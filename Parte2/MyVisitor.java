import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;

public class MyVisitor extends MiniBParserBaseVisitor<Object> {

    TablaSimbolos tablaSimbolos = new TablaSimbolos();
    Integer cont_if = 0;
    Integer cont_for = 0;
    Integer cont_while = 0;
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
    public String visitPrintStatement(MiniBParser.PrintStatementContext ctx){
        String instrucciones = "\n    getstatic java/lang/System/out Ljava/io/PrintStream;\n";

        evaluar(ctx.expression(0));

        if(is_identifier){
            is_identifier = false;
            // Si la expresion es Integer llama a la funcion correspondiente para imprimir enteros
            instrucciones += evaluar(ctx.expression(0));
            instrucciones += "\n    invokevirtual java/io/PrintStream/println(I)V\n";

        } else if(evaluar(ctx.expression(0)) instanceof String){
            instrucciones += "    ldc ";
            // Si la expresion es String llama a la funcion y lo evalua entre comillas
            instrucciones += "\"" + evaluar(ctx.expression(0)) + "\"";
            instrucciones += "\n    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";

        } else if (evaluar(ctx.expression(0)) instanceof Integer) {
            instrucciones += "    ldc ";
            // Si la expresion es Integer llama a la funcion correspondiente para imprimir enteros
            instrucciones += evaluar(ctx.expression(0));
            instrucciones += "\n    invokevirtual java/io/PrintStream/println(I)V\n";
        }

        return instrucciones;
    }

    @Override
    public Object visitExpression(MiniBParser.ExpressionContext ctx) {

        if(is_identifier){
            String  resultado = "";

            // Generar código para el primer término
            resultado += ctx.term(0).accept(this);

            // Si hay más términos, procesarlos con sus operadores
            for (int i = 1; i < ctx.term().size(); i++) {
                // Generar código para el siguiente término
                resultado += ctx.term(i).accept(this);

                // Obtener el operador entre los términos
                String operador = ctx.getChild(2 * i - 1).getText(); // PLUS o MINUS

                // Generar la instrucción correspondiente al operador
                if (operador.equals("+")) {
                    resultado += "    iadd\n"; // Suma
                } else if (operador.equals("-")) {
                    resultado += "    isub\n"; // Resta
                }
            }

            is_identifier = false;

            return resultado;
        } else {
            if (ctx.term().size() == 1 && ctx.term().size() == 1) {
                // Si la expresión tiene un solo término, se evalúa directamente
                return evaluar(ctx.term(0));
            }

            // Procesa operaciones entre términos
            Object resultado = evaluar(ctx.term(0));
            for (int i = 1; i < ctx.term().size(); i++) {
                Object siguiente = evaluar(ctx.term(i));
                String operador = ctx.getChild(2 * i - 1).getText(); // PLUS o MINUS

                if (operador.equals("+")) {
                    if (resultado instanceof Integer && siguiente instanceof Integer) {
                        resultado = (Integer) resultado + (Integer) siguiente;
                    } else if (resultado instanceof String || siguiente instanceof String) {
                        resultado = resultado.toString() + siguiente.toString();
                    }
                } else if (operador.equals("-")) {
                    if (resultado instanceof Integer && siguiente instanceof Integer) {
                        resultado = (Integer) resultado - (Integer) siguiente;
                    } else {
                        throw new RuntimeException("Operación no válida para el operador '-'");
                    }
                }
            }
            return resultado;
        }
    }

    @Override
    public Object visitTerm(MiniBParser.TermContext ctx) {
        if(is_identifier){
            String resultado = "";


            // Generar código para el primer factor
            resultado += ctx.factor(0).accept(this);

            // Si hay más factores, procesarlos con sus operadores
            for (int i = 1; i < ctx.factor().size(); i++) {
                // Generar código para el siguiente factor
                resultado += ctx.factor(i).accept(this);

                // Obtener el operador entre los factores
                String operador = ctx.getChild(2 * i - 1).getText(); // MULT, DIV o MOD

                // Generar la instrucción correspondiente al operador
                switch (operador) {
                    case "*":
                        resultado += "    imul\n";
                        break;
                    case "/":
                        resultado += "    idiv\n";
                        break;
                    case "%":
                    case "MOD":
                        resultado += "    irem\n";
                        break;
                }
            }
            return resultado;

        } else {
            if (ctx.factor().size() == 1) {
                // Si el término tiene un solo factor, evalúalo directamente
                return evaluar(ctx.factor(0));
            }

            Object resultado = evaluar(ctx.factor(0));
            for (int i = 1; i < ctx.factor().size(); i++) {
                Object siguiente = evaluar(ctx.factor(i));
                String operador = ctx.getChild(2 * i - 1).getText().toUpperCase(); // MULT, DIV, MOD

                if (operador.equals("*")) {
                    resultado = (Integer) resultado * (Integer) siguiente;
                } else if (operador.equals("/")) {
                    resultado = (Integer) resultado / (Integer) siguiente;
                } else if (operador.equals("%") || operador.equals("MOD")) {
                    resultado = (Integer) resultado % (Integer) siguiente;
                }
            }
            return resultado;
        }
    }

