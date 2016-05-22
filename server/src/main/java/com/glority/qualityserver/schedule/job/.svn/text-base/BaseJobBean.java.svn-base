package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ServerErrorCollector;
import com.glority.qualityserver.service.SchedulerService;
import com.glority.qualityserver.util.DateUtils;

/**
 * BaseJob for QuartzJobBean.
 * 
 * @author li.heping
 * 
 */
public abstract class BaseJobBean extends QuartzJobBean {
    @Autowired
    protected SchedulerService schedulerService;

    protected DateFormat df = new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS);

    protected Timestamp getSampleTime() {
        Timestamp now = new Timestamp(new Date().getTime());

        translateToSampleTime(now);

        return now;
    }

    public static void translateToSampleTime(Timestamp date) {
        DateUtils.setTimeToStartTimeOfHour(date);
    }

    protected void reportError(Throwable e, String externInfo) {
        ServerErrorCollector.getInstance().collectorError(e, externInfo);
    }

    protected void reportError(String info, String externInfo) {
        ServerErrorCollector.getInstance().collectError(info, externInfo);
    }

    public void testEntry() throws JobExecutionException {
        this.executeInternal(null);
    }
}
