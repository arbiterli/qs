package com.glority.quality.metrics.cpp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;

import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.TestFramework;
import com.glority.quality.metrics.TestCheckBaseTask;

/**
 * to Check the cppunit reports. It accept 2 types of path: 1. the report xml --
 * parse the given report xml, 2. the parent folder of the reports -- parse all
 * the cppunit reports in the folder.
 * 
 * @author LYX
 */
public class CppCppunitCheckTask extends TestCheckBaseTask {
    private static final String TAG_TESTCASE_SUCCESSFUL = "SuccessfulTests";
    private static final String TAG_TESTCASE_FAILURE = "FailedTests";

    @Override
    public String getTestFrameworkName() {
        return TestFramework.TEST_FRAMEWORK_CPPUNIT.toString();
    }

    /**
     * no "time" attribute.
     */
    @SuppressWarnings("unchecked")
    protected void parseReportFile(File file) {
        try {
            Document doc = (new SAXBuilder()).build(file);
            Element reportRoot = doc.getRootElement();
            Element failedTestsElement = (Element) reportRoot
                    .getChild(TAG_TESTCASE_FAILURE);
            Element successfulTestsElement = (Element) reportRoot
                    .getChild(TAG_TESTCASE_SUCCESSFUL);
            List<Element> failedTests = failedTestsElement.getChildren();
            List<Element> successfulTests = successfulTestsElement
                    .getChildren();
            if (failedTests != null && failedTests.size() > 0) {
                for (int i = 0; i < failedTests.size(); i++) {
                    failCount++;
                    errorCount++;
                    String testName = ((Element) failedTests.get(i)
                            .getChildren().get(0)).getText();
                    MetricResult result = MetricResult.METRIC_FAIL;
                    addTestCaseMetric(testName, result, null,
                            result.toString(), "0");
                }
            }
            if (successfulTests != null && successfulTests.size() > 0) {
                for (int i = 0; i < successfulTests.size(); i++) {
                    passCount++;
                    String testName = ((Element) successfulTests.get(i)
                            .getChildren().get(0)).getText();
                    MetricResult result = MetricResult.METRIC_SUCCESS;
                    addTestCaseMetric(testName, result, null,
                            result.toString(), "0");
                }
            }
            totalCount = failCount + passCount;

        } catch (IOException exx) {
            exx.printStackTrace();
            throw new BuildException("Failed to open cppunit report xml", exx,
                    getLocation());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("Failed to parser cppunit report");
        }
    }
}
