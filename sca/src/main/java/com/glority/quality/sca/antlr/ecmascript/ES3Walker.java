package com.glority.quality.sca.antlr.ecmascript;

// $ANTLR 3.4 ES3Walker.g3 2012-09-18 13:00:53

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ES3Walker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABSTRACT", "ADD", "ADDASS", "AND", "ANDASS", "ARGS", "ARRAY", "ASSIGN", "BLOCK", "BOOLEAN", "BREAK", "BSLASH", "BYFIELD", "BYINDEX", "BYTE", "BackslashSequence", "CALL", "CASE", "CATCH", "CEXPR", "CHAR", "CLASS", "COLON", "COMMA", "CONST", "CONTINUE", "CR", "CharacterEscapeSequence", "DEBUGGER", "DEC", "DEFAULT", "DELETE", "DIV", "DIVASS", "DO", "DOT", "DOUBLE", "DQUOTE", "DecimalDigit", "DecimalIntegerLiteral", "DecimalLiteral", "ELSE", "ENUM", "EOL", "EQ", "EXPORT", "EXPR", "EXTENDS", "EscapeSequence", "ExponentPart", "FALSE", "FF", "FINAL", "FINALLY", "FLOAT", "FOR", "FORITER", "FORSTEP", "FUNCTION", "GOTO", "GT", "GTE", "HexDigit", "HexEscapeSequence", "HexIntegerLiteral", "IF", "IMPLEMENTS", "IMPORT", "IN", "INC", "INSTANCEOF", "INT", "INTERFACE", "INV", "ITEM", "Identifier", "IdentifierNameASCIIStart", "IdentifierPart", "IdentifierStartASCII", "LABELLED", "LAND", "LBRACE", "LBRACK", "LF", "LONG", "LOR", "LPAREN", "LS", "LT", "LTE", "LineTerminator", "MOD", "MODASS", "MUL", "MULASS", "MultiLineComment", "NAMEDVALUE", "NATIVE", "NBSP", "NEG", "NEQ", "NEW", "NOT", "NSAME", "NULL", "OBJECT", "OR", "ORASS", "OctalDigit", "OctalEscapeSequence", "OctalIntegerLiteral", "PACKAGE", "PAREXPR", "PDEC", "PINC", "POS", "PRIVATE", "PROTECTED", "PS", "PUBLIC", "QUE", "RBRACE", "RBRACK", "RETURN", "RPAREN", "RegularExpressionChar", "RegularExpressionFirstChar", "RegularExpressionLiteral", "SAME", "SEMIC", "SHL", "SHLASS", "SHORT", "SHR", "SHRASS", "SHU", "SHUASS", "SP", "SQUOTE", "STATIC", "SUB", "SUBASS", "SUPER", "SWITCH", "SYNCHRONIZED", "SingleLineComment", "StringLiteral", "TAB", "THIS", "THROW", "THROWS", "TRANSIENT", "TRUE", "TRY", "TYPEOF", "USP", "UnicodeEscapeSequence", "VAR", "VOID", "VOLATILE", "VT", "WHILE", "WITH", "WhiteSpace", "XOR", "XORASS", "ZeroToThree"
    };

    public static final int EOF=-1;
    public static final int ABSTRACT=4;
    public static final int ADD=5;
    public static final int ADDASS=6;
    public static final int AND=7;
    public static final int ANDASS=8;
    public static final int ARGS=9;
    public static final int ARRAY=10;
    public static final int ASSIGN=11;
    public static final int BLOCK=12;
    public static final int BOOLEAN=13;
    public static final int BREAK=14;
    public static final int BSLASH=15;
    public static final int BYFIELD=16;
    public static final int BYINDEX=17;
    public static final int BYTE=18;
    public static final int BackslashSequence=19;
    public static final int CALL=20;
    public static final int CASE=21;
    public static final int CATCH=22;
    public static final int CEXPR=23;
    public static final int CHAR=24;
    public static final int CLASS=25;
    public static final int COLON=26;
    public static final int COMMA=27;
    public static final int CONST=28;
    public static final int CONTINUE=29;
    public static final int CR=30;
    public static final int CharacterEscapeSequence=31;
    public static final int DEBUGGER=32;
    public static final int DEC=33;
    public static final int DEFAULT=34;
    public static final int DELETE=35;
    public static final int DIV=36;
    public static final int DIVASS=37;
    public static final int DO=38;
    public static final int DOT=39;
    public static final int DOUBLE=40;
    public static final int DQUOTE=41;
    public static final int DecimalDigit=42;
    public static final int DecimalIntegerLiteral=43;
    public static final int DecimalLiteral=44;
    public static final int ELSE=45;
    public static final int ENUM=46;
    public static final int EOL=47;
    public static final int EQ=48;
    public static final int EXPORT=49;
    public static final int EXPR=50;
    public static final int EXTENDS=51;
    public static final int EscapeSequence=52;
    public static final int ExponentPart=53;
    public static final int FALSE=54;
    public static final int FF=55;
    public static final int FINAL=56;
    public static final int FINALLY=57;
    public static final int FLOAT=58;
    public static final int FOR=59;
    public static final int FORITER=60;
    public static final int FORSTEP=61;
    public static final int FUNCTION=62;
    public static final int GOTO=63;
    public static final int GT=64;
    public static final int GTE=65;
    public static final int HexDigit=66;
    public static final int HexEscapeSequence=67;
    public static final int HexIntegerLiteral=68;
    public static final int IF=69;
    public static final int IMPLEMENTS=70;
    public static final int IMPORT=71;
    public static final int IN=72;
    public static final int INC=73;
    public static final int INSTANCEOF=74;
    public static final int INT=75;
    public static final int INTERFACE=76;
    public static final int INV=77;
    public static final int ITEM=78;
    public static final int Identifier=79;
    public static final int IdentifierNameASCIIStart=80;
    public static final int IdentifierPart=81;
    public static final int IdentifierStartASCII=82;
    public static final int LABELLED=83;
    public static final int LAND=84;
    public static final int LBRACE=85;
    public static final int LBRACK=86;
    public static final int LF=87;
    public static final int LONG=88;
    public static final int LOR=89;
    public static final int LPAREN=90;
    public static final int LS=91;
    public static final int LT=92;
    public static final int LTE=93;
    public static final int LineTerminator=94;
    public static final int MOD=95;
    public static final int MODASS=96;
    public static final int MUL=97;
    public static final int MULASS=98;
    public static final int MultiLineComment=99;
    public static final int NAMEDVALUE=100;
    public static final int NATIVE=101;
    public static final int NBSP=102;
    public static final int NEG=103;
    public static final int NEQ=104;
    public static final int NEW=105;
    public static final int NOT=106;
    public static final int NSAME=107;
    public static final int NULL=108;
    public static final int OBJECT=109;
    public static final int OR=110;
    public static final int ORASS=111;
    public static final int OctalDigit=112;
    public static final int OctalEscapeSequence=113;
    public static final int OctalIntegerLiteral=114;
    public static final int PACKAGE=115;
    public static final int PAREXPR=116;
    public static final int PDEC=117;
    public static final int PINC=118;
    public static final int POS=119;
    public static final int PRIVATE=120;
    public static final int PROTECTED=121;
    public static final int PS=122;
    public static final int PUBLIC=123;
    public static final int QUE=124;
    public static final int RBRACE=125;
    public static final int RBRACK=126;
    public static final int RETURN=127;
    public static final int RPAREN=128;
    public static final int RegularExpressionChar=129;
    public static final int RegularExpressionFirstChar=130;
    public static final int RegularExpressionLiteral=131;
    public static final int SAME=132;
    public static final int SEMIC=133;
    public static final int SHL=134;
    public static final int SHLASS=135;
    public static final int SHORT=136;
    public static final int SHR=137;
    public static final int SHRASS=138;
    public static final int SHU=139;
    public static final int SHUASS=140;
    public static final int SP=141;
    public static final int SQUOTE=142;
    public static final int STATIC=143;
    public static final int SUB=144;
    public static final int SUBASS=145;
    public static final int SUPER=146;
    public static final int SWITCH=147;
    public static final int SYNCHRONIZED=148;
    public static final int SingleLineComment=149;
    public static final int StringLiteral=150;
    public static final int TAB=151;
    public static final int THIS=152;
    public static final int THROW=153;
    public static final int THROWS=154;
    public static final int TRANSIENT=155;
    public static final int TRUE=156;
    public static final int TRY=157;
    public static final int TYPEOF=158;
    public static final int USP=159;
    public static final int UnicodeEscapeSequence=160;
    public static final int VAR=161;
    public static final int VOID=162;
    public static final int VOLATILE=163;
    public static final int VT=164;
    public static final int WHILE=165;
    public static final int WITH=166;
    public static final int WhiteSpace=167;
    public static final int XOR=168;
    public static final int XORASS=169;
    public static final int ZeroToThree=170;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public ES3Walker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public ES3Walker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ES3Walker.tokenNames; }
    public String getGrammarFileName() { return "ES3Walker.g3"; }



    // $ANTLR start "program"
    // ES3Walker.g3:20:1: program : ( statement )* ;
    public final void program() throws RecognitionException {
        try {
            // ES3Walker.g3:21:2: ( ( statement )* )
            // ES3Walker.g3:21:4: ( statement )*
            {
            // ES3Walker.g3:21:4: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ADD && LA1_0 <= ANDASS)||(LA1_0 >= ARRAY && LA1_0 <= BLOCK)||LA1_0==BREAK||(LA1_0 >= BYFIELD && LA1_0 <= BYINDEX)||LA1_0==CALL||LA1_0==CEXPR||LA1_0==CONTINUE||LA1_0==DEC||(LA1_0 >= DELETE && LA1_0 <= DO)||LA1_0==DecimalLiteral||LA1_0==EQ||LA1_0==FALSE||LA1_0==FOR||LA1_0==FUNCTION||(LA1_0 >= GT && LA1_0 <= GTE)||(LA1_0 >= HexIntegerLiteral && LA1_0 <= IF)||(LA1_0 >= IN && LA1_0 <= INSTANCEOF)||LA1_0==INV||LA1_0==Identifier||(LA1_0 >= LABELLED && LA1_0 <= LAND)||LA1_0==LOR||(LA1_0 >= LT && LA1_0 <= LTE)||(LA1_0 >= MOD && LA1_0 <= MULASS)||(LA1_0 >= NEG && LA1_0 <= ORASS)||LA1_0==OctalIntegerLiteral||(LA1_0 >= PDEC && LA1_0 <= POS)||LA1_0==QUE||LA1_0==RETURN||(LA1_0 >= RegularExpressionLiteral && LA1_0 <= SAME)||(LA1_0 >= SHL && LA1_0 <= SHLASS)||(LA1_0 >= SHR && LA1_0 <= SHUASS)||(LA1_0 >= SUB && LA1_0 <= SUBASS)||LA1_0==SWITCH||LA1_0==StringLiteral||(LA1_0 >= THIS && LA1_0 <= THROW)||(LA1_0 >= TRUE && LA1_0 <= TYPEOF)||(LA1_0 >= VAR && LA1_0 <= VOID)||(LA1_0 >= WHILE && LA1_0 <= WITH)||(LA1_0 >= XOR && LA1_0 <= XORASS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ES3Walker.g3:21:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program43);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "statement"
    // ES3Walker.g3:24:1: statement : ( block | variableDeclaration | expression | ifStatement | doStatement | whileStatement | forStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );
    public final void statement() throws RecognitionException {
        try {
            // ES3Walker.g3:25:2: ( block | variableDeclaration | expression | ifStatement | doStatement | whileStatement | forStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement )
            int alt2=15;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt2=1;
                }
                break;
            case VAR:
                {
                alt2=2;
                }
                break;
            case ADD:
            case ADDASS:
            case AND:
            case ANDASS:
            case ARRAY:
            case ASSIGN:
            case BYFIELD:
            case BYINDEX:
            case CALL:
            case CEXPR:
            case DEC:
            case DELETE:
            case DIV:
            case DIVASS:
            case DecimalLiteral:
            case EQ:
            case FALSE:
            case FUNCTION:
            case GT:
            case GTE:
            case HexIntegerLiteral:
            case IN:
            case INC:
            case INSTANCEOF:
            case INV:
            case Identifier:
            case LAND:
            case LOR:
            case LT:
            case LTE:
            case MOD:
            case MODASS:
            case MUL:
            case MULASS:
            case NEG:
            case NEQ:
            case NEW:
            case NOT:
            case NSAME:
            case NULL:
            case OBJECT:
            case OR:
            case ORASS:
            case OctalIntegerLiteral:
            case PDEC:
            case PINC:
            case POS:
            case QUE:
            case RegularExpressionLiteral:
            case SAME:
            case SHL:
            case SHLASS:
            case SHR:
            case SHRASS:
            case SHU:
            case SHUASS:
            case SUB:
            case SUBASS:
            case StringLiteral:
            case THIS:
            case TRUE:
            case TYPEOF:
            case VOID:
            case XOR:
            case XORASS:
                {
                alt2=3;
                }
                break;
            case IF:
                {
                alt2=4;
                }
                break;
            case DO:
                {
                alt2=5;
                }
                break;
            case WHILE:
                {
                alt2=6;
                }
                break;
            case FOR:
                {
                alt2=7;
                }
                break;
            case CONTINUE:
                {
                alt2=8;
                }
                break;
            case BREAK:
                {
                alt2=9;
                }
                break;
            case RETURN:
                {
                alt2=10;
                }
                break;
            case WITH:
                {
                alt2=11;
                }
                break;
            case LABELLED:
                {
                alt2=12;
                }
                break;
            case SWITCH:
                {
                alt2=13;
                }
                break;
            case THROW:
                {
                alt2=14;
                }
                break;
            case TRY:
                {
                alt2=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // ES3Walker.g3:25:4: block
                    {
                    pushFollow(FOLLOW_block_in_statement55);
                    block();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ES3Walker.g3:26:4: variableDeclaration
                    {
                    pushFollow(FOLLOW_variableDeclaration_in_statement60);
                    variableDeclaration();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ES3Walker.g3:27:4: expression
                    {
                    pushFollow(FOLLOW_expression_in_statement65);
                    expression();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ES3Walker.g3:28:4: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement70);
                    ifStatement();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ES3Walker.g3:29:4: doStatement
                    {
                    pushFollow(FOLLOW_doStatement_in_statement75);
                    doStatement();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // ES3Walker.g3:30:4: whileStatement
                    {
                    pushFollow(FOLLOW_whileStatement_in_statement80);
                    whileStatement();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // ES3Walker.g3:31:4: forStatement
                    {
                    pushFollow(FOLLOW_forStatement_in_statement85);
                    forStatement();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // ES3Walker.g3:32:4: continueStatement
                    {
                    pushFollow(FOLLOW_continueStatement_in_statement90);
                    continueStatement();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // ES3Walker.g3:33:4: breakStatement
                    {
                    pushFollow(FOLLOW_breakStatement_in_statement95);
                    breakStatement();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // ES3Walker.g3:34:4: returnStatement
                    {
                    pushFollow(FOLLOW_returnStatement_in_statement100);
                    returnStatement();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // ES3Walker.g3:35:4: withStatement
                    {
                    pushFollow(FOLLOW_withStatement_in_statement105);
                    withStatement();

                    state._fsp--;


                    }
                    break;
                case 12 :
                    // ES3Walker.g3:36:4: labelledStatement
                    {
                    pushFollow(FOLLOW_labelledStatement_in_statement110);
                    labelledStatement();

                    state._fsp--;


                    }
                    break;
                case 13 :
                    // ES3Walker.g3:37:4: switchStatement
                    {
                    pushFollow(FOLLOW_switchStatement_in_statement115);
                    switchStatement();

                    state._fsp--;


                    }
                    break;
                case 14 :
                    // ES3Walker.g3:38:4: throwStatement
                    {
                    pushFollow(FOLLOW_throwStatement_in_statement120);
                    throwStatement();

                    state._fsp--;


                    }
                    break;
                case 15 :
                    // ES3Walker.g3:39:4: tryStatement
                    {
                    pushFollow(FOLLOW_tryStatement_in_statement125);
                    tryStatement();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "block"
    // ES3Walker.g3:42:1: block : ^( BLOCK ( statement )* ) ;
    public final void block() throws RecognitionException {
        try {
            // ES3Walker.g3:43:2: ( ^( BLOCK ( statement )* ) )
            // ES3Walker.g3:43:4: ^( BLOCK ( statement )* )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block138); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:43:13: ( statement )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0 >= ADD && LA3_0 <= ANDASS)||(LA3_0 >= ARRAY && LA3_0 <= BLOCK)||LA3_0==BREAK||(LA3_0 >= BYFIELD && LA3_0 <= BYINDEX)||LA3_0==CALL||LA3_0==CEXPR||LA3_0==CONTINUE||LA3_0==DEC||(LA3_0 >= DELETE && LA3_0 <= DO)||LA3_0==DecimalLiteral||LA3_0==EQ||LA3_0==FALSE||LA3_0==FOR||LA3_0==FUNCTION||(LA3_0 >= GT && LA3_0 <= GTE)||(LA3_0 >= HexIntegerLiteral && LA3_0 <= IF)||(LA3_0 >= IN && LA3_0 <= INSTANCEOF)||LA3_0==INV||LA3_0==Identifier||(LA3_0 >= LABELLED && LA3_0 <= LAND)||LA3_0==LOR||(LA3_0 >= LT && LA3_0 <= LTE)||(LA3_0 >= MOD && LA3_0 <= MULASS)||(LA3_0 >= NEG && LA3_0 <= ORASS)||LA3_0==OctalIntegerLiteral||(LA3_0 >= PDEC && LA3_0 <= POS)||LA3_0==QUE||LA3_0==RETURN||(LA3_0 >= RegularExpressionLiteral && LA3_0 <= SAME)||(LA3_0 >= SHL && LA3_0 <= SHLASS)||(LA3_0 >= SHR && LA3_0 <= SHUASS)||(LA3_0 >= SUB && LA3_0 <= SUBASS)||LA3_0==SWITCH||LA3_0==StringLiteral||(LA3_0 >= THIS && LA3_0 <= THROW)||(LA3_0 >= TRUE && LA3_0 <= TYPEOF)||(LA3_0 >= VAR && LA3_0 <= VOID)||(LA3_0 >= WHILE && LA3_0 <= WITH)||(LA3_0 >= XOR && LA3_0 <= XORASS)) ) {
                        alt3=1;
                    }


                    switch (alt3) {
                	case 1 :
                	    // ES3Walker.g3:43:13: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_block140);
                	    statement();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop3;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "block"



    // $ANTLR start "variableDeclaration"
    // ES3Walker.g3:46:1: variableDeclaration : ^( VAR ( Identifier | ^( ASSIGN Identifier expr ) )+ ) ;
    public final void variableDeclaration() throws RecognitionException {
        try {
            // ES3Walker.g3:47:2: ( ^( VAR ( Identifier | ^( ASSIGN Identifier expr ) )+ ) )
            // ES3Walker.g3:47:4: ^( VAR ( Identifier | ^( ASSIGN Identifier expr ) )+ )
            {
            match(input,VAR,FOLLOW_VAR_in_variableDeclaration156); 

            match(input, Token.DOWN, null); 
            // ES3Walker.g3:47:11: ( Identifier | ^( ASSIGN Identifier expr ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Identifier) ) {
                    alt4=1;
                }
                else if ( (LA4_0==ASSIGN) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ES3Walker.g3:47:13: Identifier
            	    {
            	    match(input,Identifier,FOLLOW_Identifier_in_variableDeclaration160); 

            	    }
            	    break;
            	case 2 :
            	    // ES3Walker.g3:47:26: ^( ASSIGN Identifier expr )
            	    {
            	    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration166); 

            	    match(input, Token.DOWN, null); 
            	    match(input,Identifier,FOLLOW_Identifier_in_variableDeclaration168); 

            	    pushFollow(FOLLOW_expr_in_variableDeclaration170);
            	    expr();

            	    state._fsp--;


            	    match(input, Token.UP, null); 


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "variableDeclaration"



    // $ANTLR start "ifStatement"
    // ES3Walker.g3:50:1: ifStatement : ^( IF expression ( statement )+ ) ;
    public final void ifStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:51:2: ( ^( IF expression ( statement )+ ) )
            // ES3Walker.g3:51:4: ^( IF expression ( statement )+ )
            {
            match(input,IF,FOLLOW_IF_in_ifStatement190); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_ifStatement192);
            expression();

            state._fsp--;


            // ES3Walker.g3:51:21: ( statement )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= ADD && LA5_0 <= ANDASS)||(LA5_0 >= ARRAY && LA5_0 <= BLOCK)||LA5_0==BREAK||(LA5_0 >= BYFIELD && LA5_0 <= BYINDEX)||LA5_0==CALL||LA5_0==CEXPR||LA5_0==CONTINUE||LA5_0==DEC||(LA5_0 >= DELETE && LA5_0 <= DO)||LA5_0==DecimalLiteral||LA5_0==EQ||LA5_0==FALSE||LA5_0==FOR||LA5_0==FUNCTION||(LA5_0 >= GT && LA5_0 <= GTE)||(LA5_0 >= HexIntegerLiteral && LA5_0 <= IF)||(LA5_0 >= IN && LA5_0 <= INSTANCEOF)||LA5_0==INV||LA5_0==Identifier||(LA5_0 >= LABELLED && LA5_0 <= LAND)||LA5_0==LOR||(LA5_0 >= LT && LA5_0 <= LTE)||(LA5_0 >= MOD && LA5_0 <= MULASS)||(LA5_0 >= NEG && LA5_0 <= ORASS)||LA5_0==OctalIntegerLiteral||(LA5_0 >= PDEC && LA5_0 <= POS)||LA5_0==QUE||LA5_0==RETURN||(LA5_0 >= RegularExpressionLiteral && LA5_0 <= SAME)||(LA5_0 >= SHL && LA5_0 <= SHLASS)||(LA5_0 >= SHR && LA5_0 <= SHUASS)||(LA5_0 >= SUB && LA5_0 <= SUBASS)||LA5_0==SWITCH||LA5_0==StringLiteral||(LA5_0 >= THIS && LA5_0 <= THROW)||(LA5_0 >= TRUE && LA5_0 <= TYPEOF)||(LA5_0 >= VAR && LA5_0 <= VOID)||(LA5_0 >= WHILE && LA5_0 <= WITH)||(LA5_0 >= XOR && LA5_0 <= XORASS)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ES3Walker.g3:51:21: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_ifStatement194);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "doStatement"
    // ES3Walker.g3:54:1: doStatement : ^( DO statement expression ) ;
    public final void doStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:55:2: ( ^( DO statement expression ) )
            // ES3Walker.g3:55:4: ^( DO statement expression )
            {
            match(input,DO,FOLLOW_DO_in_doStatement210); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_statement_in_doStatement212);
            statement();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_doStatement214);
            expression();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "doStatement"



    // $ANTLR start "whileStatement"
    // ES3Walker.g3:58:1: whileStatement : ^( WHILE expression statement ) ;
    public final void whileStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:59:2: ( ^( WHILE expression statement ) )
            // ES3Walker.g3:59:4: ^( WHILE expression statement )
            {
            match(input,WHILE,FOLLOW_WHILE_in_whileStatement229); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_whileStatement231);
            expression();

            state._fsp--;


            pushFollow(FOLLOW_statement_in_whileStatement233);
            statement();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "whileStatement"



    // $ANTLR start "forStatement"
    // ES3Walker.g3:62:1: forStatement : ^( FOR ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) ) statement ) ;
    public final void forStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:63:2: ( ^( FOR ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) ) statement ) )
            // ES3Walker.g3:63:4: ^( FOR ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) ) statement )
            {
            match(input,FOR,FOLLOW_FOR_in_forStatement249); 

            match(input, Token.DOWN, null); 
            // ES3Walker.g3:65:2: ( ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause ) | ^( FORITER ( exprClause | variableDeclaration ) exprClause ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FORSTEP) ) {
                alt8=1;
            }
            else if ( (LA8_0==FORITER) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // ES3Walker.g3:66:3: ^( FORSTEP ( exprOptClause | variableDeclaration ) exprOptClause exprOptClause )
                    {
                    match(input,FORSTEP,FOLLOW_FORSTEP_in_forStatement259); 

                    match(input, Token.DOWN, null); 
                    // ES3Walker.g3:66:14: ( exprOptClause | variableDeclaration )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==EXPR) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==VAR) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;

                    }
                    switch (alt6) {
                        case 1 :
                            // ES3Walker.g3:66:16: exprOptClause
                            {
                            pushFollow(FOLLOW_exprOptClause_in_forStatement263);
                            exprOptClause();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // ES3Walker.g3:66:32: variableDeclaration
                            {
                            pushFollow(FOLLOW_variableDeclaration_in_forStatement267);
                            variableDeclaration();

                            state._fsp--;


                            }
                            break;

                    }


                    pushFollow(FOLLOW_exprOptClause_in_forStatement271);
                    exprOptClause();

                    state._fsp--;


                    pushFollow(FOLLOW_exprOptClause_in_forStatement273);
                    exprOptClause();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // ES3Walker.g3:67:5: ^( FORITER ( exprClause | variableDeclaration ) exprClause )
                    {
                    match(input,FORITER,FOLLOW_FORITER_in_forStatement283); 

                    match(input, Token.DOWN, null); 
                    // ES3Walker.g3:67:16: ( exprClause | variableDeclaration )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==EXPR) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==VAR) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }
                    switch (alt7) {
                        case 1 :
                            // ES3Walker.g3:67:18: exprClause
                            {
                            pushFollow(FOLLOW_exprClause_in_forStatement287);
                            exprClause();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // ES3Walker.g3:67:31: variableDeclaration
                            {
                            pushFollow(FOLLOW_variableDeclaration_in_forStatement291);
                            variableDeclaration();

                            state._fsp--;


                            }
                            break;

                    }


                    pushFollow(FOLLOW_exprClause_in_forStatement295);
                    exprClause();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;

            }


            pushFollow(FOLLOW_statement_in_forStatement303);
            statement();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "forStatement"



    // $ANTLR start "exprOptClause"
    // ES3Walker.g3:72:1: exprOptClause : ^( EXPR ( expression )? ) ;
    public final void exprOptClause() throws RecognitionException {
        try {
            // ES3Walker.g3:73:2: ( ^( EXPR ( expression )? ) )
            // ES3Walker.g3:73:4: ^( EXPR ( expression )? )
            {
            match(input,EXPR,FOLLOW_EXPR_in_exprOptClause317); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:73:12: ( expression )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= ADD && LA9_0 <= ANDASS)||(LA9_0 >= ARRAY && LA9_0 <= ASSIGN)||(LA9_0 >= BYFIELD && LA9_0 <= BYINDEX)||LA9_0==CALL||LA9_0==CEXPR||LA9_0==DEC||(LA9_0 >= DELETE && LA9_0 <= DIVASS)||LA9_0==DecimalLiteral||LA9_0==EQ||LA9_0==FALSE||LA9_0==FUNCTION||(LA9_0 >= GT && LA9_0 <= GTE)||LA9_0==HexIntegerLiteral||(LA9_0 >= IN && LA9_0 <= INSTANCEOF)||LA9_0==INV||LA9_0==Identifier||LA9_0==LAND||LA9_0==LOR||(LA9_0 >= LT && LA9_0 <= LTE)||(LA9_0 >= MOD && LA9_0 <= MULASS)||(LA9_0 >= NEG && LA9_0 <= ORASS)||LA9_0==OctalIntegerLiteral||(LA9_0 >= PDEC && LA9_0 <= POS)||LA9_0==QUE||(LA9_0 >= RegularExpressionLiteral && LA9_0 <= SAME)||(LA9_0 >= SHL && LA9_0 <= SHLASS)||(LA9_0 >= SHR && LA9_0 <= SHUASS)||(LA9_0 >= SUB && LA9_0 <= SUBASS)||LA9_0==StringLiteral||LA9_0==THIS||LA9_0==TRUE||LA9_0==TYPEOF||LA9_0==VOID||(LA9_0 >= XOR && LA9_0 <= XORASS)) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // ES3Walker.g3:73:12: expression
                        {
                        pushFollow(FOLLOW_expression_in_exprOptClause319);
                        expression();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exprOptClause"



    // $ANTLR start "exprClause"
    // ES3Walker.g3:76:1: exprClause : ^( EXPR expression ) ;
    public final void exprClause() throws RecognitionException {
        try {
            // ES3Walker.g3:77:2: ( ^( EXPR expression ) )
            // ES3Walker.g3:77:4: ^( EXPR expression )
            {
            match(input,EXPR,FOLLOW_EXPR_in_exprClause335); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_exprClause337);
            expression();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exprClause"



    // $ANTLR start "continueStatement"
    // ES3Walker.g3:80:1: continueStatement : ^( CONTINUE ( Identifier )? ) ;
    public final void continueStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:81:2: ( ^( CONTINUE ( Identifier )? ) )
            // ES3Walker.g3:81:4: ^( CONTINUE ( Identifier )? )
            {
            match(input,CONTINUE,FOLLOW_CONTINUE_in_continueStatement352); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:81:16: ( Identifier )?
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Identifier) ) {
                    alt10=1;
                }
                switch (alt10) {
                    case 1 :
                        // ES3Walker.g3:81:16: Identifier
                        {
                        match(input,Identifier,FOLLOW_Identifier_in_continueStatement354); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "continueStatement"



    // $ANTLR start "breakStatement"
    // ES3Walker.g3:84:1: breakStatement : ^( BREAK ( Identifier )? ) ;
    public final void breakStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:85:2: ( ^( BREAK ( Identifier )? ) )
            // ES3Walker.g3:85:4: ^( BREAK ( Identifier )? )
            {
            match(input,BREAK,FOLLOW_BREAK_in_breakStatement370); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:85:13: ( Identifier )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Identifier) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // ES3Walker.g3:85:13: Identifier
                        {
                        match(input,Identifier,FOLLOW_Identifier_in_breakStatement372); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "breakStatement"



    // $ANTLR start "returnStatement"
    // ES3Walker.g3:88:1: returnStatement : ^( RETURN ( expression )? ) ;
    public final void returnStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:89:2: ( ^( RETURN ( expression )? ) )
            // ES3Walker.g3:89:4: ^( RETURN ( expression )? )
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement388); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:89:14: ( expression )?
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= ADD && LA12_0 <= ANDASS)||(LA12_0 >= ARRAY && LA12_0 <= ASSIGN)||(LA12_0 >= BYFIELD && LA12_0 <= BYINDEX)||LA12_0==CALL||LA12_0==CEXPR||LA12_0==DEC||(LA12_0 >= DELETE && LA12_0 <= DIVASS)||LA12_0==DecimalLiteral||LA12_0==EQ||LA12_0==FALSE||LA12_0==FUNCTION||(LA12_0 >= GT && LA12_0 <= GTE)||LA12_0==HexIntegerLiteral||(LA12_0 >= IN && LA12_0 <= INSTANCEOF)||LA12_0==INV||LA12_0==Identifier||LA12_0==LAND||LA12_0==LOR||(LA12_0 >= LT && LA12_0 <= LTE)||(LA12_0 >= MOD && LA12_0 <= MULASS)||(LA12_0 >= NEG && LA12_0 <= ORASS)||LA12_0==OctalIntegerLiteral||(LA12_0 >= PDEC && LA12_0 <= POS)||LA12_0==QUE||(LA12_0 >= RegularExpressionLiteral && LA12_0 <= SAME)||(LA12_0 >= SHL && LA12_0 <= SHLASS)||(LA12_0 >= SHR && LA12_0 <= SHUASS)||(LA12_0 >= SUB && LA12_0 <= SUBASS)||LA12_0==StringLiteral||LA12_0==THIS||LA12_0==TRUE||LA12_0==TYPEOF||LA12_0==VOID||(LA12_0 >= XOR && LA12_0 <= XORASS)) ) {
                    alt12=1;
                }
                switch (alt12) {
                    case 1 :
                        // ES3Walker.g3:89:14: expression
                        {
                        pushFollow(FOLLOW_expression_in_returnStatement390);
                        expression();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "returnStatement"



    // $ANTLR start "withStatement"
    // ES3Walker.g3:92:1: withStatement : ^( WITH expression statement ) ;
    public final void withStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:93:2: ( ^( WITH expression statement ) )
            // ES3Walker.g3:93:4: ^( WITH expression statement )
            {
            match(input,WITH,FOLLOW_WITH_in_withStatement406); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_withStatement408);
            expression();

            state._fsp--;


            pushFollow(FOLLOW_statement_in_withStatement410);
            statement();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "withStatement"



    // $ANTLR start "labelledStatement"
    // ES3Walker.g3:96:1: labelledStatement : ^( LABELLED Identifier statement ) ;
    public final void labelledStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:97:2: ( ^( LABELLED Identifier statement ) )
            // ES3Walker.g3:97:4: ^( LABELLED Identifier statement )
            {
            match(input,LABELLED,FOLLOW_LABELLED_in_labelledStatement425); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_labelledStatement427); 

            pushFollow(FOLLOW_statement_in_labelledStatement429);
            statement();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "labelledStatement"



    // $ANTLR start "switchStatement"
    // ES3Walker.g3:100:1: switchStatement : ^( SWITCH expression ( defaultClause )? ( caseClause )* ) ;
    public final void switchStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:101:2: ( ^( SWITCH expression ( defaultClause )? ( caseClause )* ) )
            // ES3Walker.g3:101:4: ^( SWITCH expression ( defaultClause )? ( caseClause )* )
            {
            match(input,SWITCH,FOLLOW_SWITCH_in_switchStatement444); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_switchStatement446);
            expression();

            state._fsp--;


            // ES3Walker.g3:101:25: ( defaultClause )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==DEFAULT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ES3Walker.g3:101:25: defaultClause
                    {
                    pushFollow(FOLLOW_defaultClause_in_switchStatement448);
                    defaultClause();

                    state._fsp--;


                    }
                    break;

            }


            // ES3Walker.g3:101:40: ( caseClause )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==CASE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ES3Walker.g3:101:40: caseClause
            	    {
            	    pushFollow(FOLLOW_caseClause_in_switchStatement451);
            	    caseClause();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "switchStatement"



    // $ANTLR start "defaultClause"
    // ES3Walker.g3:104:1: defaultClause : ^( DEFAULT ( statement )* ) ;
    public final void defaultClause() throws RecognitionException {
        try {
            // ES3Walker.g3:105:2: ( ^( DEFAULT ( statement )* ) )
            // ES3Walker.g3:105:4: ^( DEFAULT ( statement )* )
            {
            match(input,DEFAULT,FOLLOW_DEFAULT_in_defaultClause467); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:105:15: ( statement )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0 >= ADD && LA15_0 <= ANDASS)||(LA15_0 >= ARRAY && LA15_0 <= BLOCK)||LA15_0==BREAK||(LA15_0 >= BYFIELD && LA15_0 <= BYINDEX)||LA15_0==CALL||LA15_0==CEXPR||LA15_0==CONTINUE||LA15_0==DEC||(LA15_0 >= DELETE && LA15_0 <= DO)||LA15_0==DecimalLiteral||LA15_0==EQ||LA15_0==FALSE||LA15_0==FOR||LA15_0==FUNCTION||(LA15_0 >= GT && LA15_0 <= GTE)||(LA15_0 >= HexIntegerLiteral && LA15_0 <= IF)||(LA15_0 >= IN && LA15_0 <= INSTANCEOF)||LA15_0==INV||LA15_0==Identifier||(LA15_0 >= LABELLED && LA15_0 <= LAND)||LA15_0==LOR||(LA15_0 >= LT && LA15_0 <= LTE)||(LA15_0 >= MOD && LA15_0 <= MULASS)||(LA15_0 >= NEG && LA15_0 <= ORASS)||LA15_0==OctalIntegerLiteral||(LA15_0 >= PDEC && LA15_0 <= POS)||LA15_0==QUE||LA15_0==RETURN||(LA15_0 >= RegularExpressionLiteral && LA15_0 <= SAME)||(LA15_0 >= SHL && LA15_0 <= SHLASS)||(LA15_0 >= SHR && LA15_0 <= SHUASS)||(LA15_0 >= SUB && LA15_0 <= SUBASS)||LA15_0==SWITCH||LA15_0==StringLiteral||(LA15_0 >= THIS && LA15_0 <= THROW)||(LA15_0 >= TRUE && LA15_0 <= TYPEOF)||(LA15_0 >= VAR && LA15_0 <= VOID)||(LA15_0 >= WHILE && LA15_0 <= WITH)||(LA15_0 >= XOR && LA15_0 <= XORASS)) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // ES3Walker.g3:105:15: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_defaultClause469);
                	    statement();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defaultClause"



    // $ANTLR start "caseClause"
    // ES3Walker.g3:108:1: caseClause : ^( CASE expression ( statement )* ) ;
    public final void caseClause() throws RecognitionException {
        try {
            // ES3Walker.g3:109:2: ( ^( CASE expression ( statement )* ) )
            // ES3Walker.g3:109:4: ^( CASE expression ( statement )* )
            {
            match(input,CASE,FOLLOW_CASE_in_caseClause485); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_caseClause487);
            expression();

            state._fsp--;


            // ES3Walker.g3:109:23: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= ADD && LA16_0 <= ANDASS)||(LA16_0 >= ARRAY && LA16_0 <= BLOCK)||LA16_0==BREAK||(LA16_0 >= BYFIELD && LA16_0 <= BYINDEX)||LA16_0==CALL||LA16_0==CEXPR||LA16_0==CONTINUE||LA16_0==DEC||(LA16_0 >= DELETE && LA16_0 <= DO)||LA16_0==DecimalLiteral||LA16_0==EQ||LA16_0==FALSE||LA16_0==FOR||LA16_0==FUNCTION||(LA16_0 >= GT && LA16_0 <= GTE)||(LA16_0 >= HexIntegerLiteral && LA16_0 <= IF)||(LA16_0 >= IN && LA16_0 <= INSTANCEOF)||LA16_0==INV||LA16_0==Identifier||(LA16_0 >= LABELLED && LA16_0 <= LAND)||LA16_0==LOR||(LA16_0 >= LT && LA16_0 <= LTE)||(LA16_0 >= MOD && LA16_0 <= MULASS)||(LA16_0 >= NEG && LA16_0 <= ORASS)||LA16_0==OctalIntegerLiteral||(LA16_0 >= PDEC && LA16_0 <= POS)||LA16_0==QUE||LA16_0==RETURN||(LA16_0 >= RegularExpressionLiteral && LA16_0 <= SAME)||(LA16_0 >= SHL && LA16_0 <= SHLASS)||(LA16_0 >= SHR && LA16_0 <= SHUASS)||(LA16_0 >= SUB && LA16_0 <= SUBASS)||LA16_0==SWITCH||LA16_0==StringLiteral||(LA16_0 >= THIS && LA16_0 <= THROW)||(LA16_0 >= TRUE && LA16_0 <= TYPEOF)||(LA16_0 >= VAR && LA16_0 <= VOID)||(LA16_0 >= WHILE && LA16_0 <= WITH)||(LA16_0 >= XOR && LA16_0 <= XORASS)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ES3Walker.g3:109:23: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_caseClause489);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "caseClause"



    // $ANTLR start "throwStatement"
    // ES3Walker.g3:112:1: throwStatement : ^( THROW expression ) ;
    public final void throwStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:113:2: ( ^( THROW expression ) )
            // ES3Walker.g3:113:4: ^( THROW expression )
            {
            match(input,THROW,FOLLOW_THROW_in_throwStatement505); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_throwStatement507);
            expression();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "throwStatement"



    // $ANTLR start "tryStatement"
    // ES3Walker.g3:116:1: tryStatement : ^( TRY block ( catchClause )? ( finallyClause )? ) ;
    public final void tryStatement() throws RecognitionException {
        try {
            // ES3Walker.g3:117:2: ( ^( TRY block ( catchClause )? ( finallyClause )? ) )
            // ES3Walker.g3:117:4: ^( TRY block ( catchClause )? ( finallyClause )? )
            {
            match(input,TRY,FOLLOW_TRY_in_tryStatement522); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_tryStatement524);
            block();

            state._fsp--;


            // ES3Walker.g3:117:17: ( catchClause )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==CATCH) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ES3Walker.g3:117:17: catchClause
                    {
                    pushFollow(FOLLOW_catchClause_in_tryStatement526);
                    catchClause();

                    state._fsp--;


                    }
                    break;

            }


            // ES3Walker.g3:117:30: ( finallyClause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FINALLY) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ES3Walker.g3:117:30: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_tryStatement529);
                    finallyClause();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tryStatement"



    // $ANTLR start "catchClause"
    // ES3Walker.g3:120:1: catchClause : ^( CATCH Identifier block ) ;
    public final void catchClause() throws RecognitionException {
        try {
            // ES3Walker.g3:121:2: ( ^( CATCH Identifier block ) )
            // ES3Walker.g3:121:4: ^( CATCH Identifier block )
            {
            match(input,CATCH,FOLLOW_CATCH_in_catchClause546); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_catchClause548); 

            pushFollow(FOLLOW_block_in_catchClause550);
            block();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "catchClause"



    // $ANTLR start "finallyClause"
    // ES3Walker.g3:124:1: finallyClause : ^( FINALLY block ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // ES3Walker.g3:125:2: ( ^( FINALLY block ) )
            // ES3Walker.g3:125:4: ^( FINALLY block )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause566); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_block_in_finallyClause568);
            block();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "finallyClause"



    // $ANTLR start "expression"
    // ES3Walker.g3:128:1: expression : ( expr | ^( CEXPR ( expr )+ ) );
    public final void expression() throws RecognitionException {
        try {
            // ES3Walker.g3:129:2: ( expr | ^( CEXPR ( expr )+ ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0 >= ADD && LA20_0 <= ANDASS)||(LA20_0 >= ARRAY && LA20_0 <= ASSIGN)||(LA20_0 >= BYFIELD && LA20_0 <= BYINDEX)||LA20_0==CALL||LA20_0==DEC||(LA20_0 >= DELETE && LA20_0 <= DIVASS)||LA20_0==DecimalLiteral||LA20_0==EQ||LA20_0==FALSE||LA20_0==FUNCTION||(LA20_0 >= GT && LA20_0 <= GTE)||LA20_0==HexIntegerLiteral||(LA20_0 >= IN && LA20_0 <= INSTANCEOF)||LA20_0==INV||LA20_0==Identifier||LA20_0==LAND||LA20_0==LOR||(LA20_0 >= LT && LA20_0 <= LTE)||(LA20_0 >= MOD && LA20_0 <= MULASS)||(LA20_0 >= NEG && LA20_0 <= ORASS)||LA20_0==OctalIntegerLiteral||(LA20_0 >= PDEC && LA20_0 <= POS)||LA20_0==QUE||(LA20_0 >= RegularExpressionLiteral && LA20_0 <= SAME)||(LA20_0 >= SHL && LA20_0 <= SHLASS)||(LA20_0 >= SHR && LA20_0 <= SHUASS)||(LA20_0 >= SUB && LA20_0 <= SUBASS)||LA20_0==StringLiteral||LA20_0==THIS||LA20_0==TRUE||LA20_0==TYPEOF||LA20_0==VOID||(LA20_0 >= XOR && LA20_0 <= XORASS)) ) {
                alt20=1;
            }
            else if ( (LA20_0==CEXPR) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // ES3Walker.g3:129:4: expr
                    {
                    pushFollow(FOLLOW_expr_in_expression581);
                    expr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ES3Walker.g3:130:4: ^( CEXPR ( expr )+ )
                    {
                    match(input,CEXPR,FOLLOW_CEXPR_in_expression589); 

                    match(input, Token.DOWN, null); 
                    // ES3Walker.g3:130:13: ( expr )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0 >= ADD && LA19_0 <= ANDASS)||(LA19_0 >= ARRAY && LA19_0 <= ASSIGN)||(LA19_0 >= BYFIELD && LA19_0 <= BYINDEX)||LA19_0==CALL||LA19_0==DEC||(LA19_0 >= DELETE && LA19_0 <= DIVASS)||LA19_0==DecimalLiteral||LA19_0==EQ||LA19_0==FALSE||LA19_0==FUNCTION||(LA19_0 >= GT && LA19_0 <= GTE)||LA19_0==HexIntegerLiteral||(LA19_0 >= IN && LA19_0 <= INSTANCEOF)||LA19_0==INV||LA19_0==Identifier||LA19_0==LAND||LA19_0==LOR||(LA19_0 >= LT && LA19_0 <= LTE)||(LA19_0 >= MOD && LA19_0 <= MULASS)||(LA19_0 >= NEG && LA19_0 <= ORASS)||LA19_0==OctalIntegerLiteral||(LA19_0 >= PDEC && LA19_0 <= POS)||LA19_0==QUE||(LA19_0 >= RegularExpressionLiteral && LA19_0 <= SAME)||(LA19_0 >= SHL && LA19_0 <= SHLASS)||(LA19_0 >= SHR && LA19_0 <= SHUASS)||(LA19_0 >= SUB && LA19_0 <= SUBASS)||LA19_0==StringLiteral||LA19_0==THIS||LA19_0==TRUE||LA19_0==TYPEOF||LA19_0==VOID||(LA19_0 >= XOR && LA19_0 <= XORASS)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ES3Walker.g3:130:13: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_expression591);
                    	    expr();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    match(input, Token.UP, null); 


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "expr"
    // ES3Walker.g3:133:1: expr : ( leftHandSideExpression | ^( ASSIGN expr expr ) | ^( MULASS expr expr ) | ^( DIVASS expr expr ) | ^( MODASS expr expr ) | ^( ADDASS expr expr ) | ^( SUBASS expr expr ) | ^( SHLASS expr expr ) | ^( SHRASS expr expr ) | ^( SHUASS expr expr ) | ^( ANDASS expr expr ) | ^( XORASS expr expr ) | ^( ORASS expr expr ) | ^( QUE expr expr expr ) | ^( LOR expr expr ) | ^( LAND expr expr ) | ^( AND expr expr ) | ^( OR expr expr ) | ^( XOR expr expr ) | ^( EQ expr expr ) | ^( NEQ expr expr ) | ^( SAME expr expr ) | ^( NSAME expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( LTE expr expr ) | ^( GTE expr expr ) | ^( INSTANCEOF expr expr ) | ^( IN expr expr ) | ^( SHL expr expr ) | ^( SHR expr expr ) | ^( SHU expr expr ) | ^( ADD expr expr ) | ^( SUB expr expr ) | ^( MUL expr expr ) | ^( DIV expr expr ) | ^( MOD expr expr ) | ^( DELETE expr ) | ^( VOID expr ) | ^( TYPEOF expr ) | ^( INC expr ) | ^( DEC expr ) | ^( POS expr ) | ^( NEG expr ) | ^( INV expr ) | ^( NOT expr ) | ^( PINC expr ) | ^( PDEC expr ) );
    public final void expr() throws RecognitionException {
        try {
            // ES3Walker.g3:134:2: ( leftHandSideExpression | ^( ASSIGN expr expr ) | ^( MULASS expr expr ) | ^( DIVASS expr expr ) | ^( MODASS expr expr ) | ^( ADDASS expr expr ) | ^( SUBASS expr expr ) | ^( SHLASS expr expr ) | ^( SHRASS expr expr ) | ^( SHUASS expr expr ) | ^( ANDASS expr expr ) | ^( XORASS expr expr ) | ^( ORASS expr expr ) | ^( QUE expr expr expr ) | ^( LOR expr expr ) | ^( LAND expr expr ) | ^( AND expr expr ) | ^( OR expr expr ) | ^( XOR expr expr ) | ^( EQ expr expr ) | ^( NEQ expr expr ) | ^( SAME expr expr ) | ^( NSAME expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( LTE expr expr ) | ^( GTE expr expr ) | ^( INSTANCEOF expr expr ) | ^( IN expr expr ) | ^( SHL expr expr ) | ^( SHR expr expr ) | ^( SHU expr expr ) | ^( ADD expr expr ) | ^( SUB expr expr ) | ^( MUL expr expr ) | ^( DIV expr expr ) | ^( MOD expr expr ) | ^( DELETE expr ) | ^( VOID expr ) | ^( TYPEOF expr ) | ^( INC expr ) | ^( DEC expr ) | ^( POS expr ) | ^( NEG expr ) | ^( INV expr ) | ^( NOT expr ) | ^( PINC expr ) | ^( PDEC expr ) )
            int alt21=48;
            switch ( input.LA(1) ) {
            case ARRAY:
            case BYFIELD:
            case BYINDEX:
            case CALL:
            case DecimalLiteral:
            case FALSE:
            case FUNCTION:
            case HexIntegerLiteral:
            case Identifier:
            case NEW:
            case NULL:
            case OBJECT:
            case OctalIntegerLiteral:
            case RegularExpressionLiteral:
            case StringLiteral:
            case THIS:
            case TRUE:
                {
                alt21=1;
                }
                break;
            case ASSIGN:
                {
                alt21=2;
                }
                break;
            case MULASS:
                {
                alt21=3;
                }
                break;
            case DIVASS:
                {
                alt21=4;
                }
                break;
            case MODASS:
                {
                alt21=5;
                }
                break;
            case ADDASS:
                {
                alt21=6;
                }
                break;
            case SUBASS:
                {
                alt21=7;
                }
                break;
            case SHLASS:
                {
                alt21=8;
                }
                break;
            case SHRASS:
                {
                alt21=9;
                }
                break;
            case SHUASS:
                {
                alt21=10;
                }
                break;
            case ANDASS:
                {
                alt21=11;
                }
                break;
            case XORASS:
                {
                alt21=12;
                }
                break;
            case ORASS:
                {
                alt21=13;
                }
                break;
            case QUE:
                {
                alt21=14;
                }
                break;
            case LOR:
                {
                alt21=15;
                }
                break;
            case LAND:
                {
                alt21=16;
                }
                break;
            case AND:
                {
                alt21=17;
                }
                break;
            case OR:
                {
                alt21=18;
                }
                break;
            case XOR:
                {
                alt21=19;
                }
                break;
            case EQ:
                {
                alt21=20;
                }
                break;
            case NEQ:
                {
                alt21=21;
                }
                break;
            case SAME:
                {
                alt21=22;
                }
                break;
            case NSAME:
                {
                alt21=23;
                }
                break;
            case LT:
                {
                alt21=24;
                }
                break;
            case GT:
                {
                alt21=25;
                }
                break;
            case LTE:
                {
                alt21=26;
                }
                break;
            case GTE:
                {
                alt21=27;
                }
                break;
            case INSTANCEOF:
                {
                alt21=28;
                }
                break;
            case IN:
                {
                alt21=29;
                }
                break;
            case SHL:
                {
                alt21=30;
                }
                break;
            case SHR:
                {
                alt21=31;
                }
                break;
            case SHU:
                {
                alt21=32;
                }
                break;
            case ADD:
                {
                alt21=33;
                }
                break;
            case SUB:
                {
                alt21=34;
                }
                break;
            case MUL:
                {
                alt21=35;
                }
                break;
            case DIV:
                {
                alt21=36;
                }
                break;
            case MOD:
                {
                alt21=37;
                }
                break;
            case DELETE:
                {
                alt21=38;
                }
                break;
            case VOID:
                {
                alt21=39;
                }
                break;
            case TYPEOF:
                {
                alt21=40;
                }
                break;
            case INC:
                {
                alt21=41;
                }
                break;
            case DEC:
                {
                alt21=42;
                }
                break;
            case POS:
                {
                alt21=43;
                }
                break;
            case NEG:
                {
                alt21=44;
                }
                break;
            case INV:
                {
                alt21=45;
                }
                break;
            case NOT:
                {
                alt21=46;
                }
                break;
            case PINC:
                {
                alt21=47;
                }
                break;
            case PDEC:
                {
                alt21=48;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // ES3Walker.g3:134:4: leftHandSideExpression
                    {
                    pushFollow(FOLLOW_leftHandSideExpression_in_expr605);
                    leftHandSideExpression();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ES3Walker.g3:137:4: ^( ASSIGN expr expr )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_expr616); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr618);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr620);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // ES3Walker.g3:138:4: ^( MULASS expr expr )
                    {
                    match(input,MULASS,FOLLOW_MULASS_in_expr629); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr631);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr633);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // ES3Walker.g3:139:4: ^( DIVASS expr expr )
                    {
                    match(input,DIVASS,FOLLOW_DIVASS_in_expr642); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr644);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr646);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 5 :
                    // ES3Walker.g3:140:4: ^( MODASS expr expr )
                    {
                    match(input,MODASS,FOLLOW_MODASS_in_expr655); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr657);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr659);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 6 :
                    // ES3Walker.g3:141:4: ^( ADDASS expr expr )
                    {
                    match(input,ADDASS,FOLLOW_ADDASS_in_expr668); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr670);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr672);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 7 :
                    // ES3Walker.g3:142:4: ^( SUBASS expr expr )
                    {
                    match(input,SUBASS,FOLLOW_SUBASS_in_expr681); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr683);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr685);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 8 :
                    // ES3Walker.g3:143:4: ^( SHLASS expr expr )
                    {
                    match(input,SHLASS,FOLLOW_SHLASS_in_expr694); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr696);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr698);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 9 :
                    // ES3Walker.g3:144:4: ^( SHRASS expr expr )
                    {
                    match(input,SHRASS,FOLLOW_SHRASS_in_expr707); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr709);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr711);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 10 :
                    // ES3Walker.g3:145:4: ^( SHUASS expr expr )
                    {
                    match(input,SHUASS,FOLLOW_SHUASS_in_expr720); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr722);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr724);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 11 :
                    // ES3Walker.g3:146:4: ^( ANDASS expr expr )
                    {
                    match(input,ANDASS,FOLLOW_ANDASS_in_expr733); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr735);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr737);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 12 :
                    // ES3Walker.g3:147:4: ^( XORASS expr expr )
                    {
                    match(input,XORASS,FOLLOW_XORASS_in_expr746); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr748);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr750);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 13 :
                    // ES3Walker.g3:148:4: ^( ORASS expr expr )
                    {
                    match(input,ORASS,FOLLOW_ORASS_in_expr759); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr761);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr763);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 14 :
                    // ES3Walker.g3:151:4: ^( QUE expr expr expr )
                    {
                    match(input,QUE,FOLLOW_QUE_in_expr776); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr778);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr780);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr782);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 15 :
                    // ES3Walker.g3:154:4: ^( LOR expr expr )
                    {
                    match(input,LOR,FOLLOW_LOR_in_expr795); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr797);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr799);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 16 :
                    // ES3Walker.g3:155:4: ^( LAND expr expr )
                    {
                    match(input,LAND,FOLLOW_LAND_in_expr808); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr810);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr812);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 17 :
                    // ES3Walker.g3:158:4: ^( AND expr expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr825); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr827);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr829);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 18 :
                    // ES3Walker.g3:159:4: ^( OR expr expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr838); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr840);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr842);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 19 :
                    // ES3Walker.g3:160:4: ^( XOR expr expr )
                    {
                    match(input,XOR,FOLLOW_XOR_in_expr851); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr853);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr855);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 20 :
                    // ES3Walker.g3:163:4: ^( EQ expr expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_expr868); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr870);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr872);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 21 :
                    // ES3Walker.g3:164:4: ^( NEQ expr expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_expr881); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr883);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr885);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 22 :
                    // ES3Walker.g3:165:4: ^( SAME expr expr )
                    {
                    match(input,SAME,FOLLOW_SAME_in_expr894); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr896);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr898);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 23 :
                    // ES3Walker.g3:166:4: ^( NSAME expr expr )
                    {
                    match(input,NSAME,FOLLOW_NSAME_in_expr907); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr909);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr911);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 24 :
                    // ES3Walker.g3:169:4: ^( LT expr expr )
                    {
                    match(input,LT,FOLLOW_LT_in_expr924); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr926);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr928);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 25 :
                    // ES3Walker.g3:170:4: ^( GT expr expr )
                    {
                    match(input,GT,FOLLOW_GT_in_expr937); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr939);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr941);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 26 :
                    // ES3Walker.g3:171:4: ^( LTE expr expr )
                    {
                    match(input,LTE,FOLLOW_LTE_in_expr950); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr952);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr954);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 27 :
                    // ES3Walker.g3:172:4: ^( GTE expr expr )
                    {
                    match(input,GTE,FOLLOW_GTE_in_expr963); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr965);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr967);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 28 :
                    // ES3Walker.g3:173:4: ^( INSTANCEOF expr expr )
                    {
                    match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_expr976); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr978);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr980);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 29 :
                    // ES3Walker.g3:174:4: ^( IN expr expr )
                    {
                    match(input,IN,FOLLOW_IN_in_expr989); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr991);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr993);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 30 :
                    // ES3Walker.g3:177:4: ^( SHL expr expr )
                    {
                    match(input,SHL,FOLLOW_SHL_in_expr1006); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1008);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1010);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 31 :
                    // ES3Walker.g3:178:4: ^( SHR expr expr )
                    {
                    match(input,SHR,FOLLOW_SHR_in_expr1019); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1021);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1023);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 32 :
                    // ES3Walker.g3:179:4: ^( SHU expr expr )
                    {
                    match(input,SHU,FOLLOW_SHU_in_expr1032); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1034);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1036);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 33 :
                    // ES3Walker.g3:182:4: ^( ADD expr expr )
                    {
                    match(input,ADD,FOLLOW_ADD_in_expr1049); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1051);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1053);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 34 :
                    // ES3Walker.g3:183:4: ^( SUB expr expr )
                    {
                    match(input,SUB,FOLLOW_SUB_in_expr1062); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1064);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1066);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 35 :
                    // ES3Walker.g3:186:4: ^( MUL expr expr )
                    {
                    match(input,MUL,FOLLOW_MUL_in_expr1079); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1081);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1083);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 36 :
                    // ES3Walker.g3:187:4: ^( DIV expr expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr1092); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1094);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1096);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 37 :
                    // ES3Walker.g3:188:4: ^( MOD expr expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr1105); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1107);
                    expr();

                    state._fsp--;


                    pushFollow(FOLLOW_expr_in_expr1109);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 38 :
                    // ES3Walker.g3:191:4: ^( DELETE expr )
                    {
                    match(input,DELETE,FOLLOW_DELETE_in_expr1122); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1124);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 39 :
                    // ES3Walker.g3:192:4: ^( VOID expr )
                    {
                    match(input,VOID,FOLLOW_VOID_in_expr1133); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1135);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 40 :
                    // ES3Walker.g3:193:4: ^( TYPEOF expr )
                    {
                    match(input,TYPEOF,FOLLOW_TYPEOF_in_expr1144); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1146);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 41 :
                    // ES3Walker.g3:194:4: ^( INC expr )
                    {
                    match(input,INC,FOLLOW_INC_in_expr1155); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1157);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 42 :
                    // ES3Walker.g3:195:4: ^( DEC expr )
                    {
                    match(input,DEC,FOLLOW_DEC_in_expr1166); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1168);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 43 :
                    // ES3Walker.g3:196:4: ^( POS expr )
                    {
                    match(input,POS,FOLLOW_POS_in_expr1177); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1179);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 44 :
                    // ES3Walker.g3:197:4: ^( NEG expr )
                    {
                    match(input,NEG,FOLLOW_NEG_in_expr1188); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1190);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 45 :
                    // ES3Walker.g3:198:4: ^( INV expr )
                    {
                    match(input,INV,FOLLOW_INV_in_expr1199); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1201);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 46 :
                    // ES3Walker.g3:199:4: ^( NOT expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1210); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1212);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 47 :
                    // ES3Walker.g3:202:4: ^( PINC expr )
                    {
                    match(input,PINC,FOLLOW_PINC_in_expr1225); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1227);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 48 :
                    // ES3Walker.g3:203:4: ^( PDEC expr )
                    {
                    match(input,PDEC,FOLLOW_PDEC_in_expr1236); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expr_in_expr1238);
                    expr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expr"



    // $ANTLR start "leftHandSideExpression"
    // ES3Walker.g3:206:1: leftHandSideExpression : ( primaryExpression | newExpression | functionDeclaration | callExpression | memberExpression );
    public final void leftHandSideExpression() throws RecognitionException {
        try {
            // ES3Walker.g3:207:2: ( primaryExpression | newExpression | functionDeclaration | callExpression | memberExpression )
            int alt22=5;
            switch ( input.LA(1) ) {
            case ARRAY:
            case DecimalLiteral:
            case FALSE:
            case HexIntegerLiteral:
            case Identifier:
            case NULL:
            case OBJECT:
            case OctalIntegerLiteral:
            case RegularExpressionLiteral:
            case StringLiteral:
            case THIS:
            case TRUE:
                {
                alt22=1;
                }
                break;
            case NEW:
                {
                alt22=2;
                }
                break;
            case FUNCTION:
                {
                alt22=3;
                }
                break;
            case CALL:
                {
                alt22=4;
                }
                break;
            case BYFIELD:
            case BYINDEX:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // ES3Walker.g3:207:4: primaryExpression
                    {
                    pushFollow(FOLLOW_primaryExpression_in_leftHandSideExpression1251);
                    primaryExpression();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ES3Walker.g3:208:4: newExpression
                    {
                    pushFollow(FOLLOW_newExpression_in_leftHandSideExpression1256);
                    newExpression();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ES3Walker.g3:209:4: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_leftHandSideExpression1261);
                    functionDeclaration();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ES3Walker.g3:210:4: callExpression
                    {
                    pushFollow(FOLLOW_callExpression_in_leftHandSideExpression1266);
                    callExpression();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ES3Walker.g3:211:4: memberExpression
                    {
                    pushFollow(FOLLOW_memberExpression_in_leftHandSideExpression1271);
                    memberExpression();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "leftHandSideExpression"



    // $ANTLR start "newExpression"
    // ES3Walker.g3:214:1: newExpression : ^( NEW leftHandSideExpression ) ;
    public final void newExpression() throws RecognitionException {
        try {
            // ES3Walker.g3:215:2: ( ^( NEW leftHandSideExpression ) )
            // ES3Walker.g3:215:4: ^( NEW leftHandSideExpression )
            {
            match(input,NEW,FOLLOW_NEW_in_newExpression1284); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_leftHandSideExpression_in_newExpression1286);
            leftHandSideExpression();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "newExpression"



    // $ANTLR start "functionDeclaration"
    // ES3Walker.g3:218:1: functionDeclaration : ^( FUNCTION ( Identifier )? ^( ARGS ( Identifier )* ) block ) ;
    public final void functionDeclaration() throws RecognitionException {
        try {
            // ES3Walker.g3:219:2: ( ^( FUNCTION ( Identifier )? ^( ARGS ( Identifier )* ) block ) )
            // ES3Walker.g3:219:4: ^( FUNCTION ( Identifier )? ^( ARGS ( Identifier )* ) block )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_functionDeclaration1301); 

            match(input, Token.DOWN, null); 
            // ES3Walker.g3:219:16: ( Identifier )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Identifier) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ES3Walker.g3:219:16: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_functionDeclaration1303); 

                    }
                    break;

            }


            match(input,ARGS,FOLLOW_ARGS_in_functionDeclaration1308); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:219:36: ( Identifier )*
                loop24:
                do {
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==Identifier) ) {
                        alt24=1;
                    }


                    switch (alt24) {
                	case 1 :
                	    // ES3Walker.g3:219:36: Identifier
                	    {
                	    match(input,Identifier,FOLLOW_Identifier_in_functionDeclaration1310); 

                	    }
                	    break;

                	default :
                	    break loop24;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            pushFollow(FOLLOW_block_in_functionDeclaration1315);
            block();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "functionDeclaration"



    // $ANTLR start "callExpression"
    // ES3Walker.g3:222:1: callExpression : ^( CALL leftHandSideExpression ^( ARGS ( expr )* ) ) ;
    public final void callExpression() throws RecognitionException {
        try {
            // ES3Walker.g3:223:2: ( ^( CALL leftHandSideExpression ^( ARGS ( expr )* ) ) )
            // ES3Walker.g3:223:4: ^( CALL leftHandSideExpression ^( ARGS ( expr )* ) )
            {
            match(input,CALL,FOLLOW_CALL_in_callExpression1330); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_leftHandSideExpression_in_callExpression1332);
            leftHandSideExpression();

            state._fsp--;


            match(input,ARGS,FOLLOW_ARGS_in_callExpression1336); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:223:43: ( expr )*
                loop25:
                do {
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0 >= ADD && LA25_0 <= ANDASS)||(LA25_0 >= ARRAY && LA25_0 <= ASSIGN)||(LA25_0 >= BYFIELD && LA25_0 <= BYINDEX)||LA25_0==CALL||LA25_0==DEC||(LA25_0 >= DELETE && LA25_0 <= DIVASS)||LA25_0==DecimalLiteral||LA25_0==EQ||LA25_0==FALSE||LA25_0==FUNCTION||(LA25_0 >= GT && LA25_0 <= GTE)||LA25_0==HexIntegerLiteral||(LA25_0 >= IN && LA25_0 <= INSTANCEOF)||LA25_0==INV||LA25_0==Identifier||LA25_0==LAND||LA25_0==LOR||(LA25_0 >= LT && LA25_0 <= LTE)||(LA25_0 >= MOD && LA25_0 <= MULASS)||(LA25_0 >= NEG && LA25_0 <= ORASS)||LA25_0==OctalIntegerLiteral||(LA25_0 >= PDEC && LA25_0 <= POS)||LA25_0==QUE||(LA25_0 >= RegularExpressionLiteral && LA25_0 <= SAME)||(LA25_0 >= SHL && LA25_0 <= SHLASS)||(LA25_0 >= SHR && LA25_0 <= SHUASS)||(LA25_0 >= SUB && LA25_0 <= SUBASS)||LA25_0==StringLiteral||LA25_0==THIS||LA25_0==TRUE||LA25_0==TYPEOF||LA25_0==VOID||(LA25_0 >= XOR && LA25_0 <= XORASS)) ) {
                        alt25=1;
                    }


                    switch (alt25) {
                	case 1 :
                	    // ES3Walker.g3:223:43: expr
                	    {
                	    pushFollow(FOLLOW_expr_in_callExpression1338);
                	    expr();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop25;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "callExpression"



    // $ANTLR start "memberExpression"
    // ES3Walker.g3:226:1: memberExpression : ( ^( BYINDEX leftHandSideExpression expression ) | ^( BYFIELD leftHandSideExpression Identifier ) );
    public final void memberExpression() throws RecognitionException {
        try {
            // ES3Walker.g3:227:2: ( ^( BYINDEX leftHandSideExpression expression ) | ^( BYFIELD leftHandSideExpression Identifier ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==BYINDEX) ) {
                alt26=1;
            }
            else if ( (LA26_0==BYFIELD) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // ES3Walker.g3:227:4: ^( BYINDEX leftHandSideExpression expression )
                    {
                    match(input,BYINDEX,FOLLOW_BYINDEX_in_memberExpression1357); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_leftHandSideExpression_in_memberExpression1359);
                    leftHandSideExpression();

                    state._fsp--;


                    pushFollow(FOLLOW_expression_in_memberExpression1361);
                    expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // ES3Walker.g3:228:4: ^( BYFIELD leftHandSideExpression Identifier )
                    {
                    match(input,BYFIELD,FOLLOW_BYFIELD_in_memberExpression1370); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_leftHandSideExpression_in_memberExpression1372);
                    leftHandSideExpression();

                    state._fsp--;


                    match(input,Identifier,FOLLOW_Identifier_in_memberExpression1374); 

                    match(input, Token.UP, null); 


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "memberExpression"



    // $ANTLR start "primaryExpression"
    // ES3Walker.g3:231:1: primaryExpression : ( Identifier | literal );
    public final void primaryExpression() throws RecognitionException {
        try {
            // ES3Walker.g3:232:2: ( Identifier | literal )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Identifier) ) {
                alt27=1;
            }
            else if ( (LA27_0==ARRAY||LA27_0==DecimalLiteral||LA27_0==FALSE||LA27_0==HexIntegerLiteral||(LA27_0 >= NULL && LA27_0 <= OBJECT)||LA27_0==OctalIntegerLiteral||LA27_0==RegularExpressionLiteral||LA27_0==StringLiteral||LA27_0==THIS||LA27_0==TRUE) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // ES3Walker.g3:232:4: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_primaryExpression1387); 

                    }
                    break;
                case 2 :
                    // ES3Walker.g3:233:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_primaryExpression1392);
                    literal();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "primaryExpression"



    // $ANTLR start "literal"
    // ES3Walker.g3:236:1: literal : ( THIS | NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | arrayLiteral | objectLiteral );
    public final void literal() throws RecognitionException {
        try {
            // ES3Walker.g3:237:2: ( THIS | NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral | arrayLiteral | objectLiteral )
            int alt28=8;
            switch ( input.LA(1) ) {
            case THIS:
                {
                alt28=1;
                }
                break;
            case NULL:
                {
                alt28=2;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt28=3;
                }
                break;
            case DecimalLiteral:
            case HexIntegerLiteral:
            case OctalIntegerLiteral:
                {
                alt28=4;
                }
                break;
            case StringLiteral:
                {
                alt28=5;
                }
                break;
            case RegularExpressionLiteral:
                {
                alt28=6;
                }
                break;
            case ARRAY:
                {
                alt28=7;
                }
                break;
            case OBJECT:
                {
                alt28=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // ES3Walker.g3:237:4: THIS
                    {
                    match(input,THIS,FOLLOW_THIS_in_literal1403); 

                    }
                    break;
                case 2 :
                    // ES3Walker.g3:238:4: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal1408); 

                    }
                    break;
                case 3 :
                    // ES3Walker.g3:239:4: booleanLiteral
                    {
                    pushFollow(FOLLOW_booleanLiteral_in_literal1413);
                    booleanLiteral();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // ES3Walker.g3:240:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_literal1418);
                    numericLiteral();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // ES3Walker.g3:241:4: StringLiteral
                    {
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_literal1423); 

                    }
                    break;
                case 6 :
                    // ES3Walker.g3:242:4: RegularExpressionLiteral
                    {
                    match(input,RegularExpressionLiteral,FOLLOW_RegularExpressionLiteral_in_literal1428); 

                    }
                    break;
                case 7 :
                    // ES3Walker.g3:243:4: arrayLiteral
                    {
                    pushFollow(FOLLOW_arrayLiteral_in_literal1433);
                    arrayLiteral();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // ES3Walker.g3:244:4: objectLiteral
                    {
                    pushFollow(FOLLOW_objectLiteral_in_literal1438);
                    objectLiteral();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "literal"



    // $ANTLR start "booleanLiteral"
    // ES3Walker.g3:247:1: booleanLiteral : ( TRUE | FALSE );
    public final void booleanLiteral() throws RecognitionException {
        try {
            // ES3Walker.g3:248:2: ( TRUE | FALSE )
            // ES3Walker.g3:
            {
            if ( input.LA(1)==FALSE||input.LA(1)==TRUE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "booleanLiteral"



    // $ANTLR start "numericLiteral"
    // ES3Walker.g3:252:1: numericLiteral : ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral );
    public final void numericLiteral() throws RecognitionException {
        try {
            // ES3Walker.g3:253:2: ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral )
            // ES3Walker.g3:
            {
            if ( input.LA(1)==DecimalLiteral||input.LA(1)==HexIntegerLiteral||input.LA(1)==OctalIntegerLiteral ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "numericLiteral"



    // $ANTLR start "arrayLiteral"
    // ES3Walker.g3:258:1: arrayLiteral : ^( ARRAY ( ^( ITEM ( expr )? ) )* ) ;
    public final void arrayLiteral() throws RecognitionException {
        try {
            // ES3Walker.g3:259:2: ( ^( ARRAY ( ^( ITEM ( expr )? ) )* ) )
            // ES3Walker.g3:259:4: ^( ARRAY ( ^( ITEM ( expr )? ) )* )
            {
            match(input,ARRAY,FOLLOW_ARRAY_in_arrayLiteral1488); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:259:13: ( ^( ITEM ( expr )? ) )*
                loop30:
                do {
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==ITEM) ) {
                        alt30=1;
                    }


                    switch (alt30) {
                	case 1 :
                	    // ES3Walker.g3:259:15: ^( ITEM ( expr )? )
                	    {
                	    match(input,ITEM,FOLLOW_ITEM_in_arrayLiteral1494); 

                	    if ( input.LA(1)==Token.DOWN ) {
                	        match(input, Token.DOWN, null); 
                	        // ES3Walker.g3:259:23: ( expr )?
                	        int alt29=2;
                	        int LA29_0 = input.LA(1);

                	        if ( ((LA29_0 >= ADD && LA29_0 <= ANDASS)||(LA29_0 >= ARRAY && LA29_0 <= ASSIGN)||(LA29_0 >= BYFIELD && LA29_0 <= BYINDEX)||LA29_0==CALL||LA29_0==DEC||(LA29_0 >= DELETE && LA29_0 <= DIVASS)||LA29_0==DecimalLiteral||LA29_0==EQ||LA29_0==FALSE||LA29_0==FUNCTION||(LA29_0 >= GT && LA29_0 <= GTE)||LA29_0==HexIntegerLiteral||(LA29_0 >= IN && LA29_0 <= INSTANCEOF)||LA29_0==INV||LA29_0==Identifier||LA29_0==LAND||LA29_0==LOR||(LA29_0 >= LT && LA29_0 <= LTE)||(LA29_0 >= MOD && LA29_0 <= MULASS)||(LA29_0 >= NEG && LA29_0 <= ORASS)||LA29_0==OctalIntegerLiteral||(LA29_0 >= PDEC && LA29_0 <= POS)||LA29_0==QUE||(LA29_0 >= RegularExpressionLiteral && LA29_0 <= SAME)||(LA29_0 >= SHL && LA29_0 <= SHLASS)||(LA29_0 >= SHR && LA29_0 <= SHUASS)||(LA29_0 >= SUB && LA29_0 <= SUBASS)||LA29_0==StringLiteral||LA29_0==THIS||LA29_0==TRUE||LA29_0==TYPEOF||LA29_0==VOID||(LA29_0 >= XOR && LA29_0 <= XORASS)) ) {
                	            alt29=1;
                	        }
                	        switch (alt29) {
                	            case 1 :
                	                // ES3Walker.g3:259:23: expr
                	                {
                	                pushFollow(FOLLOW_expr_in_arrayLiteral1496);
                	                expr();

                	                state._fsp--;


                	                }
                	                break;

                	        }


                	        match(input, Token.UP, null); 
                	    }


                	    }
                	    break;

                	default :
                	    break loop30;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "arrayLiteral"



    // $ANTLR start "objectLiteral"
    // ES3Walker.g3:262:1: objectLiteral : ^( OBJECT ( ^( NAMEDVALUE propertyName expr ) )* ) ;
    public final void objectLiteral() throws RecognitionException {
        try {
            // ES3Walker.g3:263:2: ( ^( OBJECT ( ^( NAMEDVALUE propertyName expr ) )* ) )
            // ES3Walker.g3:263:4: ^( OBJECT ( ^( NAMEDVALUE propertyName expr ) )* )
            {
            match(input,OBJECT,FOLLOW_OBJECT_in_objectLiteral1517); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ES3Walker.g3:263:14: ( ^( NAMEDVALUE propertyName expr ) )*
                loop31:
                do {
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==NAMEDVALUE) ) {
                        alt31=1;
                    }


                    switch (alt31) {
                	case 1 :
                	    // ES3Walker.g3:263:16: ^( NAMEDVALUE propertyName expr )
                	    {
                	    match(input,NAMEDVALUE,FOLLOW_NAMEDVALUE_in_objectLiteral1523); 

                	    match(input, Token.DOWN, null); 
                	    pushFollow(FOLLOW_propertyName_in_objectLiteral1525);
                	    propertyName();

                	    state._fsp--;


                	    pushFollow(FOLLOW_expr_in_objectLiteral1527);
                	    expr();

                	    state._fsp--;


                	    match(input, Token.UP, null); 


                	    }
                	    break;

                	default :
                	    break loop31;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "objectLiteral"



    // $ANTLR start "propertyName"
    // ES3Walker.g3:266:1: propertyName : ( Identifier | StringLiteral | numericLiteral );
    public final void propertyName() throws RecognitionException {
        try {
            // ES3Walker.g3:267:2: ( Identifier | StringLiteral | numericLiteral )
            int alt32=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt32=1;
                }
                break;
            case StringLiteral:
                {
                alt32=2;
                }
                break;
            case DecimalLiteral:
            case HexIntegerLiteral:
            case OctalIntegerLiteral:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }

            switch (alt32) {
                case 1 :
                    // ES3Walker.g3:267:4: Identifier
                    {
                    match(input,Identifier,FOLLOW_Identifier_in_propertyName1545); 

                    }
                    break;
                case 2 :
                    // ES3Walker.g3:268:4: StringLiteral
                    {
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_propertyName1550); 

                    }
                    break;
                case 3 :
                    // ES3Walker.g3:269:4: numericLiteral
                    {
                    pushFollow(FOLLOW_numericLiteral_in_propertyName1555);
                    numericLiteral();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "propertyName"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program43 = new BitSet(new long[]{0x4841107A20935DE2L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_block_in_statement55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_statement60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doStatement_in_statement75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statement80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statement90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statement95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withStatement_in_statement105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelledStatement_in_statement110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statement115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statement120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tryStatement_in_statement125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block140 = new BitSet(new long[]{0x4841107A20935DE8L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_VAR_in_variableDeclaration156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaration160 = new BitSet(new long[]{0x0000000000000808L,0x0000000000008000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaration168 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_variableDeclaration170 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifStatement190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ifStatement192 = new BitSet(new long[]{0x4841107A20935DE0L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_statement_in_ifStatement194 = new BitSet(new long[]{0x4841107A20935DE8L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_DO_in_doStatement210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_doStatement212 = new BitSet(new long[]{0x4041103A00930DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expression_in_doStatement214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_whileStatement231 = new BitSet(new long[]{0x4841107A20935DE0L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_statement_in_whileStatement233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOR_in_forStatement249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FORSTEP_in_forStatement259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_exprOptClause_in_forStatement263 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_forStatement267 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_exprOptClause_in_forStatement271 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_exprOptClause_in_forStatement273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORITER_in_forStatement283 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_exprClause_in_forStatement287 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_forStatement291 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_exprClause_in_forStatement295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statement_in_forStatement303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_in_exprOptClause317 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_exprOptClause319 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_in_exprClause335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_exprClause337 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONTINUE_in_continueStatement352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_continueStatement354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BREAK_in_breakStatement370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_breakStatement372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement388 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_returnStatement390 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WITH_in_withStatement406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_withStatement408 = new BitSet(new long[]{0x4841107A20935DE0L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_statement_in_withStatement410 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LABELLED_in_labelledStatement425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_labelledStatement427 = new BitSet(new long[]{0x4841107A20935DE0L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_statement_in_labelledStatement429 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SWITCH_in_switchStatement444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_switchStatement446 = new BitSet(new long[]{0x0000000400200008L});
    public static final BitSet FOLLOW_defaultClause_in_switchStatement448 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_caseClause_in_switchStatement451 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_DEFAULT_in_defaultClause467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_defaultClause469 = new BitSet(new long[]{0x4841107A20935DE8L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_CASE_in_caseClause485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_caseClause487 = new BitSet(new long[]{0x4841107A20935DE8L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_statement_in_caseClause489 = new BitSet(new long[]{0x4841107A20935DE8L,0x90E4FF87B218A733L,0x00000366734B1ED8L});
    public static final BitSet FOLLOW_THROW_in_throwStatement505 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_throwStatement507 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRY_in_tryStatement522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_tryStatement524 = new BitSet(new long[]{0x0200000000400008L});
    public static final BitSet FOLLOW_catchClause_in_tryStatement526 = new BitSet(new long[]{0x0200000000000008L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement529 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CATCH_in_catchClause546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_catchClause548 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_block_in_catchClause550 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_finallyClause568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_expression581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CEXPR_in_expression589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expression591 = new BitSet(new long[]{0x4041103A00130DE8L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_expr605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_expr616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr618 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr620 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MULASS_in_expr629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr631 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVASS_in_expr642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr644 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr646 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODASS_in_expr655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr657 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr659 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ADDASS_in_expr668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr670 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUBASS_in_expr681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr683 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHLASS_in_expr694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr696 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr698 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHRASS_in_expr707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr709 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHUASS_in_expr720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr722 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr724 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANDASS_in_expr733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr735 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_XORASS_in_expr746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr748 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORASS_in_expr759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr761 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr763 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUE_in_expr776 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr778 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr780 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOR_in_expr795 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr797 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr799 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LAND_in_expr808 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr810 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr825 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr827 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr829 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expr838 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr840 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr842 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_XOR_in_expr851 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr853 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr855 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_expr868 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr870 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr872 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEQ_in_expr881 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr883 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr885 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAME_in_expr894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr896 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr898 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NSAME_in_expr907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr909 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr911 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LT_in_expr924 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr926 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr928 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GT_in_expr937 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr939 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr941 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LTE_in_expr950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr952 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr954 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GTE_in_expr963 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr965 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr967 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INSTANCEOF_in_expr976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr978 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr980 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_expr989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr991 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr993 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHL_in_expr1006 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1008 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1010 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHR_in_expr1019 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1021 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1023 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHU_in_expr1032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1034 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1036 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ADD_in_expr1049 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1051 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1053 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUB_in_expr1062 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1064 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1066 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MUL_in_expr1079 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1081 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1083 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1092 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1094 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1096 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1107 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_expr1109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DELETE_in_expr1122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VOID_in_expr1133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPEOF_in_expr1144 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1146 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INC_in_expr1155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEC_in_expr1166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POS_in_expr1177 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEG_in_expr1188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INV_in_expr1199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PINC_in_expr1225 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PDEC_in_expr1236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_primaryExpression_in_leftHandSideExpression1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_leftHandSideExpression1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_leftHandSideExpression1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_callExpression_in_leftHandSideExpression1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpression_in_leftHandSideExpression1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression1284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_newExpression1286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_functionDeclaration1301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_functionDeclaration1303 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ARGS_in_functionDeclaration1308 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_functionDeclaration1310 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L});
    public static final BitSet FOLLOW_block_in_functionDeclaration1315 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CALL_in_callExpression1330 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_callExpression1332 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ARGS_in_callExpression1336 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_callExpression1338 = new BitSet(new long[]{0x4041103A00130DE8L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_BYINDEX_in_memberExpression1357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_memberExpression1359 = new BitSet(new long[]{0x4041103A00930DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expression_in_memberExpression1361 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BYFIELD_in_memberExpression1370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_memberExpression1372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_Identifier_in_memberExpression1374 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Identifier_in_primaryExpression1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpression1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_literal1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RegularExpressionLiteral_in_literal1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayLiteral_in_literal1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectLiteral_in_literal1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_arrayLiteral1488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ITEM_in_arrayLiteral1494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_arrayLiteral1496 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OBJECT_in_objectLiteral1517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NAMEDVALUE_in_objectLiteral1523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyName_in_objectLiteral1525 = new BitSet(new long[]{0x4041103A00130DE0L,0x10E4FF87B210A713L,0x0000030451431ED8L});
    public static final BitSet FOLLOW_expr_in_objectLiteral1527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Identifier_in_propertyName1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_propertyName1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_propertyName1555 = new BitSet(new long[]{0x0000000000000002L});

}