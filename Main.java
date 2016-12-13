/**
 *  A simple driver for the 9/30 lexer assignment in CS 3490.
 *
 *
 * @version Fall 2016
 */
public class Main
{
    /**
     * Class entry point.
     *
     * @param args the command line arguments when invoked
     */
    public static void main(String[] args)
    {
    if (args.length != 1)
    {
        System.out.println("usage: java Main lexeme");
        System.exit(1);
    }

    Lexer lexer = new WardLexer(args[0]);
    int token = lexer.getToken();
    System.out.println("Found token: " + lexer.tokenName(token));
    }
}

