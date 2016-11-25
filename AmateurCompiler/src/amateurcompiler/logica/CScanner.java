

/*Seccion de codigo de usuario*/
package amateurcompiler.logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//clase de los token devueltos
/* Seccion de opciones y declaraciones de JFlex */


public class CScanner {

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
    "\11\0\1\55\1\56\2\0\1\56\22\0\1\52\1\0\1\51\1\44"+
    "\1\53\1\35\1\53\1\0\1\37\1\40\1\33\1\31\1\43\1\32"+
    "\1\50\1\34\12\45\1\36\1\53\1\26\1\27\1\25\2\53\32\47"+
    "\1\41\1\53\1\42\1\53\1\54\1\0\1\5\1\11\1\16\1\17"+
    "\1\13\1\20\1\4\1\23\1\10\2\47\1\12\1\6\1\14\1\3"+
    "\1\1\1\24\1\2\1\21\1\15\1\22\1\7\2\47\1\30\1\47"+
    "\57\0\1\46\12\0\1\46\4\0\1\46\4\0\1\53\2\46\1\54"+
    "\24\46\1\0\37\46\1\0\u01ca\46\4\0\14\46\16\0\5\46\7\0"+
    "\1\46\1\0\1\46\21\0\165\46\1\0\2\46\2\0\4\46\1\0"+
    "\1\46\6\0\1\46\1\0\3\46\1\0\1\46\1\0\24\46\1\0"+
    "\123\46\1\0\213\46\1\0\255\46\1\0\46\46\2\0\1\46\7\0"+
    "\47\46\11\0\55\46\1\0\1\46\1\0\2\46\1\0\2\46\1\0"+
    "\1\46\10\0\33\46\5\0\3\46\35\0\13\46\5\0\112\46\4\0"+
    "\146\46\1\0\10\46\2\0\12\46\1\0\23\46\2\0\1\46\20\0"+
    "\73\46\2\0\145\46\16\0\66\46\4\0\1\46\5\0\56\46\22\0"+
    "\34\46\104\0\23\46\61\0\200\46\2\0\12\46\1\0\23\46\1\0"+
    "\10\46\2\0\2\46\2\0\26\46\1\0\7\46\1\0\1\46\3\0"+
    "\4\46\2\0\11\46\2\0\2\46\2\0\4\46\10\0\1\46\4\0"+
    "\2\46\1\0\5\46\2\0\14\46\17\0\3\46\1\0\6\46\4\0"+
    "\2\46\2\0\26\46\1\0\7\46\1\0\2\46\1\0\2\46\1\0"+
    "\2\46\2\0\1\46\1\0\5\46\4\0\2\46\2\0\3\46\3\0"+
    "\1\46\7\0\4\46\1\0\1\46\7\0\20\46\13\0\3\46\1\0"+
    "\11\46\1\0\3\46\1\0\26\46\1\0\7\46\1\0\2\46\1\0"+
    "\5\46\2\0\12\46\1\0\3\46\1\0\3\46\2\0\1\46\17\0"+
    "\4\46\2\0\12\46\21\0\3\46\1\0\10\46\2\0\2\46\2\0"+
    "\26\46\1\0\7\46\1\0\2\46\1\0\5\46\2\0\11\46\2\0"+
    "\2\46\2\0\3\46\10\0\2\46\4\0\2\46\1\0\5\46\2\0"+
    "\12\46\1\0\1\46\20\0\2\46\1\0\6\46\3\0\3\46\1\0"+
    "\4\46\3\0\2\46\1\0\1\46\1\0\2\46\3\0\2\46\3\0"+
    "\3\46\3\0\14\46\4\0\5\46\3\0\3\46\1\0\4\46\2\0"+
    "\1\46\6\0\1\46\16\0\12\46\20\0\4\46\1\0\10\46\1\0"+
    "\3\46\1\0\27\46\1\0\20\46\3\0\10\46\1\0\3\46\1\0"+
    "\4\46\7\0\2\46\1\0\2\46\6\0\4\46\2\0\12\46\21\0"+
    "\3\46\1\0\10\46\1\0\3\46\1\0\27\46\1\0\12\46\1\0"+
    "\5\46\2\0\11\46\1\0\3\46\1\0\4\46\7\0\2\46\7\0"+
    "\1\46\1\0\4\46\2\0\12\46\1\0\2\46\16\0\3\46\1\0"+
    "\10\46\1\0\3\46\1\0\51\46\2\0\10\46\1\0\3\46\1\0"+
    "\5\46\10\0\1\46\10\0\4\46\2\0\12\46\12\0\6\46\2\0"+
    "\2\46\1\0\22\46\3\0\30\46\1\0\11\46\1\0\1\46\2\0"+
    "\7\46\3\0\1\46\4\0\6\46\1\0\1\46\1\0\10\46\6\0"+
    "\12\46\2\0\2\46\15\0\72\46\5\0\17\46\1\0\12\46\47\0"+
    "\2\46\1\0\1\46\2\0\2\46\1\0\1\46\2\0\1\46\6\0"+
    "\4\46\1\0\7\46\1\0\3\46\1\0\1\46\1\0\1\46\2\0"+
    "\2\46\1\0\15\46\1\0\3\46\2\0\5\46\1\0\1\46\1\0"+
    "\6\46\2\0\12\46\2\0\4\46\40\0\1\46\27\0\2\46\6\0"+
    "\12\46\13\0\1\46\1\0\1\46\1\0\1\46\4\0\12\46\1\0"+
    "\44\46\4\0\24\46\1\0\22\46\1\0\44\46\11\0\1\46\71\0"+
    "\112\46\6\0\116\46\2\0\46\46\1\0\1\46\5\0\1\46\2\0"+
    "\53\46\1\0\u014d\46\1\0\4\46\2\0\7\46\1\0\1\46\1\0"+
    "\4\46\2\0\51\46\1\0\4\46\2\0\41\46\1\0\4\46\2\0"+
    "\7\46\1\0\1\46\1\0\4\46\2\0\17\46\1\0\71\46\1\0"+
    "\4\46\2\0\103\46\2\0\3\46\40\0\20\46\20\0\125\46\14\0"+
    "\u026c\46\2\0\21\46\1\0\32\46\5\0\113\46\3\0\13\46\7\0"+
    "\15\46\1\0\7\46\13\0\25\46\13\0\24\46\14\0\15\46\1\0"+
    "\3\46\1\0\2\46\14\0\124\46\3\0\1\46\4\0\2\46\2\0"+
    "\12\46\41\0\3\46\2\0\12\46\6\0\130\46\10\0\53\46\5\0"+
    "\106\46\12\0\37\46\1\0\14\46\4\0\14\46\12\0\50\46\2\0"+
    "\5\46\13\0\54\46\4\0\32\46\6\0\12\46\46\0\34\46\4\0"+
    "\77\46\1\0\35\46\2\0\13\46\6\0\12\46\15\0\1\46\10\0"+
    "\17\46\101\0\114\46\4\0\12\46\21\0\11\46\14\0\164\46\14\0"+
    "\70\46\10\0\12\46\3\0\61\46\122\0\3\46\1\0\43\46\1\0"+
    "\2\46\6\0\366\46\6\0\u011a\46\2\0\6\46\2\0\46\46\2\0"+
    "\6\46\2\0\10\46\1\0\1\46\1\0\1\46\1\0\1\46\1\0"+
    "\37\46\2\0\65\46\1\0\7\46\1\0\1\46\3\0\3\46\1\0"+
    "\7\46\3\0\4\46\2\0\6\46\4\0\15\46\5\0\3\46\1\0"+
    "\7\46\102\0\2\46\23\0\1\46\34\0\1\46\15\0\1\46\20\0"+
    "\15\46\63\0\41\46\21\0\1\46\4\0\1\46\2\0\12\46\1\0"+
    "\1\46\3\0\5\46\6\0\1\46\1\0\1\46\1\0\1\46\1\0"+
    "\4\46\1\0\13\46\2\0\4\46\5\0\5\46\4\0\1\46\21\0"+
    "\51\46\u032d\0\64\46\u0716\0\57\46\1\0\57\46\1\0\205\46\6\0"+
    "\11\46\14\0\46\46\1\0\1\46\5\0\1\46\2\0\70\46\7\0"+
    "\1\46\17\0\30\46\11\0\7\46\1\0\7\46\1\0\7\46\1\0"+
    "\7\46\1\0\7\46\1\0\7\46\1\0\7\46\1\0\7\46\1\0"+
    "\40\46\57\0\1\46\u01d5\0\3\46\31\0\17\46\1\0\5\46\2\0"+
    "\5\46\4\0\126\46\2\0\2\46\2\0\3\46\1\0\132\46\1\0"+
    "\4\46\5\0\51\46\3\0\136\46\21\0\33\46\65\0\20\46\u0200\0"+
    "\u19b6\46\112\0\u51cd\46\63\0\u048d\46\103\0\56\46\2\0\u010d\46\3\0"+
    "\34\46\24\0\63\46\1\0\12\46\1\0\37\46\1\0\123\46\45\0"+
    "\11\46\2\0\147\46\2\0\4\46\1\0\36\46\2\0\2\46\105\0"+
    "\61\46\30\0\64\46\14\0\105\46\13\0\12\46\6\0\30\46\3\0"+
    "\1\46\4\0\56\46\2\0\44\46\14\0\35\46\3\0\101\46\16\0"+
    "\13\46\6\0\37\46\1\0\67\46\11\0\16\46\2\0\12\46\6\0"+
    "\27\46\3\0\111\46\30\0\3\46\2\0\20\46\2\0\5\46\12\0"+
    "\6\46\2\0\6\46\2\0\6\46\11\0\7\46\1\0\7\46\1\0"+
    "\53\46\1\0\4\46\4\0\2\46\132\0\53\46\1\0\2\46\2\0"+
    "\12\46\6\0\u2ba4\46\14\0\27\46\4\0\61\46\u2104\0\u016e\46\2\0"+
    "\152\46\46\0\7\46\14\0\5\46\5\0\14\46\1\0\15\46\1\0"+
    "\5\46\1\0\1\46\1\0\2\46\1\0\2\46\1\0\154\46\41\0"+
    "\u016b\46\22\0\100\46\2\0\66\46\50\0\14\46\4\0\20\46\20\0"+
    "\16\46\5\0\2\46\30\0\3\46\40\0\5\46\1\0\207\46\23\0"+
    "\12\46\7\0\32\46\4\0\1\46\1\0\32\46\13\0\131\46\3\0"+
    "\6\46\2\0\6\46\2\0\6\46\2\0\3\46\43\0\14\46\1\0"+
    "\32\46\1\0\23\46\1\0\2\46\1\0\17\46\2\0\16\46\42\0"+
    "\173\46\105\0\65\46\210\0\1\46\202\0\35\46\3\0\61\46\17\0"+
    "\1\46\37\0\40\46\20\0\33\46\5\0\53\46\5\0\36\46\2\0"+
    "\44\46\4\0\10\46\1\0\5\46\52\0\236\46\2\0\12\46\126\0"+
    "\50\46\10\0\64\46\234\0\u0137\46\11\0\26\46\12\0\10\46\230\0"+
    "\6\46\2\0\1\46\1\0\54\46\1\0\2\46\3\0\1\46\2\0"+
    "\27\46\12\0\27\46\11\0\37\46\141\0\26\46\12\0\32\46\106\0"+
    "\70\46\6\0\2\46\100\0\4\46\1\0\2\46\5\0\10\46\1\0"+
    "\3\46\1\0\33\46\4\0\3\46\4\0\1\46\40\0\35\46\3\0"+
    "\35\46\43\0\10\46\1\0\36\46\31\0\66\46\12\0\26\46\12\0"+
    "\23\46\15\0\22\46\156\0\111\46\u03b7\0\107\46\37\0\12\46\17\0"+
    "\74\46\25\0\31\46\7\0\12\46\6\0\65\46\1\0\12\46\20\0"+
    "\44\46\2\0\1\46\11\0\105\46\13\0\13\46\45\0\22\46\1\0"+
    "\45\46\170\0\73\46\5\0\12\46\7\0\3\46\1\0\10\46\2\0"+
    "\2\46\2\0\26\46\1\0\7\46\1\0\2\46\1\0\5\46\2\0"+
    "\11\46\2\0\2\46\2\0\3\46\11\0\1\46\5\0\7\46\2\0"+
    "\7\46\3\0\5\46\u010b\0\106\46\1\0\1\46\10\0\12\46\246\0"+
    "\66\46\2\0\11\46\77\0\101\46\3\0\1\46\13\0\12\46\46\0"+
    "\70\46\10\0\12\46\u01d6\0\112\46\25\0\1\46\u01c0\0\71\46\u0507\0"+
    "\u0399\46\147\0\157\46\u0b91\0\u042f\46\u33d1\0\u0239\46\7\0\37\46\1\0"+
    "\12\46\146\0\36\46\2\0\5\46\13\0\67\46\11\0\4\46\14\0"+
    "\12\46\11\0\25\46\5\0\23\46\u0370\0\105\46\13\0\57\46\20\0"+
    "\21\46\u4060\0\2\46\u0bfe\0\153\46\5\0\15\46\3\0\11\46\7\0"+
    "\12\46\3\0\2\46\u14c6\0\5\46\3\0\6\46\10\0\10\46\2\0"+
    "\7\46\36\0\4\46\224\0\3\46\u01bb\0\125\46\1\0\107\46\1\0"+
    "\2\46\2\0\1\46\2\0\2\46\2\0\4\46\1\0\14\46\1\0"+
    "\1\46\1\0\7\46\1\0\101\46\1\0\4\46\2\0\10\46\1\0"+
    "\7\46\1\0\34\46\1\0\4\46\1\0\5\46\1\0\1\46\3\0"+
    "\7\46\1\0\u0154\46\2\0\31\46\1\0\31\46\1\0\37\46\1\0"+
    "\31\46\1\0\37\46\1\0\31\46\1\0\37\46\1\0\31\46\1\0"+
    "\37\46\1\0\31\46\1\0\10\46\2\0\62\46\u1000\0\305\46\13\0"+
    "\7\46\u0529\0\4\46\1\0\33\46\1\0\2\46\1\0\1\46\2\0"+
    "\1\46\1\0\12\46\1\0\4\46\1\0\1\46\1\0\1\46\6\0"+
    "\1\46\4\0\1\46\1\0\1\46\1\0\1\46\1\0\3\46\1\0"+
    "\2\46\1\0\1\46\2\0\1\46\1\0\1\46\1\0\1\46\1\0"+
    "\1\46\1\0\1\46\1\0\2\46\1\0\1\46\2\0\4\46\1\0"+
    "\7\46\1\0\4\46\1\0\4\46\1\0\1\46\1\0\12\46\1\0"+
    "\21\46\5\0\3\46\1\0\5\46\1\0\21\46\u0274\0\32\46\6\0"+
    "\32\46\6\0\32\46\u0e76\0\ua6d7\46\51\0\u1035\46\13\0\336\46\u3fe2\0"+
    "\u021e\46\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u06ed\0"+
    "\360\46\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\2\1\1\2\16\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\0\1\22\1\0\1\23\1\24"+
    "\13\1\1\25\4\1\1\26\2\1\1\27\1\30\1\31"+
    "\2\0\1\32\1\0\1\33\17\1\1\34\4\1\2\0"+
    "\1\35\1\1\1\36\1\37\1\40\1\41\4\1\1\42"+
    "\5\1\1\43\15\1\1\44\1\45\1\46\3\1\1\47"+
    "\1\1\1\50\1\1\1\51\1\52\7\1\1\53\1\54"+
    "\1\55\1\56\1\57\4\1\1\60\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[147];
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
    "\0\0\0\57\0\136\0\215\0\215\0\274\0\353\0\u011a"+
    "\0\u0149\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292"+
    "\0\u02c1\0\u02f0\0\u031f\0\u034e\0\u037d\0\215\0\u03ac\0\u03db"+
    "\0\u03ac\0\u03ac\0\u03ac\0\u03ac\0\u03ac\0\u03ac\0\u03ac\0\u03ac"+
    "\0\u03ac\0\u040a\0\u0439\0\u0468\0\u03ac\0\u03ac\0\u0497\0\u04c6"+
    "\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1\0\u05e0\0\u060f\0\u063e"+
    "\0\u066d\0\215\0\u069c\0\u06cb\0\u06fa\0\u0729\0\u0758\0\u0787"+
    "\0\u07b6\0\u03ac\0\u03ac\0\u03ac\0\u07e5\0\u0814\0\u040a\0\u0843"+
    "\0\u03ac\0\u0872\0\u08a1\0\u08d0\0\u08ff\0\u092e\0\u095d\0\u098c"+
    "\0\u09bb\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5\0\u0b04"+
    "\0\215\0\u0b33\0\u0b62\0\u0b91\0\u0bc0\0\u0bef\0\u0c1e\0\u0843"+
    "\0\u0c4d\0\215\0\215\0\215\0\215\0\u0c7c\0\u0cab\0\u0cda"+
    "\0\u0d09\0\215\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\u0df4\0\215"+
    "\0\u0e23\0\u0e52\0\u0e81\0\u0eb0\0\u0edf\0\u0f0e\0\u0f3d\0\u0f6c"+
    "\0\u0f9b\0\u0fca\0\u0ff9\0\u1028\0\u1057\0\215\0\215\0\215"+
    "\0\u1086\0\u10b5\0\u10e4\0\215\0\u1113\0\215\0\u1142\0\215"+
    "\0\215\0\u1171\0\u11a0\0\u11cf\0\u11fe\0\u122d\0\u125c\0\u128b"+
    "\0\215\0\u12ba\0\215\0\215\0\215\0\u12e9\0\u1318\0\u1347"+
    "\0\u1376\0\215\0\215";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[147];
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
    "\1\0\1\2\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\5\1\16\1\17"+
    "\1\20\1\21\1\5\1\22\1\5\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\0\1\5"+
    "\1\0\1\44\1\45\2\0\1\45\1\46\1\0\1\5"+
    "\1\47\2\5\1\50\17\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\12\5\1\51\11\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\24\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\10\5\1\52\13\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\7\5"+
    "\1\53\14\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\4\5\1\54\17\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\13\5\1\55\10\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\2\5\1\56\21\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\12\5"+
    "\1\57\11\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\13\5\1\60\4\5\1\61\3\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\2\5\1\62\21\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\4\5"+
    "\1\63\2\5\1\64\14\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\12\5\1\65\11\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\7\5\1\66\14\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\7\5"+
    "\1\67\2\5\1\70\11\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\4\5\1\71\17\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\31\0\1\72\56\0\1\73"+
    "\56\0\1\74\140\0\1\75\12\0\1\43\11\0\1\42"+
    "\24\76\3\42\1\76\13\42\1\77\1\76\1\0\1\76"+
    "\4\42\1\0\2\42\32\0\1\75\12\0\1\43\2\0"+
    "\1\100\7\0\30\44\2\0\13\44\1\0\2\44\1\101"+
    "\3\44\3\0\2\5\1\102\21\5\3\0\1\5\14\0"+
    "\3\5\4\0\1\5\3\0\1\5\1\103\16\5\1\104"+
    "\3\5\3\0\1\5\14\0\3\5\4\0\1\5\3\0"+
    "\4\5\1\105\17\5\3\0\1\5\14\0\3\5\4\0"+
    "\1\5\3\0\1\5\1\106\22\5\3\0\1\5\14\0"+
    "\3\5\4\0\1\5\3\0\12\5\1\107\11\5\3\0"+
    "\1\5\14\0\3\5\4\0\1\5\3\0\1\5\1\110"+
    "\22\5\3\0\1\5\14\0\3\5\4\0\1\5\3\0"+
    "\7\5\1\111\14\5\3\0\1\5\14\0\3\5\4\0"+
    "\1\5\3\0\2\5\1\112\21\5\3\0\1\5\14\0"+
    "\3\5\4\0\1\5\3\0\12\5\1\113\11\5\3\0"+
    "\1\5\14\0\3\5\4\0\1\5\3\0\14\5\1\114"+
    "\7\5\3\0\1\5\14\0\3\5\4\0\1\5\3\0"+
    "\15\5\1\115\6\5\3\0\1\5\14\0\3\5\4\0"+
    "\1\5\3\0\16\5\1\116\5\5\3\0\1\5\14\0"+
    "\3\5\4\0\1\5\3\0\12\5\1\117\11\5\3\0"+
    "\1\5\14\0\3\5\4\0\1\5\3\0\2\5\1\120"+
    "\21\5\3\0\1\5\14\0\3\5\4\0\1\5\3\0"+
    "\13\5\1\121\10\5\3\0\1\5\14\0\3\5\4\0"+
    "\1\5\3\0\13\5\1\122\10\5\3\0\1\5\14\0"+
    "\3\5\4\0\1\5\3\0\3\5\1\123\20\5\3\0"+
    "\1\5\14\0\3\5\4\0\1\5\3\0\15\5\1\124"+
    "\2\5\1\125\3\5\3\0\1\5\14\0\3\5\4\0"+
    "\1\5\47\0\1\126\11\0\1\42\24\76\3\42\1\76"+
    "\13\42\1\77\3\76\4\42\1\76\2\42\32\0\1\127"+
    "\12\0\1\130\12\0\3\5\1\131\20\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\4\5\1\132\17\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\2\5"+
    "\1\133\21\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\11\5\1\134\12\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\12\5\1\135\11\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\13\5\1\136\10\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\7\5"+
    "\1\137\14\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\15\5\1\140\6\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\11\5\1\141\12\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\1\5\1\142\22\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\12\5"+
    "\1\143\11\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\1\5\1\144\22\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\12\5\1\145\11\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\1\5\1\146\22\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\14\5"+
    "\1\147\7\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\2\5\1\150\21\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\21\5\1\151\2\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\12\5\1\152\11\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\14\5"+
    "\1\153\7\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\34\0\1\75\12\0\1\126\2\0\1\100\53\0\1\130"+
    "\12\0\1\5\1\154\22\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\14\5\1\155\7\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\4\5\1\156\17\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\7\5"+
    "\1\157\14\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\12\5\1\160\11\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\1\5\1\161\22\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\7\5\1\162\14\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\13\5"+
    "\1\163\10\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\1\5\1\164\22\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\1\5\1\165\22\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\13\5\1\166\10\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\1\5"+
    "\1\167\22\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\4\5\1\170\17\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\4\5\1\171\17\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\1\5\1\172\22\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\10\5"+
    "\1\173\13\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\2\5\1\174\21\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\4\5\1\175\17\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\2\5\1\176\21\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\10\5"+
    "\1\177\13\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\4\5\1\200\17\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\4\5\1\201\17\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\2\5\1\202\21\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\5\5"+
    "\1\203\16\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\4\5\1\204\17\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\11\5\1\205\12\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\13\5\1\206\10\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\7\5"+
    "\1\207\14\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\5\5\1\210\16\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\4\5\1\211\17\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\20\5\1\212\3\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\12\5"+
    "\1\213\11\5\3\0\1\5\14\0\3\5\4\0\1\5"+
    "\3\0\2\5\1\214\21\5\3\0\1\5\14\0\3\5"+
    "\4\0\1\5\3\0\1\5\1\215\22\5\3\0\1\5"+
    "\14\0\3\5\4\0\1\5\3\0\2\5\1\216\21\5"+
    "\3\0\1\5\14\0\3\5\4\0\1\5\3\0\23\5"+
    "\1\217\3\0\1\5\14\0\3\5\4\0\1\5\3\0"+
    "\16\5\1\220\5\5\3\0\1\5\14\0\3\5\4\0"+
    "\1\5\3\0\21\5\1\221\2\5\3\0\1\5\14\0"+
    "\3\5\4\0\1\5\3\0\2\5\1\222\21\5\3\0"+
    "\1\5\14\0\3\5\4\0\1\5\3\0\12\5\1\223"+
    "\11\5\3\0\1\5\14\0\3\5\4\0\1\5\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5029];
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
    "\1\0\25\1\1\11\1\1\11\11\1\0\1\1\1\0"+
    "\2\11\23\1\3\11\2\0\1\1\1\0\1\11\24\1"+
    "\2\0\74\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[147];
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
	
