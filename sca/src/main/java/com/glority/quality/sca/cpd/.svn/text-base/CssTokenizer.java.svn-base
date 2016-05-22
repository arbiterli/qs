package com.glority.quality.sca.cpd;

import java.util.ArrayList;

/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 * 
 * @author Zev Blut zb@ubit.com
 */

public class CssTokenizer extends AbstractTokenizer {
    public CssTokenizer() {
        // setting markers for "string" in css
        this.stringToken = new ArrayList<String>();
        this.stringToken.add("\'");
        // setting markers for 'ignorable character' in css
        this.ignorableCharacter = new ArrayList<String>();
        this.ignorableCharacter.add("{");
        this.ignorableCharacter.add("}");
        this.ignorableCharacter.add("(");
        this.ignorableCharacter.add(")");
        this.ignorableCharacter.add(";");
        this.ignorableCharacter.add(",");

        // setting markers for 'ignorable string' in css
        this.ignorableStmt = new ArrayList<String>();
        this.ignorableStmt.add("while");
    }
}
