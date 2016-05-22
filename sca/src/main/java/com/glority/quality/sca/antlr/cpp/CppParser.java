package com.glority.quality.sca.antlr.cpp;

// $ANTLR 3.4 Cpp.g 2012-10-23 16:08:43

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CppParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AMPERSAND", "AND", "ARGS", "ASSIGNEQUAL", "BITWISEANDEQUAL", "BITWISEOR", "BITWISEOREQUAL", "BITWISEXOR", "BITWISEXOREQUAL", "CHARACTER_LITERAL", "CKEYWORD", "COLON", "COMMA", "COMMENT", "CONCATENATE", "COPERATOR", "DECIMAL_LITERAL", "DEFINE", "DEFINED", "DIRECTIVE", "DIVIDE", "DIVIDEEQUAL", "DOT", "DOTMBR", "ELLIPSIS", "ELSE", "ENDIF", "EQUAL", "ERROR", "ESCAPED_NEWLINE", "EXEC_MACRO", "EXPAND", "EXPR", "EXPR_DEF", "EXPR_GROUP", "EXPR_NDEF", "EXP_ARG", "EXP_ARGS", "End", "EscapeSequence", "Exponent", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "GREATERTHAN", "GREATERTHANOREQUALTO", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "IF", "IFDEF", "IFNDEF", "INCLUDE", "INCLUDE_EXPAND", "INCLUDE_FILE", "INDEX_OP", "IntegerTypeSuffix", "LCURLY", "LESSTHAN", "LESSTHANOREQUALTO", "LETTER", "LINE", "LINECOMMENTS", "LINE_COMMENT", "LPAREN", "LSQUARE", "MACRO_DEFINE", "MACRO_TEXT", "MAC_FUNCTION", "MAC_FUNCTION_OBJECT", "MAC_OBJECT", "METHOD_CALL", "MINUS", "MINUSEQUAL", "MINUSMINUS", "MOD", "MODEQUAL", "NOT", "NOTEQUAL", "OCTAL_LITERAL", "OR", "OctalEscape", "PLUS", "PLUSEQUAL", "PLUSPLUS", "POINTER", "POINTERTO", "POINTERTOMBR", "POINTER_AT", "POST_DEC", "POST_INC", "PRAGMA", "QUESTIONMARK", "RCURLY", "REFERANCE", "RPAREN", "RSQUARE", "SCOPE", "SEMICOLON", "SHARPSHARP", "SHIFTLEFT", "SHIFTLEFTEQUAL", "SHIFTRIGHT", "SHIFTRIGHTEQUAL", "SIZEOF", "SIZEOF_TYPE", "STAR", "STRINGIFICATION", "STRING_LITERAL", "STRING_OP", "TEXT_END", "TEXT_GROUP", "TEXT_LINE", "TILDE", "TIMESEQUAL", "TYPECAST", "UNARY_MINUS", "UNARY_PLUS", "UNDEF", "UnicodeEscape", "WARNING", "WS"
    };
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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CppParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CppParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[168+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return CppParser.tokenNames; }
    public String getGrammarFileName() { return "Cpp.g"; }


    public static class preprocess_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "preprocess"
    // Cpp.g:54:1: preprocess : ( procLine )+ ;
    public final CppParser.preprocess_return preprocess() throws RecognitionException {
        CppParser.preprocess_return retval = new CppParser.preprocess_return();
        retval.start = input.LT(1);

        int preprocess_StartIndex = input.index();

        Object root_0 = null;

        CppParser.procLine_return procLine1 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // Cpp.g:55:5: ( ( procLine )+ )
            // Cpp.g:55:7: ( procLine )+
            {
            root_0 = (Object)adaptor.nil();


            // Cpp.g:55:7: ( procLine )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= CHARACTER_LITERAL && LA1_0 <= CKEYWORD)||LA1_0==COMMA||(LA1_0 >= COPERATOR && LA1_0 <= DEFINE)||LA1_0==DIRECTIVE||LA1_0==ERROR||LA1_0==EXEC_MACRO||LA1_0==End||LA1_0==FLOATING_POINT_LITERAL||LA1_0==HEX_LITERAL||LA1_0==IDENTIFIER||(LA1_0 >= INCLUDE && LA1_0 <= INCLUDE_EXPAND)||(LA1_0 >= LINE && LA1_0 <= LINECOMMENTS)||LA1_0==LPAREN||LA1_0==OCTAL_LITERAL||LA1_0==PRAGMA||LA1_0==RPAREN||(LA1_0 >= SEMICOLON && LA1_0 <= SHARPSHARP)||LA1_0==SIZEOF||(LA1_0 >= STRINGIFICATION && LA1_0 <= TEXT_END)||LA1_0==UNDEF||(LA1_0 >= WARNING && LA1_0 <= WS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cpp.g:55:7: procLine
            	    {
            	    pushFollow(FOLLOW_procLine_in_preprocess268);
            	    procLine1=procLine();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, procLine1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, preprocess_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "preprocess"


    public static class procLine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procLine"
    // Cpp.g:58:1: procLine : ( DIRECTIVE !| text_line | diagnostics | fileInclusion | macroDefine | macroUndef | lineControl | macroExecution )? End ;
    public final CppParser.procLine_return procLine() throws RecognitionException {
        CppParser.procLine_return retval = new CppParser.procLine_return();
        retval.start = input.LT(1);

        int procLine_StartIndex = input.index();

        Object root_0 = null;

        Token DIRECTIVE2=null;
        Token End10=null;
        CppParser.text_line_return text_line3 =null;

        CppParser.diagnostics_return diagnostics4 =null;

        CppParser.fileInclusion_return fileInclusion5 =null;

        CppParser.macroDefine_return macroDefine6 =null;

        CppParser.macroUndef_return macroUndef7 =null;

        CppParser.lineControl_return lineControl8 =null;

        CppParser.macroExecution_return macroExecution9 =null;


        Object DIRECTIVE2_tree=null;
        Object End10_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // Cpp.g:59:5: ( ( DIRECTIVE !| text_line | diagnostics | fileInclusion | macroDefine | macroUndef | lineControl | macroExecution )? End )
            // Cpp.g:60:5: ( DIRECTIVE !| text_line | diagnostics | fileInclusion | macroDefine | macroUndef | lineControl | macroExecution )? End
            {
            root_0 = (Object)adaptor.nil();


            // Cpp.g:60:5: ( DIRECTIVE !| text_line | diagnostics | fileInclusion | macroDefine | macroUndef | lineControl | macroExecution )?
            int alt2=9;
            switch ( input.LA(1) ) {
                case DIRECTIVE:
                    {
                    alt2=1;
                    }
                    break;
                case CHARACTER_LITERAL:
                case CKEYWORD:
                case COMMA:
                case COPERATOR:
                case DECIMAL_LITERAL:
                case FLOATING_POINT_LITERAL:
                case HEX_LITERAL:
                case IDENTIFIER:
                case LINECOMMENTS:
                case LPAREN:
                case OCTAL_LITERAL:
                case RPAREN:
                case SEMICOLON:
                case SHARPSHARP:
                case SIZEOF:
                case STRINGIFICATION:
                case STRING_LITERAL:
                case STRING_OP:
                case TEXT_END:
                case WS:
                    {
                    alt2=2;
                    }
                    break;
                case ERROR:
                case PRAGMA:
                case WARNING:
                    {
                    alt2=3;
                    }
                    break;
                case INCLUDE:
                case INCLUDE_EXPAND:
                    {
                    alt2=4;
                    }
                    break;
                case DEFINE:
                    {
                    alt2=5;
                    }
                    break;
                case UNDEF:
                    {
                    alt2=6;
                    }
                    break;
                case LINE:
                    {
                    alt2=7;
                    }
                    break;
                case EXEC_MACRO:
                    {
                    alt2=8;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // Cpp.g:60:7: DIRECTIVE !
                    {
                    DIRECTIVE2=(Token)match(input,DIRECTIVE,FOLLOW_DIRECTIVE_in_procLine294); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // Cpp.g:61:7: text_line
                    {
                    pushFollow(FOLLOW_text_line_in_procLine303);
                    text_line3=text_line();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, text_line3.getTree());

                    }
                    break;
                case 3 :
                    // Cpp.g:62:7: diagnostics
                    {
                    pushFollow(FOLLOW_diagnostics_in_procLine312);
                    diagnostics4=diagnostics();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, diagnostics4.getTree());

                    }
                    break;
                case 4 :
                    // Cpp.g:63:7: fileInclusion
                    {
                    pushFollow(FOLLOW_fileInclusion_in_procLine320);
                    fileInclusion5=fileInclusion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fileInclusion5.getTree());

                    }
                    break;
                case 5 :
                    // Cpp.g:64:7: macroDefine
                    {
                    pushFollow(FOLLOW_macroDefine_in_procLine328);
                    macroDefine6=macroDefine();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroDefine6.getTree());

                    }
                    break;
                case 6 :
                    // Cpp.g:65:7: macroUndef
                    {
                    pushFollow(FOLLOW_macroUndef_in_procLine336);
                    macroUndef7=macroUndef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroUndef7.getTree());

                    }
                    break;
                case 7 :
                    // Cpp.g:66:7: lineControl
                    {
                    pushFollow(FOLLOW_lineControl_in_procLine344);
                    lineControl8=lineControl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lineControl8.getTree());

                    }
                    break;
                case 8 :
                    // Cpp.g:67:7: macroExecution
                    {
                    pushFollow(FOLLOW_macroExecution_in_procLine353);
                    macroExecution9=macroExecution();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroExecution9.getTree());

                    }
                    break;

            }


            End10=(Token)match(input,End,FOLLOW_End_in_procLine363); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            End10_tree = 
            (Object)adaptor.create(End10)
            ;
            adaptor.addChild(root_0, End10_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, procLine_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "procLine"


    public static class fileInclusion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fileInclusion"
    // Cpp.g:71:1: fileInclusion : ( INCLUDE -> ^( INCLUDE ) | INCLUDE_EXPAND -> ^( INCLUDE_EXPAND ) );
    public final CppParser.fileInclusion_return fileInclusion() throws RecognitionException {
        CppParser.fileInclusion_return retval = new CppParser.fileInclusion_return();
        retval.start = input.LT(1);

        int fileInclusion_StartIndex = input.index();

        Object root_0 = null;

        Token INCLUDE11=null;
        Token INCLUDE_EXPAND12=null;

        Object INCLUDE11_tree=null;
        Object INCLUDE_EXPAND12_tree=null;
        RewriteRuleTokenStream stream_INCLUDE_EXPAND=new RewriteRuleTokenStream(adaptor,"token INCLUDE_EXPAND");
        RewriteRuleTokenStream stream_INCLUDE=new RewriteRuleTokenStream(adaptor,"token INCLUDE");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // Cpp.g:72:5: ( INCLUDE -> ^( INCLUDE ) | INCLUDE_EXPAND -> ^( INCLUDE_EXPAND ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INCLUDE) ) {
                alt3=1;
            }
            else if ( (LA3_0==INCLUDE_EXPAND) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Cpp.g:72:7: INCLUDE
                    {
                    INCLUDE11=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_fileInclusion381); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCLUDE.add(INCLUDE11);


                    // AST REWRITE
                    // elements: INCLUDE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 72:16: -> ^( INCLUDE )
                    {
                        // Cpp.g:72:20: ^( INCLUDE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_INCLUDE.nextNode()
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:73:7: INCLUDE_EXPAND
                    {
                    INCLUDE_EXPAND12=(Token)match(input,INCLUDE_EXPAND,FOLLOW_INCLUDE_EXPAND_in_fileInclusion397); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCLUDE_EXPAND.add(INCLUDE_EXPAND12);


                    // AST REWRITE
                    // elements: INCLUDE_EXPAND
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:23: -> ^( INCLUDE_EXPAND )
                    {
                        // Cpp.g:73:26: ^( INCLUDE_EXPAND )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_INCLUDE_EXPAND.nextNode()
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, fileInclusion_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "fileInclusion"


    public static class macroDefine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroDefine"
    // Cpp.g:76:1: macroDefine : ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? ) | DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? ) | DEFINE IDENTIFIER ( macro_text )? -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? ) );
    public final CppParser.macroDefine_return macroDefine() throws RecognitionException {
        CppParser.macroDefine_return retval = new CppParser.macroDefine_return();
        retval.start = input.LT(1);

        int macroDefine_StartIndex = input.index();

        Object root_0 = null;

        Token mac=null;
        Token DEFINE13=null;
        Token IDENTIFIER14=null;
        Token LPAREN15=null;
        Token WS16=null;
        Token RPAREN17=null;
        Token DEFINE19=null;
        Token LPAREN20=null;
        Token WS21=null;
        Token WS22=null;
        Token COMMA23=null;
        Token WS24=null;
        Token WS25=null;
        Token RPAREN26=null;
        Token DEFINE28=null;
        Token IDENTIFIER29=null;
        List list_arg=null;
        CppParser.macro_text_return macro_text18 =null;

        CppParser.macro_text_return macro_text27 =null;

        CppParser.macro_text_return macro_text30 =null;

        RuleReturnScope arg = null;
        Object mac_tree=null;
        Object DEFINE13_tree=null;
        Object IDENTIFIER14_tree=null;
        Object LPAREN15_tree=null;
        Object WS16_tree=null;
        Object RPAREN17_tree=null;
        Object DEFINE19_tree=null;
        Object LPAREN20_tree=null;
        Object WS21_tree=null;
        Object WS22_tree=null;
        Object COMMA23_tree=null;
        Object WS24_tree=null;
        Object WS25_tree=null;
        Object RPAREN26_tree=null;
        Object DEFINE28_tree=null;
        Object IDENTIFIER29_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_macroParam=new RewriteRuleSubtreeStream(adaptor,"rule macroParam");
        RewriteRuleSubtreeStream stream_macro_text=new RewriteRuleSubtreeStream(adaptor,"rule macro_text");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // Cpp.g:77:5: ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? ) | DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? ) | DEFINE IDENTIFIER ( macro_text )? -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? ) )
            int alt14=3;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // Cpp.g:77:7: DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )?
                    {
                    DEFINE13=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_macroDefine424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE13);


                    IDENTIFIER14=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine427); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER14);


                    LPAREN15=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroDefine430); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN15);


                    // Cpp.g:77:35: ( WS )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==WS) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Cpp.g:77:35: WS
                            {
                            WS16=(Token)match(input,WS,FOLLOW_WS_in_macroDefine433); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS16);


                            }
                            break;

                    }


                    RPAREN17=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroDefine436); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN17);


                    // Cpp.g:77:47: ( macro_text )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0 >= CHARACTER_LITERAL && LA5_0 <= CKEYWORD)||LA5_0==COMMA||(LA5_0 >= COPERATOR && LA5_0 <= DECIMAL_LITERAL)||LA5_0==FLOATING_POINT_LITERAL||LA5_0==HEX_LITERAL||LA5_0==IDENTIFIER||LA5_0==LINECOMMENTS||LA5_0==LPAREN||LA5_0==OCTAL_LITERAL||LA5_0==RPAREN||(LA5_0 >= SEMICOLON && LA5_0 <= SHARPSHARP)||LA5_0==SIZEOF||(LA5_0 >= STRINGIFICATION && LA5_0 <= TEXT_END)||LA5_0==WS) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // Cpp.g:77:47: macro_text
                            {
                            pushFollow(FOLLOW_macro_text_in_macroDefine439);
                            macro_text18=macro_text();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macro_text.add(macro_text18.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: IDENTIFIER, macro_text
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 77:60: -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? )
                    {
                        // Cpp.g:77:63: ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(MAC_FUNCTION_OBJECT, "MAC_FUNCTION_OBJECT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        // Cpp.g:77:97: ( macro_text )?
                        if ( stream_macro_text.hasNext() ) {
                            adaptor.addChild(root_1, stream_macro_text.nextTree());

                        }
                        stream_macro_text.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:78:7: DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )?
                    {
                    DEFINE19=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_macroDefine461); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE19);


                    mac=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine466); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(mac);


                    LPAREN20=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroDefine470); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN20);


                    // Cpp.g:78:39: ( WS )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==WS) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // Cpp.g:78:39: WS
                            {
                            WS21=(Token)match(input,WS,FOLLOW_WS_in_macroDefine472); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS21);


                            }
                            break;

                    }


                    // Cpp.g:78:45: (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==ELLIPSIS||LA11_0==IDENTIFIER) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Cpp.g:78:46: arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                            {
                            pushFollow(FOLLOW_macroParam_in_macroDefine480);
                            arg=macroParam();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macroParam.add(arg.getTree());
                            if (list_arg==null) list_arg=new ArrayList();
                            list_arg.add(arg.getTree());


                            // Cpp.g:78:63: ( WS )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==WS) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // Cpp.g:78:63: WS
                                    {
                                    WS22=(Token)match(input,WS,FOLLOW_WS_in_macroDefine483); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_WS.add(WS22);


                                    }
                                    break;

                            }


                            // Cpp.g:78:67: ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==COMMA) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // Cpp.g:78:68: COMMA ( WS )* arg+= macroParam ( WS )*
                            	    {
                            	    COMMA23=(Token)match(input,COMMA,FOLLOW_COMMA_in_macroDefine487); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA23);


                            	    // Cpp.g:78:75: ( WS )*
                            	    loop8:
                            	    do {
                            	        int alt8=2;
                            	        int LA8_0 = input.LA(1);

                            	        if ( (LA8_0==WS) ) {
                            	            alt8=1;
                            	        }


                            	        switch (alt8) {
                            	    	case 1 :
                            	    	    // Cpp.g:78:75: WS
                            	    	    {
                            	    	    WS24=(Token)match(input,WS,FOLLOW_WS_in_macroDefine490); if (state.failed) return retval; 
                            	    	    if ( state.backtracking==0 ) stream_WS.add(WS24);


                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop8;
                            	        }
                            	    } while (true);


                            	    pushFollow(FOLLOW_macroParam_in_macroDefine495);
                            	    arg=macroParam();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_macroParam.add(arg.getTree());
                            	    if (list_arg==null) list_arg=new ArrayList();
                            	    list_arg.add(arg.getTree());


                            	    // Cpp.g:78:95: ( WS )*
                            	    loop9:
                            	    do {
                            	        int alt9=2;
                            	        int LA9_0 = input.LA(1);

                            	        if ( (LA9_0==WS) ) {
                            	            alt9=1;
                            	        }


                            	        switch (alt9) {
                            	    	case 1 :
                            	    	    // Cpp.g:78:95: WS
                            	    	    {
                            	    	    WS25=(Token)match(input,WS,FOLLOW_WS_in_macroDefine497); if (state.failed) return retval; 
                            	    	    if ( state.backtracking==0 ) stream_WS.add(WS25);


                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop9;
                            	        }
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }


                    RPAREN26=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroDefine511); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN26);


                    // Cpp.g:79:15: ( macro_text )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0 >= CHARACTER_LITERAL && LA12_0 <= CKEYWORD)||LA12_0==COMMA||(LA12_0 >= COPERATOR && LA12_0 <= DECIMAL_LITERAL)||LA12_0==FLOATING_POINT_LITERAL||LA12_0==HEX_LITERAL||LA12_0==IDENTIFIER||LA12_0==LINECOMMENTS||LA12_0==LPAREN||LA12_0==OCTAL_LITERAL||LA12_0==RPAREN||(LA12_0 >= SEMICOLON && LA12_0 <= SHARPSHARP)||LA12_0==SIZEOF||(LA12_0 >= STRINGIFICATION && LA12_0 <= TEXT_END)||LA12_0==WS) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Cpp.g:79:15: macro_text
                            {
                            pushFollow(FOLLOW_macro_text_in_macroDefine514);
                            macro_text27=macro_text();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macro_text.add(macro_text27.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: macro_text, arg, mac
                    // token labels: mac
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: arg
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_mac=new RewriteRuleTokenStream(adaptor,"token mac",mac);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"token arg",list_arg);
                    root_0 = (Object)adaptor.nil();
                    // 79:45: -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? )
                    {
                        // Cpp.g:79:48: ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(MAC_FUNCTION, "MAC_FUNCTION")
                        , root_1);

                        adaptor.addChild(root_1, stream_mac.nextNode());

                        if ( !(stream_arg.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_arg.hasNext() ) {
                            adaptor.addChild(root_1, stream_arg.nextTree());

                        }
                        stream_arg.reset();

                        // Cpp.g:79:75: ( macro_text )?
                        if ( stream_macro_text.hasNext() ) {
                            adaptor.addChild(root_1, stream_macro_text.nextTree());

                        }
                        stream_macro_text.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:80:9: DEFINE IDENTIFIER ( macro_text )?
                    {
                    DEFINE28=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_macroDefine561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE28);


                    IDENTIFIER29=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine564); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER29);


                    // Cpp.g:80:29: ( macro_text )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0 >= CHARACTER_LITERAL && LA13_0 <= CKEYWORD)||LA13_0==COMMA||(LA13_0 >= COPERATOR && LA13_0 <= DECIMAL_LITERAL)||LA13_0==FLOATING_POINT_LITERAL||LA13_0==HEX_LITERAL||LA13_0==IDENTIFIER||LA13_0==LINECOMMENTS||LA13_0==LPAREN||LA13_0==OCTAL_LITERAL||LA13_0==RPAREN||(LA13_0 >= SEMICOLON && LA13_0 <= SHARPSHARP)||LA13_0==SIZEOF||(LA13_0 >= STRINGIFICATION && LA13_0 <= TEXT_END)||LA13_0==WS) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // Cpp.g:80:29: macro_text
                            {
                            pushFollow(FOLLOW_macro_text_in_macroDefine567);
                            macro_text30=macro_text();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macro_text.add(macro_text30.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: macro_text, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:53: -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? )
                    {
                        // Cpp.g:80:56: ^( MAC_OBJECT IDENTIFIER ( macro_text )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(MAC_OBJECT, "MAC_OBJECT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        // Cpp.g:80:83: ( macro_text )?
                        if ( stream_macro_text.hasNext() ) {
                            adaptor.addChild(root_1, stream_macro_text.nextTree());

                        }
                        stream_macro_text.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, macroDefine_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macroDefine"


    public static class macroParam_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroParam"
    // Cpp.g:83:1: macroParam : ( IDENTIFIER ELLIPSIS -> ^( ELLIPSIS IDENTIFIER ) | ELLIPSIS | IDENTIFIER );
    public final CppParser.macroParam_return macroParam() throws RecognitionException {
        CppParser.macroParam_return retval = new CppParser.macroParam_return();
        retval.start = input.LT(1);

        int macroParam_StartIndex = input.index();

        Object root_0 = null;

        Token IDENTIFIER31=null;
        Token ELLIPSIS32=null;
        Token ELLIPSIS33=null;
        Token IDENTIFIER34=null;

        Object IDENTIFIER31_tree=null;
        Object ELLIPSIS32_tree=null;
        Object ELLIPSIS33_tree=null;
        Object IDENTIFIER34_tree=null;
        RewriteRuleTokenStream stream_ELLIPSIS=new RewriteRuleTokenStream(adaptor,"token ELLIPSIS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // Cpp.g:84:5: ( IDENTIFIER ELLIPSIS -> ^( ELLIPSIS IDENTIFIER ) | ELLIPSIS | IDENTIFIER )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==ELLIPSIS) ) {
                    alt15=1;
                }
                else if ( (LA15_1==EOF||LA15_1==COMMA||LA15_1==RPAREN||LA15_1==WS) ) {
                    alt15=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA15_0==ELLIPSIS) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // Cpp.g:84:7: IDENTIFIER ELLIPSIS
                    {
                    IDENTIFIER31=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroParam615); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER31);


                    ELLIPSIS32=(Token)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_macroParam617); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELLIPSIS.add(ELLIPSIS32);


                    // AST REWRITE
                    // elements: ELLIPSIS, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:27: -> ^( ELLIPSIS IDENTIFIER )
                    {
                        // Cpp.g:84:29: ^( ELLIPSIS IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_ELLIPSIS.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:85:7: ELLIPSIS
                    {
                    root_0 = (Object)adaptor.nil();


                    ELLIPSIS33=(Token)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_macroParam633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ELLIPSIS33_tree = 
                    (Object)adaptor.create(ELLIPSIS33)
                    ;
                    adaptor.addChild(root_0, ELLIPSIS33_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:86:7: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();


                    IDENTIFIER34=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroParam641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER34_tree = 
                    (Object)adaptor.create(IDENTIFIER34)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER34_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, macroParam_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macroParam"


    public static class macroExecution_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroExecution"
    // Cpp.g:89:1: macroExecution : EXEC_MACRO ifexpression -> ^( EXEC_MACRO ifexpression ) ;
    public final CppParser.macroExecution_return macroExecution() throws RecognitionException {
        CppParser.macroExecution_return retval = new CppParser.macroExecution_return();
        retval.start = input.LT(1);

        int macroExecution_StartIndex = input.index();

        Object root_0 = null;

        Token EXEC_MACRO35=null;
        CppParser.ifexpression_return ifexpression36 =null;


        Object EXEC_MACRO35_tree=null;
        RewriteRuleTokenStream stream_EXEC_MACRO=new RewriteRuleTokenStream(adaptor,"token EXEC_MACRO");
        RewriteRuleSubtreeStream stream_ifexpression=new RewriteRuleSubtreeStream(adaptor,"rule ifexpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // Cpp.g:90:5: ( EXEC_MACRO ifexpression -> ^( EXEC_MACRO ifexpression ) )
            // Cpp.g:90:7: EXEC_MACRO ifexpression
            {
            EXEC_MACRO35=(Token)match(input,EXEC_MACRO,FOLLOW_EXEC_MACRO_in_macroExecution658); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EXEC_MACRO.add(EXEC_MACRO35);


            pushFollow(FOLLOW_ifexpression_in_macroExecution660);
            ifexpression36=ifexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifexpression.add(ifexpression36.getTree());

            // AST REWRITE
            // elements: EXEC_MACRO, ifexpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 90:31: -> ^( EXEC_MACRO ifexpression )
            {
                // Cpp.g:90:34: ^( EXEC_MACRO ifexpression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_EXEC_MACRO.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_ifexpression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, macroExecution_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macroExecution"


    public static class macroUndef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroUndef"
    // Cpp.g:93:1: macroUndef : UNDEF mac= IDENTIFIER -> ^( UNDEF IDENTIFIER ) ;
    public final CppParser.macroUndef_return macroUndef() throws RecognitionException {
        CppParser.macroUndef_return retval = new CppParser.macroUndef_return();
        retval.start = input.LT(1);

        int macroUndef_StartIndex = input.index();

        Object root_0 = null;

        Token mac=null;
        Token UNDEF37=null;

        Object mac_tree=null;
        Object UNDEF37_tree=null;
        RewriteRuleTokenStream stream_UNDEF=new RewriteRuleTokenStream(adaptor,"token UNDEF");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // Cpp.g:94:5: ( UNDEF mac= IDENTIFIER -> ^( UNDEF IDENTIFIER ) )
            // Cpp.g:94:7: UNDEF mac= IDENTIFIER
            {
            UNDEF37=(Token)match(input,UNDEF,FOLLOW_UNDEF_in_macroUndef689); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UNDEF.add(UNDEF37);


            mac=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroUndef693); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(mac);


            // AST REWRITE
            // elements: IDENTIFIER, UNDEF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 94:29: -> ^( UNDEF IDENTIFIER )
            {
                // Cpp.g:94:32: ^( UNDEF IDENTIFIER )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_UNDEF.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_IDENTIFIER.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, macroUndef_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macroUndef"


    public static class lineControl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lineControl"
    // Cpp.g:98:1: lineControl : LINE n= DECIMAL_LITERAL (theFile= STRING_LITERAL )? -> ^( LINE $n ( $theFile)? ) ;
    public final CppParser.lineControl_return lineControl() throws RecognitionException {
        CppParser.lineControl_return retval = new CppParser.lineControl_return();
        retval.start = input.LT(1);

        int lineControl_StartIndex = input.index();

        Object root_0 = null;

        Token n=null;
        Token theFile=null;
        Token LINE38=null;

        Object n_tree=null;
        Object theFile_tree=null;
        Object LINE38_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_LINE=new RewriteRuleTokenStream(adaptor,"token LINE");
        RewriteRuleTokenStream stream_DECIMAL_LITERAL=new RewriteRuleTokenStream(adaptor,"token DECIMAL_LITERAL");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // Cpp.g:99:5: ( LINE n= DECIMAL_LITERAL (theFile= STRING_LITERAL )? -> ^( LINE $n ( $theFile)? ) )
            // Cpp.g:99:7: LINE n= DECIMAL_LITERAL (theFile= STRING_LITERAL )?
            {
            LINE38=(Token)match(input,LINE,FOLLOW_LINE_in_lineControl723); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LINE.add(LINE38);


            n=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_lineControl728); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DECIMAL_LITERAL.add(n);


            // Cpp.g:99:31: (theFile= STRING_LITERAL )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==STRING_LITERAL) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Cpp.g:99:32: theFile= STRING_LITERAL
                    {
                    theFile=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_lineControl733); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING_LITERAL.add(theFile);


                    }
                    break;

            }


            // AST REWRITE
            // elements: n, LINE, theFile
            // token labels: theFile, n
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_theFile=new RewriteRuleTokenStream(adaptor,"token theFile",theFile);
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 99:58: -> ^( LINE $n ( $theFile)? )
            {
                // Cpp.g:99:60: ^( LINE $n ( $theFile)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_LINE.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_n.nextNode());

                // Cpp.g:99:70: ( $theFile)?
                if ( stream_theFile.hasNext() ) {
                    adaptor.addChild(root_1, stream_theFile.nextNode());

                }
                stream_theFile.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, lineControl_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "lineControl"


    public static class diagnostics_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "diagnostics"
    // Cpp.g:102:1: diagnostics : ( WARNING -> ^( WARNING ) | ERROR -> ^( ERROR ) | PRAGMA -> ^( PRAGMA ) );
    public final CppParser.diagnostics_return diagnostics() throws RecognitionException {
        CppParser.diagnostics_return retval = new CppParser.diagnostics_return();
        retval.start = input.LT(1);

        int diagnostics_StartIndex = input.index();

        Object root_0 = null;

        Token WARNING39=null;
        Token ERROR40=null;
        Token PRAGMA41=null;

        Object WARNING39_tree=null;
        Object ERROR40_tree=null;
        Object PRAGMA41_tree=null;
        RewriteRuleTokenStream stream_ERROR=new RewriteRuleTokenStream(adaptor,"token ERROR");
        RewriteRuleTokenStream stream_WARNING=new RewriteRuleTokenStream(adaptor,"token WARNING");
        RewriteRuleTokenStream stream_PRAGMA=new RewriteRuleTokenStream(adaptor,"token PRAGMA");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // Cpp.g:103:5: ( WARNING -> ^( WARNING ) | ERROR -> ^( ERROR ) | PRAGMA -> ^( PRAGMA ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case WARNING:
                {
                alt17=1;
                }
                break;
            case ERROR:
                {
                alt17=2;
                }
                break;
            case PRAGMA:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // Cpp.g:103:7: WARNING
                    {
                    WARNING39=(Token)match(input,WARNING,FOLLOW_WARNING_in_diagnostics771); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WARNING.add(WARNING39);


                    // AST REWRITE
                    // elements: WARNING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 103:15: -> ^( WARNING )
                    {
                        // Cpp.g:103:18: ^( WARNING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_WARNING.nextNode()
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:104:7: ERROR
                    {
                    ERROR40=(Token)match(input,ERROR,FOLLOW_ERROR_in_diagnostics785); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ERROR.add(ERROR40);


                    // AST REWRITE
                    // elements: ERROR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 104:13: -> ^( ERROR )
                    {
                        // Cpp.g:104:16: ^( ERROR )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_ERROR.nextNode()
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:105:7: PRAGMA
                    {
                    PRAGMA41=(Token)match(input,PRAGMA,FOLLOW_PRAGMA_in_diagnostics799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PRAGMA.add(PRAGMA41);


                    // AST REWRITE
                    // elements: PRAGMA
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 105:15: -> ^( PRAGMA )
                    {
                        // Cpp.g:105:18: ^( PRAGMA )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_PRAGMA.nextNode()
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, diagnostics_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "diagnostics"


    public static class text_line_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "text_line"
    // Cpp.g:108:1: text_line : ( source_text )+ -> ^( TEXT_LINE ( source_text )+ ) ;
    public final CppParser.text_line_return text_line() throws RecognitionException {
        CppParser.text_line_return retval = new CppParser.text_line_return();
        retval.start = input.LT(1);

        int text_line_StartIndex = input.index();

        Object root_0 = null;

        CppParser.source_text_return source_text42 =null;


        RewriteRuleSubtreeStream stream_source_text=new RewriteRuleSubtreeStream(adaptor,"rule source_text");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // Cpp.g:109:5: ( ( source_text )+ -> ^( TEXT_LINE ( source_text )+ ) )
            // Cpp.g:109:7: ( source_text )+
            {
            // Cpp.g:109:7: ( source_text )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= CHARACTER_LITERAL && LA18_0 <= CKEYWORD)||LA18_0==COMMA||(LA18_0 >= COPERATOR && LA18_0 <= DECIMAL_LITERAL)||LA18_0==FLOATING_POINT_LITERAL||LA18_0==HEX_LITERAL||LA18_0==IDENTIFIER||LA18_0==LINECOMMENTS||LA18_0==LPAREN||LA18_0==OCTAL_LITERAL||LA18_0==RPAREN||(LA18_0 >= SEMICOLON && LA18_0 <= SHARPSHARP)||LA18_0==SIZEOF||(LA18_0 >= STRINGIFICATION && LA18_0 <= TEXT_END)||LA18_0==WS) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Cpp.g:109:7: source_text
            	    {
            	    pushFollow(FOLLOW_source_text_in_text_line826);
            	    source_text42=source_text();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_source_text.add(source_text42.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            // AST REWRITE
            // elements: source_text
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 109:24: -> ^( TEXT_LINE ( source_text )+ )
            {
                // Cpp.g:109:27: ^( TEXT_LINE ( source_text )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(TEXT_LINE, "TEXT_LINE")
                , root_1);

                if ( !(stream_source_text.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_source_text.hasNext() ) {
                    adaptor.addChild(root_1, stream_source_text.nextTree());

                }
                stream_source_text.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, text_line_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "text_line"


    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // Cpp.g:113:1: statement : ( procLine )+ ;
    public final CppParser.statement_return statement() throws RecognitionException {
        CppParser.statement_return retval = new CppParser.statement_return();
        retval.start = input.LT(1);

        int statement_StartIndex = input.index();

        Object root_0 = null;

        CppParser.procLine_return procLine43 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // Cpp.g:114:5: ( ( procLine )+ )
            // Cpp.g:114:7: ( procLine )+
            {
            root_0 = (Object)adaptor.nil();


            // Cpp.g:114:7: ( procLine )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= CHARACTER_LITERAL && LA19_0 <= CKEYWORD)||LA19_0==COMMA||(LA19_0 >= COPERATOR && LA19_0 <= DEFINE)||LA19_0==DIRECTIVE||LA19_0==ERROR||LA19_0==EXEC_MACRO||LA19_0==End||LA19_0==FLOATING_POINT_LITERAL||LA19_0==HEX_LITERAL||LA19_0==IDENTIFIER||(LA19_0 >= INCLUDE && LA19_0 <= INCLUDE_EXPAND)||(LA19_0 >= LINE && LA19_0 <= LINECOMMENTS)||LA19_0==LPAREN||LA19_0==OCTAL_LITERAL||LA19_0==PRAGMA||LA19_0==RPAREN||(LA19_0 >= SEMICOLON && LA19_0 <= SHARPSHARP)||LA19_0==SIZEOF||(LA19_0 >= STRINGIFICATION && LA19_0 <= TEXT_END)||LA19_0==UNDEF||(LA19_0 >= WARNING && LA19_0 <= WS)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Cpp.g:114:7: procLine
            	    {
            	    pushFollow(FOLLOW_procLine_in_statement863);
            	    procLine43=procLine();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, procLine43.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, statement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class type_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_name"
    // Cpp.g:117:1: type_name : IDENTIFIER ;
    public final CppParser.type_name_return type_name() throws RecognitionException {
        CppParser.type_name_return retval = new CppParser.type_name_return();
        retval.start = input.LT(1);

        int type_name_StartIndex = input.index();

        Object root_0 = null;

        Token IDENTIFIER44=null;

        Object IDENTIFIER44_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // Cpp.g:118:5: ( IDENTIFIER )
            // Cpp.g:118:7: IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();


            IDENTIFIER44=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type_name884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER44_tree = 
            (Object)adaptor.create(IDENTIFIER44)
            ;
            adaptor.addChild(root_0, IDENTIFIER44_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, type_name_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "type_name"


    public static class ifexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifexpression"
    // Cpp.g:121:1: ifexpression : ( IDENTIFIER {...}? -> ^( EXPR_NDEF IDENTIFIER ) | IDENTIFIER {...}? -> ^( EXPR_DEF IDENTIFIER ) | assignmentExpression -> ^( EXPR assignmentExpression ) );
    public final CppParser.ifexpression_return ifexpression() throws RecognitionException {
        CppParser.ifexpression_return retval = new CppParser.ifexpression_return();
        retval.start = input.LT(1);

        int ifexpression_StartIndex = input.index();

        Object root_0 = null;

        Token IDENTIFIER45=null;
        Token IDENTIFIER46=null;
        CppParser.assignmentExpression_return assignmentExpression47 =null;


        Object IDENTIFIER45_tree=null;
        Object IDENTIFIER46_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // Cpp.g:122:5: ( IDENTIFIER {...}? -> ^( EXPR_NDEF IDENTIFIER ) | IDENTIFIER {...}? -> ^( EXPR_DEF IDENTIFIER ) | assignmentExpression -> ^( EXPR assignmentExpression ) )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IDENTIFIER) ) {
                int LA20_1 = input.LA(2);

                if ( (synpred30_Cpp()) ) {
                    alt20=1;
                }
                else if ( (synpred31_Cpp()) ) {
                    alt20=2;
                }
                else if ( (true) ) {
                    alt20=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA20_0==AMPERSAND||LA20_0==CHARACTER_LITERAL||LA20_0==DECIMAL_LITERAL||LA20_0==DEFINED||LA20_0==FLOATING_POINT_LITERAL||LA20_0==HEX_LITERAL||LA20_0==LPAREN||LA20_0==MINUS||LA20_0==MINUSMINUS||LA20_0==NOT||LA20_0==OCTAL_LITERAL||LA20_0==PLUS||LA20_0==PLUSPLUS||LA20_0==SIZEOF||LA20_0==STAR||LA20_0==STRING_LITERAL||LA20_0==TILDE) ) {
                alt20=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // Cpp.g:122:7: IDENTIFIER {...}?
                    {
                    IDENTIFIER45=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ifexpression901); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER45);


                    if ( !((input.LT(-2).getText().equals("ifndef"))) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "ifexpression", "input.LT(-2).getText().equals(\"ifndef\")");
                    }

                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 122:64: -> ^( EXPR_NDEF IDENTIFIER )
                    {
                        // Cpp.g:122:67: ^( EXPR_NDEF IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXPR_NDEF, "EXPR_NDEF")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:123:7: IDENTIFIER {...}?
                    {
                    IDENTIFIER46=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ifexpression923); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER46);


                    if ( !((input.LT(-2).getText().equals("ifdef"))) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "ifexpression", "input.LT(-2).getText().equals(\"ifdef\")");
                    }

                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 123:63: -> ^( EXPR_DEF IDENTIFIER )
                    {
                        // Cpp.g:123:66: ^( EXPR_DEF IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXPR_DEF, "EXPR_DEF")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:124:7: assignmentExpression
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_ifexpression945);
                    assignmentExpression47=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression47.getTree());

                    // AST REWRITE
                    // elements: assignmentExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 124:28: -> ^( EXPR assignmentExpression )
                    {
                        // Cpp.g:124:31: ^( EXPR assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXPR, "EXPR")
                        , root_1);

                        adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, ifexpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifexpression"


    public static class assignmentExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignmentExpression"
    // Cpp.g:127:1: assignmentExpression : conditionalExpression ( ( ASSIGNEQUAL ^| TIMESEQUAL ^| DIVIDEEQUAL ^| MODEQUAL ^| PLUSEQUAL ^| MINUSEQUAL ^| SHIFTLEFTEQUAL ^| SHIFTRIGHTEQUAL ^| BITWISEANDEQUAL ^| BITWISEXOREQUAL ^| BITWISEOREQUAL ^) assignmentExpression )? ;
    public final CppParser.assignmentExpression_return assignmentExpression() throws RecognitionException {
        CppParser.assignmentExpression_return retval = new CppParser.assignmentExpression_return();
        retval.start = input.LT(1);

        int assignmentExpression_StartIndex = input.index();

        Object root_0 = null;

        Token ASSIGNEQUAL49=null;
        Token TIMESEQUAL50=null;
        Token DIVIDEEQUAL51=null;
        Token MODEQUAL52=null;
        Token PLUSEQUAL53=null;
        Token MINUSEQUAL54=null;
        Token SHIFTLEFTEQUAL55=null;
        Token SHIFTRIGHTEQUAL56=null;
        Token BITWISEANDEQUAL57=null;
        Token BITWISEXOREQUAL58=null;
        Token BITWISEOREQUAL59=null;
        CppParser.conditionalExpression_return conditionalExpression48 =null;

        CppParser.assignmentExpression_return assignmentExpression60 =null;


        Object ASSIGNEQUAL49_tree=null;
        Object TIMESEQUAL50_tree=null;
        Object DIVIDEEQUAL51_tree=null;
        Object MODEQUAL52_tree=null;
        Object PLUSEQUAL53_tree=null;
        Object MINUSEQUAL54_tree=null;
        Object SHIFTLEFTEQUAL55_tree=null;
        Object SHIFTRIGHTEQUAL56_tree=null;
        Object BITWISEANDEQUAL57_tree=null;
        Object BITWISEXOREQUAL58_tree=null;
        Object BITWISEOREQUAL59_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // Cpp.g:128:5: ( conditionalExpression ( ( ASSIGNEQUAL ^| TIMESEQUAL ^| DIVIDEEQUAL ^| MODEQUAL ^| PLUSEQUAL ^| MINUSEQUAL ^| SHIFTLEFTEQUAL ^| SHIFTRIGHTEQUAL ^| BITWISEANDEQUAL ^| BITWISEXOREQUAL ^| BITWISEOREQUAL ^) assignmentExpression )? )
            // Cpp.g:128:7: conditionalExpression ( ( ASSIGNEQUAL ^| TIMESEQUAL ^| DIVIDEEQUAL ^| MODEQUAL ^| PLUSEQUAL ^| MINUSEQUAL ^| SHIFTLEFTEQUAL ^| SHIFTRIGHTEQUAL ^| BITWISEANDEQUAL ^| BITWISEXOREQUAL ^| BITWISEOREQUAL ^) assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_conditionalExpression_in_assignmentExpression970);
            conditionalExpression48=conditionalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalExpression48.getTree());

            // Cpp.g:129:7: ( ( ASSIGNEQUAL ^| TIMESEQUAL ^| DIVIDEEQUAL ^| MODEQUAL ^| PLUSEQUAL ^| MINUSEQUAL ^| SHIFTLEFTEQUAL ^| SHIFTRIGHTEQUAL ^| BITWISEANDEQUAL ^| BITWISEXOREQUAL ^| BITWISEOREQUAL ^) assignmentExpression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0 >= ASSIGNEQUAL && LA22_0 <= BITWISEANDEQUAL)||LA22_0==BITWISEOREQUAL||LA22_0==BITWISEXOREQUAL||LA22_0==DIVIDEEQUAL||LA22_0==MINUSEQUAL||LA22_0==MODEQUAL||LA22_0==PLUSEQUAL||LA22_0==SHIFTLEFTEQUAL||LA22_0==SHIFTRIGHTEQUAL||LA22_0==TIMESEQUAL) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Cpp.g:129:9: ( ASSIGNEQUAL ^| TIMESEQUAL ^| DIVIDEEQUAL ^| MODEQUAL ^| PLUSEQUAL ^| MINUSEQUAL ^| SHIFTLEFTEQUAL ^| SHIFTRIGHTEQUAL ^| BITWISEANDEQUAL ^| BITWISEXOREQUAL ^| BITWISEOREQUAL ^) assignmentExpression
                    {
                    // Cpp.g:129:9: ( ASSIGNEQUAL ^| TIMESEQUAL ^| DIVIDEEQUAL ^| MODEQUAL ^| PLUSEQUAL ^| MINUSEQUAL ^| SHIFTLEFTEQUAL ^| SHIFTRIGHTEQUAL ^| BITWISEANDEQUAL ^| BITWISEXOREQUAL ^| BITWISEOREQUAL ^)
                    int alt21=11;
                    switch ( input.LA(1) ) {
                    case ASSIGNEQUAL:
                        {
                        alt21=1;
                        }
                        break;
                    case TIMESEQUAL:
                        {
                        alt21=2;
                        }
                        break;
                    case DIVIDEEQUAL:
                        {
                        alt21=3;
                        }
                        break;
                    case MODEQUAL:
                        {
                        alt21=4;
                        }
                        break;
                    case PLUSEQUAL:
                        {
                        alt21=5;
                        }
                        break;
                    case MINUSEQUAL:
                        {
                        alt21=6;
                        }
                        break;
                    case SHIFTLEFTEQUAL:
                        {
                        alt21=7;
                        }
                        break;
                    case SHIFTRIGHTEQUAL:
                        {
                        alt21=8;
                        }
                        break;
                    case BITWISEANDEQUAL:
                        {
                        alt21=9;
                        }
                        break;
                    case BITWISEXOREQUAL:
                        {
                        alt21=10;
                        }
                        break;
                    case BITWISEOREQUAL:
                        {
                        alt21=11;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;

                    }

                    switch (alt21) {
                        case 1 :
                            // Cpp.g:129:11: ASSIGNEQUAL ^
                            {
                            ASSIGNEQUAL49=(Token)match(input,ASSIGNEQUAL,FOLLOW_ASSIGNEQUAL_in_assignmentExpression982); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASSIGNEQUAL49_tree = 
                            (Object)adaptor.create(ASSIGNEQUAL49)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(ASSIGNEQUAL49_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // Cpp.g:130:13: TIMESEQUAL ^
                            {
                            TIMESEQUAL50=(Token)match(input,TIMESEQUAL,FOLLOW_TIMESEQUAL_in_assignmentExpression997); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            TIMESEQUAL50_tree = 
                            (Object)adaptor.create(TIMESEQUAL50)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(TIMESEQUAL50_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // Cpp.g:131:13: DIVIDEEQUAL ^
                            {
                            DIVIDEEQUAL51=(Token)match(input,DIVIDEEQUAL,FOLLOW_DIVIDEEQUAL_in_assignmentExpression1012); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DIVIDEEQUAL51_tree = 
                            (Object)adaptor.create(DIVIDEEQUAL51)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(DIVIDEEQUAL51_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // Cpp.g:132:13: MODEQUAL ^
                            {
                            MODEQUAL52=(Token)match(input,MODEQUAL,FOLLOW_MODEQUAL_in_assignmentExpression1027); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            MODEQUAL52_tree = 
                            (Object)adaptor.create(MODEQUAL52)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(MODEQUAL52_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // Cpp.g:133:13: PLUSEQUAL ^
                            {
                            PLUSEQUAL53=(Token)match(input,PLUSEQUAL,FOLLOW_PLUSEQUAL_in_assignmentExpression1042); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUSEQUAL53_tree = 
                            (Object)adaptor.create(PLUSEQUAL53)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(PLUSEQUAL53_tree, root_0);
                            }

                            }
                            break;
                        case 6 :
                            // Cpp.g:134:13: MINUSEQUAL ^
                            {
                            MINUSEQUAL54=(Token)match(input,MINUSEQUAL,FOLLOW_MINUSEQUAL_in_assignmentExpression1057); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            MINUSEQUAL54_tree = 
                            (Object)adaptor.create(MINUSEQUAL54)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(MINUSEQUAL54_tree, root_0);
                            }

                            }
                            break;
                        case 7 :
                            // Cpp.g:135:13: SHIFTLEFTEQUAL ^
                            {
                            SHIFTLEFTEQUAL55=(Token)match(input,SHIFTLEFTEQUAL,FOLLOW_SHIFTLEFTEQUAL_in_assignmentExpression1072); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            SHIFTLEFTEQUAL55_tree = 
                            (Object)adaptor.create(SHIFTLEFTEQUAL55)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(SHIFTLEFTEQUAL55_tree, root_0);
                            }

                            }
                            break;
                        case 8 :
                            // Cpp.g:136:13: SHIFTRIGHTEQUAL ^
                            {
                            SHIFTRIGHTEQUAL56=(Token)match(input,SHIFTRIGHTEQUAL,FOLLOW_SHIFTRIGHTEQUAL_in_assignmentExpression1087); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            SHIFTRIGHTEQUAL56_tree = 
                            (Object)adaptor.create(SHIFTRIGHTEQUAL56)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(SHIFTRIGHTEQUAL56_tree, root_0);
                            }

                            }
                            break;
                        case 9 :
                            // Cpp.g:137:11: BITWISEANDEQUAL ^
                            {
                            BITWISEANDEQUAL57=(Token)match(input,BITWISEANDEQUAL,FOLLOW_BITWISEANDEQUAL_in_assignmentExpression1100); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BITWISEANDEQUAL57_tree = 
                            (Object)adaptor.create(BITWISEANDEQUAL57)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(BITWISEANDEQUAL57_tree, root_0);
                            }

                            }
                            break;
                        case 10 :
                            // Cpp.g:138:11: BITWISEXOREQUAL ^
                            {
                            BITWISEXOREQUAL58=(Token)match(input,BITWISEXOREQUAL,FOLLOW_BITWISEXOREQUAL_in_assignmentExpression1113); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BITWISEXOREQUAL58_tree = 
                            (Object)adaptor.create(BITWISEXOREQUAL58)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(BITWISEXOREQUAL58_tree, root_0);
                            }

                            }
                            break;
                        case 11 :
                            // Cpp.g:139:11: BITWISEOREQUAL ^
                            {
                            BITWISEOREQUAL59=(Token)match(input,BITWISEOREQUAL,FOLLOW_BITWISEOREQUAL_in_assignmentExpression1126); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BITWISEOREQUAL59_tree = 
                            (Object)adaptor.create(BITWISEOREQUAL59)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(BITWISEOREQUAL59_tree, root_0);
                            }

                            }
                            break;

                    }


                    pushFollow(FOLLOW_assignmentExpression_in_assignmentExpression1145);
                    assignmentExpression60=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression60.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, assignmentExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assignmentExpression"


    public static class conditionalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "conditionalExpression"
    // Cpp.g:145:1: conditionalExpression : logicalOrExpression ( QUESTIONMARK ^ assignmentExpression COLON conditionalExpression )? ;
    public final CppParser.conditionalExpression_return conditionalExpression() throws RecognitionException {
        CppParser.conditionalExpression_return retval = new CppParser.conditionalExpression_return();
        retval.start = input.LT(1);

        int conditionalExpression_StartIndex = input.index();

        Object root_0 = null;

        Token QUESTIONMARK62=null;
        Token COLON64=null;
        CppParser.logicalOrExpression_return logicalOrExpression61 =null;

        CppParser.assignmentExpression_return assignmentExpression63 =null;

        CppParser.conditionalExpression_return conditionalExpression65 =null;


        Object QUESTIONMARK62_tree=null;
        Object COLON64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // Cpp.g:146:5: ( logicalOrExpression ( QUESTIONMARK ^ assignmentExpression COLON conditionalExpression )? )
            // Cpp.g:146:7: logicalOrExpression ( QUESTIONMARK ^ assignmentExpression COLON conditionalExpression )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_logicalOrExpression_in_conditionalExpression1171);
            logicalOrExpression61=logicalOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalOrExpression61.getTree());

            // Cpp.g:147:7: ( QUESTIONMARK ^ assignmentExpression COLON conditionalExpression )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==QUESTIONMARK) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Cpp.g:147:9: QUESTIONMARK ^ assignmentExpression COLON conditionalExpression
                    {
                    QUESTIONMARK62=(Token)match(input,QUESTIONMARK,FOLLOW_QUESTIONMARK_in_conditionalExpression1182); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUESTIONMARK62_tree = 
                    (Object)adaptor.create(QUESTIONMARK62)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(QUESTIONMARK62_tree, root_0);
                    }

                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression1185);
                    assignmentExpression63=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression63.getTree());

                    COLON64=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpression1187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON64_tree = 
                    (Object)adaptor.create(COLON64)
                    ;
                    adaptor.addChild(root_0, COLON64_tree);
                    }

                    pushFollow(FOLLOW_conditionalExpression_in_conditionalExpression1189);
                    conditionalExpression65=conditionalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalExpression65.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, conditionalExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "conditionalExpression"


    public static class logicalOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "logicalOrExpression"
    // Cpp.g:150:1: logicalOrExpression : logicalAndExpression ( OR ^ logicalAndExpression )* ;
    public final CppParser.logicalOrExpression_return logicalOrExpression() throws RecognitionException {
        CppParser.logicalOrExpression_return retval = new CppParser.logicalOrExpression_return();
        retval.start = input.LT(1);

        int logicalOrExpression_StartIndex = input.index();

        Object root_0 = null;

        Token OR67=null;
        CppParser.logicalAndExpression_return logicalAndExpression66 =null;

        CppParser.logicalAndExpression_return logicalAndExpression68 =null;


        Object OR67_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // Cpp.g:151:5: ( logicalAndExpression ( OR ^ logicalAndExpression )* )
            // Cpp.g:151:7: logicalAndExpression ( OR ^ logicalAndExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_logicalAndExpression_in_logicalOrExpression1209);
            logicalAndExpression66=logicalAndExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpression66.getTree());

            // Cpp.g:151:28: ( OR ^ logicalAndExpression )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==OR) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Cpp.g:151:29: OR ^ logicalAndExpression
            	    {
            	    OR67=(Token)match(input,OR,FOLLOW_OR_in_logicalOrExpression1212); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR67_tree = 
            	    (Object)adaptor.create(OR67)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(OR67_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_logicalAndExpression_in_logicalOrExpression1215);
            	    logicalAndExpression68=logicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpression68.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, logicalOrExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "logicalOrExpression"


    public static class logicalAndExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "logicalAndExpression"
    // Cpp.g:154:1: logicalAndExpression : inclusiveOrExpression ( AND ^ inclusiveOrExpression )* ;
    public final CppParser.logicalAndExpression_return logicalAndExpression() throws RecognitionException {
        CppParser.logicalAndExpression_return retval = new CppParser.logicalAndExpression_return();
        retval.start = input.LT(1);

        int logicalAndExpression_StartIndex = input.index();

        Object root_0 = null;

        Token AND70=null;
        CppParser.inclusiveOrExpression_return inclusiveOrExpression69 =null;

        CppParser.inclusiveOrExpression_return inclusiveOrExpression71 =null;


        Object AND70_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // Cpp.g:155:5: ( inclusiveOrExpression ( AND ^ inclusiveOrExpression )* )
            // Cpp.g:155:7: inclusiveOrExpression ( AND ^ inclusiveOrExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_inclusiveOrExpression_in_logicalAndExpression1234);
            inclusiveOrExpression69=inclusiveOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusiveOrExpression69.getTree());

            // Cpp.g:155:29: ( AND ^ inclusiveOrExpression )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==AND) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // Cpp.g:155:30: AND ^ inclusiveOrExpression
            	    {
            	    AND70=(Token)match(input,AND,FOLLOW_AND_in_logicalAndExpression1237); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND70_tree = 
            	    (Object)adaptor.create(AND70)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(AND70_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_inclusiveOrExpression_in_logicalAndExpression1240);
            	    inclusiveOrExpression71=inclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusiveOrExpression71.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, logicalAndExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "logicalAndExpression"


    public static class inclusiveOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inclusiveOrExpression"
    // Cpp.g:158:1: inclusiveOrExpression : exclusiveOrExpression ( BITWISEOR ^ exclusiveOrExpression )* ;
    public final CppParser.inclusiveOrExpression_return inclusiveOrExpression() throws RecognitionException {
        CppParser.inclusiveOrExpression_return retval = new CppParser.inclusiveOrExpression_return();
        retval.start = input.LT(1);

        int inclusiveOrExpression_StartIndex = input.index();

        Object root_0 = null;

        Token BITWISEOR73=null;
        CppParser.exclusiveOrExpression_return exclusiveOrExpression72 =null;

        CppParser.exclusiveOrExpression_return exclusiveOrExpression74 =null;


        Object BITWISEOR73_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // Cpp.g:159:5: ( exclusiveOrExpression ( BITWISEOR ^ exclusiveOrExpression )* )
            // Cpp.g:159:7: exclusiveOrExpression ( BITWISEOR ^ exclusiveOrExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1259);
            exclusiveOrExpression72=exclusiveOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusiveOrExpression72.getTree());

            // Cpp.g:159:29: ( BITWISEOR ^ exclusiveOrExpression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==BITWISEOR) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // Cpp.g:159:30: BITWISEOR ^ exclusiveOrExpression
            	    {
            	    BITWISEOR73=(Token)match(input,BITWISEOR,FOLLOW_BITWISEOR_in_inclusiveOrExpression1262); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    BITWISEOR73_tree = 
            	    (Object)adaptor.create(BITWISEOR73)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(BITWISEOR73_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1265);
            	    exclusiveOrExpression74=exclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusiveOrExpression74.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, inclusiveOrExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "inclusiveOrExpression"


    public static class exclusiveOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "exclusiveOrExpression"
    // Cpp.g:162:1: exclusiveOrExpression : andExpression ( BITWISEXOR ^ andExpression )* ;
    public final CppParser.exclusiveOrExpression_return exclusiveOrExpression() throws RecognitionException {
        CppParser.exclusiveOrExpression_return retval = new CppParser.exclusiveOrExpression_return();
        retval.start = input.LT(1);

        int exclusiveOrExpression_StartIndex = input.index();

        Object root_0 = null;

        Token BITWISEXOR76=null;
        CppParser.andExpression_return andExpression75 =null;

        CppParser.andExpression_return andExpression77 =null;


        Object BITWISEXOR76_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

            // Cpp.g:163:5: ( andExpression ( BITWISEXOR ^ andExpression )* )
            // Cpp.g:163:7: andExpression ( BITWISEXOR ^ andExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression1284);
            andExpression75=andExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression75.getTree());

            // Cpp.g:163:21: ( BITWISEXOR ^ andExpression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BITWISEXOR) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Cpp.g:163:22: BITWISEXOR ^ andExpression
            	    {
            	    BITWISEXOR76=(Token)match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_exclusiveOrExpression1287); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    BITWISEXOR76_tree = 
            	    (Object)adaptor.create(BITWISEXOR76)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(BITWISEXOR76_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression1290);
            	    andExpression77=andExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression77.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, exclusiveOrExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "exclusiveOrExpression"


    public static class andExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "andExpression"
    // Cpp.g:166:1: andExpression : equalityExpression ( AMPERSAND ^ equalityExpression )* ;
    public final CppParser.andExpression_return andExpression() throws RecognitionException {
        CppParser.andExpression_return retval = new CppParser.andExpression_return();
        retval.start = input.LT(1);

        int andExpression_StartIndex = input.index();

        Object root_0 = null;

        Token AMPERSAND79=null;
        CppParser.equalityExpression_return equalityExpression78 =null;

        CppParser.equalityExpression_return equalityExpression80 =null;


        Object AMPERSAND79_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

            // Cpp.g:167:5: ( equalityExpression ( AMPERSAND ^ equalityExpression )* )
            // Cpp.g:167:7: equalityExpression ( AMPERSAND ^ equalityExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_equalityExpression_in_andExpression1309);
            equalityExpression78=equalityExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpression78.getTree());

            // Cpp.g:167:26: ( AMPERSAND ^ equalityExpression )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AMPERSAND) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // Cpp.g:167:27: AMPERSAND ^ equalityExpression
            	    {
            	    AMPERSAND79=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_andExpression1312); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AMPERSAND79_tree = 
            	    (Object)adaptor.create(AMPERSAND79)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(AMPERSAND79_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_equalityExpression_in_andExpression1315);
            	    equalityExpression80=equalityExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpression80.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, andExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "andExpression"


    public static class equalityExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "equalityExpression"
    // Cpp.g:170:1: equalityExpression : relationalExpression ( ( NOTEQUAL ^| EQUAL ^) relationalExpression )* ;
    public final CppParser.equalityExpression_return equalityExpression() throws RecognitionException {
        CppParser.equalityExpression_return retval = new CppParser.equalityExpression_return();
        retval.start = input.LT(1);

        int equalityExpression_StartIndex = input.index();

        Object root_0 = null;

        Token NOTEQUAL82=null;
        Token EQUAL83=null;
        CppParser.relationalExpression_return relationalExpression81 =null;

        CppParser.relationalExpression_return relationalExpression84 =null;


        Object NOTEQUAL82_tree=null;
        Object EQUAL83_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

            // Cpp.g:171:5: ( relationalExpression ( ( NOTEQUAL ^| EQUAL ^) relationalExpression )* )
            // Cpp.g:171:7: relationalExpression ( ( NOTEQUAL ^| EQUAL ^) relationalExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_relationalExpression_in_equalityExpression1334);
            relationalExpression81=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression81.getTree());

            // Cpp.g:171:28: ( ( NOTEQUAL ^| EQUAL ^) relationalExpression )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==EQUAL||LA30_0==NOTEQUAL) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // Cpp.g:171:29: ( NOTEQUAL ^| EQUAL ^) relationalExpression
            	    {
            	    // Cpp.g:171:29: ( NOTEQUAL ^| EQUAL ^)
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==NOTEQUAL) ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0==EQUAL) ) {
            	        alt29=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // Cpp.g:171:30: NOTEQUAL ^
            	            {
            	            NOTEQUAL82=(Token)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_equalityExpression1338); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            NOTEQUAL82_tree = 
            	            (Object)adaptor.create(NOTEQUAL82)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(NOTEQUAL82_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:171:42: EQUAL ^
            	            {
            	            EQUAL83=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_equalityExpression1343); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            EQUAL83_tree = 
            	            (Object)adaptor.create(EQUAL83)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(EQUAL83_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression1347);
            	    relationalExpression84=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression84.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, equalityExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "equalityExpression"


    public static class relationalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relationalExpression"
    // Cpp.g:174:1: relationalExpression : shiftExpression ( ( ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression )* ) ;
    public final CppParser.relationalExpression_return relationalExpression() throws RecognitionException {
        CppParser.relationalExpression_return retval = new CppParser.relationalExpression_return();
        retval.start = input.LT(1);

        int relationalExpression_StartIndex = input.index();

        Object root_0 = null;

        Token LESSTHAN86=null;
        Token GREATERTHAN87=null;
        Token LESSTHANOREQUALTO88=null;
        Token GREATERTHANOREQUALTO89=null;
        CppParser.shiftExpression_return shiftExpression85 =null;

        CppParser.shiftExpression_return shiftExpression90 =null;


        Object LESSTHAN86_tree=null;
        Object GREATERTHAN87_tree=null;
        Object LESSTHANOREQUALTO88_tree=null;
        Object GREATERTHANOREQUALTO89_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

            // Cpp.g:175:5: ( shiftExpression ( ( ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression )* ) )
            // Cpp.g:175:7: shiftExpression ( ( ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression )* )
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_shiftExpression_in_relationalExpression1366);
            shiftExpression85=shiftExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, shiftExpression85.getTree());

            // Cpp.g:176:7: ( ( ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression )* )
            // Cpp.g:176:9: ( ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression )*
            {
            // Cpp.g:176:9: ( ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0 >= GREATERTHAN && LA32_0 <= GREATERTHANOREQUALTO)||(LA32_0 >= LESSTHAN && LA32_0 <= LESSTHANOREQUALTO)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Cpp.g:176:11: ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^) shiftExpression
            	    {
            	    // Cpp.g:176:11: ( LESSTHAN ^| GREATERTHAN ^| LESSTHANOREQUALTO ^| GREATERTHANOREQUALTO ^)
            	    int alt31=4;
            	    switch ( input.LA(1) ) {
            	    case LESSTHAN:
            	        {
            	        alt31=1;
            	        }
            	        break;
            	    case GREATERTHAN:
            	        {
            	        alt31=2;
            	        }
            	        break;
            	    case LESSTHANOREQUALTO:
            	        {
            	        alt31=3;
            	        }
            	        break;
            	    case GREATERTHANOREQUALTO:
            	        {
            	        alt31=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt31) {
            	        case 1 :
            	            // Cpp.g:176:13: LESSTHAN ^
            	            {
            	            LESSTHAN86=(Token)match(input,LESSTHAN,FOLLOW_LESSTHAN_in_relationalExpression1380); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESSTHAN86_tree = 
            	            (Object)adaptor.create(LESSTHAN86)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(LESSTHAN86_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:177:13: GREATERTHAN ^
            	            {
            	            GREATERTHAN87=(Token)match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_relationalExpression1395); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATERTHAN87_tree = 
            	            (Object)adaptor.create(GREATERTHAN87)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(GREATERTHAN87_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Cpp.g:178:13: LESSTHANOREQUALTO ^
            	            {
            	            LESSTHANOREQUALTO88=(Token)match(input,LESSTHANOREQUALTO,FOLLOW_LESSTHANOREQUALTO_in_relationalExpression1410); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESSTHANOREQUALTO88_tree = 
            	            (Object)adaptor.create(LESSTHANOREQUALTO88)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(LESSTHANOREQUALTO88_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Cpp.g:179:13: GREATERTHANOREQUALTO ^
            	            {
            	            GREATERTHANOREQUALTO89=(Token)match(input,GREATERTHANOREQUALTO,FOLLOW_GREATERTHANOREQUALTO_in_relationalExpression1425); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATERTHANOREQUALTO89_tree = 
            	            (Object)adaptor.create(GREATERTHANOREQUALTO89)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(GREATERTHANOREQUALTO89_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression1448);
            	    shiftExpression90=shiftExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, shiftExpression90.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, relationalExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "relationalExpression"


    public static class shiftExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "shiftExpression"
    // Cpp.g:185:1: shiftExpression : additiveExpression ( ( SHIFTLEFT ^| SHIFTRIGHT ^) additiveExpression )* ;
    public final CppParser.shiftExpression_return shiftExpression() throws RecognitionException {
        CppParser.shiftExpression_return retval = new CppParser.shiftExpression_return();
        retval.start = input.LT(1);

        int shiftExpression_StartIndex = input.index();

        Object root_0 = null;

        Token SHIFTLEFT92=null;
        Token SHIFTRIGHT93=null;
        CppParser.additiveExpression_return additiveExpression91 =null;

        CppParser.additiveExpression_return additiveExpression94 =null;


        Object SHIFTLEFT92_tree=null;
        Object SHIFTRIGHT93_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }

            // Cpp.g:186:5: ( additiveExpression ( ( SHIFTLEFT ^| SHIFTRIGHT ^) additiveExpression )* )
            // Cpp.g:186:7: additiveExpression ( ( SHIFTLEFT ^| SHIFTRIGHT ^) additiveExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_additiveExpression_in_shiftExpression1483);
            additiveExpression91=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression91.getTree());

            // Cpp.g:186:26: ( ( SHIFTLEFT ^| SHIFTRIGHT ^) additiveExpression )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==SHIFTLEFT||LA34_0==SHIFTRIGHT) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Cpp.g:186:27: ( SHIFTLEFT ^| SHIFTRIGHT ^) additiveExpression
            	    {
            	    // Cpp.g:186:27: ( SHIFTLEFT ^| SHIFTRIGHT ^)
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==SHIFTLEFT) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==SHIFTRIGHT) ) {
            	        alt33=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // Cpp.g:186:28: SHIFTLEFT ^
            	            {
            	            SHIFTLEFT92=(Token)match(input,SHIFTLEFT,FOLLOW_SHIFTLEFT_in_shiftExpression1487); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFTLEFT92_tree = 
            	            (Object)adaptor.create(SHIFTLEFT92)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(SHIFTLEFT92_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:186:41: SHIFTRIGHT ^
            	            {
            	            SHIFTRIGHT93=(Token)match(input,SHIFTRIGHT,FOLLOW_SHIFTRIGHT_in_shiftExpression1492); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFTRIGHT93_tree = 
            	            (Object)adaptor.create(SHIFTRIGHT93)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(SHIFTRIGHT93_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression1496);
            	    additiveExpression94=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression94.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, shiftExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "shiftExpression"


    public static class additiveExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "additiveExpression"
    // Cpp.g:189:1: additiveExpression : multiplicativeExpression ( ( PLUS ^| MINUS ^) multiplicativeExpression )* ;
    public final CppParser.additiveExpression_return additiveExpression() throws RecognitionException {
        CppParser.additiveExpression_return retval = new CppParser.additiveExpression_return();
        retval.start = input.LT(1);

        int additiveExpression_StartIndex = input.index();

        Object root_0 = null;

        Token PLUS96=null;
        Token MINUS97=null;
        CppParser.multiplicativeExpression_return multiplicativeExpression95 =null;

        CppParser.multiplicativeExpression_return multiplicativeExpression98 =null;


        Object PLUS96_tree=null;
        Object MINUS97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }

            // Cpp.g:190:5: ( multiplicativeExpression ( ( PLUS ^| MINUS ^) multiplicativeExpression )* )
            // Cpp.g:190:7: multiplicativeExpression ( ( PLUS ^| MINUS ^) multiplicativeExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1515);
            multiplicativeExpression95=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression95.getTree());

            // Cpp.g:190:32: ( ( PLUS ^| MINUS ^) multiplicativeExpression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==MINUS||LA36_0==PLUS) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Cpp.g:190:33: ( PLUS ^| MINUS ^) multiplicativeExpression
            	    {
            	    // Cpp.g:190:33: ( PLUS ^| MINUS ^)
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==PLUS) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==MINUS) ) {
            	        alt35=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // Cpp.g:190:34: PLUS ^
            	            {
            	            PLUS96=(Token)match(input,PLUS,FOLLOW_PLUS_in_additiveExpression1519); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS96_tree = 
            	            (Object)adaptor.create(PLUS96)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(PLUS96_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:190:42: MINUS ^
            	            {
            	            MINUS97=(Token)match(input,MINUS,FOLLOW_MINUS_in_additiveExpression1524); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS97_tree = 
            	            (Object)adaptor.create(MINUS97)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(MINUS97_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1528);
            	    multiplicativeExpression98=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression98.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, additiveExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "additiveExpression"


    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multiplicativeExpression"
    // Cpp.g:193:1: multiplicativeExpression : unaryExpression ( ( STAR ^| DIVIDE ^| MOD ^) unaryExpression )* ;
    public final CppParser.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        CppParser.multiplicativeExpression_return retval = new CppParser.multiplicativeExpression_return();
        retval.start = input.LT(1);

        int multiplicativeExpression_StartIndex = input.index();

        Object root_0 = null;

        Token STAR100=null;
        Token DIVIDE101=null;
        Token MOD102=null;
        CppParser.unaryExpression_return unaryExpression99 =null;

        CppParser.unaryExpression_return unaryExpression103 =null;


        Object STAR100_tree=null;
        Object DIVIDE101_tree=null;
        Object MOD102_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }

            // Cpp.g:194:5: ( unaryExpression ( ( STAR ^| DIVIDE ^| MOD ^) unaryExpression )* )
            // Cpp.g:194:7: unaryExpression ( ( STAR ^| DIVIDE ^| MOD ^) unaryExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1547);
            unaryExpression99=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression99.getTree());

            // Cpp.g:194:23: ( ( STAR ^| DIVIDE ^| MOD ^) unaryExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==DIVIDE||LA38_0==MOD||LA38_0==STAR) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Cpp.g:194:24: ( STAR ^| DIVIDE ^| MOD ^) unaryExpression
            	    {
            	    // Cpp.g:194:24: ( STAR ^| DIVIDE ^| MOD ^)
            	    int alt37=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case DIVIDE:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt37=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt37) {
            	        case 1 :
            	            // Cpp.g:194:25: STAR ^
            	            {
            	            STAR100=(Token)match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression1551); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            STAR100_tree = 
            	            (Object)adaptor.create(STAR100)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(STAR100_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:194:33: DIVIDE ^
            	            {
            	            DIVIDE101=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_multiplicativeExpression1556); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIVIDE101_tree = 
            	            (Object)adaptor.create(DIVIDE101)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(DIVIDE101_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Cpp.g:194:43: MOD ^
            	            {
            	            MOD102=(Token)match(input,MOD,FOLLOW_MOD_in_multiplicativeExpression1561); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD102_tree = 
            	            (Object)adaptor.create(MOD102)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(MOD102_tree, root_0);
            	            }

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1566);
            	    unaryExpression103=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression103.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, multiplicativeExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"


    public static class unaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unaryExpression"
    // Cpp.g:197:1: unaryExpression : ( PLUSPLUS unaryExpression -> ^( PLUSPLUS unaryExpression ) | MINUSMINUS unaryExpression -> ^( MINUSMINUS unaryExpression ) | SIZEOF unaryExpression -> ^( SIZEOF unaryExpression ) | SIZEOF LPAREN type_name RPAREN -> ^( SIZEOF_TYPE type_name ) | DEFINED type_name -> ^( DEFINED type_name ) | DEFINED LPAREN type_name RPAREN -> ^( DEFINED type_name ) | unaryExpressionNotPlusMinus );
    public final CppParser.unaryExpression_return unaryExpression() throws RecognitionException {
        CppParser.unaryExpression_return retval = new CppParser.unaryExpression_return();
        retval.start = input.LT(1);

        int unaryExpression_StartIndex = input.index();

        Object root_0 = null;

        Token PLUSPLUS104=null;
        Token MINUSMINUS106=null;
        Token SIZEOF108=null;
        Token SIZEOF110=null;
        Token LPAREN111=null;
        Token RPAREN113=null;
        Token DEFINED114=null;
        Token DEFINED116=null;
        Token LPAREN117=null;
        Token RPAREN119=null;
        CppParser.unaryExpression_return unaryExpression105 =null;

        CppParser.unaryExpression_return unaryExpression107 =null;

        CppParser.unaryExpression_return unaryExpression109 =null;

        CppParser.type_name_return type_name112 =null;

        CppParser.type_name_return type_name115 =null;

        CppParser.type_name_return type_name118 =null;

        CppParser.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus120 =null;


        Object PLUSPLUS104_tree=null;
        Object MINUSMINUS106_tree=null;
        Object SIZEOF108_tree=null;
        Object SIZEOF110_tree=null;
        Object LPAREN111_tree=null;
        Object RPAREN113_tree=null;
        Object DEFINED114_tree=null;
        Object DEFINED116_tree=null;
        Object LPAREN117_tree=null;
        Object RPAREN119_tree=null;
        RewriteRuleTokenStream stream_SIZEOF=new RewriteRuleTokenStream(adaptor,"token SIZEOF");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_MINUSMINUS=new RewriteRuleTokenStream(adaptor,"token MINUSMINUS");
        RewriteRuleTokenStream stream_PLUSPLUS=new RewriteRuleTokenStream(adaptor,"token PLUSPLUS");
        RewriteRuleTokenStream stream_DEFINED=new RewriteRuleTokenStream(adaptor,"token DEFINED");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_unaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpression");
        RewriteRuleSubtreeStream stream_type_name=new RewriteRuleSubtreeStream(adaptor,"rule type_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

            // Cpp.g:198:5: ( PLUSPLUS unaryExpression -> ^( PLUSPLUS unaryExpression ) | MINUSMINUS unaryExpression -> ^( MINUSMINUS unaryExpression ) | SIZEOF unaryExpression -> ^( SIZEOF unaryExpression ) | SIZEOF LPAREN type_name RPAREN -> ^( SIZEOF_TYPE type_name ) | DEFINED type_name -> ^( DEFINED type_name ) | DEFINED LPAREN type_name RPAREN -> ^( DEFINED type_name ) | unaryExpressionNotPlusMinus )
            int alt39=7;
            switch ( input.LA(1) ) {
            case PLUSPLUS:
                {
                alt39=1;
                }
                break;
            case MINUSMINUS:
                {
                alt39=2;
                }
                break;
            case SIZEOF:
                {
                int LA39_3 = input.LA(2);

                if ( (LA39_3==LPAREN) ) {
                    int LA39_6 = input.LA(3);

                    if ( (LA39_6==IDENTIFIER) ) {
                        int LA39_10 = input.LA(4);

                        if ( ((LA39_10 >= AMPERSAND && LA39_10 <= AND)||(LA39_10 >= ASSIGNEQUAL && LA39_10 <= BITWISEXOREQUAL)||(LA39_10 >= DIVIDE && LA39_10 <= DOT)||LA39_10==EQUAL||(LA39_10 >= GREATERTHAN && LA39_10 <= GREATERTHANOREQUALTO)||(LA39_10 >= LESSTHAN && LA39_10 <= LESSTHANOREQUALTO)||(LA39_10 >= LPAREN && LA39_10 <= LSQUARE)||(LA39_10 >= MINUS && LA39_10 <= MODEQUAL)||LA39_10==NOTEQUAL||LA39_10==OR||(LA39_10 >= PLUS && LA39_10 <= PLUSPLUS)||LA39_10==POINTERTO||LA39_10==QUESTIONMARK||(LA39_10 >= SHIFTLEFT && LA39_10 <= SHIFTRIGHTEQUAL)||LA39_10==STAR||LA39_10==TIMESEQUAL) ) {
                            alt39=3;
                        }
                        else if ( (LA39_10==RPAREN) ) {
                            int LA39_11 = input.LA(5);

                            if ( (synpred64_Cpp()) ) {
                                alt39=3;
                            }
                            else if ( (synpred65_Cpp()) ) {
                                alt39=4;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 39, 11, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 39, 10, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA39_6==AMPERSAND||LA39_6==CHARACTER_LITERAL||LA39_6==DECIMAL_LITERAL||LA39_6==DEFINED||LA39_6==FLOATING_POINT_LITERAL||LA39_6==HEX_LITERAL||LA39_6==LPAREN||LA39_6==MINUS||LA39_6==MINUSMINUS||LA39_6==NOT||LA39_6==OCTAL_LITERAL||LA39_6==PLUS||LA39_6==PLUSPLUS||LA39_6==SIZEOF||LA39_6==STAR||LA39_6==STRING_LITERAL||LA39_6==TILDE) ) {
                        alt39=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 6, input);

                        throw nvae;

                    }
                }
                else if ( (LA39_3==AMPERSAND||LA39_3==CHARACTER_LITERAL||LA39_3==DECIMAL_LITERAL||LA39_3==DEFINED||LA39_3==FLOATING_POINT_LITERAL||LA39_3==HEX_LITERAL||LA39_3==IDENTIFIER||LA39_3==MINUS||LA39_3==MINUSMINUS||LA39_3==NOT||LA39_3==OCTAL_LITERAL||LA39_3==PLUS||LA39_3==PLUSPLUS||LA39_3==SIZEOF||LA39_3==STAR||LA39_3==STRING_LITERAL||LA39_3==TILDE) ) {
                    alt39=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 3, input);

                    throw nvae;

                }
                }
                break;
            case DEFINED:
                {
                int LA39_4 = input.LA(2);

                if ( (LA39_4==LPAREN) ) {
                    alt39=6;
                }
                else if ( (LA39_4==IDENTIFIER) ) {
                    alt39=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 4, input);

                    throw nvae;

                }
                }
                break;
            case AMPERSAND:
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case LPAREN:
            case MINUS:
            case NOT:
            case OCTAL_LITERAL:
            case PLUS:
            case STAR:
            case STRING_LITERAL:
            case TILDE:
                {
                alt39=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // Cpp.g:198:7: PLUSPLUS unaryExpression
                    {
                    PLUSPLUS104=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unaryExpression1585); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUSPLUS.add(PLUSPLUS104);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1588);
                    unaryExpression105=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression105.getTree());

                    // AST REWRITE
                    // elements: unaryExpression, PLUSPLUS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 198:33: -> ^( PLUSPLUS unaryExpression )
                    {
                        // Cpp.g:198:36: ^( PLUSPLUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_PLUSPLUS.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:199:7: MINUSMINUS unaryExpression
                    {
                    MINUSMINUS106=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_unaryExpression1604); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUSMINUS.add(MINUSMINUS106);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1607);
                    unaryExpression107=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression107.getTree());

                    // AST REWRITE
                    // elements: unaryExpression, MINUSMINUS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 199:35: -> ^( MINUSMINUS unaryExpression )
                    {
                        // Cpp.g:199:38: ^( MINUSMINUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_MINUSMINUS.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:200:7: SIZEOF unaryExpression
                    {
                    SIZEOF108=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_unaryExpression1623); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SIZEOF.add(SIZEOF108);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1626);
                    unaryExpression109=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression109.getTree());

                    // AST REWRITE
                    // elements: unaryExpression, SIZEOF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 200:31: -> ^( SIZEOF unaryExpression )
                    {
                        // Cpp.g:200:34: ^( SIZEOF unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_SIZEOF.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // Cpp.g:201:7: SIZEOF LPAREN type_name RPAREN
                    {
                    SIZEOF110=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_unaryExpression1642); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SIZEOF.add(SIZEOF110);


                    LPAREN111=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpression1645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN111);


                    pushFollow(FOLLOW_type_name_in_unaryExpression1647);
                    type_name112=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name112.getTree());

                    RPAREN113=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpression1649); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN113);


                    // AST REWRITE
                    // elements: type_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 201:39: -> ^( SIZEOF_TYPE type_name )
                    {
                        // Cpp.g:201:43: ^( SIZEOF_TYPE type_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(SIZEOF_TYPE, "SIZEOF_TYPE")
                        , root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // Cpp.g:202:7: DEFINED type_name
                    {
                    DEFINED114=(Token)match(input,DEFINED,FOLLOW_DEFINED_in_unaryExpression1666); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEFINED.add(DEFINED114);


                    pushFollow(FOLLOW_type_name_in_unaryExpression1668);
                    type_name115=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name115.getTree());

                    // AST REWRITE
                    // elements: type_name, DEFINED
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 202:29: -> ^( DEFINED type_name )
                    {
                        // Cpp.g:202:32: ^( DEFINED type_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_DEFINED.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // Cpp.g:203:7: DEFINED LPAREN type_name RPAREN
                    {
                    DEFINED116=(Token)match(input,DEFINED,FOLLOW_DEFINED_in_unaryExpression1688); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEFINED.add(DEFINED116);


                    LPAREN117=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpression1690); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN117);


                    pushFollow(FOLLOW_type_name_in_unaryExpression1692);
                    type_name118=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name118.getTree());

                    RPAREN119=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpression1695); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN119);


                    // AST REWRITE
                    // elements: DEFINED, type_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 203:41: -> ^( DEFINED type_name )
                    {
                        // Cpp.g:203:43: ^( DEFINED type_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_DEFINED.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // Cpp.g:204:7: unaryExpressionNotPlusMinus
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression1711);
                    unaryExpressionNotPlusMinus120=unaryExpressionNotPlusMinus();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpressionNotPlusMinus120.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, unaryExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unaryExpression"


    public static class unaryExpressionNotPlusMinus_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unaryExpressionNotPlusMinus"
    // Cpp.g:207:1: unaryExpressionNotPlusMinus : ( NOT unaryExpression -> ^( NOT unaryExpression ) | TILDE unaryExpression -> ^( TILDE unaryExpression ) | AMPERSAND unaryExpression -> ^( REFERANCE unaryExpression ) | STAR unaryExpression -> ^( POINTER_AT unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS unaryExpression ) | PLUS unaryExpression -> ^( UNARY_PLUS unaryExpression ) | LPAREN type_name RPAREN unaryExpression -> ^( TYPECAST type_name unaryExpression ) | postfixExpression );
    public final CppParser.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus() throws RecognitionException {
        CppParser.unaryExpressionNotPlusMinus_return retval = new CppParser.unaryExpressionNotPlusMinus_return();
        retval.start = input.LT(1);

        int unaryExpressionNotPlusMinus_StartIndex = input.index();

        Object root_0 = null;

        Token NOT121=null;
        Token TILDE123=null;
        Token AMPERSAND125=null;
        Token STAR127=null;
        Token MINUS129=null;
        Token PLUS131=null;
        Token LPAREN133=null;
        Token RPAREN135=null;
        CppParser.unaryExpression_return unaryExpression122 =null;

        CppParser.unaryExpression_return unaryExpression124 =null;

        CppParser.unaryExpression_return unaryExpression126 =null;

        CppParser.unaryExpression_return unaryExpression128 =null;

        CppParser.unaryExpression_return unaryExpression130 =null;

        CppParser.unaryExpression_return unaryExpression132 =null;

        CppParser.type_name_return type_name134 =null;

        CppParser.unaryExpression_return unaryExpression136 =null;

        CppParser.postfixExpression_return postfixExpression137 =null;


        Object NOT121_tree=null;
        Object TILDE123_tree=null;
        Object AMPERSAND125_tree=null;
        Object STAR127_tree=null;
        Object MINUS129_tree=null;
        Object PLUS131_tree=null;
        Object LPAREN133_tree=null;
        Object RPAREN135_tree=null;
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_TILDE=new RewriteRuleTokenStream(adaptor,"token TILDE");
        RewriteRuleSubtreeStream stream_unaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpression");
        RewriteRuleSubtreeStream stream_type_name=new RewriteRuleSubtreeStream(adaptor,"rule type_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }

            // Cpp.g:208:5: ( NOT unaryExpression -> ^( NOT unaryExpression ) | TILDE unaryExpression -> ^( TILDE unaryExpression ) | AMPERSAND unaryExpression -> ^( REFERANCE unaryExpression ) | STAR unaryExpression -> ^( POINTER_AT unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS unaryExpression ) | PLUS unaryExpression -> ^( UNARY_PLUS unaryExpression ) | LPAREN type_name RPAREN unaryExpression -> ^( TYPECAST type_name unaryExpression ) | postfixExpression )
            int alt40=8;
            switch ( input.LA(1) ) {
            case NOT:
                {
                alt40=1;
                }
                break;
            case TILDE:
                {
                alt40=2;
                }
                break;
            case AMPERSAND:
                {
                alt40=3;
                }
                break;
            case STAR:
                {
                alt40=4;
                }
                break;
            case MINUS:
                {
                alt40=5;
                }
                break;
            case PLUS:
                {
                alt40=6;
                }
                break;
            case LPAREN:
                {
                int LA40_7 = input.LA(2);

                if ( (synpred74_Cpp()) ) {
                    alt40=7;
                }
                else if ( (true) ) {
                    alt40=8;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 7, input);

                    throw nvae;

                }
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt40=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // Cpp.g:208:7: NOT unaryExpression
                    {
                    NOT121=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpressionNotPlusMinus1728); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT121);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1734);
                    unaryExpression122=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression122.getTree());

                    // AST REWRITE
                    // elements: unaryExpression, NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 208:31: -> ^( NOT unaryExpression )
                    {
                        // Cpp.g:208:35: ^( NOT unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_NOT.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:209:7: TILDE unaryExpression
                    {
                    TILDE123=(Token)match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1751); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TILDE.add(TILDE123);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1755);
                    unaryExpression124=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression124.getTree());

                    // AST REWRITE
                    // elements: TILDE, unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 209:31: -> ^( TILDE unaryExpression )
                    {
                        // Cpp.g:209:35: ^( TILDE unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_TILDE.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:210:7: AMPERSAND unaryExpression
                    {
                    AMPERSAND125=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_unaryExpressionNotPlusMinus1774); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND125);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1776);
                    unaryExpression126=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression126.getTree());

                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 210:33: -> ^( REFERANCE unaryExpression )
                    {
                        // Cpp.g:210:37: ^( REFERANCE unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(REFERANCE, "REFERANCE")
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // Cpp.g:211:7: STAR unaryExpression
                    {
                    STAR127=(Token)match(input,STAR,FOLLOW_STAR_in_unaryExpressionNotPlusMinus1793); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(STAR127);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1798);
                    unaryExpression128=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression128.getTree());

                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 211:31: -> ^( POINTER_AT unaryExpression )
                    {
                        // Cpp.g:211:35: ^( POINTER_AT unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(POINTER_AT, "POINTER_AT")
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // Cpp.g:212:7: MINUS unaryExpression
                    {
                    MINUS129=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpressionNotPlusMinus1816); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS129);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1819);
                    unaryExpression130=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression130.getTree());

                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 212:31: -> ^( UNARY_MINUS unaryExpression )
                    {
                        // Cpp.g:212:34: ^( UNARY_MINUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS")
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // Cpp.g:213:7: PLUS unaryExpression
                    {
                    PLUS131=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpressionNotPlusMinus1836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS131);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1840);
                    unaryExpression132=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression132.getTree());

                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 213:31: -> ^( UNARY_PLUS unaryExpression )
                    {
                        // Cpp.g:213:34: ^( UNARY_PLUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(UNARY_PLUS, "UNARY_PLUS")
                        , root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // Cpp.g:214:7: LPAREN type_name RPAREN unaryExpression
                    {
                    LPAREN133=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpressionNotPlusMinus1857); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN133);


                    pushFollow(FOLLOW_type_name_in_unaryExpressionNotPlusMinus1859);
                    type_name134=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name134.getTree());

                    RPAREN135=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpressionNotPlusMinus1861); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN135);


                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1864);
                    unaryExpression136=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression136.getTree());

                    // AST REWRITE
                    // elements: type_name, unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 214:48: -> ^( TYPECAST type_name unaryExpression )
                    {
                        // Cpp.g:214:51: ^( TYPECAST type_name unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(TYPECAST, "TYPECAST")
                        , root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 8 :
                    // Cpp.g:215:7: postfixExpression
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_postfixExpression_in_unaryExpressionNotPlusMinus1882);
                    postfixExpression137=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression137.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, unaryExpressionNotPlusMinus_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unaryExpressionNotPlusMinus"


    public static class postfixExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "postfixExpression"
    // Cpp.g:218:1: postfixExpression : primaryExpression (l= LSQUARE ^ assignmentExpression RSQUARE !| DOT ^ IDENTIFIER |s= STAR ^ IDENTIFIER |s= BITWISEXOR ^ IDENTIFIER | POINTERTO ^ IDENTIFIER |p= PLUSPLUS ^|m= MINUSMINUS ^)* ;
    public final CppParser.postfixExpression_return postfixExpression() throws RecognitionException {
        CppParser.postfixExpression_return retval = new CppParser.postfixExpression_return();
        retval.start = input.LT(1);

        int postfixExpression_StartIndex = input.index();

        Object root_0 = null;

        Token l=null;
        Token s=null;
        Token p=null;
        Token m=null;
        Token RSQUARE140=null;
        Token DOT141=null;
        Token IDENTIFIER142=null;
        Token IDENTIFIER143=null;
        Token IDENTIFIER144=null;
        Token POINTERTO145=null;
        Token IDENTIFIER146=null;
        CppParser.primaryExpression_return primaryExpression138 =null;

        CppParser.assignmentExpression_return assignmentExpression139 =null;


        Object l_tree=null;
        Object s_tree=null;
        Object p_tree=null;
        Object m_tree=null;
        Object RSQUARE140_tree=null;
        Object DOT141_tree=null;
        Object IDENTIFIER142_tree=null;
        Object IDENTIFIER143_tree=null;
        Object IDENTIFIER144_tree=null;
        Object POINTERTO145_tree=null;
        Object IDENTIFIER146_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }

            // Cpp.g:219:5: ( primaryExpression (l= LSQUARE ^ assignmentExpression RSQUARE !| DOT ^ IDENTIFIER |s= STAR ^ IDENTIFIER |s= BITWISEXOR ^ IDENTIFIER | POINTERTO ^ IDENTIFIER |p= PLUSPLUS ^|m= MINUSMINUS ^)* )
            // Cpp.g:219:9: primaryExpression (l= LSQUARE ^ assignmentExpression RSQUARE !| DOT ^ IDENTIFIER |s= STAR ^ IDENTIFIER |s= BITWISEXOR ^ IDENTIFIER | POINTERTO ^ IDENTIFIER |p= PLUSPLUS ^|m= MINUSMINUS ^)*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_primaryExpression_in_postfixExpression1901);
            primaryExpression138=primaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primaryExpression138.getTree());

            // Cpp.g:220:5: (l= LSQUARE ^ assignmentExpression RSQUARE !| DOT ^ IDENTIFIER |s= STAR ^ IDENTIFIER |s= BITWISEXOR ^ IDENTIFIER | POINTERTO ^ IDENTIFIER |p= PLUSPLUS ^|m= MINUSMINUS ^)*
            loop41:
            do {
                int alt41=8;
                switch ( input.LA(1) ) {
                case STAR:
                    {
                    int LA41_1 = input.LA(2);

                    if ( (LA41_1==IDENTIFIER) ) {
                        int LA41_9 = input.LA(3);

                        if ( (synpred77_Cpp()) ) {
                            alt41=3;
                        }


                    }


                    }
                    break;
                case BITWISEXOR:
                    {
                    int LA41_3 = input.LA(2);

                    if ( (LA41_3==IDENTIFIER) ) {
                        int LA41_10 = input.LA(3);

                        if ( (synpred78_Cpp()) ) {
                            alt41=4;
                        }


                    }


                    }
                    break;
                case LSQUARE:
                    {
                    alt41=1;
                    }
                    break;
                case DOT:
                    {
                    alt41=2;
                    }
                    break;
                case POINTERTO:
                    {
                    alt41=5;
                    }
                    break;
                case PLUSPLUS:
                    {
                    alt41=6;
                    }
                    break;
                case MINUSMINUS:
                    {
                    alt41=7;
                    }
                    break;

                }

                switch (alt41) {
            	case 1 :
            	    // Cpp.g:220:9: l= LSQUARE ^ assignmentExpression RSQUARE !
            	    {
            	    l=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_postfixExpression1913); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    l_tree = 
            	    (Object)adaptor.create(l)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(l_tree, root_0);
            	    }

            	    if ( state.backtracking==0 ) {l.setType(INDEX_OP);}

            	    pushFollow(FOLLOW_assignmentExpression_in_postfixExpression1919);
            	    assignmentExpression139=assignmentExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression139.getTree());

            	    RSQUARE140=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_postfixExpression1921); if (state.failed) return retval;

            	    }
            	    break;
            	case 2 :
            	    // Cpp.g:221:9: DOT ^ IDENTIFIER
            	    {
            	    DOT141=(Token)match(input,DOT,FOLLOW_DOT_in_postfixExpression1932); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DOT141_tree = 
            	    (Object)adaptor.create(DOT141)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(DOT141_tree, root_0);
            	    }

            	    IDENTIFIER142=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression1940); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER142_tree = 
            	    (Object)adaptor.create(IDENTIFIER142)
            	    ;
            	    adaptor.addChild(root_0, IDENTIFIER142_tree);
            	    }

            	    }
            	    break;
            	case 3 :
            	    // Cpp.g:222:7: s= STAR ^ IDENTIFIER
            	    {
            	    s=(Token)match(input,STAR,FOLLOW_STAR_in_postfixExpression1957); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    s_tree = 
            	    (Object)adaptor.create(s)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(s_tree, root_0);
            	    }

            	    if ( state.backtracking==0 ) {s.setType(POINTER);}

            	    IDENTIFIER143=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression1962); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER143_tree = 
            	    (Object)adaptor.create(IDENTIFIER143)
            	    ;
            	    adaptor.addChild(root_0, IDENTIFIER143_tree);
            	    }

            	    }
            	    break;
            	case 4 :
            	    // Cpp.g:223:21: s= BITWISEXOR ^ IDENTIFIER
            	    {
            	    s=(Token)match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_postfixExpression1986); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    s_tree = 
            	    (Object)adaptor.create(s)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(s_tree, root_0);
            	    }

            	    if ( state.backtracking==0 ) {s.setType(POINTER);}

            	    IDENTIFIER144=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression1991); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER144_tree = 
            	    (Object)adaptor.create(IDENTIFIER144)
            	    ;
            	    adaptor.addChild(root_0, IDENTIFIER144_tree);
            	    }

            	    }
            	    break;
            	case 5 :
            	    // Cpp.g:224:9: POINTERTO ^ IDENTIFIER
            	    {
            	    POINTERTO145=(Token)match(input,POINTERTO,FOLLOW_POINTERTO_in_postfixExpression2003); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POINTERTO145_tree = 
            	    (Object)adaptor.create(POINTERTO145)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(POINTERTO145_tree, root_0);
            	    }

            	    IDENTIFIER146=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression2006); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER146_tree = 
            	    (Object)adaptor.create(IDENTIFIER146)
            	    ;
            	    adaptor.addChild(root_0, IDENTIFIER146_tree);
            	    }

            	    }
            	    break;
            	case 6 :
            	    // Cpp.g:225:9: p= PLUSPLUS ^
            	    {
            	    p=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_postfixExpression2018); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    p_tree = 
            	    (Object)adaptor.create(p)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(p_tree, root_0);
            	    }

            	    if ( state.backtracking==0 ) {p.setType(POST_INC);}

            	    }
            	    break;
            	case 7 :
            	    // Cpp.g:226:9: m= MINUSMINUS ^
            	    {
            	    m=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_postfixExpression2036); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    m_tree = 
            	    (Object)adaptor.create(m)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(m_tree, root_0);
            	    }

            	    if ( state.backtracking==0 ) {m.setType(POST_DEC);}

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, postfixExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "postfixExpression"


    public static class primaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "primaryExpression"
    // Cpp.g:230:1: primaryExpression : ( ( IDENTIFIER LPAREN )=> functionCall | IDENTIFIER | constant | LPAREN assignmentExpression RPAREN -> ^( EXPR_GROUP assignmentExpression ) );
    public final CppParser.primaryExpression_return primaryExpression() throws RecognitionException {
        CppParser.primaryExpression_return retval = new CppParser.primaryExpression_return();
        retval.start = input.LT(1);

        int primaryExpression_StartIndex = input.index();

        Object root_0 = null;

        Token IDENTIFIER148=null;
        Token LPAREN150=null;
        Token RPAREN152=null;
        CppParser.functionCall_return functionCall147 =null;

        CppParser.constant_return constant149 =null;

        CppParser.assignmentExpression_return assignmentExpression151 =null;


        Object IDENTIFIER148_tree=null;
        Object LPAREN150_tree=null;
        Object RPAREN152_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }

            // Cpp.g:231:5: ( ( IDENTIFIER LPAREN )=> functionCall | IDENTIFIER | constant | LPAREN assignmentExpression RPAREN -> ^( EXPR_GROUP assignmentExpression ) )
            int alt42=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==LPAREN) && (synpred82_Cpp())) {
                    alt42=1;
                }
                else if ( (LA42_1==EOF||(LA42_1 >= AMPERSAND && LA42_1 <= AND)||(LA42_1 >= ASSIGNEQUAL && LA42_1 <= BITWISEXOREQUAL)||(LA42_1 >= COLON && LA42_1 <= COMMA)||(LA42_1 >= DIVIDE && LA42_1 <= DOT)||LA42_1==EQUAL||LA42_1==End||(LA42_1 >= GREATERTHAN && LA42_1 <= GREATERTHANOREQUALTO)||(LA42_1 >= LESSTHAN && LA42_1 <= LESSTHANOREQUALTO)||LA42_1==LSQUARE||(LA42_1 >= MINUS && LA42_1 <= MODEQUAL)||LA42_1==NOTEQUAL||LA42_1==OR||(LA42_1 >= PLUS && LA42_1 <= PLUSPLUS)||LA42_1==POINTERTO||LA42_1==QUESTIONMARK||(LA42_1 >= RPAREN && LA42_1 <= RSQUARE)||(LA42_1 >= SHIFTLEFT && LA42_1 <= SHIFTRIGHTEQUAL)||LA42_1==STAR||LA42_1==TIMESEQUAL) ) {
                    alt42=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;

                }
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt42=3;
                }
                break;
            case LPAREN:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // Cpp.g:231:9: ( IDENTIFIER LPAREN )=> functionCall
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionCall_in_primaryExpression2076);
                    functionCall147=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall147.getTree());

                    }
                    break;
                case 2 :
                    // Cpp.g:232:9: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();


                    IDENTIFIER148=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primaryExpression2086); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER148_tree = 
                    (Object)adaptor.create(IDENTIFIER148)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER148_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:233:9: constant
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_constant_in_primaryExpression2102);
                    constant149=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant149.getTree());

                    }
                    break;
                case 4 :
                    // Cpp.g:234:9: LPAREN assignmentExpression RPAREN
                    {
                    LPAREN150=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression2117); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN150);


                    pushFollow(FOLLOW_assignmentExpression_in_primaryExpression2120);
                    assignmentExpression151=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression151.getTree());

                    RPAREN152=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression2122); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN152);


                    // AST REWRITE
                    // elements: assignmentExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 234:46: -> ^( EXPR_GROUP assignmentExpression )
                    {
                        // Cpp.g:234:49: ^( EXPR_GROUP assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXPR_GROUP, "EXPR_GROUP")
                        , root_1);

                        adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, primaryExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "primaryExpression"


    public static class functionCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCall"
    // Cpp.g:237:1: functionCall : id= IDENTIFIER LPAREN ( argList )? RPAREN -> ^( METHOD_CALL $id ( argList )? ) ;
    public final CppParser.functionCall_return functionCall() throws RecognitionException {
        CppParser.functionCall_return retval = new CppParser.functionCall_return();
        retval.start = input.LT(1);

        int functionCall_StartIndex = input.index();

        Object root_0 = null;

        Token id=null;
        Token LPAREN153=null;
        Token RPAREN155=null;
        CppParser.argList_return argList154 =null;


        Object id_tree=null;
        Object LPAREN153_tree=null;
        Object RPAREN155_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_argList=new RewriteRuleSubtreeStream(adaptor,"rule argList");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }

            // Cpp.g:238:5: (id= IDENTIFIER LPAREN ( argList )? RPAREN -> ^( METHOD_CALL $id ( argList )? ) )
            // Cpp.g:238:7: id= IDENTIFIER LPAREN ( argList )? RPAREN
            {
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall2153); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


            LPAREN153=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionCall2155); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN153);


            // Cpp.g:238:28: ( argList )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==AMPERSAND||LA43_0==CHARACTER_LITERAL||LA43_0==DECIMAL_LITERAL||LA43_0==DEFINED||LA43_0==FLOATING_POINT_LITERAL||LA43_0==HEX_LITERAL||LA43_0==IDENTIFIER||LA43_0==LPAREN||LA43_0==MINUS||LA43_0==MINUSMINUS||LA43_0==NOT||LA43_0==OCTAL_LITERAL||LA43_0==PLUS||LA43_0==PLUSPLUS||LA43_0==SIZEOF||LA43_0==STAR||LA43_0==STRING_LITERAL||LA43_0==TILDE) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // Cpp.g:238:28: argList
                    {
                    pushFollow(FOLLOW_argList_in_functionCall2157);
                    argList154=argList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argList.add(argList154.getTree());

                    }
                    break;

            }


            RPAREN155=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionCall2160); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN155);


            // AST REWRITE
            // elements: id, argList
            // token labels: id
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 238:46: -> ^( METHOD_CALL $id ( argList )? )
            {
                // Cpp.g:238:49: ^( METHOD_CALL $id ( argList )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(METHOD_CALL, "METHOD_CALL")
                , root_1);

                adaptor.addChild(root_1, stream_id.nextNode());

                // Cpp.g:238:67: ( argList )?
                if ( stream_argList.hasNext() ) {
                    adaptor.addChild(root_1, stream_argList.nextTree());

                }
                stream_argList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, functionCall_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "functionCall"


    public static class argList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "argList"
    // Cpp.g:241:1: argList : assignmentExpression ( COMMA assignmentExpression )* -> ^( ARGS ( assignmentExpression )+ ) ;
    public final CppParser.argList_return argList() throws RecognitionException {
        CppParser.argList_return retval = new CppParser.argList_return();
        retval.start = input.LT(1);

        int argList_StartIndex = input.index();

        Object root_0 = null;

        Token COMMA157=null;
        CppParser.assignmentExpression_return assignmentExpression156 =null;

        CppParser.assignmentExpression_return assignmentExpression158 =null;


        Object COMMA157_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }

            // Cpp.g:242:5: ( assignmentExpression ( COMMA assignmentExpression )* -> ^( ARGS ( assignmentExpression )+ ) )
            // Cpp.g:242:7: assignmentExpression ( COMMA assignmentExpression )*
            {
            pushFollow(FOLLOW_assignmentExpression_in_argList2191);
            assignmentExpression156=assignmentExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression156.getTree());

            // Cpp.g:242:28: ( COMMA assignmentExpression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==COMMA) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // Cpp.g:242:29: COMMA assignmentExpression
            	    {
            	    COMMA157=(Token)match(input,COMMA,FOLLOW_COMMA_in_argList2194); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA157);


            	    pushFollow(FOLLOW_assignmentExpression_in_argList2196);
            	    assignmentExpression158=assignmentExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression158.getTree());

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            // AST REWRITE
            // elements: assignmentExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 242:58: -> ^( ARGS ( assignmentExpression )+ )
            {
                // Cpp.g:242:61: ^( ARGS ( assignmentExpression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGS, "ARGS")
                , root_1);

                if ( !(stream_assignmentExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_assignmentExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                }
                stream_assignmentExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, argList_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "argList"


    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constant"
    // Cpp.g:245:1: constant : ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL );
    public final CppParser.constant_return constant() throws RecognitionException {
        CppParser.constant_return retval = new CppParser.constant_return();
        retval.start = input.LT(1);

        int constant_StartIndex = input.index();

        Object root_0 = null;

        Token set159=null;

        Object set159_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

            // Cpp.g:246:5: ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL )
            // Cpp.g:
            {
            root_0 = (Object)adaptor.nil();


            set159=(Token)input.LT(1);

            if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||input.LA(1)==FLOATING_POINT_LITERAL||input.LA(1)==HEX_LITERAL||input.LA(1)==OCTAL_LITERAL||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set159)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, constant_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "constant"


    public static class source_text_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "source_text"
    // Cpp.g:256:1: source_text : ( sourceExpression | COMMA | LPAREN | RPAREN | WS );
    public final CppParser.source_text_return source_text() throws RecognitionException {
        CppParser.source_text_return retval = new CppParser.source_text_return();
        retval.start = input.LT(1);

        int source_text_StartIndex = input.index();

        Object root_0 = null;

        Token COMMA161=null;
        Token LPAREN162=null;
        Token RPAREN163=null;
        Token WS164=null;
        CppParser.sourceExpression_return sourceExpression160 =null;


        Object COMMA161_tree=null;
        Object LPAREN162_tree=null;
        Object RPAREN163_tree=null;
        Object WS164_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }

            // Cpp.g:257:5: ( sourceExpression | COMMA | LPAREN | RPAREN | WS )
            int alt45=5;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case CKEYWORD:
            case COPERATOR:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case LINECOMMENTS:
            case OCTAL_LITERAL:
            case SEMICOLON:
            case SHARPSHARP:
            case SIZEOF:
            case STRINGIFICATION:
            case STRING_LITERAL:
            case STRING_OP:
            case TEXT_END:
                {
                alt45=1;
                }
                break;
            case LPAREN:
                {
                int LA45_9 = input.LA(2);

                if ( (synpred92_Cpp()) ) {
                    alt45=1;
                }
                else if ( (synpred94_Cpp()) ) {
                    alt45=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 9, input);

                    throw nvae;

                }
                }
                break;
            case WS:
                {
                int LA45_13 = input.LA(2);

                if ( (synpred92_Cpp()) ) {
                    alt45=1;
                }
                else if ( (true) ) {
                    alt45=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 13, input);

                    throw nvae;

                }
                }
                break;
            case COMMA:
                {
                alt45=2;
                }
                break;
            case RPAREN:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // Cpp.g:257:9: sourceExpression
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sourceExpression_in_source_text2298);
                    sourceExpression160=sourceExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sourceExpression160.getTree());

                    }
                    break;
                case 2 :
                    // Cpp.g:258:7: COMMA
                    {
                    root_0 = (Object)adaptor.nil();


                    COMMA161=(Token)match(input,COMMA,FOLLOW_COMMA_in_source_text2306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA161_tree = 
                    (Object)adaptor.create(COMMA161)
                    ;
                    adaptor.addChild(root_0, COMMA161_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:259:7: LPAREN
                    {
                    root_0 = (Object)adaptor.nil();


                    LPAREN162=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_source_text2314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN162_tree = 
                    (Object)adaptor.create(LPAREN162)
                    ;
                    adaptor.addChild(root_0, LPAREN162_tree);
                    }

                    }
                    break;
                case 4 :
                    // Cpp.g:260:7: RPAREN
                    {
                    root_0 = (Object)adaptor.nil();


                    RPAREN163=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_source_text2322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN163_tree = 
                    (Object)adaptor.create(RPAREN163)
                    ;
                    adaptor.addChild(root_0, RPAREN163_tree);
                    }

                    }
                    break;
                case 5 :
                    // Cpp.g:261:7: WS
                    {
                    root_0 = (Object)adaptor.nil();


                    WS164=(Token)match(input,WS,FOLLOW_WS_in_source_text2330); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WS164_tree = 
                    (Object)adaptor.create(WS164)
                    ;
                    adaptor.addChild(root_0, WS164_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, source_text_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "source_text"


    public static class macroExpansion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroExpansion"
    // Cpp.g:264:1: macroExpansion : (id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN -> ^( EXPAND $id) |id= IDENTIFIER ( WS )? LPAREN ( WS )? macArgs ( WS )? RPAREN -> ^( EXPAND $id ( macArgs )? ) );
    public final CppParser.macroExpansion_return macroExpansion() throws RecognitionException {
        CppParser.macroExpansion_return retval = new CppParser.macroExpansion_return();
        retval.start = input.LT(1);
        int macroExpansion_StartIndex = input.index();

        Object root_0 = null;

        Token id=null;
        Token WS165=null;
        Token LPAREN166=null;
        Token WS167=null;
        Token RPAREN168=null;
        Token WS169=null;
        Token LPAREN170=null;
        Token WS171=null;
        Token WS173=null;
        Token RPAREN174=null;
        CppParser.macArgs_return macArgs172 =null;


        Object id_tree=null;
        Object WS165_tree=null;
        Object LPAREN166_tree=null;
        Object WS167_tree=null;
        Object RPAREN168_tree=null;
        Object WS169_tree=null;
        Object LPAREN170_tree=null;
        Object WS171_tree=null;
        Object WS173_tree=null;
        Object RPAREN174_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_macArgs=new RewriteRuleSubtreeStream(adaptor,"rule macArgs");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }

            // Cpp.g:265:5: (id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN -> ^( EXPAND $id) |id= IDENTIFIER ( WS )? LPAREN ( WS )? macArgs ( WS )? RPAREN -> ^( EXPAND $id ( macArgs )? ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==IDENTIFIER) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==WS) ) {
                    int LA51_2 = input.LA(3);

                    if ( (LA51_2==LPAREN) ) {
                        switch ( input.LA(4) ) {
                        case WS:
                            {
                            int LA51_4 = input.LA(5);

                            if ( (LA51_4==RPAREN) ) {
                                int LA51_7 = input.LA(6);

                                if ( (synpred98_Cpp()) ) {
                                    alt51=1;
                                }
                                else if ( (true) ) {
                                    alt51=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 51, 7, input);

                                    throw nvae;

                                }
                            }
                            else if ( ((LA51_4 >= CHARACTER_LITERAL && LA51_4 <= CKEYWORD)||LA51_4==COMMA||(LA51_4 >= COPERATOR && LA51_4 <= DECIMAL_LITERAL)||LA51_4==FLOATING_POINT_LITERAL||LA51_4==HEX_LITERAL||LA51_4==IDENTIFIER||LA51_4==LINECOMMENTS||LA51_4==LPAREN||LA51_4==OCTAL_LITERAL||(LA51_4 >= SEMICOLON && LA51_4 <= SHARPSHARP)||LA51_4==SIZEOF||(LA51_4 >= STRINGIFICATION && LA51_4 <= TEXT_END)||LA51_4==WS) ) {
                                alt51=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 51, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case RPAREN:
                            {
                            int LA51_5 = input.LA(5);

                            if ( (synpred98_Cpp()) ) {
                                alt51=1;
                            }
                            else if ( (true) ) {
                                alt51=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 51, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case CHARACTER_LITERAL:
                        case CKEYWORD:
                        case COMMA:
                        case COPERATOR:
                        case DECIMAL_LITERAL:
                        case FLOATING_POINT_LITERAL:
                        case HEX_LITERAL:
                        case IDENTIFIER:
                        case LINECOMMENTS:
                        case LPAREN:
                        case OCTAL_LITERAL:
                        case SEMICOLON:
                        case SHARPSHARP:
                        case SIZEOF:
                        case STRINGIFICATION:
                        case STRING_LITERAL:
                        case STRING_OP:
                        case TEXT_END:
                            {
                            alt51=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 51, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA51_1==LPAREN) ) {
                    switch ( input.LA(3) ) {
                    case WS:
                        {
                        int LA51_4 = input.LA(4);

                        if ( (LA51_4==RPAREN) ) {
                            int LA51_7 = input.LA(5);

                            if ( (synpred98_Cpp()) ) {
                                alt51=1;
                            }
                            else if ( (true) ) {
                                alt51=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 51, 7, input);

                                throw nvae;

                            }
                        }
                        else if ( ((LA51_4 >= CHARACTER_LITERAL && LA51_4 <= CKEYWORD)||LA51_4==COMMA||(LA51_4 >= COPERATOR && LA51_4 <= DECIMAL_LITERAL)||LA51_4==FLOATING_POINT_LITERAL||LA51_4==HEX_LITERAL||LA51_4==IDENTIFIER||LA51_4==LINECOMMENTS||LA51_4==LPAREN||LA51_4==OCTAL_LITERAL||(LA51_4 >= SEMICOLON && LA51_4 <= SHARPSHARP)||LA51_4==SIZEOF||(LA51_4 >= STRINGIFICATION && LA51_4 <= TEXT_END)||LA51_4==WS) ) {
                            alt51=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 51, 4, input);

                            throw nvae;

                        }
                        }
                        break;
                    case RPAREN:
                        {
                        int LA51_5 = input.LA(4);

                        if ( (synpred98_Cpp()) ) {
                            alt51=1;
                        }
                        else if ( (true) ) {
                            alt51=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 51, 5, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CHARACTER_LITERAL:
                    case CKEYWORD:
                    case COMMA:
                    case COPERATOR:
                    case DECIMAL_LITERAL:
                    case FLOATING_POINT_LITERAL:
                    case HEX_LITERAL:
                    case IDENTIFIER:
                    case LINECOMMENTS:
                    case LPAREN:
                    case OCTAL_LITERAL:
                    case SEMICOLON:
                    case SHARPSHARP:
                    case SIZEOF:
                    case STRINGIFICATION:
                    case STRING_LITERAL:
                    case STRING_OP:
                    case TEXT_END:
                        {
                        alt51=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 3, input);

                        throw nvae;

                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }
            switch (alt51) {
                case 1 :
                    // Cpp.g:265:7: id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroExpansion2351); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


                    // Cpp.g:265:21: ( WS )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==WS) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // Cpp.g:265:21: WS
                            {
                            WS165=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2353); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS165);


                            }
                            break;

                    }


                    LPAREN166=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroExpansion2356); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN166);


                    // Cpp.g:265:32: ( WS )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==WS) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // Cpp.g:265:32: WS
                            {
                            WS167=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2358); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS167);


                            }
                            break;

                    }


                    RPAREN168=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroExpansion2363); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN168);


                    // AST REWRITE
                    // elements: id
                    // token labels: id
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 265:46: -> ^( EXPAND $id)
                    {
                        // Cpp.g:265:49: ^( EXPAND $id)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXPAND, "EXPAND")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:266:7: id= IDENTIFIER ( WS )? LPAREN ( WS )? macArgs ( WS )? RPAREN
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroExpansion2383); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);


                    // Cpp.g:266:21: ( WS )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==WS) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // Cpp.g:266:21: WS
                            {
                            WS169=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2385); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS169);


                            }
                            break;

                    }


                    LPAREN170=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroExpansion2388); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN170);


                    // Cpp.g:266:32: ( WS )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==WS) ) {
                        int LA49_1 = input.LA(2);

                        if ( (synpred100_Cpp()) ) {
                            alt49=1;
                        }
                    }
                    switch (alt49) {
                        case 1 :
                            // Cpp.g:266:32: WS
                            {
                            WS171=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2390); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS171);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_macArgs_in_macroExpansion2393);
                    macArgs172=macArgs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_macArgs.add(macArgs172.getTree());

                    // Cpp.g:266:45: ( WS )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==WS) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // Cpp.g:266:45: WS
                            {
                            WS173=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2396); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS173);


                            }
                            break;

                    }


                    RPAREN174=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroExpansion2399); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN174);


                    // AST REWRITE
                    // elements: macArgs, id
                    // token labels: id
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 266:58: -> ^( EXPAND $id ( macArgs )? )
                    {
                        // Cpp.g:266:61: ^( EXPAND $id ( macArgs )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXPAND, "EXPAND")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());

                        // Cpp.g:266:74: ( macArgs )?
                        if ( stream_macArgs.hasNext() ) {
                            adaptor.addChild(root_1, stream_macArgs.nextTree());

                        }
                        stream_macArgs.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, macroExpansion_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macroExpansion"


    public static class macArgs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macArgs"
    // Cpp.g:269:1: macArgs :marg+= mArg ( ( WS )? COMMA ( WS )? marg+= mArg )* -> ^( EXP_ARGS ( $marg)+ ) ;
    public final CppParser.macArgs_return macArgs() throws RecognitionException {
        CppParser.macArgs_return retval = new CppParser.macArgs_return();
        retval.start = input.LT(1);

        int macArgs_StartIndex = input.index();

        Object root_0 = null;

        Token WS175=null;
        Token COMMA176=null;
        Token WS177=null;
        List list_marg=null;
        RuleReturnScope marg = null;
        Object WS175_tree=null;
        Object COMMA176_tree=null;
        Object WS177_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_mArg=new RewriteRuleSubtreeStream(adaptor,"rule mArg");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }

            // Cpp.g:269:9: (marg+= mArg ( ( WS )? COMMA ( WS )? marg+= mArg )* -> ^( EXP_ARGS ( $marg)+ ) )
            // Cpp.g:269:11: marg+= mArg ( ( WS )? COMMA ( WS )? marg+= mArg )*
            {
            pushFollow(FOLLOW_mArg_in_macArgs2428);
            marg=mArg();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_mArg.add(marg.getTree());
            if (list_marg==null) list_marg=new ArrayList();
            list_marg.add(marg.getTree());


            // Cpp.g:269:22: ( ( WS )? COMMA ( WS )? marg+= mArg )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==WS) ) {
                    int LA54_1 = input.LA(2);

                    if ( (LA54_1==COMMA) ) {
                        alt54=1;
                    }


                }
                else if ( (LA54_0==COMMA) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // Cpp.g:269:24: ( WS )? COMMA ( WS )? marg+= mArg
            	    {
            	    // Cpp.g:269:24: ( WS )?
            	    int alt52=2;
            	    int LA52_0 = input.LA(1);

            	    if ( (LA52_0==WS) ) {
            	        alt52=1;
            	    }
            	    switch (alt52) {
            	        case 1 :
            	            // Cpp.g:269:24: WS
            	            {
            	            WS175=(Token)match(input,WS,FOLLOW_WS_in_macArgs2432); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WS.add(WS175);


            	            }
            	            break;

            	    }


            	    COMMA176=(Token)match(input,COMMA,FOLLOW_COMMA_in_macArgs2435); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA176);


            	    // Cpp.g:269:34: ( WS )?
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( (LA53_0==WS) ) {
            	        int LA53_1 = input.LA(2);

            	        if ( (synpred103_Cpp()) ) {
            	            alt53=1;
            	        }
            	    }
            	    switch (alt53) {
            	        case 1 :
            	            // Cpp.g:269:34: WS
            	            {
            	            WS177=(Token)match(input,WS,FOLLOW_WS_in_macArgs2437); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WS.add(WS177);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_mArg_in_macArgs2442);
            	    marg=mArg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_mArg.add(marg.getTree());
            	    if (list_marg==null) list_marg=new ArrayList();
            	    list_marg.add(marg.getTree());


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            // AST REWRITE
            // elements: marg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: marg
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_marg=new RewriteRuleSubtreeStream(adaptor,"token marg",list_marg);
            root_0 = (Object)adaptor.nil();
            // 269:52: -> ^( EXP_ARGS ( $marg)+ )
            {
                // Cpp.g:269:55: ^( EXP_ARGS ( $marg)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(EXP_ARGS, "EXP_ARGS")
                , root_1);

                if ( !(stream_marg.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_marg.hasNext() ) {
                    adaptor.addChild(root_1, stream_marg.nextTree());

                }
                stream_marg.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, macArgs_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macArgs"


    public static class mArg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mArg"
    // Cpp.g:272:1: mArg : ( ( sourceExpression )+ -> ^( EXP_ARG ( sourceExpression )+ ) | -> ^( EXP_ARG ) );
    public final CppParser.mArg_return mArg() throws RecognitionException {
        CppParser.mArg_return retval = new CppParser.mArg_return();
        retval.start = input.LT(1);

        int mArg_StartIndex = input.index();

        Object root_0 = null;

        CppParser.sourceExpression_return sourceExpression178 =null;


        RewriteRuleSubtreeStream stream_sourceExpression=new RewriteRuleSubtreeStream(adaptor,"rule sourceExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }

            // Cpp.g:272:7: ( ( sourceExpression )+ -> ^( EXP_ARG ( sourceExpression )+ ) | -> ^( EXP_ARG ) )
            int alt56=2;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case CKEYWORD:
            case COPERATOR:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case LINECOMMENTS:
            case LPAREN:
            case OCTAL_LITERAL:
            case SEMICOLON:
            case SHARPSHARP:
            case SIZEOF:
            case STRINGIFICATION:
            case STRING_LITERAL:
            case STRING_OP:
            case TEXT_END:
                {
                alt56=1;
                }
                break;
            case WS:
                {
                int LA56_2 = input.LA(2);

                if ( (synpred106_Cpp()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;

                }
                }
                break;
            case EOF:
            case COMMA:
            case RPAREN:
                {
                alt56=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // Cpp.g:272:9: ( sourceExpression )+
                    {
                    // Cpp.g:272:9: ( sourceExpression )+
                    int cnt55=0;
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==WS) ) {
                            int LA55_1 = input.LA(2);

                            if ( (synpred105_Cpp()) ) {
                                alt55=1;
                            }


                        }
                        else if ( ((LA55_0 >= CHARACTER_LITERAL && LA55_0 <= CKEYWORD)||(LA55_0 >= COPERATOR && LA55_0 <= DECIMAL_LITERAL)||LA55_0==FLOATING_POINT_LITERAL||LA55_0==HEX_LITERAL||LA55_0==IDENTIFIER||LA55_0==LINECOMMENTS||LA55_0==LPAREN||LA55_0==OCTAL_LITERAL||(LA55_0 >= SEMICOLON && LA55_0 <= SHARPSHARP)||LA55_0==SIZEOF||(LA55_0 >= STRINGIFICATION && LA55_0 <= TEXT_END)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // Cpp.g:272:9: sourceExpression
                    	    {
                    	    pushFollow(FOLLOW_sourceExpression_in_mArg2469);
                    	    sourceExpression178=sourceExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_sourceExpression.add(sourceExpression178.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt55 >= 1 ) break loop55;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(55, input);
                                throw eee;
                        }
                        cnt55++;
                    } while (true);


                    // AST REWRITE
                    // elements: sourceExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 272:29: -> ^( EXP_ARG ( sourceExpression )+ )
                    {
                        // Cpp.g:272:32: ^( EXP_ARG ( sourceExpression )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXP_ARG, "EXP_ARG")
                        , root_1);

                        if ( !(stream_sourceExpression.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_sourceExpression.hasNext() ) {
                            adaptor.addChild(root_1, stream_sourceExpression.nextTree());

                        }
                        stream_sourceExpression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:273:7: 
                    {
                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 273:7: -> ^( EXP_ARG )
                    {
                        // Cpp.g:273:10: ^( EXP_ARG )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXP_ARG, "EXP_ARG")
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, mArg_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "mArg"


    public static class sourceExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sourceExpression"
    // Cpp.g:276:1: sourceExpression : ( ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion | ( primarySource ( WS )? SHARPSHARP )=> concatenate | STRINGIFICATION IDENTIFIER -> ^( STRINGIFICATION IDENTIFIER ) | primarySource | STRING_OP | SIZEOF | LPAREN ( macArgs )? RPAREN -> ^( TEXT_GROUP ( macArgs )? ) | SEMICOLON | TEXT_END | LINECOMMENTS | WS );
    public final CppParser.sourceExpression_return sourceExpression() throws RecognitionException {
        CppParser.sourceExpression_return retval = new CppParser.sourceExpression_return();
        retval.start = input.LT(1);

        int sourceExpression_StartIndex = input.index();

        Object root_0 = null;

        Token STRINGIFICATION181=null;
        Token IDENTIFIER182=null;
        Token STRING_OP184=null;
        Token SIZEOF185=null;
        Token LPAREN186=null;
        Token RPAREN188=null;
        Token SEMICOLON189=null;
        Token TEXT_END190=null;
        Token LINECOMMENTS191=null;
        Token WS192=null;
        CppParser.concatenate_return macroExpansion179 =null;

        CppParser.concatenate_return concatenate180 =null;

        CppParser.primarySource_return primarySource183 =null;

        CppParser.macArgs_return macArgs187 =null;


        Object STRINGIFICATION181_tree=null;
        Object IDENTIFIER182_tree=null;
        Object STRING_OP184_tree=null;
        Object SIZEOF185_tree=null;
        Object LPAREN186_tree=null;
        Object RPAREN188_tree=null;
        Object SEMICOLON189_tree=null;
        Object TEXT_END190_tree=null;
        Object LINECOMMENTS191_tree=null;
        Object WS192_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_STRINGIFICATION=new RewriteRuleTokenStream(adaptor,"token STRINGIFICATION");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_macArgs=new RewriteRuleSubtreeStream(adaptor,"rule macArgs");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }

            // Cpp.g:277:5: ( ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion | ( primarySource ( WS )? SHARPSHARP )=> concatenate | STRINGIFICATION IDENTIFIER -> ^( STRINGIFICATION IDENTIFIER ) | primarySource | STRING_OP | SIZEOF | LPAREN ( macArgs )? RPAREN -> ^( TEXT_GROUP ( macArgs )? ) | SEMICOLON | TEXT_END | LINECOMMENTS | WS )
            int alt58=11;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA58_1 = input.LA(2);

                if ( (synpred108_Cpp()) ) {
                    alt58=1;
                }
                else if ( (synpred110_Cpp()) ) {
                    alt58=2;
                }
                else if ( (synpred112_Cpp()) ) {
                    alt58=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;

                }
                }
                break;
            case SHARPSHARP:
                {
                int LA58_2 = input.LA(2);

                if ( (synpred110_Cpp()) ) {
                    alt58=2;
                }
                else if ( (synpred112_Cpp()) ) {
                    alt58=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;

                }
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                int LA58_3 = input.LA(2);

                if ( (synpred110_Cpp()) ) {
                    alt58=2;
                }
                else if ( (synpred112_Cpp()) ) {
                    alt58=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 3, input);

                    throw nvae;

                }
                }
                break;
            case CKEYWORD:
                {
                int LA58_4 = input.LA(2);

                if ( (synpred110_Cpp()) ) {
                    alt58=2;
                }
                else if ( (synpred112_Cpp()) ) {
                    alt58=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 4, input);

                    throw nvae;

                }
                }
                break;
            case COPERATOR:
                {
                int LA58_5 = input.LA(2);

                if ( (synpred110_Cpp()) ) {
                    alt58=2;
                }
                else if ( (synpred112_Cpp()) ) {
                    alt58=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 5, input);

                    throw nvae;

                }
                }
                break;
            case STRINGIFICATION:
                {
                alt58=3;
                }
                break;
            case STRING_OP:
                {
                alt58=5;
                }
                break;
            case SIZEOF:
                {
                alt58=6;
                }
                break;
            case LPAREN:
                {
                alt58=7;
                }
                break;
            case SEMICOLON:
                {
                alt58=8;
                }
                break;
            case TEXT_END:
                {
                alt58=9;
                }
                break;
            case LINECOMMENTS:
                {
                alt58=10;
                }
                break;
            case WS:
                {
                alt58=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // Cpp.g:277:7: ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_macroExpansion_in_sourceExpression2522);
                    macroExpansion179=concatenate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroExpansion179.getTree());

                    }
                    break;
                case 2 :
                    // Cpp.g:278:7: ( primarySource ( WS )? SHARPSHARP )=> concatenate
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_concatenate_in_sourceExpression2544);
                    concatenate180=concatenate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, concatenate180.getTree());

                    }
                    break;
                case 3 :
                    // Cpp.g:279:7: STRINGIFICATION IDENTIFIER
                    {
                    STRINGIFICATION181=(Token)match(input,STRINGIFICATION,FOLLOW_STRINGIFICATION_in_sourceExpression2552); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRINGIFICATION.add(STRINGIFICATION181);


                    IDENTIFIER182=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_sourceExpression2554); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER182);


                    // AST REWRITE
                    // elements: STRINGIFICATION, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 279:37: -> ^( STRINGIFICATION IDENTIFIER )
                    {
                        // Cpp.g:279:41: ^( STRINGIFICATION IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_STRINGIFICATION.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // Cpp.g:280:7: primarySource
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_primarySource_in_sourceExpression2574);
                    primarySource183=primarySource();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primarySource183.getTree());

                    }
                    break;
                case 5 :
                    // Cpp.g:281:7: STRING_OP
                    {
                    root_0 = (Object)adaptor.nil();


                    STRING_OP184=(Token)match(input,STRING_OP,FOLLOW_STRING_OP_in_sourceExpression2582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING_OP184_tree = 
                    (Object)adaptor.create(STRING_OP184)
                    ;
                    adaptor.addChild(root_0, STRING_OP184_tree);
                    }

                    }
                    break;
                case 6 :
                    // Cpp.g:282:7: SIZEOF
                    {
                    root_0 = (Object)adaptor.nil();


                    SIZEOF185=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_sourceExpression2590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SIZEOF185_tree = 
                    (Object)adaptor.create(SIZEOF185)
                    ;
                    adaptor.addChild(root_0, SIZEOF185_tree);
                    }

                    }
                    break;
                case 7 :
                    // Cpp.g:283:7: LPAREN ( macArgs )? RPAREN
                    {
                    LPAREN186=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_sourceExpression2598); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN186);


                    // Cpp.g:283:14: ( macArgs )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( ((LA57_0 >= CHARACTER_LITERAL && LA57_0 <= CKEYWORD)||LA57_0==COMMA||(LA57_0 >= COPERATOR && LA57_0 <= DECIMAL_LITERAL)||LA57_0==FLOATING_POINT_LITERAL||LA57_0==HEX_LITERAL||LA57_0==IDENTIFIER||LA57_0==LINECOMMENTS||LA57_0==LPAREN||LA57_0==OCTAL_LITERAL||(LA57_0 >= SEMICOLON && LA57_0 <= SHARPSHARP)||LA57_0==SIZEOF||(LA57_0 >= STRINGIFICATION && LA57_0 <= TEXT_END)||LA57_0==WS) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==RPAREN) ) {
                        int LA57_2 = input.LA(2);

                        if ( (synpred115_Cpp()) ) {
                            alt57=1;
                        }
                    }
                    switch (alt57) {
                        case 1 :
                            // Cpp.g:283:14: macArgs
                            {
                            pushFollow(FOLLOW_macArgs_in_sourceExpression2600);
                            macArgs187=macArgs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macArgs.add(macArgs187.getTree());

                            }
                            break;

                    }


                    RPAREN188=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_sourceExpression2603); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN188);


                    // AST REWRITE
                    // elements: macArgs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 283:31: -> ^( TEXT_GROUP ( macArgs )? )
                    {
                        // Cpp.g:283:34: ^( TEXT_GROUP ( macArgs )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(TEXT_GROUP, "TEXT_GROUP")
                        , root_1);

                        // Cpp.g:283:47: ( macArgs )?
                        if ( stream_macArgs.hasNext() ) {
                            adaptor.addChild(root_1, stream_macArgs.nextTree());

                        }
                        stream_macArgs.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 8 :
                    // Cpp.g:284:7: SEMICOLON
                    {
                    root_0 = (Object)adaptor.nil();


                    SEMICOLON189=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_sourceExpression2621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON189_tree = 
                    (Object)adaptor.create(SEMICOLON189)
                    ;
                    adaptor.addChild(root_0, SEMICOLON189_tree);
                    }

                    }
                    break;
                case 9 :
                    // Cpp.g:285:7: TEXT_END
                    {
                    root_0 = (Object)adaptor.nil();


                    TEXT_END190=(Token)match(input,TEXT_END,FOLLOW_TEXT_END_in_sourceExpression2629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT_END190_tree = 
                    (Object)adaptor.create(TEXT_END190)
                    ;
                    adaptor.addChild(root_0, TEXT_END190_tree);
                    }

                    }
                    break;
                case 10 :
                    // Cpp.g:286:7: LINECOMMENTS
                    {
                    root_0 = (Object)adaptor.nil();


                    LINECOMMENTS191=(Token)match(input,LINECOMMENTS,FOLLOW_LINECOMMENTS_in_sourceExpression2637); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LINECOMMENTS191_tree = 
                    (Object)adaptor.create(LINECOMMENTS191)
                    ;
                    adaptor.addChild(root_0, LINECOMMENTS191_tree);
                    }

                    }
                    break;
                case 11 :
                    // Cpp.g:287:7: WS
                    {
                    root_0 = (Object)adaptor.nil();


                    WS192=(Token)match(input,WS,FOLLOW_WS_in_sourceExpression2645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WS192_tree = 
                    (Object)adaptor.create(WS192)
                    ;
                    adaptor.addChild(root_0, WS192_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, sourceExpression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "sourceExpression"


    public static class concatenate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "concatenate"
    // Cpp.g:290:1: concatenate :prim+= primarySource ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+ -> ^( CONCATENATE ( $prim)+ ) ;
    public final CppParser.concatenate_return concatenate() throws RecognitionException {
        CppParser.concatenate_return retval = new CppParser.concatenate_return();
        retval.start = input.LT(1);

        int concatenate_StartIndex = input.index();

        Object root_0 = null;

        Token WS193=null;
        Token SHARPSHARP194=null;
        Token WS195=null;
        List list_prim=null;
        RuleReturnScope prim = null;
        Object WS193_tree=null;
        Object SHARPSHARP194_tree=null;
        Object WS195_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_SHARPSHARP=new RewriteRuleTokenStream(adaptor,"token SHARPSHARP");
        RewriteRuleSubtreeStream stream_primarySource=new RewriteRuleSubtreeStream(adaptor,"rule primarySource");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }

            // Cpp.g:291:5: (prim+= primarySource ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+ -> ^( CONCATENATE ( $prim)+ ) )
            // Cpp.g:291:7: prim+= primarySource ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+
            {
            pushFollow(FOLLOW_primarySource_in_concatenate2664);
            prim=primarySource();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_primarySource.add(prim.getTree());
            if (list_prim==null) list_prim=new ArrayList();
            list_prim.add(prim.getTree());


            // Cpp.g:291:27: ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==SHARPSHARP) ) {
                    switch ( input.LA(2) ) {
                    case WS:
                        {
                        int LA61_4 = input.LA(3);

                        if ( (LA61_4==IDENTIFIER) ) {
                            int LA61_7 = input.LA(4);

                            if ( (synpred122_Cpp()) ) {
                                alt61=1;
                            }


                        }
                        else if ( ((LA61_4 >= CHARACTER_LITERAL && LA61_4 <= CKEYWORD)||(LA61_4 >= COPERATOR && LA61_4 <= DECIMAL_LITERAL)||LA61_4==FLOATING_POINT_LITERAL||LA61_4==HEX_LITERAL||LA61_4==OCTAL_LITERAL||LA61_4==SHARPSHARP||LA61_4==STRING_LITERAL) ) {
                            alt61=1;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA61_5 = input.LA(3);

                        if ( (synpred122_Cpp()) ) {
                            alt61=1;
                        }


                        }
                        break;
                    case CHARACTER_LITERAL:
                    case CKEYWORD:
                    case COPERATOR:
                    case DECIMAL_LITERAL:
                    case FLOATING_POINT_LITERAL:
                    case HEX_LITERAL:
                    case OCTAL_LITERAL:
                    case SHARPSHARP:
                    case STRING_LITERAL:
                        {
                        alt61=1;
                        }
                        break;

                    }

                }
                else if ( (LA61_0==WS) ) {
                    int LA61_3 = input.LA(2);

                    if ( (LA61_3==SHARPSHARP) ) {
                        switch ( input.LA(3) ) {
                        case WS:
                            {
                            int LA61_4 = input.LA(4);

                            if ( (LA61_4==IDENTIFIER) ) {
                                int LA61_7 = input.LA(5);

                                if ( (synpred122_Cpp()) ) {
                                    alt61=1;
                                }


                            }
                            else if ( ((LA61_4 >= CHARACTER_LITERAL && LA61_4 <= CKEYWORD)||(LA61_4 >= COPERATOR && LA61_4 <= DECIMAL_LITERAL)||LA61_4==FLOATING_POINT_LITERAL||LA61_4==HEX_LITERAL||LA61_4==OCTAL_LITERAL||LA61_4==SHARPSHARP||LA61_4==STRING_LITERAL) ) {
                                alt61=1;
                            }


                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA61_5 = input.LA(4);

                            if ( (synpred122_Cpp()) ) {
                                alt61=1;
                            }


                            }
                            break;
                        case CHARACTER_LITERAL:
                        case CKEYWORD:
                        case COPERATOR:
                        case DECIMAL_LITERAL:
                        case FLOATING_POINT_LITERAL:
                        case HEX_LITERAL:
                        case OCTAL_LITERAL:
                        case SHARPSHARP:
                        case STRING_LITERAL:
                            {
                            alt61=1;
                            }
                            break;

                        }

                    }


                }


                switch (alt61) {
            	case 1 :
            	    // Cpp.g:291:28: ( WS )? SHARPSHARP ( WS )? prim+= primarySource
            	    {
            	    // Cpp.g:291:28: ( WS )?
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==WS) ) {
            	        alt59=1;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // Cpp.g:291:28: WS
            	            {
            	            WS193=(Token)match(input,WS,FOLLOW_WS_in_concatenate2667); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WS.add(WS193);


            	            }
            	            break;

            	    }


            	    SHARPSHARP194=(Token)match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_concatenate2670); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SHARPSHARP.add(SHARPSHARP194);


            	    // Cpp.g:291:44: ( WS )?
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==WS) ) {
            	        alt60=1;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // Cpp.g:291:44: WS
            	            {
            	            WS195=(Token)match(input,WS,FOLLOW_WS_in_concatenate2673); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WS.add(WS195);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_primarySource_in_concatenate2678);
            	    prim=primarySource();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_primarySource.add(prim.getTree());
            	    if (list_prim==null) list_prim=new ArrayList();
            	    list_prim.add(prim.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);


            // AST REWRITE
            // elements: prim
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: prim
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_prim=new RewriteRuleSubtreeStream(adaptor,"token prim",list_prim);
            root_0 = (Object)adaptor.nil();
            // 291:71: -> ^( CONCATENATE ( $prim)+ )
            {
                // Cpp.g:291:74: ^( CONCATENATE ( $prim)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONCATENATE, "CONCATENATE")
                , root_1);

                if ( !(stream_prim.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_prim.hasNext() ) {
                    adaptor.addChild(root_1, stream_prim.nextTree());

                }
                stream_prim.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, concatenate_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "concatenate"


    public static class primarySource_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "primarySource"
    // Cpp.g:294:1: primarySource : ( SHARPSHARP ( WS )? IDENTIFIER -> ^( SHARPSHARP IDENTIFIER ) | IDENTIFIER | constant | CKEYWORD | COPERATOR );
    public final CppParser.primarySource_return primarySource() throws RecognitionException {
        CppParser.primarySource_return retval = new CppParser.primarySource_return();
        retval.start = input.LT(1);

        int primarySource_StartIndex = input.index();

        Object root_0 = null;

        Token SHARPSHARP196=null;
        Token WS197=null;
        Token IDENTIFIER198=null;
        Token IDENTIFIER199=null;
        Token CKEYWORD201=null;
        Token COPERATOR202=null;
        CppParser.constant_return constant200 =null;


        Object SHARPSHARP196_tree=null;
        Object WS197_tree=null;
        Object IDENTIFIER198_tree=null;
        Object IDENTIFIER199_tree=null;
        Object CKEYWORD201_tree=null;
        Object COPERATOR202_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_SHARPSHARP=new RewriteRuleTokenStream(adaptor,"token SHARPSHARP");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }

            // Cpp.g:295:5: ( SHARPSHARP ( WS )? IDENTIFIER -> ^( SHARPSHARP IDENTIFIER ) | IDENTIFIER | constant | CKEYWORD | COPERATOR )
            int alt63=5;
            switch ( input.LA(1) ) {
            case SHARPSHARP:
                {
                alt63=1;
                }
                break;
            case IDENTIFIER:
                {
                alt63=2;
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt63=3;
                }
                break;
            case CKEYWORD:
                {
                alt63=4;
                }
                break;
            case COPERATOR:
                {
                alt63=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // Cpp.g:295:9: SHARPSHARP ( WS )? IDENTIFIER
                    {
                    SHARPSHARP196=(Token)match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_primarySource2710); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHARPSHARP.add(SHARPSHARP196);


                    // Cpp.g:295:20: ( WS )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==WS) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // Cpp.g:295:20: WS
                            {
                            WS197=(Token)match(input,WS,FOLLOW_WS_in_primarySource2712); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WS.add(WS197);


                            }
                            break;

                    }


                    IDENTIFIER198=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primarySource2716); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER198);


                    // AST REWRITE
                    // elements: IDENTIFIER, SHARPSHARP
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 295:37: -> ^( SHARPSHARP IDENTIFIER )
                    {
                        // Cpp.g:295:40: ^( SHARPSHARP IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_SHARPSHARP.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Cpp.g:296:7: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();


                    IDENTIFIER199=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primarySource2733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER199_tree = 
                    (Object)adaptor.create(IDENTIFIER199)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER199_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:297:7: constant
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_constant_in_primarySource2742);
                    constant200=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant200.getTree());

                    }
                    break;
                case 4 :
                    // Cpp.g:298:7: CKEYWORD
                    {
                    root_0 = (Object)adaptor.nil();


                    CKEYWORD201=(Token)match(input,CKEYWORD,FOLLOW_CKEYWORD_in_primarySource2750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CKEYWORD201_tree = 
                    (Object)adaptor.create(CKEYWORD201)
                    ;
                    adaptor.addChild(root_0, CKEYWORD201_tree);
                    }

                    }
                    break;
                case 5 :
                    // Cpp.g:299:7: COPERATOR
                    {
                    root_0 = (Object)adaptor.nil();


                    COPERATOR202=(Token)match(input,COPERATOR,FOLLOW_COPERATOR_in_primarySource2758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COPERATOR202_tree = 
                    (Object)adaptor.create(COPERATOR202)
                    ;
                    adaptor.addChild(root_0, COPERATOR202_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 39, primarySource_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "primarySource"


    public static class macro_text_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro_text"
    // Cpp.g:666:1: macro_text : ( source_text )+ -> ^( MACRO_DEFINE ( source_text )+ ) ;
    public final CppParser.macro_text_return macro_text() throws RecognitionException {
        CppParser.macro_text_return retval = new CppParser.macro_text_return();
        retval.start = input.LT(1);

        int macro_text_StartIndex = input.index();

        Object root_0 = null;

        CppParser.source_text_return source_text203 =null;


        RewriteRuleSubtreeStream stream_source_text=new RewriteRuleSubtreeStream(adaptor,"rule source_text");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }

            // Cpp.g:667:5: ( ( source_text )+ -> ^( MACRO_DEFINE ( source_text )+ ) )
            // Cpp.g:667:7: ( source_text )+
            {
            // Cpp.g:667:7: ( source_text )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0 >= CHARACTER_LITERAL && LA64_0 <= CKEYWORD)||LA64_0==COMMA||(LA64_0 >= COPERATOR && LA64_0 <= DECIMAL_LITERAL)||LA64_0==FLOATING_POINT_LITERAL||LA64_0==HEX_LITERAL||LA64_0==IDENTIFIER||LA64_0==LINECOMMENTS||LA64_0==LPAREN||LA64_0==OCTAL_LITERAL||LA64_0==RPAREN||(LA64_0 >= SEMICOLON && LA64_0 <= SHARPSHARP)||LA64_0==SIZEOF||(LA64_0 >= STRINGIFICATION && LA64_0 <= TEXT_END)||LA64_0==WS) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // Cpp.g:667:7: source_text
            	    {
            	    pushFollow(FOLLOW_source_text_in_macro_text4914);
            	    source_text203=source_text();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_source_text.add(source_text203.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);


            // AST REWRITE
            // elements: source_text
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 667:20: -> ^( MACRO_DEFINE ( source_text )+ )
            {
                // Cpp.g:667:23: ^( MACRO_DEFINE ( source_text )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(MACRO_DEFINE, "MACRO_DEFINE")
                , root_1);

                if ( !(stream_source_text.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_source_text.hasNext() ) {
                    adaptor.addChild(root_1, stream_source_text.nextTree());

                }
                stream_source_text.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 40, macro_text_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "macro_text"

    // $ANTLR start synpred13_Cpp
    public final void synpred13_Cpp_fragment() throws RecognitionException {
        // Cpp.g:77:7: ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? )
        // Cpp.g:77:7: DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )?
        {
        match(input,DEFINE,FOLLOW_DEFINE_in_synpred13_Cpp424); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred13_Cpp427); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred13_Cpp430); if (state.failed) return ;

        // Cpp.g:77:35: ( WS )?
        int alt65=2;
        int LA65_0 = input.LA(1);

        if ( (LA65_0==WS) ) {
            alt65=1;
        }
        switch (alt65) {
            case 1 :
                // Cpp.g:77:35: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred13_Cpp433); if (state.failed) return ;

                }
                break;

        }


        match(input,RPAREN,FOLLOW_RPAREN_in_synpred13_Cpp436); if (state.failed) return ;

        // Cpp.g:77:47: ( macro_text )?
        int alt66=2;
        int LA66_0 = input.LA(1);

        if ( ((LA66_0 >= CHARACTER_LITERAL && LA66_0 <= CKEYWORD)||LA66_0==COMMA||(LA66_0 >= COPERATOR && LA66_0 <= DECIMAL_LITERAL)||LA66_0==FLOATING_POINT_LITERAL||LA66_0==HEX_LITERAL||LA66_0==IDENTIFIER||LA66_0==LINECOMMENTS||LA66_0==LPAREN||LA66_0==OCTAL_LITERAL||LA66_0==RPAREN||(LA66_0 >= SEMICOLON && LA66_0 <= SHARPSHARP)||LA66_0==SIZEOF||(LA66_0 >= STRINGIFICATION && LA66_0 <= TEXT_END)||LA66_0==WS) ) {
            alt66=1;
        }
        switch (alt66) {
            case 1 :
                // Cpp.g:77:47: macro_text
                {
                pushFollow(FOLLOW_macro_text_in_synpred13_Cpp439);
                macro_text();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred13_Cpp

    // $ANTLR start synpred21_Cpp
    public final void synpred21_Cpp_fragment() throws RecognitionException {
        Token mac=null;
        List list_=null;
        RuleReturnScope  arg= null;
        // Cpp.g:78:7: ( DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? )
        // Cpp.g:78:7: DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )?
        {
        match(input,DEFINE,FOLLOW_DEFINE_in_synpred21_Cpp461); if (state.failed) return ;

        mac=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred21_Cpp466); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred21_Cpp470); if (state.failed) return ;

        // Cpp.g:78:39: ( WS )?
        int alt73=2;
        int LA73_0 = input.LA(1);

        if ( (LA73_0==WS) ) {
            alt73=1;
        }
        switch (alt73) {
            case 1 :
                // Cpp.g:78:39: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred21_Cpp472); if (state.failed) return ;

                }
                break;

        }


        // Cpp.g:78:45: (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )?
        int alt78=2;
        int LA78_0 = input.LA(1);

        if ( (LA78_0==ELLIPSIS||LA78_0==IDENTIFIER) ) {
            alt78=1;
        }
        switch (alt78) {
            case 1 :
                // Cpp.g:78:46: arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                {
                pushFollow(FOLLOW_macroParam_in_synpred21_Cpp480);
                arg=macroParam();

                state._fsp--;
                if (state.failed) return ;

                // Cpp.g:78:63: ( WS )?
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==WS) ) {
                    alt74=1;
                }
                switch (alt74) {
                    case 1 :
                        // Cpp.g:78:63: WS
                        {
                        match(input,WS,FOLLOW_WS_in_synpred21_Cpp483); if (state.failed) return ;

                        }
                        break;

                }


                // Cpp.g:78:67: ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                loop77:
                do {
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==COMMA) ) {
                        alt77=1;
                    }


                    switch (alt77) {
                	case 1 :
                	    // Cpp.g:78:68: COMMA ( WS )* arg+= macroParam ( WS )*
                	    {
                	    match(input,COMMA,FOLLOW_COMMA_in_synpred21_Cpp487); if (state.failed) return ;

                	    // Cpp.g:78:75: ( WS )*
                	    loop75:
                	    do {
                	        int alt75=2;
                	        int LA75_0 = input.LA(1);

                	        if ( (LA75_0==WS) ) {
                	            alt75=1;
                	        }


                	        switch (alt75) {
                	    	case 1 :
                	    	    // Cpp.g:78:75: WS
                	    	    {
                	    	    match(input,WS,FOLLOW_WS_in_synpred21_Cpp490); if (state.failed) return ;

                	    	    }
                	    	    break;

                	    	default :
                	    	    break loop75;
                	        }
                	    } while (true);


                	    pushFollow(FOLLOW_macroParam_in_synpred21_Cpp495);
                	    arg=macroParam();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    // Cpp.g:78:95: ( WS )*
                	    loop76:
                	    do {
                	        int alt76=2;
                	        int LA76_0 = input.LA(1);

                	        if ( (LA76_0==WS) ) {
                	            alt76=1;
                	        }


                	        switch (alt76) {
                	    	case 1 :
                	    	    // Cpp.g:78:95: WS
                	    	    {
                	    	    match(input,WS,FOLLOW_WS_in_synpred21_Cpp497); if (state.failed) return ;

                	    	    }
                	    	    break;

                	    	default :
                	    	    break loop76;
                	        }
                	    } while (true);


                	    }
                	    break;

                	default :
                	    break loop77;
                    }
                } while (true);


                }
                break;

        }


        match(input,RPAREN,FOLLOW_RPAREN_in_synpred21_Cpp511); if (state.failed) return ;

        // Cpp.g:79:15: ( macro_text )?
        int alt79=2;
        int LA79_0 = input.LA(1);

        if ( ((LA79_0 >= CHARACTER_LITERAL && LA79_0 <= CKEYWORD)||LA79_0==COMMA||(LA79_0 >= COPERATOR && LA79_0 <= DECIMAL_LITERAL)||LA79_0==FLOATING_POINT_LITERAL||LA79_0==HEX_LITERAL||LA79_0==IDENTIFIER||LA79_0==LINECOMMENTS||LA79_0==LPAREN||LA79_0==OCTAL_LITERAL||LA79_0==RPAREN||(LA79_0 >= SEMICOLON && LA79_0 <= SHARPSHARP)||LA79_0==SIZEOF||(LA79_0 >= STRINGIFICATION && LA79_0 <= TEXT_END)||LA79_0==WS) ) {
            alt79=1;
        }
        switch (alt79) {
            case 1 :
                // Cpp.g:79:15: macro_text
                {
                pushFollow(FOLLOW_macro_text_in_synpred21_Cpp514);
                macro_text();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred21_Cpp

    // $ANTLR start synpred30_Cpp
    public final void synpred30_Cpp_fragment() throws RecognitionException {
        // Cpp.g:122:7: ( IDENTIFIER {...}?)
        // Cpp.g:122:7: IDENTIFIER {...}?
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred30_Cpp901); if (state.failed) return ;

        if ( !((input.LT(-2).getText().equals("ifndef"))) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_Cpp", "input.LT(-2).getText().equals(\"ifndef\")");
        }

        }

    }
    // $ANTLR end synpred30_Cpp

    // $ANTLR start synpred31_Cpp
    public final void synpred31_Cpp_fragment() throws RecognitionException {
        // Cpp.g:123:7: ( IDENTIFIER {...}?)
        // Cpp.g:123:7: IDENTIFIER {...}?
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred31_Cpp923); if (state.failed) return ;

        if ( !((input.LT(-2).getText().equals("ifdef"))) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred31_Cpp", "input.LT(-2).getText().equals(\"ifdef\")");
        }

        }

    }
    // $ANTLR end synpred31_Cpp

    // $ANTLR start synpred64_Cpp
    public final void synpred64_Cpp_fragment() throws RecognitionException {
        // Cpp.g:200:7: ( SIZEOF unaryExpression )
        // Cpp.g:200:7: SIZEOF unaryExpression
        {
        match(input,SIZEOF,FOLLOW_SIZEOF_in_synpred64_Cpp1623); if (state.failed) return ;

        pushFollow(FOLLOW_unaryExpression_in_synpred64_Cpp1626);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred64_Cpp

    // $ANTLR start synpred65_Cpp
    public final void synpred65_Cpp_fragment() throws RecognitionException {
        // Cpp.g:201:7: ( SIZEOF LPAREN type_name RPAREN )
        // Cpp.g:201:7: SIZEOF LPAREN type_name RPAREN
        {
        match(input,SIZEOF,FOLLOW_SIZEOF_in_synpred65_Cpp1642); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred65_Cpp1645); if (state.failed) return ;

        pushFollow(FOLLOW_type_name_in_synpred65_Cpp1647);
        type_name();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred65_Cpp1649); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred65_Cpp

    // $ANTLR start synpred74_Cpp
    public final void synpred74_Cpp_fragment() throws RecognitionException {
        // Cpp.g:214:7: ( LPAREN type_name RPAREN unaryExpression )
        // Cpp.g:214:7: LPAREN type_name RPAREN unaryExpression
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred74_Cpp1857); if (state.failed) return ;

        pushFollow(FOLLOW_type_name_in_synpred74_Cpp1859);
        type_name();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred74_Cpp1861); if (state.failed) return ;

        pushFollow(FOLLOW_unaryExpression_in_synpred74_Cpp1864);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred74_Cpp

    // $ANTLR start synpred77_Cpp
    public final void synpred77_Cpp_fragment() throws RecognitionException {
        Token s=null;

        // Cpp.g:222:7: (s= STAR IDENTIFIER )
        // Cpp.g:222:7: s= STAR IDENTIFIER
        {
        s=(Token)match(input,STAR,FOLLOW_STAR_in_synpred77_Cpp1957); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred77_Cpp1962); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred77_Cpp

    // $ANTLR start synpred78_Cpp
    public final void synpred78_Cpp_fragment() throws RecognitionException {
        Token s=null;

        // Cpp.g:223:21: (s= BITWISEXOR IDENTIFIER )
        // Cpp.g:223:21: s= BITWISEXOR IDENTIFIER
        {
        s=(Token)match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_synpred78_Cpp1986); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred78_Cpp1991); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred78_Cpp

    // $ANTLR start synpred82_Cpp
    public final void synpred82_Cpp_fragment() throws RecognitionException {
        // Cpp.g:231:9: ( IDENTIFIER LPAREN )
        // Cpp.g:231:10: IDENTIFIER LPAREN
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred82_Cpp2068); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred82_Cpp2070); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred82_Cpp

    // $ANTLR start synpred92_Cpp
    public final void synpred92_Cpp_fragment() throws RecognitionException {
        // Cpp.g:257:9: ( sourceExpression )
        // Cpp.g:257:9: sourceExpression
        {
        pushFollow(FOLLOW_sourceExpression_in_synpred92_Cpp2298);
        sourceExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred92_Cpp

    // $ANTLR start synpred94_Cpp
    public final void synpred94_Cpp_fragment() throws RecognitionException {
        // Cpp.g:259:7: ( LPAREN )
        // Cpp.g:259:7: LPAREN
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred94_Cpp2314); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred94_Cpp

    // $ANTLR start synpred98_Cpp
    public final void synpred98_Cpp_fragment() throws RecognitionException {
        Token id=null;

        // Cpp.g:265:7: (id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN )
        // Cpp.g:265:7: id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN
        {
        id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred98_Cpp2351); if (state.failed) return ;

        // Cpp.g:265:21: ( WS )?
        int alt80=2;
        int LA80_0 = input.LA(1);

        if ( (LA80_0==WS) ) {
            alt80=1;
        }
        switch (alt80) {
            case 1 :
                // Cpp.g:265:21: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred98_Cpp2353); if (state.failed) return ;

                }
                break;

        }


        match(input,LPAREN,FOLLOW_LPAREN_in_synpred98_Cpp2356); if (state.failed) return ;

        // Cpp.g:265:32: ( WS )?
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==WS) ) {
            alt81=1;
        }
        switch (alt81) {
            case 1 :
                // Cpp.g:265:32: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred98_Cpp2358); if (state.failed) return ;

                }
                break;

        }


        match(input,RPAREN,FOLLOW_RPAREN_in_synpred98_Cpp2363); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred98_Cpp

    // $ANTLR start synpred100_Cpp
    public final void synpred100_Cpp_fragment() throws RecognitionException {
        // Cpp.g:266:32: ( WS )
        // Cpp.g:266:32: WS
        {
        match(input,WS,FOLLOW_WS_in_synpred100_Cpp2390); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred100_Cpp

    // $ANTLR start synpred103_Cpp
    public final void synpred103_Cpp_fragment() throws RecognitionException {
        // Cpp.g:269:34: ( WS )
        // Cpp.g:269:34: WS
        {
        match(input,WS,FOLLOW_WS_in_synpred103_Cpp2437); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred103_Cpp

    // $ANTLR start synpred105_Cpp
    public final void synpred105_Cpp_fragment() throws RecognitionException {
        // Cpp.g:272:9: ( sourceExpression )
        // Cpp.g:272:9: sourceExpression
        {
        pushFollow(FOLLOW_sourceExpression_in_synpred105_Cpp2469);
        sourceExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred105_Cpp

    // $ANTLR start synpred106_Cpp
    public final void synpred106_Cpp_fragment() throws RecognitionException {
        // Cpp.g:272:9: ( ( sourceExpression )+ )
        // Cpp.g:272:9: ( sourceExpression )+
        {
        // Cpp.g:272:9: ( sourceExpression )+
        int cnt84=0;
        loop84:
        do {
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0 >= CHARACTER_LITERAL && LA84_0 <= CKEYWORD)||(LA84_0 >= COPERATOR && LA84_0 <= DECIMAL_LITERAL)||LA84_0==FLOATING_POINT_LITERAL||LA84_0==HEX_LITERAL||LA84_0==IDENTIFIER||LA84_0==LINECOMMENTS||LA84_0==LPAREN||LA84_0==OCTAL_LITERAL||(LA84_0 >= SEMICOLON && LA84_0 <= SHARPSHARP)||LA84_0==SIZEOF||(LA84_0 >= STRINGIFICATION && LA84_0 <= TEXT_END)||LA84_0==WS) ) {
                alt84=1;
            }


            switch (alt84) {
        	case 1 :
        	    // Cpp.g:272:9: sourceExpression
        	    {
        	    pushFollow(FOLLOW_sourceExpression_in_synpred106_Cpp2469);
        	    sourceExpression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt84 >= 1 ) break loop84;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(84, input);
                    throw eee;
            }
            cnt84++;
        } while (true);


        }

    }
    // $ANTLR end synpred106_Cpp

    // $ANTLR start synpred108_Cpp
    public final void synpred108_Cpp_fragment() throws RecognitionException {
        // Cpp.g:277:7: ( IDENTIFIER ( WS )? LPAREN )
        // Cpp.g:277:8: IDENTIFIER ( WS )? LPAREN
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred108_Cpp2513); if (state.failed) return ;

        // Cpp.g:277:19: ( WS )?
        int alt85=2;
        int LA85_0 = input.LA(1);

        if ( (LA85_0==WS) ) {
            alt85=1;
        }
        switch (alt85) {
            case 1 :
                // Cpp.g:277:19: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred108_Cpp2515); if (state.failed) return ;

                }
                break;

        }


        match(input,LPAREN,FOLLOW_LPAREN_in_synpred108_Cpp2518); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred108_Cpp

    // $ANTLR start synpred110_Cpp
    public final void synpred110_Cpp_fragment() throws RecognitionException {
        // Cpp.g:278:7: ( primarySource ( WS )? SHARPSHARP )
        // Cpp.g:278:8: primarySource ( WS )? SHARPSHARP
        {
        pushFollow(FOLLOW_primarySource_in_synpred110_Cpp2531);
        primarySource();

        state._fsp--;
        if (state.failed) return ;

        // Cpp.g:278:23: ( WS )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==WS) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // Cpp.g:278:23: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred110_Cpp2534); if (state.failed) return ;

                }
                break;

        }


        match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_synpred110_Cpp2537); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred110_Cpp

    // $ANTLR start synpred112_Cpp
    public final void synpred112_Cpp_fragment() throws RecognitionException {
        // Cpp.g:280:7: ( primarySource )
        // Cpp.g:280:7: primarySource
        {
        pushFollow(FOLLOW_primarySource_in_synpred112_Cpp2574);
        primarySource();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred112_Cpp

    // $ANTLR start synpred115_Cpp
    public final void synpred115_Cpp_fragment() throws RecognitionException {
        // Cpp.g:283:14: ( macArgs )
        // Cpp.g:283:14: macArgs
        {
        pushFollow(FOLLOW_macArgs_in_synpred115_Cpp2600);
        macArgs();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred115_Cpp

    // $ANTLR start synpred122_Cpp
    public final void synpred122_Cpp_fragment() throws RecognitionException {
        List list_=null;
        RuleReturnScope  prim= null;
        // Cpp.g:291:28: ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )
        // Cpp.g:291:28: ( WS )? SHARPSHARP ( WS )? prim+= primarySource
        {
        // Cpp.g:291:28: ( WS )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==WS) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // Cpp.g:291:28: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred122_Cpp2667); if (state.failed) return ;

                }
                break;

        }


        match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_synpred122_Cpp2670); if (state.failed) return ;

        // Cpp.g:291:44: ( WS )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( (LA89_0==WS) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // Cpp.g:291:44: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred122_Cpp2673); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_primarySource_in_synpred122_Cpp2678);
        prim=primarySource();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_Cpp

    // Delegated rules

    public final boolean synpred94_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\27\uffff";
    static final String DFA14_eofS =
        "\2\uffff\2\4\1\uffff\1\4\1\uffff\1\4\3\uffff\2\4\2\uffff\4\4\2\uffff"+
        "\1\4\1\uffff";
    static final String DFA14_minS =
        "\1\25\1\63\2\15\1\uffff\1\15\1\0\1\15\1\uffff\1\0\1\uffff\2\15\2"+
        "\0\4\15\2\0\1\15\1\0";
    static final String DFA14_maxS =
        "\1\25\1\63\2\174\1\uffff\1\174\1\0\1\174\1\uffff\1\0\1\uffff\2\174"+
        "\2\0\4\174\2\0\1\174\1\0";
    static final String DFA14_acceptS =
        "\4\uffff\1\3\3\uffff\1\2\1\uffff\1\1\14\uffff";
    static final String DFA14_specialS =
        "\6\uffff\1\5\2\uffff\1\6\3\uffff\1\4\1\3\4\uffff\1\2\1\1\1\uffff"+
        "\1\0}>";
    static final String[] DFA14_transitionS = {
            "\1\1",
            "\1\2",
            "\2\4\1\uffff\1\4\2\uffff\2\4\25\uffff\1\4\2\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\15\uffff\1\4\1\uffff\1\3\16\uffff\1\4\17\uffff"+
            "\1\4\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff\1\4",
            "\2\4\1\uffff\1\4\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\7\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\6\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\5",
            "",
            "\2\4\1\uffff\1\4\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\7\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\11\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\4",
            "\1\uffff",
            "\2\4\1\uffff\1\14\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\15\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\13",
            "",
            "\1\uffff",
            "",
            "\2\4\1\uffff\1\14\2\uffff\2\4\25\uffff\1\4\2\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff\1\4\17\uffff"+
            "\1\16\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff\1\4",
            "\2\4\1\uffff\1\4\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\20\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\4\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\17",
            "\1\uffff",
            "\1\uffff",
            "\2\4\1\uffff\1\4\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\20\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\4\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\21",
            "\2\4\1\uffff\1\14\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\23\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\22",
            "\2\4\1\uffff\1\4\2\uffff\2\4\7\uffff\1\10\15\uffff\1\4\2\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\20\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\17\uffff\1\4\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff"+
            "\1\21",
            "\2\4\1\uffff\1\14\2\uffff\2\4\25\uffff\1\4\2\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff\1\4\17\uffff"+
            "\1\24\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff\1\25",
            "\1\uffff",
            "\1\uffff",
            "\2\4\1\uffff\1\14\2\uffff\2\4\25\uffff\1\4\2\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff\1\4\17\uffff"+
            "\1\26\2\uffff\2\4\4\uffff\1\4\2\uffff\4\4\12\uffff\1\25",
            "\1\uffff"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "76:1: macroDefine : ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? ) | DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? ) | DEFINE IDENTIFIER ( macro_text )? -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_22 = input.LA(1);

                         
                        int index14_22 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_22);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA14_20 = input.LA(1);

                         
                        int index14_20 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_20);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA14_19 = input.LA(1);

                         
                        int index14_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_19);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA14_14 = input.LA(1);

                         
                        int index14_14 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_14);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA14_13 = input.LA(1);

                         
                        int index14_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_13);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA14_6 = input.LA(1);

                         
                        int index14_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred13_Cpp()) ) {s = 10;}

                        else if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_6);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA14_9 = input.LA(1);

                         
                        int index14_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred13_Cpp()) ) {s = 10;}

                        else if ( (synpred21_Cpp()) ) {s = 8;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index14_9);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 
    
    public static final BitSet FOLLOW_procLine_in_preprocess268 = new BitSet(new long[]{0x018A240500B96002L,0x1A03C8644004000BL});
    public static final BitSet FOLLOW_DIRECTIVE_in_procLine294 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_text_line_in_procLine303 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_diagnostics_in_procLine312 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_fileInclusion_in_procLine320 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_macroDefine_in_procLine328 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_macroUndef_in_procLine336 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_lineControl_in_procLine344 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_macroExecution_in_procLine353 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_End_in_procLine363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_fileInclusion381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_EXPAND_in_fileInclusion397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_macroDefine424 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_macroDefine430 = new BitSet(new long[]{0x0000000000000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine433 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroDefine436 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_macro_text_in_macroDefine439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_macroDefine461 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_macroDefine470 = new BitSet(new long[]{0x0008000010000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine472 = new BitSet(new long[]{0x0008000010000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_macroParam_in_macroDefine480 = new BitSet(new long[]{0x0000000000010000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine483 = new BitSet(new long[]{0x0000000000010000L,0x0000000400000000L});
    public static final BitSet FOLLOW_COMMA_in_macroDefine487 = new BitSet(new long[]{0x0008000010000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine490 = new BitSet(new long[]{0x0008000010000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_macroParam_in_macroDefine495 = new BitSet(new long[]{0x0000000000010000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine497 = new BitSet(new long[]{0x0000000000010000L,0x1000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroDefine511 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_macro_text_in_macroDefine514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_macroDefine561 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine564 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_macro_text_in_macroDefine567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroParam615 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ELLIPSIS_in_macroParam617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELLIPSIS_in_macroParam633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroParam641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXEC_MACRO_in_macroExecution658 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_ifexpression_in_macroExecution660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDEF_in_macroUndef689 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroUndef693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_lineControl723 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_lineControl728 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_lineControl733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WARNING_in_diagnostics771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERROR_in_diagnostics785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRAGMA_in_diagnostics799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_text_in_text_line826 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_procLine_in_statement863 = new BitSet(new long[]{0x018A240500B96002L,0x1A03C8644004000BL});
    public static final BitSet FOLLOW_IDENTIFIER_in_type_name884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ifexpression901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ifexpression923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_ifexpression945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_assignmentExpression970 = new BitSet(new long[]{0x0000000002001582L,0x0020050000409000L});
    public static final BitSet FOLLOW_ASSIGNEQUAL_in_assignmentExpression982 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_TIMESEQUAL_in_assignmentExpression997 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_DIVIDEEQUAL_in_assignmentExpression1012 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_MODEQUAL_in_assignmentExpression1027 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_PLUSEQUAL_in_assignmentExpression1042 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_MINUSEQUAL_in_assignmentExpression1057 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_SHIFTLEFTEQUAL_in_assignmentExpression1072 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_SHIFTRIGHTEQUAL_in_assignmentExpression1087 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_BITWISEANDEQUAL_in_assignmentExpression1100 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_BITWISEXOREQUAL_in_assignmentExpression1113 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_BITWISEOREQUAL_in_assignmentExpression1126 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_assignmentExpression_in_assignmentExpression1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalOrExpression_in_conditionalExpression1171 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_QUESTIONMARK_in_conditionalExpression1182 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression1185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression1187 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalExpression1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalAndExpression_in_logicalOrExpression1209 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_OR_in_logicalOrExpression1212 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_logicalAndExpression_in_logicalOrExpression1215 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_logicalAndExpression1234 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_logicalAndExpression1237 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_logicalAndExpression1240 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1259 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_BITWISEOR_in_inclusiveOrExpression1262 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1265 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression1284 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_BITWISEXOR_in_exclusiveOrExpression1287 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression1290 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression1309 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AMPERSAND_in_andExpression1312 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression1315 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1334 = new BitSet(new long[]{0x0000000080000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_equalityExpression1338 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_EQUAL_in_equalityExpression1343 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1347 = new BitSet(new long[]{0x0000000080000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression1366 = new BitSet(new long[]{0x6001800000000002L});
    public static final BitSet FOLLOW_LESSTHAN_in_relationalExpression1380 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_GREATERTHAN_in_relationalExpression1395 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_LESSTHANOREQUALTO_in_relationalExpression1410 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_GREATERTHANOREQUALTO_in_relationalExpression1425 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression1448 = new BitSet(new long[]{0x6001800000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression1483 = new BitSet(new long[]{0x0000000000000002L,0x0000028000000000L});
    public static final BitSet FOLLOW_SHIFTLEFT_in_shiftExpression1487 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_SHIFTRIGHT_in_shiftExpression1492 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression1496 = new BitSet(new long[]{0x0000000000000002L,0x0000028000000000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1515 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200800L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression1519 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpression1524 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1528 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200800L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1547 = new BitSet(new long[]{0x0000000001000002L,0x0000200000004000L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression1551 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_DIVIDE_in_multiplicativeExpression1556 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_MOD_in_multiplicativeExpression1561 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1566 = new BitSet(new long[]{0x0000000001000002L,0x0000200000004000L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unaryExpression1585 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUSMINUS_in_unaryExpression1604 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_unaryExpression1623 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_unaryExpression1642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpression1645 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpression1647 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpression1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINED_in_unaryExpression1666 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpression1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINED_in_unaryExpression1688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpression1690 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpression1692 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpression1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpressionNotPlusMinus1728 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1751 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMPERSAND_in_unaryExpressionNotPlusMinus1774 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_unaryExpressionNotPlusMinus1793 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpressionNotPlusMinus1816 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpressionNotPlusMinus1836 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpressionNotPlusMinus1857 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpressionNotPlusMinus1859 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpressionNotPlusMinus1861 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpressionNotPlusMinus1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_postfixExpression1901 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_LSQUARE_in_postfixExpression1913 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_assignmentExpression_in_postfixExpression1919 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_RSQUARE_in_postfixExpression1921 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_DOT_in_postfixExpression1932 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression1940 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_STAR_in_postfixExpression1957 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression1962 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_BITWISEXOR_in_postfixExpression1986 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression1991 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_POINTERTO_in_postfixExpression2003 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression2006 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_PLUSPLUS_in_postfixExpression2018 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_MINUSMINUS_in_postfixExpression2036 = new BitSet(new long[]{0x0000000004000802L,0x0000200002802010L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpression2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primaryExpression2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primaryExpression2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression2117 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_assignmentExpression_in_primaryExpression2120 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall2153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_functionCall2155 = new BitSet(new long[]{0x000A200000502010L,0x0010A80400A52808L});
    public static final BitSet FOLLOW_argList_in_functionCall2157 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_functionCall2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_argList2191 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_argList2194 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_assignmentExpression_in_argList2196 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_sourceExpression_in_source_text2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_source_text2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_source_text2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RPAREN_in_source_text2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_source_text2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroExpansion2351 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000008L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2353 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_macroExpansion2356 = new BitSet(new long[]{0x0000000000000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2358 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroExpansion2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroExpansion2383 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000008L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_macroExpansion2388 = new BitSet(new long[]{0x000A200000196000L,0x1003C8600004000AL});
    public static final BitSet FOLLOW_WS_in_macroExpansion2390 = new BitSet(new long[]{0x000A200000196000L,0x1003C8600004000AL});
    public static final BitSet FOLLOW_macArgs_in_macroExpansion2393 = new BitSet(new long[]{0x0000000000000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2396 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroExpansion2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mArg_in_macArgs2428 = new BitSet(new long[]{0x0000000000010002L,0x1000000000000000L});
    public static final BitSet FOLLOW_WS_in_macArgs2432 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_macArgs2435 = new BitSet(new long[]{0x000A200000196000L,0x1003C8600004000AL});
    public static final BitSet FOLLOW_WS_in_macArgs2437 = new BitSet(new long[]{0x000A200000196000L,0x1003C8600004000AL});
    public static final BitSet FOLLOW_mArg_in_macArgs2442 = new BitSet(new long[]{0x0000000000010002L,0x1000000000000000L});
    public static final BitSet FOLLOW_sourceExpression_in_mArg2469 = new BitSet(new long[]{0x000A200000186002L,0x1003C8600004000AL});
    public static final BitSet FOLLOW_macroExpansion_in_sourceExpression2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatenate_in_sourceExpression2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGIFICATION_in_sourceExpression2552 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_sourceExpression2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_sourceExpression2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_OP_in_sourceExpression2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_sourceExpression2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_sourceExpression2598 = new BitSet(new long[]{0x000A200000196000L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_macArgs_in_sourceExpression2600 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_sourceExpression2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_sourceExpression2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_END_in_sourceExpression2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINECOMMENTS_in_sourceExpression2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_sourceExpression2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_concatenate2664 = new BitSet(new long[]{0x0000000000000000L,0x1000004000000000L});
    public static final BitSet FOLLOW_WS_in_concatenate2667 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_concatenate2670 = new BitSet(new long[]{0x000A200000186000L,0x1000804000040000L});
    public static final BitSet FOLLOW_WS_in_concatenate2673 = new BitSet(new long[]{0x000A200000186000L,0x0000804000040000L});
    public static final BitSet FOLLOW_primarySource_in_concatenate2678 = new BitSet(new long[]{0x0000000000000002L,0x1000004000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_primarySource2710 = new BitSet(new long[]{0x0008000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_WS_in_primarySource2712 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primarySource2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primarySource2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primarySource2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CKEYWORD_in_primarySource2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COPERATOR_in_primarySource2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_text_in_macro_text4914 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_DEFINE_in_synpred13_Cpp424 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred13_Cpp427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_synpred13_Cpp430 = new BitSet(new long[]{0x0000000000000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_synpred13_Cpp433 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred13_Cpp436 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_macro_text_in_synpred13_Cpp439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_synpred21_Cpp461 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred21_Cpp466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_synpred21_Cpp470 = new BitSet(new long[]{0x0008000010000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_synpred21_Cpp472 = new BitSet(new long[]{0x0008000010000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_macroParam_in_synpred21_Cpp480 = new BitSet(new long[]{0x0000000000010000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_synpred21_Cpp483 = new BitSet(new long[]{0x0000000000010000L,0x0000000400000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred21_Cpp487 = new BitSet(new long[]{0x0008000010000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred21_Cpp490 = new BitSet(new long[]{0x0008000010000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_macroParam_in_synpred21_Cpp495 = new BitSet(new long[]{0x0000000000010000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_synpred21_Cpp497 = new BitSet(new long[]{0x0000000000010000L,0x1000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred21_Cpp511 = new BitSet(new long[]{0x000A200000196002L,0x1003C8640004000AL});
    public static final BitSet FOLLOW_macro_text_in_synpred21_Cpp514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred30_Cpp901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred31_Cpp923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_synpred64_Cpp1623 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred64_Cpp1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_synpred65_Cpp1642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_synpred65_Cpp1645 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_type_name_in_synpred65_Cpp1647 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred65_Cpp1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred74_Cpp1857 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_type_name_in_synpred74_Cpp1859 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred74_Cpp1861 = new BitSet(new long[]{0x000A200000502010L,0x0010A80000A52808L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred74_Cpp1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred77_Cpp1957 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred77_Cpp1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BITWISEXOR_in_synpred78_Cpp1986 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred78_Cpp1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred82_Cpp2068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_synpred82_Cpp2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_synpred92_Cpp2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred94_Cpp2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred98_Cpp2351 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000008L});
    public static final BitSet FOLLOW_WS_in_synpred98_Cpp2353 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_synpred98_Cpp2356 = new BitSet(new long[]{0x0000000000000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_WS_in_synpred98_Cpp2358 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred98_Cpp2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_synpred100_Cpp2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_synpred103_Cpp2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_synpred105_Cpp2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_synpred106_Cpp2469 = new BitSet(new long[]{0x000A200000186002L,0x1003C8600004000AL});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred108_Cpp2513 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000008L});
    public static final BitSet FOLLOW_WS_in_synpred108_Cpp2515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_LPAREN_in_synpred108_Cpp2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_synpred110_Cpp2531 = new BitSet(new long[]{0x0000000000000000L,0x1000004000000000L});
    public static final BitSet FOLLOW_WS_in_synpred110_Cpp2534 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_synpred110_Cpp2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_synpred112_Cpp2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macArgs_in_synpred115_Cpp2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_synpred122_Cpp2667 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_synpred122_Cpp2670 = new BitSet(new long[]{0x000A200000186000L,0x1000804000040000L});
    public static final BitSet FOLLOW_WS_in_synpred122_Cpp2673 = new BitSet(new long[]{0x000A200000186000L,0x0000804000040000L});
    public static final BitSet FOLLOW_primarySource_in_synpred122_Cpp2678 = new BitSet(new long[]{0x0000000000000002L});

}