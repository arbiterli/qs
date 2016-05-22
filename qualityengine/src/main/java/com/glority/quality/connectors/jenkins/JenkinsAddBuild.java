package com.glority.quality.connectors.jenkins;

/**
 * to do jenkins add build operation.
 * 
 * @author zm
 * 
 */
public class JenkinsAddBuild extends JenkinsBase {

    private String jobName;
    private String postData;
    private int buildId;

    public JenkinsAddBuild(String url) {
        super(url);
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getBuildId() {
        return this.buildId;
    }

    @Override
    protected void doWithConnector() throws Exception {
        this.buildId = super.connector.addJenkinsBuild(this.jobName, postData);
    }

}
