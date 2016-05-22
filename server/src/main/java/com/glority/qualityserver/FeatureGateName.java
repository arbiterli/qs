package com.glority.qualityserver;

/**
 * feature gate name enum.
 * 
 * the value of this enum is the property name in qualityserver.properties
 * 
 * @author liheping
 * 
 */
public enum FeatureGateName {
    SERVER_CHANGE_CHECK("featureGate_serverChangeCheck"),
    SERVER_MONITORING("featureGate_ServerMonitoring"),
    CLEAR_DEAD_DEPLOY("featureGate_clearDeadDeploy"),
    SYNCHRONIZE_ISSUE("featureGate_synchronizeIssue"),
    TESTRAIL_INFO_CHECK("featureGate_testrailInfoCheck"),
    HOTDEPLOY_CHECK("featureGate_hotDeployCheckJob"),
    BASE_DEPLOY("featureGate_baseDeoploy"),
    ISSUE_FIX_ABILITY_CHECK("featureGate_issueFixAbilityCheck"),
    SCORE_CHECK("featureGate_scoreCheckJob"),
    SUPPORT_DB_EMAIL_SEND("featureGate_supportDBEmailSend"),
    REPORT_SYSTEM_ERROR("featureGate_reportSystemError"),
    JENKINS_SLAVE_MONITOR("featureGate_jenkinsSlaveMonitor"),
    QUALITY_REPORT_SCAN("featureGate_qualityReportScan");

    private String value;

    /**
     * constructor.
     * 
     * @param value
     *            String value the the feature gate name
     */
    private FeatureGateName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
