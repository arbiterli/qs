package com.glority.quality.connectors.jenkins;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.jenkins.JenkinsBuild;
import com.glority.common.connectors.jenkins.JenkinsBuild.BuildResult;

/**
 * a task to get jenkins build result.
 * 
 * @author zm.
 * 
 */
public class JenkinsCheckBuildResult extends JenkinsBase {

    private String buildId;
    private String jobName;

    private JenkinsBuild build;

    public JenkinsCheckBuildResult(String baseUrl) {
        super(baseUrl);
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public BuildResult getResult() {
        return build == null ? null : build.getResult();
    }

    public String getConsoleOutput() throws ConnectorException {
        return super.connector.getJenkinsBuildConsoleOutput(this.jobName, this.buildId);
    }

    @Override
    protected void doWithConnector() throws Exception {
        this.build = super.connector.getJenkinsBuild(this.jobName, this.buildId);
    }

}
