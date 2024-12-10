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

        //System.out.println(tree.toStringTree(parser));

        return createJasminFile((String) new MyVisitor().visit(tree));
    }

    private static String createJasminFile(String instructions){
        return    instructions + "\n"
                + "return\n"
                + "\n"
                + ".end method";
    }
}
