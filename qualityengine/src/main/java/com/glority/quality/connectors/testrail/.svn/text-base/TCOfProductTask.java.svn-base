package com.glority.quality.connectors.testrail;

import com.glority.common.connectors.ConnectorException;

/**
 * to get test cases of product.
 * 
 * @author zm.
 * 
 */
public class TCOfProductTask extends TestrailBase {

    /**
     * the id of product.
     */
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String proID) {
        this.productId = proID;
    }

    @Override
    public void process() throws ConnectorException {
        if (adapter == null) {
            configAdapter();
        }
        this.resultTC = adapter.getTestCasesOfProduct(productId);
    }

    /**
     * the constructor.
     * 
     * @param key
     *            testrail key
     * @param server
     *            testrail server
     */
    public TCOfProductTask(String key, String server) {
        this.testrailKey = key;
        this.testrailServer = server;
    }

    /**
     * the constructor.
     */
    public TCOfProductTask() {
    }
}
