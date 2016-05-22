package com.glority.quality.metrics.all;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.tools.ant.BuildException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.TestFramework;
import com.glority.quality.metrics.TestCheckBaseTask;

/**
 * to do svn check operation.
 * 
 * @author zm
 * 
 */
public class TestCompleteCheckTask extends TestCheckBaseTask {
    private static final String ATTR_NAME = "name";

    /**
     * the root.xml file.
     */
    private static final String ROOT_XML = "Log" + File.separator + "root.xml";

    private static final int HUNDRED = 100;
    @Override
    public void parseReport() {
        File logFolder = new File(reportPath + File.separator + ROOT_XML);
        if (logFolder.exists()) {
            ResultCount counter = parseRootFile(reportPath + File.separator
                    + ROOT_XML);
            totalCount = counter.totalCount;
            passCount = counter.passCount;
            if (totalCount != 0) {
                successRate = HUNDRED * passCount / totalCount;
            }
            return;
        }
        File reportFolder = new File(reportPath);
        if (!reportFolder.exists()) {
            throw new BuildException("Report path not exists.");
        }
        File[] reportFolders = reportFolder.listFiles();
        for (int i = 0; i < reportFolders.length; i++) {
            if (reportFolders[i].isDirectory()) {
                String rootXMLPath = reportFolders[i].getAbsolutePath()
                        + File.separator + ROOT_XML;
                ResultCount counter = parseRootFile(rootXMLPath);
                totalCount += counter.totalCount;
                passCount += counter.passCount;
            }
        }

        if (totalCount != 0) {
            successRate = HUNDRED * passCount / totalCount;
        }
        return;
    }

    /**
     * to parse root.xml file.
     * 
     * @param filePath
     *            root file path.
     * @return a result count.
     */
    private ResultCount parseRootFile(String filePath) {
        ResultCount counter = new ResultCount();
        try {
            final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            docBuilderFactory.setNamespaceAware(true);
            DocumentBuilder docBuilder;
            docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(filePath));
            doc.getDocumentElement().normalize();
            NodeList testcases = (NodeList) doc.getChildNodes().item(0);
            for (int i = 0; i < testcases.getLength(); i++) {
                if (testcases.item(i).getNodeName().equals("LogData")) {
                    totalCount = totalCount + 1;
                    String testCaseName = testcases.item(i).getAttributes()
                            .getNamedItem(ATTR_NAME).getNodeValue();
                    if (Integer.parseInt(testcases.item(i).getAttributes()
                            .getNamedItem("status").getNodeValue()) == 0) {
                        passCount = passCount + 1;
                        addTestCaseMetric(testCaseName,
                                MetricResult.METRIC_SUCCESS, null,
                                MetricResult.METRIC_SUCCESS.toString(), null);
                    } else {
                        failCount = failCount + 1;
                        addTestCaseMetric(testCaseName,
                                MetricResult.METRIC_FAIL, null,
                                MetricResult.METRIC_FAIL.toString(), null);
                    }
                }
            }
            counter.passCount = passCount;
            counter.totalCount = totalCount;
            return counter;
        } catch (IOException exx) {
            exx.printStackTrace();
            throw new BuildException("Failed to open report... <"
                    + getTaskName() + "/>", exx, getLocation());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("Parser the xml failed");
        }
    }

    @Override
    public String getTestFrameworkName() {
        return TestFramework.TEST_FRAMEWORK_TESTCOMPLETE.toString();
    }

    /**
     * to hold result info.
     * @author zm
     *
     */
    private class ResultCount {
        private int passCount;
        private int totalCount;
    }

    protected void parseReportFile(File file) {
    }
}
