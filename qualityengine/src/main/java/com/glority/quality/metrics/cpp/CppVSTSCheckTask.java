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
 * check VS test system reports.
 * 
 * @author LYX
 */
public class CppVSTSCheckTask extends TestCheckBaseTask {
    private static final String TAG_TESTCASE_RESULTS = "Results";
    private static final String ATTR_TESTCASE_PASSED = "Passed";
    private static final String ATTR_TESTCASE_TESTNAME = "testName";
    private static final String ATTR_TESTCASE_TIME = "duration";
    private static final String ATTR_TESTCASE_OUTCOME = "outcome";

    @Override
    public String getTestFrameworkName() {
        return TestFramework.TEST_FRAMEWORK_VSTS.toString();
    }

    @SuppressWarnings("unchecked")
    protected void parseReportFile(File file) {
        try {
            Document doc = (new SAXBuilder()).build(file);
            Element reportRoot = doc.getRootElement();
            Element testResults = (Element) reportRoot
            .getChild(TAG_TESTCASE_RESULTS, reportRoot.getNamespace());
            List<Element> unitTestResults = testResults.getChildren();
            if (unitTestResults != null && unitTestResults.size() > 0) {
                for (int i = 0; i < unitTestResults.size(); i++) {
                    totalCount++;
                    Element unitTestResult = unitTestResults.get(i);
                    String testName = unitTestResult
                    .getAttributeValue(ATTR_TESTCASE_TESTNAME);
                    MetricResult result = MetricResult.METRIC_FAIL;
                    if (unitTestResult.getAttributeValue(ATTR_TESTCASE_OUTCOME)
                            .equals(ATTR_TESTCASE_PASSED)) {
                        passCount++;
                        result = MetricResult.METRIC_SUCCESS;
                    } else {
                        failCount++;
                        result = MetricResult.METRIC_FAIL;
                    }
                    String time = unitTestResult.getAttributeValue(ATTR_TESTCASE_TIME);
                    addTestCaseMetric(testName, result, null, result.toString(), time);
                }
            }

        } catch (IOException exx) {
            exx.printStackTrace();
            throw new BuildException("Failed to open vsts report xml", exx, getLocation());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("Failed to parser vsts report");
        }
    }
}
