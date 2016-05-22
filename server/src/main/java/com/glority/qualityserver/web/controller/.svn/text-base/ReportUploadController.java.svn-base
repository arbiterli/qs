package com.glority.qualityserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.glority.qualityserver.web.service.QualityReportSaveService;

/**
 * ReportUploadController holds quality report upload.
 * 
 * @author liheping
 * 
 */
@Controller
public class ReportUploadController {
    @Autowired
    private QualityReportSaveService reportSaveService;

    @RequestMapping("/upload")
    public String uploadReport(@RequestParam("xml") MultipartFile file) {
        try {
            this.reportSaveService.saveQualityReport(file.getInputStream());
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
