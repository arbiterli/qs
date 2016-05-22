package com.glority.quality.sca.antlr;

import java.io.File;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.antlr.runtime.tree.Tree;

import com.glority.quality.sca.antlr.cpp.CppLexer;
import com.glority.quality.sca.antlr.cpp.CppParser;
import com.glority.quality.sca.antlr.cs.CSharp4;
import com.glority.quality.sca.antlr.cs.CSharp4PreProcessor;
import com.glority.quality.sca.antlr.ecmascript.ES3Lexer;
import com.glority.quality.sca.antlr.ecmascript.ES3Parser;
import com.glority.quality.sca.antlr.java.JavaLexer;
import com.glority.quality.sca.antlr.java.JavaParser;
/**
 * This class is the factory of language parsers. 
 * You can get Lexer, parser, AST or tokensteams for all supported languages.
 * 
 * @author XQS
 *
 */
public class LanguageParserFactory {
	private static LanguageParserFactory instance = new LanguageParserFactory();
	private LanguageParserFactory() {
		
	}
	
	public static LanguageParserFactory getInstance() {
		return instance;
	}
	
	/**
	 * The list of language the parser engine supported
	 * @author XQS
	 *
	 */
	public enum LanguageEnum {
		CPP,
		JAVA,
		CS,
		JS		
	}
	/**
	 * Get the lexer for the given file
	 * @param file
	 * @param lang
	 * @return
	 */
	public Lexer getLexer(File file, LanguageEnum lang) {
		try {
			ANTLRFileStreamWithBOM input = new ANTLRFileStreamWithBOM(file.getPath());
			Lexer lexer = null;
			switch(lang) {
		    case CPP: 
		    	lexer = new CppLexer(input);
		        break;
		    case JAVA: 
		    	lexer = new JavaLexer(input);
		        break;
		    case CS: 
		    	lexer = new CSharp4PreProcessor(input);
		        break;
		    case JS: 
		    	lexer = new ES3Lexer(input);
                break;		    
		    default: 
		    	//Do Nothing
		    }
			
		    return lexer;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
			//TODO: Handle this exception better
		}		
		
	}	
	/**
	 * Get the tokenstream of the given file
	 * 
	 * Note: The token stream is empty before running the parser
	 * @param file
	 * @param lang
	 * @return
	 */
	public CommonTokenStream getTokenStream(File file, LanguageEnum lang) {
		Lexer lexer = getLexer(file, lang);
		if(lexer == null) {
			return null;
		}
		return new CommonTokenStream(lexer);
	}
	/**
	 * Get the grammar parser of the given file
	 * @param file
	 * @param lang
	 * @return
	 */
	public Parser getParser(File file, LanguageEnum lang) {
		try{
			CommonTokenStream cts = getTokenStream(file, lang);
			Parser parser = null;
			switch(lang) {
		    case CPP: 
		    	parser = new CppParser(cts);
		    	break;
		    case JAVA: 
		    	parser = new JavaParser(cts);
		    	break;
		    case CS: 
		    	parser = new CSharp4(cts);
		    	break;
		    case JS: 
		    	parser = new ES3Parser(cts);
		    	break;
		    default: 
		    	//Do Nothing
		    }
			
		    return parser;			
		}catch(Exception e) {
			e.printStackTrace();
			//TODO: need better error handle
			return null;
		}		
		
	}
    /**
     * Get the abstract syntax tree of the given source file
     * TODO: the tree does not support all files now.  Further refactoring is needed
     * 
     * @param file
     * @param lang
     * @return
     */
	public Tree getAst(File file, LanguageEnum lang) {
		try{
			CommonTokenStream cts = getTokenStream(file, lang);
			Tree ast = null;
			switch(lang) {
		    case CPP: {
		    	//TODO: the cpp ast is not fully correct, need further fix
		    	// Need fix inline defines
		    	CppParser cppParser = new CppParser(cts);
		    	ast = (Tree)cppParser.preprocess().getTree();
		    	break;
		    }
		    case JAVA: { 
		    	JavaParser javaParser = new JavaParser(cts);
		    	ast = (Tree)javaParser.compilationUnit().getTree();
		    	break;
		    }
		    case CS: {
		    	CSharp4 csParser = new CSharp4(cts);
		    	ast = (Tree)csParser.compilation_unit().getTree();
		    	break;
		    }
		    case JS: { 
		    	ES3Parser jsParser = new ES3Parser(cts);
		    	ast = (Tree)jsParser.program().getTree();
		    	break;
		    }
		    default: 
		    	//Do Nothing
		    }			
		    return ast;			
		}catch(Exception e) {
			e.printStackTrace();
			
			//TODO: need better error handle
			return null;
		}
	}
	
	public Tree getAstFromParser(Parser parser, LanguageEnum lang) {
		try{
			Tree ast = null;
			switch(lang) {
		    case CPP: {
		    	CppParser cppParser = (CppParser)parser;
		    	ast = (Tree)cppParser.preprocess().getTree();
		    	break;
		    }
		    case JAVA: { 
		    	JavaParser javaParser = (JavaParser)parser;
		    	ast = (Tree)javaParser.compilationUnit().getTree();
		    	break;
		    }
		    case CS: {
		    	CSharp4 csParser = (CSharp4)parser;
		    	ast = (Tree)csParser.compilation_unit().getTree();
		    	break;
		    }
		    case JS: { 
		    	ES3Parser jsParser = (ES3Parser)parser;
		    	ast = (Tree)jsParser.program().getTree();
		    	break;
		    }
		    default: 
		    	//Do Nothing
		    }			
		    return ast;
		}
		catch(Exception e){
			e.printStackTrace();	
			//TODO: need better error handle
			return null;
		}
	}
	
	public Parser getParserFromTokenStream(CommonTokenStream cts, LanguageEnum lang) {
		try{			
			Parser parser = null;
			switch(lang) {
		    case CPP: 
		    	parser = new CppParser(cts);
		    	break;
		    case JAVA: 
		    	parser = new JavaParser(cts);
		    	break;
		    case CS: 
		    	parser = new CSharp4(cts);
		    	break;
		    case JS: 
		    	parser = new ES3Parser(cts);
		    	break;
		    default: 
		    	//Do Nothing
		    }
			
		    return parser;			
		}catch(Exception e) {
			e.printStackTrace();
			//TODO: need better error handle
			return null;
		}		
		
	}
}
