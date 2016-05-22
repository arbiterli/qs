package com.glority.qualityserver.web.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.quality.reportxml.QualityReport;
import com.glority.qualityserver.service.QualityReportService;
import com.glority.qualityserver.web.service.QualityReportSaveService;

/**
 * Quality report save service implementation.
 * 
 * @author liheping
 * 
 */
@Service("qualityReportSaveService")
public class QualityReportSaveServiceImpl implements QualityReportSaveService {
    @Autowired
    private QualityReportService reportService;

    public void saveQualityReport(InputStream inputStream) throws Exception {
        QualityReport report = this.reportService.parseQualityReport(inputStream);

        this.reportService.saveQualityReport(report);
    }
}
