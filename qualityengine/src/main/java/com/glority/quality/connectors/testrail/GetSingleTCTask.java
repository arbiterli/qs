package com.glority.quality.connectors.testrail;

import com.glority.common.connectors.ConnectorException;

/**
 * to get single test case info from testrail.
 * 
 * @author zm
 * 
 */
public class GetSingleTCTask extends TestrailBase {

    /**
     * the case id.
     */
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Override
    public void process() throws ConnectorException {
        if (adapter == null) {
            configAdapter();
        }
        this.resultTC = adapter.getSingleTestCase(caseId);
    }

    /**
     * the constructor.
     * 
     * @param key
     *            testrail key
     * @param server
     *            testrail server
     */
    public GetSingleTCTask(String key, String server) {
        this.testrailKey = key;
        this.testrailServer = server;
    }

    /**
     * the constructor.
     */
    public GetSingleTCTask() {
    }

}
