package com.glority.quality.connectors.testrail;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.Constants.TestRunType;

/**
 * to get test cases of test run.
 * 
 * @author zm
 * 
 */
public class TCOfTestRunTask extends TestrailBase {

    private String productId;

    private String version;

    private TestRunType type;

    private String testrunId;

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

    public TestRunType getType() {
        return type;
    }

    public void setType(TestRunType type) {
        this.type = type;
    }

    public String getTestrunId() {
        return testrunId;
    }

    public void setTestrunId(String testrunId) {
        this.testrunId = testrunId;
    }

    @Override
    public void process() throws ConnectorException {
        if (adapter == null) {
            configAdapter();
        }
        if (this.testrunId != null) {
            this.resultTC = adapter.getTestRunResult(testrunId);
        } else {
            this.resultTC = adapter.getTestRunResult(productId, version, type);
        }
    }

    /**
     * the constructor.
     * 
     * @param key
     *            testrail key.
     * @param server
     *            testrail server.
     * @param testrunId
     *            test run id.
     */
    public TCOfTestRunTask(String key, String server, String testrunId) {
        this.testrailKey = key;
        this.testrailServer = server;
        this.testrunId = testrunId;
    }

    /**
     * the constructor.
     * 
     * @param key
     *            testrail key.
     * @param server
     *            testrail server.
     * @param productId
     *            product id.
     * @param version
     *            version.
     * @param type
     *            type of test run.
     */
    public TCOfTestRunTask(String key, String server, String productId,
            String version, TestRunType type) {
        this.testrailKey = key;
        this.testrailServer = server;
        this.productId = productId;
        this.version = version;
        this.type = type;
    }

    /**
     * the constructor.
     */
    public TCOfTestRunTask() {
    }
}
