package com.glority.qualityserver.schedule.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.error.ErrorStatus;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.service.MailService;

/**
 * SystemErrorReportJob.
 * 
 * @author li.heping
 * 
 */
@QuartzJob(name = "SystemErrorReportJob", cronExp = "0 0 18 * * ?")
public class SystemErrorReportJob extends BaseJobBean {
    public static final String ERROR_REPORT_EMAILS = "errorReportEmails";
    public static final String EMAIL_SUBJECT = "Quality System Error Report";
    public static final String EMAIL_TEMPLATE = "error_report.vm";

    private static final Logger LOGGER = Logger.getLogger(SystemErrorReportJob.class);

    @Autowired
    private MailService mailService;

    @Autowired
    private SystemErrorManager systemErrorManager;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if (!this.isErrorReportJobEnabled()) {
            LOGGER.info("system error report job not enabled");
            return;
        }
        LOGGER.info("system error report job start working..");
        String reportTo = ServerSettings.getInstance().getSetting(ERROR_REPORT_EMAILS);
        String serverUrl = ServerSettings.getInstance().getSetting(Constants.SERVER_URL);
        if (StringUtils.isEmpty(reportTo)) {
            LOGGER.error("system error receiver is not configed, no email will send.");
            super.reportError("system error receiver is not configed, no email will send.", null);
            return;
        }

        List<SystemError> errorList = this.systemErrorManager.getSystemErrors(ErrorStatus.NEW);
        if (errorList == null || errorList.isEmpty()) {
            LOGGER.info("no new errors, no report email to send");
            return;
        }
        errorList = this.retainSingleErrorAndCreatedInHours(errorList, TimeUnit.DAYS.toHours(1));
        this.formartErrors(errorList);

        Map<String, Serializable> mailModel = new HashMap<String, Serializable>();
        mailModel.put("errors", new ArrayList<SystemError>(errorList));
        mailModel.put("serverUrl", serverUrl);
        this.mailService.sendHTMLEmail(reportTo, EMAIL_SUBJECT, EMAIL_TEMPLATE, mailModel);
        LOGGER.info("system error report job finished.");
    }

    private List<SystemError> retainSingleErrorAndCreatedInHours(List<SystemError> errorList, long hours) {
        Timestamp now = super.getSampleTime();
        for (Iterator<SystemError> iter = errorList.iterator(); iter.hasNext();) {
            SystemError error = iter.next();
            if (TimeUnit.MILLISECONDS.toHours((now.getTime() - error.getCreateTime().getTime())) > hours) {
                iter.remove();
            }
        }

        // error list is ordered by create time desc, and we want keep the
        // oldest one, so we need the reverse order.
        Collections.reverse(errorList);
        Set<SystemErrorExt> set = new LinkedHashSet<SystemErrorExt>();
        for (SystemError error : errorList) {
            set.add(new SystemErrorExt(error));
        }

        List<SystemError> result = new ArrayList<SystemError>(set.size());
        for (Iterator<SystemErrorExt> iter = set.iterator(); iter.hasNext();) {
            result.add(iter.next().getSystemError());
        }
        // keep the newest error comes first.
        Collections.reverse(result);
        return result;
    }

    private void formartErrors(List<SystemError> errorList) {
        if (errorList == null) {
            return;
        }
        for (SystemError error : errorList) {
            if (error.getExternInfo() == null) {
                error.setExternInfo("");
            }

            BufferedReader reader = new BufferedReader(new StringReader(error.getInfo()));
            try {
                error.setInfo(reader.readLine());
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    private boolean isErrorReportJobEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.REPORT_SYSTEM_ERROR);
    }

    /**
     * SystemErrorExt. when decide the same system error, the some info in the
     * SystemError should be ignored, such as create time. And this is the
     * purpose. equals and hashCode method is rewritten.
     * 
     * @author Li.heping
     * 
     */
    private class SystemErrorExt {
        private SystemError error;

        public SystemErrorExt(SystemError error) {
            this.error = error;
        }

        public SystemError getSystemError() {
            return this.error;
        }

        @Override
        public boolean equals(final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SystemErrorExt)) {
                return false;
            }
            SystemErrorExt castOther = (SystemErrorExt) other;
            if ((error == null && castOther.error != null) || (error != null && castOther.error == null)) {
                return false;
            }

            return new EqualsBuilder().append(error.getFrom(), castOther.error.getFrom())
                    .append(error.getInfo(), castOther.error.getInfo())
                    .append(error.getExternInfo(), castOther.error.getExternInfo()).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(error.getFrom()).append(error.getInfo()).append(error.getExternInfo())
                    .toHashCode();
        }
    }
}
