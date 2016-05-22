package com.glority.quality.connectors.testcomplete;

import java.util.List;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.Constants.TestRunType;
import com.glority.quality.connectors.testrail.TCOfTestRunTask;
import com.glority.quality.model.TestCase;

/**
 * create pjs of a test run.
 * @author zm
 * 
 */
public class GenerateTestRunPjs extends GeneratePjsBase {

    /**
     * the product id.
     */
    private String productId;

    /**
     * the version.
     */
    private String version;

    /**
     * the type.
     */
    private String type;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected List<TestCase> getTCFromTestrail() throws ConnectorException {
        TCOfTestRunTask testrunCaseTask = new TCOfTestRunTask();
        testrunCaseTask.setProductId(productId);
        testrunCaseTask.setTestrailKey(testrailKey);
        testrunCaseTask.setTestrailServer(testrailServer);
        testrunCaseTask.setVersion(version);
        testrunCaseTask.setType(TestRunType.getValueOf(type));
        testrunCaseTask.process();
        List<TestCase> testcases = testrunCaseTask.getTestCases();
        return testcases;
    }
}
