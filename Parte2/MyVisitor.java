import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import enums.ExpOperations;
import enums.FinalFactors;
import enums.TermOperations;
import org.antlr.v4.runtime.tree.*;

import javax.print.DocFlavor;

public class MyVisitor extends MiniBParserBaseVisitor<Object> {

    TablaSimbolos tablaSimbolos = new TablaSimbolos();
    Integer contador_if = 0;
    Integer contador_for = 0;
    Integer contador_while = 0;
    Integer cont_repeat = 0;

    String file_name;
    Boolean is_identifier = false;
    Boolean is_val = false;

    public MyVisitor(String file_name) {
        this.file_name = file_name;
    }

    private Object evaluar(ParseTree tree) {
        return tree.accept(this);
    }

    @Override
    public Object visitPrograma(MiniBParser.ProgramaContext ctx) {
        String instrucciones = ".class public " + file_name + "\n" +
                ".super java/lang/Object\n" +
                "\n" +
                ".method public static main([Ljava/lang/String;)V\n" +
                "    .limit stack 100\n" +
                "    .limit locals 100\n\n";

        for(int i=0; i<ctx.statement().size(); i++){
            instrucciones += visitChildren(ctx.statement(i));
        }
        return instrucciones;
    }

    @Override
    public String visitPrintStatement(MiniBParser.PrintStatementContext ctx) {
        String instrucciones = "\n    getstatic java/lang/System/out Ljava/io/PrintStream;\n";
        MyExpression exp = ((MyExpression) visit(ctx.expression()));
        if (exp.getHadIdentifier()) {

        } else {
            Object resultado = exp.evaluar();
            instrucciones += "    ldc ";
            switch (exp.type) {
                case NUMBER:
                    instrucciones += resultado;
                    instrucciones += "\n    invokevirtual java/io/PrintStream/println(I)V\n";
                    break;
                case FLOAT:
                    instrucciones += resultado;
                    instrucciones += "\n    invokevirtual java/io/PrintStream/println(F)V\n";
                    break;
                case CHAR:
                    instrucciones += resultado;
                    instrucciones += "\n    invokevirtual java/io/PrintStream/println(C)V\n";
                    break;
                case STRING:
                    instrucciones += "\"" + resultado + "\"";
                    instrucciones += "\n    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
                    break;
                case BOOLEAN:
                    instrucciones += "\"" + resultado.toString() + "\"";
                    instrucciones += "\n    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
                    break;
                //TODO ver c omo imprimir los arrays

            }
        }
        return instrucciones;
    }

    @Override
    public String visitLetStatement(MiniBParser.LetStatementContext ctx){
        String resultado = "";

        // Obtener el identificador y la expresión
        String nombre = ctx.IDENTIFIER().getText();

        if(tablaSimbolos.buscarSimbolo(nombre) == null){ // Se esta asignando una variable nueva
            MyExpression valor = visitExpression(ctx.expression());
            // Determinar el tipo del valor
            FinalFactors tipoenum = valor.getType();
            Simbolo variable = new Simbolo(nombre, tipoenum, valor.evaluar());
            // Guardar o actualizar el valor en la tabla de símbolos
            tablaSimbolos.agregarSimbolo(nombre, variable);
            resultado += "    ldc " + variable.getValor() + "\n"
                    +  "    " + variable.asignar() + "\n\n";
        } else {
            is_identifier = true;
            Simbolo variable = tablaSimbolos.buscarSimbolo(nombre);
            resultado += visitExpression(ctx.expression());
            resultado += variable.asignar() + "\n";
        }
        return resultado; // No devuelve nada, ya que es una declaración
    }
    

