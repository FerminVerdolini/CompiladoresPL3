import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MyVisitor extends MiniBParserBaseVisitor<Object> {

    TablaSimbolos tablaSimbolos = new TablaSimbolos();
    Integer contador_if = 0;

    /*
    String instrucciones = ".class public IfExample\n" +
            ".super java/lang/Object\n" +
            "\n" +
            ".method public static main([Ljava/lang/String;)V\n" +
            "    .limit stack 10\n" +
            "    .limit locals 10\n\n";
*/

    private Object evaluar(ParseTree tree) {
        return tree.accept(this);
    }

    @Override
    public Object visitPrograma(MiniBParser.ProgramaContext ctx) {
        String instrucciones = ".class public IfExample\n" +
                ".super java/lang/Object\n" +
                "\n" +
                ".method public static main([Ljava/lang/String;)V\n" +
                "    .limit stack 10\n" +
                "    .limit locals 10\n\n";

        instrucciones += visitChildren(ctx);

        return instrucciones;
    }

    @Override
    public String visitPrintStatement(MiniBParser.PrintStatementContext ctx){
        String instrucciones = "    ldc ";

        // Procesar la expresión principal
        instrucciones += evaluar(ctx.expression(0)).toString();

        //instrucciones += "\n    getstatic java/lang/System/out Ljava/io/PrintStream;\n";
        instrucciones += "\n    getstatic java/lang/System/out Ljava/io/PrintStream;"
                       + "\n    invokevirtual java/io/PrintStream/println(I)V\n";

        return instrucciones;
    }

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

        // Generar etiquetas únicas
        String etiquetaElse = "ELSE_BLOCK_" + contador_if;
        String etiquetaFin = "END_BLOCK_" + contador_if;
        contador_if++;

        // Evaluar la condición
        String instrucciones = visitCondition(ctx.condition()) + etiquetaElse;

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

        String exp1 = "    ldc " + visitExpression(ctx.expression(0)) + "\n";
        String exp2 = "    ldc " + visitExpression(ctx.expression(1)) + "\n";

        String instrucciones = exp1 + exp2;

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

        return instrucciones;
    }

    @Override
    public String visitBloqueControl(MiniBParser.BloqueControlContext ctx) {
        StringBuilder instrucciones = new StringBuilder();
        for (MiniBParser.StatementContext statement : ctx.statement()) {
            instrucciones.append(statement.accept(this));
        }
        return instrucciones.toString();
    }


}
