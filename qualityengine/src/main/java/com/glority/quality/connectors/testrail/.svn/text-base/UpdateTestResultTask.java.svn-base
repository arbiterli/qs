package com.glority.quality.connectors.testrail;

import java.util.List;
import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.model.TestCase;

/**
 * to update test case result.
 * @author zm.
 *
 */
public class UpdateTestResultTask extends TestrailBase {

    /**
     * the id of test.
     */
    private String testId;
    /**
     * the result of a test.
     */
    private String testResult;
    /**
     * the message.
     */
    private String message;

    public String getTestId() {
        return testId;
    }

    public void setTestId(final String id) {
        this.testId = id;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(final String result) {
        this.testResult = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String msg) {
        this.message = msg;
    }

    @Override
    public void process() throws ConnectorException {
        if (adapter == null) {
            configAdapter();
        }
        adapter.updateTestResult(testId, testResult, message);
    }

    /**
     * to get result.
     * @return a list of test cases.
     */
    public List<TestCase> getTestCases() {
        throw new BuildException("Cann't use this function");
    }
}
