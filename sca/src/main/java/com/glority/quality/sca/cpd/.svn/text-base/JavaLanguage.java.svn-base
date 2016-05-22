/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import java.util.Properties;

public class JavaLanguage extends AbstractLanguage {
    public JavaLanguage() {
        this(System.getProperties());
    }

    public JavaLanguage(Properties properties) {
        super(new JavaTokenizer(), ".java");
        JavaTokenizer tokenizer = (JavaTokenizer) getTokenizer();
        tokenizer.setProperties(properties);
    }
}
