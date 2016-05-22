/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

public class CsLanguage extends AbstractLanguage {
    public CsLanguage() {
        super(new CsTokenizer(), ".cs");
    }
}
