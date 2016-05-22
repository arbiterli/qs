package com.glority.quality.sca.counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Counter for each file.
 * @author cz
 *
 */
public class FileLineCounter {

    private long codeLineCount;
    private long commentLineCount;
    private long totleLineCount;
    private File file;
    private List<String> patterns;
    private Boolean isTheCommentOver = true;

    /**
     * Get the patterns.
     * @return The patterns
     */
    public List<String> getPatterns() {
        return patterns;
    }

    /**
     * Setter method for the patterns.
     * @param patterns Patterns to set
     */
    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    /**
     * Get the file.
     * @return the file.
     */
    public File getFile() {
        return file;
    }

    /**
     * Setter method for the file.
     * @param file the file to set
     */
    public void setFile(File file) {
        if (!file.exists()) {
            System.out.println("File " + file.getPath() + " is not exist");
            System.exit(-1);
        }
        this.file = file;
    }

    /**
     * Get the totle line count.
     * @return the totleLineCount
     */
    public long getTotleLineCount() {
        return totleLineCount;
    }

    /**
     * Setter method for totle line count.
     * @param count The count to set
     */
    public void setTotleLineCount(long count) {
        this.totleLineCount = count;
    }

    /**
     * Get the code line count.
     * @return the codeLineCount
     */
    public long getCodeLineCount() {
        return codeLineCount;
    }

    /**
     * Setter method for code line count.
     * @param count The count to set
     */
    public void setCodeLineCount(long count) {
        this.codeLineCount = count;
    }

    /**
     * Get the comment line count.
     * @return the commentLineCount
     */
    public long getCommentLineCount() {
        return commentLineCount;
    }

    /**
     * Setter method for comment line count.
     * @param count The count to set
     */
    public void setCommentLineCount(long count) {
        this.commentLineCount = count;
    }

    /**
     * To remove the tab and space in the sting.
     * @param photoType The string before process
     * @return The string after process
     */
    private String removeSpaceAndTab(String photoType) {
        return photoType.trim().replaceAll(" ", "").replaceAll("    ", "");
    }

