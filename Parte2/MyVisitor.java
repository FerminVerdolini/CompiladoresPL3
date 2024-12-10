import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MyVisitor extends MiniBParserBaseVisitor<Object> {

    TablaSimbolos tablaSimbolos = new TablaSimbolos();

    private Object evaluar(ParseTree tree) {
        return tree.accept(this);
    }

    @Override
    public String visitPrintStatement(MiniBParser.PrintStatementContext ctx){
        System.out.println("Entrando en visitPrintStatement");

        String resultado = "ldc ";

        // Procesar la expresión principal
        resultado += evaluar(ctx.expression(0)).toString();

        System.out.println("Saliendo de visitPrintStatement");

        return resultado;
    }

    @Override
    public String visitExpression(MiniBParser.ExpressionContext ctx) {
        String instrucciones = "";

        // Procesamos la primera parte de la expresión
        instrucciones += visitTerm(ctx.term(0));

        // Si hay más términos, procesamos las operaciones entre ellos
        for (int i = 1; i < ctx.term().size(); i++) {
            instrucciones += visitTerm(ctx.term(i));
            String operador = ctx.getChild(2 * i - 1).getText();  // + o -

            if (operador.equals("+")) {
                instrucciones += "    iadd\n";  // Jasmin para suma
            } else if (operador.equals("-")) {
                instrucciones += "    isub\n";  // Jasmin para resta
            }
        }
        return instrucciones;
    }

    @Override
    public String visitTerm(MiniBParser.TermContext ctx) {
        String instrucciones = "";

        for (MiniBParser.FactorContext factor : ctx.factor()) {
            instrucciones += visitFactor(factor);
        }

        return instrucciones;
    }

    @Override
    public String visitFactor(MiniBParser.FactorContext ctx) {
        String instrucciones = "";

        if (ctx.NUMBER() != null) {
            instrucciones += "    ldc " + ctx.NUMBER().getText() + "\n";  // Para un número
        } else if (ctx.IDENTIFIER() != null) {
            instrucciones += "    aload " + ctx.IDENTIFIER().getText() + "\n";  // Para una variable
        } else if (ctx.STRING() != null) {
            instrucciones += "    ldc " + ctx.STRING().getText() + "\n";  // Para una cadena
        }

        return instrucciones;
    }


    /*
    @Override
    public Object visitExpression(MiniBParser.ExpressionContext ctx) {
        if (ctx.term().size() == 1) {
            // Si la expresión tiene un solo término, evalúalo directamente
            return evaluar(ctx.term(0));
        }

        // Procesa operaciones entre términos
        Object resultado = evaluar(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            Object siguiente = evaluar(ctx.term(i));
            String operador = ctx.getChild(2 * i - 1).getText(); // PLUS o MINUS

            if (operador.equals("+")) {
                if (resultado instanceof Double && siguiente instanceof Double) {
                    resultado = (Double) resultado + (Double) siguiente;
                } else if (resultado instanceof String || siguiente instanceof String) {
                    resultado = resultado.toString() + siguiente.toString();
                }
            } else if (operador.equals("-")) {
                if (resultado instanceof Double && siguiente instanceof Double) {
                    resultado = (Double) resultado - (Double) siguiente;
                } else {
                    throw new RuntimeException("Operación no válida para el operador '-'");
                }
            }
        }
        return resultado;
    }

    @Override
    public Object visitTerm(MiniBParser.TermContext ctx) {
        if (ctx.factor().size() == 1) {
            // Si el término tiene un solo factor, evalúalo directamente
            return evaluar(ctx.factor(0));
        }

        Object resultado = evaluar(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            Object siguiente = evaluar(ctx.factor(i));
            String operador = ctx.getChild(2 * i - 1).getText(); // MULT, DIV, MOD

            if (operador.equals("*")) {
                resultado = (Double) resultado * (Double) siguiente;
            } else if (operador.equals("/")) {
                resultado = (Double) resultado / (Double) siguiente;
            } else if (operador.equals("%")) {
                resultado = (Double) resultado % (Double) siguiente;
            }
        }
        return resultado;
    }

    @Override
    public Object visitFactor(MiniBParser.FactorContext ctx) {
        if (ctx.NUMBER() != null) {
            // Procesa números
            return Double.parseDouble(ctx.NUMBER().getText());
        } else if (ctx.IDENTIFIER() != null) {
            // Procesa identificadores
            String nombre = ctx.IDENTIFIER().getText();
            Simbolo simbolo = tablaSimbolos.buscarSimbolo(nombre);
            if (simbolo == null) {
                throw new RuntimeException("Variable no declarada: " + nombre);
            }
            return simbolo.getValor();
        } else if (ctx.STRING() != null) {
            // Procesa cadenas
            return ctx.STRING().getText().replace("\"", ""); // Elimina las comillas
        } else if (ctx.expression() != null) {
            // Procesa subexpresiones
            return evaluar(ctx.expression());
        }
        return null;
    }

    */
    @Override
    public String visitLetStatement(MiniBParser.LetStatementContext ctx){
        // Obtener el identificador y la expresión
        String nombre = ctx.IDENTIFIER().getText();

        // CORREGIR
        Object valor = visitExpression(ctx.expression());

        System.out.println(valor);

        // Determinar el tipo del valor
        String tipo;
        if (valor instanceof Double) {
            tipo = "Double";
        } else if (valor instanceof String) {
            tipo = "String";
        } else if (valor instanceof Integer){
            tipo = "Integer";
        } else {
            throw new RuntimeException("Tipo desconocido para la variable: " + nombre);
        }

        // Guardar o actualizar el valor en la tabla de símbolos
        tablaSimbolos.agregarSimbolo(nombre, tipo, valor);
        tablaSimbolos.imprimirTabla();

        return null; // No devuelve nada, ya que es una declaración
    }

    @Override
    public String visitIfStatement(MiniBParser.IfStatementContext ctx) {
        // Evaluar la condición (esto generará el código para la comparación)
        String instrucciones = (String) visitCondition(ctx.condition());

        // Instrucciones para el bloque THEN (cuando la condición es verdadera)
        instrucciones += "    ldc \"true\"\n";
        instrucciones += "    getstatic java/lang/System/out Ljava/io/PrintStream;\n";
        instrucciones += "    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";

        // Etiqueta de salto para el bloque ELSE
        String etiquetaElse = "ELSE_BLOCK" + System.currentTimeMillis();
        instrucciones += "    goto " + etiquetaElse + "\n";  // Salta al bloque ELSE si la condición es falsa

        // Bloque ELSE
        instrucciones += etiquetaElse + ":\n";
        instrucciones += "    ldc \"false\"\n";
        instrucciones += "    getstatic java/lang/System/out Ljava/io/PrintStream;\n";
        instrucciones += "    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";

        return instrucciones;
    }
    @Override
    public String visitCondition(MiniBParser.ConditionContext ctx) {
        // Evaluar la expresión izquierda
        String izquierda = visitExpression(ctx.expression(0));

        // Evaluar la expresión derecha
        String derecha = visitExpression(ctx.expression(1));

        // Obtener el operador de comparación
        String operador = ctx.getChild(1).getText();  // LT, LTE, etc.

        // Generar el código Jasmin para la comparación
        String instrucciones = izquierda + "\n" + derecha + "\n";

        switch (operador) {
            case "<":
                instrucciones += "    if_icmplt ";
                break;
            case "<=":
                instrucciones += "    if_icmple ";
                break;
            case ">":
                instrucciones += "    if_icmpgt ";
                break;
            case ">=":
                instrucciones += "    if_icmpge ";
                break;
            case "==":
                instrucciones += "    if_icmpeq ";
                break;
            case "!=":
                instrucciones += "    if_icmpne ";
                break;
            default:
                throw new RuntimeException("Operador desconocido: " + operador);
        }

        // Etiqueta de salto para la instrucción condicional
        instrucciones += "ELSE_BLOCK" + System.currentTimeMillis() + "\n";

        return instrucciones;
    }




/*    @Override
    public Object visitCondition(MiniBParser.ConditionContext ctx) {
        // Evaluar la primera expresión
        Object izquierda = visitExpression(ctx.expression(0));

        // Si no hay operador de comparación, la condición es solo una expresión booleana
        if (ctx.expression(1) == null) {
            return izquierda instanceof Boolean ? (Boolean) izquierda : Boolean.parseBoolean(izquierda.toString());
        }

        // Evaluar la segunda expresión
        Object derecha = visitExpression(ctx.expression(1));

        // Evaluar el operador de comparación
        String operador = ctx.getChild(1).getText(); // LT, LTE, GT, etc.
        switch (operador) {
            case "<": return (Double) izquierda < (Double) derecha;
            case "<=": return (Double) izquierda <= (Double) derecha;
            case ">": return (Double) izquierda > (Double) derecha;
            case ">=": return (Double) izquierda >= (Double) derecha;
            case "==": return izquierda.equals(derecha);
            case "!=": return !izquierda.equals(derecha);
            default: throw new RuntimeException("Operador desconocido: " + operador);
        }

    }
*/
    @Override
    public String visitBloqueControl(MiniBParser.BloqueControlContext ctx) {
        StringBuilder instrucciones = new StringBuilder();

        for (MiniBParser.StatementContext statement : ctx.statement()) {
            // Visitar cada statement y concatenar sus instrucciones
            instrucciones.append(statement.accept(this)).append("\n");
        }

        return instrucciones.toString();
    }



}
