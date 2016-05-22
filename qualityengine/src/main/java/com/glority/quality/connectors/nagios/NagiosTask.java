/**
 * 
 */
package com.glority.quality.connectors.nagios;

import com.glority.common.connectors.nagios.NagiosConnector;
import com.glority.quality.BaseTask;

/**
 * nagios base task
 * 
 * @author CLB
 */
public abstract class NagiosTask extends BaseTask {
    private String username;
    private String password;
    private String baseUrl;
    private String productname;

    protected NagiosConnector connector;

    @Override
    public void process() throws Exception {
        this.connector = new NagiosConnector(this.baseUrl, this.productname, this.username, this.password);
        this.proccessWithConnector();
    }

    protected abstract void proccessWithConnector() throws Exception;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
