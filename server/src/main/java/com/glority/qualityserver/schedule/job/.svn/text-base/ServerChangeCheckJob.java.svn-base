package com.glority.qualityserver.schedule.job;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.glority.qualityserver.DeployProtocol;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.thread.check.CheckRunner;
import com.glority.qualityserver.thread.check.CheckThread;
import com.glority.qualityserver.thread.check.SSHExecCheckRunner;

/**
 * check server changes.
 * 
 * @author liheping
 * 
 */
// @QuartzJob(name = "serverCheckJob", cronExp = "0/20 * * * * ?")
@QuartzJob(name = "serverChangeCheckJob", cronExp = "0 0 0/1 * * ?")
public class ServerChangeCheckJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(ServerChangeCheckJob.class);
    private static final int MAX_THREAD_NUM = 5;
    private static ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD_NUM);

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        boolean featureEnabled = FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SERVER_CHANGE_CHECK);
        if (!featureEnabled) {
            return;
        }

        Date sampleTime = super.getSampleTime();
        LOGGER.debug("Server Change Checkr, Sample Time : " + super.df.format(sampleTime));

        List<Server> serverList = super.schedulerService.getCheckServers();

        if (serverList != null && !serverList.isEmpty()) {
            for (Server server : serverList) {
                DeployProtocol protocol = DeployProtocol.getDeployProtocol(server.getDeployProtocol());

                CheckRunner checkRunner = null;
                if (DeployProtocol.SSH == protocol) {
                    LOGGER.debug("doing ssh check for server " + server.getId());
                    checkRunner = new SSHExecCheckRunner(super.schedulerService, server);
                } else {
                    LOGGER.debug("doing unsupported protocol check for server " + server.getId());
                }

                if (checkRunner != null) {
                    CheckThread checkThread = new CheckThread(checkRunner);
                    pool.execute(checkThread);
                }
            }
        }
    }

}