    /**
     * Process the FileLineCounter, to get the comment line
     * count and code line count.
     */
    public void processFile() {
        long totleLine = 0;
        long commentLine = 0;
        long codeLine = 0;
        try {
            BufferedReader br =
                new BufferedReader(new FileReader(this.getFile()));
            String content = null;
            String[] beginPatterns = new String[patterns.size()];
            String[] endPatterns = new String[patterns.size()];
            for (int i = 0; i < patterns.size(); i++) {
                String[] pattern = patterns.get(i).split(" ");
                beginPatterns[i] = pattern[0];
                endPatterns[i] = pattern[1];
            }
            while ((content = br.readLine()) != null) {
                content = " " + content + " ";
                totleLine++;
                int beginPatternNum = 0;
                int endPatternNum = 0;
                for (int i = 0; i < patterns.size(); i++) {
                    String beginPattern = processTheSpecialString(beginPatterns[i]);
                    String endPattern = processTheSpecialString(endPatterns[i]);
                    beginPatternNum += content.split(beginPattern).length - 1;
                    endPatternNum += content.split(endPattern).length - 1;
                }
                content = removeSpaceAndTab(content);
                if (beginWithPattern(beginPatterns, content)) {
                    if (endWithPattern(endPatterns, content)) {
                        commentLine += beginPatternNum;
                        codeLine += beginPatternNum - 1;
                    } else if (endWithPattern(beginPatterns, content)) {
                        commentLine += beginPatternNum;
                        codeLine += beginPatternNum - 1;
                        isTheCommentOver = false;
                    } else {
                        if (beginPatternNum == endPatternNum) {
                            commentLine += beginPatternNum;
                            codeLine += beginPatternNum;
                        } else {
                            commentLine += beginPatternNum;
                            codeLine += beginPatternNum - 1;
                            isTheCommentOver = false;
                        }
                    }
                } else if (beginWithPattern(endPatterns, content)) {
                    isTheCommentOver = true;
                    if (endWithPattern(endPatterns, content)) {
                        commentLine += beginPatternNum + 1;
                        codeLine += beginPatternNum;
                    } else if (endWithPattern(beginPatterns, content)) {
                        commentLine += beginPatternNum + 1;
                        codeLine += beginPatternNum;
                        isTheCommentOver = false;
                    } else {
                        commentLine += beginPatternNum + 1;
                        if (beginPatternNum == endPatternNum) {
                            codeLine += beginPatternNum;
                            isTheCommentOver = false;
                        } else {
                            codeLine += beginPatternNum + 1;
                        }
                    }
                } else {
                    if (endWithPattern(endPatterns, content)) {
                        codeLine += beginPatternNum;
                        if (isTheCommentOver) {
                            commentLine += beginPatternNum;
                        } else {
                            commentLine += endPatternNum;
                            isTheCommentOver = true;
                        }
                    } else if (endWithPattern(beginPatterns, content)) {
                        codeLine += beginPatternNum;
                        if (isTheCommentOver) {
                            commentLine += beginPatternNum;
                        } else {
                            commentLine += beginPatternNum + 1;
                        }
                        isTheCommentOver = false;
                    } else {
                        if (isTheCommentOver) {
                            if (endPatternNum == beginPatternNum) {
                                commentLine += beginPatternNum;
                                codeLine += beginPatternNum + 1;
                            } else {
                                commentLine += beginPatternNum;
                                codeLine += beginPatternNum;
                                isTheCommentOver = false;
                            }
                        } else {
                            if (endPatternNum != 0 && endPatternNum == beginPatternNum) {
                                commentLine += beginPatternNum + 1;
                                codeLine += beginPatternNum;
                            } else if (endPatternNum == 0) {
                                commentLine++;
                            } else {
                                isTheCommentOver = true;
                                commentLine += beginPatternNum + 1;
                                codeLine += beginPatternNum + 1;
                            }
                        }
                    }
                }
                int continuousCommentPatternSize = getContinuousCommentPatternSize(
                        getContinuousCommentPatterns(beginPatterns, endPatterns), content);
                codeLine -= continuousCommentPatternSize;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setCodeLineCount(codeLine);
        this.setCommentLineCount(commentLine);
        this.setTotleLineCount(totleLine);
    }

    /**
     * Get the continuous comment patterns list.
     * @param beginPatterns Begin patterns
     * @param endPatterns End patterns
     * @return Continuous comment patterns list.
     */
    private List<String> getContinuousCommentPatterns(String[] beginPatterns, String[] endPatterns) {
        List<String> continuousCommentPatterns = new ArrayList<String>();
        for (int i = 0; i < endPatterns.length; i++) {
            for (int j = 0; j < beginPatterns.length; j++) {
                continuousCommentPatterns.add(endPatterns[i] + beginPatterns[j]);
            }
        }
        return continuousCommentPatterns;
    }

    /**
     * Get the count of continuous comment patterns in one line.
     * @param continuousCommentPatterns Continuous comment patterns list
     * @param content Line value
     * @return The count of continuous comment patterns in one line.
     */
    private int getContinuousCommentPatternSize(List<String> continuousCommentPatterns, String content) {
        int size = 0;
        content = " " + content + " ";
        for (int i = 0; i < continuousCommentPatterns.size(); i++) {
            if (content.contains(continuousCommentPatterns.get(i))) {
                size += content.split(processTheSpecialString(continuousCommentPatterns.get(i))).length - 1;
            }
        }
        return size;
    }

    /**
     * To process the special string.
     * @param stringToBeProcessed The string will be processed.
     * @return The string after process
     */
    private String processTheSpecialString(String stringToBeProcessed) {
        String processedString = stringToBeProcessed.replaceAll("\\*", "\\\\*");
        return processedString;
    }

    /**
     * Judge if the line value begin with the patterns.
     * @param patterns The patterns.
     * @param content Line value
     * @return True if the line begin with the patterns, false if not.
     */
    private boolean beginWithPattern(String[] patterns, String content) {
        for (int i = 0; i < patterns.length; i++) {
            if (content.startsWith(patterns[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Judge if the line value end with the patterns.
     * @param patterns The patterns.
     * @param content Line value
     * @return True if the line end with the patterns, false if not.
     */
    private boolean endWithPattern(String[] patterns, String content) {
        for (int i = 0; i < patterns.length; i++) {
            if (content.endsWith(patterns[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Set value for isTheCommentOver.
     * @param isTheCommentOver Boolean value.
     */
    public void setIsTheCommentOver(Boolean isTheCommentOver) {
        this.isTheCommentOver = isTheCommentOver;
    }

}
