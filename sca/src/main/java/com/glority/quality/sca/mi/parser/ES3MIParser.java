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

import com.glority.quality.sca.antlr.ecmascript.ES3Parser;

/**
 * javascript MI parser API.
 * @author LYX
 */
public class ES3MIParser extends ES3Parser implements IMISourceCodeParser {
    private List functions;

    public ES3MIParser(TokenStream input) {
        super(input);
        functions = new ArrayList();
    }

    public List getFunctions() {
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

    public List getFunctionComments(ParserRuleReturnScope mrs) {
        List comments = new ArrayList();
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
            return (Tree) program().getTree();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final ES3Parser.formalParameterList_return formalParameterList()
            throws RecognitionException {
        ES3Parser.formalParameterList_return retval = new ES3Parser.formalParameterList_return();
        Token startToken = super.input.LT(-1);
        int rCurly = 0;
        int tokenNum = 1;
        boolean visitedRCurly = false;
        Token stopToken = null;
        // to find the end "}" of the function
        while (true) {
            if (super.input.LT(tokenNum).getType() == LBRACE) {
                rCurly++;
            } else if (super.input.LT(tokenNum).getType() == RBRACE) {
                rCurly--;
                visitedRCurly = true;
            }
            if (rCurly == 0 && visitedRCurly) {
                stopToken = super.input.LT(tokenNum);
                break;
            }
            tokenNum++;
        }
        retval = super.formalParameterList();
        Tree tree = (Tree) retval.getTree();
        if (tree != null) {
            retval.start = startToken;
            retval.stop = stopToken;
            functions.add(retval);
        }
        return retval;
    }

    public static final Set JAVA_OPERAND_TOKENS = new HashSet(Arrays.asList(
            IdentifierStartASCII, IdentifierPart, IdentifierNameASCIIStart,
            Identifier, DecimalDigit, HexDigit, OctalDigit, ExponentPart,
            DecimalIntegerLiteral, DecimalLiteral, OctalIntegerLiteral,
            HexIntegerLiteral, CharacterEscapeSequence, ZeroToThree,
            OctalEscapeSequence, HexEscapeSequence, UnicodeEscapeSequence,
            EscapeSequence, StringLiteral, RegularExpressionLiteral,
            BackslashSequence, RegularExpressionFirstChar,
            RegularExpressionChar));
    public static final Set JAVA_CC_TOKENS = new HashSet(Arrays.asList(CASE,
            CATCH, DEFAULT, DO, ELSE, FINALLY, FOR, GOTO, IF, SWITCH, TRY,
            WHILE));
    public static final Set JAVA_COMMENT_TOKENS = new HashSet(Arrays.asList(
            MultiLineComment, SingleLineComment));
    public static final Set JAVA_IGNORABLE_TOKENS = new HashSet(Arrays.asList(
            EOF, RBRACE, RBRACK, RPAREN, WhiteSpace));
}
