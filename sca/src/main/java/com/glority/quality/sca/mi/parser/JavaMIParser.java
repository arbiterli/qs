package com.glority.quality.sca.mi.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.Tree;

import com.glority.quality.sca.antlr.java.JavaParser;

/**
 * This is the Java antlr parser extension used to calculate MI metrics To make
 * it be able to locate the method block easier, we need extend the method
 * process code.
 * 
 * Note: the method process code in JavaParser is final. We need remove the
 * final prefix from the antlr generated code.
 * 
 * @author XQS
 * 
 */
public class JavaMIParser extends JavaParser implements IMISourceCodeParser {
    private List<ParserRuleReturnScope> functions;

    public JavaMIParser(TokenStream input) {
        super(input);
        functions = new ArrayList<ParserRuleReturnScope>();
    }

    public List<ParserRuleReturnScope> getFunctions() {
        return functions;
    }

    public boolean isCC(Token t) {
        return JAVA_CC_TOKENS.contains(t.getType());
    }

    public boolean isComment(Token t) {
        return JAVA_COMMENT_TOKENS.contains(t.getType());
    }

    public boolean isIgnoreAble(Token t) {
        return JAVA_IGNORABLE_TOKENS.contains(t.getType());
    }

    public boolean isOperand(Token t) {
        return JAVA_OPERAND_TOKENS.contains(t.getType());
    }

    public boolean isFunctionHeadEnd(Token t) {
        return (t.getType() == RPAREN);
    }

    public boolean isOperator(Token t) {
        return !(isIgnoreAble(t) || isOperand(t) || isComment(t));
    }

    public List<Token> getFunctionComments(ParserRuleReturnScope mrs) {
        List<Token> comments = new ArrayList<Token>();
        Token t = (Token) mrs.getStart();
        int ti = t.getTokenIndex() - 1;
        while (ti >= 0) {
            Token ct = input.get(ti);
            if (isComment(ct)) {
                comments.add(ct);
            } else {
                break;
            }
            ti--;
        }
        return comments;
    }

    public Tree getAST() {
        try {
            return (Tree) compilationUnit().getTree();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Overwrite the methodDeclaration(). Put the found methods to a list.
     * 
     * Note: Since the original method in parent class is final. we need update
     * the parent class to remove the final token.
     * 
     */
    public final JavaParser.methodDeclaration_return methodDeclaration()
            throws RecognitionException {
        JavaParser.methodDeclaration_return retval = super.methodDeclaration();
        Tree tree = (Tree) retval.getTree();
        if (tree != null) {
            functions.add(retval);
        }
        return retval;
    }

    public  static final Set<Integer> JAVA_OPERAND_TOKENS = new HashSet<Integer>(
            Arrays.asList(CHARLITERAL, DOUBLELITERAL, DoubleSuffix,
                    EscapeSequence, Exponent, FLOATLITERAL, FloatSuffix,
                    HexDigit, HexPrefix, IDENTIFIER, INTLITERAL,
                    IdentifierPart, IdentifierStart, IntegerNumber,
                    LONGLITERAL, LongSuffix, NULL, NonIntegerNumber,
                    STRINGLITERAL, SurrogateIdentifer));
    public  static final Set<Integer> JAVA_CC_TOKENS = new HashSet<Integer>(
            Arrays.asList(CASE, CATCH, DEFAULT, DO, ELSE, FINALLY, FOR, GOTO,
                    IF, SWITCH, TRY, WHILE));
    public  static final Set<Integer> JAVA_COMMENT_TOKENS = new HashSet<Integer>(
            Arrays.asList(COMMENT, LINE_COMMENT));
    public  static final Set<Integer> JAVA_IGNORABLE_TOKENS = new HashSet<Integer>(
            Arrays.asList(EOF, RBRACE, RBRACKET, RPAREN, WS));
}
