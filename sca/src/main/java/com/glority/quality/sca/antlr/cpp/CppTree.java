package com.glority.quality.sca.antlr.cpp;

// $ANTLR 3.4 CppTree.g 2012-09-18 12:22:07

	import	java.util.Set;
	import	java.lang.*;
	import 	java.util.HashSet;
	import java.util.Arrays;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CppTree extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AMPERSAND", "AND", "ARGS", "ASSIGNEQUAL", "BITWISEANDEQUAL", "BITWISEOR", "BITWISEOREQUAL", "BITWISEXOR", "BITWISEXOREQUAL", "CHARACTER_LITERAL", "CKEYWORD", "COLON", "COMMA", "COMMENT", "CONCATENATE", "COPERATOR", "DECIMAL_LITERAL", "DEFINE", "DEFINED", "DIRECTIVE", "DIVIDE", "DIVIDEEQUAL", "DOT", "DOTMBR", "ELIF", "ELLIPSIS", "ELSE", "ENDIF", "EQUAL", "ERROR", "ESCAPED_NEWLINE", "EXEC_MACRO", "EXPAND", "EXPR", "EXPR_DEF", "EXPR_GROUP", "EXPR_NDEF", "EXP_ARG", "EXP_ARGS", "End", "EscapeSequence", "Exponent", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "GREATERTHAN", "GREATERTHANOREQUALTO", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "IF", "IFDEF", "IFNDEF", "INCLUDE", "INCLUDE_EXPAND", "INCLUDE_FILE", "INDEX_OP", "IntegerTypeSuffix", "LCURLY", "LESSTHAN", "LESSTHANOREQUALTO", "LETTER", "LINE", "LINE_COMMENT", "LPAREN", "LSQUARE", "MACRO_DEFINE", "MACRO_TEXT", "MAC_FUNCTION", "MAC_FUNCTION_OBJECT", "MAC_OBJECT", "METHOD_CALL", "MINUS", "MINUSEQUAL", "MINUSMINUS", "MOD", "MODEQUAL", "NOT", "NOTEQUAL", "OCTAL_LITERAL", "OR", "OctalEscape", "PLUS", "PLUSEQUAL", "PLUSPLUS", "POINTER", "POINTERTO", "POINTERTOMBR", "POINTER_AT", "POST_DEC", "POST_INC", "PRAGMA", "QUESTIONMARK", "RCURLY", "REFERANCE", "RPAREN", "RSQUARE", "SCOPE", "SEMICOLON", "SHARPSHARP", "SHIFTLEFT", "SHIFTLEFTEQUAL", "SHIFTRIGHT", "SHIFTRIGHTEQUAL", "SIZEOF", "SIZEOF_TYPE", "STAR", "STRINGIFICATION", "STRING_LITERAL", "STRING_OP", "TEXT_END", "TEXT_GROUP", "TEXT_LINE", "TILDE", "TIMESEQUAL", "TYPECAST", "UNARY_MINUS", "UNARY_PLUS", "UNDEF", "UnicodeEscape", "WARNING", "WS", "BITWISERXOR"
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
    public static final int ELIF=28;
    public static final int ELLIPSIS=29;
    public static final int ELSE=30;
    public static final int ENDIF=31;
    public static final int EQUAL=32;
    public static final int ERROR=33;
    public static final int ESCAPED_NEWLINE=34;
    public static final int EXEC_MACRO=35;
    public static final int EXPAND=36;
    public static final int EXPR=37;
    public static final int EXPR_DEF=38;
    public static final int EXPR_GROUP=39;
    public static final int EXPR_NDEF=40;
    public static final int EXP_ARG=41;
    public static final int EXP_ARGS=42;
    public static final int End=43;
    public static final int EscapeSequence=44;
    public static final int Exponent=45;
    public static final int FLOATING_POINT_LITERAL=46;
    public static final int FloatTypeSuffix=47;
    public static final int GREATERTHAN=48;
    public static final int GREATERTHANOREQUALTO=49;
    public static final int HEX_LITERAL=50;
    public static final int HexDigit=51;
    public static final int IDENTIFIER=52;
    public static final int IF=53;
    public static final int IFDEF=54;
    public static final int IFNDEF=55;
    public static final int INCLUDE=56;
    public static final int INCLUDE_EXPAND=57;
    public static final int INCLUDE_FILE=58;
    public static final int INDEX_OP=59;
    public static final int IntegerTypeSuffix=60;
    public static final int LCURLY=61;
    public static final int LESSTHAN=62;
    public static final int LESSTHANOREQUALTO=63;
    public static final int LETTER=64;
    public static final int LINE=65;
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
    public static final int BITWISERXOR=125;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators

    protected static class Macros_scope {
        Map	 defines;
    }
    protected Stack Macros_stack = new Stack();



    public CppTree(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public CppTree(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return CppTree.tokenNames; }
    public String getGrammarFileName() { return "CppTree.g"; }


    	protected String fileName;
    	protected int	 lineNo=0;

    	class 	ExpressionReturn
    	{
    		int	   value;
    		String text;
    	}

    	class	MacroParameter
    	{
    		int		type;
    		String	text;
    	}

    	public	 CppTree(TreeNodeStream input,String filename) 
    	{
       		this(input);
    		this.fileName = filename; 
    	}

        protected static final String ONE = "1";

    // static global stack for macro definitions and macro call params..		

    	public static Stack Macrox_stack = new Stack();

        boolean isMacroDefined(String name) 
    	{ 
            for (int i = Macrox_stack.size()-1; i>=0; i--) {
                Macros_scope scope = (Macros_scope)Macrox_stack.get(i);
                if ( scope.defines.containsKey(name) ) 
    			{
                    return true;
                }       
            }       
            return false;
        }

        Object getMacroObject(String name) 
    	{ 
            for (int i = Macrox_stack.size()-1; i>=0; i--) {
                Macros_scope scope = (Macros_scope)Macrox_stack.get(i);
                if ( scope.defines.containsKey(name) ) 
    			{
    					return(scope.defines.get(name));
                }       
            }       
            return null;
    	}

        void putMacroObject(String name,Object Macro) 
    	{ 
            Macros_scope scope = (Macros_scope)Macrox_stack.get(0);
            if ( scope.defines.containsKey(name) ) 
    		{
    			System.out.println("MACRO OBJECT " + name + "redefined ");
            }       
    		scope.defines.put(name,Macro);
    	}

        void removeMacroObject(String name) 
    	{ 
            Macros_scope scope = (Macros_scope)Macrox_stack.get(0);
            if (!scope.defines.containsKey(name) ) 
    		{
    			System.out.println("REMOVE  undefined " + name );
            }       
    		scope.defines.remove(name);
    	}

    	void putMacroParameter(String name,Object parameter)
    	{
    		((Macros_scope)Macrox_stack.peek()).defines.put(name, parameter); 
    	}

    	public int Mod(int a, int b)
    	{
    		int c;
    		if(a<b) return a;
    		c = (a/b);
    		return (a - (c*b));
    	}

    // Functions form cdt..
        protected  String removedEscapedNewline(String macro_text)
    	{
    		int start, len;
    		char text[] = macro_text.toCharArray();

    		start = 0;
    		len   = text.length;

            if (CharArrayUtils.indexOf('\n', text, start, start + len) == -1)
                return new String(text);

            char[] result = new char[len];
            Arrays.fill(result, ' ');
            int counter = 0;
            for (int i = start; i < start + len; ++i) {
                if (text[i] == '\\' && i + 1 < text.length && text[i + 1] == '\n')
                    ++i;
                else if (text[i] == '\\' && i + 1 < text.length
                        && text[i + 1] == '\r' && i + 2 < text.length
                        && text[i + 2] == '\n')
                    i += 2;
                else
                    result[counter++] = text[i];
            }
            return new String(CharArrayUtils.trim(result));
        }

        protected String removeComment(String macro_text) 
    	{ 
    		char[] text = macro_text.toCharArray();
            char[] result = new char[text.length];

            Arrays.fill(result, ' ');
            int resultCount = 0;
            for (int i = 0; i < text.length; ++i) {
    			if (text[i] == '/' && (i+1 <text.length) && text[i+1] == '/')
    			{
    				break;	// Line Comment;
    			}
                if (text[i] == '/' && (i + 1 < text.length) && text[i + 1] == '*') {
                    i += 2;
                    while (i < text.length
                            && !(text[i] == '*' && i + 1 < text.length && text[i + 1] == '/'))
                        ++i;
                    ++i;
                } else
                    result[resultCount++] = text[i];

            }
            return new String(CharArrayUtils.trim(result));
    	}
    	final static public String trim(String text) 
    	{
                if (text == null) return null;
    			char[] chars =text.toCharArray();
        
                int start = 0, length = chars.length, end = length - 1;
                while (end > start && (chars[end] == ' '||chars[end]== '\t')) {
                    end--;
                }
    			if (end == 0)  return new String("");

                if( end != length - 1) {
                    return new String(CharArrayUtils.subarray(chars, start, end + 1));
                }
                return new String(chars);
    	}

    	



    // $ANTLR start "preprocess"
    // CppTree.g:175:1: preprocess : ( procLine[true] )+ ;
    public final void preprocess() throws RecognitionException {

        	Macrox_stack.push(new Macros_scope());
        	((Macros_scope)Macrox_stack.peek()).defines = new HashMap();

        try {
            // CppTree.g:181:3: ( ( procLine[true] )+ )
            // CppTree.g:181:6: ( procLine[true] )+
            {
            // CppTree.g:181:6: ( procLine[true] )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ERROR||LA1_0==EXEC_MACRO||LA1_0==End||LA1_0==IF||(LA1_0 >= INCLUDE && LA1_0 <= INCLUDE_EXPAND)||LA1_0==LINE||(LA1_0 >= MAC_FUNCTION && LA1_0 <= MAC_OBJECT)||LA1_0==PRAGMA||LA1_0==TEXT_LINE||LA1_0==UNDEF||LA1_0==WARNING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // CppTree.g:181:6: procLine[true]
            	    {
            	    pushFollow(FOLLOW_procLine_in_preprocess62);
            	    procLine(true);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) {
            				Macrox_stack.pop();
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
    // $ANTLR end "preprocess"



    // $ANTLR start "procLine"
    // CppTree.g:187:1: procLine[boolean condition] : ( fileInclusion[condition] | macroDefine[condition] | macroUndef[condition] | conditionalCompilation[condition] | lineControl[condition] | diagnostics[condition] | macroExecution |txt= text_line[condition,true] )? e= End ;
    public final void procLine(boolean condition) throws RecognitionException {
        CommonTree e=null;
        String txt =null;


        try {
            // CppTree.g:188:3: ( ( fileInclusion[condition] | macroDefine[condition] | macroUndef[condition] | conditionalCompilation[condition] | lineControl[condition] | diagnostics[condition] | macroExecution |txt= text_line[condition,true] )? e= End )
            // CppTree.g:189:3: ( fileInclusion[condition] | macroDefine[condition] | macroUndef[condition] | conditionalCompilation[condition] | lineControl[condition] | diagnostics[condition] | macroExecution |txt= text_line[condition,true] )? e= End
            {
            // CppTree.g:189:3: ( fileInclusion[condition] | macroDefine[condition] | macroUndef[condition] | conditionalCompilation[condition] | lineControl[condition] | diagnostics[condition] | macroExecution |txt= text_line[condition,true] )?
            int alt2=9;
            switch ( input.LA(1) ) {
                case INCLUDE:
                case INCLUDE_EXPAND:
                    {
                    alt2=1;
                    }
                    break;
                case MAC_FUNCTION:
                case MAC_FUNCTION_OBJECT:
                case MAC_OBJECT:
                    {
                    alt2=2;
                    }
                    break;
                case UNDEF:
                    {
                    alt2=3;
                    }
                    break;
                case IF:
                    {
                    alt2=4;
                    }
                    break;
                case LINE:
                    {
                    alt2=5;
                    }
                    break;
                case ERROR:
                case PRAGMA:
                case WARNING:
                    {
                    alt2=6;
                    }
                    break;
                case EXEC_MACRO:
                    {
                    alt2=7;
                    }
                    break;
                case TEXT_LINE:
                    {
                    alt2=8;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // CppTree.g:189:6: fileInclusion[condition]
                    {
                    pushFollow(FOLLOW_fileInclusion_in_procLine92);
                    fileInclusion(condition);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // CppTree.g:190:5: macroDefine[condition]
                    {
                    pushFollow(FOLLOW_macroDefine_in_procLine102);
                    macroDefine(condition);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // CppTree.g:191:5: macroUndef[condition]
                    {
                    pushFollow(FOLLOW_macroUndef_in_procLine113);
                    macroUndef(condition);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // CppTree.g:192:5: conditionalCompilation[condition]
                    {
                    pushFollow(FOLLOW_conditionalCompilation_in_procLine124);
                    conditionalCompilation(condition);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // CppTree.g:193:5: lineControl[condition]
                    {
                    pushFollow(FOLLOW_lineControl_in_procLine132);
                    lineControl(condition);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // CppTree.g:194:5: diagnostics[condition]
                    {
                    pushFollow(FOLLOW_diagnostics_in_procLine143);
                    diagnostics(condition);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // CppTree.g:195:5: macroExecution
                    {
                    pushFollow(FOLLOW_macroExecution_in_procLine156);
                    macroExecution();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // CppTree.g:196:8: txt= text_line[condition,true]
                    {
                    pushFollow(FOLLOW_text_line_in_procLine167);
                    txt=text_line(condition, true);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            e=(CommonTree)match(input,End,FOLLOW_End_in_procLine192); if (state.failed) return ;

            if ( state.backtracking==0 ) { if (condition == true) System.out.println("	// line	" + e.getLine() + " " + fileName); }

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
    // $ANTLR end "procLine"



    // $ANTLR start "fileInclusion"
    // CppTree.g:200:1: fileInclusion[ boolean condition] : (s= INCLUDE |inc= INCLUDE_EXPAND ) ;
    public final void fileInclusion(boolean condition) throws RecognitionException {
        CommonTree s=null;
        CommonTree inc=null;

         String filename=null;	
        try {
            // CppTree.g:202:4: ( (s= INCLUDE |inc= INCLUDE_EXPAND ) )
            // CppTree.g:203:3: (s= INCLUDE |inc= INCLUDE_EXPAND )
            {
            // CppTree.g:203:3: (s= INCLUDE |inc= INCLUDE_EXPAND )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INCLUDE) ) {
                alt3=1;
            }
            else if ( (LA3_0==INCLUDE_EXPAND) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // CppTree.g:203:5: s= INCLUDE
                    {
                    s=(CommonTree)match(input,INCLUDE,FOLLOW_INCLUDE_in_fileInclusion222); if (state.failed) return ;

                    if ( state.backtracking==0 ) {	filename = s.toString();	}

                    }
                    break;
                case 2 :
                    // CppTree.g:204:5: inc= INCLUDE_EXPAND
                    {
                    inc=(CommonTree)match(input,INCLUDE_EXPAND,FOLLOW_INCLUDE_EXPAND_in_fileInclusion234); if (state.failed) return ;

                    if ( state.backtracking==0 ) {
                    				if(isMacroDefined(inc.toString()))
                    				{
                    					Object expObject = getMacroObject(inc.toString());
                    					if(expObject instanceof ObjectMacro)
                    					{
                    						filename = ((ObjectMacro)expObject).getExpansion();
                    					}
                    				}
                    				else
                    				{
                    					filename  = inc.toString();
                    				}
                    				// modify filename which is local path...
                    			}

                    }
                    break;

            }


            if ( state.backtracking==0 ) { 	
            			if(condition == true)
            			{
            				try
                       		{
                           		CppLexer iLexer = new CppLexer(new ANTLRFileStream(filename));
            					TokenRewriteStream itokens = new TokenRewriteStream(iLexer);
                           		itokens.LT(1);

                           		CppParser iParser = new CppParser(itokens);
                           		CppParser.preprocess_return iret = iParser.preprocess();

                           		CommonTreeNodeStream inodes = new CommonTreeNodeStream((Tree)iret.tree);
            					CppTree iwalker = new CppTree(inodes,filename);
            					iwalker.preprocess();
                       		}
                       		catch (Exception ex)
                       		{
                           		System.out.println(ex);
                       		}       
            			}
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
    // $ANTLR end "fileInclusion"



    // $ANTLR start "macroDefine"
    // CppTree.g:245:1: macroDefine[boolean condition] : ( ^( MAC_FUNCTION_OBJECT id= IDENTIFIER m= macroText ) | ^( MAC_FUNCTION id= IDENTIFIER (p= macroParam )+ m= macroText ) | ^( MAC_OBJECT id= IDENTIFIER m= macroText ) );
    public final void macroDefine(boolean condition) throws RecognitionException {
        CommonTree id=null;
        String m =null;

        MacroParameter p =null;


         
        	String	macro_text	=	null; 
        	List 	params		=	new ArrayList();

        try {
            // CppTree.g:251:4: ( ^( MAC_FUNCTION_OBJECT id= IDENTIFIER m= macroText ) | ^( MAC_FUNCTION id= IDENTIFIER (p= macroParam )+ m= macroText ) | ^( MAC_OBJECT id= IDENTIFIER m= macroText ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case MAC_FUNCTION_OBJECT:
                {
                alt5=1;
                }
                break;
            case MAC_FUNCTION:
                {
                alt5=2;
                }
                break;
            case MAC_OBJECT:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // CppTree.g:251:6: ^( MAC_FUNCTION_OBJECT id= IDENTIFIER m= macroText )
                    {
                    match(input,MAC_FUNCTION_OBJECT,FOLLOW_MAC_FUNCTION_OBJECT_in_macroDefine272); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine276); if (state.failed) return ;

                    pushFollow(FOLLOW_macroText_in_macroDefine280);
                    m=macroText();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    if ( state.backtracking==0 ) {
                    				if(condition == true)
                    				{
                    					FunctionMacro fncMac = new FunctionMacro(id.toString(),m.toString());
                    					putMacroObject(id.toString(),fncMac);
                    				}
                    			}

                    }
                    break;
                case 2 :
                    // CppTree.g:259:5: ^( MAC_FUNCTION id= IDENTIFIER (p= macroParam )+ m= macroText )
                    {
                    match(input,MAC_FUNCTION,FOLLOW_MAC_FUNCTION_in_macroDefine293); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine297); if (state.failed) return ;

                    // CppTree.g:259:35: (p= macroParam )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==ELLIPSIS||LA4_0==IDENTIFIER) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // CppTree.g:259:37: p= macroParam
                    	    {
                    	    pushFollow(FOLLOW_macroParam_in_macroDefine304);
                    	    p=macroParam();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    if ( state.backtracking==0 ) {params.add(p);	}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    pushFollow(FOLLOW_macroText_in_macroDefine312);
                    m=macroText();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    if ( state.backtracking==0 ) {
                    				if(condition == true)
                    				{
                    					FunctionMacro fncMac = new FunctionMacro(id.toString(),params,m.toString());
                    					putMacroObject(id.toString(),fncMac);
                    				}
                    			}

                    }
                    break;
                case 3 :
                    // CppTree.g:267:5: ^( MAC_OBJECT id= IDENTIFIER m= macroText )
                    {
                    match(input,MAC_OBJECT,FOLLOW_MAC_OBJECT_in_macroDefine325); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine329); if (state.failed) return ;

                    pushFollow(FOLLOW_macroText_in_macroDefine334);
                    m=macroText();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    if ( state.backtracking==0 ) {
                    				if(condition == true)
                    				{
                    					ObjectMacro objMac = new ObjectMacro(id.toString(),m.toString());
                    					putMacroObject(id.toString(),objMac);
                    				}
                    			}

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
    // $ANTLR end "macroDefine"



    // $ANTLR start "macroParam"
    // CppTree.g:277:1: macroParam returns [MacroParameter param] : ( ^( ELLIPSIS i= IDENTIFIER ) |e= ELLIPSIS |i= IDENTIFIER );
    public final MacroParameter macroParam() throws RecognitionException {
        MacroParameter param = null;


        CommonTree i=null;
        CommonTree e=null;

        param = new MacroParameter();
        try {
            // CppTree.g:279:3: ( ^( ELLIPSIS i= IDENTIFIER ) |e= ELLIPSIS |i= IDENTIFIER )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ELLIPSIS) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    alt6=1;
                }
                else if ( (LA6_1==EOF||LA6_1==UP||LA6_1==ELLIPSIS||LA6_1==IDENTIFIER||LA6_1==MACRO_DEFINE) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return param;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA6_0==IDENTIFIER) ) {
                alt6=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return param;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // CppTree.g:279:5: ^( ELLIPSIS i= IDENTIFIER )
                    {
                    match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_macroParam364); if (state.failed) return param;

                    match(input, Token.DOWN, null); if (state.failed) return param;
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroParam368); if (state.failed) return param;

                    match(input, Token.UP, null); if (state.failed) return param;


                    if ( state.backtracking==0 ) {
                    				param.type = EXP_ARGS;
                    				param.text = i.getText();
                    			}

                    }
                    break;
                case 2 :
                    // CppTree.g:284:5: e= ELLIPSIS
                    {
                    e=(CommonTree)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_macroParam382); if (state.failed) return param;

                    if ( state.backtracking==0 ) {
                    				param.type = ELLIPSIS;
                    				param.text = new String("__VA_ARGS__");
                    			}

                    }
                    break;
                case 3 :
                    // CppTree.g:289:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroParam397); if (state.failed) return param;

                    if ( state.backtracking==0 ) {
                    				param.type = IDENTIFIER;
                    				param.text = i.getText();
                    			}

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
        return param;
    }
    // $ANTLR end "macroParam"



    // $ANTLR start "macroText"
    // CppTree.g:296:1: macroText returns [String mtext] : ( ^( MACRO_DEFINE (src= source_text[false] )+ ) |);
    public final String macroText() throws RecognitionException {
        String mtext = null;


        String src =null;


         mtext = new String("");	
        try {
            // CppTree.g:298:3: ( ^( MACRO_DEFINE (src= source_text[false] )+ ) |)
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==MACRO_DEFINE) ) {
                alt8=1;
            }
            else if ( (LA8_0==UP) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return mtext;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // CppTree.g:298:5: ^( MACRO_DEFINE (src= source_text[false] )+ )
                    {
                    match(input,MACRO_DEFINE,FOLLOW_MACRO_DEFINE_in_macroText426); if (state.failed) return mtext;

                    match(input, Token.DOWN, null); if (state.failed) return mtext;
                    // CppTree.g:298:20: (src= source_text[false] )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= CHARACTER_LITERAL && LA7_0 <= CKEYWORD)||LA7_0==COMMA||(LA7_0 >= CONCATENATE && LA7_0 <= DECIMAL_LITERAL)||LA7_0==EXPAND||LA7_0==FLOATING_POINT_LITERAL||LA7_0==HEX_LITERAL||LA7_0==IDENTIFIER||LA7_0==LPAREN||LA7_0==OCTAL_LITERAL||LA7_0==RPAREN||(LA7_0 >= SEMICOLON && LA7_0 <= SHARPSHARP)||LA7_0==SIZEOF||(LA7_0 >= STRINGIFICATION && LA7_0 <= TEXT_GROUP)||LA7_0==WS) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // CppTree.g:298:21: src= source_text[false]
                    	    {
                    	    pushFollow(FOLLOW_source_text_in_macroText431);
                    	    src=source_text(false);

                    	    state._fsp--;
                    	    if (state.failed) return mtext;

                    	    if ( state.backtracking==0 ) {
                    	    					mtext += src; 
                    	    			}

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return mtext;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return mtext;


                    if ( state.backtracking==0 ) {
                          			mtext  = removedEscapedNewline(mtext);
                    				mtext  = trim(mtext);
                    			}

                    }
                    break;
                case 2 :
                    // CppTree.g:307:5: 
                    {
                    if ( state.backtracking==0 ) {mtext = new String(" ");}

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
        return mtext;
    }
    // $ANTLR end "macroText"



    // $ANTLR start "macroUndef"
    // CppTree.g:311:1: macroUndef[boolean condition] : ^( UNDEF mac= IDENTIFIER ) ;
    public final void macroUndef(boolean condition) throws RecognitionException {
        CommonTree mac=null;

        try {
            // CppTree.g:312:3: ( ^( UNDEF mac= IDENTIFIER ) )
            // CppTree.g:312:5: ^( UNDEF mac= IDENTIFIER )
            {
            match(input,UNDEF,FOLLOW_UNDEF_in_macroUndef472); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            mac=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroUndef476); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==0 ) {
            				if(condition == true)
            				{
            					removeMacroObject(mac.toString());
            				}
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
    // $ANTLR end "macroUndef"



    // $ANTLR start "conditionalCompilation"
    // CppTree.g:321:1: conditionalCompilation[boolean condition] : ^( IF (a= expression statement[condition && subCondition ] )+ ( ELSE statement[condition && (!ifMatched)] )? ) ;
    public final void conditionalCompilation(boolean condition) throws RecognitionException {
        int a =0;


        	
        		boolean ifMatched=false;
        		boolean subCondition=false;
        	  
        try {
            // CppTree.g:326:3: ( ^( IF (a= expression statement[condition && subCondition ] )+ ( ELSE statement[condition && (!ifMatched)] )? ) )
            // CppTree.g:326:5: ^( IF (a= expression statement[condition && subCondition ] )+ ( ELSE statement[condition && (!ifMatched)] )? )
            {
            match(input,IF,FOLLOW_IF_in_conditionalCompilation504); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // CppTree.g:327:7: (a= expression statement[condition && subCondition ] )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= EXPR && LA9_0 <= EXPR_DEF)||LA9_0==EXPR_NDEF) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // CppTree.g:327:9: a= expression statement[condition && subCondition ]
            	    {
            	    pushFollow(FOLLOW_expression_in_conditionalCompilation517);
            	    a=expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    if ( state.backtracking==0 ) {	
            	    					if(ifMatched == true ) subCondition = false;
            	    					else subCondition = ((a != 0 ) ? true: false);  
            	    					if(subCondition == true) ifMatched =true; 
            	    				}

            	    pushFollow(FOLLOW_statement_in_conditionalCompilation530);
            	    statement(condition && subCondition);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            // CppTree.g:335:4: ( ELSE statement[condition && (!ifMatched)] )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ELSE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // CppTree.g:335:5: ELSE statement[condition && (!ifMatched)]
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_conditionalCompilation547); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_conditionalCompilation549);
                    statement(condition  && (!ifMatched));

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


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
    // $ANTLR end "conditionalCompilation"



    // $ANTLR start "lineControl"
    // CppTree.g:338:1: lineControl[boolean condition] : ^( LINE n= DECIMAL_LITERAL (s= STRING_LITERAL |) ) ;
    public final void lineControl(boolean condition) throws RecognitionException {
        CommonTree n=null;
        CommonTree s=null;


        	String  file=null;

        try {
            // CppTree.g:343:3: ( ^( LINE n= DECIMAL_LITERAL (s= STRING_LITERAL |) ) )
            // CppTree.g:343:5: ^( LINE n= DECIMAL_LITERAL (s= STRING_LITERAL |) )
            {
            match(input,LINE,FOLLOW_LINE_in_lineControl579); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            n=(CommonTree)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_lineControl583); if (state.failed) return ;

            // CppTree.g:344:5: (s= STRING_LITERAL |)
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==STRING_LITERAL) ) {
                alt11=1;
            }
            else if ( (LA11_0==UP) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // CppTree.g:344:7: s= STRING_LITERAL
                    {
                    s=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_lineControl594); if (state.failed) return ;

                    if ( state.backtracking==0 ) { file = s.toString();	}

                    }
                    break;
                case 2 :
                    // CppTree.g:345:12: 
                    {
                    if ( state.backtracking==0 ) { file = null; }

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==0 ) {
            				if(condition == true)
            				{
            					if(file == null) System.out.println("LINE : "+n.toString());
            					else 			 System.out.println("LINE : "+n.toString()  +" FILE: "+ file);
            				}
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
    // $ANTLR end "lineControl"



    // $ANTLR start "diagnostics"
    // CppTree.g:357:1: diagnostics[boolean condition] : (s= WARNING |s= ERROR |s= PRAGMA );
    public final void diagnostics(boolean condition) throws RecognitionException {
        CommonTree s=null;

        try {
            // CppTree.g:358:4: (s= WARNING |s= ERROR |s= PRAGMA )
            int alt12=3;
            switch ( input.LA(1) ) {
            case WARNING:
                {
                alt12=1;
                }
                break;
            case ERROR:
                {
                alt12=2;
                }
                break;
            case PRAGMA:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // CppTree.g:358:6: s= WARNING
                    {
                    s=(CommonTree)match(input,WARNING,FOLLOW_WARNING_in_diagnostics645); if (state.failed) return ;

                    if ( state.backtracking==0 ) { if(condition)	{	 System.out.println("warning: " + s);	} }

                    }
                    break;
                case 2 :
                    // CppTree.g:359:5: s= ERROR
                    {
                    s=(CommonTree)match(input,ERROR,FOLLOW_ERROR_in_diagnostics656); if (state.failed) return ;

                    if ( state.backtracking==0 ) { if(condition)	{	 System.out.println("error: " +  s);	} }

                    }
                    break;
                case 3 :
                    // CppTree.g:360:5: s= PRAGMA
                    {
                    s=(CommonTree)match(input,PRAGMA,FOLLOW_PRAGMA_in_diagnostics667); if (state.failed) return ;

                    if ( state.backtracking==0 ) { if(condition)	{	 System.out.println(s);	} }

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
    // $ANTLR end "diagnostics"



    // $ANTLR start "text_line"
    // CppTree.g:363:1: text_line[boolean condition,boolean out] returns [String text] : ^( TEXT_LINE (src= source_text[true] )+ ) ;
    public final String text_line(boolean condition, boolean out) throws RecognitionException {
        String text = null;


        String src =null;


         text = new String("");	
        try {
            // CppTree.g:365:3: ( ^( TEXT_LINE (src= source_text[true] )+ ) )
            // CppTree.g:365:5: ^( TEXT_LINE (src= source_text[true] )+ )
            {
            match(input,TEXT_LINE,FOLLOW_TEXT_LINE_in_text_line694); if (state.failed) return text;

            match(input, Token.DOWN, null); if (state.failed) return text;
            // CppTree.g:365:17: (src= source_text[true] )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= CHARACTER_LITERAL && LA13_0 <= CKEYWORD)||LA13_0==COMMA||(LA13_0 >= CONCATENATE && LA13_0 <= DECIMAL_LITERAL)||LA13_0==EXPAND||LA13_0==FLOATING_POINT_LITERAL||LA13_0==HEX_LITERAL||LA13_0==IDENTIFIER||LA13_0==LPAREN||LA13_0==OCTAL_LITERAL||LA13_0==RPAREN||(LA13_0 >= SEMICOLON && LA13_0 <= SHARPSHARP)||LA13_0==SIZEOF||(LA13_0 >= STRINGIFICATION && LA13_0 <= TEXT_GROUP)||LA13_0==WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // CppTree.g:365:18: src= source_text[true]
            	    {
            	    pushFollow(FOLLOW_source_text_in_text_line699);
            	    src=source_text(true);

            	    state._fsp--;
            	    if (state.failed) return text;

            	    if ( state.backtracking==0 ) {
            	    				if(condition == true) 
            	    				{ 	
            	    					text += src; 
            	    				 	if(out) {	System.out.print(src);	} 		
            	    				}
            	    			}

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return text;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return text;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return text;
    }
    // $ANTLR end "text_line"



    // $ANTLR start "statement"
    // CppTree.g:376:1: statement[boolean condition] : ( procLine[condition] )+ ;
    public final void statement(boolean condition) throws RecognitionException {
        try {
            // CppTree.g:377:3: ( ( procLine[condition] )+ )
            // CppTree.g:377:5: ( procLine[condition] )+
            {
            // CppTree.g:377:5: ( procLine[condition] )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ERROR||LA14_0==EXEC_MACRO||LA14_0==End||LA14_0==IF||(LA14_0 >= INCLUDE && LA14_0 <= INCLUDE_EXPAND)||LA14_0==LINE||(LA14_0 >= MAC_FUNCTION && LA14_0 <= MAC_OBJECT)||LA14_0==PRAGMA||LA14_0==TEXT_LINE||LA14_0==UNDEF||LA14_0==WARNING) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // CppTree.g:377:5: procLine[condition]
            	    {
            	    pushFollow(FOLLOW_procLine_in_statement729);
            	    procLine(condition);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
    // $ANTLR end "statement"



    // $ANTLR start "source_text"
    // CppTree.g:380:1: source_text[boolean expand] returns [String stext] : (m= macroExpansion[expand] |m= primarySource[expand] |m= concatenate[expand] |t= SEMICOLON |t= COMMA |t= RPAREN |t= LPAREN |t= STRING_OP |t= WS | TEXT_GROUP |t= TEXT_END | ^( TEXT_GROUP lst= macArgs[expand] ) | ^( STRINGIFICATION m= primarySource[expand] ) ) ;
    public final String source_text(boolean expand) throws RecognitionException {
        String stext = null;


        CommonTree t=null;
        String m =null;

        List lst =null;


        try {
            // CppTree.g:382:3: ( (m= macroExpansion[expand] |m= primarySource[expand] |m= concatenate[expand] |t= SEMICOLON |t= COMMA |t= RPAREN |t= LPAREN |t= STRING_OP |t= WS | TEXT_GROUP |t= TEXT_END | ^( TEXT_GROUP lst= macArgs[expand] ) | ^( STRINGIFICATION m= primarySource[expand] ) ) )
            // CppTree.g:383:3: (m= macroExpansion[expand] |m= primarySource[expand] |m= concatenate[expand] |t= SEMICOLON |t= COMMA |t= RPAREN |t= LPAREN |t= STRING_OP |t= WS | TEXT_GROUP |t= TEXT_END | ^( TEXT_GROUP lst= macArgs[expand] ) | ^( STRINGIFICATION m= primarySource[expand] ) )
            {
            // CppTree.g:383:3: (m= macroExpansion[expand] |m= primarySource[expand] |m= concatenate[expand] |t= SEMICOLON |t= COMMA |t= RPAREN |t= LPAREN |t= STRING_OP |t= WS | TEXT_GROUP |t= TEXT_END | ^( TEXT_GROUP lst= macArgs[expand] ) | ^( STRINGIFICATION m= primarySource[expand] ) )
            int alt15=13;
            switch ( input.LA(1) ) {
            case EXPAND:
                {
                alt15=1;
                }
                break;
            case CHARACTER_LITERAL:
            case CKEYWORD:
            case COPERATOR:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case OCTAL_LITERAL:
            case SHARPSHARP:
            case SIZEOF:
            case STRING_LITERAL:
                {
                alt15=2;
                }
                break;
            case CONCATENATE:
                {
                alt15=3;
                }
                break;
            case SEMICOLON:
                {
                alt15=4;
                }
                break;
            case COMMA:
                {
                alt15=5;
                }
                break;
            case RPAREN:
                {
                alt15=6;
                }
                break;
            case LPAREN:
                {
                alt15=7;
                }
                break;
            case STRING_OP:
                {
                alt15=8;
                }
                break;
            case WS:
                {
                alt15=9;
                }
                break;
            case TEXT_GROUP:
                {
                int LA15_10 = input.LA(2);

                if ( (LA15_10==DOWN) ) {
                    alt15=12;
                }
                else if ( (LA15_10==EOF||LA15_10==UP||(LA15_10 >= CHARACTER_LITERAL && LA15_10 <= CKEYWORD)||LA15_10==COMMA||(LA15_10 >= CONCATENATE && LA15_10 <= DECIMAL_LITERAL)||LA15_10==EXPAND||LA15_10==FLOATING_POINT_LITERAL||LA15_10==HEX_LITERAL||LA15_10==IDENTIFIER||LA15_10==LPAREN||LA15_10==OCTAL_LITERAL||LA15_10==RPAREN||(LA15_10 >= SEMICOLON && LA15_10 <= SHARPSHARP)||LA15_10==SIZEOF||(LA15_10 >= STRINGIFICATION && LA15_10 <= TEXT_GROUP)||LA15_10==WS) ) {
                    alt15=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return stext;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 10, input);

                    throw nvae;

                }
                }
                break;
            case TEXT_END:
                {
                alt15=11;
                }
                break;
            case STRINGIFICATION:
                {
                alt15=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return stext;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // CppTree.g:383:7: m= macroExpansion[expand]
                    {
                    pushFollow(FOLLOW_macroExpansion_in_source_text764);
                    m=macroExpansion(expand);

                    state._fsp--;
                    if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = m; 	}

                    }
                    break;
                case 2 :
                    // CppTree.g:384:7: m= primarySource[expand]
                    {
                    pushFollow(FOLLOW_primarySource_in_source_text777);
                    m=primarySource(expand);

                    state._fsp--;
                    if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = m;	}

                    }
                    break;
                case 3 :
                    // CppTree.g:385:5: m= concatenate[expand]
                    {
                    pushFollow(FOLLOW_concatenate_in_source_text789);
                    m=concatenate(expand);

                    state._fsp--;
                    if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = m;	}

                    }
                    break;
                case 4 :
                    // CppTree.g:386:7: t= SEMICOLON
                    {
                    t=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_source_text803); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 5 :
                    // CppTree.g:387:7: t= COMMA
                    {
                    t=(CommonTree)match(input,COMMA,FOLLOW_COMMA_in_source_text817); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 6 :
                    // CppTree.g:388:7: t= RPAREN
                    {
                    t=(CommonTree)match(input,RPAREN,FOLLOW_RPAREN_in_source_text834); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 7 :
                    // CppTree.g:389:7: t= LPAREN
                    {
                    t=(CommonTree)match(input,LPAREN,FOLLOW_LPAREN_in_source_text850); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 8 :
                    // CppTree.g:390:7: t= STRING_OP
                    {
                    t=(CommonTree)match(input,STRING_OP,FOLLOW_STRING_OP_in_source_text866); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = "#_#_" + t.getText();	}

                    }
                    break;
                case 9 :
                    // CppTree.g:391:7: t= WS
                    {
                    t=(CommonTree)match(input,WS,FOLLOW_WS_in_source_text880); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 10 :
                    // CppTree.g:392:5: TEXT_GROUP
                    {
                    match(input,TEXT_GROUP,FOLLOW_TEXT_GROUP_in_source_text893); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = "()";			}

                    }
                    break;
                case 11 :
                    // CppTree.g:393:7: t= TEXT_END
                    {
                    t=(CommonTree)match(input,TEXT_END,FOLLOW_TEXT_END_in_source_text907); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { 	if(expand)
                    				{	
                    					stext = t.getText(); ++lineNo;	
                    				}
                    				else	stext ="";
                    			}

                    }
                    break;
                case 12 :
                    // CppTree.g:400:5: ^( TEXT_GROUP lst= macArgs[expand] )
                    {
                    match(input,TEXT_GROUP,FOLLOW_TEXT_GROUP_in_source_text922); if (state.failed) return stext;

                    match(input, Token.DOWN, null); if (state.failed) return stext;
                    pushFollow(FOLLOW_macArgs_in_source_text926);
                    lst=macArgs(expand);

                    state._fsp--;
                    if (state.failed) return stext;

                    match(input, Token.UP, null); if (state.failed) return stext;


                    if ( state.backtracking==0 ) {
                    				
                    				stext = "(";
                    			    for (int i=0; i<lst.size(); i++)
                    				{
                    					ExpressionReturn exp = (ExpressionReturn)lst.get(i);
                    					stext  += exp.text;
                    					if( i != lst.size()-1) stext += ",";
                    				}
                    				stext += ")";
                    			}

                    }
                    break;
                case 13 :
                    // CppTree.g:412:7: ^( STRINGIFICATION m= primarySource[expand] )
                    {
                    match(input,STRINGIFICATION,FOLLOW_STRINGIFICATION_in_source_text942); if (state.failed) return stext;

                    match(input, Token.DOWN, null); if (state.failed) return stext;
                    pushFollow(FOLLOW_primarySource_in_source_text947);
                    m=primarySource(expand);

                    state._fsp--;
                    if (state.failed) return stext;

                    match(input, Token.UP, null); if (state.failed) return stext;


                    if ( state.backtracking==0 ) { stext = "\"" + m + "\"";}

                    }
                    break;

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
        return stext;
    }
    // $ANTLR end "source_text"



    // $ANTLR start "concatenate"
    // CppTree.g:418:1: concatenate[boolean expand] returns [String stext] : ^( CONCATENATE (a= primarySource[expand] )+ ) ;
    public final String concatenate(boolean expand) throws RecognitionException {
        String stext = null;


        String a =null;


         stext = "";	int i=0;	
        try {
            // CppTree.g:420:3: ( ^( CONCATENATE (a= primarySource[expand] )+ ) )
            // CppTree.g:421:3: ^( CONCATENATE (a= primarySource[expand] )+ )
            {
            match(input,CONCATENATE,FOLLOW_CONCATENATE_in_concatenate988); if (state.failed) return stext;

            match(input, Token.DOWN, null); if (state.failed) return stext;
            // CppTree.g:422:4: (a= primarySource[expand] )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= CHARACTER_LITERAL && LA16_0 <= CKEYWORD)||(LA16_0 >= COPERATOR && LA16_0 <= DECIMAL_LITERAL)||LA16_0==FLOATING_POINT_LITERAL||LA16_0==HEX_LITERAL||LA16_0==IDENTIFIER||LA16_0==OCTAL_LITERAL||LA16_0==SHARPSHARP||LA16_0==SIZEOF||LA16_0==STRING_LITERAL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // CppTree.g:422:5: a= primarySource[expand]
            	    {
            	    pushFollow(FOLLOW_primarySource_in_concatenate997);
            	    a=primarySource(expand);

            	    state._fsp--;
            	    if (state.failed) return stext;

            	    if ( state.backtracking==0 ) { 
            	    				if(expand == false)
            	    				{ 
            	    					if(i==0) stext = a;
            	    					else stext = stext + " ## " +  a;
            	    					i++;
            	    				}
            	    				else stext += a; 
            	    			}

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return stext;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return stext;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return stext;
    }
    // $ANTLR end "concatenate"



    // $ANTLR start "primarySource"
    // CppTree.g:436:1: primarySource[boolean expand] returns [String stext] : (c= constant[false] |t= COPERATOR |t= CKEYWORD |t= SIZEOF | ^( SHARPSHARP id= IDENTIFIER ) |id= IDENTIFIER );
    public final String primarySource(boolean expand) throws RecognitionException {
        String stext = null;


        CommonTree t=null;
        CommonTree id=null;
        ExpressionReturn c =null;


        try {
            // CppTree.g:438:3: (c= constant[false] |t= COPERATOR |t= CKEYWORD |t= SIZEOF | ^( SHARPSHARP id= IDENTIFIER ) |id= IDENTIFIER )
            int alt17=6;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt17=1;
                }
                break;
            case COPERATOR:
                {
                alt17=2;
                }
                break;
            case CKEYWORD:
                {
                alt17=3;
                }
                break;
            case SIZEOF:
                {
                alt17=4;
                }
                break;
            case SHARPSHARP:
                {
                alt17=5;
                }
                break;
            case IDENTIFIER:
                {
                alt17=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return stext;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // CppTree.g:438:7: c= constant[false]
                    {
                    pushFollow(FOLLOW_constant_in_primarySource1042);
                    c=constant(false);

                    state._fsp--;
                    if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = c.text;		}

                    }
                    break;
                case 2 :
                    // CppTree.g:439:7: t= COPERATOR
                    {
                    t=(CommonTree)match(input,COPERATOR,FOLLOW_COPERATOR_in_primarySource1056); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 3 :
                    // CppTree.g:440:5: t= CKEYWORD
                    {
                    t=(CommonTree)match(input,CKEYWORD,FOLLOW_CKEYWORD_in_primarySource1068); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 4 :
                    // CppTree.g:441:7: t= SIZEOF
                    {
                    t=(CommonTree)match(input,SIZEOF,FOLLOW_SIZEOF_in_primarySource1082); if (state.failed) return stext;

                    if ( state.backtracking==0 ) { stext = t.getText();	}

                    }
                    break;
                case 5 :
                    // CppTree.g:442:7: ^( SHARPSHARP id= IDENTIFIER )
                    {
                    match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_primarySource1096); if (state.failed) return stext;

                    match(input, Token.DOWN, null); if (state.failed) return stext;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primarySource1101); if (state.failed) return stext;

                    match(input, Token.UP, null); if (state.failed) return stext;


                    if ( state.backtracking==0 ) {
                    				if(expand)
                    				{
                    					if(isMacroDefined(id.toString()))
                                   		{
                    						Object expObject = getMacroObject(id.toString());
                    	
                    						if( expObject instanceof ExpressionReturn)
                    						{
                    							stext  = ((ExpressionReturn)expObject).text;
                    							if(stext.equals("__VA_ARGS__")) stext = "__VA_ARGS_EMPTY__";
                    						}
                    						else
                    						{
                    							System.out.println("Not Expected Argument Type : " + id.toString());
                    							stext  = "##" + id.toString() ;
                    						}
                    					}
                    					else
                    					{
                    							stext  = "##" + id.toString() ;
                    					}
                    				}
                    				else
                    				{
                    					stext = "##" + id.toString() ; // make String function to handle Escape sequence...
                    				}
                    			}

                    }
                    break;
                case 6 :
                    // CppTree.g:471:7: id= IDENTIFIER
                    {
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primarySource1117); if (state.failed) return stext;

                    if ( state.backtracking==0 ) {
                    				if(expand)
                    				{
                    					if(isMacroDefined(id.toString()))
                                   		{
                    						Object expObject = getMacroObject(id.toString());
                    	
                    						if(expObject instanceof ObjectMacro)
                    						{
                       	                    	stext = ((ObjectMacro)expObject).getExpansion();
                    						}
                    						else if( expObject instanceof ExpressionReturn)
                    						{
                    							stext  = ((ExpressionReturn)expObject).text;
                    						}
                    						else if( expObject instanceof FunctionMacro)
                    						{
                    							stext  = id.toString() ;
                    						}
                    					}
                    					else
                    					{
                    						stext = id.toString();
                    					}
                    				}
                    				else
                    				{
                    						stext = id.toString();
                    				}
                    			}

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
        return stext;
    }
    // $ANTLR end "primarySource"



    // $ANTLR start "macroExpansion"
    // CppTree.g:504:1: macroExpansion[boolean expand] returns [String r] : ( ^( EXPAND id= IDENTIFIER ) | ^( EXPAND id= IDENTIFIER lst= macArgs[expand] ) );
    public final String macroExpansion(boolean expand) throws RecognitionException {
        String r = null;


        CommonTree id=null;
        List lst =null;


        try {
            // CppTree.g:505:3: ( ^( EXPAND id= IDENTIFIER ) | ^( EXPAND id= IDENTIFIER lst= macArgs[expand] ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==EXPAND) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==DOWN) ) {
                    int LA18_2 = input.LA(3);

                    if ( (LA18_2==IDENTIFIER) ) {
                        int LA18_3 = input.LA(4);

                        if ( (LA18_3==UP) ) {
                            alt18=1;
                        }
                        else if ( (LA18_3==EXP_ARGS) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return r;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // CppTree.g:505:6: ^( EXPAND id= IDENTIFIER )
                    {
                    match(input,EXPAND,FOLLOW_EXPAND_in_macroExpansion1145); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroExpansion1149); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {
                    				if(expand)
                    				{
                    					if(isMacroDefined(id.toString()))
                    					{
                    						Object expObject = getMacroObject(id.toString());
                    						if(expObject instanceof FunctionMacro)
                    						{
                    							Macrox_stack.push(new Macros_scope());
                    							((Macros_scope)Macrox_stack.peek()).defines = new HashMap();

                    							FunctionMacro expMacro = (FunctionMacro)expObject;
                    							if(expMacro.haveArgs())
                    							{
                    								MacroParameter	parm;
                    								List formalArgs = expMacro.getArgList();
                    								int	argSize	= formalArgs.size();
                    								parm=(MacroParameter)formalArgs.get(argSize-1);
                    								ExpressionReturn variadics = new ExpressionReturn();
                    								variadics.text = "__VA_ARGS__";

                    								if( argSize == 1 && (parm.type == ELLIPSIS || parm.type == EXP_ARGS))
                    								{
                    									putMacroParameter(((parm.type == ELLIPSIS)? "__VA_ARGS__":parm.text), variadics); 
                    									r = expMacro.getExpansion();
                    								}
                    								else
                    								{
                    									System.out.println("Not Exist Parameter List");
                    									r = id.toString() + "()";
                    								}
                    							}
                    							else
                    							{
                    								r = expMacro.getExpansion();	
                    							}
                    							Macrox_stack.pop();
                    						}
                    						else if(expObject instanceof ObjectMacro)
                    						{
                    							r = ((ObjectMacro)expObject).getExpansion() + "()";
                    						}
                    					}
                    					else
                    					{
                    						r  = id.toString() + "()";
                    					}
                    				}
                    				else
                    				{
                    					r  = id.toString() + "()";
                    				}
                    			}

                    }
                    break;
                case 2 :
                    // CppTree.g:559:5: ^( EXPAND id= IDENTIFIER lst= macArgs[expand] )
                    {
                    match(input,EXPAND,FOLLOW_EXPAND_in_macroExpansion1163); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroExpansion1167); if (state.failed) return r;

                    pushFollow(FOLLOW_macArgs_in_macroExpansion1171);
                    lst=macArgs(expand);

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {
                    				if(expand)
                    				{
                    					if(isMacroDefined(id.toString()))
                    					{
                    						Object expObject = getMacroObject(id.toString());
                    						if(expObject instanceof FunctionMacro)
                    						{
                    							Macrox_stack.push(new Macros_scope());
                    							((Macros_scope)Macrox_stack.peek()).defines = new HashMap();


                    							FunctionMacro expMacro = (FunctionMacro)expObject;
                    							if(expMacro.haveArgs())
                    							{

                    								MacroParameter	parm;
                    								List formalArgs = expMacro.getArgList();
                    								int	argSize	= formalArgs.size();
                    								int lstSize = lst.size();

                    							 	parm=(MacroParameter)formalArgs.get(argSize-1);
                    								if(parm.type == ELLIPSIS || parm.type == EXP_ARGS)
                    								{
                    							 		ExpressionReturn	variadics  = new ExpressionReturn();
                    									variadics.text = "";

                    									if(argSize == 1)
                    									{
                    										for(int i = 0; i<lstSize; i++)
                    										{
                    											variadics.text += ((ExpressionReturn)lst.get(i)).text;
                    											if( i != lstSize-1) variadics.text += ",";
                    										}
                    										putMacroParameter(((parm.type == ELLIPSIS)? "__VA_ARGS__":parm.text), variadics); 
                    										r = expMacro.getExpansion();
                    									}
                    									else
                    									{
                    										if(lstSize < argSize -1)
                    										{
                    											System.err.println("Function Macro Call Not Defined:"+id.toString());	
                    											r  = id.toString()+"(";
                    											for (int i=0; i<lstSize; i++)
                    											{
                    												ExpressionReturn exp = (ExpressionReturn)lst.get(i);
                    												r  += exp.text;
                    												if( i != lstSize-1) r += ",";
                    											}
                    											r += ")";
                    										}
                    										else
                    										{
                    											if(lstSize ==  argSize -1)
                    											{
                    												for (int i=0; i<lstSize; i++)
                    												{
                    													putMacroObject(((MacroParameter)formalArgs.get(i)).text, lst.get(i)); 
                    												}
                    												variadics.text = "__VA_ARGS__";
                    											}
                    											else
                    											{
                    												for (int i=0; i<argSize-1; i++)
                    												{
                    													putMacroParameter(((MacroParameter)formalArgs.get(i)).text, lst.get(i)); 
                    												}
                    												for(int i = argSize-1; i<lstSize; i++)
                    												{
                    													variadics.text += ((ExpressionReturn)lst.get(i)).text;
                    													if( i != lstSize-1) variadics.text += ",";
                    												}
                    											}
                    											putMacroParameter(((parm.type == ELLIPSIS)? "__VA_ARGS__":parm.text), variadics); 
                    											r = expMacro.getExpansion();	
                    										}
                    									}
                    								}
                    								else
                    								{
                    										if(formalArgs.size() != lst.size())
                    										{
                    											System.err.println("// error: macro \"" + id.toString()
                    															  +"\" passed " + lst.size()+ " arguments, but takes just " 
                    															  +formalArgs.size()); 
                    											r = id.toString();
                    										}
                    										else
                    										{
                    											for (int i=0; i<formalArgs.size(); i++)
                    											{
                    												putMacroParameter(((MacroParameter)formalArgs.get(i)).text, lst.get(i)); 
                    											}
                    											r = expMacro.getExpansion();	
                    										}
                    								}
                    							}
                    							else
                    							{
                    								System.err.println("// error: macro \"" + id.toString()
                    												 + "\" passed " + lst.size()+ " arguments, but takes just 0 " );
                    								r = id.toString();
                    							}
                    							Macrox_stack.pop();
                    						}
                    						else
                    						{	
                    							System.err.println("Function Macro Call Not Defined:"+id.toString());	
                    							r  = id.toString()+"(";
                    							for (int i=0; i<lst.size(); i++)
                    							{
                    								ExpressionReturn exp = (ExpressionReturn)lst.get(i);
                    								r  += exp.text;
                    								if( i != lst.size()-1) r += ",";
                    							}
                    							r += ")";
                    	
                    						}
                    					}
                    					else
                    					{
                    						int	argSize	= lst.size();

                    						r  = id.toString()+"(";
                    					    for (int i=0; i<argSize; i++)
                    						{
                    							ExpressionReturn exp = (ExpressionReturn)lst.get(i);
                    							if(!exp.text.equals("__VA_ARGS__")) r  += exp.text;
                    							if(i==argSize-2)
                    							{
                    								ExpressionReturn lastExp = (ExpressionReturn)lst.get(lst.size()-1);
                    								if(lastExp.text.equals("__VA_ARGS_EMPTY__")) 
                    									break;
                    							}

                    							if( i != argSize-1) r += ",";
                    						}
                    						r += ")";
                    					}
                    				}
                    				else
                    				{
                    					r  = id.toString()+"(";
                    				    for (int i=0; i<lst.size(); i++)
                    					{
                    						ExpressionReturn exp = (ExpressionReturn)lst.get(i);
                    						r  += exp.text;
                    						if( i != lst.size()-1) r += ",";
                    					}
                    					r += ")";
                    				}
                    			}

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
        return r;
    }
    // $ANTLR end "macroExpansion"



    // $ANTLR start "macArgs"
    // CppTree.g:714:1: macArgs[boolean expand] returns [List r] : ^( EXP_ARGS (a= mArg[expand] )+ ) ;
    public final List macArgs(boolean expand) throws RecognitionException {
        List r = null;


        String a =null;


         	
        	r = new ArrayList();

        try {
            // CppTree.g:719:3: ( ^( EXP_ARGS (a= mArg[expand] )+ ) )
            // CppTree.g:719:5: ^( EXP_ARGS (a= mArg[expand] )+ )
            {
            match(input,EXP_ARGS,FOLLOW_EXP_ARGS_in_macArgs1203); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            // CppTree.g:719:16: (a= mArg[expand] )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==EXP_ARG) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // CppTree.g:719:17: a= mArg[expand]
            	    {
            	    pushFollow(FOLLOW_mArg_in_macArgs1208);
            	    a=mArg(expand);

            	    state._fsp--;
            	    if (state.failed) return r;

            	    if ( state.backtracking==0 ) { 
            	    				ExpressionReturn arg = new ExpressionReturn();
            	    				arg.text = a;
            	    				r.add(arg); 
            	    			}

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return r;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return r;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "macArgs"



    // $ANTLR start "mArg"
    // CppTree.g:728:1: mArg[boolean expand] returns [String r] : ( ^( EXP_ARG (a= source_text[expand] )+ ) | EXP_ARG );
    public final String mArg(boolean expand) throws RecognitionException {
        String r = null;


        String a =null;


         r = new String(""); 
        try {
            // CppTree.g:730:3: ( ^( EXP_ARG (a= source_text[expand] )+ ) | EXP_ARG )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==EXP_ARG) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==DOWN) ) {
                    alt21=1;
                }
                else if ( (LA21_1==EOF||LA21_1==UP||LA21_1==EXP_ARG) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // CppTree.g:730:5: ^( EXP_ARG (a= source_text[expand] )+ )
                    {
                    match(input,EXP_ARG,FOLLOW_EXP_ARG_in_mArg1245); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    // CppTree.g:730:15: (a= source_text[expand] )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0 >= CHARACTER_LITERAL && LA20_0 <= CKEYWORD)||LA20_0==COMMA||(LA20_0 >= CONCATENATE && LA20_0 <= DECIMAL_LITERAL)||LA20_0==EXPAND||LA20_0==FLOATING_POINT_LITERAL||LA20_0==HEX_LITERAL||LA20_0==IDENTIFIER||LA20_0==LPAREN||LA20_0==OCTAL_LITERAL||LA20_0==RPAREN||(LA20_0 >= SEMICOLON && LA20_0 <= SHARPSHARP)||LA20_0==SIZEOF||(LA20_0 >= STRINGIFICATION && LA20_0 <= TEXT_GROUP)||LA20_0==WS) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // CppTree.g:730:16: a= source_text[expand]
                    	    {
                    	    pushFollow(FOLLOW_source_text_in_mArg1250);
                    	    a=source_text(expand);

                    	    state._fsp--;
                    	    if (state.failed) return r;

                    	    if ( state.backtracking==0 ) { r += a; }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return r;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return r;


                    }
                    break;
                case 2 :
                    // CppTree.g:731:5: EXP_ARG
                    {
                    match(input,EXP_ARG,FOLLOW_EXP_ARG_in_mArg1264); if (state.failed) return r;

                    if ( state.backtracking==0 ) {	r = " ";	}

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
        return r;
    }
    // $ANTLR end "mArg"



    // $ANTLR start "macroExecution"
    // CppTree.g:736:1: macroExecution returns [int r] : ^( EXEC_MACRO a= expression ) ;
    public final int macroExecution() throws RecognitionException {
        int r = 0;


        int a =0;


        try {
            // CppTree.g:737:3: ( ^( EXEC_MACRO a= expression ) )
            // CppTree.g:737:5: ^( EXEC_MACRO a= expression )
            {
            match(input,EXEC_MACRO,FOLLOW_EXEC_MACRO_in_macroExecution1288); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expression_in_macroExecution1292);
            a=expression();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = a; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "macroExecution"



    // $ANTLR start "expression"
    // CppTree.g:740:1: expression returns [int r] : ( ^( EXPR a= expr ) | ^( EXPR_DEF id= IDENTIFIER ) | ^( EXPR_NDEF id= IDENTIFIER ) );
    public final int expression() throws RecognitionException {
        int r = 0;


        CommonTree id=null;
        int a =0;


        r = 0;
        try {
            // CppTree.g:742:3: ( ^( EXPR a= expr ) | ^( EXPR_DEF id= IDENTIFIER ) | ^( EXPR_NDEF id= IDENTIFIER ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case EXPR:
                {
                alt22=1;
                }
                break;
            case EXPR_DEF:
                {
                alt22=2;
                }
                break;
            case EXPR_NDEF:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // CppTree.g:742:5: ^( EXPR a= expr )
                    {
                    match(input,EXPR,FOLLOW_EXPR_in_expression1318); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_expression1322);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = a; }

                    }
                    break;
                case 2 :
                    // CppTree.g:743:5: ^( EXPR_DEF id= IDENTIFIER )
                    {
                    match(input,EXPR_DEF,FOLLOW_EXPR_DEF_in_expression1335); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression1339); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = isMacroDefined(id.toString()) ? 1: 0 ; }

                    }
                    break;
                case 3 :
                    // CppTree.g:744:5: ^( EXPR_NDEF id= IDENTIFIER )
                    {
                    match(input,EXPR_NDEF,FOLLOW_EXPR_NDEF_in_expression1349); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression1354); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = isMacroDefined(id.toString()) ? 0: 1 ; }

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
        return r;
    }
    // $ANTLR end "expression"



    // $ANTLR start "expr"
    // CppTree.g:747:1: expr returns [int r] : (a= assignmentExpression |a= conditionalExpression |a= logicalOrExpression |a= logicalAndExpression |a= inclusiveOrExpression |a= exclusiveOrExpression |a= andExpression |a= equalityExpression |a= relationalExpression |a= shiftExpression |a= additiveExpression |a= multiplicativeExpression |a= unaryExpression |a= postfixExpression |a= primaryExpression ) ;
    public final int expr() throws RecognitionException {
        int r = 0;


        int a =0;


         r = 0; 
        try {
            // CppTree.g:749:3: ( (a= assignmentExpression |a= conditionalExpression |a= logicalOrExpression |a= logicalAndExpression |a= inclusiveOrExpression |a= exclusiveOrExpression |a= andExpression |a= equalityExpression |a= relationalExpression |a= shiftExpression |a= additiveExpression |a= multiplicativeExpression |a= unaryExpression |a= postfixExpression |a= primaryExpression ) )
            // CppTree.g:750:3: (a= assignmentExpression |a= conditionalExpression |a= logicalOrExpression |a= logicalAndExpression |a= inclusiveOrExpression |a= exclusiveOrExpression |a= andExpression |a= equalityExpression |a= relationalExpression |a= shiftExpression |a= additiveExpression |a= multiplicativeExpression |a= unaryExpression |a= postfixExpression |a= primaryExpression )
            {
            // CppTree.g:750:3: (a= assignmentExpression |a= conditionalExpression |a= logicalOrExpression |a= logicalAndExpression |a= inclusiveOrExpression |a= exclusiveOrExpression |a= andExpression |a= equalityExpression |a= relationalExpression |a= shiftExpression |a= additiveExpression |a= multiplicativeExpression |a= unaryExpression |a= postfixExpression |a= primaryExpression )
            int alt23=15;
            switch ( input.LA(1) ) {
            case ASSIGNEQUAL:
            case BITWISEANDEQUAL:
            case BITWISEOREQUAL:
            case BITWISEXOREQUAL:
            case DIVIDEEQUAL:
            case MINUSEQUAL:
            case MODEQUAL:
            case PLUSEQUAL:
            case SHIFTLEFTEQUAL:
            case SHIFTRIGHTEQUAL:
            case TIMESEQUAL:
                {
                alt23=1;
                }
                break;
            case QUESTIONMARK:
                {
                alt23=2;
                }
                break;
            case OR:
                {
                alt23=3;
                }
                break;
            case AND:
                {
                alt23=4;
                }
                break;
            case BITWISEOR:
                {
                alt23=5;
                }
                break;
            case BITWISERXOR:
                {
                alt23=6;
                }
                break;
            case AMPERSAND:
                {
                alt23=7;
                }
                break;
            case EQUAL:
            case NOTEQUAL:
                {
                alt23=8;
                }
                break;
            case GREATERTHAN:
            case GREATERTHANOREQUALTO:
            case LESSTHAN:
            case LESSTHANOREQUALTO:
                {
                alt23=9;
                }
                break;
            case SHIFTLEFT:
            case SHIFTRIGHT:
                {
                alt23=10;
                }
                break;
            case MINUS:
            case PLUS:
                {
                alt23=11;
                }
                break;
            case DIVIDE:
            case MOD:
            case STAR:
                {
                alt23=12;
                }
                break;
            case DEFINED:
            case MINUSMINUS:
            case NOT:
            case PLUSPLUS:
            case POINTER_AT:
            case REFERANCE:
            case SIZEOF:
            case SIZEOF_TYPE:
            case TILDE:
            case TYPECAST:
            case UNARY_MINUS:
            case UNARY_PLUS:
                {
                alt23=13;
                }
                break;
            case DOT:
            case INDEX_OP:
            case POINTER:
            case POINTERTO:
            case POST_DEC:
            case POST_INC:
                {
                alt23=14;
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case EXPR_GROUP:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case METHOD_CALL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt23=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // CppTree.g:750:5: a= assignmentExpression
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_expr1386);
                    a=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 2 :
                    // CppTree.g:751:5: a= conditionalExpression
                    {
                    pushFollow(FOLLOW_conditionalExpression_in_expr1394);
                    a=conditionalExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 3 :
                    // CppTree.g:752:5: a= logicalOrExpression
                    {
                    pushFollow(FOLLOW_logicalOrExpression_in_expr1402);
                    a=logicalOrExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 4 :
                    // CppTree.g:753:5: a= logicalAndExpression
                    {
                    pushFollow(FOLLOW_logicalAndExpression_in_expr1410);
                    a=logicalAndExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 5 :
                    // CppTree.g:754:5: a= inclusiveOrExpression
                    {
                    pushFollow(FOLLOW_inclusiveOrExpression_in_expr1418);
                    a=inclusiveOrExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 6 :
                    // CppTree.g:755:5: a= exclusiveOrExpression
                    {
                    pushFollow(FOLLOW_exclusiveOrExpression_in_expr1426);
                    a=exclusiveOrExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 7 :
                    // CppTree.g:756:5: a= andExpression
                    {
                    pushFollow(FOLLOW_andExpression_in_expr1434);
                    a=andExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 8 :
                    // CppTree.g:757:5: a= equalityExpression
                    {
                    pushFollow(FOLLOW_equalityExpression_in_expr1442);
                    a=equalityExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 9 :
                    // CppTree.g:758:5: a= relationalExpression
                    {
                    pushFollow(FOLLOW_relationalExpression_in_expr1450);
                    a=relationalExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 10 :
                    // CppTree.g:759:5: a= shiftExpression
                    {
                    pushFollow(FOLLOW_shiftExpression_in_expr1458);
                    a=shiftExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 11 :
                    // CppTree.g:760:5: a= additiveExpression
                    {
                    pushFollow(FOLLOW_additiveExpression_in_expr1466);
                    a=additiveExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 12 :
                    // CppTree.g:761:5: a= multiplicativeExpression
                    {
                    pushFollow(FOLLOW_multiplicativeExpression_in_expr1474);
                    a=multiplicativeExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 13 :
                    // CppTree.g:762:5: a= unaryExpression
                    {
                    pushFollow(FOLLOW_unaryExpression_in_expr1482);
                    a=unaryExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 14 :
                    // CppTree.g:763:5: a= postfixExpression
                    {
                    pushFollow(FOLLOW_postfixExpression_in_expr1490);
                    a=postfixExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;
                case 15 :
                    // CppTree.g:764:5: a= primaryExpression
                    {
                    pushFollow(FOLLOW_primaryExpression_in_expr1498);
                    a=primaryExpression();

                    state._fsp--;
                    if (state.failed) return r;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { 	r = a; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "expr"



    // $ANTLR start "assignmentExpression"
    // CppTree.g:769:1: assignmentExpression returns [int r] : ( ^(o= ASSIGNEQUAL a= expr b= expr ) | ^(o= TIMESEQUAL a= expr b= expr ) | ^(o= DIVIDEEQUAL a= expr b= expr ) | ^(o= PLUSEQUAL a= expr b= expr ) | ^(o= MINUSEQUAL a= expr b= expr ) | ^(o= SHIFTLEFTEQUAL a= expr b= expr ) | ^(o= SHIFTRIGHTEQUAL a= expr b= expr ) | ^(o= BITWISEANDEQUAL a= expr b= expr ) | ^(o= BITWISEXOREQUAL a= expr b= expr ) | ^(o= BITWISEOREQUAL a= expr b= expr ) | ^(o= MODEQUAL a= expr b= expr ) );
    public final int assignmentExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:771:3: ( ^(o= ASSIGNEQUAL a= expr b= expr ) | ^(o= TIMESEQUAL a= expr b= expr ) | ^(o= DIVIDEEQUAL a= expr b= expr ) | ^(o= PLUSEQUAL a= expr b= expr ) | ^(o= MINUSEQUAL a= expr b= expr ) | ^(o= SHIFTLEFTEQUAL a= expr b= expr ) | ^(o= SHIFTRIGHTEQUAL a= expr b= expr ) | ^(o= BITWISEANDEQUAL a= expr b= expr ) | ^(o= BITWISEXOREQUAL a= expr b= expr ) | ^(o= BITWISEOREQUAL a= expr b= expr ) | ^(o= MODEQUAL a= expr b= expr ) )
            int alt24=11;
            switch ( input.LA(1) ) {
            case ASSIGNEQUAL:
                {
                alt24=1;
                }
                break;
            case TIMESEQUAL:
                {
                alt24=2;
                }
                break;
            case DIVIDEEQUAL:
                {
                alt24=3;
                }
                break;
            case PLUSEQUAL:
                {
                alt24=4;
                }
                break;
            case MINUSEQUAL:
                {
                alt24=5;
                }
                break;
            case SHIFTLEFTEQUAL:
                {
                alt24=6;
                }
                break;
            case SHIFTRIGHTEQUAL:
                {
                alt24=7;
                }
                break;
            case BITWISEANDEQUAL:
                {
                alt24=8;
                }
                break;
            case BITWISEXOREQUAL:
                {
                alt24=9;
                }
                break;
            case BITWISEOREQUAL:
                {
                alt24=10;
                }
                break;
            case MODEQUAL:
                {
                alt24=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // CppTree.g:771:6: ^(o= ASSIGNEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,ASSIGNEQUAL,FOLLOW_ASSIGNEQUAL_in_assignmentExpression1532); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1542);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1546);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = a;		  }

                    }
                    break;
                case 2 :
                    // CppTree.g:772:7: ^(o= TIMESEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,TIMESEQUAL,FOLLOW_TIMESEQUAL_in_assignmentExpression1560); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1571);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1575);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a *= b;	r = a;}

                    }
                    break;
                case 3 :
                    // CppTree.g:773:7: ^(o= DIVIDEEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,DIVIDEEQUAL,FOLLOW_DIVIDEEQUAL_in_assignmentExpression1589); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1599);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1603);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a /= b;	r = a;}

                    }
                    break;
                case 4 :
                    // CppTree.g:774:7: ^(o= PLUSEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,PLUSEQUAL,FOLLOW_PLUSEQUAL_in_assignmentExpression1617); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1629);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1633);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a += b;	r = a;}

                    }
                    break;
                case 5 :
                    // CppTree.g:775:7: ^(o= MINUSEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,MINUSEQUAL,FOLLOW_MINUSEQUAL_in_assignmentExpression1647); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1658);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1662);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a -= b;	r = a;}

                    }
                    break;
                case 6 :
                    // CppTree.g:776:7: ^(o= SHIFTLEFTEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,SHIFTLEFTEQUAL,FOLLOW_SHIFTLEFTEQUAL_in_assignmentExpression1676); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1683);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1687);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a <<= b;	r = a;}

                    }
                    break;
                case 7 :
                    // CppTree.g:777:7: ^(o= SHIFTRIGHTEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,SHIFTRIGHTEQUAL,FOLLOW_SHIFTRIGHTEQUAL_in_assignmentExpression1701); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1707);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1711);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a >>= b;	r = a;}

                    }
                    break;
                case 8 :
                    // CppTree.g:778:7: ^(o= BITWISEANDEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,BITWISEANDEQUAL,FOLLOW_BITWISEANDEQUAL_in_assignmentExpression1725); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1731);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1735);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a &= b;	r = a;}

                    }
                    break;
                case 9 :
                    // CppTree.g:779:7: ^(o= BITWISEXOREQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,BITWISEXOREQUAL,FOLLOW_BITWISEXOREQUAL_in_assignmentExpression1749); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1755);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1759);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a ^= b;	r = a;}

                    }
                    break;
                case 10 :
                    // CppTree.g:780:7: ^(o= BITWISEOREQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,BITWISEOREQUAL,FOLLOW_BITWISEOREQUAL_in_assignmentExpression1773); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1780);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1784);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a |= b;	r = a;}

                    }
                    break;
                case 11 :
                    // CppTree.g:781:7: ^(o= MODEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,MODEQUAL,FOLLOW_MODEQUAL_in_assignmentExpression1798); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_assignmentExpression1811);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_assignmentExpression1815);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  a =Mod(a,b);	r = a;}

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
        return r;
    }
    // $ANTLR end "assignmentExpression"



    // $ANTLR start "conditionalExpression"
    // CppTree.g:784:1: conditionalExpression returns [int r] : ^( QUESTIONMARK a= expr b= expr COLON c= expr ) ;
    public final int conditionalExpression() throws RecognitionException {
        int r = 0;


        int a =0;

        int b =0;

        int c =0;


        r = 0;
        try {
            // CppTree.g:786:3: ( ^( QUESTIONMARK a= expr b= expr COLON c= expr ) )
            // CppTree.g:786:5: ^( QUESTIONMARK a= expr b= expr COLON c= expr )
            {
            match(input,QUESTIONMARK,FOLLOW_QUESTIONMARK_in_conditionalExpression1842); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expr_in_conditionalExpression1846);
            a=expr();

            state._fsp--;
            if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_conditionalExpression1850);
            b=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input,COLON,FOLLOW_COLON_in_conditionalExpression1852); if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_conditionalExpression1856);
            c=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = ((a!=0) ?	b:c); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "conditionalExpression"



    // $ANTLR start "logicalOrExpression"
    // CppTree.g:789:1: logicalOrExpression returns [int r] : ^(o= OR a= expr b= expr ) ;
    public final int logicalOrExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:791:3: ( ^(o= OR a= expr b= expr ) )
            // CppTree.g:791:5: ^(o= OR a= expr b= expr )
            {
            o=(CommonTree)match(input,OR,FOLLOW_OR_in_logicalOrExpression1887); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expr_in_logicalOrExpression1891);
            a=expr();

            state._fsp--;
            if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_logicalOrExpression1895);
            b=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = ((a!=0||b!=0)	? 1:0); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "logicalOrExpression"



    // $ANTLR start "logicalAndExpression"
    // CppTree.g:794:1: logicalAndExpression returns [int r] : ^(o= AND a= expr b= expr ) ;
    public final int logicalAndExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:796:3: ( ^(o= AND a= expr b= expr ) )
            // CppTree.g:796:5: ^(o= AND a= expr b= expr )
            {
            o=(CommonTree)match(input,AND,FOLLOW_AND_in_logicalAndExpression1928); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expr_in_logicalAndExpression1932);
            a=expr();

            state._fsp--;
            if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_logicalAndExpression1936);
            b=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = (((a!=0)&&(b!=0))	? 1:0); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "logicalAndExpression"



    // $ANTLR start "inclusiveOrExpression"
    // CppTree.g:799:1: inclusiveOrExpression returns [int r] : ^(o= BITWISEOR a= expr b= expr ) ;
    public final int inclusiveOrExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:801:3: ( ^(o= BITWISEOR a= expr b= expr ) )
            // CppTree.g:801:5: ^(o= BITWISEOR a= expr b= expr )
            {
            o=(CommonTree)match(input,BITWISEOR,FOLLOW_BITWISEOR_in_inclusiveOrExpression1966); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expr_in_inclusiveOrExpression1970);
            a=expr();

            state._fsp--;
            if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_inclusiveOrExpression1974);
            b=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = a|b; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "inclusiveOrExpression"



    // $ANTLR start "exclusiveOrExpression"
    // CppTree.g:804:1: exclusiveOrExpression returns [int r] : ^(o= BITWISERXOR a= expr b= expr ) ;
    public final int exclusiveOrExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:806:3: ( ^(o= BITWISERXOR a= expr b= expr ) )
            // CppTree.g:806:5: ^(o= BITWISERXOR a= expr b= expr )
            {
            o=(CommonTree)match(input,BITWISERXOR,FOLLOW_BITWISERXOR_in_exclusiveOrExpression2005); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expr_in_exclusiveOrExpression2009);
            a=expr();

            state._fsp--;
            if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_exclusiveOrExpression2013);
            b=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = a^b; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "exclusiveOrExpression"



    // $ANTLR start "andExpression"
    // CppTree.g:809:1: andExpression returns [int r] : ^(o= AMPERSAND a= expr b= expr ) ;
    public final int andExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:811:3: ( ^(o= AMPERSAND a= expr b= expr ) )
            // CppTree.g:811:5: ^(o= AMPERSAND a= expr b= expr )
            {
            o=(CommonTree)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_andExpression2043); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            pushFollow(FOLLOW_expr_in_andExpression2047);
            a=expr();

            state._fsp--;
            if (state.failed) return r;

            pushFollow(FOLLOW_expr_in_andExpression2051);
            b=expr();

            state._fsp--;
            if (state.failed) return r;

            match(input, Token.UP, null); if (state.failed) return r;


            if ( state.backtracking==0 ) { r = a&b; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "andExpression"



    // $ANTLR start "equalityExpression"
    // CppTree.g:814:1: equalityExpression returns [int r] : ( ^(o= NOTEQUAL a= expr b= expr ) | ^(o= EQUAL a= expr b= expr ) );
    public final int equalityExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:816:3: ( ^(o= NOTEQUAL a= expr b= expr ) | ^(o= EQUAL a= expr b= expr ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==NOTEQUAL) ) {
                alt25=1;
            }
            else if ( (LA25_0==EQUAL) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // CppTree.g:816:5: ^(o= NOTEQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_equalityExpression2080); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_equalityExpression2084);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_equalityExpression2088);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a !=  b) ?	1:0); }

                    }
                    break;
                case 2 :
                    // CppTree.g:817:5: ^(o= EQUAL a= expr b= expr )
                    {
                    o=(CommonTree)match(input,EQUAL,FOLLOW_EQUAL_in_equalityExpression2102); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_equalityExpression2108);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_equalityExpression2112);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a ==  b) ?	1:0); }

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
        return r;
    }
    // $ANTLR end "equalityExpression"



    // $ANTLR start "relationalExpression"
    // CppTree.g:820:1: relationalExpression returns [int r] : ( ^(o= LESSTHAN a= expr b= expr ) | ^(o= GREATERTHAN a= expr b= expr ) | ^(o= LESSTHANOREQUALTO a= expr b= expr ) | ^(o= GREATERTHANOREQUALTO a= expr b= expr ) );
    public final int relationalExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:822:3: ( ^(o= LESSTHAN a= expr b= expr ) | ^(o= GREATERTHAN a= expr b= expr ) | ^(o= LESSTHANOREQUALTO a= expr b= expr ) | ^(o= GREATERTHANOREQUALTO a= expr b= expr ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case LESSTHAN:
                {
                alt26=1;
                }
                break;
            case GREATERTHAN:
                {
                alt26=2;
                }
                break;
            case LESSTHANOREQUALTO:
                {
                alt26=3;
                }
                break;
            case GREATERTHANOREQUALTO:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // CppTree.g:822:5: ^(o= LESSTHAN a= expr b= expr )
                    {
                    o=(CommonTree)match(input,LESSTHAN,FOLLOW_LESSTHAN_in_relationalExpression2142); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_relationalExpression2150);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_relationalExpression2154);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a <  b) ? 1:0); }

                    }
                    break;
                case 2 :
                    // CppTree.g:823:13: ^(o= GREATERTHAN a= expr b= expr )
                    {
                    o=(CommonTree)match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_relationalExpression2176); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_relationalExpression2184);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_relationalExpression2188);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a >  b) ? 1:0); }

                    }
                    break;
                case 3 :
                    // CppTree.g:824:13: ^(o= LESSTHANOREQUALTO a= expr b= expr )
                    {
                    o=(CommonTree)match(input,LESSTHANOREQUALTO,FOLLOW_LESSTHANOREQUALTO_in_relationalExpression2210); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_relationalExpression2216);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_relationalExpression2220);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a <= b) ? 1:0); }

                    }
                    break;
                case 4 :
                    // CppTree.g:825:13: ^(o= GREATERTHANOREQUALTO a= expr b= expr )
                    {
                    o=(CommonTree)match(input,GREATERTHANOREQUALTO,FOLLOW_GREATERTHANOREQUALTO_in_relationalExpression2242); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_relationalExpression2246);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_relationalExpression2250);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a >= b) ? 1:0); }

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
        return r;
    }
    // $ANTLR end "relationalExpression"



    // $ANTLR start "shiftExpression"
    // CppTree.g:828:1: shiftExpression returns [int r] : ( ^(o= SHIFTLEFT a= expr b= expr ) | ^(o= SHIFTRIGHT a= expr b= expr ) );
    public final int shiftExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:830:3: ( ^(o= SHIFTLEFT a= expr b= expr ) | ^(o= SHIFTRIGHT a= expr b= expr ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==SHIFTLEFT) ) {
                alt27=1;
            }
            else if ( (LA27_0==SHIFTRIGHT) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // CppTree.g:830:5: ^(o= SHIFTLEFT a= expr b= expr )
                    {
                    o=(CommonTree)match(input,SHIFTLEFT,FOLLOW_SHIFTLEFT_in_shiftExpression2284); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_shiftExpression2290);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_shiftExpression2294);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = a<<b; }

                    }
                    break;
                case 2 :
                    // CppTree.g:831:7: ^(o= SHIFTRIGHT a= expr b= expr )
                    {
                    o=(CommonTree)match(input,SHIFTRIGHT,FOLLOW_SHIFTRIGHT_in_shiftExpression2310); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_shiftExpression2315);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_shiftExpression2319);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = a>>b; }

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
        return r;
    }
    // $ANTLR end "shiftExpression"



    // $ANTLR start "additiveExpression"
    // CppTree.g:834:1: additiveExpression returns [int r] : ( ^(o= PLUS a= expr b= expr ) | ^(o= MINUS a= expr b= expr ) );
    public final int additiveExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:836:3: ( ^(o= PLUS a= expr b= expr ) | ^(o= MINUS a= expr b= expr ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==PLUS) ) {
                alt28=1;
            }
            else if ( (LA28_0==MINUS) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // CppTree.g:836:5: ^(o= PLUS a= expr b= expr )
                    {
                    o=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_additiveExpression2352); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_additiveExpression2356);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_additiveExpression2360);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = a+b; }

                    }
                    break;
                case 2 :
                    // CppTree.g:837:10: ^(o= MINUS a= expr b= expr )
                    {
                    o=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_additiveExpression2379); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_additiveExpression2384);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_additiveExpression2388);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = a-b; }

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
        return r;
    }
    // $ANTLR end "additiveExpression"



    // $ANTLR start "multiplicativeExpression"
    // CppTree.g:840:1: multiplicativeExpression returns [int r] : ( ^(o= STAR a= expr b= expr ) | ^(o= DIVIDE a= expr b= expr ) | ^(o= MOD a= expr b= expr ) );
    public final int multiplicativeExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:842:3: ( ^(o= STAR a= expr b= expr ) | ^(o= DIVIDE a= expr b= expr ) | ^(o= MOD a= expr b= expr ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case STAR:
                {
                alt29=1;
                }
                break;
            case DIVIDE:
                {
                alt29=2;
                }
                break;
            case MOD:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // CppTree.g:842:5: ^(o= STAR a= expr b= expr )
                    {
                    o=(CommonTree)match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression2420); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_multiplicativeExpression2425);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_multiplicativeExpression2429);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = a*b; }

                    }
                    break;
                case 2 :
                    // CppTree.g:843:10: ^(o= DIVIDE a= expr b= expr )
                    {
                    o=(CommonTree)match(input,DIVIDE,FOLLOW_DIVIDE_in_multiplicativeExpression2446); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_multiplicativeExpression2452);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_multiplicativeExpression2456);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = a/b; }

                    }
                    break;
                case 3 :
                    // CppTree.g:844:7: ^(o= MOD a= expr b= expr )
                    {
                    o=(CommonTree)match(input,MOD,FOLLOW_MOD_in_multiplicativeExpression2470); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_multiplicativeExpression2476);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_multiplicativeExpression2480);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = Mod(a,b); }

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
        return r;
    }
    // $ANTLR end "multiplicativeExpression"



    // $ANTLR start "unaryExpression"
    // CppTree.g:847:1: unaryExpression returns [int r] : ( ^(o= PLUSPLUS a= expr ) | ^(o= MINUSMINUS a= expr ) | ^(o= REFERANCE a= expr ) | ^(o= POINTER_AT a= expr ) | ^(o= UNARY_MINUS a= expr ) | ^(o= UNARY_PLUS a= expr ) | ^( SIZEOF a= expr ) | ^( SIZEOF_TYPE b= IDENTIFIER ) | ^(o= NOT a= expr ) | ^(o= TILDE a= expr ) | ^(o= TYPECAST b= IDENTIFIER a= expr ) | ^( DEFINED b= IDENTIFIER ) );
    public final int unaryExpression() throws RecognitionException {
        int r = 0;


        CommonTree o=null;
        CommonTree b=null;
        int a =0;


        r = 0; 
        try {
            // CppTree.g:849:3: ( ^(o= PLUSPLUS a= expr ) | ^(o= MINUSMINUS a= expr ) | ^(o= REFERANCE a= expr ) | ^(o= POINTER_AT a= expr ) | ^(o= UNARY_MINUS a= expr ) | ^(o= UNARY_PLUS a= expr ) | ^( SIZEOF a= expr ) | ^( SIZEOF_TYPE b= IDENTIFIER ) | ^(o= NOT a= expr ) | ^(o= TILDE a= expr ) | ^(o= TYPECAST b= IDENTIFIER a= expr ) | ^( DEFINED b= IDENTIFIER ) )
            int alt30=12;
            switch ( input.LA(1) ) {
            case PLUSPLUS:
                {
                alt30=1;
                }
                break;
            case MINUSMINUS:
                {
                alt30=2;
                }
                break;
            case REFERANCE:
                {
                alt30=3;
                }
                break;
            case POINTER_AT:
                {
                alt30=4;
                }
                break;
            case UNARY_MINUS:
                {
                alt30=5;
                }
                break;
            case UNARY_PLUS:
                {
                alt30=6;
                }
                break;
            case SIZEOF:
                {
                alt30=7;
                }
                break;
            case SIZEOF_TYPE:
                {
                alt30=8;
                }
                break;
            case NOT:
                {
                alt30=9;
                }
                break;
            case TILDE:
                {
                alt30=10;
                }
                break;
            case TYPECAST:
                {
                alt30=11;
                }
                break;
            case DEFINED:
                {
                alt30=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // CppTree.g:849:5: ^(o= PLUSPLUS a= expr )
                    {
                    o=(CommonTree)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unaryExpression2508); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2513);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ++a; }

                    }
                    break;
                case 2 :
                    // CppTree.g:850:5: ^(o= MINUSMINUS a= expr )
                    {
                    o=(CommonTree)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_unaryExpression2527); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2532);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = --a; }

                    }
                    break;
                case 3 :
                    // CppTree.g:851:5: ^(o= REFERANCE a= expr )
                    {
                    o=(CommonTree)match(input,REFERANCE,FOLLOW_REFERANCE_in_unaryExpression2546); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2550);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r =1;	   }

                    }
                    break;
                case 4 :
                    // CppTree.g:852:5: ^(o= POINTER_AT a= expr )
                    {
                    o=(CommonTree)match(input,POINTER_AT,FOLLOW_POINTER_AT_in_unaryExpression2564); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2568);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r =1;    }

                    }
                    break;
                case 5 :
                    // CppTree.g:853:5: ^(o= UNARY_MINUS a= expr )
                    {
                    o=(CommonTree)match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_unaryExpression2582); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2586);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = +a;  }

                    }
                    break;
                case 6 :
                    // CppTree.g:854:5: ^(o= UNARY_PLUS a= expr )
                    {
                    o=(CommonTree)match(input,UNARY_PLUS,FOLLOW_UNARY_PLUS_in_unaryExpression2600); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2605);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = -a;  }

                    }
                    break;
                case 7 :
                    // CppTree.g:855:5: ^( SIZEOF a= expr )
                    {
                    match(input,SIZEOF,FOLLOW_SIZEOF_in_unaryExpression2617); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2623);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = 1;   }

                    }
                    break;
                case 8 :
                    // CppTree.g:856:5: ^( SIZEOF_TYPE b= IDENTIFIER )
                    {
                    match(input,SIZEOF_TYPE,FOLLOW_SIZEOF_TYPE_in_unaryExpression2635); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unaryExpression2639); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = 1;   }

                    }
                    break;
                case 9 :
                    // CppTree.g:857:5: ^(o= NOT a= expr )
                    {
                    o=(CommonTree)match(input,NOT,FOLLOW_NOT_in_unaryExpression2651); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2657);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a!=0) ?	0:1); }

                    }
                    break;
                case 10 :
                    // CppTree.g:858:5: ^(o= TILDE a= expr )
                    {
                    o=(CommonTree)match(input,TILDE,FOLLOW_TILDE_in_unaryExpression2671); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_unaryExpression2676);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = ((a!=0) ?	0:1); }

                    }
                    break;
                case 11 :
                    // CppTree.g:859:5: ^(o= TYPECAST b= IDENTIFIER a= expr )
                    {
                    o=(CommonTree)match(input,TYPECAST,FOLLOW_TYPECAST_in_unaryExpression2690); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unaryExpression2695); if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_unaryExpression2699);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = 1; }

                    }
                    break;
                case 12 :
                    // CppTree.g:860:5: ^( DEFINED b= IDENTIFIER )
                    {
                    match(input,DEFINED,FOLLOW_DEFINED_in_unaryExpression2710); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unaryExpression2716); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = isMacroDefined(b.toString()) ? 1: 0 ; }

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
        return r;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "postfixExpression"
    // CppTree.g:863:1: postfixExpression returns [int r] : ( ^( POST_INC a= expr ) | ^( POST_DEC a= expr ) | ^( POINTERTO a= expr i= IDENTIFIER ) | ^( POINTER a= expr i= IDENTIFIER ) | ^( DOT a= expr i= IDENTIFIER ) | ^( INDEX_OP a= expr b= expr ) );
    public final int postfixExpression() throws RecognitionException {
        int r = 0;


        CommonTree i=null;
        int a =0;

        int b =0;


        r = 0;
        try {
            // CppTree.g:865:3: ( ^( POST_INC a= expr ) | ^( POST_DEC a= expr ) | ^( POINTERTO a= expr i= IDENTIFIER ) | ^( POINTER a= expr i= IDENTIFIER ) | ^( DOT a= expr i= IDENTIFIER ) | ^( INDEX_OP a= expr b= expr ) )
            int alt31=6;
            switch ( input.LA(1) ) {
            case POST_INC:
                {
                alt31=1;
                }
                break;
            case POST_DEC:
                {
                alt31=2;
                }
                break;
            case POINTERTO:
                {
                alt31=3;
                }
                break;
            case POINTER:
                {
                alt31=4;
                }
                break;
            case DOT:
                {
                alt31=5;
                }
                break;
            case INDEX_OP:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // CppTree.g:865:5: ^( POST_INC a= expr )
                    {
                    match(input,POST_INC,FOLLOW_POST_INC_in_postfixExpression2742); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_postfixExpression2747);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = a++; }

                    }
                    break;
                case 2 :
                    // CppTree.g:866:10: ^( POST_DEC a= expr )
                    {
                    match(input,POST_DEC,FOLLOW_POST_DEC_in_postfixExpression2767); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_postfixExpression2771);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = a--; }

                    }
                    break;
                case 3 :
                    // CppTree.g:867:5: ^( POINTERTO a= expr i= IDENTIFIER )
                    {
                    match(input,POINTERTO,FOLLOW_POINTERTO_in_postfixExpression2786); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_postfixExpression2790);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression2795); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = 1; 	}

                    }
                    break;
                case 4 :
                    // CppTree.g:868:5: ^( POINTER a= expr i= IDENTIFIER )
                    {
                    match(input,POINTER,FOLLOW_POINTER_in_postfixExpression2807); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_postfixExpression2812);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression2817); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = 1; 	}

                    }
                    break;
                case 5 :
                    // CppTree.g:869:5: ^( DOT a= expr i= IDENTIFIER )
                    {
                    match(input,DOT,FOLLOW_DOT_in_postfixExpression2829); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_postfixExpression2835);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression2840); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = 1; 	}

                    }
                    break;
                case 6 :
                    // CppTree.g:870:5: ^( INDEX_OP a= expr b= expr )
                    {
                    match(input,INDEX_OP,FOLLOW_INDEX_OP_in_postfixExpression2853); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_postfixExpression2858);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    pushFollow(FOLLOW_expr_in_postfixExpression2863);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {  r = 1; 	}

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
        return r;
    }
    // $ANTLR end "postfixExpression"



    // $ANTLR start "primaryExpression"
    // CppTree.g:873:1: primaryExpression returns [int r] : (c= constant[true] | ^( EXPR_GROUP b= expr ) |id= IDENTIFIER | ^( METHOD_CALL id= IDENTIFIER ) | ^( METHOD_CALL id= IDENTIFIER lst= argList ) );
    public final int primaryExpression() throws RecognitionException {
        int r = 0;


        CommonTree id=null;
        ExpressionReturn c =null;

        int b =0;

        List lst =null;


        r = 0;
        try {
            // CppTree.g:875:3: (c= constant[true] | ^( EXPR_GROUP b= expr ) |id= IDENTIFIER | ^( METHOD_CALL id= IDENTIFIER ) | ^( METHOD_CALL id= IDENTIFIER lst= argList ) )
            int alt32=5;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt32=1;
                }
                break;
            case EXPR_GROUP:
                {
                alt32=2;
                }
                break;
            case IDENTIFIER:
                {
                alt32=3;
                }
                break;
            case METHOD_CALL:
                {
                int LA32_4 = input.LA(2);

                if ( (LA32_4==DOWN) ) {
                    int LA32_5 = input.LA(3);

                    if ( (LA32_5==IDENTIFIER) ) {
                        int LA32_6 = input.LA(4);

                        if ( (LA32_6==UP) ) {
                            alt32=4;
                        }
                        else if ( (LA32_6==ARGS) ) {
                            alt32=5;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return r;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 32, 6, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return r;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 5, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return r;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }

            switch (alt32) {
                case 1 :
                    // CppTree.g:875:5: c= constant[true]
                    {
                    pushFollow(FOLLOW_constant_in_primaryExpression2893);
                    c=constant(true);

                    state._fsp--;
                    if (state.failed) return r;

                    if ( state.backtracking==0 ) { r = c.value; }

                    }
                    break;
                case 2 :
                    // CppTree.g:876:10: ^( EXPR_GROUP b= expr )
                    {
                    match(input,EXPR_GROUP,FOLLOW_EXPR_GROUP_in_primaryExpression2909); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    pushFollow(FOLLOW_expr_in_primaryExpression2913);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) { r = b; 	   }

                    }
                    break;
                case 3 :
                    // CppTree.g:877:6: id= IDENTIFIER
                    {
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primaryExpression2926); if (state.failed) return r;

                    if ( state.backtracking==0 ) {
                    				if(isMacroDefined(id.toString()))
                    				{
                    					Object expObject = getMacroObject(id.toString());
                    					if(expObject instanceof ObjectMacro)
                    					{
                    						r = ((ObjectMacro)expObject).getExpandedValue();	
                    					}
                    					else if( expObject instanceof ExpressionReturn)
                    					{
                    						r = ((ExpressionReturn)expObject).value;
                    					}
                    					else if( expObject instanceof FunctionMacro)
                    					{
                    						r = 0;
                    					}
                    				}
                    				else
                    				{
                    						r = 0;	
                    				}
                     			}

                    }
                    break;
                case 4 :
                    // CppTree.g:900:6: ^( METHOD_CALL id= IDENTIFIER )
                    {
                    match(input,METHOD_CALL,FOLLOW_METHOD_CALL_in_primaryExpression2940); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primaryExpression2944); if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {
                    				if(isMacroDefined(id.toString()))
                    				{
                    					Object expObject = getMacroObject(id.toString());
                    					if(expObject instanceof FunctionMacro)
                    					{
                    						FunctionMacro expMacro = (FunctionMacro)expObject;
                    						if(expMacro.haveArgs())
                    						{
                    							r = 0;
                    							System.out.println("Not Exist Parameter List");
                    						}
                    						else
                    						{
                    							r = expMacro.getExpandedValue();	
                    						}
                    					}
                    					else if(expObject instanceof ObjectMacro)
                    					{
                    						r = ((ObjectMacro)expObject).getExpandedValue();	
                    					}
                    				}
                    				else
                    				{
                    					 r = 0;
                    				}
                    			}

                    }
                    break;
                case 5 :
                    // CppTree.g:928:5: ^( METHOD_CALL id= IDENTIFIER lst= argList )
                    {
                    match(input,METHOD_CALL,FOLLOW_METHOD_CALL_in_primaryExpression2958); if (state.failed) return r;

                    match(input, Token.DOWN, null); if (state.failed) return r;
                    id=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primaryExpression2962); if (state.failed) return r;

                    pushFollow(FOLLOW_argList_in_primaryExpression2966);
                    lst=argList();

                    state._fsp--;
                    if (state.failed) return r;

                    match(input, Token.UP, null); if (state.failed) return r;


                    if ( state.backtracking==0 ) {
                    				if(isMacroDefined(id.toString()))
                    				{
                    					Object expObject = getMacroObject(id.toString());

                    					if(expObject instanceof FunctionMacro)
                    					{
                    						Macrox_stack.push(new Macros_scope());
                    						((Macros_scope)Macrox_stack.peek()).defines = new HashMap();

                    						FunctionMacro expMacro = (FunctionMacro)expObject;
                    						if(expMacro.haveArgs())
                    						{
                    							List formalArgs = expMacro.getArgList();
                    							if(formalArgs.size() != lst.size())
                    							{
                    								r = 0;
                    								System.err.println(" error: macro \"" + id.toString()
                    												 + "\" passed " + lst.size()+ " arguments, but takes just " 
                    												 + formalArgs.size());
                    							}
                    							else
                    							{
                    								for (int i=0; i<formalArgs.size(); i++)
                    								{
                    									putMacroParameter(((MacroParameter)formalArgs.get(i)).text, lst.get(i)); 
                    								}
                    								r = expMacro.getExpandedValue();	
                    							}
                    						}
                    						else
                    						{
                    							r = 0;
                    							System.err.println(" error: macro \"" + id.toString()
                    											 + "\" passed " + lst.size()+ " arguments, but takes just 0" );
                    						}
                    						Macrox_stack.pop();
                    					}
                    					else
                    					{
                    						System.err.println("Function Macro Call Not Defined:"+id.toString());
                    					}
                    				}
                    				else
                    				{
                    					r = 0;
                    				}
                    			}

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
        return r;
    }
    // $ANTLR end "primaryExpression"



    // $ANTLR start "argList"
    // CppTree.g:979:1: argList returns [List r] : ^( ARGS (a= expr )+ ) ;
    public final List argList() throws RecognitionException {
        List r = null;


        int a =0;


         	
        			r = new ArrayList();
        		
        try {
            // CppTree.g:983:3: ( ^( ARGS (a= expr )+ ) )
            // CppTree.g:983:5: ^( ARGS (a= expr )+ )
            {
            match(input,ARGS,FOLLOW_ARGS_in_argList2996); if (state.failed) return r;

            match(input, Token.DOWN, null); if (state.failed) return r;
            // CppTree.g:983:12: (a= expr )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0 >= AMPERSAND && LA33_0 <= AND)||(LA33_0 >= ASSIGNEQUAL && LA33_0 <= BITWISEOREQUAL)||(LA33_0 >= BITWISEXOREQUAL && LA33_0 <= CHARACTER_LITERAL)||LA33_0==DECIMAL_LITERAL||LA33_0==DEFINED||(LA33_0 >= DIVIDE && LA33_0 <= DOT)||LA33_0==EQUAL||LA33_0==EXPR_GROUP||LA33_0==FLOATING_POINT_LITERAL||(LA33_0 >= GREATERTHAN && LA33_0 <= HEX_LITERAL)||LA33_0==IDENTIFIER||LA33_0==INDEX_OP||(LA33_0 >= LESSTHAN && LA33_0 <= LESSTHANOREQUALTO)||(LA33_0 >= METHOD_CALL && LA33_0 <= OR)||(LA33_0 >= PLUS && LA33_0 <= POINTERTO)||(LA33_0 >= POINTER_AT && LA33_0 <= POST_INC)||LA33_0==QUESTIONMARK||LA33_0==REFERANCE||(LA33_0 >= SHIFTLEFT && LA33_0 <= STAR)||LA33_0==STRING_LITERAL||(LA33_0 >= TILDE && LA33_0 <= UNARY_PLUS)||LA33_0==BITWISERXOR) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // CppTree.g:983:13: a= expr
            	    {
            	    pushFollow(FOLLOW_expr_in_argList3001);
            	    a=expr();

            	    state._fsp--;
            	    if (state.failed) return r;

            	    if ( state.backtracking==0 ) { 
            	    				ExpressionReturn arg = new ExpressionReturn();
            	    				arg.value = a;
            	    				r.add(arg); 
            	    			}

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return r;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return r;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return r;
    }
    // $ANTLR end "argList"



    // $ANTLR start "constant"
    // CppTree.g:992:1: constant[boolean eval] returns [ExpressionReturn r] : (c= HEX_LITERAL |c= OCTAL_LITERAL |c= DECIMAL_LITERAL |c= FLOATING_POINT_LITERAL |c= CHARACTER_LITERAL |c= STRING_LITERAL );
    public final ExpressionReturn constant(boolean eval) throws RecognitionException {
        ExpressionReturn r = null;


        CommonTree c=null;

        r = new ExpressionReturn();
        try {
            // CppTree.g:994:3: (c= HEX_LITERAL |c= OCTAL_LITERAL |c= DECIMAL_LITERAL |c= FLOATING_POINT_LITERAL |c= CHARACTER_LITERAL |c= STRING_LITERAL )
            int alt34=6;
            switch ( input.LA(1) ) {
            case HEX_LITERAL:
                {
                alt34=1;
                }
                break;
            case OCTAL_LITERAL:
                {
                alt34=2;
                }
                break;
            case DECIMAL_LITERAL:
                {
                alt34=3;
                }
                break;
            case FLOATING_POINT_LITERAL:
                {
                alt34=4;
                }
                break;
            case CHARACTER_LITERAL:
                {
                alt34=5;
                }
                break;
            case STRING_LITERAL:
                {
                alt34=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return r;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // CppTree.g:994:5: c= HEX_LITERAL
                    {
                    c=(CommonTree)match(input,HEX_LITERAL,FOLLOW_HEX_LITERAL_in_constant3039); if (state.failed) return r;

                    if ( state.backtracking==0 ) { 
                    				if(eval)
                    				{
                    					String decString = c.toString();
                    					if(c.toString().endsWith("ul") || c.toString().endsWith("UL"))
                    					{
                    						decString = c.toString().substring(0,c.toString().length()-2);				
                    					}
                    					else if( c.toString().endsWith("u") || c.toString().endsWith("U") ||
                    					 		 c.toString().endsWith("l") || c.toString().endsWith("L") )
                    					{
                    						decString = c.toString().substring(0,c.toString().length()-1);				
                    					} 
                    					r.value = Long.decode(decString).intValue();
                    				}
                    				else { r.text = c.toString(); } }

                    }
                    break;
                case 2 :
                    // CppTree.g:1012:7: c= OCTAL_LITERAL
                    {
                    c=(CommonTree)match(input,OCTAL_LITERAL,FOLLOW_OCTAL_LITERAL_in_constant3057); if (state.failed) return r;

                    if ( state.backtracking==0 ) {
                    				if(eval)
                    				{
                    					String decString = c.toString();
                    					if(c.toString().endsWith("ul") || c.toString().endsWith("UL"))
                    					{
                    						decString = c.toString().substring(0,c.toString().length()-2);				
                    					}
                    					else if( c.toString().endsWith("u") || c.toString().endsWith("U") ||
                    					 		 c.toString().endsWith("l") || c.toString().endsWith("L") )
                    					{
                    						decString = c.toString().substring(0,c.toString().length()-1);				
                    					} 
                    					r.value = Long.decode(decString).intValue();
                    				}
                    				else { r.text = c.toString(); } 
                    			}

                    }
                    break;
                case 3 :
                    // CppTree.g:1030:7: c= DECIMAL_LITERAL
                    {
                    c=(CommonTree)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_constant3073); if (state.failed) return r;

                    if ( state.backtracking==0 ) { 	if(eval) 
                    				{ 
                    					String decString = c.toString();
                    					if(c.toString().endsWith("ul") || c.toString().endsWith("UL"))
                    					{
                    						decString = c.toString().substring(0,c.toString().length()-2);				
                    					}
                    					else if( c.toString().endsWith("u") || c.toString().endsWith("U") ||
                    					 		 c.toString().endsWith("l") || c.toString().endsWith("L") )
                    					{
                    						decString = c.toString().substring(0,c.toString().length()-1);				
                    					} 
                    					r.value = (new Integer(decString.toString())).intValue(); 
                    				} 
                    				else 
                    				{ r.text = c.toString(); } 
                    			}

                    }
                    break;
                case 4 :
                    // CppTree.g:1048:7: c= FLOATING_POINT_LITERAL
                    {
                    c=(CommonTree)match(input,FLOATING_POINT_LITERAL,FOLLOW_FLOATING_POINT_LITERAL_in_constant3089); if (state.failed) return r;

                    if ( state.backtracking==0 ) { 	if(eval) 
                    				{ 
                    					r.value = (new Float(c.toString())).intValue(); 
                    				} 
                    				else 
                    				{ r.text = c.toString(); } 
                    			}

                    }
                    break;
                case 5 :
                    // CppTree.g:1056:5: c= CHARACTER_LITERAL
                    {
                    c=(CommonTree)match(input,CHARACTER_LITERAL,FOLLOW_CHARACTER_LITERAL_in_constant3103); if (state.failed) return r;

                    if ( state.backtracking==0 ) { 
                    				if(eval) 
                    				{
                                   		String cs = c.toString();
                    	           		char d = cs.charAt(1);
                                   		Character Ch = new Character(d);
                                   		r.value  = Ch.charValue();
                    				}
                    				else 
                    				{ 
                    					r.text = c.toString(); 
                    				} 
                    			}

                    }
                    break;
                case 6 :
                    // CppTree.g:1070:7: c= STRING_LITERAL
                    {
                    c=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_constant3119); if (state.failed) return r;

                    if ( state.backtracking==0 ) { 
                    				if(eval) r.value	= (new Integer(c.toString())).intValue(); 
                    				else  	 r.text		=  c.toString();
                    			}

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
        return r;
    }
    // $ANTLR end "constant"

    // Delegated rules


 

    public static final BitSet FOLLOW_procLine_in_preprocess62 = new BitSet(new long[]{0x0320080A00000002L,0x0A08000040000382L});
    public static final BitSet FOLLOW_fileInclusion_in_procLine92 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_macroDefine_in_procLine102 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_macroUndef_in_procLine113 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_conditionalCompilation_in_procLine124 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_lineControl_in_procLine132 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_diagnostics_in_procLine143 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_macroExecution_in_procLine156 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_text_line_in_procLine167 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_End_in_procLine192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_fileInclusion222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_EXPAND_in_fileInclusion234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAC_FUNCTION_OBJECT_in_macroDefine272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine276 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_macroText_in_macroDefine280 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAC_FUNCTION_in_macroDefine293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine297 = new BitSet(new long[]{0x0010000020000000L});
    public static final BitSet FOLLOW_macroParam_in_macroDefine304 = new BitSet(new long[]{0x0010000020000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_macroText_in_macroDefine312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAC_OBJECT_in_macroDefine325 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine329 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000020L});
    public static final BitSet FOLLOW_macroText_in_macroDefine334 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELLIPSIS_in_macroParam364 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroParam368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELLIPSIS_in_macroParam382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroParam397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_DEFINE_in_macroText426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_source_text_in_macroText431 = new BitSet(new long[]{0x00144010001D6008L,0x1007C86400040008L});
    public static final BitSet FOLLOW_UNDEF_in_macroUndef472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroUndef476 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_conditionalCompilation504 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_conditionalCompilation517 = new BitSet(new long[]{0x0320080A00000000L,0x0A08000040000382L});
    public static final BitSet FOLLOW_statement_in_conditionalCompilation530 = new BitSet(new long[]{0x0000016040000008L});
    public static final BitSet FOLLOW_ELSE_in_conditionalCompilation547 = new BitSet(new long[]{0x0320080A00000000L,0x0A08000040000382L});
    public static final BitSet FOLLOW_statement_in_conditionalCompilation549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LINE_in_lineControl579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_lineControl583 = new BitSet(new long[]{0x0000000000000008L,0x0000800000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_lineControl594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WARNING_in_diagnostics645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERROR_in_diagnostics656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRAGMA_in_diagnostics667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_LINE_in_text_line694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_source_text_in_text_line699 = new BitSet(new long[]{0x00144010001D6008L,0x1007C86400040008L});
    public static final BitSet FOLLOW_procLine_in_statement729 = new BitSet(new long[]{0x0320080A00000002L,0x0A08000040000382L});
    public static final BitSet FOLLOW_macroExpansion_in_source_text764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_source_text777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatenate_in_source_text789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_source_text803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_source_text817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RPAREN_in_source_text834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_source_text850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_OP_in_source_text866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_source_text880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_GROUP_in_source_text893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_END_in_source_text907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_GROUP_in_source_text922 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_macArgs_in_source_text926 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRINGIFICATION_in_source_text942 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_primarySource_in_source_text947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCATENATE_in_concatenate988 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_primarySource_in_concatenate997 = new BitSet(new long[]{0x0014400000186008L,0x0000884000040000L});
    public static final BitSet FOLLOW_constant_in_primarySource1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COPERATOR_in_primarySource1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CKEYWORD_in_primarySource1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_primarySource1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARPSHARP_in_primarySource1096 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primarySource1101 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primarySource1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPAND_in_macroExpansion1145 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroExpansion1149 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPAND_in_macroExpansion1163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroExpansion1167 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_macArgs_in_macroExpansion1171 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXP_ARGS_in_macArgs1203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_mArg_in_macArgs1208 = new BitSet(new long[]{0x0000020000000008L});
    public static final BitSet FOLLOW_EXP_ARG_in_mArg1245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_source_text_in_mArg1250 = new BitSet(new long[]{0x00144010001D6008L,0x1007C86400040008L});
    public static final BitSet FOLLOW_EXP_ARG_in_mArg1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXEC_MACRO_in_macroExecution1288 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_macroExecution1292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_in_expression1318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expression1322 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_DEF_in_expression1335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression1339 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_NDEF_in_expression1349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression1354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assignmentExpression_in_expr1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_expr1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalOrExpression_in_expr1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalAndExpression_in_expr1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_expr1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_expr1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_expr1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equalityExpression_in_expr1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalExpression_in_expr1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftExpression_in_expr1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_expr1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_expr1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_expr1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_expr1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_expr1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGNEQUAL_in_assignmentExpression1532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1542 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1546 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TIMESEQUAL_in_assignmentExpression1560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1571 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1575 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDEEQUAL_in_assignmentExpression1589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1599 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1603 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUSEQUAL_in_assignmentExpression1617 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1629 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUSEQUAL_in_assignmentExpression1647 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1658 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1662 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHIFTLEFTEQUAL_in_assignmentExpression1676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1683 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1687 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHIFTRIGHTEQUAL_in_assignmentExpression1701 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1707 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEANDEQUAL_in_assignmentExpression1725 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1731 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1735 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEXOREQUAL_in_assignmentExpression1749 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1755 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1759 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEOREQUAL_in_assignmentExpression1773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1780 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1784 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODEQUAL_in_assignmentExpression1798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1811 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_assignmentExpression1815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUESTIONMARK_in_conditionalExpression1842 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_conditionalExpression1846 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_conditionalExpression1850 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression1852 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_conditionalExpression1856 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_logicalOrExpression1887 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_logicalOrExpression1891 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_logicalOrExpression1895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_logicalAndExpression1928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_logicalAndExpression1932 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_logicalAndExpression1936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEOR_in_inclusiveOrExpression1966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_inclusiveOrExpression1970 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_inclusiveOrExpression1974 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISERXOR_in_exclusiveOrExpression2005 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_exclusiveOrExpression2009 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_exclusiveOrExpression2013 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_andExpression2043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_andExpression2047 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_andExpression2051 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOTEQUAL_in_equalityExpression2080 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_equalityExpression2084 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_equalityExpression2088 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUAL_in_equalityExpression2102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_equalityExpression2108 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_equalityExpression2112 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESSTHAN_in_relationalExpression2142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2150 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2154 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATERTHAN_in_relationalExpression2176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2184 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESSTHANOREQUALTO_in_relationalExpression2210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2216 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATERTHANOREQUALTO_in_relationalExpression2242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2246 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_relationalExpression2250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHIFTLEFT_in_shiftExpression2284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_shiftExpression2290 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_shiftExpression2294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SHIFTRIGHT_in_shiftExpression2310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_shiftExpression2315 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_shiftExpression2319 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression2352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_additiveExpression2356 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_additiveExpression2360 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpression2379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_additiveExpression2384 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_additiveExpression2388 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression2420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_multiplicativeExpression2425 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_multiplicativeExpression2429 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_multiplicativeExpression2446 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_multiplicativeExpression2452 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_multiplicativeExpression2456 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_multiplicativeExpression2470 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_multiplicativeExpression2476 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_multiplicativeExpression2480 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unaryExpression2508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2513 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUSMINUS_in_unaryExpression2527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REFERANCE_in_unaryExpression2546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2550 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POINTER_AT_in_unaryExpression2564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_MINUS_in_unaryExpression2582 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_PLUS_in_unaryExpression2600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SIZEOF_in_unaryExpression2617 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2623 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SIZEOF_TYPE_in_unaryExpression2635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unaryExpression2639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_unaryExpression2651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2657 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpression2671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2676 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TYPECAST_in_unaryExpression2690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unaryExpression2695 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_unaryExpression2699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINED_in_unaryExpression2710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unaryExpression2716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POST_INC_in_postfixExpression2742 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2747 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POST_DEC_in_postfixExpression2767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POINTERTO_in_postfixExpression2786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2790 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression2795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POINTER_in_postfixExpression2807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2812 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression2817 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_postfixExpression2829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2835 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression2840 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDEX_OP_in_postfixExpression2853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2858 = new BitSet(new long[]{0xC8174081075037B0L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_expr_in_postfixExpression2863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_constant_in_primaryExpression2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPR_GROUP_in_primaryExpression2909 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_primaryExpression2913 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primaryExpression2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_CALL_in_primaryExpression2940 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primaryExpression2944 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_CALL_in_primaryExpression2958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primaryExpression2962 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_argList_in_primaryExpression2966 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGS_in_argList2996 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_argList3001 = new BitSet(new long[]{0xC8174081075037B8L,0x21F0BF82BBEFFC00L});
    public static final BitSet FOLLOW_HEX_LITERAL_in_constant3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_LITERAL_in_constant3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_constant3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATING_POINT_LITERAL_in_constant3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_LITERAL_in_constant3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_constant3119 = new BitSet(new long[]{0x0000000000000002L});

}