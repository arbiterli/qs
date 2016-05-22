package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.manager.AlertManager;
import com.glority.qualityserver.model.Alert;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.schedule.QuartzJob;

/**
 * do sample server change check data.
 * 
 * @author liheping
 * 
 */
@QuartzJob(name = "sampleServerChangeCheckJob", cronExp = "0 0 0/1 * * ?")
public class SampleServerChangeCheckJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(SampleServerChangeCheckJob.class);
    private static final int HOURS = 24;

    @Autowired
    private AlertManager alertManager;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        runOnce();

    }

    public void runOnce() {
        boolean featureEnabled = FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SERVER_CHANGE_CHECK);
        if (!featureEnabled) {
            LOGGER.info("Server change check sampling is disabled");
            return;
        }

        Timestamp sampleTime = super.getSampleTime();

        List<Server> serverList = super.schedulerService.getCheckServers();
        if (serverList != null && !serverList.isEmpty()) {
            for (Server server : serverList) {
                Product product = this.schedulerService.getProduct(server);
                if (product != null) {
                    List<Alert> alertList = this.alertManager.getServerAlerts(server.getId(), AlertType.SERVER_CHANGE,
                            HOURS);
                    String countValue = (alertList == null || alertList.isEmpty()) ? "no" : "yes";
                    super.schedulerService.saveRecordMetric(server, MetricType.METRIC_TYPE_RUN_QUALITY,
                            MetricName.INVALID_CHANGE, countValue, sampleTime);
                } else {
                    LOGGER.error("Product is invalid for server: " + server.getId());
                }
            }
        }
    }

}
