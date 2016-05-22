package com.glority.qualityserver.schedule.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.service.ReportScanAndSaveService;

/**
 * ReportScanJob. be careful to refactor this class. the transactional
 * annotaion.
 * 
 * @author Li.heping.
 * 
 */
@QuartzJob(name = "reportScanJob", cronExp = "0 0/5 * * * ?")
public class ReportScanJob extends BaseJobBean {
    private static final Logger LOGGER = Logger.getLogger(ReportScanJob.class);
    @Autowired
    private ReportScanAndSaveService scanAndSaveService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if (!this.isReportScanJobEnabled()) {
            LOGGER.info("report scan job is not enabled");
            return;
        }
        LOGGER.info("report scan job start working...");
        this.scanAndSaveService.scanAndSaveNewReports();
        LOGGER.info("report scan job finished work.");
    }

    private boolean isReportScanJobEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.QUALITY_REPORT_SCAN);
    }
}