    @Override
    public String visitIfStatement(MiniBParser.IfStatementContext ctx) {

        // Generar etiquetas únicas
        String etiquetaElse = "ELSE_BLOCK_" + contador_if;
        String etiquetaFin = "END_BLOCK_" + contador_if;
        contador_if++;

        // Evaluar la condición
        String instrucciones = visitCondition(ctx.condition()) + etiquetaElse;

        if(ctx.condition().children.contains(ctx.condition().logicalOp())){
            instrucciones += "\n" + visitCondition(ctx.condition().condition()) + etiquetaElse;
        }

        // Bloque THEN
        instrucciones += "    ; Bloque THEN\n";
        instrucciones += visitBloqueControl(ctx.bloqueControl(0));
        instrucciones += "    goto " + etiquetaFin + "\n";  // Saltar al final del bloque


        // Bloque ELSE
        instrucciones += etiquetaElse + ":\n";
        if (ctx.bloqueControl(1) != null) {
            instrucciones += "    ; Bloque ELSE\n";
            instrucciones += visitBloqueControl(ctx.bloqueControl(1));
        }

        // Etiqueta de fin
        instrucciones += etiquetaFin + ":\n";

        return instrucciones;
    }

    @Override
    public String visitCondition(MiniBParser.ConditionContext ctx){

        String instrucciones = "";
        String exp1;
        String exp2;

        // Evaluo para levantar flag
        evaluar(ctx.expression(0));

        if(ctx.expression().size() == 1) {
            // Evalua la expresion de una sola expresion (0, != 0 o Boolean)
            if(is_identifier){
                instrucciones += "    " + visitExpression(ctx.expression(0)).evaluar() + "\n";
            } else{
                instrucciones += "    ldc " + visitExpression(ctx.expression(0)) + "\n";
            }
            instrucciones += "    ifeq ";
        } else if (ctx.expression().size() == 2) {
            // Evalua la comparacion de dos expresiones

            visitExpression(ctx.expression(0));
            if(is_identifier){
                exp1 = "    " + visitExpression(ctx.expression(0)) + "\n";
                is_identifier = false;
            } else {
                exp1 = "    ldc " + visitExpression(ctx.expression(0)) + "\n";
            }

            visitExpression(ctx.expression(1));
            if(is_identifier){
                exp2 = "    " + visitExpression(ctx.expression(1)) + "\n";
                is_identifier = false;
            } else {
                exp2 = "    ldc " + visitExpression(ctx.expression(1)) + "\n";
            }

            instrucciones += exp2 + exp1;

            String operador = ctx.getChild(1).getText();

            switch (operador) {
                case "<":
                    instrucciones += "    if_icmplt "; break;
                case "<=":
                    instrucciones += "    if_icmple "; break;
                case ">":
                    instrucciones += "    if_icmpgt "; break;
                case ">=":
                    instrucciones += "    if_icmpge "; break;
                case "==":
                    instrucciones += "    if_icmpeq "; break;
                case "!=":
                    instrucciones += "    if_icmpne "; break;
                default:
                    throw new RuntimeException("Operador desconocido: " + operador);
            }
        }

        return instrucciones;
    }

    @Override
    public String visitBloqueControl(MiniBParser.BloqueControlContext ctx) {
        StringBuilder instrucciones = new StringBuilder();
        for (MiniBParser.StatementContext statement : ctx.statement()) {
            instrucciones.append(statement.accept(this));
        }
        if(ctx.CONTINUE() != null)
            instrucciones.append("    goto INCREMENTAR\n");

        if(ctx.EXIT() != null){
            instrucciones.append("    goto LOOP_END_").append(contador_for).append("\n");
        }
        return instrucciones.toString();
    }

    @Override
    public Object visitForStatement(MiniBParser.ForStatementContext ctx) {
        String resultado = "   ; Inicializar las variables locales: \n";

        MyExpression lim = (MyExpression) evaluar(ctx.expression(1));
        Integer limite = (Integer) lim.evaluar();
        
        tablaSimbolos.agregarSimbolo(ctx.IDENTIFIER().getText(), FinalFactors.NUMBER, evaluar(ctx.expression(0)));
        Simbolo indice = tablaSimbolos.buscarSimbolo(ctx.IDENTIFIER().getText());

        MyExpression aux = (MyExpression) indice.getValor();
        Integer indice_valor = (Integer) aux.evaluar();
        String indice_registro = indice.asignar();


        resultado += "    ldc " + indice_valor + "        ; Cargar el valor inicial\n"
                  + "    " + indice_registro + "          ; Guardar en la variable local 1\n\n";

        resultado += "    ldc " + limite + "        ; Cargar el valor final\n"
                  +  "    istore_2      ; Guardar en la variable local 2\n\n";

        resultado += "LOOP_START_" + contador_for + ":\n"
                  +  "    " + indice.cargarEnPila() + "       ; Cargar i\n"
                  +  "    iload_2       ; Cargar end\n"
                  +  "    if_icmpgt LOOP_END_" + contador_for + "\n\n"
                  +  "    ; Cuerpo del bucle \n";

        // Se evalua el bloque de control.
        resultado += visitBloqueControl(ctx.bloqueControl());

        resultado += "INCREMENTAR: "
                  +  "\n    ; Incrementar i: 1 = 1 + i \n"
                  +  "    " + indice.cargarEnPila() + "           ; Cargar i\n"
                  +  "    iconst_1      ; Cargar el incremento \n"
                  +  "    iadd          ; Sumar i + 1\n"
                  +  "    " + indice_registro + "          ; Guardar el nuevo valor de i\n\n"
                  +  "    goto LOOP_START_" + contador_for + "\n"
                  +  "    LOOP_END_" + contador_for + ":\n";

        contador_for++;

        return resultado;
    }

