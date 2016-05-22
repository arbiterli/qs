package com.glority.quality.connectors.testrail;

import com.glority.common.connectors.ConnectorException;

/**
 * to get test cases of product in a version.
 * 
 * @author zm
 * 
 */
public class TCOfVersionTask extends TestrailBase {

    /**
     * the id of product.
     */
    private String productId;

    /**
     * the version of product.
     */
    private String productVersion;

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String id) {
        this.productId = id;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(final String version) {
        this.productVersion = version;
    }

    @Override
    public void process() throws ConnectorException {
        configAdapter();
        this.resultTC = adapter
                .getTestCasesOfVersion(productId, productVersion);
    }

    /**
     * the constructor.
     * 
     * @param key
     *            testrail key
     * @param server
     *            testrail server
     */
    public TCOfVersionTask(String key, String server, String version) {
        this.testrailKey = key;
        this.testrailServer = server;
        this.productVersion = version;
    }

    /**
     * the constructor.
     */
    public TCOfVersionTask() {
    }
}
