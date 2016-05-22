package com.glority.quality.sca.mi.parser;

import java.util.List;

import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.Tree;

/**
 * The interface for MI source code parser. This interface defines the methods required to be implemented for a language
 * if we want to calculate MI.
 * 
 * @author XQS
 * 
 */
public interface IMISourceCodeParser {
    /**
     * Return true if the token is an operator.
     * 
     * @return
     */
    boolean isOperator(Token t);

    /**
     * return true if the token is an operand.
     * 
     * @return
     */
    boolean isOperand(Token t);

    /**
     * Return true if the token is an Cyclomatic complexity operator.
     * 
     * @return
     */
    boolean isCC(Token t);

    /**
     * return return is the token is comment.
     * 
     * @return
     */
    boolean isComment(Token t);

    /**
     * return true if the token is ignorable.
     * 
     * @return
     */
    boolean isIgnoreAble(Token t);

    /**
     * The token marks the function head end. This will be used to get the function definition Normally it will be ')'.
     * 
     * @param t
     * @return
     */
    boolean isFunctionHeadEnd(Token t);

    /**
     * Return the list of function ParserRuleReturnScope. MI is function based, this function is used to get the list of
     * functions in the give source stream.
     * 
     * @param t
     * @return
     */
    List getFunctions();

    /**
     * This function is used to get the comments above the function Normally saying, there will be some comments above a
     * function. but the function ParserRuleReturnScope included in the getFunctions list does not include these comment
     * tokens. So we need a extra API to get the comments for the given function.
     * 
     * @param mrs
     * @return
     */
    List getFunctionComments(ParserRuleReturnScope mrs);

    /**
     * Return the full AST of the give source Stream.
     * 
     * @return
     */
    Tree getAST();

    /**
     * Get the full token Stream.
     * 
     * @return
     */
    TokenStream getTokenStream();
}
