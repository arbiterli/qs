package com.glority.quality.sca.antlr.cpp;

// $ANTLR 3.4 Cpp.g 2012-10-23 16:08:43

  import java.io.File;
  import java.io.IOException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CppLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AMPERSAND=4;
    public static final int AND=5;
    public static final int ARGS=6;
    public static final int ASSIGNEQUAL=7;
    public static final int BITWISEANDEQUAL=8;
    public static final int BITWISEOR=9;
    public static final int BITWISEOREQUAL=10;
    public static final int BITWISEXOR=11;
    public static final int BITWISEXOREQUAL=12;
    public static final int CHARACTER_LITERAL=13;
    public static final int CKEYWORD=14;
    public static final int COLON=15;
    public static final int COMMA=16;
    public static final int COMMENT=17;
    public static final int CONCATENATE=18;
    public static final int COPERATOR=19;
    public static final int DECIMAL_LITERAL=20;
    public static final int DEFINE=21;
    public static final int DEFINED=22;
    public static final int DIRECTIVE=23;
    public static final int DIVIDE=24;
    public static final int DIVIDEEQUAL=25;
    public static final int DOT=26;
    public static final int DOTMBR=27;
    public static final int ELLIPSIS=28;
    public static final int ELSE=29;
    public static final int ENDIF=30;
    public static final int EQUAL=31;
    public static final int ERROR=32;
    public static final int ESCAPED_NEWLINE=33;
    public static final int EXEC_MACRO=34;
    public static final int EXPAND=35;
    public static final int EXPR=36;
    public static final int EXPR_DEF=37;
    public static final int EXPR_GROUP=38;
    public static final int EXPR_NDEF=39;
    public static final int EXP_ARG=40;
    public static final int EXP_ARGS=41;
    public static final int End=42;
    public static final int EscapeSequence=43;
    public static final int Exponent=44;
    public static final int FLOATING_POINT_LITERAL=45;
    public static final int FloatTypeSuffix=46;
    public static final int GREATERTHAN=47;
    public static final int GREATERTHANOREQUALTO=48;
    public static final int HEX_LITERAL=49;
    public static final int HexDigit=50;
    public static final int IDENTIFIER=51;
    public static final int IF=52;
    public static final int IFDEF=53;
    public static final int IFNDEF=54;
    public static final int INCLUDE=55;
    public static final int INCLUDE_EXPAND=56;
    public static final int INCLUDE_FILE=57;
    public static final int INDEX_OP=58;
    public static final int IntegerTypeSuffix=59;
    public static final int LCURLY=60;
    public static final int LESSTHAN=61;
    public static final int LESSTHANOREQUALTO=62;
    public static final int LETTER=63;
    public static final int LINE=64;
    public static final int LINECOMMENTS=65;
    public static final int LINE_COMMENT=66;
    public static final int LPAREN=67;
    public static final int LSQUARE=68;
    public static final int MACRO_DEFINE=69;
    public static final int MACRO_TEXT=70;
    public static final int MAC_FUNCTION=71;
    public static final int MAC_FUNCTION_OBJECT=72;
    public static final int MAC_OBJECT=73;
    public static final int METHOD_CALL=74;
    public static final int MINUS=75;
    public static final int MINUSEQUAL=76;
    public static final int MINUSMINUS=77;
    public static final int MOD=78;
    public static final int MODEQUAL=79;
    public static final int NOT=80;
    public static final int NOTEQUAL=81;
    public static final int OCTAL_LITERAL=82;
    public static final int OR=83;
    public static final int OctalEscape=84;
    public static final int PLUS=85;
    public static final int PLUSEQUAL=86;
    public static final int PLUSPLUS=87;
    public static final int POINTER=88;
    public static final int POINTERTO=89;
    public static final int POINTERTOMBR=90;
    public static final int POINTER_AT=91;
    public static final int POST_DEC=92;
    public static final int POST_INC=93;
    public static final int PRAGMA=94;
    public static final int QUESTIONMARK=95;
    public static final int RCURLY=96;
    public static final int REFERANCE=97;
    public static final int RPAREN=98;
    public static final int RSQUARE=99;
    public static final int SCOPE=100;
    public static final int SEMICOLON=101;
    public static final int SHARPSHARP=102;
    public static final int SHIFTLEFT=103;
    public static final int SHIFTLEFTEQUAL=104;
    public static final int SHIFTRIGHT=105;
    public static final int SHIFTRIGHTEQUAL=106;
    public static final int SIZEOF=107;
    public static final int SIZEOF_TYPE=108;
    public static final int STAR=109;
    public static final int STRINGIFICATION=110;
    public static final int STRING_LITERAL=111;
    public static final int STRING_OP=112;
    public static final int TEXT_END=113;
    public static final int TEXT_GROUP=114;
    public static final int TEXT_LINE=115;
    public static final int TILDE=116;
    public static final int TIMESEQUAL=117;
    public static final int TYPECAST=118;
    public static final int UNARY_MINUS=119;
    public static final int UNARY_PLUS=120;
    public static final int UNDEF=121;
    public static final int UnicodeEscape=122;
    public static final int WARNING=123;
    public static final int WS=124;

      boolean inDirective =false;
      boolean inDefineMode=false;
      boolean discardSpace=true;
      int   ltoken=End;
      static char cpp = 'X';
      static String [] includeSearchPaths = 
      { "/usr/local/include", 
        "/usr/lib/gcc/i386-redhat-linux/4.0.0/include",
        "/usr/include/linux/stddef.h",
       "/usr/include" };


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CppLexer() {} 
    public CppLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CppLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Cpp.g"; }

    // $ANTLR start "STRING_OP"
    public final void mSTRING_OP() throws RecognitionException {
        try {
            int _type = STRING_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken id=null;

            // Cpp.g:302:10: ({...}? '#' ( WS )? id= IDENTIFIER )
            // Cpp.g:302:14: {...}? '#' ( WS )? id= IDENTIFIER
            {
            if ( !((inDefineMode)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "STRING_OP", "inDefineMode");
            }

            match('#'); if (state.failed) return ;

            // Cpp.g:302:34: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\t'||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // Cpp.g:302:34: WS
                    {
                    mWS(); if (state.failed) return ;


                    }
                    break;

            }


            int idStart34 = getCharIndex();
            int idStartLine34 = getLine();
            int idStartCharPos34 = getCharPositionInLine();
            mIDENTIFIER(); if (state.failed) return ;


            if ( state.backtracking==0 ) {}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_OP"

    // $ANTLR start "DIRECTIVE"
    public final void mDIRECTIVE() throws RecognitionException {
        try {
            int _type = DIRECTIVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken f=null;
            CommonToken m=null;


              File  sourceFile = null;
              File  currentDirectory=null;
              String  includeFile = null; 

            // Cpp.g:313:5: ({...}? '#' ( WS )? ( 'line' | 'undef' WS | 'define' WS | 'exec_macro_expression' | ( 'include' | 'include_next' ) WS f= IDENTIFIER | ( 'include' | 'include_next' ) WS f= INCLUDE_FILE | 'warning' m= MACRO_TEXT | 'error' (m= MACRO_TEXT )? | 'pragma' m= MACRO_TEXT |) )
            // Cpp.g:313:7: {...}? '#' ( WS )? ( 'line' | 'undef' WS | 'define' WS | 'exec_macro_expression' | ( 'include' | 'include_next' ) WS f= IDENTIFIER | ( 'include' | 'include_next' ) WS f= INCLUDE_FILE | 'warning' m= MACRO_TEXT | 'error' (m= MACRO_TEXT )? | 'pragma' m= MACRO_TEXT |)
            {
            if ( !((!inDirective && !inDefineMode)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "DIRECTIVE", "!inDirective && !inDefineMode");
            }

            match('#'); if (state.failed) return ;

            if ( state.backtracking==0 ) {inDirective=true; cpp='X'; discardSpace=false;}

            // Cpp.g:313:96: ( WS )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\t'||(LA2_0 >= '\f' && LA2_0 <= '\r')||LA2_0==' ') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Cpp.g:313:96: WS
                    {
                    mWS(); if (state.failed) return ;


                    }
                    break;

            }


            // Cpp.g:314:5: ( 'line' | 'undef' WS | 'define' WS | 'exec_macro_expression' | ( 'include' | 'include_next' ) WS f= IDENTIFIER | ( 'include' | 'include_next' ) WS f= INCLUDE_FILE | 'warning' m= MACRO_TEXT | 'error' (m= MACRO_TEXT )? | 'pragma' m= MACRO_TEXT |)
            int alt6=10;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // Cpp.g:315:9: 'line'
                    {
                    match("line"); if (state.failed) return ;



                    if ( state.backtracking==0 ) { _type = LINE;   discardSpace=true;}

                    }
                    break;
                case 2 :
                    // Cpp.g:316:9: 'undef' WS
                    {
                    match("undef"); if (state.failed) return ;



                    mWS(); if (state.failed) return ;


                    if ( state.backtracking==0 ) { _type = UNDEF;  discardSpace=true;}

                    }
                    break;
                case 3 :
                    // Cpp.g:317:9: 'define' WS
                    {
                    match("define"); if (state.failed) return ;



                    mWS(); if (state.failed) return ;


                    if ( state.backtracking==0 ) { _type = DEFINE; cpp = 'D'; discardSpace=false;  }

                    }
                    break;
                case 4 :
                    // Cpp.g:318:9: 'exec_macro_expression'
                    {
                    match("exec_macro_expression"); if (state.failed) return ;



                    if ( state.backtracking==0 ) {_type=EXEC_MACRO;discardSpace=true;}

                    }
                    break;
                case 10 :
                    // Cpp.g:335:7: 
                    {
                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIRECTIVE"

    // $ANTLR start "MACRO_TEXT"
    public final void mMACRO_TEXT() throws RecognitionException {
        try {
            // Cpp.g:339:9: ( ( ( '/*' )=> '/*' ( options {greedy=false; } : . )* '*/' | ( '\\\\\\n' )=> ( '\\\\\\n' ) | ( '\\\\\\r\\n' )=> ( '\\\\\\n' ) |~ '\\n' )+ )
            // Cpp.g:339:17: ( ( '/*' )=> '/*' ( options {greedy=false; } : . )* '*/' | ( '\\\\\\n' )=> ( '\\\\\\n' ) | ( '\\\\\\r\\n' )=> ( '\\\\\\n' ) |~ '\\n' )+
            {
            // Cpp.g:339:17: ( ( '/*' )=> '/*' ( options {greedy=false; } : . )* '*/' | ( '\\\\\\n' )=> ( '\\\\\\n' ) | ( '\\\\\\r\\n' )=> ( '\\\\\\n' ) |~ '\\n' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=5;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // Cpp.g:339:21: ( '/*' )=> '/*' ( options {greedy=false; } : . )* '*/'
            	    {
            	    match("/*"); if (state.failed) return ;



            	    // Cpp.g:339:38: ( options {greedy=false; } : . )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0=='*') ) {
            	            int LA7_1 = input.LA(2);

            	            if ( (LA7_1=='/') ) {
            	                alt7=2;
            	            }
            	            else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
            	                alt7=1;
            	            }


            	        }
            	        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // Cpp.g:339:64: .
            	    	    {
            	    	    matchAny(); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    match("*/"); if (state.failed) return ;



            	    }
            	    break;
            	case 2 :
            	    // Cpp.g:340:17: ( '\\\\\\n' )=> ( '\\\\\\n' )
            	    {
            	    // Cpp.g:340:29: ( '\\\\\\n' )
            	    // Cpp.g:340:30: '\\\\\\n'
            	    {
            	    match("\\\n"); if (state.failed) return ;



            	    }


            	    }
            	    break;
            	case 3 :
            	    // Cpp.g:341:17: ( '\\\\\\r\\n' )=> ( '\\\\\\n' )
            	    {
            	    // Cpp.g:341:31: ( '\\\\\\n' )
            	    // Cpp.g:341:32: '\\\\\\n'
            	    {
            	    match("\\\n"); if (state.failed) return ;



            	    }


            	    }
            	    break;
            	case 4 :
            	    // Cpp.g:342:17: ~ '\\n'
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MACRO_TEXT"

    // $ANTLR start "SIZEOF"
    public final void mSIZEOF() throws RecognitionException {
        try {
            int _type = SIZEOF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:346:9: ( 'sizeof' )
            // Cpp.g:346:11: 'sizeof'
            {
            match("sizeof"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SIZEOF"

    // $ANTLR start "DEFINED"
    public final void mDEFINED() throws RecognitionException {
        try {
            int _type = DEFINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:349:9: ( 'defined' )
            // Cpp.g:349:11: 'defined'
            {
            match("defined"); if (state.failed) return ;



            if ( state.backtracking==0 ) { 
                    if(!inDirective)
                    _type = CKEYWORD;
                  }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFINED"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:357:5: ( ( '#' )? LETTER ( LETTER | '0' .. '9' )* )
            // Cpp.g:357:7: ( '#' )? LETTER ( LETTER | '0' .. '9' )*
            {
            // Cpp.g:357:7: ( '#' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='#') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Cpp.g:357:7: '#'
                    {
                    match('#'); if (state.failed) return ;

                    }
                    break;

            }


            mLETTER(); if (state.failed) return ;


            // Cpp.g:357:19: ( LETTER | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='$'||(LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Cpp.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                    if(inDirective == true)
                    {
                      if(cpp == 'D') 
                      {
                        if(input.LA(1) != '(' )
                        {
                          inDefineMode= true; 
                          inDirective = false; 
                          cpp = 'X';
                        }
                        else 
                        {  
                          cpp = '('; 
                        }
                      }
                    }
                  }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Cpp.g:380:9: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // Cpp.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "STRINGIFICATION"
    public final void mSTRINGIFICATION() throws RecognitionException {
        try {
            int _type = STRINGIFICATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:387:17: ( '#_#_' )
            // Cpp.g:387:19: '#_#_'
            {
            match("#_#_"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRINGIFICATION"

    // $ANTLR start "SHARPSHARP"
    public final void mSHARPSHARP() throws RecognitionException {
        try {
            int _type = SHARPSHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:390:15: ( '##' )
            // Cpp.g:390:17: '##'
            {
            match("##"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHARPSHARP"

    // $ANTLR start "ASSIGNEQUAL"
    public final void mASSIGNEQUAL() throws RecognitionException {
        try {
            int _type = ASSIGNEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:392:15: ( '=' )
            // Cpp.g:392:17: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGNEQUAL"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:394:11: ( ':' )
            // Cpp.g:394:13: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:396:11: ( ',' )
            // Cpp.g:396:13: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "QUESTIONMARK"
    public final void mQUESTIONMARK() throws RecognitionException {
        try {
            int _type = QUESTIONMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:398:15: ( '?' )
            // Cpp.g:398:17: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUESTIONMARK"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:400:13: ( ';' )
            // Cpp.g:400:15: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "POINTERTO"
    public final void mPOINTERTO() throws RecognitionException {
        try {
            int _type = POINTERTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:402:13: ( '->' )
            // Cpp.g:402:15: '->'
            {
            match("->"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POINTERTO"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:404:13: ( '(' )
            // Cpp.g:404:15: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:406:9: ( ')' )
            // Cpp.g:406:11: ')'
            {
            match(')'); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                    if(cpp=='(')
                    {
                      if(input.LA(1) != '\n')
                      {
                        inDefineMode = true; 
                        inDirective = false; 
                      }
                      cpp ='X';
                    }
                  }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:420:13: ( '[' )
            // Cpp.g:420:15: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:422:13: ( ']' )
            // Cpp.g:422:15: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:424:13: ( '{' )
            // Cpp.g:424:15: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:426:13: ( '}' )
            // Cpp.g:426:15: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:428:11: ( '==' )
            // Cpp.g:428:13: '=='
            {
            match("=="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOTEQUAL"
    public final void mNOTEQUAL() throws RecognitionException {
        try {
            int _type = NOTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:430:13: ( '!=' )
            // Cpp.g:430:15: '!='
            {
            match("!="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOTEQUAL"

    // $ANTLR start "LESSTHANOREQUALTO"
    public final void mLESSTHANOREQUALTO() throws RecognitionException {
        try {
            int _type = LESSTHANOREQUALTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:433:9: ( '<=' )
            // Cpp.g:433:11: '<='
            {
            match("<="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESSTHANOREQUALTO"

    // $ANTLR start "LESSTHAN"
    public final void mLESSTHAN() throws RecognitionException {
        try {
            int _type = LESSTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:435:13: ( '<' )
            // Cpp.g:435:15: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESSTHAN"

    // $ANTLR start "GREATERTHANOREQUALTO"
    public final void mGREATERTHANOREQUALTO() throws RecognitionException {
        try {
            int _type = GREATERTHANOREQUALTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:438:9: ( '>=' )
            // Cpp.g:438:11: '>='
            {
            match(">="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATERTHANOREQUALTO"

    // $ANTLR start "GREATERTHAN"
    public final void mGREATERTHAN() throws RecognitionException {
        try {
            int _type = GREATERTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:440:15: ( '>' )
            // Cpp.g:440:17: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATERTHAN"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:442:13: ( '/' )
            // Cpp.g:442:15: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "DIVIDEEQUAL"
    public final void mDIVIDEEQUAL() throws RecognitionException {
        try {
            int _type = DIVIDEEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:444:15: ( '/=' )
            // Cpp.g:444:17: '/='
            {
            match("/="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDEEQUAL"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:446:11: ( '+' )
            // Cpp.g:446:13: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "PLUSEQUAL"
    public final void mPLUSEQUAL() throws RecognitionException {
        try {
            int _type = PLUSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:448:13: ( '+=' )
            // Cpp.g:448:15: '+='
            {
            match("+="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUSEQUAL"

    // $ANTLR start "PLUSPLUS"
    public final void mPLUSPLUS() throws RecognitionException {
        try {
            int _type = PLUSPLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:450:13: ( '++' )
            // Cpp.g:450:15: '++'
            {
            match("++"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUSPLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:452:11: ( '-' )
            // Cpp.g:452:13: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MINUSEQUAL"
    public final void mMINUSEQUAL() throws RecognitionException {
        try {
            int _type = MINUSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:454:15: ( '-=' )
            // Cpp.g:454:17: '-='
            {
            match("-="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUSEQUAL"

    // $ANTLR start "MINUSMINUS"
    public final void mMINUSMINUS() throws RecognitionException {
        try {
            int _type = MINUSMINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:456:15: ( '--' )
            // Cpp.g:456:17: '--'
            {
            match("--"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUSMINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:458:11: ( '*' )
            // Cpp.g:458:13: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "TIMESEQUAL"
    public final void mTIMESEQUAL() throws RecognitionException {
        try {
            int _type = TIMESEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:460:15: ( '*=' )
            // Cpp.g:460:17: '*='
            {
            match("*="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TIMESEQUAL"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:462:11: ( '%' )
            // Cpp.g:462:13: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "MODEQUAL"
    public final void mMODEQUAL() throws RecognitionException {
        try {
            int _type = MODEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:464:13: ( '%=' )
            // Cpp.g:464:15: '%='
            {
            match("%="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MODEQUAL"

    // $ANTLR start "SHIFTRIGHT"
    public final void mSHIFTRIGHT() throws RecognitionException {
        try {
            int _type = SHIFTRIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:466:15: ( '>>' )
            // Cpp.g:466:17: '>>'
            {
            match(">>"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIFTRIGHT"

    // $ANTLR start "SHIFTRIGHTEQUAL"
    public final void mSHIFTRIGHTEQUAL() throws RecognitionException {
        try {
            int _type = SHIFTRIGHTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:468:17: ( '>>=' )
            // Cpp.g:468:19: '>>='
            {
            match(">>="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIFTRIGHTEQUAL"

    // $ANTLR start "SHIFTLEFT"
    public final void mSHIFTLEFT() throws RecognitionException {
        try {
            int _type = SHIFTLEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:470:13: ( '<<' )
            // Cpp.g:470:15: '<<'
            {
            match("<<"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIFTLEFT"

    // $ANTLR start "SHIFTLEFTEQUAL"
    public final void mSHIFTLEFTEQUAL() throws RecognitionException {
        try {
            int _type = SHIFTLEFTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:472:17: ( '<<=' )
            // Cpp.g:472:19: '<<='
            {
            match("<<="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIFTLEFTEQUAL"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:474:11: ( '&&' )
            // Cpp.g:474:13: '&&'
            {
            match("&&"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:476:11: ( '!' )
            // Cpp.g:476:13: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:478:11: ( '||' )
            // Cpp.g:478:13: '||'
            {
            match("||"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:480:13: ( '&' )
            // Cpp.g:480:15: '&'
            {
            match('&'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "BITWISEANDEQUAL"
    public final void mBITWISEANDEQUAL() throws RecognitionException {
        try {
            int _type = BITWISEANDEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:482:17: ( '&=' )
            // Cpp.g:482:19: '&='
            {
            match("&="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BITWISEANDEQUAL"

    // $ANTLR start "TILDE"
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:484:11: ( '~' )
            // Cpp.g:484:13: '~'
            {
            match('~'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TILDE"

    // $ANTLR start "BITWISEOR"
    public final void mBITWISEOR() throws RecognitionException {
        try {
            int _type = BITWISEOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:486:13: ( '|' )
            // Cpp.g:486:15: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BITWISEOR"

    // $ANTLR start "BITWISEOREQUAL"
    public final void mBITWISEOREQUAL() throws RecognitionException {
        try {
            int _type = BITWISEOREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:488:17: ( '|=' )
            // Cpp.g:488:19: '|='
            {
            match("|="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BITWISEOREQUAL"

    // $ANTLR start "BITWISEXOR"
    public final void mBITWISEXOR() throws RecognitionException {
        try {
            int _type = BITWISEXOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:490:15: ( '^' )
            // Cpp.g:490:17: '^'
            {
            match('^'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BITWISEXOR"

    // $ANTLR start "BITWISEXOREQUAL"
    public final void mBITWISEXOREQUAL() throws RecognitionException {
        try {
            int _type = BITWISEXOREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:492:17: ( '^=' )
            // Cpp.g:492:19: '^='
            {
            match("^="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BITWISEXOREQUAL"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:494:11: ( '.' )
            // Cpp.g:494:13: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "POINTERTOMBR"
    public final void mPOINTERTOMBR() throws RecognitionException {
        try {
            int _type = POINTERTOMBR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:496:15: ( '->*' )
            // Cpp.g:496:17: '->*'
            {
            match("->*"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POINTERTOMBR"

    // $ANTLR start "DOTMBR"
    public final void mDOTMBR() throws RecognitionException {
        try {
            int _type = DOTMBR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:498:13: ( '.*' )
            // Cpp.g:498:15: '.*'
            {
            match(".*"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOTMBR"

    // $ANTLR start "SCOPE"
    public final void mSCOPE() throws RecognitionException {
        try {
            int _type = SCOPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:500:11: ( '::' )
            // Cpp.g:500:13: '::'
            {
            match("::"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SCOPE"

    // $ANTLR start "ELLIPSIS"
    public final void mELLIPSIS() throws RecognitionException {
        try {
            int _type = ELLIPSIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:502:13: ( '...' )
            // Cpp.g:502:15: '...'
            {
            match("..."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELLIPSIS"

    // $ANTLR start "INCLUDE_FILE"
    public final void mINCLUDE_FILE() throws RecognitionException {
        try {
            // Cpp.g:507:5: ( '<' ( ' ' | '!' | '#' .. ';' | '=' | '?' .. '[' | ']' .. '\\u00FF' )+ '>' | '\"' ( ' ' | '!' | '#' .. ';' | '=' | '?' .. '[' | ']' .. '\\u00FF' )+ '\"' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='<') ) {
                alt13=1;
            }
            else if ( (LA13_0=='\"') ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // Cpp.g:507:7: '<' ( ' ' | '!' | '#' .. ';' | '=' | '?' .. '[' | ']' .. '\\u00FF' )+ '>'
                    {
                    match('<'); if (state.failed) return ;

                    // Cpp.g:507:11: ( ' ' | '!' | '#' .. ';' | '=' | '?' .. '[' | ']' .. '\\u00FF' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= ' ' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= ';')||LA11_0=='='||(LA11_0 >= '?' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\u00FF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= ';')||input.LA(1)=='='||(input.LA(1) >= '?' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\u00FF') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    match('>'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Cpp.g:508:11: '\"' ( ' ' | '!' | '#' .. ';' | '=' | '?' .. '[' | ']' .. '\\u00FF' )+ '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    // Cpp.g:508:15: ( ' ' | '!' | '#' .. ';' | '=' | '?' .. '[' | ']' .. '\\u00FF' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= ' ' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= ';')||LA12_0=='='||(LA12_0 >= '?' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\u00FF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= ';')||input.LA(1)=='='||(input.LA(1) >= '?' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\u00FF') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    match('\"'); if (state.failed) return ;

                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INCLUDE_FILE"

    // $ANTLR start "CHARACTER_LITERAL"
    public final void mCHARACTER_LITERAL() throws RecognitionException {
        try {
            int _type = CHARACTER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:511:5: ( ( 'L' )? '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // Cpp.g:511:7: ( 'L' )? '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            // Cpp.g:511:7: ( 'L' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='L') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Cpp.g:511:8: 'L'
                    {
                    match('L'); if (state.failed) return ;

                    }
                    break;

            }


            match('\''); if (state.failed) return ;

            // Cpp.g:511:19: ( EscapeSequence |~ ( '\\'' | '\\\\' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\\') ) {
                alt15=1;
            }
            else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '&')||(LA15_0 >= '(' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // Cpp.g:511:21: EscapeSequence
                    {
                    mEscapeSequence(); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // Cpp.g:511:38: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARACTER_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:518:11: ( ( 'L' )? '\"' ( EscapeSequence |~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )* '\"' )
            // Cpp.g:518:18: ( 'L' )? '\"' ( EscapeSequence |~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )* '\"'
            {
            // Cpp.g:518:18: ( 'L' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='L') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Cpp.g:518:19: 'L'
                    {
                    match('L'); if (state.failed) return ;

                    }
                    break;

            }


            match('\"'); if (state.failed) return ;

            // Cpp.g:519:12: ( EscapeSequence |~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\\') ) {
                    alt17=1;
                }
                else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '\t')||(LA17_0 >= '\u000B' && LA17_0 <= '\f')||(LA17_0 >= '\u000E' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= '[')||(LA17_0 >= ']' && LA17_0 <= '\uFFFF')) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // Cpp.g:519:13: EscapeSequence
            	    {
            	    mEscapeSequence(); if (state.failed) return ;


            	    }
            	    break;
            	case 2 :
            	    // Cpp.g:519:30: ~ ( '\"' | '\\\\' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "HEX_LITERAL"
    public final void mHEX_LITERAL() throws RecognitionException {
        try {
            int _type = HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:522:5: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // Cpp.g:522:7: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); if (state.failed) return ;

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Cpp.g:522:21: ( HexDigit )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')||(LA18_0 >= 'A' && LA18_0 <= 'F')||(LA18_0 >= 'a' && LA18_0 <= 'f')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Cpp.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            // Cpp.g:522:31: ( IntegerTypeSuffix )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='L'||LA19_0=='U'||LA19_0=='l'||LA19_0=='u') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Cpp.g:522:31: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_LITERAL"

    // $ANTLR start "DECIMAL_LITERAL"
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:526:5: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // Cpp.g:526:7: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // Cpp.g:526:7: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='0') ) {
                alt21=1;
            }
            else if ( ((LA21_0 >= '1' && LA21_0 <= '9')) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // Cpp.g:526:8: '0'
                    {
                    match('0'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Cpp.g:526:14: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); if (state.failed) return ;

                    // Cpp.g:526:23: ( '0' .. '9' )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }


            // Cpp.g:526:34: ( IntegerTypeSuffix )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='L'||LA22_0=='U'||LA22_0=='l'||LA22_0=='u') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Cpp.g:526:34: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL_LITERAL"

    // $ANTLR start "OCTAL_LITERAL"
    public final void mOCTAL_LITERAL() throws RecognitionException {
        try {
            int _type = OCTAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:530:5: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // Cpp.g:530:7: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); if (state.failed) return ;

            // Cpp.g:530:11: ( '0' .. '7' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= '0' && LA23_0 <= '7')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Cpp.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            // Cpp.g:530:23: ( IntegerTypeSuffix )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='L'||LA24_0=='U'||LA24_0=='l'||LA24_0=='u') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Cpp.g:530:23: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_LITERAL"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // Cpp.g:534:5: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // Cpp.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "IntegerTypeSuffix"
    public final void mIntegerTypeSuffix() throws RecognitionException {
        try {
            // Cpp.g:538:5: ( 'u' | 'ul' | 'U' | 'UL' | 'l' | 'L' )
            int alt25=6;
            switch ( input.LA(1) ) {
            case 'u':
                {
                int LA25_1 = input.LA(2);

                if ( (LA25_1=='l') ) {
                    alt25=2;
                }
                else {
                    alt25=1;
                }
                }
                break;
            case 'U':
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2=='L') ) {
                    alt25=4;
                }
                else {
                    alt25=3;
                }
                }
                break;
            case 'l':
                {
                alt25=5;
                }
                break;
            case 'L':
                {
                alt25=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // Cpp.g:538:7: 'u'
                    {
                    match('u'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Cpp.g:538:13: 'ul'
                    {
                    match("ul"); if (state.failed) return ;



                    }
                    break;
                case 3 :
                    // Cpp.g:538:20: 'U'
                    {
                    match('U'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // Cpp.g:538:26: 'UL'
                    {
                    match("UL"); if (state.failed) return ;



                    }
                    break;
                case 5 :
                    // Cpp.g:538:33: 'l'
                    {
                    match('l'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // Cpp.g:538:39: 'L'
                    {
                    match('L'); if (state.failed) return ;

                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IntegerTypeSuffix"

    // $ANTLR start "FLOATING_POINT_LITERAL"
    public final void mFLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOATING_POINT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:542:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix )
            int alt36=4;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // Cpp.g:542:7: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // Cpp.g:542:7: ( '0' .. '9' )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0 >= '0' && LA26_0 <= '9')) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    match('.'); if (state.failed) return ;

                    // Cpp.g:542:23: ( '0' .. '9' )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0 >= '0' && LA27_0 <= '9')) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    // Cpp.g:542:35: ( Exponent )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='E'||LA28_0=='e') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // Cpp.g:542:35: Exponent
                            {
                            mExponent(); if (state.failed) return ;


                            }
                            break;

                    }


                    // Cpp.g:542:45: ( FloatTypeSuffix )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0=='D'||LA29_0=='F'||LA29_0=='d'||LA29_0=='f') ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // Cpp.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // Cpp.g:543:7: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); if (state.failed) return ;

                    // Cpp.g:543:11: ( '0' .. '9' )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0 >= '0' && LA30_0 <= '9')) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);


                    // Cpp.g:543:23: ( Exponent )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0=='E'||LA31_0=='e') ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // Cpp.g:543:23: Exponent
                            {
                            mExponent(); if (state.failed) return ;


                            }
                            break;

                    }


                    // Cpp.g:543:33: ( FloatTypeSuffix )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0=='D'||LA32_0=='F'||LA32_0=='d'||LA32_0=='f') ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // Cpp.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // Cpp.g:544:7: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                    {
                    // Cpp.g:544:7: ( '0' .. '9' )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0 >= '0' && LA33_0 <= '9')) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    mExponent(); if (state.failed) return ;


                    // Cpp.g:544:28: ( FloatTypeSuffix )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0=='D'||LA34_0=='F'||LA34_0=='d'||LA34_0=='f') ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // Cpp.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // Cpp.g:545:7: ( '0' .. '9' )+ FloatTypeSuffix
                    {
                    // Cpp.g:545:7: ( '0' .. '9' )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( ((LA35_0 >= '0' && LA35_0 <= '9')) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);


                    mFloatTypeSuffix(); if (state.failed) return ;


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATING_POINT_LITERAL"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // Cpp.g:549:5: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // Cpp.g:549:7: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Cpp.g:549:17: ( '+' | '-' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0=='+'||LA37_0=='-') ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // Cpp.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // Cpp.g:549:28: ( '0' .. '9' )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0 >= '0' && LA38_0 <= '9')) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Cpp.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatTypeSuffix"
    public final void mFloatTypeSuffix() throws RecognitionException {
        try {
            // Cpp.g:553:5: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // Cpp.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FloatTypeSuffix"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // Cpp.g:557:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'v' | '\\\"' | '\\'' | '\\\\' ) | '\\\\' 'x' ( HexDigit )+ | OctalEscape )
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '.':
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                case 'v':
                case 'a':
                case 'c':
                case 'd':
                case 'e':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'z':
                case 'o':
                case 'p':
                case 'q':
                case 's':
                case 'u':
                case 'w':
                case 'y':
                case 'B':
                case 'F':
                case 'N':
                case 'R':
                case 'T':
                case 'V':
                case 'A':
                case 'C':
                case 'D':
                case 'E':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'Z':
                case 'O':
                case 'P':
                case 'Q':
                case 'S':
                case 'U':
                case 'W':
                case 'Y':
                case 'X':
                    {
                    alt40=1;
                    }
                    break;
                case 'x':
                    {
                    alt40=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt40=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // Cpp.g:557:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'v' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='A' && input.LA(1)<='Z'||input.LA(1)=='.')) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // Cpp.g:558:7: '\\\\' 'x' ( HexDigit )+
                    {
                    match('\\'); if (state.failed) return ;

                    match('x'); if (state.failed) return ;

                    // Cpp.g:558:16: ( HexDigit )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( ((LA39_0 >= '0' && LA39_0 <= '9')||(LA39_0 >= 'A' && LA39_0 <= 'F')||(LA39_0 >= 'a' && LA39_0 <= 'f')) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // Cpp.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                    	        input.consume();
                    	        state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // Cpp.g:559:9: OctalEscape
                    {
                    mOctalEscape(); if (state.failed) return ;


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // Cpp.g:563:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt41=3;
            int LA41_0 = input.LA(1);

            if ( (LA41_0=='\\') ) {
                int LA41_1 = input.LA(2);

                if ( ((LA41_1 >= '0' && LA41_1 <= '3')) ) {
                    int LA41_2 = input.LA(3);

                    if ( ((LA41_2 >= '0' && LA41_2 <= '7')) ) {
                        int LA41_4 = input.LA(4);

                        if ( ((LA41_4 >= '0' && LA41_4 <= '7')) ) {
                            alt41=1;
                        }
                        else {
                            alt41=2;
                        }
                    }
                    else {
                        alt41=3;
                    }
                }
                else if ( ((LA41_1 >= '4' && LA41_1 <= '7')) ) {
                    int LA41_3 = input.LA(3);

                    if ( ((LA41_3 >= '0' && LA41_3 <= '7')) ) {
                        alt41=2;
                    }
                    else {
                        alt41=3;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // Cpp.g:563:7: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // Cpp.g:564:7: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // Cpp.g:565:7: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); if (state.failed) return ;

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // Cpp.g:569:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // Cpp.g:569:7: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); if (state.failed) return ;

            match('u'); if (state.failed) return ;

            mHexDigit(); if (state.failed) return ;


            mHexDigit(); if (state.failed) return ;


            mHexDigit(); if (state.failed) return ;


            mHexDigit(); if (state.failed) return ;


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:573:5: ( '/*' ( options {greedy=false; } : . )* '*/' | '/' '\\\\' '\\n' '*' ( options {greedy=false; } : . )* '*/' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0=='/') ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1=='*') ) {
                    alt44=1;
                }
                else if ( (LA44_1=='\\') ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // Cpp.g:573:7: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); if (state.failed) return ;



                    // Cpp.g:573:13: ( options {greedy=false; } : . )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0=='*') ) {
                            int LA42_1 = input.LA(2);

                            if ( (LA42_1=='/') ) {
                                alt42=2;
                            }
                            else if ( ((LA42_1 >= '\u0000' && LA42_1 <= '.')||(LA42_1 >= '0' && LA42_1 <= '\uFFFF')) ) {
                                alt42=1;
                            }


                        }
                        else if ( ((LA42_0 >= '\u0000' && LA42_0 <= ')')||(LA42_0 >= '+' && LA42_0 <= '\uFFFF')) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // Cpp.g:573:39: .
                    	    {
                    	    matchAny(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    match("*/"); if (state.failed) return ;



                    if ( state.backtracking==0 ) {_channel=99;}

                    }
                    break;
                case 2 :
                    // Cpp.g:574:7: '/' '\\\\' '\\n' '*' ( options {greedy=false; } : . )* '*/'
                    {
                    match('/'); if (state.failed) return ;

                    match('\\'); if (state.failed) return ;

                    match('\n'); if (state.failed) return ;

                    match('*'); if (state.failed) return ;

                    // Cpp.g:574:26: ( options {greedy=false; } : . )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0=='*') ) {
                            int LA43_1 = input.LA(2);

                            if ( (LA43_1=='/') ) {
                                alt43=2;
                            }
                            else if ( ((LA43_1 >= '\u0000' && LA43_1 <= '.')||(LA43_1 >= '0' && LA43_1 <= '\uFFFF')) ) {
                                alt43=1;
                            }


                        }
                        else if ( ((LA43_0 >= '\u0000' && LA43_0 <= ')')||(LA43_0 >= '+' && LA43_0 <= '\uFFFF')) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // Cpp.g:574:52: .
                    	    {
                    	    matchAny(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    match("*/"); if (state.failed) return ;



                    if ( state.backtracking==0 ) {_channel=99;}

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:578:6: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' | EOF ) )
            // Cpp.g:578:8: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' | EOF )
            {
            match("//"); if (state.failed) return ;



            // Cpp.g:578:13: (~ ( '\\n' | '\\r' ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0 >= '\u0000' && LA45_0 <= '\t')||(LA45_0 >= '\u000B' && LA45_0 <= '\f')||(LA45_0 >= '\u000E' && LA45_0 <= '\uFFFF')) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // Cpp.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            // Cpp.g:578:27: ( '\\r' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0=='\r') ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // Cpp.g:578:27: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;

            }


            // Cpp.g:578:33: ( '\\n' | EOF )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0=='\n') ) {
                alt47=1;
            }
            else {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // Cpp.g:578:34: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Cpp.g:578:39: EOF
                    {
                    match(EOF); if (state.failed) return ;


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                  if(!inDirective)
                  {
                    try{          
                        if(input.LT(1) != '#' && input.LT(1) != -1 )
                        {
                          _type = LINECOMMENTS;
                        }
                        else
                        {
                          _type = End;
                        }
                    }
                    catch(Exception e)
                    {
                      _type = End;
                    }
                  }
                  else
                  {
                     _type=End;
                  }

                  inDirective=false;
                  inDefineMode=false;
                  discardSpace = true;
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:608:7: ( ( ' ' | '\\r' | '\\t' | '\\f' )+ )
            // Cpp.g:609:5: ( ' ' | '\\r' | '\\t' | '\\f' )+
            {
            if ( state.backtracking==0 ) { 
                  if( this.getLine() != 1)
                  {
                    if(input.LA(-1) == '\n')
                      ltoken = End;
                    else
                      ltoken = input.LA(-1);
                  }
                  else
                  {
                    try
                    {
                      if(input.LA(-1) == '\n')
                        ltoken = End;
                      else
                        ltoken = input.LA(-1);  
                    }
                    catch (Exception e)
                    {
                      ltoken = End;
                    }
                  }

                }

            // Cpp.g:633:5: ( ' ' | '\\r' | '\\t' | '\\f' )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0=='\t'||(LA48_0 >= '\f' && LA48_0 <= '\r')||LA48_0==' ') ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // Cpp.g:
            	    {
            	    if ( input.LA(1)=='\t'||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);


            if ( state.backtracking==0 ) {      
                  if(inDirective ==  true)
                  {
                    if(discardSpace == true)
                    {
                      _channel = 99;
                    }
                    else
                    {
                      _type = WS;
                    }
                  }
                  else
                  {
                    if(!inDefineMode)
                    {
                      try
                      {
                        if(input.LA(1) != EOF  && input.LA(1) == '#' &&   ltoken == End )
                        {
                          _type = End;
                        }
                      }
                      catch (Exception e)
                      {
                        _channel = 99;
                      }
                    }
                  }
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "End"
    public final void mEnd() throws RecognitionException {
        try {
            int _type = End;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:670:7: ( ( WS )? '\\n' )
            // Cpp.g:670:9: ( WS )? '\\n'
            {
            // Cpp.g:670:9: ( WS )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0=='\t'||(LA49_0 >= '\f' && LA49_0 <= '\r')||LA49_0==' ') ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // Cpp.g:670:9: WS
                    {
                    mWS(); if (state.failed) return ;


                    }
                    break;

            }


            match('\n'); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                  if(!inDirective)
                  {
                    if(inDefineMode) 
                    {
                      _type=End;
                    }
                    else
                    {
                        try{          
                            if(input.LT(1) != '#' && input.LT(1) != -1 )
                            {
                              _type = TEXT_END;
                            }
                        }
                        catch(Exception e)
                        {
                          _type = End;
                        }
                    }
                  } else {_type=End;}
                  ltoken =End;  
                  inDirective=false;
                  inDefineMode=false;
                  discardSpace=true;
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "End"

    // $ANTLR start "ESCAPED_NEWLINE"
    public final void mESCAPED_NEWLINE() throws RecognitionException {
        try {
            int _type = ESCAPED_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:700:5: ( ( '\\\\\\n' | '\\\\\\r\\n' ) )
            // Cpp.g:700:7: ( '\\\\\\n' | '\\\\\\r\\n' )
            {
            // Cpp.g:700:7: ( '\\\\\\n' | '\\\\\\r\\n' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0=='\\') ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1=='\n') ) {
                    alt50=1;
                }
                else if ( (LA50_1=='\r') ) {
                    alt50=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }
            switch (alt50) {
                case 1 :
                    // Cpp.g:700:8: '\\\\\\n'
                    {
                    match("\\\n"); if (state.failed) return ;



                    }
                    break;
                case 2 :
                    // Cpp.g:700:17: '\\\\\\r\\n'
                    {
                    match("\\\r\n"); if (state.failed) return ;



                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                  _channel=99;
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESCAPED_NEWLINE"

    // $ANTLR start "COPERATOR"
    public final void mCOPERATOR() throws RecognitionException {
        try {
            int _type = COPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:707:5: ({...}? ( COLON | QUESTIONMARK | POINTERTO | LCURLY | RCURLY | LSQUARE | RSQUARE | STAR | EQUAL | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | DIVIDE | PLUSPLUS | MINUSMINUS | MOD | SHIFTRIGHT | SHIFTLEFT | AND | OR | BITWISEOR | BITWISEXOR | DOT | POINTERTOMBR | DOTMBR | SCOPE | AMPERSAND | PLUS | MINUS | TILDE | ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL | NOT | ELLIPSIS ) )
            // Cpp.g:707:9: {...}? ( COLON | QUESTIONMARK | POINTERTO | LCURLY | RCURLY | LSQUARE | RSQUARE | STAR | EQUAL | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | DIVIDE | PLUSPLUS | MINUSMINUS | MOD | SHIFTRIGHT | SHIFTLEFT | AND | OR | BITWISEOR | BITWISEXOR | DOT | POINTERTOMBR | DOTMBR | SCOPE | AMPERSAND | PLUS | MINUS | TILDE | ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL | NOT | ELLIPSIS )
            {
            if ( !((!inDirective)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "COPERATOR", "!inDirective");
            }

            // Cpp.g:708:9: ( COLON | QUESTIONMARK | POINTERTO | LCURLY | RCURLY | LSQUARE | RSQUARE | STAR | EQUAL | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | DIVIDE | PLUSPLUS | MINUSMINUS | MOD | SHIFTRIGHT | SHIFTLEFT | AND | OR | BITWISEOR | BITWISEXOR | DOT | POINTERTOMBR | DOTMBR | SCOPE | AMPERSAND | PLUS | MINUS | TILDE | ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL | NOT | ELLIPSIS )
            int alt51=45;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // Cpp.g:708:13: COLON
                    {
                    mCOLON(); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // Cpp.g:708:37: QUESTIONMARK
                    {
                    mQUESTIONMARK(); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // Cpp.g:709:13: POINTERTO
                    {
                    mPOINTERTO(); if (state.failed) return ;


                    }
                    break;
                case 4 :
                    // Cpp.g:709:29: LCURLY
                    {
                    mLCURLY(); if (state.failed) return ;


                    }
                    break;
                case 5 :
                    // Cpp.g:709:45: RCURLY
                    {
                    mRCURLY(); if (state.failed) return ;


                    }
                    break;
                case 6 :
                    // Cpp.g:710:7: LSQUARE
                    {
                    mLSQUARE(); if (state.failed) return ;


                    }
                    break;
                case 7 :
                    // Cpp.g:710:23: RSQUARE
                    {
                    mRSQUARE(); if (state.failed) return ;


                    }
                    break;
                case 8 :
                    // Cpp.g:710:45: STAR
                    {
                    mSTAR(); if (state.failed) return ;


                    }
                    break;
                case 9 :
                    // Cpp.g:711:13: EQUAL
                    {
                    mEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 10 :
                    // Cpp.g:711:37: NOTEQUAL
                    {
                    mNOTEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 11 :
                    // Cpp.g:711:61: LESSTHANOREQUALTO
                    {
                    mLESSTHANOREQUALTO(); if (state.failed) return ;


                    }
                    break;
                case 12 :
                    // Cpp.g:711:85: LESSTHAN
                    {
                    mLESSTHAN(); if (state.failed) return ;


                    }
                    break;
                case 13 :
                    // Cpp.g:712:13: GREATERTHANOREQUALTO
                    {
                    mGREATERTHANOREQUALTO(); if (state.failed) return ;


                    }
                    break;
                case 14 :
                    // Cpp.g:712:37: GREATERTHAN
                    {
                    mGREATERTHAN(); if (state.failed) return ;


                    }
                    break;
                case 15 :
                    // Cpp.g:712:61: DIVIDE
                    {
                    mDIVIDE(); if (state.failed) return ;


                    }
                    break;
                case 16 :
                    // Cpp.g:712:85: PLUSPLUS
                    {
                    mPLUSPLUS(); if (state.failed) return ;


                    }
                    break;
                case 17 :
                    // Cpp.g:713:13: MINUSMINUS
                    {
                    mMINUSMINUS(); if (state.failed) return ;


                    }
                    break;
                case 18 :
                    // Cpp.g:713:37: MOD
                    {
                    mMOD(); if (state.failed) return ;


                    }
                    break;
                case 19 :
                    // Cpp.g:713:61: SHIFTRIGHT
                    {
                    mSHIFTRIGHT(); if (state.failed) return ;


                    }
                    break;
                case 20 :
                    // Cpp.g:713:85: SHIFTLEFT
                    {
                    mSHIFTLEFT(); if (state.failed) return ;


                    }
                    break;
                case 21 :
                    // Cpp.g:714:13: AND
                    {
                    mAND(); if (state.failed) return ;


                    }
                    break;
                case 22 :
                    // Cpp.g:714:37: OR
                    {
                    mOR(); if (state.failed) return ;


                    }
                    break;
                case 23 :
                    // Cpp.g:714:61: BITWISEOR
                    {
                    mBITWISEOR(); if (state.failed) return ;


                    }
                    break;
                case 24 :
                    // Cpp.g:714:85: BITWISEXOR
                    {
                    mBITWISEXOR(); if (state.failed) return ;


                    }
                    break;
                case 25 :
                    // Cpp.g:715:13: DOT
                    {
                    mDOT(); if (state.failed) return ;


                    }
                    break;
                case 26 :
                    // Cpp.g:715:37: POINTERTOMBR
                    {
                    mPOINTERTOMBR(); if (state.failed) return ;


                    }
                    break;
                case 27 :
                    // Cpp.g:715:61: DOTMBR
                    {
                    mDOTMBR(); if (state.failed) return ;


                    }
                    break;
                case 28 :
                    // Cpp.g:715:85: SCOPE
                    {
                    mSCOPE(); if (state.failed) return ;


                    }
                    break;
                case 29 :
                    // Cpp.g:716:13: AMPERSAND
                    {
                    mAMPERSAND(); if (state.failed) return ;


                    }
                    break;
                case 30 :
                    // Cpp.g:716:37: PLUS
                    {
                    mPLUS(); if (state.failed) return ;


                    }
                    break;
                case 31 :
                    // Cpp.g:716:61: MINUS
                    {
                    mMINUS(); if (state.failed) return ;


                    }
                    break;
                case 32 :
                    // Cpp.g:717:13: TILDE
                    {
                    mTILDE(); if (state.failed) return ;


                    }
                    break;
                case 33 :
                    // Cpp.g:717:37: ASSIGNEQUAL
                    {
                    mASSIGNEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 34 :
                    // Cpp.g:717:61: TIMESEQUAL
                    {
                    mTIMESEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 35 :
                    // Cpp.g:717:85: DIVIDEEQUAL
                    {
                    mDIVIDEEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 36 :
                    // Cpp.g:718:13: MODEQUAL
                    {
                    mMODEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 37 :
                    // Cpp.g:718:37: PLUSEQUAL
                    {
                    mPLUSEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 38 :
                    // Cpp.g:718:61: MINUSEQUAL
                    {
                    mMINUSEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 39 :
                    // Cpp.g:718:85: SHIFTLEFTEQUAL
                    {
                    mSHIFTLEFTEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 40 :
                    // Cpp.g:719:13: SHIFTRIGHTEQUAL
                    {
                    mSHIFTRIGHTEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 41 :
                    // Cpp.g:719:37: BITWISEANDEQUAL
                    {
                    mBITWISEANDEQUAL(); if (state.failed) return ;


                    }
                    break;
                case 42 :
                    // Cpp.g:719:61: BITWISEXOREQUAL
                    {
                    mBITWISEXOREQUAL(); if (state.failed) return ;


                    }
                    break;
                case 43 :
                    // Cpp.g:719:85: BITWISEOREQUAL
                    {
                    mBITWISEOREQUAL(); if (state.failed) return ;


                    }
                    break;
                case 44 :
                    // Cpp.g:720:7: NOT
                    {
                    mNOT(); if (state.failed) return ;


                    }
                    break;
                case 45 :
                    // Cpp.g:720:21: ELLIPSIS
                    {
                    mELLIPSIS(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COPERATOR"

    // $ANTLR start "CKEYWORD"
    public final void mCKEYWORD() throws RecognitionException {
        try {
            int _type = CKEYWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Cpp.g:724:11: ({...}? 'typedef' | '__va_list__' | 'extern' | 'static' | 'auto' | 'register' | 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | '__fpreg' | '__float80' | 'struct' | 'union' | 'enum' | 'const' | 'volatile' | 'case' | 'default' | 'switch' | 'while' | 'do' | 'for' | 'goto' | 'continue' | 'break' | 'return' | 'if' | 'else' | 'sealed' | 'ref' )
            int alt52=36;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt52=1;
                }
                break;
            case '_':
                {
                int LA52_2 = input.LA(2);

                if ( (LA52_2=='_') ) {
                    int LA52_17 = input.LA(3);

                    if ( (LA52_17=='v') ) {
                        alt52=2;
                    }
                    else if ( (LA52_17=='f') ) {
                        int LA52_39 = input.LA(4);

                        if ( (LA52_39=='p') ) {
                            alt52=16;
                        }
                        else if ( (LA52_39=='l') ) {
                            alt52=17;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 39, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 17, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'e':
                {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt52=3;
                    }
                    break;
                case 'n':
                    {
                    alt52=20;
                    }
                    break;
                case 'l':
                    {
                    alt52=34;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 3, input);

                    throw nvae;

                }

                }
                break;
            case 's':
                {
                switch ( input.LA(2) ) {
                case 't':
                    {
                    int LA52_21 = input.LA(3);

                    if ( (LA52_21=='a') ) {
                        alt52=4;
                    }
                    else if ( (LA52_21=='r') ) {
                        alt52=18;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 21, input);

                        throw nvae;

                    }
                    }
                    break;
                case 'h':
                    {
                    alt52=9;
                    }
                    break;
                case 'i':
                    {
                    alt52=14;
                    }
                    break;
                case 'w':
                    {
                    alt52=25;
                    }
                    break;
                case 'e':
                    {
                    alt52=35;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 4, input);

                    throw nvae;

                }

                }
                break;
            case 'a':
                {
                alt52=5;
                }
                break;
            case 'r':
                {
                int LA52_6 = input.LA(2);

                if ( (LA52_6=='e') ) {
                    switch ( input.LA(3) ) {
                    case 'g':
                        {
                        alt52=6;
                        }
                        break;
                    case 't':
                        {
                        alt52=32;
                        }
                        break;
                    case 'f':
                        {
                        alt52=36;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 26, input);

                        throw nvae;

                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 6, input);

                    throw nvae;

                }
                }
                break;
            case 'v':
                {
                int LA52_7 = input.LA(2);

                if ( (LA52_7=='o') ) {
                    int LA52_27 = input.LA(3);

                    if ( (LA52_27=='i') ) {
                        alt52=7;
                    }
                    else if ( (LA52_27=='l') ) {
                        alt52=22;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 27, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 7, input);

                    throw nvae;

                }
                }
                break;
            case 'c':
                {
                switch ( input.LA(2) ) {
                case 'h':
                    {
                    alt52=8;
                    }
                    break;
                case 'o':
                    {
                    int LA52_29 = input.LA(3);

                    if ( (LA52_29=='n') ) {
                        int LA52_47 = input.LA(4);

                        if ( (LA52_47=='s') ) {
                            alt52=21;
                        }
                        else if ( (LA52_47=='t') ) {
                            alt52=30;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 52, 47, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 29, input);

                        throw nvae;

                    }
                    }
                    break;
                case 'a':
                    {
                    alt52=23;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 8, input);

                    throw nvae;

                }

                }
                break;
            case 'i':
                {
                int LA52_9 = input.LA(2);

                if ( (LA52_9=='n') ) {
                    alt52=10;
                }
                else if ( (LA52_9=='f') ) {
                    alt52=33;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 9, input);

                    throw nvae;

                }
                }
                break;
            case 'l':
                {
                alt52=11;
                }
                break;
            case 'f':
                {
                int LA52_11 = input.LA(2);

                if ( (LA52_11=='l') ) {
                    alt52=12;
                }
                else if ( (LA52_11=='o') ) {
                    alt52=28;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 11, input);

                    throw nvae;

                }
                }
                break;
            case 'd':
                {
                int LA52_12 = input.LA(2);

                if ( (LA52_12=='o') ) {
                    int LA52_35 = input.LA(3);

                    if ( (LA52_35=='u') ) {
                        alt52=13;
                    }
                    else {
                        alt52=27;
                    }
                }
                else if ( (LA52_12=='e') ) {
                    alt52=24;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 12, input);

                    throw nvae;

                }
                }
                break;
            case 'u':
                {
                int LA52_13 = input.LA(2);

                if ( (LA52_13=='n') ) {
                    int LA52_37 = input.LA(3);

                    if ( (LA52_37=='s') ) {
                        alt52=15;
                    }
                    else if ( (LA52_37=='i') ) {
                        alt52=19;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 37, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 13, input);

                    throw nvae;

                }
                }
                break;
            case 'w':
                {
                alt52=26;
                }
                break;
            case 'g':
                {
                alt52=29;
                }
                break;
            case 'b':
                {
                alt52=31;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // Cpp.g:724:13: {...}? 'typedef'
                    {
                    if ( !((!inDirective)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "CKEYWORD", "!inDirective");
                    }

                    match("typedef"); if (state.failed) return ;



                    }
                    break;
                case 2 :
                    // Cpp.g:725:23: '__va_list__'
                    {
                    match("__va_list__"); if (state.failed) return ;



                    }
                    break;
                case 3 :
                    // Cpp.g:725:39: 'extern'
                    {
                    match("extern"); if (state.failed) return ;



                    }
                    break;
                case 4 :
                    // Cpp.g:725:51: 'static'
                    {
                    match("static"); if (state.failed) return ;



                    }
                    break;
                case 5 :
                    // Cpp.g:725:63: 'auto'
                    {
                    match("auto"); if (state.failed) return ;



                    }
                    break;
                case 6 :
                    // Cpp.g:725:75: 'register'
                    {
                    match("register"); if (state.failed) return ;



                    }
                    break;
                case 7 :
                    // Cpp.g:726:11: 'void'
                    {
                    match("void"); if (state.failed) return ;



                    }
                    break;
                case 8 :
                    // Cpp.g:726:23: 'char'
                    {
                    match("char"); if (state.failed) return ;



                    }
                    break;
                case 9 :
                    // Cpp.g:726:35: 'short'
                    {
                    match("short"); if (state.failed) return ;



                    }
                    break;
                case 10 :
                    // Cpp.g:726:45: 'int'
                    {
                    match("int"); if (state.failed) return ;



                    }
                    break;
                case 11 :
                    // Cpp.g:726:55: 'long'
                    {
                    match("long"); if (state.failed) return ;



                    }
                    break;
                case 12 :
                    // Cpp.g:726:67: 'float'
                    {
                    match("float"); if (state.failed) return ;



                    }
                    break;
                case 13 :
                    // Cpp.g:727:11: 'double'
                    {
                    match("double"); if (state.failed) return ;



                    }
                    break;
                case 14 :
                    // Cpp.g:727:23: 'signed'
                    {
                    match("signed"); if (state.failed) return ;



                    }
                    break;
                case 15 :
                    // Cpp.g:727:37: 'unsigned'
                    {
                    match("unsigned"); if (state.failed) return ;



                    }
                    break;
                case 16 :
                    // Cpp.g:727:49: '__fpreg'
                    {
                    match("__fpreg"); if (state.failed) return ;



                    }
                    break;
                case 17 :
                    // Cpp.g:727:61: '__float80'
                    {
                    match("__float80"); if (state.failed) return ;



                    }
                    break;
                case 18 :
                    // Cpp.g:727:77: 'struct'
                    {
                    match("struct"); if (state.failed) return ;



                    }
                    break;
                case 19 :
                    // Cpp.g:728:11: 'union'
                    {
                    match("union"); if (state.failed) return ;



                    }
                    break;
                case 20 :
                    // Cpp.g:728:23: 'enum'
                    {
                    match("enum"); if (state.failed) return ;



                    }
                    break;
                case 21 :
                    // Cpp.g:728:35: 'const'
                    {
                    match("const"); if (state.failed) return ;



                    }
                    break;
                case 22 :
                    // Cpp.g:728:45: 'volatile'
                    {
                    match("volatile"); if (state.failed) return ;



                    }
                    break;
                case 23 :
                    // Cpp.g:728:58: 'case'
                    {
                    match("case"); if (state.failed) return ;



                    }
                    break;
                case 24 :
                    // Cpp.g:728:71: 'default'
                    {
                    match("default"); if (state.failed) return ;



                    }
                    break;
                case 25 :
                    // Cpp.g:729:11: 'switch'
                    {
                    match("switch"); if (state.failed) return ;



                    }
                    break;
                case 26 :
                    // Cpp.g:729:23: 'while'
                    {
                    match("while"); if (state.failed) return ;



                    }
                    break;
                case 27 :
                    // Cpp.g:729:35: 'do'
                    {
                    match("do"); if (state.failed) return ;



                    }
                    break;
                case 28 :
                    // Cpp.g:729:45: 'for'
                    {
                    match("for"); if (state.failed) return ;



                    }
                    break;
                case 29 :
                    // Cpp.g:729:55: 'goto'
                    {
                    match("goto"); if (state.failed) return ;



                    }
                    break;
                case 30 :
                    // Cpp.g:729:67: 'continue'
                    {
                    match("continue"); if (state.failed) return ;



                    }
                    break;
                case 31 :
                    // Cpp.g:730:11: 'break'
                    {
                    match("break"); if (state.failed) return ;



                    }
                    break;
                case 32 :
                    // Cpp.g:730:23: 'return'
                    {
                    match("return"); if (state.failed) return ;



                    }
                    break;
                case 33 :
                    // Cpp.g:730:37: 'if'
                    {
                    match("if"); if (state.failed) return ;



                    }
                    break;
                case 34 :
                    // Cpp.g:730:47: 'else'
                    {
                    match("else"); if (state.failed) return ;



                    }
                    break;
                case 35 :
                    // Cpp.g:730:56: 'sealed'
                    {
                    match("sealed"); if (state.failed) return ;



                    }
                    break;
                case 36 :
                    // Cpp.g:730:68: 'ref'
                    {
                    match("ref"); if (state.failed) return ;



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CKEYWORD"

    public void mTokens() throws RecognitionException {
        // Cpp.g:1:8: ( STRING_OP | DIRECTIVE | SIZEOF | DEFINED | IDENTIFIER | STRINGIFICATION | SHARPSHARP | ASSIGNEQUAL | COLON | COMMA | QUESTIONMARK | SEMICOLON | POINTERTO | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | EQUAL | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | DIVIDE | DIVIDEEQUAL | PLUS | PLUSEQUAL | PLUSPLUS | MINUS | MINUSEQUAL | MINUSMINUS | STAR | TIMESEQUAL | MOD | MODEQUAL | SHIFTRIGHT | SHIFTRIGHTEQUAL | SHIFTLEFT | SHIFTLEFTEQUAL | AND | NOT | OR | AMPERSAND | BITWISEANDEQUAL | TILDE | BITWISEOR | BITWISEOREQUAL | BITWISEXOR | BITWISEXOREQUAL | DOT | POINTERTOMBR | DOTMBR | SCOPE | ELLIPSIS | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | COMMENT | LINE_COMMENT | WS | End | ESCAPED_NEWLINE | COPERATOR | CKEYWORD )
        int alt53=69;
        alt53 = dfa53.predict(input);
        switch (alt53) {
            case 1 :
                // Cpp.g:1:10: STRING_OP
                {
                mSTRING_OP(); if (state.failed) return ;


                }
                break;
            case 2 :
                // Cpp.g:1:20: DIRECTIVE
                {
                mDIRECTIVE(); if (state.failed) return ;


                }
                break;
            case 3 :
                // Cpp.g:1:30: SIZEOF
                {
                mSIZEOF(); if (state.failed) return ;


                }
                break;
            case 4 :
                // Cpp.g:1:37: DEFINED
                {
                mDEFINED(); if (state.failed) return ;


                }
                break;
            case 5 :
                // Cpp.g:1:45: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;


                }
                break;
            case 6 :
                // Cpp.g:1:56: STRINGIFICATION
                {
                mSTRINGIFICATION(); if (state.failed) return ;


                }
                break;
            case 7 :
                // Cpp.g:1:72: SHARPSHARP
                {
                mSHARPSHARP(); if (state.failed) return ;


                }
                break;
            case 8 :
                // Cpp.g:1:83: ASSIGNEQUAL
                {
                mASSIGNEQUAL(); if (state.failed) return ;


                }
                break;
            case 9 :
                // Cpp.g:1:95: COLON
                {
                mCOLON(); if (state.failed) return ;


                }
                break;
            case 10 :
                // Cpp.g:1:101: COMMA
                {
                mCOMMA(); if (state.failed) return ;


                }
                break;
            case 11 :
                // Cpp.g:1:107: QUESTIONMARK
                {
                mQUESTIONMARK(); if (state.failed) return ;


                }
                break;
            case 12 :
                // Cpp.g:1:120: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;


                }
                break;
            case 13 :
                // Cpp.g:1:130: POINTERTO
                {
                mPOINTERTO(); if (state.failed) return ;


                }
                break;
            case 14 :
                // Cpp.g:1:140: LPAREN
                {
                mLPAREN(); if (state.failed) return ;


                }
                break;
            case 15 :
                // Cpp.g:1:147: RPAREN
                {
                mRPAREN(); if (state.failed) return ;


                }
                break;
            case 16 :
                // Cpp.g:1:154: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;


                }
                break;
            case 17 :
                // Cpp.g:1:162: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;


                }
                break;
            case 18 :
                // Cpp.g:1:170: LCURLY
                {
                mLCURLY(); if (state.failed) return ;


                }
                break;
            case 19 :
                // Cpp.g:1:177: RCURLY
                {
                mRCURLY(); if (state.failed) return ;


                }
                break;
            case 20 :
                // Cpp.g:1:184: EQUAL
                {
                mEQUAL(); if (state.failed) return ;


                }
                break;
            case 21 :
                // Cpp.g:1:190: NOTEQUAL
                {
                mNOTEQUAL(); if (state.failed) return ;


                }
                break;
            case 22 :
                // Cpp.g:1:199: LESSTHANOREQUALTO
                {
                mLESSTHANOREQUALTO(); if (state.failed) return ;


                }
                break;
            case 23 :
                // Cpp.g:1:217: LESSTHAN
                {
                mLESSTHAN(); if (state.failed) return ;


                }
                break;
            case 24 :
                // Cpp.g:1:226: GREATERTHANOREQUALTO
                {
                mGREATERTHANOREQUALTO(); if (state.failed) return ;


                }
                break;
            case 25 :
                // Cpp.g:1:247: GREATERTHAN
                {
                mGREATERTHAN(); if (state.failed) return ;


                }
                break;
            case 26 :
                // Cpp.g:1:259: DIVIDE
                {
                mDIVIDE(); if (state.failed) return ;


                }
                break;
            case 27 :
                // Cpp.g:1:266: DIVIDEEQUAL
                {
                mDIVIDEEQUAL(); if (state.failed) return ;


                }
                break;
            case 28 :
                // Cpp.g:1:278: PLUS
                {
                mPLUS(); if (state.failed) return ;


                }
                break;
            case 29 :
                // Cpp.g:1:283: PLUSEQUAL
                {
                mPLUSEQUAL(); if (state.failed) return ;


                }
                break;
            case 30 :
                // Cpp.g:1:293: PLUSPLUS
                {
                mPLUSPLUS(); if (state.failed) return ;


                }
                break;
            case 31 :
                // Cpp.g:1:302: MINUS
                {
                mMINUS(); if (state.failed) return ;


                }
                break;
            case 32 :
                // Cpp.g:1:308: MINUSEQUAL
                {
                mMINUSEQUAL(); if (state.failed) return ;


                }
                break;
            case 33 :
                // Cpp.g:1:319: MINUSMINUS
                {
                mMINUSMINUS(); if (state.failed) return ;


                }
                break;
            case 34 :
                // Cpp.g:1:330: STAR
                {
                mSTAR(); if (state.failed) return ;


                }
                break;
            case 35 :
                // Cpp.g:1:335: TIMESEQUAL
                {
                mTIMESEQUAL(); if (state.failed) return ;


                }
                break;
            case 36 :
                // Cpp.g:1:346: MOD
                {
                mMOD(); if (state.failed) return ;


                }
                break;
            case 37 :
                // Cpp.g:1:350: MODEQUAL
                {
                mMODEQUAL(); if (state.failed) return ;


                }
                break;
            case 38 :
                // Cpp.g:1:359: SHIFTRIGHT
                {
                mSHIFTRIGHT(); if (state.failed) return ;


                }
                break;
            case 39 :
                // Cpp.g:1:370: SHIFTRIGHTEQUAL
                {
                mSHIFTRIGHTEQUAL(); if (state.failed) return ;


                }
                break;
            case 40 :
                // Cpp.g:1:386: SHIFTLEFT
                {
                mSHIFTLEFT(); if (state.failed) return ;


                }
                break;
            case 41 :
                // Cpp.g:1:396: SHIFTLEFTEQUAL
                {
                mSHIFTLEFTEQUAL(); if (state.failed) return ;


                }
                break;
            case 42 :
                // Cpp.g:1:411: AND
                {
                mAND(); if (state.failed) return ;


                }
                break;
            case 43 :
                // Cpp.g:1:415: NOT
                {
                mNOT(); if (state.failed) return ;


                }
                break;
            case 44 :
                // Cpp.g:1:419: OR
                {
                mOR(); if (state.failed) return ;


                }
                break;
            case 45 :
                // Cpp.g:1:422: AMPERSAND
                {
                mAMPERSAND(); if (state.failed) return ;


                }
                break;
            case 46 :
                // Cpp.g:1:432: BITWISEANDEQUAL
                {
                mBITWISEANDEQUAL(); if (state.failed) return ;


                }
                break;
            case 47 :
                // Cpp.g:1:448: TILDE
                {
                mTILDE(); if (state.failed) return ;


                }
                break;
            case 48 :
                // Cpp.g:1:454: BITWISEOR
                {
                mBITWISEOR(); if (state.failed) return ;


                }
                break;
            case 49 :
                // Cpp.g:1:464: BITWISEOREQUAL
                {
                mBITWISEOREQUAL(); if (state.failed) return ;


                }
                break;
            case 50 :
                // Cpp.g:1:479: BITWISEXOR
                {
                mBITWISEXOR(); if (state.failed) return ;


                }
                break;
            case 51 :
                // Cpp.g:1:490: BITWISEXOREQUAL
                {
                mBITWISEXOREQUAL(); if (state.failed) return ;


                }
                break;
            case 52 :
                // Cpp.g:1:506: DOT
                {
                mDOT(); if (state.failed) return ;


                }
                break;
            case 53 :
                // Cpp.g:1:510: POINTERTOMBR
                {
                mPOINTERTOMBR(); if (state.failed) return ;


                }
                break;
            case 54 :
                // Cpp.g:1:523: DOTMBR
                {
                mDOTMBR(); if (state.failed) return ;


                }
                break;
            case 55 :
                // Cpp.g:1:530: SCOPE
                {
                mSCOPE(); if (state.failed) return ;


                }
                break;
            case 56 :
                // Cpp.g:1:536: ELLIPSIS
                {
                mELLIPSIS(); if (state.failed) return ;


                }
                break;
            case 57 :
                // Cpp.g:1:545: CHARACTER_LITERAL
                {
                mCHARACTER_LITERAL(); if (state.failed) return ;


                }
                break;
            case 58 :
                // Cpp.g:1:563: STRING_LITERAL
                {
                mSTRING_LITERAL(); if (state.failed) return ;


                }
                break;
            case 59 :
                // Cpp.g:1:578: HEX_LITERAL
                {
                mHEX_LITERAL(); if (state.failed) return ;


                }
                break;
            case 60 :
                // Cpp.g:1:590: DECIMAL_LITERAL
                {
                mDECIMAL_LITERAL(); if (state.failed) return ;


                }
                break;
            case 61 :
                // Cpp.g:1:606: OCTAL_LITERAL
                {
                mOCTAL_LITERAL(); if (state.failed) return ;


                }
                break;
            case 62 :
                // Cpp.g:1:620: FLOATING_POINT_LITERAL
                {
                mFLOATING_POINT_LITERAL(); if (state.failed) return ;


                }
                break;
            case 63 :
                // Cpp.g:1:643: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;


                }
                break;
            case 64 :
                // Cpp.g:1:651: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;


                }
                break;
            case 65 :
                // Cpp.g:1:664: WS
                {
                mWS(); if (state.failed) return ;


                }
                break;
            case 66 :
                // Cpp.g:1:667: End
                {
                mEnd(); if (state.failed) return ;


                }
                break;
            case 67 :
                // Cpp.g:1:671: ESCAPED_NEWLINE
                {
                mESCAPED_NEWLINE(); if (state.failed) return ;


                }
                break;
            case 68 :
                // Cpp.g:1:687: COPERATOR
                {
                mCOPERATOR(); if (state.failed) return ;


                }
                break;
            case 69 :
                // Cpp.g:1:697: CKEYWORD
                {
                mCKEYWORD(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_Cpp
    public final void synpred1_Cpp_fragment() throws RecognitionException {
        // Cpp.g:339:21: ( '/*' )
        // Cpp.g:339:22: '/*'
        {
        match("/*"); if (state.failed) return ;



        }

    }
    // $ANTLR end synpred1_Cpp

    // $ANTLR start synpred2_Cpp
    public final void synpred2_Cpp_fragment() throws RecognitionException {
        // Cpp.g:340:17: ( '\\\\\\n' )
        // Cpp.g:340:18: '\\\\\\n'
        {
        match("\\\n"); if (state.failed) return ;



        }

    }
    // $ANTLR end synpred2_Cpp

    // $ANTLR start synpred3_Cpp
    public final void synpred3_Cpp_fragment() throws RecognitionException {
        // Cpp.g:341:17: ( '\\\\\\r\\n' )
        // Cpp.g:341:18: '\\\\\\r\\n'
        {
        match("\\\r\n"); if (state.failed) return ;



        }

    }
    // $ANTLR end synpred3_Cpp

    public final boolean synpred2_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA53 dfa53 = new DFA53(this);
    static final String DFA6_eotS =
        "\1\10\30\uffff";
    static final String DFA6_eofS =
        "\31\uffff";
    static final String DFA6_minS =
        "\1\144\3\uffff\1\162\1\156\5\uffff\1\143\1\154\1\165\1\144\1\145"+
        "\1\11\1\156\1\11\1\145\2\uffff\1\170\1\164\1\11";
    static final String DFA6_maxS =
        "\1\167\3\uffff\1\170\1\156\5\uffff\1\143\1\154\1\165\1\144\1\145"+
        "\1\137\1\156\1\172\1\145\2\uffff\1\170\1\164\1\40";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\2\uffff\1\7\1\11\1\12\1\4\1\10\11\uffff\1\5"+
        "\1\6\3\uffff";
    static final String DFA6_specialS =
        "\31\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\1\4\3\uffff\1\5\2\uffff\1\1\3\uffff\1\7\4\uffff\1\2\1\uffff"+
            "\1\6",
            "",
            "",
            "",
            "\1\12\5\uffff\1\11",
            "\1\13",
            "",
            "",
            "",
            "",
            "",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\22\2\uffff\2\22\22\uffff\1\22\76\uffff\1\21",
            "\1\23",
            "\1\22\2\uffff\2\22\22\uffff\1\22\1\uffff\1\25\2\24\27\uffff"+
            "\1\25\4\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\26",
            "",
            "",
            "\1\27",
            "\1\30",
            "\1\22\2\uffff\2\22\22\uffff\1\22"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "314:5: ( 'line' | 'undef' WS | 'define' WS | 'exec_macro_expression' | ( 'include' | 'include_next' ) WS f= IDENTIFIER | ( 'include' | 'include_next' ) WS f= INCLUDE_FILE | 'warning' m= MACRO_TEXT | 'error' (m= MACRO_TEXT )? | 'pragma' m= MACRO_TEXT|)";
        }
    }
    static final String DFA8_eotS =
        "\1\1\1\uffff\2\4\1\uffff\1\4\1\uffff\4\4\5\uffff\1\4";
    static final String DFA8_eofS =
        "\21\uffff";
    static final String DFA8_minS =
        "\1\0\1\uffff\1\52\1\12\1\uffff\6\0\3\uffff\3\0";
    static final String DFA8_maxS =
        "\1\uffff\1\uffff\1\52\1\12\1\uffff\1\uffff\1\0\4\uffff\3\uffff\2"+
        "\0\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\5\2\uffff\1\4\6\uffff\1\1\1\2\1\3\3\uffff";
    static final String DFA8_specialS =
        "\1\3\4\uffff\1\5\1\4\1\6\1\10\1\2\1\7\3\uffff\1\11\1\1\1\0}>";
    static final String[] DFA8_transitionS = {
            "\12\4\1\uffff\44\4\1\2\54\4\1\3\uffa3\4",
            "",
            "\1\5",
            "\1\6",
            "",
            "\12\12\1\13\37\12\1\7\4\12\1\10\54\12\1\11\uffa3\12",
            "\1\uffff",
            "\12\12\1\13\37\12\1\7\4\12\1\16\54\12\1\11\uffa3\12",
            "\12\12\1\13\37\12\1\17\4\12\1\10\54\12\1\11\uffa3\12",
            "\12\12\1\20\37\12\1\7\4\12\1\10\54\12\1\11\uffa3\12",
            "\12\12\1\13\37\12\1\7\4\12\1\10\54\12\1\11\uffa3\12",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\12\12\1\13\37\12\1\7\4\12\1\10\54\12\1\11\uffa3\12"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()+ loopback of 339:17: ( ( '/*' )=> '/*' ( options {greedy=false; } : . )* '*/' | ( '\\\\\\n' )=> ( '\\\\\\n' ) | ( '\\\\\\r\\n' )=> ( '\\\\\\n' ) |~ '\\n' )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_16 = input.LA(1);

                         
                        int index8_16 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_16=='/') ) {s = 8;}

                        else if ( (LA8_16=='\\') ) {s = 9;}

                        else if ( (LA8_16=='*') ) {s = 7;}

                        else if ( ((LA8_16 >= '\u0000' && LA8_16 <= '\t')||(LA8_16 >= '\u000B' && LA8_16 <= ')')||(LA8_16 >= '+' && LA8_16 <= '.')||(LA8_16 >= '0' && LA8_16 <= '[')||(LA8_16 >= ']' && LA8_16 <= '\uFFFF')) ) {s = 10;}

                        else if ( (LA8_16=='\n') && (synpred1_Cpp())) {s = 11;}

                        else s = 4;

                         
                        input.seek(index8_16);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Cpp()) ) {s = 11;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index8_15);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA8_9 = input.LA(1);

                        s = -1;
                        if ( (LA8_9=='\n') ) {s = 16;}

                        else if ( (LA8_9=='*') ) {s = 7;}

                        else if ( (LA8_9=='/') ) {s = 8;}

                        else if ( (LA8_9=='\\') ) {s = 9;}

                        else if ( ((LA8_9 >= '\u0000' && LA8_9 <= '\t')||(LA8_9 >= '\u000B' && LA8_9 <= ')')||(LA8_9 >= '+' && LA8_9 <= '.')||(LA8_9 >= '0' && LA8_9 <= '[')||(LA8_9 >= ']' && LA8_9 <= '\uFFFF')) ) {s = 10;}

                        else s = 4;

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA8_0 = input.LA(1);

                        s = -1;
                        if ( (LA8_0=='/') ) {s = 2;}

                        else if ( (LA8_0=='\\') ) {s = 3;}

                        else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '.')||(LA8_0 >= '0' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {s = 4;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred2_Cpp()) ) {s = 12;}

                        else if ( (synpred3_Cpp()) ) {s = 13;}

                         
                        input.seek(index8_6);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_5=='*') ) {s = 7;}

                        else if ( (LA8_5=='/') ) {s = 8;}

                        else if ( (LA8_5=='\\') ) {s = 9;}

                        else if ( ((LA8_5 >= '\u0000' && LA8_5 <= '\t')||(LA8_5 >= '\u000B' && LA8_5 <= ')')||(LA8_5 >= '+' && LA8_5 <= '.')||(LA8_5 >= '0' && LA8_5 <= '[')||(LA8_5 >= ']' && LA8_5 <= '\uFFFF')) ) {s = 10;}

                        else if ( (LA8_5=='\n') && (synpred1_Cpp())) {s = 11;}

                        else s = 4;

                         
                        input.seek(index8_5);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_7=='/') ) {s = 14;}

                        else if ( (LA8_7=='*') ) {s = 7;}

                        else if ( (LA8_7=='\\') ) {s = 9;}

                        else if ( ((LA8_7 >= '\u0000' && LA8_7 <= '\t')||(LA8_7 >= '\u000B' && LA8_7 <= ')')||(LA8_7 >= '+' && LA8_7 <= '.')||(LA8_7 >= '0' && LA8_7 <= '[')||(LA8_7 >= ']' && LA8_7 <= '\uFFFF')) ) {s = 10;}

                        else if ( (LA8_7=='\n') && (synpred1_Cpp())) {s = 11;}

                        else s = 4;

                         
                        input.seek(index8_7);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA8_10 = input.LA(1);

                         
                        int index8_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_10=='*') ) {s = 7;}

                        else if ( (LA8_10=='/') ) {s = 8;}

                        else if ( (LA8_10=='\\') ) {s = 9;}

                        else if ( ((LA8_10 >= '\u0000' && LA8_10 <= '\t')||(LA8_10 >= '\u000B' && LA8_10 <= ')')||(LA8_10 >= '+' && LA8_10 <= '.')||(LA8_10 >= '0' && LA8_10 <= '[')||(LA8_10 >= ']' && LA8_10 <= '\uFFFF')) ) {s = 10;}

                        else if ( (LA8_10=='\n') && (synpred1_Cpp())) {s = 11;}

                        else s = 4;

                         
                        input.seek(index8_10);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA8_8 = input.LA(1);

                         
                        int index8_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_8=='*') ) {s = 15;}

                        else if ( (LA8_8=='/') ) {s = 8;}

                        else if ( (LA8_8=='\\') ) {s = 9;}

                        else if ( ((LA8_8 >= '\u0000' && LA8_8 <= '\t')||(LA8_8 >= '\u000B' && LA8_8 <= ')')||(LA8_8 >= '+' && LA8_8 <= '.')||(LA8_8 >= '0' && LA8_8 <= '[')||(LA8_8 >= ']' && LA8_8 <= '\uFFFF')) ) {s = 10;}

                        else if ( (LA8_8=='\n') && (synpred1_Cpp())) {s = 11;}

                        else s = 4;

                         
                        input.seek(index8_8);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA8_14 = input.LA(1);

                         
                        int index8_14 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_Cpp()) ) {s = 11;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index8_14);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA36_eotS =
        "\6\uffff";
    static final String DFA36_eofS =
        "\6\uffff";
    static final String DFA36_minS =
        "\2\56\4\uffff";
    static final String DFA36_maxS =
        "\1\71\1\146\4\uffff";
    static final String DFA36_acceptS =
        "\2\uffff\1\2\1\1\1\3\1\4";
    static final String DFA36_specialS =
        "\6\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5\1\4\1\5",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "541:1: FLOATING_POINT_LITERAL : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix );";
        }
    }
    static final String DFA51_eotS =
        "\1\uffff\1\26\1\uffff\1\32\4\uffff\1\34\1\36\1\40\1\43\1\46\1\50"+
        "\1\53\1\55\1\60\1\63\1\65\1\70\3\uffff\1\72\12\uffff\1\74\2\uffff"+
        "\1\76\31\uffff";
    static final String DFA51_eofS =
        "\77\uffff";
    static final String DFA51_minS =
        "\1\41\1\72\1\uffff\1\55\4\uffff\3\75\1\74\2\75\1\53\1\75\1\46\2"+
        "\75\1\52\3\uffff\1\52\12\uffff\1\75\2\uffff\1\75\31\uffff";
    static final String DFA51_maxS =
        "\1\176\1\72\1\uffff\1\76\4\uffff\4\75\1\76\4\75\1\174\1\75\1\56"+
        "\3\uffff\1\52\12\uffff\1\75\2\uffff\1\75\31\uffff";
    static final String DFA51_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\14\uffff\1\40\1\34\1\1\1\uffff"+
        "\1\21\1\46\1\37\1\42\1\10\1\11\1\41\1\12\1\54\1\13\1\uffff\1\14"+
        "\1\15\1\uffff\1\16\1\43\1\17\1\20\1\45\1\36\1\44\1\22\1\25\1\51"+
        "\1\35\1\26\1\53\1\27\1\52\1\30\1\33\1\55\1\31\1\32\1\3\1\47\1\24"+
        "\1\50\1\23";
    static final String DFA51_specialS =
        "\77\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\12\3\uffff\1\17\1\20\3\uffff\1\10\1\16\1\uffff\1\3\1\23\1"+
            "\15\12\uffff\1\1\1\uffff\1\13\1\11\1\14\1\2\33\uffff\1\6\1\uffff"+
            "\1\7\1\22\34\uffff\1\4\1\21\1\5\1\24",
            "\1\25",
            "",
            "\1\30\17\uffff\1\31\1\27",
            "",
            "",
            "",
            "",
            "\1\33",
            "\1\35",
            "\1\37",
            "\1\42\1\41",
            "\1\44\1\45",
            "\1\47",
            "\1\51\21\uffff\1\52",
            "\1\54",
            "\1\56\26\uffff\1\57",
            "\1\62\76\uffff\1\61",
            "\1\64",
            "\1\66\3\uffff\1\67",
            "",
            "",
            "",
            "\1\71",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\73",
            "",
            "",
            "\1\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "708:9: ( COLON | QUESTIONMARK | POINTERTO | LCURLY | RCURLY | LSQUARE | RSQUARE | STAR | EQUAL | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | DIVIDE | PLUSPLUS | MINUSMINUS | MOD | SHIFTRIGHT | SHIFTLEFT | AND | OR | BITWISEOR | BITWISEXOR | DOT | POINTERTOMBR | DOTMBR | SCOPE | AMPERSAND | PLUS | MINUS | TILDE | ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL | NOT | ELLIPSIS )";
        }
    }
    static final String DFA53_eotS =
        "\1\uffff\1\76\3\62\1\107\1\111\1\uffff\1\112\1\uffff\1\116\2\uffff"+
        "\1\117\1\120\1\121\1\122\1\124\1\127\1\132\1\136\1\141\1\143\1\145"+
        "\1\150\1\153\1\154\1\156\1\161\1\62\2\uffff\2\165\1\170\2\uffff"+
        "\15\62\1\uffff\1\u008d\1\u008f\1\76\1\u0099\1\u009b\1\u009d\1\u00a0"+
        "\1\u00a2\1\u00a4\1\u00a6\1\u00a7\1\uffff\7\62\1\u00b1\1\uffff\1"+
        "\u00b4\2\uffff\1\u00b8\1\u00b9\1\u00ba\5\uffff\1\u00c0\1\uffff\1"+
        "\u00c2\1\u00c4\1\uffff\1\u00c6\1\u00c8\1\uffff\1\u00ca\3\uffff\1"+
        "\u00cc\1\u00cd\1\uffff\1\u00cf\1\uffff\1\u00d1\1\uffff\1\u00d3\1"+
        "\u00d4\1\uffff\1\u00d6\1\u00d7\2\uffff\1\u00da\1\uffff\1\u00dc\3"+
        "\uffff\1\62\2\uffff\1\u00e0\1\165\1\uffff\13\62\1\uffff\7\62\2\uffff"+
        "\1\u00f8\2\uffff\7\u0090\1\u0102\1\uffff\1\u0104\1\uffff\1\u0106"+
        "\1\uffff\1\u0108\1\u010a\1\uffff\1\u010c\1\uffff\1\u010e\1\uffff"+
        "\1\u0110\2\uffff\11\62\6\uffff\1\u011d\13\uffff\1\u0123\3\uffff"+
        "\1\u0126\25\uffff\1\u0133\1\uffff\1\62\1\uffff\10\62\1\uffff\5\62"+
        "\1\uffff\2\62\1\uffff\5\62\1\uffff\10\u0090\1\u0154\1\uffff\1\u0156"+
        "\1\uffff\1\u0158\1\uffff\1\u015a\1\uffff\1\u015c\1\uffff\1\u015e"+
        "\1\uffff\1\u0160\1\uffff\1\u0162\1\uffff\12\62\31\uffff\5\62\3\uffff"+
        "\2\62\1\uffff\1\62\1\uffff\2\62\2\uffff\4\62\1\uffff\1\62\10\u0090"+
        "\1\u0188\1\uffff\1\u018a\1\uffff\1\u018c\1\uffff\1\u018e\1\uffff"+
        "\1\u0190\1\uffff\1\u0192\1\uffff\1\u0194\1\uffff\1\u0196\1\uffff"+
        "\4\62\1\uffff\5\62\4\uffff\10\62\1\uffff\1\62\1\uffff\1\62\3\uffff"+
        "\1\u01aa\7\u0090\1\uffff\1\u01b2\1\uffff\1\u01b4\1\uffff\1\u01b6"+
        "\1\uffff\1\u01b8\1\uffff\1\u01ba\1\uffff\1\u01bc\1\uffff\1\u01be"+
        "\1\uffff\1\u01bf\5\uffff\2\62\1\uffff\4\62\1\uffff\1\62\1\uffff"+
        "\3\62\1\uffff\3\u0090\1\u01aa\3\u0090\1\uffff\1\u01d0\1\uffff\1"+
        "\u01d2\1\uffff\1\u01d3\1\uffff\1\u01d5\1\uffff\1\u01d7\1\uffff\1"+
        "\u01d9\2\uffff\1\u01da\1\uffff\1\u01db\1\62\1\uffff\5\62\2\u0090"+
        "\1\u01aa\3\u0090\1\uffff\1\u01e7\2\uffff\1\u01e9\1\uffff\1\u01eb"+
        "\1\uffff\1\u01ec\3\uffff\2\62\4\uffff\3\u0090\1\u01aa\1\u01f4\1"+
        "\uffff\1\u01f6\1\uffff\1\u01f7\3\uffff\1\62\1\uffff\2\u0090\1\u01aa"+
        "\1\u01fc\1\uffff\1\u01fe\2\uffff\1\62\2\u0090\1\u0203\1\uffff\1"+
        "\u0205\2\uffff\2\u0090\1\u0209\1\uffff\1\u020b\1\uffff\2\u0090\1"+
        "\u020f\1\uffff\1\u0210\1\uffff\2\u0090\1\u0213\2\uffff\1\u0090\1"+
        "\u0216\1\uffff\1\u0090\1\u0219\1\uffff\1\u0090\1\u021c\1\uffff\1"+
        "\u0090\1\u021f\1\uffff\1\u0090\1\u0222\1\uffff\1\u0090\1\u0225\1"+
        "\uffff\1\u0090\1\u0228\1\uffff\1\u0090\1\u022a\1\uffff\1\u01aa\1"+
        "\uffff";
    static final String DFA53_eofS =
        "\u022b\uffff";
    static final String DFA53_minS =
        "\2\11\2\145\1\42\1\75\1\72\1\uffff\1\0\1\uffff\1\55\2\uffff\4\0"+
        "\1\75\1\74\1\75\1\52\1\53\2\75\1\46\1\75\1\0\1\75\1\52\1\171\2\uffff"+
        "\2\56\1\11\2\uffff\1\137\1\154\1\165\1\145\1\157\1\141\1\146\1\157"+
        "\1\154\1\156\1\150\1\157\1\162\1\uffff\1\43\1\44\1\11\10\44\1\uffff"+
        "\1\147\1\141\1\157\1\151\1\141\1\146\1\165\5\0\1\52\12\0\1\75\2"+
        "\0\1\75\2\0\2\uffff\22\0\1\56\1\0\1\uffff\1\160\2\uffff\2\56\1\uffff"+
        "\1\146\1\164\1\165\1\163\1\164\1\146\1\151\1\141\1\156\1\163\1\164"+
        "\1\uffff\1\156\1\157\1\162\2\151\1\164\1\145\1\uffff\1\0\1\44\2"+
        "\uffff\1\151\1\156\1\145\1\162\1\156\1\141\1\162\1\44\1\0\1\44\1"+
        "\0\1\44\1\0\2\44\1\0\1\44\1\0\1\44\1\0\1\44\2\0\1\145\1\156\1\164"+
        "\1\165\1\162\1\164\1\154\1\141\1\142\1\0\2\uffff\1\0\2\uffff\4\0"+
        "\5\uffff\1\0\1\uffff\3\0\1\uffff\3\0\1\uffff\1\0\1\uffff\2\0\1\uffff"+
        "\1\0\1\uffff\1\0\1\uffff\2\0\1\uffff\2\0\2\uffff\1\0\1\uffff\2\0"+
        "\1\uffff\1\145\1\uffff\1\141\1\154\1\145\1\155\1\145\1\157\1\151"+
        "\1\165\1\uffff\1\144\1\141\1\162\1\163\1\145\1\uffff\1\147\1\141"+
        "\1\uffff\1\151\1\157\1\154\1\157\1\141\1\0\1\156\1\144\1\146\1\145"+
        "\1\162\1\143\1\162\1\141\1\44\1\0\1\44\1\0\1\44\1\0\1\44\1\0\1\44"+
        "\1\0\1\44\1\0\1\44\1\0\1\44\1\0\1\157\1\145\1\151\1\143\1\164\1"+
        "\143\1\145\1\156\1\165\1\154\2\uffff\1\0\5\uffff\1\0\2\uffff\1\0"+
        "\14\uffff\1\0\1\144\1\137\1\162\1\157\1\162\3\uffff\1\163\1\162"+
        "\1\uffff\1\164\1\uffff\1\164\1\151\2\uffff\1\164\1\147\1\156\1\145"+
        "\1\uffff\1\153\2\145\1\151\1\143\1\157\1\154\1\156\1\147\1\44\1"+
        "\0\1\44\1\0\1\44\1\0\1\44\1\0\1\44\1\0\1\44\1\0\1\44\1\0\1\44\1"+
        "\0\1\146\1\144\1\143\1\164\1\uffff\1\150\1\144\1\145\1\154\1\145"+
        "\4\uffff\1\145\1\154\1\145\1\141\1\156\1\164\1\156\1\151\1\uffff"+
        "\1\156\1\uffff\1\156\3\uffff\1\44\1\146\1\156\1\137\1\162\1\165"+
        "\1\151\1\155\1\0\1\11\1\0\1\44\1\0\1\44\3\0\1\44\1\0\1\44\1\0\1"+
        "\44\1\0\1\44\5\uffff\1\144\1\164\1\uffff\1\146\1\151\1\147\1\164"+
        "\1\uffff\1\145\1\uffff\1\154\1\165\1\145\1\0\1\11\1\145\1\155\1"+
        "\0\1\144\1\156\1\141\1\0\1\11\1\0\1\44\3\0\1\44\1\0\1\44\3\0\1\uffff"+
        "\1\44\1\uffff\1\44\1\163\1\uffff\1\70\1\162\2\145\1\144\1\11\1\141"+
        "\1\0\1\145\1\147\2\0\1\44\2\0\1\11\5\0\1\uffff\1\0\1\164\1\60\4"+
        "\uffff\1\143\1\11\2\0\1\44\1\0\1\44\4\0\1\uffff\1\137\1\uffff\1"+
        "\162\1\156\1\0\1\44\1\0\1\44\2\0\1\137\1\157\1\145\1\44\1\0\1\44"+
        "\1\0\1\uffff\1\137\1\170\1\44\1\0\1\44\1\0\1\145\1\164\1\44\1\0"+
        "\1\11\1\0\1\170\1\11\1\44\2\0\1\160\1\44\1\0\1\162\1\44\1\0\1\145"+
        "\1\44\1\0\1\163\1\44\1\0\1\163\1\44\1\0\1\151\1\44\1\0\1\157\1\44"+
        "\1\0\1\156\1\44\1\0\1\44\1\0";
    static final String DFA53_maxS =
        "\1\176\1\172\1\167\1\157\1\47\1\75\1\72\1\uffff\1\0\1\uffff\1\76"+
        "\2\uffff\4\0\2\75\1\76\1\134\4\75\1\174\1\0\1\75\1\71\1\171\2\uffff"+
        "\1\170\1\146\1\40\2\uffff\1\137\1\170\1\165\1\145\2\157\1\156\2"+
        "\157\1\156\1\150\1\157\1\162\1\uffff\13\172\1\uffff\1\172\1\162"+
        "\1\157\1\151\1\141\1\146\1\165\5\0\1\52\12\0\1\75\2\0\1\75\2\0\2"+
        "\uffff\22\0\1\56\1\0\1\uffff\1\160\2\uffff\2\146\1\uffff\1\166\1"+
        "\164\1\165\1\163\2\164\1\154\1\141\1\156\1\163\1\164\1\uffff\1\156"+
        "\1\157\1\162\1\163\1\151\1\164\1\145\1\uffff\1\0\1\172\2\uffff\1"+
        "\151\1\156\1\145\1\170\1\156\1\141\1\162\1\172\1\0\1\172\1\0\1\172"+
        "\1\0\2\172\1\0\1\172\1\0\1\172\1\0\1\172\2\0\1\145\1\156\1\164\1"+
        "\165\1\162\1\164\1\154\1\151\1\142\1\0\2\uffff\1\0\2\uffff\4\0\5"+
        "\uffff\1\0\1\uffff\3\0\1\uffff\3\0\1\uffff\1\0\1\uffff\2\0\1\uffff"+
        "\1\0\1\uffff\1\0\1\uffff\2\0\1\uffff\2\0\2\uffff\1\0\1\uffff\2\0"+
        "\1\uffff\1\145\1\uffff\1\141\1\160\1\145\1\155\1\145\1\157\1\151"+
        "\1\165\1\uffff\1\144\1\141\1\162\1\164\1\145\1\uffff\1\147\1\141"+
        "\1\uffff\1\151\1\157\1\154\1\157\1\141\1\0\1\156\1\144\1\146\1\145"+
        "\1\162\1\143\1\162\1\141\1\172\1\0\1\172\1\0\1\172\1\0\1\172\1\0"+
        "\1\172\1\0\1\172\1\0\1\172\1\0\1\172\1\0\1\157\1\145\1\151\1\143"+
        "\1\164\1\143\1\145\1\156\1\165\1\154\2\uffff\1\0\5\uffff\1\0\2\uffff"+
        "\1\0\14\uffff\1\0\1\144\1\137\1\162\1\157\1\162\3\uffff\1\163\1"+
        "\162\1\uffff\1\164\1\uffff\1\164\1\151\2\uffff\1\164\1\147\1\156"+
        "\1\145\1\uffff\1\153\2\145\1\151\1\143\1\157\1\154\1\156\1\147\1"+
        "\172\1\0\1\172\1\0\1\172\1\0\1\172\1\0\1\172\1\0\1\172\1\0\1\172"+
        "\1\0\1\172\1\0\1\146\1\144\1\143\1\164\1\uffff\1\150\1\144\1\145"+
        "\1\154\1\145\4\uffff\1\145\1\154\1\145\1\141\1\156\1\164\1\156\1"+
        "\151\1\uffff\1\156\1\uffff\1\156\3\uffff\1\172\1\146\1\156\1\137"+
        "\1\162\1\165\1\151\1\155\1\0\1\172\1\0\1\172\1\0\1\172\1\0\1\uffff"+
        "\1\0\1\172\1\0\1\172\1\0\1\172\1\0\1\172\5\uffff\1\144\1\164\1\uffff"+
        "\1\146\1\151\1\147\1\164\1\uffff\1\145\1\uffff\1\154\1\165\1\145"+
        "\1\0\1\40\1\145\1\155\1\uffff\1\144\1\156\1\141\1\0\1\172\1\0\1"+
        "\172\1\0\1\uffff\1\0\1\172\1\0\1\172\1\0\1\uffff\1\0\1\uffff\1\172"+
        "\1\uffff\1\172\1\163\1\uffff\1\70\1\162\2\145\1\144\1\40\1\141\1"+
        "\uffff\1\145\1\147\1\uffff\1\0\1\172\2\0\1\172\1\0\1\uffff\1\0\1"+
        "\uffff\1\0\1\uffff\1\0\1\164\1\60\4\uffff\1\143\1\137\2\uffff\1"+
        "\172\1\0\1\172\1\0\1\uffff\2\0\1\uffff\1\137\1\uffff\1\162\1\156"+
        "\1\uffff\1\172\1\0\1\172\2\0\1\137\1\157\1\145\1\172\1\0\1\172\1"+
        "\0\1\uffff\1\137\1\170\1\172\1\0\1\172\1\0\1\145\1\164\1\172\1\0"+
        "\1\172\1\0\1\170\1\40\1\172\2\0\1\160\1\172\1\0\1\162\1\172\1\0"+
        "\1\145\1\172\1\0\1\163\1\172\1\0\1\163\1\172\1\0\1\151\1\172\1\0"+
        "\1\157\1\172\1\0\1\156\1\172\1\0\1\172\1\0";
    static final String DFA53_acceptS =
        "\7\uffff\1\12\1\uffff\1\14\1\uffff\1\16\1\17\21\uffff\1\71\1\72"+
        "\3\uffff\1\102\1\103\15\uffff\1\5\13\uffff\1\2\35\uffff\1\77\1\100"+
        "\24\uffff\1\76\1\uffff\1\73\1\74\2\uffff\1\101\13\uffff\1\5\7\uffff"+
        "\1\6\2\uffff\1\7\1\1\41\uffff\1\10\1\104\1\uffff\1\11\1\13\4\uffff"+
        "\1\37\1\20\1\21\1\22\1\23\1\uffff\1\53\3\uffff\1\27\3\uffff\1\31"+
        "\1\uffff\1\32\2\uffff\1\34\1\uffff\1\42\1\uffff\1\44\2\uffff\1\55"+
        "\2\uffff\1\60\1\57\1\uffff\1\62\2\uffff\1\64\1\uffff\1\75\10\uffff"+
        "\1\5\5\uffff\1\5\2\uffff\1\5\50\uffff\1\24\1\67\1\uffff\1\15\1\40"+
        "\1\41\1\25\1\26\1\uffff\1\50\1\30\1\uffff\1\46\1\33\1\35\1\36\1"+
        "\43\1\45\1\52\1\56\1\54\1\61\1\63\1\66\6\uffff\3\5\2\uffff\1\5\1"+
        "\uffff\1\5\2\uffff\2\5\4\uffff\1\5\35\uffff\1\5\5\uffff\1\65\1\51"+
        "\1\47\1\70\10\uffff\1\5\1\uffff\1\5\1\uffff\3\5\30\uffff\5\5\2\uffff"+
        "\1\5\4\uffff\1\5\1\uffff\1\5\30\uffff\1\3\1\uffff\1\5\2\uffff\1"+
        "\5\25\uffff\1\4\3\uffff\4\5\13\uffff\1\105\1\uffff\1\5\17\uffff"+
        "\1\5\53\uffff";
    static final String DFA53_specialS =
        "\107\uffff\1\36\1\uffff\1\35\1\37\3\uffff\1\60\1\42\1\41\1\44\1"+
        "\43\1\uffff\1\4\2\uffff\1\50\2\uffff\1\52\3\uffff\1\53\2\uffff\1"+
        "\55\1\uffff\1\63\1\uffff\1\65\2\uffff\1\2\2\uffff\1\17\1\20\1\uffff"+
        "\1\15\2\uffff\1\13\33\uffff\1\147\13\uffff\1\146\1\uffff\1\145\1"+
        "\uffff\1\144\2\uffff\1\143\1\uffff\1\142\1\uffff\1\141\1\uffff\1"+
        "\140\1\137\11\uffff\1\46\2\uffff\1\24\3\uffff\1\40\1\61\1\62\5\uffff"+
        "\1\45\1\uffff\1\47\1\uffff\1\7\1\uffff\1\51\1\uffff\1\11\1\uffff"+
        "\1\54\1\uffff\1\56\1\57\1\uffff\1\64\1\uffff\1\66\1\uffff\1\5\1"+
        "\21\1\uffff\1\3\1\16\2\uffff\1\14\1\uffff\1\23\33\uffff\1\150\11"+
        "\uffff\1\151\1\uffff\1\152\1\uffff\1\153\1\uffff\1\154\1\uffff\1"+
        "\155\1\uffff\1\156\1\uffff\1\157\1\uffff\1\160\14\uffff\1\12\5\uffff"+
        "\1\6\2\uffff\1\10\14\uffff\1\22\40\uffff\1\161\1\uffff\1\162\1\uffff"+
        "\1\163\1\uffff\1\164\1\uffff\1\165\1\uffff\1\166\1\uffff\1\167\1"+
        "\uffff\1\170\45\uffff\1\33\1\uffff\1\136\1\uffff\1\135\1\uffff\1"+
        "\134\1\u0080\1\133\1\uffff\1\132\1\uffff\1\131\1\uffff\1\130\23"+
        "\uffff\1\171\3\uffff\1\25\3\uffff\1\127\1\uffff\1\126\1\uffff\1"+
        "\125\1\174\1\32\1\uffff\1\124\1\uffff\1\123\1\175\1\122\15\uffff"+
        "\1\1\2\uffff\1\172\1\121\1\uffff\1\120\1\31\1\uffff\1\117\1\u0081"+
        "\1\116\1\177\1\115\1\uffff\1\34\10\uffff\1\0\1\67\1\uffff\1\114"+
        "\1\uffff\1\113\1\176\1\112\1\30\5\uffff\1\173\1\uffff\1\111\1\uffff"+
        "\1\110\1\27\4\uffff\1\107\1\uffff\1\106\4\uffff\1\105\1\uffff\1"+
        "\104\3\uffff\1\103\1\uffff\1\102\3\uffff\1\101\1\100\2\uffff\1\77"+
        "\2\uffff\1\76\2\uffff\1\75\2\uffff\1\74\2\uffff\1\73\2\uffff\1\72"+
        "\2\uffff\1\71\2\uffff\1\70\1\uffff\1\26}>";
    static final String[] DFA53_transitionS = {
            "\1\42\1\43\1\uffff\2\42\22\uffff\1\42\1\21\1\37\1\1\1\62\1\27"+
            "\1\30\1\36\1\13\1\14\1\26\1\25\1\7\1\12\1\34\1\24\1\40\11\41"+
            "\1\6\1\11\1\22\1\5\1\23\1\10\1\uffff\13\62\1\4\16\62\1\15\1"+
            "\44\1\16\1\33\1\45\1\uffff\1\47\1\61\1\52\1\3\1\46\1\55\1\60"+
            "\1\62\1\53\2\62\1\54\5\62\1\50\1\2\1\35\1\56\1\51\1\57\3\62"+
            "\1\17\1\31\1\20\1\32",
            "\1\65\2\uffff\2\65\22\uffff\1\65\2\uffff\1\64\1\75\34\uffff"+
            "\32\75\4\uffff\1\63\1\uffff\3\75\1\70\1\71\3\75\1\72\2\75\1"+
            "\66\3\75\1\74\4\75\1\67\1\75\1\73\3\75",
            "\1\103\2\uffff\1\101\1\77\12\uffff\1\100\2\uffff\1\102",
            "\1\104\11\uffff\1\105",
            "\1\37\4\uffff\1\36",
            "\1\106",
            "\1\110",
            "",
            "\1\uffff",
            "",
            "\1\115\17\uffff\1\114\1\113",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\123",
            "\1\126\1\125",
            "\1\130\1\131",
            "\1\134\4\uffff\1\135\15\uffff\1\133\36\uffff\1\134",
            "\1\140\21\uffff\1\137",
            "\1\142",
            "\1\144",
            "\1\146\26\uffff\1\147",
            "\1\152\76\uffff\1\151",
            "\1\uffff",
            "\1\155",
            "\1\157\3\uffff\1\160\1\uffff\12\162",
            "\1\163",
            "",
            "",
            "\1\162\1\uffff\10\166\2\162\12\uffff\3\162\21\uffff\1\164\13"+
            "\uffff\3\162\21\uffff\1\164",
            "\1\162\1\uffff\12\167\12\uffff\3\162\35\uffff\3\162",
            "\1\42\1\43\1\uffff\2\42\22\uffff\1\42",
            "",
            "",
            "\1\171",
            "\1\174\1\uffff\1\173\11\uffff\1\172",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0082\6\uffff\1\u0080\6\uffff\1\u0081",
            "\1\u0084\7\uffff\1\u0083",
            "\1\u0085",
            "\1\u0086\2\uffff\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "",
            "\1\u008c\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff"+
            "\1\u008e\1\uffff\32\u008e",
            "\1\u0090\34\uffff\32\u0090\4\uffff\1\u0090\1\uffff\32\u0090",
            "\1\65\2\uffff\2\65\22\uffff\1\65\2\uffff\2\u0090\34\uffff\32"+
            "\u0090\4\uffff\1\u0090\1\uffff\3\u0090\1\u0093\1\u0094\3\u0090"+
            "\1\u0095\2\u0090\1\u0091\3\u0090\1\u0097\4\u0090\1\u0092\1\u0090"+
            "\1\u0096\3\u0090",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\10\u008e\1\u0098\21\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u009a\14\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u009c\25\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u009f\5\u008e\1\u009e\2\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u00a1\14\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\1\u00a3\31\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u00a5\10\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\32\u008e",
            "",
            "\1\u00a9\22\uffff\1\u00a8",
            "\1\u00aa\20\uffff\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\u00b7",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\u00c3",
            "\1\uffff",
            "\1\uffff",
            "\1\u00c7",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\u00dd",
            "\1\uffff",
            "",
            "\1\u00df",
            "",
            "",
            "\1\162\1\uffff\10\166\2\162\12\uffff\3\162\35\uffff\3\162",
            "\1\162\1\uffff\12\167\12\uffff\3\162\35\uffff\3\162",
            "",
            "\1\u00e2\17\uffff\1\u00e1",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e9\1\u00e7\14\uffff\1\u00e8",
            "\1\u00ea\2\uffff\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f4\11\uffff\1\u00f3",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\32\u008e",
            "",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fd\5\uffff\1\u00fc",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u0101\14\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\3\u008e\1\u0103\26\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\5\u008e\1\u0105\24\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u0107\25\u008e",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u0109\10\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\2\u008e\1\u010b\27\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u010d\10\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\1\u010f\31\u008e",
            "\1\uffff",
            "\1\uffff",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0119\7\uffff\1\u0118",
            "\1\u011a",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\u0134",
            "",
            "\1\u0135",
            "\1\u0137\3\uffff\1\u0136",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141\1\u0142",
            "\1\u0143",
            "",
            "\1\u0144",
            "\1\u0145",
            "",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\uffff",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u0153\25\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u0155\25\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\10\u008e\1\u0157\21\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\2\u008e\1\u0159\27\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\16\u008e\1\u015b\13\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\13\u008e\1\u015d\16\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u015f\14\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\6\u008e\1\u0161\23\u008e",
            "\1\uffff",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "",
            "",
            "",
            "\1\u0176",
            "\1\u0177",
            "",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\u017a",
            "",
            "",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\5\u008e\1\u0189\24\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u018b\14\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u018d"+
            "\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u018f\10\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\24\u008e\1\u0191\5\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\10\u008e\1\u0193\21\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\14\u008e\1\u0195\15\u008e",
            "\1\uffff",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "",
            "",
            "",
            "",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "",
            "\1\u01a8",
            "",
            "\1\u01a9",
            "",
            "",
            "",
            "\1\u0090\13\uffff\12\u0090\7\uffff\32\u0090\4\uffff\1\u0090"+
            "\1\uffff\32\u0090",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\uffff",
            "\1\76\2\uffff\2\76\22\uffff\1\76\3\uffff\1\u008e\13\uffff\12"+
            "\u008e\7\uffff\32\u008e\4\uffff\1\u008e\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u01b3\25\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\14\u008e\1\u01b5\15\u008e",
            "\1\uffff",
            "\12\76\1\uffff\31\76\1\u01b7\13\76\12\u01b7\7\76\32\u01b7\4"+
            "\76\1\u01b7\1\76\32\u01b7\uff85\76",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\3\u008e\1\u01b9\26\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u01bb\14\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\1\u01bd\31\u008e",
            "\1\uffff",
            "\1\62\13\uffff\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32"+
            "\62",
            "",
            "",
            "",
            "",
            "",
            "\1\u01c0",
            "\1\u01c1",
            "",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "\1\u01c5",
            "",
            "\1\u01c6",
            "",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "\1\uffff",
            "\1\76\2\uffff\2\76\22\uffff\1\76",
            "\1\u01ca",
            "\1\u01cb",
            "\12\76\1\uffff\31\76\1\u01cc\13\76\12\u01cc\7\76\32\u01cc\4"+
            "\76\1\u01cc\1\76\32\u01cc\uff85\76",
            "\1\u01cd",
            "\1\u01ce",
            "\1\u01cf",
            "\1\uffff",
            "\1\76\2\uffff\2\76\22\uffff\1\76\3\uffff\1\u008e\13\uffff\12"+
            "\u008e\7\uffff\32\u008e\4\uffff\1\u008e\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\1\u01d1\31\u008e",
            "\1\uffff",
            "\12\76\1\uffff\31\76\1\u01b7\13\76\12\u01b7\7\76\32\u01b7\4"+
            "\76\1\u01b7\1\76\32\u01b7\uff85\76",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u01d4\25\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\6\u008e\1\u01d6\23\u008e",
            "\1\uffff",
            "\12\76\1\uffff\31\76\1\u01d8\13\76\12\u01d8\7\76\32\u01d8\4"+
            "\76\1\u01d8\1\76\32\u01d8\uff85\76",
            "\1\uffff",
            "",
            "\1\62\13\uffff\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32"+
            "\62",
            "",
            "\1\62\13\uffff\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32"+
            "\62",
            "\1\u01dc",
            "",
            "\1\u01dd",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "\1\76\2\uffff\2\76\22\uffff\1\76",
            "\1\u01e2",
            "\12\76\1\uffff\31\76\1\u01cc\13\76\12\u01cc\7\76\32\u01cc\4"+
            "\76\1\u01cc\1\76\32\u01cc\uff85\76",
            "\1\u01e3",
            "\1\u01e4",
            "\12\76\1\uffff\31\76\1\u01e5\13\76\12\u01e5\7\76\32\u01e5\4"+
            "\76\1\u01e5\1\76\32\u01e5\uff85\76",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\2\u008e\1\u01e6\27\u008e",
            "\1\uffff",
            "\1\uffff",
            "\1\76\2\uffff\2\76\22\uffff\1\76\3\uffff\1\u008e\13\uffff\12"+
            "\u008e\7\uffff\32\u008e\4\uffff\1\u01e8\1\uffff\32\u008e",
            "\1\uffff",
            "\12\76\1\uffff\31\76\1\u01ea\13\76\12\u01ea\7\76\32\u01ea\4"+
            "\76\1\u01ea\1\76\32\u01ea\uff85\76",
            "\1\uffff",
            "\12\76\1\uffff\31\76\1\u01d8\13\76\12\u01d8\7\76\32\u01d8\4"+
            "\76\1\u01d8\1\76\32\u01d8\uff85\76",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\u01ee",
            "\1\u01ef",
            "",
            "",
            "",
            "",
            "\1\u01f0",
            "\1\76\2\uffff\2\76\22\uffff\1\76\76\uffff\1\u01f1",
            "\12\76\1\uffff\31\76\1\u01f2\13\76\12\u01f2\7\76\32\u01f2\4"+
            "\76\1\u01f2\1\76\32\u01f2\uff85\76",
            "\12\76\1\uffff\31\76\1\u01e5\13\76\12\u01e5\7\76\32\u01e5\4"+
            "\76\1\u01e5\1\76\32\u01e5\uff85\76",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u01f3\10\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u01f5\14\u008e",
            "\1\uffff",
            "\12\76\1\uffff\31\76\1\u01ea\13\76\12\u01ea\7\76\32\u01ea\4"+
            "\76\1\u01ea\1\76\32\u01ea\uff85\76",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\u01f8",
            "",
            "\1\u01f9",
            "\1\u01fa",
            "\12\76\1\uffff\31\76\1\u01f2\13\76\12\u01f2\7\76\32\u01f2\4"+
            "\76\1\u01f2\1\76\32\u01f2\uff85\76",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\16\u008e\1\u01fb\13\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u01fd\25\u008e",
            "\1\uffff",
            "\1\uffff",
            "\1\u01ff",
            "\1\u0200",
            "\1\u0201",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u0202"+
            "\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\27\u008e\1\u0204\2\u008e",
            "\1\uffff",
            "",
            "\1\u0206",
            "\1\u0207",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u0208\25\u008e",
            "\1\uffff",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\23\u008e\1\u020a\6\u008e",
            "\1\uffff",
            "\1\u020c",
            "\1\u020d",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\27\u008e\1\u020e\2\u008e",
            "\1\uffff",
            "\1\76\2\uffff\2\76\22\uffff\1\76\3\uffff\1\u008e\13\uffff\12"+
            "\u008e\7\uffff\32\u008e\4\uffff\1\u008e\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u0211",
            "\1\76\2\uffff\2\76\22\uffff\1\76",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\17\u008e\1\u0212\12\u008e",
            "\1\uffff",
            "\1\uffff",
            "\1\u0214",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\21\u008e\1\u0215\10\u008e",
            "\1\uffff",
            "\1\u0217",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\4\u008e\1\u0218\25\u008e",
            "\1\uffff",
            "\1\u021a",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\22\u008e\1\u021b\7\u008e",
            "\1\uffff",
            "\1\u021d",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\22\u008e\1\u021e\7\u008e",
            "\1\uffff",
            "\1\u0220",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\10\u008e\1\u0221\21\u008e",
            "\1\uffff",
            "\1\u0223",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\16\u008e\1\u0224\13\u008e",
            "\1\uffff",
            "\1\u0226",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\15\u008e\1\u0227\14\u008e",
            "\1\uffff",
            "\1\u0229",
            "\1\u008e\13\uffff\12\u008e\7\uffff\32\u008e\4\uffff\1\u008e"+
            "\1\uffff\32\u008e",
            "\1\uffff",
            "\1\u0090\13\uffff\12\u0090\7\uffff\32\u0090\4\uffff\1\u0090"+
            "\1\uffff\32\u0090",
            "\1\uffff"
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( STRING_OP | DIRECTIVE | SIZEOF | DEFINED | IDENTIFIER | STRINGIFICATION | SHARPSHARP | ASSIGNEQUAL | COLON | COMMA | QUESTIONMARK | SEMICOLON | POINTERTO | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | EQUAL | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | DIVIDE | DIVIDEEQUAL | PLUS | PLUSEQUAL | PLUSPLUS | MINUS | MINUSEQUAL | MINUSMINUS | STAR | TIMESEQUAL | MOD | MODEQUAL | SHIFTRIGHT | SHIFTRIGHTEQUAL | SHIFTLEFT | SHIFTLEFTEQUAL | AND | NOT | OR | AMPERSAND | BITWISEANDEQUAL | TILDE | BITWISEOR | BITWISEOREQUAL | BITWISEXOR | BITWISEXOREQUAL | DOT | POINTERTOMBR | DOTMBR | SCOPE | ELLIPSIS | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | COMMENT | LINE_COMMENT | WS | End | ESCAPED_NEWLINE | COPERATOR | CKEYWORD );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA53_484 = input.LA(1);

                        s = -1;
                        if ( ((LA53_484 >= '\u0000' && LA53_484 <= '\t')||(LA53_484 >= '\u000B' && LA53_484 <= '#')||(LA53_484 >= '%' && LA53_484 <= '/')||(LA53_484 >= ':' && LA53_484 <= '@')||(LA53_484 >= '[' && LA53_484 <= '^')||LA53_484=='`'||(LA53_484 >= '{' && LA53_484 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_484=='$'||(LA53_484 >= '0' && LA53_484 <= '9')||(LA53_484 >= 'A' && LA53_484 <= 'Z')||LA53_484=='_'||(LA53_484 >= 'a' && LA53_484 <= 'z')) ) {s = 498;}

                        else s = 144;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA53_460 = input.LA(1);

                        s = -1;
                        if ( ((LA53_460 >= '\u0000' && LA53_460 <= '\t')||(LA53_460 >= '\u000B' && LA53_460 <= '#')||(LA53_460 >= '%' && LA53_460 <= '/')||(LA53_460 >= ':' && LA53_460 <= '@')||(LA53_460 >= '[' && LA53_460 <= '^')||LA53_460=='`'||(LA53_460 >= '{' && LA53_460 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_460=='$'||(LA53_460 >= '0' && LA53_460 <= '9')||(LA53_460 >= 'A' && LA53_460 <= 'Z')||LA53_460=='_'||(LA53_460 >= 'a' && LA53_460 <= 'z')) ) {s = 460;}

                        else s = 426;

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA53_104 = input.LA(1);

                         
                        int index53_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 213;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_104);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA53_214 = input.LA(1);

                         
                        int index53_214 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 303;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_214);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA53_84 = input.LA(1);

                         
                        int index53_84 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 193;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_84);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA53_211 = input.LA(1);

                         
                        int index53_211 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 301;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_211);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA53_291 = input.LA(1);

                         
                        int index53_291 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 366;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_291);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA53_196 = input.LA(1);

                         
                        int index53_196 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 292;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_196);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA53_294 = input.LA(1);

                         
                        int index53_294 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 367;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_294);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA53_200 = input.LA(1);

                         
                        int index53_200 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 295;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_200);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA53_285 = input.LA(1);

                         
                        int index53_285 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 365;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_285);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA53_113 = input.LA(1);

                         
                        int index53_113 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 222;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_113);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA53_218 = input.LA(1);

                         
                        int index53_218 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 305;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_218);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA53_110 = input.LA(1);

                         
                        int index53_110 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 219;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_110);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA53_215 = input.LA(1);

                         
                        int index53_215 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 304;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_215);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA53_107 = input.LA(1);

                         
                        int index53_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 216;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_107);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA53_108 = input.LA(1);

                         
                        int index53_108 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 217;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_108);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA53_212 = input.LA(1);

                         
                        int index53_212 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 302;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_212);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA53_307 = input.LA(1);

                         
                        int index53_307 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 368;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_307);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA53_220 = input.LA(1);

                         
                        int index53_220 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 306;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_220);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA53_180 = input.LA(1);

                         
                        int index53_180 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 284;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_180);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA53_430 = input.LA(1);

                        s = -1;
                        if ( ((LA53_430 >= '\u0000' && LA53_430 <= '\t')||(LA53_430 >= '\u000B' && LA53_430 <= '#')||(LA53_430 >= '%' && LA53_430 <= '/')||(LA53_430 >= ':' && LA53_430 <= '@')||(LA53_430 >= '[' && LA53_430 <= '^')||LA53_430=='`'||(LA53_430 >= '{' && LA53_430 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_430=='$'||(LA53_430 >= '0' && LA53_430 <= '9')||(LA53_430 >= 'A' && LA53_430 <= 'Z')||LA53_430=='_'||(LA53_430 >= 'a' && LA53_430 <= 'z')) ) {s = 460;}

                        else s = 426;

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA53_554 = input.LA(1);

                         
                        int index53_554 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_554);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA53_503 = input.LA(1);

                         
                        int index53_503 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_503);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA53_492 = input.LA(1);

                         
                        int index53_492 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_492);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA53_467 = input.LA(1);

                         
                        int index53_467 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_467);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA53_440 = input.LA(1);

                         
                        int index53_440 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_440);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA53_392 = input.LA(1);

                         
                        int index53_392 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_392);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA53_475 = input.LA(1);

                         
                        int index53_475 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 50;}

                        else if ( ((!inDirective)) ) {s = 493;}

                         
                        input.seek(index53_475);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA53_73 = input.LA(1);

                         
                        int index53_73 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 181;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_73);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA53_71 = input.LA(1);

                         
                        int index53_71 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 178;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_71);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA53_74 = input.LA(1);

                         
                        int index53_74 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 182;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_74);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA53_184 = input.LA(1);

                         
                        int index53_184 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 286;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_184);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA53_80 = input.LA(1);

                         
                        int index53_80 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 189;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_80);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA53_79 = input.LA(1);

                         
                        int index53_79 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 188;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_79);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA53_82 = input.LA(1);

                         
                        int index53_82 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 191;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_82);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA53_81 = input.LA(1);

                         
                        int index53_81 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 190;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_81);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA53_192 = input.LA(1);

                         
                        int index53_192 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 289;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_192);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA53_177 = input.LA(1);

                         
                        int index53_177 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 283;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_177);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA53_194 = input.LA(1);

                         
                        int index53_194 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 290;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_194);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA53_87 = input.LA(1);

                         
                        int index53_87 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 197;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_87);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA53_198 = input.LA(1);

                         
                        int index53_198 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 293;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_198);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA53_90 = input.LA(1);

                         
                        int index53_90 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 201;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_90);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA53_94 = input.LA(1);

                         
                        int index53_94 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 203;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_94);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA53_202 = input.LA(1);

                         
                        int index53_202 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 296;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_202);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA53_97 = input.LA(1);

                         
                        int index53_97 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 206;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_97);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA53_204 = input.LA(1);

                         
                        int index53_204 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 297;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_204);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA53_205 = input.LA(1);

                         
                        int index53_205 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 298;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_205);

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA53_78 = input.LA(1);

                         
                        int index53_78 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 187;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_78);

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA53_185 = input.LA(1);

                         
                        int index53_185 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 287;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_185);

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA53_186 = input.LA(1);

                         
                        int index53_186 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 288;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_186);

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA53_99 = input.LA(1);

                         
                        int index53_99 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 208;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_99);

                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA53_207 = input.LA(1);

                         
                        int index53_207 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 299;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_207);

                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA53_101 = input.LA(1);

                         
                        int index53_101 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 210;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_101);

                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA53_209 = input.LA(1);

                         
                        int index53_209 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((!inDirective)))) ) {s = 300;}

                        else if ( ((!inDirective)) ) {s = 179;}

                         
                        input.seek(index53_209);

                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA53_485 = input.LA(1);

                        s = -1;
                        if ( ((LA53_485 >= '\u0000' && LA53_485 <= '\t')||(LA53_485 >= '\u000B' && LA53_485 <= '#')||(LA53_485 >= '%' && LA53_485 <= '/')||(LA53_485 >= ':' && LA53_485 <= '@')||(LA53_485 >= '[' && LA53_485 <= '^')||LA53_485=='`'||(LA53_485 >= '{' && LA53_485 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_485=='$'||(LA53_485 >= '0' && LA53_485 <= '9')||(LA53_485 >= 'A' && LA53_485 <= 'Z')||LA53_485=='_'||(LA53_485 >= 'a' && LA53_485 <= 'z')) ) {s = 485;}

                        else s = 426;

                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA53_552 = input.LA(1);

                         
                        int index53_552 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_552);

                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA53_549 = input.LA(1);

                         
                        int index53_549 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_549);

                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA53_546 = input.LA(1);

                         
                        int index53_546 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_546);

                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA53_543 = input.LA(1);

                         
                        int index53_543 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_543);

                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA53_540 = input.LA(1);

                         
                        int index53_540 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_540);

                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA53_537 = input.LA(1);

                         
                        int index53_537 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_537);

                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA53_534 = input.LA(1);

                         
                        int index53_534 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_534);

                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA53_531 = input.LA(1);

                         
                        int index53_531 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_531);

                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA53_528 = input.LA(1);

                         
                        int index53_528 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_528);

                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA53_527 = input.LA(1);

                         
                        int index53_527 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_527);

                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA53_523 = input.LA(1);

                         
                        int index53_523 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_523);

                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA53_521 = input.LA(1);

                         
                        int index53_521 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_521);

                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA53_517 = input.LA(1);

                         
                        int index53_517 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_517);

                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA53_515 = input.LA(1);

                         
                        int index53_515 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_515);

                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA53_510 = input.LA(1);

                         
                        int index53_510 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_510);

                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA53_508 = input.LA(1);

                         
                        int index53_508 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_508);

                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA53_502 = input.LA(1);

                         
                        int index53_502 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_502);

                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA53_500 = input.LA(1);

                         
                        int index53_500 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_500);

                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA53_491 = input.LA(1);

                         
                        int index53_491 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_491);

                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA53_489 = input.LA(1);

                         
                        int index53_489 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_489);

                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA53_487 = input.LA(1);

                         
                        int index53_487 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_487);

                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA53_473 = input.LA(1);

                         
                        int index53_473 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_473);

                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA53_471 = input.LA(1);

                         
                        int index53_471 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_471);

                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA53_469 = input.LA(1);

                         
                        int index53_469 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_469);

                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA53_466 = input.LA(1);

                         
                        int index53_466 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_466);

                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA53_464 = input.LA(1);

                         
                        int index53_464 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_464);

                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA53_446 = input.LA(1);

                         
                        int index53_446 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_446);

                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA53_444 = input.LA(1);

                         
                        int index53_444 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_444);

                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA53_442 = input.LA(1);

                         
                        int index53_442 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_442);

                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA53_438 = input.LA(1);

                         
                        int index53_438 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_438);

                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA53_436 = input.LA(1);

                         
                        int index53_436 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_436);

                        if ( s>=0 ) return s;
                        break;

                    case 87 : 
                        int LA53_434 = input.LA(1);

                         
                        int index53_434 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_434);

                        if ( s>=0 ) return s;
                        break;

                    case 88 : 
                        int LA53_406 = input.LA(1);

                         
                        int index53_406 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_406);

                        if ( s>=0 ) return s;
                        break;

                    case 89 : 
                        int LA53_404 = input.LA(1);

                         
                        int index53_404 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_404);

                        if ( s>=0 ) return s;
                        break;

                    case 90 : 
                        int LA53_402 = input.LA(1);

                         
                        int index53_402 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_402);

                        if ( s>=0 ) return s;
                        break;

                    case 91 : 
                        int LA53_400 = input.LA(1);

                         
                        int index53_400 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_400);

                        if ( s>=0 ) return s;
                        break;

                    case 92 : 
                        int LA53_398 = input.LA(1);

                         
                        int index53_398 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_398);

                        if ( s>=0 ) return s;
                        break;

                    case 93 : 
                        int LA53_396 = input.LA(1);

                         
                        int index53_396 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_396);

                        if ( s>=0 ) return s;
                        break;

                    case 94 : 
                        int LA53_394 = input.LA(1);

                         
                        int index53_394 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_394);

                        if ( s>=0 ) return s;
                        break;

                    case 95 : 
                        int LA53_167 = input.LA(1);

                         
                        int index53_167 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_167);

                        if ( s>=0 ) return s;
                        break;

                    case 96 : 
                        int LA53_166 = input.LA(1);

                         
                        int index53_166 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_166);

                        if ( s>=0 ) return s;
                        break;

                    case 97 : 
                        int LA53_164 = input.LA(1);

                         
                        int index53_164 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_164);

                        if ( s>=0 ) return s;
                        break;

                    case 98 : 
                        int LA53_162 = input.LA(1);

                         
                        int index53_162 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_162);

                        if ( s>=0 ) return s;
                        break;

                    case 99 : 
                        int LA53_160 = input.LA(1);

                         
                        int index53_160 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_160);

                        if ( s>=0 ) return s;
                        break;

                    case 100 : 
                        int LA53_157 = input.LA(1);

                         
                        int index53_157 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_157);

                        if ( s>=0 ) return s;
                        break;

                    case 101 : 
                        int LA53_155 = input.LA(1);

                         
                        int index53_155 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_155);

                        if ( s>=0 ) return s;
                        break;

                    case 102 : 
                        int LA53_153 = input.LA(1);

                         
                        int index53_153 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_153);

                        if ( s>=0 ) return s;
                        break;

                    case 103 : 
                        int LA53_141 = input.LA(1);

                         
                        int index53_141 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_141);

                        if ( s>=0 ) return s;
                        break;

                    case 104 : 
                        int LA53_248 = input.LA(1);

                         
                        int index53_248 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_248);

                        if ( s>=0 ) return s;
                        break;

                    case 105 : 
                        int LA53_258 = input.LA(1);

                         
                        int index53_258 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_258);

                        if ( s>=0 ) return s;
                        break;

                    case 106 : 
                        int LA53_260 = input.LA(1);

                         
                        int index53_260 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_260);

                        if ( s>=0 ) return s;
                        break;

                    case 107 : 
                        int LA53_262 = input.LA(1);

                         
                        int index53_262 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_262);

                        if ( s>=0 ) return s;
                        break;

                    case 108 : 
                        int LA53_264 = input.LA(1);

                         
                        int index53_264 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_264);

                        if ( s>=0 ) return s;
                        break;

                    case 109 : 
                        int LA53_266 = input.LA(1);

                         
                        int index53_266 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_266);

                        if ( s>=0 ) return s;
                        break;

                    case 110 : 
                        int LA53_268 = input.LA(1);

                         
                        int index53_268 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_268);

                        if ( s>=0 ) return s;
                        break;

                    case 111 : 
                        int LA53_270 = input.LA(1);

                         
                        int index53_270 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_270);

                        if ( s>=0 ) return s;
                        break;

                    case 112 : 
                        int LA53_272 = input.LA(1);

                         
                        int index53_272 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_272);

                        if ( s>=0 ) return s;
                        break;

                    case 113 : 
                        int LA53_340 = input.LA(1);

                         
                        int index53_340 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_340);

                        if ( s>=0 ) return s;
                        break;

                    case 114 : 
                        int LA53_342 = input.LA(1);

                         
                        int index53_342 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_342);

                        if ( s>=0 ) return s;
                        break;

                    case 115 : 
                        int LA53_344 = input.LA(1);

                         
                        int index53_344 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_344);

                        if ( s>=0 ) return s;
                        break;

                    case 116 : 
                        int LA53_346 = input.LA(1);

                         
                        int index53_346 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_346);

                        if ( s>=0 ) return s;
                        break;

                    case 117 : 
                        int LA53_348 = input.LA(1);

                         
                        int index53_348 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_348);

                        if ( s>=0 ) return s;
                        break;

                    case 118 : 
                        int LA53_350 = input.LA(1);

                         
                        int index53_350 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_350);

                        if ( s>=0 ) return s;
                        break;

                    case 119 : 
                        int LA53_352 = input.LA(1);

                         
                        int index53_352 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_352);

                        if ( s>=0 ) return s;
                        break;

                    case 120 : 
                        int LA53_354 = input.LA(1);

                         
                        int index53_354 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( (true) ) {s = 50;}

                         
                        input.seek(index53_354);

                        if ( s>=0 ) return s;
                        break;

                    case 121 : 
                        int LA53_426 = input.LA(1);

                         
                        int index53_426 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((inDefineMode)) ) {s = 144;}

                        else if ( ((!inDirective && !inDefineMode)) ) {s = 62;}

                         
                        input.seek(index53_426);

                        if ( s>=0 ) return s;
                        break;

                    case 122 : 
                        int LA53_463 = input.LA(1);

                        s = -1;
                        if ( ((LA53_463 >= '\u0000' && LA53_463 <= '\t')||(LA53_463 >= '\u000B' && LA53_463 <= '#')||(LA53_463 >= '%' && LA53_463 <= '/')||(LA53_463 >= ':' && LA53_463 <= '@')||(LA53_463 >= '[' && LA53_463 <= '^')||LA53_463=='`'||(LA53_463 >= '{' && LA53_463 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_463=='$'||(LA53_463 >= '0' && LA53_463 <= '9')||(LA53_463 >= 'A' && LA53_463 <= 'Z')||LA53_463=='_'||(LA53_463 >= 'a' && LA53_463 <= 'z')) ) {s = 485;}

                        else s = 144;

                        if ( s>=0 ) return s;
                        break;

                    case 123 : 
                        int LA53_498 = input.LA(1);

                        s = -1;
                        if ( ((LA53_498 >= '\u0000' && LA53_498 <= '\t')||(LA53_498 >= '\u000B' && LA53_498 <= '#')||(LA53_498 >= '%' && LA53_498 <= '/')||(LA53_498 >= ':' && LA53_498 <= '@')||(LA53_498 >= '[' && LA53_498 <= '^')||LA53_498=='`'||(LA53_498 >= '{' && LA53_498 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_498=='$'||(LA53_498 >= '0' && LA53_498 <= '9')||(LA53_498 >= 'A' && LA53_498 <= 'Z')||LA53_498=='_'||(LA53_498 >= 'a' && LA53_498 <= 'z')) ) {s = 498;}

                        else s = 426;

                        if ( s>=0 ) return s;
                        break;

                    case 124 : 
                        int LA53_439 = input.LA(1);

                        s = -1;
                        if ( ((LA53_439 >= '\u0000' && LA53_439 <= '\t')||(LA53_439 >= '\u000B' && LA53_439 <= '#')||(LA53_439 >= '%' && LA53_439 <= '/')||(LA53_439 >= ':' && LA53_439 <= '@')||(LA53_439 >= '[' && LA53_439 <= '^')||LA53_439=='`'||(LA53_439 >= '{' && LA53_439 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_439=='$'||(LA53_439 >= '0' && LA53_439 <= '9')||(LA53_439 >= 'A' && LA53_439 <= 'Z')||LA53_439=='_'||(LA53_439 >= 'a' && LA53_439 <= 'z')) ) {s = 439;}

                        else s = 467;

                        if ( s>=0 ) return s;
                        break;

                    case 125 : 
                        int LA53_445 = input.LA(1);

                        s = -1;
                        if ( ((LA53_445 >= '\u0000' && LA53_445 <= '\t')||(LA53_445 >= '\u000B' && LA53_445 <= '#')||(LA53_445 >= '%' && LA53_445 <= '/')||(LA53_445 >= ':' && LA53_445 <= '@')||(LA53_445 >= '[' && LA53_445 <= '^')||LA53_445=='`'||(LA53_445 >= '{' && LA53_445 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_445=='$'||(LA53_445 >= '0' && LA53_445 <= '9')||(LA53_445 >= 'A' && LA53_445 <= 'Z')||LA53_445=='_'||(LA53_445 >= 'a' && LA53_445 <= 'z')) ) {s = 472;}

                        else s = 473;

                        if ( s>=0 ) return s;
                        break;

                    case 126 : 
                        int LA53_490 = input.LA(1);

                        s = -1;
                        if ( ((LA53_490 >= '\u0000' && LA53_490 <= '\t')||(LA53_490 >= '\u000B' && LA53_490 <= '#')||(LA53_490 >= '%' && LA53_490 <= '/')||(LA53_490 >= ':' && LA53_490 <= '@')||(LA53_490 >= '[' && LA53_490 <= '^')||LA53_490=='`'||(LA53_490 >= '{' && LA53_490 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_490=='$'||(LA53_490 >= '0' && LA53_490 <= '9')||(LA53_490 >= 'A' && LA53_490 <= 'Z')||LA53_490=='_'||(LA53_490 >= 'a' && LA53_490 <= 'z')) ) {s = 490;}

                        else s = 503;

                        if ( s>=0 ) return s;
                        break;

                    case 127 : 
                        int LA53_472 = input.LA(1);

                        s = -1;
                        if ( ((LA53_472 >= '\u0000' && LA53_472 <= '\t')||(LA53_472 >= '\u000B' && LA53_472 <= '#')||(LA53_472 >= '%' && LA53_472 <= '/')||(LA53_472 >= ':' && LA53_472 <= '@')||(LA53_472 >= '[' && LA53_472 <= '^')||LA53_472=='`'||(LA53_472 >= '{' && LA53_472 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_472=='$'||(LA53_472 >= '0' && LA53_472 <= '9')||(LA53_472 >= 'A' && LA53_472 <= 'Z')||LA53_472=='_'||(LA53_472 >= 'a' && LA53_472 <= 'z')) ) {s = 472;}

                        else s = 492;

                        if ( s>=0 ) return s;
                        break;

                    case 128 : 
                        int LA53_399 = input.LA(1);

                        s = -1;
                        if ( ((LA53_399 >= '\u0000' && LA53_399 <= '\t')||(LA53_399 >= '\u000B' && LA53_399 <= '#')||(LA53_399 >= '%' && LA53_399 <= '/')||(LA53_399 >= ':' && LA53_399 <= '@')||(LA53_399 >= '[' && LA53_399 <= '^')||LA53_399=='`'||(LA53_399 >= '{' && LA53_399 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_399=='$'||(LA53_399 >= '0' && LA53_399 <= '9')||(LA53_399 >= 'A' && LA53_399 <= 'Z')||LA53_399=='_'||(LA53_399 >= 'a' && LA53_399 <= 'z')) ) {s = 439;}

                        else s = 440;

                        if ( s>=0 ) return s;
                        break;

                    case 129 : 
                        int LA53_470 = input.LA(1);

                        s = -1;
                        if ( ((LA53_470 >= '\u0000' && LA53_470 <= '\t')||(LA53_470 >= '\u000B' && LA53_470 <= '#')||(LA53_470 >= '%' && LA53_470 <= '/')||(LA53_470 >= ':' && LA53_470 <= '@')||(LA53_470 >= '[' && LA53_470 <= '^')||LA53_470=='`'||(LA53_470 >= '{' && LA53_470 <= '\uFFFF')) ) {s = 62;}

                        else if ( (LA53_470=='$'||(LA53_470 >= '0' && LA53_470 <= '9')||(LA53_470 >= 'A' && LA53_470 <= 'Z')||LA53_470=='_'||(LA53_470 >= 'a' && LA53_470 <= 'z')) ) {s = 490;}

                        else s = 491;

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 53, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}