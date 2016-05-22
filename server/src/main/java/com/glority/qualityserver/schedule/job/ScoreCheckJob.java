package com.glority.qualityserver.schedule.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.service.ScoreCheckService;

/**
 * to do score check job, send report to score owner.
 * 
 * @author zm.
 * 
 */
// @QuartzJob(name = "scoreCheckJob", cronExp = "0 0 8 * * ?")
@QuartzJob(name = "scoreCheckJob", cronExp = "0 0 8 * * ?")
public class ScoreCheckJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(ScoreCheckJob.class);

    @Autowired
    private ScoreCheckService scoreCheckService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if (!this.isScoreCheckEnabled()) {
            LOGGER.info("scoreCheckJob not enabled");
            return;
        }
        LOGGER.info("start scoreCheckJob ..");
        this.scoreCheckService.checkScore();
        LOGGER.info("end scoreCheckJob ..");

    }

    /**
     * check whether the feature is enabled.
     * 
     * @return if enable.
     */
    private boolean isScoreCheckEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.SCORE_CHECK);
    }

}