    @Override
    public Object visitWhileStatement(MiniBParser.WhileStatementContext ctx) {
        String resultado = "WHILE_START_" + contador_while + ":\n";

        resultado += visitCondition(ctx.condition()) + " WHILE_END_" + contador_while + "\n";
        resultado += visitBloqueControl(ctx.bloqueControl());
        resultado += "    goto WHILE_START_" + contador_while + "\n"
                  +  "WHILE_END_" + contador_while + ": \n";

        contador_while++;
        return resultado;
    }

    @Override
    public MyExpression visitExpression(MiniBParser.ExpressionContext ctx) {
        List<MyTerm> terms = new ArrayList<>();
        List<ExpOperations> operations = new ArrayList<>();
        FinalFactors type = FinalFactors.NULL;
        Boolean hadIdentifier = false;

        MyTerm term;
        for (int i = 0; i < ctx.term().size(); i++){
            term = (MyTerm)visit(ctx.term(i));

            if(term.getHadIdentifier()){
                hadIdentifier=true;
            }
            //Compruebo QUE TODOS Tengan el mismo tipo
            if (i==0) {
                type = term.getType();
            }else{
                if(type != term.getType()){
                    //TODO lanzar exepcion
                }

            }
            terms.add(term);
        }

        for (int i = 0; i < ctx.expOperations().size(); i++){
            operations.add((ExpOperations)visit(ctx.expOperations(i)));
        }

        MyExpression exp = new MyExpression(terms,operations,type,hadIdentifier);
        return exp;
    }

    @Override
    public Object visitRepeatStatement(MiniBParser.RepeatStatementContext ctx) {
        String resultado = "REPEAT_START_" + cont_repeat + ":\n";

        for(int i=0; i<ctx.statement().size(); i++)
            resultado += evaluar(ctx.statement(i));

        resultado += "\n    ; UNTIL \n";
        resultado += visitCondition(ctx.condition()) + " END" + "\n"
                  +  "    goto REPEAT_START_" + cont_repeat + "\n"
                  +  "END:" + "\n";

        cont_repeat++;
        return resultado;
    }


    @Override
    public MyTerm visitTerm(MiniBParser.TermContext ctx) {
        List<MyFactor> factors = new ArrayList<>();
        List<TermOperations> operations = new ArrayList<>();
        FinalFactors type = FinalFactors.NULL;
        MyFactor fact;
        Boolean hadIdentifier = false;


        for (int i = 0; i < ctx.factor().size(); i++){
            fact = (MyFactor)visit(ctx.factor(i));
            //Compruebo QUE TODOS Tengan el mismo tipo
            if (i==0) {
                type = fact.getType();
                if(type.equals(FinalFactors.IDENTIFIER)){
                    type = tablaSimbolos.buscarSimbolo(fact.getValue().toString()).getTipo();
                    hadIdentifier = true;
                }
            }else{
                if(fact.getType().equals(FinalFactors.IDENTIFIER)){
                    if(type != tablaSimbolos.buscarSimbolo(fact.getValue().toString()).getTipo()){
                        // TODO lanzar excepcion
                    }
                    hadIdentifier = true;
                }else{
                    if(type != fact.getType()){
                        //TODO lanzar exepcion
                    }
                }
            }
            factors.add(fact);
        }

        for (int i = 0; i < ctx.factorOperations().size(); i++){
            operations.add((TermOperations)visit(ctx.factorOperations(i)));
        }

        MyTerm term = new MyTerm(factors,operations,type,hadIdentifier);
        return term;
    }

