package com.glority.quality.sca.cpp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.glority.quality.sca.FileUtil;
import com.glority.quality.sca.ReportGenerator;
import com.glority.quality.sca.model.ErrorNode;

/**
 * cpp cpplint task.
 * 
 * @author Zhao JP
 * 
 */
public class CppCpplintTask extends BaseViolationCheckTask {

    private String pythonPath;
    private String cpplintPath;
    private String srcDir;

    public void setPythonPath(String pythonPath) {
        this.pythonPath = pythonPath;
    }

    public String getPythonPath() {
        return this.pythonPath;
    }

    public void setCpplintPath(String cpplintPath) {
        this.cpplintPath = cpplintPath;
    }

    public String getCpplintPath() {
        return this.cpplintPath;
    }

    public void setSrcDir(String srcDir) {
        this.srcDir = srcDir;
    }

    public String getSrcDir() {
        return this.srcDir;
    }

    public void runSCA() throws Exception {
        int i = 0;
        FileUtil fileUtil = FileUtil.getInstance();
        String rootPath = filesets.get(0).getDir().getPath();
        for (List<File> files : pieces) {
            for (File file : files) {
                if (!fileUtil.copyFile(file, srcDir, rootPath)) {
                    throw new IOException();
                }
            }
            System.out.println(files.size());
            String subReportPath = new File(reportFilePath).getParent() + File.separator + "cppLintReport_" + i
                    + ".txt";
            String command = pythonPath + " " + cpplintPath + " " + srcDir + " " + subReportPath;
            Process proc = Runtime.getRuntime().exec(command);
            String temp = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }
            proc.waitFor();
            br.close();
            i += 1;
            fileUtil.deleteTempFile(new File(srcDir));
        }
    }

    @Override
    public void mergeReport(String reportFilePath) throws Exception {
        long errorNum = 0;
        File reportFile = new File(reportFilePath);
        File reportDir = new File(reportFile.getParent());
        File[] subFiles = reportDir.listFiles();
        Pattern pattern = Pattern.compile("Total No. Of Error Count is : \\d++");
        for (File subReportFile : subFiles) {
            BufferedReader br = new BufferedReader(new FileReader(subReportFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile, true));
            String line = null;
            while ((line = br.readLine()) != null) {
                Matcher match = pattern.matcher(line);
                if (!match.find()) {
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                } else {
                    String digitString = line.replaceAll("Total No. Of Error Count is : ", "");
                    errorNum += Integer.parseInt(digitString.trim());
                }
            }
            bw.close();
            br.close();
            FileUtil.getInstance().deleteTempFile(subReportFile);
        }
        finishReport(reportFile, errorNum);
    }

    private void finishReport(File reportFile, long errorNum) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile, true));
        bw.write("Total No. Of Error Count is : " + errorNum);
        bw.close();
    }

    @Override
    public List<ErrorNode> analyzeOriginalReport(String originalReportPath) throws Exception {
        List<String> warningTypes = ReportGenerator.getInstance().getExcludeErrors("defect_cpplint", scaErrorSetting);
        List<ErrorNode> errorNodes = new ArrayList<ErrorNode>();
        BufferedReader br = new BufferedReader(new FileReader(originalReportPath));
        String tempLine = null;
        while ((tempLine = br.readLine()) != null) {
            if (tempLine.matches("Total No. Of Error Count is : \\d++")) {
                continue;
            }
            ErrorNode errorNode = new ErrorNode();
            String errorId = tempLine.substring(tempLine.lastIndexOf(" ") + 1);
            errorNode.setId(errorId);
            boolean isWarning = false;
            for (String id : warningTypes) {
                if (id.equals(errorId)) {
                    isWarning = true;
                    errorNode.setErrorType(ReportGenerator.SEVERITY_LEVEL_WARNING);
                    break;
                }
            }
            if (!isWarning) {
                errorNode.setErrorType(ReportGenerator.SEVERITY_LEVEL_ERROR);
            }
            int fileDotIndex = tempLine.indexOf(".");
            errorNode.setFile(tempLine.substring(srcDir.length(), tempLine.indexOf(" ", fileDotIndex)));
            int numDotIndex = tempLine.indexOf(".", fileDotIndex + 1);
            String lineNum = tempLine.substring(numDotIndex + 1, tempLine.indexOf(" ", numDotIndex));
            errorNode.setStartLine(lineNum);
            errorNode.setEndLine(lineNum);
            errorNode.setErrorMessage(tempLine.substring(tempLine.indexOf(" ", numDotIndex) + 1,
                    tempLine.lastIndexOf(" ")));

            errorNodes.add(errorNode);
        }
        return errorNodes;
    }
}