    @Override
    public Object visitNumb(MiniBParser.NumbContext ctx) {
        if(is_identifier)
            return "    ldc " + Integer.parseInt((ctx.NUMBER().getText())) + "\n";
        return Integer.parseInt((ctx.NUMBER().getText()));
    }

    @Override
    public Object visitFlotante(MiniBParser.FlotanteContext ctx) {
        return Float.valueOf(ctx.FLOAT().getText());
    }

    @Override
    public Object visitIdent(MiniBParser.IdentContext ctx) {
        String nombre = ctx.IDENTIFIER().getText();
        Simbolo simbolo = tablaSimbolos.buscarSimbolo(nombre);
        if (simbolo == null) {
            throw new RuntimeException("Variable no declarada: " + nombre);
        }
        is_identifier = true;
        return "    " + simbolo.cargarEnPila().replace("\"","") + "\n";
    }

    @Override
    public Object visitParent(MiniBParser.ParentContext ctx) {
        return super.visitParent(ctx);
    }

    @Override
    public Object visitCadena(MiniBParser.CadenaContext ctx) {
        return ctx.STRING().getText().replace("\"", "");
    }

    @Override
    public Object visitCar(MiniBParser.CarContext ctx){
        return ctx.CHAR().getText();
    }

    @Override
    public Object visitBool(MiniBParser.BoolContext ctx){
        if(ctx.boolean_().FALSE() != null)
            return 0;
        else
            return 1;
    }

    @Override
    public Object visitVal(MiniBParser.ValContext ctx) {
        String str_aux = (String) evaluar(ctx.valFunc().expression());
        try {
            Integer.parseInt(str_aux);
            return str_aux;
        } catch (NumberFormatException e){
            return 0;
        }
    }

    @Override
    public Object visitLen(MiniBParser.LenContext ctx) {
        String aux = (String) evaluar(ctx.lenFunc().expression());
        return String.valueOf(aux.length());
    }

    @Override
    public Object visitIsnan(MiniBParser.IsnanContext ctx) {
        String aux = (String) evaluar(ctx.isNanFunc().expression());
        return aux.equals("NaN") ? "true" : "false";
    }

    @Override
    public Object visitCopy(MiniBParser.CopyContext ctx) {
        return visitExpression(ctx.copyFunct().expression());
    }

    @Override
    public Object visitConcat(MiniBParser.ConcatContext ctx){
        String aux = "";
        for(int i=0; i<ctx.concatFunc().expression().size(); i++){
            aux += visitExpression(ctx.concatFunc().expression(i)).toString();
        }
        return aux;
    }

    @Override
    public Object visitSubStr(MiniBParser.SubStrContext ctx) {
        String aux = (String) evaluar(ctx.subStringFunc().expression(0));
        Integer start = (Integer) evaluar(ctx.subStringFunc().expression(1));
        Integer size = (Integer) evaluar(ctx.subStringFunc().expression(2));

        return aux.substring(start, start + size);
    }

    @Override
    public Object visitCharAt(MiniBParser.CharAtContext ctx){
        String aux = (String) evaluar(ctx.charAtFunct().expression(0));
        int index = (Integer) evaluar(ctx.charAtFunct().expression(1));
        return aux.charAt(index);
    }

    @Override
    public Object visitArrayLit(MiniBParser.ArrayLitContext ctx){
        //Obtiene el tipo de la primer expresion
        Object tipo = visitExpression(ctx.arrayLiteral().expression(0));

        // Segun el tipo que sea crea el arreglo de ese tipo de objeto y lo devuelve
        if(tipo instanceof Integer) {
            ArrayList<Integer> arreglo = new ArrayList<>();
            for(int i=0; i<ctx.arrayLiteral().expression().size(); i++){
                arreglo.add((Integer)visitExpression(ctx.arrayLiteral().expression(i)));
            }
            return arreglo;
        }
        else if (tipo instanceof Float) {
            ArrayList<Float> arreglo = new ArrayList<>();
            for(int i=0; i<ctx.arrayLiteral().expression().size(); i++){
                arreglo.add((Float) visitExpression(ctx.arrayLiteral().expression(i)));
            }
            return arreglo;
        }
        else if (tipo instanceof Character) {
            ArrayList<Character> arreglo = new ArrayList<>();
            for(int i=0; i<ctx.arrayLiteral().expression().size(); i++){
                arreglo.add((Character) visitExpression(ctx.arrayLiteral().expression(i)));
            }
            return arreglo;
        }
        else { //String como opcion por defecto
            ArrayList<String> arreglo = new ArrayList<>();
            for(int i=0; i<ctx.arrayLiteral().expression().size(); i++){
                arreglo.add((String) visitExpression(ctx.arrayLiteral().expression(i)));
            }
            return arreglo;
        }
    }

