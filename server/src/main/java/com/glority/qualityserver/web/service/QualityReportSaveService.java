package com.glority.qualityserver.web.service;

import java.io.InputStream;

/**
 * Quality Report Save Service.
 * 
 * @author liheping
 * 
 */
public interface QualityReportSaveService {
    void saveQualityReport(InputStream inputStream) throws Exception;
}
