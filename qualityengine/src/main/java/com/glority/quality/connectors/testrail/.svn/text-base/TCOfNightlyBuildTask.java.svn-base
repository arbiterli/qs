package com.glority.quality.connectors.testrail;

import com.glority.common.connectors.ConnectorException;

/**
 * to get test cases of product.
 * 
 * @author zm
 * 
 */
public class TCOfNightlyBuildTask extends TestrailBase {

    /**
     * product id.
     */
    private String productId;

    /**
     * product version.
     */
    private String productVersion;

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String proID) {
        this.productId = proID;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(final String proVersion) {
        this.productVersion = proVersion;
    }

    @Override
    public void process() throws ConnectorException {
        if (adapter == null) {
            configAdapter();
        }
        this.resultTC = adapter.getNightlyBuildTests(productId, productVersion);
    }

    /**
     * the constructor.
     * 
     * @param key
     *            testrail key
     * @param server
     *            testrail server
     */
    public TCOfNightlyBuildTask(String key, String server) {
        this.testrailKey = key;
        this.testrailServer = server;
    }

    /**
     * the constructor.
     */
    public TCOfNightlyBuildTask() {
    }

}
