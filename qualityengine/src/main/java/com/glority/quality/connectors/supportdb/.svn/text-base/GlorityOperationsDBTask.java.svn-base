package com.glority.quality.connectors.supportdb;

import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;

/**
 * .
 * 
 * @author Administrator
 * 
 */
public class GlorityOperationsDBTask extends SupportDBBaseTask {
    private String baseUrl;
    private String userName;
    private String password;

    /**
     * default SupportDBTask construct.
     */
    public GlorityOperationsDBTask() {

    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void initialClient() throws ConnectorException {
        if (super.getSupportDbClient() == null) {
            GlorityOperationsDBClient client = new GlorityOperationsDBClient(baseUrl, userName, password);
            client.initClient();
            super.setSupportDbClient(client);

        } else {
            if (super.getSupportDbClient() instanceof GlorityOperationsDBClient) {
                GlorityOperationsDBClient client = (GlorityOperationsDBClient) super.getSupportDbClient();
                client.initClient();
            } else {
                throw new BuildException("GlorityOperationsDBTask is not setted an instance of "
                        + "GlorityOperationsDBClient for SupportDbClient property");
            }
        }
    }
}
