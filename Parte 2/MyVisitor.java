import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MyVisitor extends MiniBParserBaseVisitor<String> {

    TablaSimbolos tablaSimbolos = new TablaSimbolos();


    @Override
    public String visitPrintStatement(MiniBParser.PrintStatementContext ctx){
        return "lcd " + ctx.exp.getText();
    }

    @Override
    public String visitLetStatement(MiniBParser.LetStatementContext ctx){
        // Obtener el identificador y la expresión
        String nombre = ctx.IDENTIFIER().getText();

        // CORREGIR
        Object valor = ctx.expression();

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
        return null; // No devuelve nada, ya que es una declaración
    }

}
