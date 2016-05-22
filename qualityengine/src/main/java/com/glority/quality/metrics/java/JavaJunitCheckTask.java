package com.glority.quality.metrics.java;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.tools.ant.BuildException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.TestFramework;
import com.glority.quality.metrics.TestCheckBaseTask;

/**
 * Check the junit reports. It accept 2 types of path: 1. the report xml -- parse the given report xml, 2. the parent
 * folder of the reports -- parse all the junit reports in the folder.
 * 
 * @author XQS
 * 
 */
public class JavaJunitCheckTask extends TestCheckBaseTask {
    /** The Constant FAILURES. */
    private static final String TAG_TESTCASE = "testcase";
    private static final String TAG_TESTCASE_ERROR = "error";
    private static final String TAG_TESTCASE_FAILURE = "failure";
    // private static final String ATTR_TESTCASE_ERROR_TYPE = "type";
    private static final String ATTR_TESTCASE_NAME = "name";
    private static final String ATTR_TESTCASE_CLASSNAME = "classname";
    private static final String ATTR_TESTCASE_TIME = "time";

    @Override
    public String getTestFrameworkName() {
        return TestFramework.TEST_FRAMEWORK_JUNIT.toString();
    }

    protected void parseReportFile(File file) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setNamespaceAware(false);
            DocumentBuilder docBuilder;
            docBuilder = docBuilderFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();

            Element root = (Element) doc.getChildNodes().item(0);
            NodeList testcases = root.getElementsByTagName(TAG_TESTCASE);
            for (int i = 0; i < testcases.getLength(); i++) {
                totalCount++;
                Element testcase = (Element) testcases.item(i);
                MetricResult result = MetricResult.METRIC_FAIL;
                String className = testcase.getAttribute(ATTR_TESTCASE_CLASSNAME);
                if (className == null) {
                    className = "";
                } else {
                    className += ".";
                }
                String testName = testcase.getAttribute(ATTR_TESTCASE_NAME);

                NodeList failures = testcase.getElementsByTagName(TAG_TESTCASE_FAILURE);
                if (failures != null && failures.getLength() > 0) {
                    failCount++;
                } else {
                    NodeList errors = testcase.getElementsByTagName(TAG_TESTCASE_ERROR);
                    if (errors != null && errors.getLength() > 0) {
                        failCount++;
                        errorCount++;
                        result = MetricResult.METRIC_ERROR;
                    } else {
                        passCount++;
                        result = MetricResult.METRIC_SUCCESS;
                    }
                }
                addTestCaseMetric(className + testName, result, null, result.toString(),
                        testcase.getAttribute(ATTR_TESTCASE_TIME));
            }
        } catch (IOException exx) {
            exx.printStackTrace();
            throw new BuildException("Failed to open junit report xml", exx, getLocation());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("Failed to parser junit report");
        }
    }
}
