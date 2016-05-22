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

import com.glority.quality.sca.antlr.cpp.CppParser;

/**
 * CPP MI parser API.
 * 
 * @author LYX
 */
public class CppMIParser extends CppParser implements IMISourceCodeParser {
    private List<ParserRuleReturnScope> functions;

    public CppMIParser(TokenStream input) {
        super(input);
        functions = new ArrayList<ParserRuleReturnScope>();
    }

    public List<ParserRuleReturnScope> getFunctions() {
        return functions;
    }

    public boolean isCC(Token t) {
        return CPP_CC_TOKENS.contains(t.getText());
    }

    public boolean isComment(Token t) {
        return CPP_COMMENT_TOKENS.contains(t.getType());
    }

    public boolean isIgnoreAble(Token t) {
        return CPP_IGNORABLE_TOKENS.contains(t.getType());
    }

    public boolean isOperand(Token t) {
        return CPP_OPERAND_TOKENS.contains(t.getType());
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
            return (Tree) preprocess().getTree();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * because CppParser.java get the type macroExpansion contains most string
     * type as "*(*)" ,need to get the real function declaration in the
     * function,the k++ and t++ operation is to skip whitespace ,j++ is to find
     * ")",rCurly record the number of "}" to find the the last "}" in the
     * function.
     **/
    public ParserRuleReturnScope functionDeclaration()
            throws RecognitionException {
        ParserRuleReturnScope mrs = new ParserRuleReturnScope();
        TokenStream tokens = super.getTokenStream();
        // super.reset();
        super.preprocess();
        for (int i = 0; i < tokens.size(); i++) {
            int rCurly = 1;
            int j = 1, t = 1;
            Token token = tokens.get(i);
            if (KEYWORD.contains(token.getText())) {
                continue;
            }

            int k = 1;
            while (tokens.get(i + k).getType() == WS
                    || tokens.get(i + k).getType() == TEXT_END) {
                k++;
            }
            if (!"(".equals(tokens.get(i + k).getText())) {
                continue;
            }
            while (!")".equals(tokens.get(i + j).getText())) {
                j++;
            }
            while (tokens.get(i + j + t).getType() == WS
                    || tokens.get(i + j + t).getType() == TEXT_END) {
                t++;
            }
            if ("{".equals(tokens.get(i + j + t).getText())) {
                mrs = new ParserRuleReturnScope();
                mrs.start = tokens.get(i);
                int stop = i + j + t + 1;
                while (rCurly > 0) {
                    if ("{".equals(tokens.get(stop).getText())) {
                        rCurly++;
                    } else if ("}".equals(tokens.get(stop).getText())) {
                        rCurly--;
                    }
                    if (rCurly > 0) {
                        stop++;
                    }
                }
                mrs.stop = tokens.get(stop);
                functions.add(mrs);
            }

        }
        return mrs;
    }

    public static final Set CPP_OPERAND_TOKENS = new HashSet(Arrays.asList(
            IDENTIFIER, CHARACTER_LITERAL, FLOATING_POINT_LITERAL,
            FloatTypeSuffix, EscapeSequence, Exponent, HexDigit, HEX_LITERAL,
            LETTER, IntegerTypeSuffix, DECIMAL_LITERAL, OctalEscape,
            UnicodeEscape, STRING_LITERAL));
    public static final Set CPP_CC_TOKENS = new HashSet(Arrays.asList("while",
            "else", "if", "case", "catch", "default", "do", "goto", "for",
            "finally", "try", "switch"));
    public static final Set CPP_COMMENT_TOKENS = new HashSet(Arrays.asList(
            COMMENT, LINE_COMMENT, LINECOMMENTS));
    public static final Set CPP_IGNORABLE_TOKENS = new HashSet(Arrays.asList(
            EOF, RCURLY, RSQUARE, RPAREN, WS));

    public static final Set KEYWORD = new HashSet(Arrays.asList("while",
            "else", "if", "catch", "do", "for", "finally", "try", "switch",
            "for_each", "throw", " "));
}
