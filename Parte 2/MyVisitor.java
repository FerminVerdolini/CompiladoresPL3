import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MyVisitor extends MiniBParserBaseVisitor<Object> {

    TablaSimbolos tablaSimbolos = new TablaSimbolos();

    private Object evaluar(ParseTree tree) {
        return tree.accept(this);
    }

    @Override
    public String visitPrintStatement(MiniBParser.PrintStatementContext ctx){
        return "lcd " + ctx.exp.getText();
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

}
