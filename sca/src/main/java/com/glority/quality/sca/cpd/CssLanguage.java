
package com.glority.quality.sca.cpd;

public class CssLanguage extends AbstractLanguage {
    public CssLanguage() {
        super(new CssTokenizer(), ".css");
    }
}
