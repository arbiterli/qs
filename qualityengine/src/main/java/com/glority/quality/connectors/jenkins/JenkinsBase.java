package com.glority.quality.connectors.jenkins;

import com.glority.common.connectors.jenkins.JenkinsConnector;
import com.glority.quality.BaseTask;

/**
 * the jenkins base task.
 * 
 * @author zm
 * 
 */
public abstract class JenkinsBase extends BaseTask {

    private String baseUrl;
    protected JenkinsConnector connector;

    public JenkinsBase(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public void process() throws Exception {
        connector = new JenkinsConnector(this.baseUrl);
        this.doWithConnector();
    }

    protected abstract void doWithConnector() throws Exception;

}
