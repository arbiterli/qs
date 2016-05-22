package com.glority.qualityserver.schedule.job;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.common.connectors.jenkins.JenkinsBuildExecutor;
import com.glority.quality.connectors.jenkins.JenkinsBuildExecutorGetTask;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.error.ErrorFrom;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.schedule.QuartzJob;

/**
 * JenkinsSlaveOfflineMonitorJob.
 * 
 * @author li.heping
 * 
 */
@QuartzJob(name = "jenkinsSlaveOfflineMonitorJob", cronExp = "0 0 0/1 * * ?")
public class JenkinsSlaveOfflineMonitorJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(JenkinsSlaveOfflineMonitorJob.class);

    public static final String JENKINS_URL = "jenkinsUrl";

    public static final String JENKINS_AUTO_CREATED_FLAG = "Jenkins_Auto_Created_Node";

    @Autowired
    private SystemErrorManager systemErrorManager;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if (!this.isJenkinsSlaveOfflineMonitorEnabled()) {
            LOGGER.info("jenkinsSlaveOfflineMonitorJob is not enabled");
            return;
        }

        LOGGER.info("jenkinsSlaveOfflineMonitorJob is start working");
        try {
            List<JenkinsBuildExecutor> allExecutorList = this.getAllBuildExecutors();
            this.removeJenkinsAutoCreatedSlaves(allExecutorList);
            this.doWithOfflineExecutor(allExecutorList);
        } catch (Exception e) {
            super.reportError(e, "monitor jenkins slave offline job failed!");
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("jenkinsSlaveOfflineMonitorJob is start working");
    }

    private void removeJenkinsAutoCreatedSlaves(List<JenkinsBuildExecutor> allExecutorList) {
        for (Iterator<JenkinsBuildExecutor> iter = allExecutorList.iterator(); iter.hasNext();) {
            JenkinsBuildExecutor executor = iter.next();
            if (executor.getDisplayName() == null || executor.getDisplayName().contains(JENKINS_AUTO_CREATED_FLAG)) {
                iter.remove();
            }
        }
    }

    private void doWithOfflineExecutor(List<JenkinsBuildExecutor> allExecutorList) {
        for (JenkinsBuildExecutor executor : allExecutorList) {
            if (executor.isOffline()) {
                SystemError error = this.systemErrorManager.createSystemError(ErrorFrom.MONITORING_SYSTEM,
                        "Jenkins slave " + executor.getDisplayName() + " is offline", null, null);
                this.systemErrorManager.save(error);
            }
        }
    }

    private List<JenkinsBuildExecutor> getAllBuildExecutors() {
        String jenkinsUrl = ServerSettings.getInstance().getSetting(JENKINS_URL);
        JenkinsBuildExecutorGetTask executorTask = new JenkinsBuildExecutorGetTask(jenkinsUrl);
        executorTask.setProject(new Project());
        executorTask.execute();
        return executorTask.getExecutorList();
    }

    private boolean isJenkinsSlaveOfflineMonitorEnabled() {
        return FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.JENKINS_SLAVE_MONITOR);
    }

}
