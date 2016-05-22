/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchAlgorithm {

    private static final int MOD = 37;
    private int lastHash;
    private int lastMod = 1;

    private List<Match> matches;
    private Map<String, SourceCode> source;
    private Tokens tokens;
    private List<TokenEntry> code;
    private List<TokenEntry> baseCode;
    private CPDListener cpdListener;
    private int min;

    public MatchAlgorithm(Map<String, SourceCode> sourceCode, Tokens tokens, Tokens baseTokens, int min) {
        this(sourceCode, tokens, baseTokens, min, new CPDNullListener());
    }

    public MatchAlgorithm(Map<String, SourceCode> sourceCode, Tokens tokens, Tokens baseTokens, int min,
            CPDListener listener) {
        this.source = sourceCode;
        this.tokens = tokens;
        this.code = tokens.getTokens();
        this.baseCode = baseTokens.getTokens();
        this.min = min;
        this.cpdListener = listener;
        for (int i = 0; i < min; i++) {
            lastMod *= MOD;
        }
    }

    public void setListener(CPDListener listener) {
        this.cpdListener = listener;
    }

    public Iterator<Match> matches() {
        return matches.iterator();
    }

    public TokenEntry tokenAt(int offset, TokenEntry m, List<TokenEntry> code) {
        return code.get(offset + m.getIndex());
    }
    
    public TokenEntry tokenAt(int offset, TokenEntry m) {
        return code.get(offset + m.getIndex());
    }
    
    public TokenEntry tokenAt(int offset, TokenEntry m, int type) {
        if(type == 1){
            return code.get(offset + m.getIndex());
        } else {
            return baseCode.get(offset + m.getIndex());
        }
    } 

    public int getMinimumTileSize() {
        return this.min;
    }

    public void findMatches(boolean isSlice) {
        cpdListener.phaseUpdate(CPDListener.HASH);
        Map<TokenEntry, Object> markGroups = null;
        if(isSlice){
            Map<TokenEntry, Object> markGroups1 = hash(code, isSlice);
            Map<TokenEntry, Object> markGroups2 = hash(baseCode, isSlice);
            markGroups = mergeHash(markGroups1, markGroups2);
        } else {
            markGroups = hash(code, isSlice);
        }

        cpdListener.phaseUpdate(CPDListener.MATCH);
        MatchCollector matchCollector = new MatchCollector(this);
        for (Iterator<Object> i = markGroups.values().iterator(); i.hasNext();) {
            Object o = i.next();
            if (o instanceof List) {
                List<TokenEntry> l = (List<TokenEntry>) o;
                Collections.reverse(l);
                matchCollector.collect(l);
            }
            i.remove();
        }
        cpdListener.phaseUpdate(CPDListener.GROUPING);
        matches = matchCollector.getMatches();
        matchCollector = null;
        for (Match match : matches) {
            Iterator<TokenEntry> occurrences = match.iterator();
            if (occurrences.hasNext()) {
                TokenEntry mark = occurrences.next();
                match.setLineCount(tokens.getLineCount(mark, match));
                int start = mark.getBeginLine();
                int end = start + match.getLineCount() - 1;
                SourceCode sourceCode = source.get(mark.getTokenSrcID());
                match.setSourceCodeSlice(sourceCode.getSlice(start, end));
            }
        }
        cpdListener.phaseUpdate(CPDListener.DONE);
    }

    @SuppressWarnings("PMD.JumbledIncrementer")
    private Map<TokenEntry, Object> hash(List<TokenEntry> code, boolean isSlice) {
        Map<TokenEntry, Object> markGroups = new HashMap<TokenEntry, Object>(tokens.size());
        for (int i = code.size() - 1; i >= 0; i--) {
            TokenEntry token = code.get(i);
            if (token != TokenEntry.EOF) {
                int last = tokenAt(min, token, code).getIdentifier();
                lastHash = MOD * lastHash + token.getIdentifier() - lastMod * last;
                token.setHashCode(lastHash);
                Object o = markGroups.get(token);

                // Note that this insertion method is worthwhile since the vast
                // majority
                // markGroup keys will have only one value.
                if (o == null) {
                    markGroups.put(token, token);
                } else if(!isSlice){
                    if (o instanceof TokenEntry) {
                    List<TokenEntry> l = new ArrayList<TokenEntry>();
                    l.add((TokenEntry) o);
                    l.add(token);
                    markGroups.put(token, l);
                    } else {
                        List<TokenEntry> l = (List<TokenEntry>) o;
                        l.add(token);
                    }
                }
            } else {
                lastHash = 0;
                for (int end = Math.max(0, i - min + 1); i > end; i--) {
                    token = code.get(i - 1);
                    lastHash = MOD * lastHash + token.getIdentifier();
                    if (token == TokenEntry.EOF) {
                        break;
                    }
                }
            }
        }
        return markGroups;
    }

    private Map<TokenEntry, Object> mergeHash(Map<TokenEntry, Object> m1
            , Map<TokenEntry, Object> m2) {
        for (Iterator<Object> i = m2.values().iterator(); i.hasNext();) {
            TokenEntry token = (TokenEntry)i.next();
            Object o = m1.get(token);
            if(o == null){
                m1.put(token, token);
            } else if(o instanceof TokenEntry){   
                List<TokenEntry> l = new ArrayList<TokenEntry>();
                l.add((TokenEntry) o);
                l.add(token);
                m1.put(token, l);
            } else {
                List<TokenEntry> l = (List<TokenEntry>) o;
                l.add(token);
            }
            i.remove();
        }
        return m1;
    }
}
