/* Generated By:JavaCC: Do not edit this line. PAParser.java */
package other.postscriptviewer.interpreter;

public class PAParser extends Object implements PAParserConstants {

  final public void parse(PAContext context) throws ParseException {
        Token x = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case IDENTIFIER:
      case KEY_IDENTIFIER:
      case IMMEDIATE_IDENTIFIER:
      case LBRACE:
      case RBRACE:
      case LBRACKET:
      case RBRACKET:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
        x = jj_consume_token(INTEGER_LITERAL);
                                try {
                                        context.engine.process(new Integer(x.image));
                                } catch(NumberFormatException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case FLOATING_POINT_LITERAL:
        x = jj_consume_token(FLOATING_POINT_LITERAL);
                                try {
                                        context.engine.process(new Double(x.image));
                                } catch(NumberFormatException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case STRING_LITERAL:
        x = jj_consume_token(STRING_LITERAL);
                                try {
                                         context.engine.process(x.image.substring(1, x.image.length() -1));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case IDENTIFIER:
        x = jj_consume_token(IDENTIFIER);
                                try {
                                         context.engine.process(new PAToken(x.image, PAToken.IDENTIFIER));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case KEY_IDENTIFIER:
        x = jj_consume_token(KEY_IDENTIFIER);
                                try {
                                         context.engine.process(new PAToken(x.image.substring(1, x.image.length()), PAToken.KEY));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case IMMEDIATE_IDENTIFIER:
        x = jj_consume_token(IMMEDIATE_IDENTIFIER);
                                try {
                                         context.engine.process(new PAToken(x.image.substring(2, x.image.length()), PAToken.IMMEDIATE));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case LBRACE:
        jj_consume_token(LBRACE);
                                try {
                                        context.engine.process(new PAToken(null, PAToken.START_PROCEDURE));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case RBRACE:
        jj_consume_token(RBRACE);
                                try {
                                        context.engine.process(new PAToken(null, PAToken.END_PROCEDURE));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case LBRACKET:
        jj_consume_token(LBRACKET);
                                try {
                                        context.engine.process(new PAToken(null, PAToken.START_ARRAY));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      case RBRACKET:
        jj_consume_token(RBRACKET);
                                try {
                                        context.engine.process(new PAToken(null, PAToken.END_ARRAY));
                                } catch(PainterException e) {
                                        {if (true) throw new ParseException(e.toString());}
                                }
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  public PAParserTokenManager token_source;
  ASCII_UCodeESC_CharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[2];
  final private int[] jj_la1_0 = {0x3cf48,0x3cf48,};

  public PAParser(java.io.InputStream stream) {
    jj_input_stream = new ASCII_UCodeESC_CharStream(stream, 1, 1);
    token_source = new PAParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public PAParser(PAParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public void ReInit(PAParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  final public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[18];
    for (int i = 0; i < 18; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 18; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}
