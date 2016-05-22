/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 * @author Romain PELISSE belaran@gmail.com
 */
package com.glority.quality.sca.cpd;

public class FortranLanguage extends AbstractLanguage {
    public FortranLanguage() {
        super(new FortranTokenizer(), ".for");
    }
}
