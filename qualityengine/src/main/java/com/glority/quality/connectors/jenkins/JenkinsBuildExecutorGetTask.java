package com.glority.quality.connectors.jenkins;

import java.util.ArrayList;
import java.util.List;

import com.glority.common.connectors.jenkins.JenkinsBuildExecutor;

/**
 * JenkinsBuildExecutorGetTask. this task is used for get JenkinsBuildExecutor
 * from jenkins.
 * 
 * @author Li.heping
 * 
 */
public class JenkinsBuildExecutorGetTask extends JenkinsBase {
    private List<JenkinsBuildExecutor> executorList = new ArrayList<JenkinsBuildExecutor>();

    public JenkinsBuildExecutorGetTask(String baseUrl) {
        super(baseUrl);
    }

    /**
     * return executorList. be sure that the process method is invoked before
     * this method called. otherwise, only empty list got.
     * 
     * @return
     */
    public List<JenkinsBuildExecutor> getExecutorList() {
        return this.executorList;
    }

    @Override
    protected void doWithConnector() throws Exception {
        this.executorList = super.connector.getJenkinsBuildExecutors();
    }

}
