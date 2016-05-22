package com.glority.quality.connectors.jenkins;

import java.util.List;

/**
 * the interface that all coverage file tools need to impelment.
 * 
 * @author zm.
 * 
 */
public interface CovFileTool {

    /**
     * to output merged cov files.
     * 
     * @param covFiles
     *            the cov files.
     * @param outputFile
     *            the merged file path.
     */
    void mergedFiles(List<String> covFiles, String outputFile);

    /**
     * to convert cov file to html files.
     * 
     * @param srcPath
     *            original cov file.
     * @param destFolder
     *            the dest folder.
     */
    void convertToHtml(String srcPath, String destFolder);

    /**
     * to convert cov file to xml file.
     * 
     * @param srcPath
     *            original cov file.
     * @param destFile
     *            dest file.
     */
    void convertToXml(String srcPath, String destFile);

    /**
     * to set if show details.
     * 
     * @param verbose
     *            if show details.
     */
    void setVerbose(boolean verbose);

}
