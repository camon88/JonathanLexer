/**
 *  basic lexer interface
 *
 * Typical usage will be for user who wishes to implement a lexer for
 * a specific purpose. They will define their own concrete lexer class
 * that implements this interface. They will add static final token values
 * specific to their language. They will implement the two required
 * methods specifically for their language.
 *
 * @author Dr. Fenwick
 * @version Fall 2016
 */
public interface Lexer
{
    public static final int EOP = 0;
    public static final int UNKNOWN_TOKEN = 1;

    /**
     * Abstract method that implements FSM of lexer.
     *
     * @return token value (one of the static final values)
     */
    public int getToken();

    /**
     * Utility method converting token values into readable form.
     *
     * @param token is numeric (static final) value of a token
     * @return string form of token name
     */
    public String tokenName(int token);
}

