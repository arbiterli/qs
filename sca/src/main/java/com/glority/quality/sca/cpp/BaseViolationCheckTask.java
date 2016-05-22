package com.glority.quality.sca.cpp;

import com.glority.quality.sca.BaseSCATask;
import com.glority.quality.sca.FileUtil;
import com.glority.quality.sca.ReportGenerator;

/**
 * Check violation rule task.
 * 
 * @author ZJP
 * 
 */
public abstract class BaseViolationCheckTask extends BaseSCATask {
    protected String qualityXmlPath;

    public String getQualityXmlPath() {
        return qualityXmlPath;
    }

    public void setQualityXmlPath(String qualityXmlPath) {
        this.qualityXmlPath = qualityXmlPath;
    }

    @Override
    public void doWithReport() throws Exception {
        mergeReport(reportFilePath);
        ReportGenerator.getInstance().generateStandardReport(reportFilePath, analyzeOriginalReport(reportFilePath));
        FileUtil.getInstance().zipAndDeleteOriReport(reportFilePath);
    }

    /**
     * when run sca slicly ,we need to merge the reports to one report whose
     * path is reportFilePath.
     * 
     * @param reportFilePath
     * @throws Exception
     */
    public abstract void mergeReport(String reportFilePath) throws Exception;

}
