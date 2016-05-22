package com.glority.quality.connectors.testcomplete;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.tools.ant.BuildException;

import com.glority.quality.BaseTask;

/**
 * a task to run pjs.
 * 
 * @author zm
 * 
 */
public class PjsRunTask extends BaseTask {

    /**
     * the folder that contains pjs files.
     */
    private String atcFolder;

    /**
     * the pjs file extension.
     */
    private static final String PJS_EXTENSION = ".pjs";

    /**
     * the run cmd prefix.
     */
    private static final String CMD_PREFIX = "TestExecute.exe \"";

    /**
     * the run cmd postfix.
     */
    private static final String CMD_POSTFIX = "\" /run /exit /SilentMode";

    /**
     * the folder contains pjs files.
     */
    private static final String PJS_FOLDER = "DynamicalSuites";

    /**
     * the installer suite pjs file.
     */
    private static final String INSTALLER_SUITE_FILE = "InstallerSuite\\InstallerSuite.pjs";

    public String getAtcFolder() {
        return atcFolder;
    }

    public void setAtcFolder(String atcFolder) {
        this.atcFolder = atcFolder;
    }

    @Override
    public void process() {
        File dir = new File(this.atcFolder + File.separator + PJS_FOLDER);
        File[] files = dir.listFiles();
        List<String> pjsFiles = new ArrayList<String>();
        for (int i = 0; i < files.length; i++) {
            File tmpFile = files[i];
            if (tmpFile.isDirectory()) {
                pjsFiles.add(tmpFile.getAbsolutePath());
            }
        }
        Collections.sort(pjsFiles, new PjsFileComparator());
        runPjsFiles(pjsFiles);
    }

    /**
     * to run all the pjs files.
     * 
     * @param pjsFiles
     *            all the pjs files.
     */
    private void runPjsFiles(List<String> pjsFiles) {
        Runtime runtime = Runtime.getRuntime();
        runInstallerSuitePjs(runtime);
        for (int i = 0; i < pjsFiles.size(); i++) {
            try {
                String pjsIndex = pjsFiles.get(i).substring(
                        pjsFiles.get(i).lastIndexOf("\\") + 1);
                String pjsFilePath = pjsFiles.get(i) + File.separator
                        + pjsIndex + PJS_EXTENSION;
                String cmd = CMD_PREFIX + pjsFilePath + CMD_POSTFIX;
                Process p = runtime.exec(cmd);
                BufferedInputStream in = new BufferedInputStream(
                        p.getInputStream());
                BufferedReader inBr = new BufferedReader(new InputStreamReader(
                        in));
                String lineStr;
                while ((lineStr = inBr.readLine()) != null) {
                    getProject().log(lineStr);
                }

                if (p.waitFor() != 0) {
                    if (p.exitValue() == 1) {
                        getProject().log(" Run TestSuite Failed at"
                                + pjsFiles.get(i));
                    }
                }
                inBr.close();
                in.close();
            } catch (Exception e) {
                throw new BuildException(e.getMessage());
            }
        }
    }

    /**
     * to run installer suite pjs.
     * 
     * @param runtime
     *            the runtime.
     */
    private void runInstallerSuitePjs(Runtime runtime) {
        try {
            String cmd = CMD_PREFIX + this.atcFolder + File.separator
                    + INSTALLER_SUITE_FILE + CMD_POSTFIX;
            Process p = runtime.exec(cmd);
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                getProject().log(lineStr);
            }

            if (p.waitFor() != 0) {
                if (p.exitValue() == 1) {
                    getProject().log(" Run Installer Suite failed.");
                }
            }
            inBr.close();
            in.close();
        } catch (Exception e) {
            throw new BuildException(e.getMessage());
        }
    }

    /**
     * the class used to sort pjs file.
     * 
     * @author zm
     * 
     */
    private class PjsFileComparator implements Comparator<String> {
        public int compare(String pathOne, String pathTwo) {
            String pathOneBase = pathOne
                    .substring(pathOne.lastIndexOf("\\") + 1);
            String pathTwoBase = pathTwo
                    .substring(pathTwo.lastIndexOf("\\") + 1);
            int pathOneIndex = Integer.parseInt(pathOneBase);
            int pathTwoIndex = Integer.parseInt(pathTwoBase);
            return (pathOneIndex == pathTwoIndex) ? 0
                    : (pathOneIndex > pathTwoIndex ? 1 : -1);
        }
    }

}
