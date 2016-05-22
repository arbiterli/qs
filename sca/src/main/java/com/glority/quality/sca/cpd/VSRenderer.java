/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import net.sourceforge.pmd.PMD;

import java.io.File;
import java.util.Iterator;

public class VSRenderer implements Renderer {

    public String render(Iterator<Match> matches, File outputFile) {

        StringBuilder buffer = new StringBuilder(300);

        for (Match match; matches.hasNext();) {
            match = matches.next();
            TokenEntry mark;
            for (Iterator<TokenEntry> iterator = match.iterator(); iterator
                    .hasNext();) {
                mark = iterator.next();
                buffer.append(mark.getTokenSrcID());
                buffer.append('(').append(mark.getBeginLine()).append("):");
                buffer.append(" Between lines " + mark.getBeginLine() + " and "
                        + (mark.getBeginLine() + match.getLineCount())
                        + PMD.EOL);
            }
        }
        return buffer.toString();
    }
}
