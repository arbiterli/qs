package com.glority.qualityserver.web.service.auth;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.schedule.job.BaseJobBean;
import com.glority.qualityserver.schedule.job.CloudWatchJob;
import com.glority.qualityserver.schedule.job.HotDeployCheckJob;
import com.glority.qualityserver.schedule.job.IssueFixAbilityCheckJob;
import com.glority.qualityserver.schedule.job.JenkinsSlaveOfflineMonitorJob;
import com.glority.qualityserver.schedule.job.NagiosCheckJob;
import com.glority.qualityserver.schedule.job.ReportScanJob;
import com.glority.qualityserver.schedule.job.SampleServerChangeCheckJob;
import com.glority.qualityserver.schedule.job.ScoreCheckJob;
import com.glority.qualityserver.schedule.job.ServerChangeCheckJob;
import com.glority.qualityserver.schedule.job.SynchronizeIssueJob;
import com.glority.qualityserver.schedule.job.SystemErrorReportJob;
import com.glority.qualityserver.schedule.job.TestrailInfoCheckJob;
import com.glority.qualityserver.schedule.job.WeeklyReportJob;

/**
 * debug job service;
 * 
 * @author Administrator
 * 
 */
@RemoteProxy(name = "debugJobService")
public class DebugJobService extends AbstractACLDwrService {
    @Autowired
    private ApplicationContext ctx;

    @Override
    public String getFeatureName() {
        return "DEBUG_JOB";
    }

    @RemoteMethod
    public String debugNagiosCheckJob() {
        BaseJobBean job = ctx.getBean(NagiosCheckJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugServerChangeCheckJob() {
        BaseJobBean job1 = ctx.getBean(ServerChangeCheckJob.class);
        BaseJobBean job2 = ctx.getBean(SampleServerChangeCheckJob.class);
        try {
            job1.testEntry();
            job2.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugCloudWatchJob() {
        BaseJobBean job = ctx.getBean(CloudWatchJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugIssueFixAbilityJob() {
        BaseJobBean job = ctx.getBean(IssueFixAbilityCheckJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugWeeklyReportJob() {
        BaseJobBean job = ctx.getBean(WeeklyReportJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugSynchronizeIssueJob() {
        BaseJobBean job = ctx.getBean(SynchronizeIssueJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugTestrailInfoCheckJob() {
        BaseJobBean job = ctx.getBean(TestrailInfoCheckJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugScanReportJob() {
        BaseJobBean job = ctx.getBean(ReportScanJob.class);

        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugSystemErrorReportJob() {
        BaseJobBean job = ctx.getBean(SystemErrorReportJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugScoreCheckJob() {
        BaseJobBean job = ctx.getBean(ScoreCheckJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugHotdeployCheckJob() {
        BaseJobBean job = ctx.getBean(HotDeployCheckJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }

    @RemoteMethod
    public String debugJenkinsSlaveOfflineMonitorJob() {
        BaseJobBean job = ctx.getBean(JenkinsSlaveOfflineMonitorJob.class);
        try {
            job.testEntry();
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.FAIL;
    }
}
