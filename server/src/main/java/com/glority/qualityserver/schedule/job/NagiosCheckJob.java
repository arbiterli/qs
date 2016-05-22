/**
 * 
 */
package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.glority.common.connectors.nagios.ServiceNotification;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.connectors.nagios.GlorityNotificationTask;
import com.glority.quality.connectors.nagios.GlorityOkRateTask;
import com.glority.quality.connectors.nagios.NagiosTask;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.schedule.QuartzJob;

/**
 * integrate nagios.
 * 
 * @author CLB updated by LiHeping
 */

// "0/20 * * * * ?"
// "0 0 0/1 * * ?"
@QuartzJob(name = "nagiosCheckJob", cronExp = "0 0 0/1 * * ?")
public class NagiosCheckJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(NagiosCheckJob.class);

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        boolean featureEnabled = FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SERVER_MONITORING);
        if (!featureEnabled) {
            LOGGER.info("NagiosCheckJob is disabled");
            return;
        }

        List<Server> serverList = super.schedulerService.getAllNagiosIsActiveServer();
        LOGGER.debug("Nagios Active Server List : " + serverList);

        if (serverList == null || serverList.isEmpty()) {
            return;
        }
        Timestamp sampleTime = super.getSampleTime();

        modifyAvgOkRate(serverList, sampleTime);

//        modifyNotification(serverList);

    }

    private void modifyAvgOkRate(List<Server> serverList, Timestamp sampleTime) {
        LOGGER.debug("Sample AVG OK rate");
        GlorityOkRateTask nagios = new GlorityOkRateTask();
        for (Server server : serverList) {
            this.initNagiosBaseTask(nagios, server);
            try {
                nagios.execute();
                double avgOkRate = nagios.getResult();
                super.schedulerService.saveRecordMetric(server, MetricType.METRIC_TYPE_RUN_QUALITY,
                        MetricName.AVERAGE_SLA, Double.toString(avgOkRate), sampleTime);
            } catch (Exception e) {
                super.reportError(e, "server : " + server.getName());
                LOGGER.error(e.getMessage(), e);
            }
        }
    }


    private void modifyNotification(List<Server> serverList) {
        LOGGER.debug("Sample notification");
        // GlorityNotificationTask get notifications in 24 hours.
        GlorityNotificationTask nagios = new GlorityNotificationTask();
        for (Server server : serverList) {
            this.initNagiosBaseTask(nagios, server);
            nagios.setContact("quality");
            try {
                nagios.execute();
                List<ServiceNotification> notificationList = nagios.getResult();
                super.schedulerService.saveNotifications(notificationList, server);
            } catch (Exception e) {
                super.reportError(e, "server : " + server.getName());
                e.printStackTrace();
            }
        }
    }

    private void initNagiosBaseTask(NagiosTask nagios, Server server) {

        nagios.setBaseUrl(server.getNagiosUrl());
        nagios.setUsername(server.getNagiosUserName());
        nagios.setPassword(server.getNagiosPassword());
        nagios.setProductname(server.getNagiosHost());
        Project project = new Project();
        nagios.setProject(project);
    }

}
