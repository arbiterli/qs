package com.glority.quality.connectors.jenkins;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.BuildException;

/**
 * use bullseye tools to do coverage operation.
 * @author zm.
 *
 */
public class BullsEyeTool implements CovFileTool {

    private static Log log;
    private boolean verbose = false;
    private Runtime runtime;

    private String binFolder;
    private static final String COV_MERGE = "covmerge";
    private static final String COV_HTML = "covhtml";
    private static final String COV_XML = "covxml";
    private static final String XML_REPORT_FILE = "report.xml";
    private static final String CREATE_OPTIONS = "-c";
    private static final String FILE_OPTIONS = "-f";
    private static final String OUTPUT_OPTIONS = "-o";

    public BullsEyeTool(String bullseyeBinFolder) {
        log = LogFactory.getLog(this.getClass().getName());
        binFolder = bullseyeBinFolder + File.separator;
        if (!checkEnv()) {
            throw new BuildException(
                    " BullsEye environment has not been installed. ");
        }
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    private boolean checkEnv() {
            File bullsEyeFolder  =  new File(binFolder);
            if (bullsEyeFolder.exists()) {
                return true;
            }
            return false;
    }

    @Override
    public void mergedFiles(List<String> covFiles, String outputFile) {
        StringBuilder mergeCmd = new StringBuilder();
        mergeCmd.append(binFolder + COV_MERGE + " ");
        mergeCmd.append(CREATE_OPTIONS + " ");
        mergeCmd.append(FILE_OPTIONS);
        mergeCmd.append(outputFile + " ");
        for (String covFile : covFiles) {
            mergeCmd.append(covFile + " ");
        }
        try {
            runCmd(mergeCmd.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void convertToHtml(String srcPath, String destFolder) {
        StringBuilder convertCmd = new StringBuilder();
        convertCmd.append(binFolder + COV_HTML + " ");
        convertCmd.append(FILE_OPTIONS);
        convertCmd.append(srcPath + " ");
        convertCmd.append(destFolder);
        try {
            runCmd(convertCmd.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void convertToXml(String srcPath, String destFolder) {
        StringBuilder convertCmd = new StringBuilder();
        File xmlFolder = new File(destFolder);
        if (!xmlFolder.exists()) {
            if (!xmlFolder.mkdir()) {
                String errorInfo = "Make directory " + destFolder + " failed.";
                log.error(errorInfo);
                throw new BuildException(errorInfo);
            }
        }
        convertCmd.append(binFolder + COV_XML + " ");
        convertCmd.append(FILE_OPTIONS);
        convertCmd.append(srcPath + " ");
        convertCmd.append(OUTPUT_OPTIONS);
        convertCmd.append(destFolder + File.separator + XML_REPORT_FILE);
        try {
            runCmd(convertCmd.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * to run command.
     * 
     * @param cmd
     *            the command string
     * @throws Exception
     *             may cause IOException.
     */
    private void runCmd(String cmd) throws Exception {
        runtime = Runtime.getRuntime();
        Process p = runtime.exec(cmd);
        p.waitFor();
        if (verbose) {
            BufferedInputStream in = new BufferedInputStream(p.getErrorStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                log.info(lineStr);
            }
            inBr.close();
            in.close();
        }
    }
}
