package com.glority.quality.metrics.cs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;

import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.TestFramework;
import com.glority.quality.metrics.TestCheckBaseTask;

/**
 * check nunit reports.
 * 
 * @author LYX
 */
public class CSNunitCheckTask extends TestCheckBaseTask {
    private static final String TAG_TESTCASE = "test-case";
    private static final String ATTR_RESULT = "result";
    private static final String ATTR_SUCCESS = "Success";
    private static final String ATTR_TIME = "time";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_ERROR = "Error";

    private List<Element> testcase = new ArrayList<Element>();

    @Override
    public String getTestFrameworkName() {
        return TestFramework.TEST_FRAMEWORK_NUNIT.toString();
    }

    private void findTestcase(Element e) {
        if (e.getName().equals(TAG_TESTCASE)) {
            testcase.add(e);
        } else if (e.getChildren() != null && e.getChildren().size() > 0) {
            for (int i = 0; i < e.getChildren().size(); i++) {
                findTestcase((Element) e.getChildren().get(i));
            }
        }
    }

    protected void parseReportFile(File file) {
        try {
            Document doc = (new SAXBuilder()).build(file);
            Element reportRoot = doc.getRootElement();
            findTestcase(reportRoot);
            if (testcase.size() > 0) {
                for (int i = 0; i < testcase.size(); i++) {
                    totalCount++;
                    Element e = testcase.get(i);
                    String name = e.getAttributeValue(ATTR_NAME);
                    String time = e.getAttributeValue(ATTR_TIME);
                    MetricResult result = MetricResult.METRIC_FAIL;
                    if (e.getAttributeValue(ATTR_RESULT).equals(ATTR_SUCCESS)) {
                        result = MetricResult.METRIC_SUCCESS;
                        passCount++;
                    } else if (e.getAttributeValue(ATTR_RESULT).equals(ATTR_ERROR)) {
                        failCount++;
                        errorCount++;
                        result = MetricResult.METRIC_ERROR;
                    } else {
                        failCount++;
                    }
                    addTestCaseMetric(name, result, null, result.toString(), time);
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
