/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import java.util.HashMap;
import java.util.Map;

public class TokenEntry implements Comparable<TokenEntry> {

    public static final TokenEntry EOF = new TokenEntry();

    private String tokenSrcID;
    private int beginLine;
    private int index;
    private int identifier;
    private int hashCode;
    private int type;

    private static final Map<String, Integer> TOKENS = new HashMap<String, Integer>();
    private static int tokenCount = 0;
    private static int baseTokenCount = 0;

    private TokenEntry() {
        this.identifier = 0;
        this.tokenSrcID = "EOFMarker";
    }

    public TokenEntry(String image, String tokenSrcID, int beginLine, int type) {
        Integer i = TOKENS.get(image);
        if (i == null) {
            i = TOKENS.size() + 1;
            TOKENS.put(image, i);
        }
        this.identifier = i.intValue();
        this.tokenSrcID = tokenSrcID;
        this.beginLine = beginLine;
        this.type = type;
        if (type == 1) {
            this.index = tokenCount++;
        } else {
            this.index = baseTokenCount++;
        }
    }

    public static TokenEntry getEOF(int type) {
        if (type == 1) {
            tokenCount++;
        } else {
            baseTokenCount++;
        }
        return EOF;
    }

    public static void clearImages() {
        TOKENS.clear();
        tokenCount = 0;
        baseTokenCount = 0;
    }

    public int getType() {
        return type;
    }

    public String getTokenSrcID() {
        return tokenSrcID;
    }

    public int getBeginLine() {
        return beginLine;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public boolean equals(Object o) {
        if (!(o instanceof TokenEntry)) {
            return false;
        }
        TokenEntry other = (TokenEntry) o;
        return other.hashCode == hashCode;
    }

    public int compareTo(TokenEntry other) {
        return getIndex() - other.getIndex();
    }
}