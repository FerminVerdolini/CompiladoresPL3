import org.antlr.v4.runtime.tree.*;

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
            if (ctx.term().size() == 1) {
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
    public Object visitFactor(MiniBParser.FactorContext ctx) {
        String resultado = "";
        if (ctx.NUMBER() != null) {
            // Procesa números
            if(is_identifier)
                resultado = "   ldc " + Integer.parseInt((ctx.NUMBER().getText())) + "\n"
                          +  (Integer.parseInt((ctx.NUMBER().getText())));
        } else if (ctx.IDENTIFIER() != null) {
            // Procesa identificadores
            String nombre = ctx.IDENTIFIER().getText();
            Simbolo simbolo = tablaSimbolos.buscarSimbolo(nombre);
            if (simbolo == null) {
                throw new RuntimeException("Variable no declarada: " + nombre);
            }
            is_identifier = true;
            resultado = "    " + simbolo.cargarEnPila().replace("\"","") + "\n";
        } else if (ctx.STRING() != null) {
            String str_aux = ctx.STRING().getText().replace("\"", "");
            if(is_val){
                try {
                    Integer int_aux = Integer.parseInt(str_aux);
                    resultado = str_aux;
                } catch (NumberFormatException e){
                    resultado = "NaN";
                }
            }else {
                resultado = str_aux;
            }
        } else if(ctx.VAL() != null){
            is_val = true;
            resultado = (String) evaluar(ctx.expression());
        } else if (ctx.LEN() != null){
            String aux = (String) evaluar(ctx.expression());
            resultado = String.valueOf(aux.length());
        } else if (ctx.ISNAN() != null) {
            String aux = (String) evaluar(ctx.expression());
            resultado = aux.equals("NaN") ? "true" : "false";
        }
        is_val = false;
        return resultado;
    }

    @Override
    public String visitLetStatement(MiniBParser.LetStatementContext ctx){
        String resultado = "";

        // Obtener el identificador y la expresión
        String nombre = ctx.IDENTIFIER().getText();

        if(tablaSimbolos.buscarSimbolo(nombre) == null){ // Se esta asignando una variable nueva
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

        if(ctx.expression().size() == 1) {
            // Evalua la expresion de una sola expresion (0, != 0 o Boolean)
            instrucciones += "    ldc " + visitExpression(ctx.expression(0)) + "\n";
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


}
