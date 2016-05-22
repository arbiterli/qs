package com.glority.quality.injection.cpp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.glority.quality.sca.antlr.cpp.CppParser;

/**
 * instrument.
 * 
 * @author LYX
 */
public class CppInjection extends CppParser {
    public CppInjection(TokenStream input) {
        super(input);
    }

    public static StringBuffer readIntoStringBuffer(String inputFile)
            throws IOException {
        StringBuffer buffer = new StringBuffer();
        FileInputStream fis = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = reader.readLine();
        while (line != null) {
            buffer.append(line);
            buffer.append("\n");
            line = reader.readLine();
        }
        return buffer;
    }

    // to declare a bool variable for each function
    public static void headerFileInjection(String inputFile, String outputFile,
            Vector<String> functions, int insertPos)
            throws RecognitionException {
        try {
            StringBuffer buffer = readIntoStringBuffer(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            if (functions.size() > 0) {
                for (int i = 0; i < functions.size(); i++) {
                    buffer.insert(insertPos, "BOOL isRun" + functions.get(i)
                            + " = FALSE;\n");
                }
            }
            fos.write(buffer.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void injection(File inputFile, String outputPath,
            Vector<String> functions, String includeText)
            throws RecognitionException {
        try {
            TokenStream tokens = super.getTokenStream();
            int insertNum = 1;

            // super.reset(); //if not point to the begin of the file ,should
            // reset
            super.preprocess();
            List<String> tokenList = new ArrayList<String>();
            File outputFile = new File(outputPath);
            FileOutputStream fos = new FileOutputStream(outputFile);

            tokenList.add("#include \"" + includeText + "\"\n");
            for (int i = 0; i < tokens.size(); i++) {
                tokenList.add(tokens.get(i).getText());
            }

            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                if (KEYWORD.contains(token.getText())) {
                    continue;
                }
                if (token.getText().contains("#")) {
                    continue;
                }

                int k = 1, j = 0, t = 1;
                while (tokens.get(i + k).getType() == WS
                        || tokens.get(i + k).getType() == TEXT_END) {
                    k++;
                }
                if (!"(".equals(tokens.get(i + k).getText())) {
                    continue;
                }
                while (!")".equals(tokens.get(i + j).getText())) {
                    j++;
                }
                while (tokens.get(i + j + t).getType() == WS
                        || tokens.get(i + j + t).getType() == TEXT_END
                        || tokens.get(i + j + t).getType() == LINE_COMMENT
                        || tokens.get(i + j + t).getType() == LINECOMMENTS
                        || "const".equals(tokens.get(i + j + t).getText())) {
                    t++;
                }
                if ("{".equals(tokens.get(i + j + t).getText())) {
                    if (!functions.contains(token.getText())) {
                        functions.add(token.getText());
                    }
                    tokenList.add(
                            i + j + t + insertNum + 1,
                            "getFunctionName(\""
                                    + addBackslash(tokens.getSourceName())
                                    + " : " + token.getText() + "\",isRun"
                                    + token.getText() + ");isRun"
                                    + token.getText() + " = TRUE;");
                    insertNum++;
                }

            }
            for (int i = 0; i < tokenList.size(); i++) {
                if (!"<EOF>".equals(tokenList.get(i))) {
                    fos.write(tokenList.get(i).getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // change '\' to '\\' in the string
    public String addBackslash(String str) {
        int strInsertNum = 0;
        StringBuffer strSource = new StringBuffer(str);
        StringBuffer strSourceCopy = new StringBuffer(str);
        for (int i = 0; i < strSourceCopy.length(); i++) {
            if (strSourceCopy.charAt(i) == '\\') {
                strSource.insert(i + strInsertNum, '\\');
                strInsertNum++;
            }
        }

        return strSource.toString();
    }

    public static final Set<String> KEYWORD = new HashSet<String>(
            Arrays.asList("while", "else", "if", "catch", "do", "for",
                    "finally", "try", "switch", "for_each", "throw"));
}
