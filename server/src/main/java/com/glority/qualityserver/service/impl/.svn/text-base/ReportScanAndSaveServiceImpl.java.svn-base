package com.glority.qualityserver.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.quality.reportxml.QualityReport;
import com.glority.qualityserver.ServerErrorCollector;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.service.QualityReportService;
import com.glority.qualityserver.service.ReportScanAndSaveService;

/**
 * ReportScanAndSaveServiceImpl.
 * 
 * @author Administrator
 * 
 */
@Service
public class ReportScanAndSaveServiceImpl implements ReportScanAndSaveService {
    private static final Logger LOGGER = Logger.getLogger(ReportScanAndSaveServiceImpl.class);
    @Autowired
    private QualityReportService reportService;

    @Override
    @Transactional
    public void scanAndSaveNewReports() {
        Map<Product, List<String>> newReportPathMap = this.reportService.getNewReportFTPPaths();
        if (newReportPathMap != null && !newReportPathMap.isEmpty()) {
            for (Map.Entry<Product, List<String>> entry : newReportPathMap.entrySet()) {
                for (String newReportPath : entry.getValue()) {
                    LOGGER.debug("retrieve and save report with path " + newReportPath);
                    QualityReport report = null;
                    try {
                        report = this.reportService.retrieveQualityReport(newReportPath);
                        this.reportService.validateReport(entry.getKey(), newReportPath, report);
                        this.reportService.saveQualityReport(report);
                    } catch (Exception e) {
                        LOGGER.error("retrieve and save report with path " + newReportPath);
                        LOGGER.error(e);
                        ServerErrorCollector.getInstance().collectorError(e,
                                "occurs in get new report with path" + newReportPath);
                    }
                }
            }
        }

    }

}
