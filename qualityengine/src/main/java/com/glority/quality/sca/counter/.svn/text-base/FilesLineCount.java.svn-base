package com.glority.quality.sca.counter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.types.FileSet;

import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.metrics.MetricsBaseTask;
import com.glority.quality.model.Metric;

/**
 * Count the line of codes and comments.
 * @author cz
 *
 */
public class FilesLineCount extends MetricsBaseTask {

    private List<FileLineCounter> counters;
    private List<FileSet> filesets = new ArrayList<FileSet>();
    private String[] includedFiles;
    private String languageType;

    /**
     * Initialization the FilesLineCount.
     */
    public void setUp() {
        counters = new ArrayList<FileLineCounter>();
    }

    /**
     * Get all files in the path.
     * @return fileList File list
     */
    private List<File> getFiles() {
        List<File> fileList = new ArrayList<File>();
        for (FileSet fileSet : filesets) {
            DirectoryScanner directoryScanner = fileSet
                    .getDirectoryScanner(getProject());
            includedFiles = directoryScanner.getIncludedFiles();
            for (int i = 0; i < includedFiles.length; i++) {
                File file = new File(directoryScanner.getBasedir()
                        + System.getProperty("file.separator")
                        + includedFiles[i]);
                fileList.add(file);
            }
        }
        return fileList;
    }

    /**
     * To process input file.
     */
    public void processInputFile() {
        List<File> filesList = getFiles();
        for (File file:filesList) {
            FileLineCounter counter = new FileLineCounter();
            if (counter != null) {
                counter.setPatterns(getPatternsByLanguageType(languageType));
                counter.setFile(file);
                counter.processFile();
                counters.add(counter);
            }
        }
    }

    /**
     * Get patterns by language type.
     * @param languageType The language type.
     * @return Patterns list.
     */
    private List<String> getPatternsByLanguageType(String languageType) {
        List<String> patterns = new ArrayList<String>();
        if (languageType.equalsIgnoreCase("css")) {
            patterns.add(CommentPattern.COMMENT_PATTERN1);
        } else if (languageType.equalsIgnoreCase("jsp")) {
            patterns.add(CommentPattern.COMMENT_PATTERN2);
            patterns.add(CommentPattern.COMMENT_PATTERN3);
        }
        return patterns;
    }

    /**
     * Get the counters.
     * @return the counters
     */
    public List<FileLineCounter> getCounters() {
        return counters;
    }

    /**
     * Get the language type.
     * @return the languageType
     */
    public String getLanguageType() {
        return languageType;
    }

    /**
     * Setter method for language type.
     * @param languageType the languageType to set
     */
    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    /**
     * Add file set to fileSets.
     * @param set Input fileset
     */
    public void addFileset(FileSet set) {
        filesets.add(set);
    }

    /**
     * Get metric list to update.
     * @return Metric list
     */
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric metricCodeLine = new Metric();
        Metric metricCommentLine = new Metric();
        String lineOfCodeTask = languageType.toUpperCase() + "_LINE_OF_CODE";
        long lineOfCode = 0;
        String lineOfCommentTask = languageType.toUpperCase() + "_LINE_OF_COMMENT";
        long lineOfComment = 0;
        for (FileLineCounter counter : counters) {
            lineOfCode += counter.getCodeLineCount();
            lineOfComment += counter.getCommentLineCount();
        }
        metricCodeLine.setName(lineOfCodeTask);
        metricCodeLine.setNewValue(lineOfCode);
        metricCodeLine.setType(MetricType.METRIC_TYPE_MI);
        metricCodeLine.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(metricCodeLine);
        metricCommentLine.setName(lineOfCommentTask);
        metricCommentLine.setNewValue(lineOfComment);
        metricCommentLine.setType(MetricType.METRIC_TYPE_MI);
        metricCommentLine.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(metricCommentLine);
        return metrics;
    }

    /**
     * Init FileLineCount, to process input files and update quality.xml.
     */
    public void process() {
        setUp();
        processInputFile();
        updateQualityXML(getMetrics());
    }
}
