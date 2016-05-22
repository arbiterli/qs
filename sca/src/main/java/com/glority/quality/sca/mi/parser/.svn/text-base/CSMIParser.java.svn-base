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

import com.glority.quality.sca.antlr.cs.CSharp4;

/**
 * C# MI parser API.
 * @author LYX
 */
public class CSMIParser extends CSharp4 implements IMISourceCodeParser {
    private List functions;

    public CSMIParser(TokenStream input) {
        super(input);
        functions = new ArrayList();
    }

    public List getFunctions() {
        return functions;
    }

    public boolean isCC(Token t) {
        return CSHARP_CC_TOKENS.contains(t.getType());
    }

    public boolean isComment(Token t) {
        return CSHARP_COMMENT_TOKENS.contains(t.getType());
    }

    public boolean isIgnoreAble(Token t) {
        return CSHARP_IGNORABLE_TOKENS.contains(t.getType());
    }

    public boolean isOperand(Token t) {
        return CSHARP_OPERAND_TOKENS.contains(t.getType());
    }

    public boolean isFunctionHeadEnd(Token t) {
        return (t.getType() == CLOSE_PARENS);
    }

    public Tree getAST() {
        try {
            return (Tree) compilation_unit().getTree();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    // CHECKSTYLE IGNORE Method_Names FOR NEXT 1 LINES
    public final CSharp4.method_definition_return method_definition()
            throws RecognitionException {
        CSharp4.method_definition_return retval = super.method_definition();
        Tree tree = (Tree) retval.getTree();
        if (tree != null) {
            functions.add(retval);
        }
        return retval;
    }

    public static final Set CSHARP_OPERAND_TOKENS = new HashSet(Arrays.asList(
            IDENTIFIER, Available_identifier, Identifier_or_keyword,
            Identifier_start_character, Identifier_part_character,
            Letter_character, Combining_character, Decimal_digit_character,
            Connecting_character, Formatting_character, INTEGER_LITERAL,
            Decimal_integer_literal, Decimal_digits, DECIMAL_DIGIT,
            Integer_type_suffix, Hexadecimal_integer_literal, Hex_digits,
            HEX_DIGIT, LiteralAccess, REAL_LITERAL, Exponent_part,
            Real_type_suffix, CHARACTER_LITERAL, Character, Single_character,
            Simple_escape_sequence, Hexadecimal_escape_sequence,
            STRING_LITERAL, Regular_string_literal,
            Regular_string_literal_character,
            Single_regular_string_literal_character, Verbatim_string_literal,
            Verbatim_string_literal_character,
            Single_verbatim_string_literal_character, Quote_escape_sequence));
    public static final Set CSHARP_CC_TOKENS = new HashSet(Arrays.asList(CASE,
            CATCH, DEFAULT, DO, ELSE, FINALLY, FOR, GOTO, IF, SWITCH, TRY,
            WHILE));
    public static final Set CSHARP_COMMENT_TOKENS = new HashSet(Arrays.asList(
            DELIMITED_DOC_COMMENT, DELIMITED_COMMENT, SINGLE_LINE_COMMENT,
            SINGLE_LINE_DOC_COMMENT));
    public static final Set CSHARP_IGNORABLE_TOKENS = new HashSet(
            Arrays.asList(EOF, CLOSE_BRACE, CLOSE_BRACKET, CLOSE_PARENS,
                    Whitespace_character, Whitespace_characters, WHITESPACE));
}