    private int contador;
    private ArrayList<CToken> tokens;

	private void writeOutputFile() throws IOException{
			String filename = "file.out";
			BufferedWriter out = new BufferedWriter(
				new FileWriter(filename));
            System.out.println("\n*** Tokens guardados en archivo ***\n");
			for(CToken t: this.tokens){
				System.out.println(t);
				out.write(t + "\n");
			}
			out.close();
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CScanner(java.io.Reader in) {
      contador = 0;
	tokens = new ArrayList<CToken>();
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
    while (i < 2654) {
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
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    	try{
		this.writeOutputFile();
        
	}catch(IOException ioe){
		ioe.printStackTrace();
	}

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public CToken nextToken() throws java.io.IOException {
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
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"ID_VAR",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 50: break;
          case 2: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OL_O",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 51: break;
          case 3: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OR_MAYOR_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 52: break;
          case 4: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OR_MENOR_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 53: break;
          case 5: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_ASIGNACION",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 54: break;
          case 6: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"y",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 55: break;
          case 7: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OA_SUMA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 56: break;
          case 8: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OA_RESTA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 57: break;
          case 9: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OA_PRODUCTO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 58: break;
          case 10: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OA_DIVISION",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 59: break;
          case 11: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OA_MODULO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 60: break;
          case 12: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_DOS_PUNTOS",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 61: break;
          case 13: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_PAREN_ABRE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 62: break;
          case 14: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_PAREN_CIERRA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 63: break;
          case 15: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_CORCHETE_ABRE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 64: break;
          case 16: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_CORCHETE_CIERRA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 65: break;
          case 17: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"O_COMA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 66: break;
          case 18: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_ENTERO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 67: break;
          case 19: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_ESPACIO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 68: break;
          case 20: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_FIN_LINEA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 69: break;
          case 21: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OL_NO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 70: break;
          case 22: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_SI",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 71: break;
          case 23: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OR_MAYOR_O_IGUAL_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 72: break;
          case 24: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OR_MENOR_O_IGUAL_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 73: break;
          case 25: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"OR_IGUAL_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 74: break;
          case 26: 
            { contador++;
	CToken t = new CToken(contador, yytext(), "COMENTARIOS", yyline, yycolumn);
	tokens.add(t);
	return t;
            }
          case 75: break;
          case 27: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_CADENA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 76: break;
          case 28: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_FIN",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 77: break;
          case 29: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"VALOR_REAL",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 78: break;
          case 30: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_PARA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 79: break;
          case 31: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_PASO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 80: break;
          case 32: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_REAL",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 81: break;
          case 33: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_ABRE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 82: break;
          case 34: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_LEER",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 83: break;
          case 35: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_SINO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 84: break;
          case 36: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_SEGUN",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 85: break;
          case 37: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_HACER",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 86: break;
          case 38: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_HASTA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 87: break;
          case 39: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_INICIO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 88: break;
          case 40: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_ENTERO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 89: break;
          case 41: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_CADENA", yyline, yycolumn);
    tokens.add(t);
    return t;
            }
          case 90: break;
          case 42: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_CIERRA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 91: break;
          case 43: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_PROGRAMA",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 92: break;
          case 44: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_MIENTRAS",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 93: break;
          case 45: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_VARIABLE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 94: break;
          case 46: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_BOOLEANO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 95: break;
          case 47: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_ESCRIBIR",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 96: break;
          case 48: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_DE_OTRO_MODO",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 97: break;
          case 49: 
            { contador++;
    CToken t = new CToken(contador,yytext(),"PR_MIENTRAS_QUE",yyline,yycolumn);
    tokens.add(t);
    return t;
            }
          case 98: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
