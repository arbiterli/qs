package com.glority.qualityserver.schedule.job;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.glority.quality.StringUtil;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.schedule.QuartzJob;

/**
 * this class do clear the dead deploy job.
 * it set all the deploy's status whose running time extend the set time to be timeout.
 * 
 * @author liheping
 * 
 */
@QuartzJob(name = "clearDeadDeployJob", cronExp = "0 0 0/1 * * ?")
public class ClearDeadDeployJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(ClearDeadDeployJob.class);
    private static final String DEPLOY_DEAD_TIME = "deployDeadTime";
    // default dead deploy Interval is one hour
    private int defaultDeadDeployTime = 1;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        if (!this.isClearDeadDeployEnabled()) {
            LOGGER.info("ClearDeadDeployJob is disabled");
            return;
        }

        int deadInterval = this.getDeadInterval();

        List<Deploy> runningDeployList = super.schedulerService.getAllRunningDeploys();

        Date now = new Date();
        List<Deploy> deadDeployList = new ArrayList<Deploy>();
        if (runningDeployList != null && !runningDeployList.isEmpty()) {
            for (Deploy deploy : runningDeployList) {
                if (this.isDeployDead(deploy, now, deadInterval)) {
                    deadDeployList.add(deploy);
                }
            }
        }

        super.schedulerService.clearDeadDeploys(deadDeployList);
    }

    /**
     * if deploy running more than one hour, it is dead.
     * 
     * @param deploy
     * @param now
     * @return
     */
    private boolean isDeployDead(Deploy deploy, Date now, int deadInterval) {
        if (deploy != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(deploy.getCreateTime());
            cal.add(Calendar.HOUR, deadInterval);
            if (!cal.getTime().after(now)) {
                return true;
            }
        }

        return false;
    }

    /**
     * get the dead deploy time from server configuration, if not configed, use the default time: one hour.
     * 
     * @return
     */
    private int getDeadInterval() {
        ServerSettings settings = ServerSettings.getInstance();
        String intervalTimeStr = settings.getSetting(DEPLOY_DEAD_TIME);
        if (!StringUtil.isEmpty(intervalTimeStr)) {
            try {
                return Integer.parseInt(intervalTimeStr);
            } catch (Exception e) {
                LOGGER.error("config for clear interval time is wrong! use default value "
                        + this.defaultDeadDeployTime + " .");
            }
        }

        return this.defaultDeadDeployTime;
    }

    /**
     * check whether the feature is enabled.
     * 
     * @return
     */
    private boolean isClearDeadDeployEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.CLEAR_DEAD_DEPLOY);
    }
}