    // **********************************************************************************
    // Primero implementar manejo de arrays en tabla de simbolos para acceder al indice
    // **********************************************************************************
    @Override
    public Object visitArrayAcc(MiniBParser.ArrayAccContext ctx){
        return "";
    }
    // **********************************************************************************


    @Override
    public String visitLetStatement(MiniBParser.LetStatementContext ctx){
        String resultado = "";

        // Obtener el identificador y la expresión
        String nombre = ctx.IDENTIFIER().getText();


        if(tablaSimbolos.buscarSimbolo(nombre) == null){ // Se esta asignando una variable nueva
            is_identifier = true;
            Object valor = visitExpression(ctx.expression());

            // Determinar el tipo del valor
            String tipo;
            if (valor instanceof Integer) {
                tipo = "Integer";
            } else if (valor instanceof String) {
                tipo = "String";
            } else if (valor instanceof Integer) {
                tipo = "Integer";
            } else {
                throw new RuntimeException("Tipo desconocido para la variable: " + nombre);
            }

            Simbolo variable = new Simbolo(nombre, tipo, valor);

            // IF auxiliar para no tener que modificar visitTerm y visitPrin
            if (tipo == "String")
                valor = "\"" + valor + "\"";

            // Guardar o actualizar el valor en la tabla de símbolos
            tablaSimbolos.agregarSimbolo(nombre, variable);
            resultado += "    ldc " + valor + "\n"
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
        String etiquetaElse = "ELSE_BLOCK_" + cont_if;
        String etiquetaFin = "END_BLOCK_" + cont_if;
        cont_if++;

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
                instrucciones += "    " + visitExpression(ctx.expression(0)) + "\n";
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
            instrucciones.append("    goto LOOP_END_").append(cont_for).append("\n");
        }
        return instrucciones.toString();
    }

    @Override
    public Object visitForStatement(MiniBParser.ForStatementContext ctx) {
        String resultado = "   ; Inicializar las variables locales: \n";

        Integer limite = (Integer) evaluar(ctx.expression(1));

        tablaSimbolos.agregarSimbolo(ctx.IDENTIFIER().getText(), "Integer", evaluar(ctx.expression(0)));
        Simbolo indice = tablaSimbolos.buscarSimbolo(ctx.IDENTIFIER().getText());

        Integer indice_valor = (Integer) indice.getValor();
        String indice_registro = indice.asignar();


        resultado += "    ldc " + indice_valor + "        ; Cargar el valor inicial\n"
                  + "    " + indice_registro + "          ; Guardar en la variable local 1\n\n";

        resultado += "    ldc " + limite + "        ; Cargar el valor final\n"
                  +  "    istore_2      ; Guardar en la variable local 2\n\n";

        resultado += "LOOP_START_" + cont_for + ":\n"
                  +  "    " + indice.cargarEnPila() + "       ; Cargar i\n"
                  +  "    iload_2       ; Cargar end\n"
                  +  "    if_icmpgt LOOP_END_" + cont_for + "\n\n"
                  +  "    ; Cuerpo del bucle \n";

        // Se evalua el bloque de control.
        resultado += visitBloqueControl(ctx.bloqueControl());

        resultado += "INCREMENTAR: "
                  +  "\n    ; Incrementar i: 1 = 1 + i \n"
                  +  "    " + indice.cargarEnPila() + "           ; Cargar i\n"
                  +  "    iconst_1      ; Cargar el incremento \n"
                  +  "    iadd          ; Sumar i + 1\n"
                  +  "    " + indice_registro + "          ; Guardar el nuevo valor de i\n\n"
                  +  "    goto LOOP_START_" + cont_for + "\n"
                  +  "    LOOP_END_" + cont_for + ":\n";

        cont_for++;

        return resultado;
    }

    @Override
    public Object visitWhileStatement(MiniBParser.WhileStatementContext ctx) {
        String resultado = "WHILE_START_" + cont_while + ":\n";

        resultado += visitCondition(ctx.condition()) + " WHILE_END_" + cont_while + "\n";
        resultado += visitBloqueControl(ctx.bloqueControl());
        resultado += "    goto WHILE_START_" + cont_while + "\n"
                  +  "WHILE_END_" + cont_while + ": \n";

        cont_while++;
        return resultado;
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
    public Object visitInputStatement(MiniBParser.InputStatementContext ctx) {
        String nombre = ctx.IDENTIFIER().getText();
        String valor = ctx.STRING().getText();
        Simbolo nuevo = new Simbolo(nombre, "String", valor);

        tablaSimbolos.agregarSimbolo(nombre, nuevo);

        is_identifier = true;

        return  "    ldc " + valor + "\n"
                + "    " + nuevo.asignar() + "\n";
    }
}
