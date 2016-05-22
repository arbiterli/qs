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
 * check gtest reports.
 * 
 * @author LYX
 */
public class CppGtestCheckTask extends TestCheckBaseTask {
    private static final String ATTR_TESTS = "tests";
    private static final String ATTR_FAILURES = "failures";
    private static final String ATTR_ERRORS = "errors";
    private static final String ATTR_TIME = "time";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_CLASSNAME = "classname";

    @Override
    public String getTestFrameworkName() {
        return TestFramework.TEST_FRAMEWORK_GTEST.toString();
    }

    @SuppressWarnings("unchecked")
    protected void parseReportFile(File file) {
        try {
            Document doc = (new SAXBuilder()).build(file);
            Element reportRoot = doc.getRootElement();
            totalCount = Integer.parseInt(reportRoot.getAttributeValue(ATTR_TESTS));
            failCount = Integer.parseInt(reportRoot.getAttributeValue(ATTR_FAILURES))
                    + Integer.parseInt(reportRoot.getAttributeValue(ATTR_ERRORS));
            errorCount = Integer.parseInt(reportRoot.getAttributeValue(ATTR_ERRORS));
            passCount = totalCount - failCount;
            List<Element> testSuites = reportRoot.getChildren();
            if (testSuites != null && testSuites.size() > 0) {
                for (int i = 0; i < testSuites.size(); i++) {
                    Element testSuite = testSuites.get(i);
                    String testSuiteName = testSuite.getAttributeValue(ATTR_NAME);
                    List<Element> testcases = testSuite.getChildren();
                    for (int j = 0; j < testcases.size(); j++) {
                        Element testcase = testcases.get(j);
                        String testcaseName = testcase.getAttributeValue(ATTR_NAME);
                        String className = testcase.getAttributeValue(ATTR_CLASSNAME);
                        String time = testcase.getAttributeValue(ATTR_TIME);
                        MetricResult result = MetricResult.METRIC_FAIL;
                        if (testcase.getChildren() != null && testcase.getChildren().size() > 0) {
                            result = MetricResult.METRIC_FAIL;
                        } else {
                            result = MetricResult.METRIC_SUCCESS;
                        }
                        addTestCaseMetric(testSuiteName + className + testcaseName,
                                result, null, result.toString(), time);
                    }
                }
            }
        } catch (IOException exx) {
            exx.printStackTrace();
            throw new BuildException("Failed to open gtest report xml", exx, getLocation());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("Failed to parser gtest report");
        }
    }
}
