/* The following code was generated by JFlex 1.6.1 */

/**
 * JFlex specification for lexical analysis of a simple demo language.
 * Change this into the scanner for your implementation of MiniJava.
 *
 * CSE 401/M501/P501 18sp
 */


package Scanner;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;
import Parser.sym;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/Scanner/minijava.jflex</tt>
 */
public final class scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\6\1\3\1\56\1\56\1\3\22\0\1\6\1\43\4\0"+
    "\1\44\1\0\1\45\1\46\1\5\1\37\1\52\1\41\1\36\1\4"+
    "\12\2\1\0\1\47\1\42\1\40\3\0\22\1\1\32\7\1\1\53"+
    "\1\0\1\54\1\0\1\55\1\0\1\14\1\17\1\20\1\7\1\26"+
    "\1\35\1\34\1\31\1\10\2\1\1\13\1\24\1\25\1\23\1\12"+
    "\1\1\1\33\1\11\1\21\1\16\1\22\1\30\1\27\1\15\1\1"+
    "\1\50\1\0\1\51\7\0\1\56\u1fa2\0\1\56\1\56\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\20\2"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\1\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\2\0"+
    "\2\2\1\24\21\2\1\25\1\26\2\0\1\2\1\27"+
    "\11\2\1\30\7\2\1\0\6\2\1\31\1\32\1\33"+
    "\1\34\1\35\13\2\1\36\1\2\1\37\3\2\1\40"+
    "\1\2\1\41\1\42\1\43\3\2\1\44\1\45\1\46"+
    "\1\47\1\50\13\0\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[137];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\57\0\u011a"+
    "\0\u0149\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292"+
    "\0\u02c1\0\u02f0\0\u031f\0\u034e\0\u037d\0\u03ac\0\u03db\0\57"+
    "\0\57\0\57\0\57\0\57\0\57\0\u040a\0\57\0\57"+
    "\0\57\0\57\0\57\0\57\0\57\0\57\0\u0439\0\u0468"+
    "\0\u0497\0\u04c6\0\136\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1"+
    "\0\u05e0\0\u060f\0\u063e\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u0729"+
    "\0\u0758\0\u0787\0\u07b6\0\u07e5\0\57\0\57\0\u0814\0\u0843"+
    "\0\u0872\0\136\0\u08a1\0\u08d0\0\u08ff\0\u092e\0\u095d\0\u098c"+
    "\0\u09bb\0\u09ea\0\u0a19\0\136\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5"+
    "\0\u0b04\0\u0b33\0\u0b62\0\u0b91\0\u0bc0\0\u0bef\0\u0c1e\0\u0c4d"+
    "\0\u0c7c\0\u0cab\0\136\0\136\0\136\0\136\0\136\0\u0cda"+
    "\0\u0d09\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\u0df4\0\u0e23\0\u0e52"+
    "\0\u0e81\0\u0eb0\0\136\0\u0edf\0\136\0\u0f0e\0\u0f3d\0\u0f6c"+
    "\0\136\0\u0f9b\0\136\0\136\0\136\0\u0fca\0\u0ff9\0\u1028"+
    "\0\136\0\136\0\136\0\136\0\136\0\u1057\0\u1086\0\u10b5"+
    "\0\u10e4\0\u1113\0\u1142\0\u1171\0\u11a0\0\u11cf\0\u11fe\0\u122d"+
    "\0\57";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[137];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\5\1\10"+
    "\1\11\1\12\1\13\1\14\3\3\1\15\1\16\1\17"+
    "\1\20\1\3\1\21\1\22\1\23\1\3\1\24\1\3"+
    "\1\25\1\26\1\3\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\2\61\0\2\3\4\0\27\3"+
    "\17\0\1\3\3\0\1\4\57\0\1\5\2\0\1\5"+
    "\54\0\1\47\1\50\52\0\2\3\4\0\1\3\1\51"+
    "\25\3\17\0\1\3\2\0\2\3\4\0\16\3\1\52"+
    "\7\3\1\53\17\0\1\3\2\0\2\3\4\0\12\3"+
    "\1\54\14\3\17\0\1\3\2\0\2\3\4\0\7\3"+
    "\1\55\17\3\17\0\1\3\2\0\2\3\4\0\17\3"+
    "\1\56\7\3\17\0\1\3\2\0\2\3\4\0\14\3"+
    "\1\57\12\3\17\0\1\3\2\0\2\3\4\0\4\3"+
    "\1\60\22\3\17\0\1\3\2\0\2\3\4\0\22\3"+
    "\1\61\1\3\1\62\2\3\17\0\1\3\2\0\2\3"+
    "\4\0\14\3\1\63\12\3\17\0\1\3\2\0\2\3"+
    "\4\0\5\3\1\64\21\3\17\0\1\3\2\0\2\3"+
    "\4\0\17\3\1\65\7\3\17\0\1\3\2\0\2\3"+
    "\4\0\4\3\1\66\13\3\1\67\6\3\17\0\1\3"+
    "\2\0\2\3\4\0\22\3\1\70\4\3\17\0\1\3"+
    "\2\0\2\3\4\0\6\3\1\71\3\3\1\72\14\3"+
    "\17\0\1\3\2\0\2\3\4\0\17\3\1\73\7\3"+
    "\17\0\1\3\2\0\2\3\4\0\5\3\1\74\21\3"+
    "\17\0\1\3\45\0\1\75\12\0\3\47\1\76\52\47"+
    "\1\0\5\77\1\100\51\77\1\0\2\3\4\0\2\3"+
    "\1\101\24\3\17\0\1\3\2\0\2\3\4\0\12\3"+
    "\1\102\14\3\17\0\1\3\2\0\2\3\4\0\5\3"+
    "\1\103\21\3\17\0\1\3\2\0\2\3\4\0\10\3"+
    "\1\104\16\3\17\0\1\3\2\0\2\3\4\0\16\3"+
    "\1\105\10\3\17\0\1\3\2\0\2\3\4\0\14\3"+
    "\1\106\12\3\17\0\1\3\2\0\2\3\4\0\5\3"+
    "\1\107\21\3\17\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\110\25\3\17\0\1\3\2\0\2\3\4\0\7\3"+
    "\1\111\17\3\17\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\112\25\3\17\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\113\25\3\17\0\1\3\2\0\2\3\4\0\21\3"+
    "\1\114\5\3\17\0\1\3\2\0\2\3\4\0\2\3"+
    "\1\115\24\3\17\0\1\3\2\0\2\3\4\0\12\3"+
    "\1\116\14\3\17\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\117\25\3\17\0\1\3\2\0\2\3\4\0\2\3"+
    "\1\120\24\3\17\0\1\3\2\0\2\3\4\0\24\3"+
    "\1\121\2\3\17\0\1\3\2\0\2\3\4\0\12\3"+
    "\1\122\14\3\17\0\1\3\2\0\2\3\4\0\4\3"+
    "\1\123\22\3\17\0\1\3\1\0\5\77\1\124\51\77"+
    "\4\0\1\76\1\100\52\0\2\3\4\0\3\3\1\125"+
    "\23\3\17\0\1\3\2\0\2\3\4\0\12\3\1\126"+
    "\14\3\17\0\1\3\2\0\2\3\4\0\4\3\1\127"+
    "\22\3\17\0\1\3\2\0\2\3\4\0\25\3\1\130"+
    "\1\3\17\0\1\3\2\0\2\3\4\0\4\3\1\131"+
    "\22\3\17\0\1\3\2\0\2\3\4\0\2\3\1\132"+
    "\24\3\17\0\1\3\2\0\2\3\4\0\2\3\1\133"+
    "\24\3\17\0\1\3\2\0\2\3\4\0\17\3\1\134"+
    "\7\3\17\0\1\3\2\0\2\3\4\0\1\135\26\3"+
    "\17\0\1\3\2\0\2\3\4\0\16\3\1\136\10\3"+
    "\17\0\1\3\2\0\2\3\4\0\17\3\1\137\7\3"+
    "\17\0\1\3\2\0\2\3\4\0\17\3\1\140\7\3"+
    "\17\0\1\3\2\0\2\3\4\0\4\3\1\141\22\3"+
    "\17\0\1\3\2\0\2\3\4\0\12\3\1\142\14\3"+
    "\17\0\1\3\2\0\2\3\4\0\1\3\1\143\25\3"+
    "\17\0\1\3\2\0\2\3\4\0\7\3\1\144\17\3"+
    "\17\0\1\3\2\0\2\3\4\0\2\3\1\145\24\3"+
    "\17\0\1\3\1\0\4\77\1\76\1\124\51\77\1\0"+
    "\2\3\4\0\4\3\1\146\22\3\17\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\147\25\3\17\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\150\25\3\17\0\1\3\2\0"+
    "\2\3\4\0\12\3\1\151\14\3\17\0\1\3\2\0"+
    "\2\3\4\0\17\3\1\152\7\3\17\0\1\3\2\0"+
    "\2\3\4\0\2\3\1\153\24\3\17\0\1\3\2\0"+
    "\2\3\4\0\16\3\1\154\10\3\17\0\1\3\2\0"+
    "\2\3\4\0\17\3\1\155\7\3\17\0\1\3\2\0"+
    "\2\3\4\0\17\3\1\156\7\3\17\0\1\3\2\0"+
    "\2\3\4\0\16\3\1\157\10\3\17\0\1\3\2\0"+
    "\2\3\4\0\24\3\1\160\2\3\17\0\1\3\2\0"+
    "\2\3\4\0\17\3\1\161\7\3\17\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\162\21\3\17\0\1\3\2\0"+
    "\2\3\4\0\11\3\1\163\15\3\17\0\1\3\2\0"+
    "\2\3\4\0\11\3\1\164\15\3\17\0\1\3\2\0"+
    "\2\3\4\0\22\3\1\165\4\3\17\0\1\3\2\0"+
    "\2\3\4\0\5\3\1\166\21\3\17\0\1\3\2\0"+
    "\2\3\4\0\1\167\26\3\17\0\1\3\2\0\2\3"+
    "\4\0\15\3\1\170\11\3\17\0\1\3\2\0\2\3"+
    "\4\0\25\3\1\171\1\3\17\0\1\3\2\0\2\3"+
    "\4\0\16\3\1\172\10\3\17\0\1\3\2\0\2\3"+
    "\4\0\6\3\1\173\20\3\17\0\1\3\2\0\2\3"+
    "\4\0\16\3\1\174\10\3\17\0\1\3\2\0\2\3"+
    "\4\0\2\3\1\175\24\3\17\0\1\3\2\0\2\3"+
    "\4\0\27\3\1\176\16\0\1\3\24\0\1\177\51\0"+
    "\1\200\61\0\1\201\73\0\1\202\32\0\1\203\77\0"+
    "\1\204\33\0\1\205\73\0\1\206\52\0\1\207\50\0"+
    "\1\210\70\0\1\211\31\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4700];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\11\20\1\6\11\1\1\10\11"+
    "\2\0\24\1\2\11\2\0\23\1\1\0\51\1\13\0"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[137];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  /** The CUP symbol factory, typically shared with parser. */
  private ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

  /** Initialize scanner with input stream and a shared symbol factory. */
  public scanner(java.io.Reader in, ComplexSymbolFactory sf) {
    this(in);
    this.symbolFactory = sf;
  }

  /**
   * Construct a symbol with a given lexical token, a given
   * user-controlled datum, and the matched source location.
   *
   * @param code     identifier of the lexical token (i.e., sym.<TOKEN>)
   * @param value    user-controlled datum to associate with this symbol
   * @effects        constructs new ComplexSymbol via this.symbolFactory
   * @return         a fresh symbol storing the above-desribed information
   */
  private Symbol symbol(int code, Object value) {
    // Calculate symbol location
    int yylen = yylength();
    Location left = new Location(yyline + 1, yycolumn + 1, yychar);
    Location right = new Location(yyline + 1, yycolumn + yylen, yychar + yylen);
    // Calculate symbol name
    int max_code = sym.terminalNames.length;
    String name = code < max_code ? sym.terminalNames[code] : "<UNKNOWN(" + yytext() + ")>";
    return this.symbolFactory.newSymbol(name, code, left, right, value);
  }

  /**
   * Construct a symbol with a given lexical token and matched source
   * location, leaving the user-controlled value field uninitialized.
   *
   * @param code     identifier of the lexical token (i.e., sym.<TOKEN>)
   * @effects        constructs new ComplexSymbol via this.symbolFactory
   * @return         a fresh symbol storing the above-desribed information
   */
  private Symbol symbol(int code) {
    // Calculate symbol location
    int yylen = yylength();
    Location left = new Location(yyline + 1, yycolumn + 1, yychar);
    Location right = new Location(yyline + 1, yycolumn + yylen, yychar + yylen);
    // Calculate symbol name
    int max_code = sym.terminalNames.length;
    String name = code < max_code ? sym.terminalNames[code] : "<UNKNOWN(" + yytext() + ")>";
    return this.symbolFactory.newSymbol(name, code, left, right);
  }

  /**
   * Convert the symbol generated by this scanner into a string.
   *
   * This method is useful to include information in the string representation
   * in addition to the plain CUP name for a lexical token.
   *
   * @param symbol   symbol instance generated by this scanner
   * @return         string representation of the symbol
   */
   public String symbolToString(Symbol s) {
     // All symbols generated by this class are ComplexSymbol instances
     ComplexSymbol cs = (ComplexSymbol)s; 
     if (cs.sym == sym.IDENTIFIER) {
       return "ID(" + (String)cs.value + ")";
     } else if (cs.sym == sym.error) {
       return "<UNEXPECTED(" + (String)cs.value + ")>";
     } else {
       return cs.getName();
     }
   }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 170) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.err.printf(
      "%nUnexpected character '%s' on line %d at column %d of input.%n",
      yytext(), yyline + 1, yycolumn + 1
    );
    return symbol(sym.error, yytext());
            }
          case 42: break;
          case 2: 
            { return symbol(sym.IDENTIFIER, yytext());
            }
          case 43: break;
          case 3: 
            { return symbol(sym.INTLITERAL, yytext());
            }
          case 44: break;
          case 4: 
            { /* ignore whitespace */
            }
          case 45: break;
          case 5: 
            { return symbol(sym.MULTI);
            }
          case 46: break;
          case 6: 
            { return symbol(sym.DOT);
            }
          case 47: break;
          case 7: 
            { return symbol(sym.PLUS);
            }
          case 48: break;
          case 8: 
            { return symbol(sym.BECOMES);
            }
          case 49: break;
          case 9: 
            { return symbol(sym.MINUS);
            }
          case 50: break;
          case 10: 
            { return symbol(sym.LTHAN);
            }
          case 51: break;
          case 11: 
            { return symbol(sym.EXCLAMATION);
            }
          case 52: break;
          case 12: 
            { return symbol(sym.LPAREN);
            }
          case 53: break;
          case 13: 
            { return symbol(sym.RPAREN);
            }
          case 54: break;
          case 14: 
            { return symbol(sym.SEMICOLON);
            }
          case 55: break;
          case 15: 
            { return symbol(sym.LCURLYBRACE);
            }
          case 56: break;
          case 16: 
            { return symbol(sym.RCURLYBRACE);
            }
          case 57: break;
          case 17: 
            { return symbol(sym.COMA);
            }
          case 58: break;
          case 18: 
            { return symbol(sym.LBRACKET);
            }
          case 59: break;
          case 19: 
            { return symbol(sym.RBRACKET);
            }
          case 60: break;
          case 20: 
            { return symbol(sym.IF);
            }
          case 61: break;
          case 21: 
            { return symbol(sym.AND);
            }
          case 62: break;
          case 22: 
            { /* ignore comments */
            }
          case 63: break;
          case 23: 
            { return symbol(sym.INT);
            }
          case 64: break;
          case 24: 
            { return symbol(sym.NEW);
            }
          case 65: break;
          case 25: 
            { return symbol(sym.THIS);
            }
          case 66: break;
          case 26: 
            { return symbol(sym.TRUE);
            }
          case 67: break;
          case 27: 
            { return symbol(sym.VOID);
            }
          case 68: break;
          case 28: 
            { return symbol(sym.MAIN);
            }
          case 69: break;
          case 29: 
            { return symbol(sym.ELSE);
            }
          case 70: break;
          case 30: 
            { return symbol(sym.CLASS);
            }
          case 71: break;
          case 31: 
            { return symbol(sym.WHILE);
            }
          case 72: break;
          case 32: 
            { return symbol(sym.FALSE);
            }
          case 73: break;
          case 33: 
            { return symbol(sym.STATIC);
            }
          case 74: break;
          case 34: 
            { return symbol(sym.PUBLIC);
            }
          case 75: break;
          case 35: 
            { return symbol(sym.LENGTH);
            }
          case 76: break;
          case 36: 
            { return symbol(sym.STRING);
            }
          case 77: break;
          case 37: 
            { return symbol(sym.RETURN);
            }
          case 78: break;
          case 38: 
            { return symbol(sym.DISPLAY);
            }
          case 79: break;
          case 39: 
            { return symbol(sym.BOOLEAN);
            }
          case 80: break;
          case 40: 
            { return symbol(sym.EXTENDS);
            }
          case 81: break;
          case 41: 
            { return symbol(sym.PRINT);
            }
          case 82: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
