package com.glority.quality.connectors.jenkins;

import java.util.List;

import com.glority.common.connectors.jenkins.JenkinsJob;

/**
 * to get all jenkins jobs.
 * 
 * @author zm
 * 
 */
public class JenkinsGetJobs extends JenkinsBase {
    private List<JenkinsJob> jobsList;

    public JenkinsGetJobs(String baseUrl) {
        super(baseUrl);
    }

    public List<JenkinsJob> getJobsList() {
        return this.jobsList;
    }

    @Override
    protected void doWithConnector() throws Exception {
        this.jobsList = super.connector.getJenkinsJobs();
    }
}
