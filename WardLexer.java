/*
 *
 *
 *
 *
 *
 *
 *
 *
 * @author Jonathan Ward
 * @version Fall 2016
 */
public class WardLexer implements Lexer
{
    public static final int TO_TOKEN = 101;
    public static final int TOP_KEYWORD = 102;
    public static final int ID_TOKEN = 103;

    private String input;
    private int currIndex;
    private int eopIndex;
    private int state;
    private int [][] dfaTable =
    {//              a-n    o   p-s     t   u-s     0-9     ?? */
    {                 4,    4,   4,     1,   4,       5,       5}, //0
    {                 4,    2,   4,     4,   4,       4,       5}, //1
    {                 4,    4,   3,     4,   4,       4,       5}, //2
    {                 4,    4,   4,     4,   4,       4,       5}, //3
    {                 4,    4,   4,     4,   4,       4,       5}, //4
    {                 5,    5,   5,     5,   5,       5,       5}  //5
    };

    public WardLexer(String input)
    {
    this.input = input;
    eopIndex = input.length();
    state = 0;
    currIndex = 0;
    }

    public int getToken()
    {
    char c;
    int col;
    int token = Lexer.EOP;
    
    while (true)
    {
        if (currIndex < eopIndex)
        c = input.charAt(currIndex++);
        else 
        return token;

        col = mapCharToCol(c);
        state = dfaTable[state][col];


    switch (state)
    {
        case 1:
        token = ID_TOKEN; break;
        case 2:
        token = TO_TOKEN; break;
        case 3:
        token = TOP_KEYWORD; break;
        case 4: 
        token = ID_TOKEN; break;
        //case 5: 
       // token = ID_TOKEN; break;
        default:
        return Lexer.UNKNOWN_TOKEN;
   }

 }
    }
    
    public String tokenName(int token)
   {
       switch (token)
       {
           case Lexer.EOP:
           return "EOP";
           case Lexer.UNKNOWN_TOKEN:
           return "UKNOWN";
           case TO_TOKEN:
           return "TO";
           case TOP_KEYWORD:
           return "TOP";
           case ID_TOKEN:
           return "ID";
           default:
           return "Huh??";
       }
   }


   private int mapCharToCol(char c)
   {
       if ('a' <= c && c <= 'n') return 0;
       if (c == 'o') return 1;
       if ('p' <= c && c <= 's') return 2;
       if (c == 't') return 3;
       if (c <= 'u' && c <= 'z') return 4;
       if (c <= '0' && c <= '9') return 5;
       
       return 6; 
   }

 }


