/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

public class JSPLanguage extends AbstractLanguage {
    public JSPLanguage() {
        super(new JSPTokenizer(), ".jsp", ".jspx");
    }
}
