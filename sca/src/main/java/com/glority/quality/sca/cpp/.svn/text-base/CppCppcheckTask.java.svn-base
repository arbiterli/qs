package com.glority.quality.sca.cpp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.glority.quality.sca.FileUtil;
import com.glority.quality.sca.ReportGenerator;
import com.glority.quality.sca.model.ErrorNode;

/**
 * cpp cppcheck task.
 * 
 * @author Zhao JP
 * 
 */
public class CppCppcheckTask extends BaseViolationCheckTask {
    private String cppcheckPath;
    private String srcDir;
    private String macroSetting;
    private String includesFilePath;

    @Override
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
            String subReportPath = new File(reportFilePath).getParent() + File.separator + "cppCheckReport_" + i
                    + ".xml";
            String command = cppcheckPath + " --xml -q " + macroSetting + " --includes-file=" + includesFilePath
                    + " --suppress=toomanyconfigs " + srcDir;
            Process proc = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String temp = br.readLine();
            if (temp != null) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(subReportPath));
                while (temp != null) {
                    bw.write(temp);
                    bw.newLine();
                    bw.flush();
                    temp = br.readLine();
                }
                proc.waitFor();
                bw.close();
            }
            i += 1;
            br.close();
            fileUtil.deleteTempFile(new File(srcDir));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void mergeReport(String reportFilePath) throws Exception {
        File reportFile = new File(reportFilePath);
        File reportDir = new File(reportFile.getParent());
        File[] subFiles = reportDir.listFiles();
        Document report = DocumentHelper.createDocument();
        report.addElement("results");
        XMLWriter writer = new XMLWriter(new FileWriter(reportFile, true));
        for (File subReportFile : subFiles) {
            SAXReader saxReader = new SAXReader();
            Document subReport = saxReader.read(subReportFile);
            if (report != null && subReport != null) {
                Element reportRoot = report.getRootElement();
                Element subReportRoot = subReport.getRootElement();
                List<Element> errorElements = subReportRoot.elements();
                for (Element element : errorElements) {
                    Element temp = element.createCopy();
                    reportRoot.add(temp);
                }
            }
            FileUtil.getInstance().deleteTempFile(subReportFile);
        }
        writer.write(report);
        writer.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ErrorNode> analyzeOriginalReport(String originalReportPath) throws IOException, DocumentException {
        List<String> warningTypes = ReportGenerator.getInstance().getExcludeErrors("defect_cppcheck", scaErrorSetting);
        List<ErrorNode> errorNodes = new ArrayList<ErrorNode>();
        SAXReader saxReader = new SAXReader();
        Document originalReportDoc = saxReader.read(new File(originalReportPath));
        Element originalReportRoot = originalReportDoc.getRootElement();
        List<Element> errorElements = originalReportRoot.elements();
        for (Element element : errorElements) {
                ErrorNode errorNode = new ErrorNode();
                String errorId = element.attributeValue("id");
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
                String fileValue = element.attributeValue("file");
                if (fileValue != null && fileValue.length() > srcDir.length()) {
                    errorNode.setFile(element.attributeValue("file").substring(srcDir.length()));
                } else {
                    errorNode.setFile(element.attributeValue("file"));
                }
                errorNode.setStartLine(element.attributeValue("line"));
                errorNode.setEndLine(element.attributeValue("line"));
                errorNode.setErrorMessage(element.attributeValue("msg"));
                errorNodes.add(errorNode);

        }
        return errorNodes;
    }

    public String getCppcheckPath() {
        return cppcheckPath;
    }

    public void setCppcheckPath(String cppcheckPath) {
        this.cppcheckPath = cppcheckPath;
    }

    public String getSrcDir() {
        return srcDir;
    }

    public void setSrcDir(String srcDir) {
        this.srcDir = srcDir;
    }

    public String getMacroSetting() {
        return macroSetting;
    }

    public void setMacroSetting(String macroSetting) {
        this.macroSetting = macroSetting;
    }

    public String getIncludesFilePath() {
        return includesFilePath;
    }

    public void setIncludesFilePath(String includesFilePath) {
        this.includesFilePath = includesFilePath;
    }

}
