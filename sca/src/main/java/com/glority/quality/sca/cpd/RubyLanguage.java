/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 * @author Zev Blut zb@ubit.com
 */
package com.glority.quality.sca.cpd;

public class RubyLanguage extends AbstractLanguage {
    public RubyLanguage() {
        super(new RubyTokenizer(), ".rb", ".cgi", ".class");
    }
}
