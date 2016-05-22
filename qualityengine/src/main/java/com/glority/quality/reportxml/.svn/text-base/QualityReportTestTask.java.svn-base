package com.glority.quality.reportxml;

import com.glority.quality.BaseTask;
/**
 * QualityReportTestTask.
 * @author liheping
 *
 */
public class QualityReportTestTask extends BaseTask {
    private String jenkinsJobName;
    private String jenkinsBuildId;

    @Override
    public void process() {
        qualityReport.addJenkinsTestInfo(null, jenkinsJobName, jenkinsBuildId);
        exportQualityXml();
    }

    public void setJenkinsJobName(String jenkinsJobName) {
        this.jenkinsJobName = jenkinsJobName;
    }

    public void setJenkinsBuildId(String jenkinsBuildId) {
        this.jenkinsBuildId = jenkinsBuildId;
    }
}
