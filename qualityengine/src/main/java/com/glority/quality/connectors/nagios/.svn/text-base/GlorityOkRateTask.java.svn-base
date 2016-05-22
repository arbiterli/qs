/**
 * 
 */
package com.glority.quality.connectors.nagios;

/**
 * Ok rate task.
 * 
 * @author CLB
 * 
 */
public class GlorityOkRateTask extends NagiosTask {

    private double okRate;

    @Override
    protected void proccessWithConnector() throws Exception {
        this.okRate = super.connector.getServiceOkRate();
    }

    /**
     * get result.
     * 
     * @return list of Status
     */
    public double getResult() {
        return okRate;
    }
}
