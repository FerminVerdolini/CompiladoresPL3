import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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
            System.out.println(compile(inputFile));
        }
    }

    public static String compile(String inputFile) throws Exception{
        MiniBLexer lexer = new MiniBLexer(CharStreams.fromFileName(inputFile));
        MiniBParser parser = new MiniBParser(new CommonTokenStream(lexer));

        parser.setBuildParseTree(true);
        ParseTree tree = parser.programa();

        System.out.println(tree.toStringTree(parser));

        return createJasminFile((String) new MyVisitor().visit(tree));
    }

    private static String createJasminFile(String instructions){
        return ".class public Sumar\n"
                + ".super java/lang/Object\n"
                + "\n"
                + ".method public static main([Ljava/lang/String;)V\n"
                + "    .limit stack 100\n"
                + "    .limit locals 100 \n"
                + "\n"
                + "    getstatic java/lang/System/out Ljava/io/PrintStream;\n"
                + instructions + "\n"
                + "    invokevirtual java/io/PrintStream/println(I)V\n"
                + "return\n"
                + "\n"
                + ".end method";
    }
}
