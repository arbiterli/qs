package com.glority.quality.reportxml;

import com.glority.quality.BaseTask;

/**
 * Quality report initial task.
 * 
 * @author liheping
 * 
 */
public class QualityReportInitialTask extends BaseTask {
    private String businessUnit;
    private String productName;
    private String productVersion;
    private String svnUrl;
    private String svnRevision;

    @Override
    public void process() throws Exception {
        qualityReport = new QualityReport();
        qualityReport.initialQualityProcess(businessUnit, productName,
                productVersion, svnUrl, svnRevision);
        qualityReport.writeToFile(qualityXmlPath);
    }

    /**
     * Do nothing here since this task will initial a new quality xml.
     */
    public void loadQualityReport() {
        // Do nothing
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }
}
