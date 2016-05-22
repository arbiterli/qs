package com.glority.qualityserver.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.glority.quality.reportxml.QualityReport;
import com.glority.qualityserver.model.Product;

/**
 * Quality report service interface.
 * 
 * @author liheping
 * 
 */
public interface QualityReportService {
    /**
     * Parse the xml report string to QualityReport
     * 
     * @param reportString
     * @return
     * @throws Exception
     */
    QualityReport parseQualityReport(String reportString) throws Exception;

    /**
     * parse the quality report inputstream to QualityReport
     * 
     * @param inputStream
     * @return
     * @throws Exception
     */
    QualityReport parseQualityReport(InputStream inputStream) throws Exception;

    /**
     * Generate Quality report to xml String
     * 
     * @param report
     * @return
     * @throws Exception
     */
    String generateQualityReport(QualityReport report) throws Exception;

    /**
     * save quality report to db.
     * 
     * @param report
     */
    void saveQualityReport(QualityReport report);

    /**
     * get new report path in ftp.
     * 
     * @return
     */
    Map<Product, List<String>> getNewReportFTPPaths();

    /**
     * retrieve Quality Report from ftp.
     * 
     * @param newReportPath
     * @return
     * @throws Exception
     */
    QualityReport retrieveQualityReport(String newReportPath) throws Exception;

    /**
     * validate the report.
     * 
     * @param product
     * @param report
     */
    void validateReport(Product product, String path, QualityReport report);
}
