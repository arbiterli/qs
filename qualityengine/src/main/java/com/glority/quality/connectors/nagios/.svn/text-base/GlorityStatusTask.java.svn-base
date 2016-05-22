/**
 * 
 */
package com.glority.quality.connectors.nagios;

import java.util.List;

import com.glority.common.connectors.nagios.ServiceStatus;

/**
 * status task.
 * 
 * @author CLB
 * 
 */
public class GlorityStatusTask extends NagiosTask {
    private List<ServiceStatus> statuses;

    @Override
    protected void proccessWithConnector() throws Exception {
        this.statuses = super.connector.getServiceStatuses();
    }

    /**
     * get result.
     * 
     * @return list of Status
     */
    public List<ServiceStatus> getResult() {
        return statuses;
    }
}
