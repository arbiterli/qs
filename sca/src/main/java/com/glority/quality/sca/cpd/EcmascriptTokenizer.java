package com.glority.quality.sca.cpd;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import com.glority.quality.sca.antlr.ecmascript.ES3Lexer;
import com.glority.quality.sca.antlr.ecmascript.ES3Parser;

/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
public class EcmascriptTokenizer extends AbstractTokenizer {
    public void tokenize(SourceCode sourceCode, Tokens tokenEntries) {
        ANTLRStringStream input = new ANTLRStringStream(sourceCode
                .getCodeBuffer().toString());
        ES3Lexer es3Lexer = new ES3Lexer(input);
        CommonTokenStream cts = new CommonTokenStream(es3Lexer);

        ES3Parser parser = new ES3Parser(cts);
        Tree ast = null;
        try {
            ast = (Tree) parser.program().getTree();
        } catch (Exception e) {
            System.out.println("failed to parser " + sourceCode.getFileName());
        }
        if (ast != null) {
            addAstTree(ast, sourceCode, tokenEntries);
        }
        tokenEntries.add(TokenEntry.getEOF(tokenEntries.getType()));
    }

    private void addAstTree(Tree astTree, SourceCode sourceCode,
            Tokens tokenEntries) {
        if (ignorableNode(astTree)) {
            return;
        }
        tokenEntries.add(new TokenEntry(astTree.getText(), sourceCode
                .getFileName(), astTree.getLine(), tokenEntries.getType()));
        int childCount = astTree.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Tree child = astTree.getChild(i);
            if (child.getChildCount() < 1) {
                if (!ignorableNode(child)) {
                    tokenEntries.add(new TokenEntry(child.getText(), sourceCode
                            .getFileName(), child.getLine(), tokenEntries.getType()));
                }
            } else {
                addAstTree(child, sourceCode, tokenEntries);
            }
        }
    }

    private boolean ignorableNode(Tree node) {
        // TODO in js, DQUOTE and SQUOTE can be treated as the same
        // We need add this logic
        return node.getType() == ES3Lexer.SEMIC;
    }
}