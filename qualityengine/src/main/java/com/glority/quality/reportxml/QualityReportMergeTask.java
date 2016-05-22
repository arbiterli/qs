package com.glority.quality.reportxml;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.glority.quality.BaseTask;
/**
 * QualityReportMergeTask.
 * @author liheping
 *
 */
public class QualityReportMergeTask extends BaseTask {
    private String srcRptOneName;
    private String srcRptTwoName;

    private String targetRptName;

    public String getSrcRptOneName() {
        return srcRptOneName;
    }

    public void setSrcRptOneName(String srcRptOneName) {
        this.srcRptOneName = srcRptOneName;
    }

    public String getSrcRptTwoName() {
        return srcRptTwoName;
    }

    public void setSrcRptTwoName(String srcRptTwoName) {
        this.srcRptTwoName = srcRptTwoName;
    }

    public String getTargetRptName() {
        return targetRptName;
    }

    public void setTargetRptName(String targetRptName) {
        this.targetRptName = targetRptName;
    }

    @Override
    public void process() throws Exception {
        QualityReport source = translateFileToReport(this.srcRptOneName);
        QualityReport target = translateFileToReport(this.srcRptTwoName);

        target.merge(source);

        String xml = target.toXml();

        FileWriter writer = new FileWriter(this.targetRptName);
        writer.write(xml);
        writer.close();

    }

    private QualityReport translateFileToReport(String fileName)
            throws Exception {
        File inputFile = new File(fileName);

        SAXReader reader = new SAXReader();

        Document doc = reader.read(inputFile);

        QualityReport report = new QualityReport(doc.asXML());

        return report;
    }

}
