/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

/**
 * This class does a best-guess try-anything tokenization.
 * 
 * @author jheintz
 */
public class CsTokenizer implements Tokenizer {

    public void tokenize(SourceCode sourceCode, Tokens tokenEntries)
            throws IOException {
        BufferedReader reader = new BufferedReader(new CharArrayReader(
                sourceCode.getCodeBuffer().toString().toCharArray()));
        try {
            int ic = reader.read(), line = 1;
            char c;
            StringBuilder b;
            while (ic != -1) {
                c = (char) ic;
                switch (c) {
                // new line
                case '\n':
                    line++;
                    ic = reader.read();
                    break;

                // white space
                case ' ':
                case '\t':
                case '\r':
                    ic = reader.read();
                    break;

                // < << <= <<= > >> >= >>=
                case '<':
                case '>':
                    ic = reader.read();
                    if (ic == '=') {
                        tokenEntries.add(new TokenEntry(
                                String.valueOf(c) + "=", sourceCode
                                        .getFileName(), line, tokenEntries.getType()));
                        ic = reader.read();
                    } else if (ic == c) {
                        ic = reader.read();
                        if (ic == '=') {
                            tokenEntries.add(new TokenEntry(String.valueOf(c)
                                    + String.valueOf(c) + "=", sourceCode
                                    .getFileName(), line, tokenEntries.getType()));
                            ic = reader.read();
                        } else {
                            tokenEntries.add(new TokenEntry(String.valueOf(c)
                                    + String.valueOf(c), sourceCode
                                    .getFileName(), line, tokenEntries.getType()));
                        }
                    } else {
                        tokenEntries.add(new TokenEntry(String.valueOf(c),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                    }
                    break;

                // = == & &= && | |= || + += ++ - -= --
                case '=':
                case '&':
                case '|':
                case '+':
                case '-':
                    ic = reader.read();
                    if (ic == '=' || ic == c) {
                        tokenEntries.add(new TokenEntry(String.valueOf(c)
                                + String.valueOf((char) ic), sourceCode
                                .getFileName(), line, tokenEntries.getType()));
                        ic = reader.read();
                    } else {
                        tokenEntries.add(new TokenEntry(String.valueOf(c),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                    }
                    break;

                // ! != * *= % %= ^ ^= ~ ~=
                case '!':
                case '*':
                case '%':
                case '^':
                case '~':
                    ic = reader.read();
                    if (ic == '=') {
                        tokenEntries.add(new TokenEntry(
                                String.valueOf(c) + "=", sourceCode
                                        .getFileName(), line, tokenEntries.getType()));
                        ic = reader.read();
                    } else {
                        tokenEntries.add(new TokenEntry(String.valueOf(c),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                    }
                    break;

                // strings & chars
                case '"':
                case '\'':
                    b = new StringBuilder();
                    b.append(c);
                    while ((ic = reader.read()) != c) {
                        if (ic == -1) {
                            break;
                        }
                        b.append((char) ic);
                        if (ic == '\\') {
                            b.append((char) reader.read());
                        }
                    }
                    b.append((char) ic);
                    tokenEntries.add(new TokenEntry(b.toString(), sourceCode
                            .getFileName(), line, tokenEntries.getType()));
                    ic = reader.read();

                    // / /= /*...*/ //...
                case '/':
                    switch (c = (char) (ic = reader.read())) {
                    case '*':
                        int state = 1;
                        b = new StringBuilder();
                        b.append(c);

                        while ((ic = reader.read()) != -1) {
                            c = (char) ic;
                            b.append(c);

                            if (state == 1) {
                                if (c == '*') {
                                    state = 2;
                                }
                            } else {
                                if (c == '/') {
                                    break;
                                } else if (c != '*') {
                                    state = 1;
                                }
                            }
                        }
                        tokenEntries.add(new TokenEntry(b.toString(),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                        break;

                    case '/':
                        b = new StringBuilder();
                        b.append(c);
                        while ((ic = reader.read()) != '\n') {
                            if (ic == -1) {
                                break;
                            }
                            b.append((char) ic);
                        }
                        tokenEntries.add(new TokenEntry(b.toString(),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                        break;

                    case '=':
                        tokenEntries.add(new TokenEntry("/=", sourceCode
                                .getFileName(), line, tokenEntries.getType()));
                        ic = reader.read();
                        break;

                    default:
                        tokenEntries.add(new TokenEntry("/", sourceCode
                                .getFileName(), line, tokenEntries.getType()));
                        break;
                    }
                    break;

                default:
                    // [a-zA-Z_][a-zA-Z_0-9]*
                    if (Character.isJavaIdentifierStart(c)) {
                        b = new StringBuilder();
                        do {
                            b.append(c);
                            c = (char) (ic = reader.read());
                        } while (Character.isJavaIdentifierPart(c));
                        tokenEntries.add(new TokenEntry(b.toString(),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                    } else if (Character.isDigit(c) || c == '.') { // numbers
                        b = new StringBuilder();
                        do {
                            b.append(c);
                            if (c == 'e' || c == 'E') {
                                c = (char) (ic = reader.read());
                                if ("1234567890-".indexOf(c) == -1) {
                                    break;
                                }
                                b.append(c);
                            }
                            c = (char) (ic = reader.read());
                        } while ("1234567890.iIlLfFdDsSuUeExX".indexOf(c) != -1);

                        tokenEntries.add(new TokenEntry(b.toString(), sourceCode.getFileName(), line, tokenEntries.getType()));
                    } else { // anything else
                        tokenEntries.add(new TokenEntry(String.valueOf(c),
                                sourceCode.getFileName(), line, tokenEntries.getType()));
                        ic = reader.read();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tokenEntries.add(TokenEntry.getEOF(tokenEntries.getType()));
    }
}