    @Override
    public MyFactor visitNumb(MiniBParser.NumbContext ctx){
        MyFactor num = new MyFactor(Integer.parseInt((ctx.NUMBER().getText())),FinalFactors.NUMBER);
        return num;        
    }
    
    
    @Override
    public MyFactor visitFlotante(MiniBParser.FlotanteContext ctx){
        MyFactor fl = new MyFactor(Float.parseFloat((ctx.FLOAT().getText())),FinalFactors.FLOAT);
        return fl;  
    }

    @Override
    public MyFactor visitIdent(MiniBParser.IdentContext ctx){
        // Procesa identificadores
        String nombre = ctx.IDENTIFIER().getText();
        Simbolo simbolo = tablaSimbolos.buscarSimbolo(nombre);
        if (simbolo == null) {
            throw new RuntimeException("Variable no declarada: " + nombre);
        }

        MyFactor id = new MyFactor(nombre,FinalFactors.IDENTIFIER);

        return id;
    }

    @Override
    public MyFactor visitCar(MiniBParser.CarContext ctx){
        MyFactor ch = new MyFactor(ctx.CHAR().getText().charAt(1),FinalFactors.CHAR);
        return ch;
    }

    @Override
    public MyFactor visitCadena(MiniBParser.CadenaContext ctx){
        MyFactor ch = new MyFactor(ctx.STRING().getText().replace("\"", ""),FinalFactors.STRING);
        return ch;
    }

    @Override
    public Object visitParent(MiniBParser.ParentContext ctx){
        return visit(ctx.expression());
    }

    @Override
    public Object visitInputStatement(MiniBParser.InputStatementContext ctx) {
        String nombre = ctx.IDENTIFIER().getText();
        String valor = ctx.STRING().getText();
        Simbolo nuevo = new Simbolo(nombre, FinalFactors.STRING, valor);

        tablaSimbolos.agregarSimbolo(nombre, nuevo);

        is_identifier = true;

        return  "    ldc " + valor + "\n"
                + "    " + nuevo.asignar() + "\n";
    }
    
    @Override
    public Object visitMult(MiniBParser.MultContext ctx){
        return TermOperations.MULT;
    }
    
    @Override
    public Object visitDiv(MiniBParser.DivContext ctx){
        return TermOperations.DIV;
    }
    @Override
    public Object visitMod(MiniBParser.ModContext ctx){
        return TermOperations.MOD;
    }
    
    @Override
    public Object visitPlus(MiniBParser.PlusContext ctx){
        return ExpOperations.PLUS;
    }
    @Override
    public Object visitMinus(MiniBParser.MinusContext ctx){
        return ExpOperations.MINUS;
    }
    
    // @Override
    // public List<MyFactor> visitTerm(MiniBParser.TermContext ctx) {
    //     Lis
    
    //     Object resultado = evaluar(ctx.factor(0));
    
    //     if (ctx.factor().size() > 1) {
        //         if(is_identifier){
    //             //TODO aca deberia llevar un registro de, en caso de haber mas de un factor, que operaciones lleva, tela...
    
    //             // String resultado = "";
    
    //             // // Generar código para el primer factor
    //             // resultado += ctx.factor(0).accept(this);
    
    //             // // Si hay más factores, procesarlos con sus operadores
    //             // for (int i = 1; i < ctx.factor().size(); i++) {
    //             //     // Generar código para el siguiente factor
    //             //     resultado += ctx.factor(i).accept(this);
    
    //             //     // Obtener el operador entre los factores
    //             //     String operador = ctx.getChild(2 * i - 1).getText(); // MULT, DIV o MOD
    
    //             //     // Generar la instrucción correspondiente al operador
    //             //     switch (operador) {
    //             //         case "*":
    //             //             resultado += "    imul\n";
    //             //             break;
    //             //         case "/":
    //             //             resultado += "    idiv\n";
    //             //             break;
    //             //         case "%":
    //             //         case "MOD":
    //             //             resultado += "    irem\n";
    //             //             break;
    //             //     }
    //             // }
    //             // return resultado;
    
