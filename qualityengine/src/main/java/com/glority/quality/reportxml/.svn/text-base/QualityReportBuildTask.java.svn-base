package com.glority.quality.reportxml;

import com.glority.quality.BaseTask;
/**
 * QualityReportBuildTask.
 * @author liheping
 *
 */
public class QualityReportBuildTask extends BaseTask {
    private String jenkinsJobName;
    private String jenkinsBuildId;

    @Override
    public void process() {
        qualityReport.addJenkinsBuildInfo(jenkinsJobName, jenkinsBuildId);
        exportQualityXml();

    }

    public void setJenkinsJobName(String jenkinsJobName) {
        this.jenkinsJobName = jenkinsJobName;
    }

    public void setJenkinsBuildId(String jenkinsBuildId) {
        this.jenkinsBuildId = jenkinsBuildId;
    }
}
