/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import java.io.IOException;

public interface Tokenizer {
    void tokenize(SourceCode sourceCode, Tokens tokenEntries)
            throws IOException;
}