    //         } else {
        //             for (int i = 1; i < ctx.factor().size(); i++) {
    //                 Object siguiente = evaluar(ctx.factor(i));
    //                 String operador = ctx.getChild(2 * i - 1).getText().toUpperCase(); // MULT, DIV, MOD
    
    //                 if (operador.equals("*")) {
        //                     resultado = (Integer) resultado * (Integer) siguiente;
    //                 } else if (operador.equals("/")) {
    //                     resultado = (Integer) resultado / (Integer) siguiente;
    //                 } else if (operador.equals("%") || operador.equals("MOD")) {
        //                     resultado = (Integer) resultado % (Integer) siguiente;
        //                 }
        //             }
        
        //             //TODO comprobar si necesito hacer algo con los char y los array aca
        //         }
        //     }
        //     return resultado;
        // }
    }

    // @Override
    // public Object visitExpression(MiniBParser.ExpressionContext ctx) {
    //     Object resultado = evaluar(ctx.term(0));
    //     if (ctx.term().size() > 1) {
    //         if(is_identifier){
    //             //TODO aca deberia llevar control de que si hay mas de un termino que opeciones se hace con este(una set??);
    //             //  String  resultado = "";

    //             // // Generar código para el primer término
    //             // resultado += ctx.term(0).accept(this);

    //             // // Si hay más términos, procesarlos con sus operadores
    //             // for (int i = 1; i < ctx.term().size(); i++) {
    //             //     // Generar código para el siguiente término
    //             //     resultado += ctx.term(i).accept(this);

    //             //     // Obtener el operador entre los términos
    //             //     String operador = ctx.getChild(2 * i - 1).getText(); // PLUS o MINUS

    //             //     // Generar la instrucción correspondiente al operador
    //             //     if (operador.equals("+")) {
    //             //         resultado += "    iadd\n"; // Suma
    //             //     } else if (operador.equals("-")) {
    //             //         resultado += "    isub\n"; // Resta
    //             //     }
    //             // }

    //             // is_identifier = false;

    //             return "resultado";
    //         } else {
    //             for (int i = 1; i < ctx.term().size(); i++) {
    //                 Object siguiente = evaluar(ctx.term(i));
    //                 String operador = ctx.getChild(2 * i - 1).getText(); // PLUS o MINUS
    
    //                 if (operador.equals("+")) {
    //                     if (resultado instanceof Integer && siguiente instanceof Integer) {
    //                         resultado = (Integer) resultado + (Integer) siguiente;
    //                     } else if (resultado instanceof String || siguiente instanceof String) {
    //                         resultado = resultado.toString() + siguiente.toString();
    //                     }
    //                 } else if (operador.equals("-")) {
    //                     if (resultado instanceof Integer && siguiente instanceof Integer) {
    //                         resultado = (Integer) resultado - (Integer) siguiente;
    //                     } else {
    //                         throw new RuntimeException("Operación no válida para el operador '-'");
    //                     }
    //                 }
    //                 //TODO comprobar si necesito hacer algo con los char y los array aca

    //             }
    //         }
    //     }
    //     return resultado;
    // }

    
    // @Override
    // public Object visitFactor(MiniBParser.FactorContext ctx) {
    //     Object factor="";
    
    //     if (ctx.NUMBER() != null) {
    //         factor = (Integer.parseInt((ctx.NUMBER().getText())));
    //     } else if (ctx.IDENTIFIER() != null) {
    //         // Procesa identificadores
    //         String nombre = ctx.IDENTIFIER().getText();
    //         Simbolo simbolo = tablaSimbolos.buscarSimbolo(nombre);
    //         if (simbolo == null) {
        //             throw new RuntimeException("Variable no declarada: " + nombre);
    //         }

    //         is_identifier = true;
    //         factor = nombre;
    
    //     } else if (ctx.STRING() != null) {
        //         factor= ctx.STRING().getText().replace("\"", "");
    //     } else if (ctx.CHAR() != null) {
    //         factor = ctx.CHAR().getText().charAt(1);
    //     } else if (ctx.expression() != null) {
        //         factor = evaluar(ctx.expression());
    //     }
    //     return factor;
    // }


