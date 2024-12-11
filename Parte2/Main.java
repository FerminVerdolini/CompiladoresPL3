import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.sql.CommonDataSource;

public class Main {
    public static void main(String[] args) throws Exception{
        String inputFile = null;

        if(args.length > 0){
            inputFile = args[0];
        }

        CharStream inputsream = null;
        if (inputFile != null){
            compile(inputFile);
        }
    }

    public static void compile(String inputFile) throws Exception{
        MiniBLexer lexer = new MiniBLexer(CharStreams.fromFileName(inputFile));
        MiniBParser parser = new MiniBParser(new CommonTokenStream(lexer));

        parser.setBuildParseTree(true);
        ParseTree tree = parser.programa();

        //System.out.println(tree.toStringTree(parser));
        String fileName = new File(inputFile).getName().replaceFirst("\\.[^.]+$", "");


        createJasminFile((String) new MyVisitor(fileName).visit(tree), fileName+".j");
    }

    private static void createJasminFile(String instructions, String fileName) {
        // Nombre del archivo de salida
        String dir = "EjemplosJasmin/";

        // Agregar las instrucciones de cierre al archivo Jasmin
        String content = instructions + "\n"
                + "return\n"
                + "\n"
                + ".end method";

        try (FileWriter fileWriter = new FileWriter(dir+fileName)) {
            // Escribir el contenido en el archivo
            fileWriter.write(content);
            System.out.println("Archivo generado exitosamente: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
