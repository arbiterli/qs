package com.glority.qualityserver.web.service.key;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.error.ErrorFrom;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.web.service.QualityReportSaveService;

/**
 * Key is required to access this service.
 * 
 * @author xxd
 * 
 */
@Controller
@RequestMapping("/service/key/*")
public class DefaultKeyAuthService extends KeyAuthService {
    private static final Logger LOGGER = Logger.getLogger(DefaultKeyAuthService.class);
    @Autowired
    private QualityReportSaveService reportSaveService;
    @Autowired
    private SystemErrorManager systemErrorManager;

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam("key") String key) {
        super.defaultKeyAuth(key);
        return "test";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadReport(@RequestParam("xml") MultipartFile file, @RequestParam("key") String key) {
        // TODO move super.defaultKeyAuth(key) out of try catch. when the
        // permission exception is handled globally.
        try {
            super.defaultKeyAuth(key);
            this.reportSaveService.saveQualityReport(file.getInputStream());
            return Constants.SUCCESS;
        } catch (Exception e) {
            LOGGER.error("parse file - " + file.getOriginalFilename());
            LOGGER.debug(e.getMessage(), e);
        }

        return Constants.ERROR;
    }

    @RequestMapping("/reportQualityEngineFailure")
    @ResponseBody
    public String reportQualityEngineFailure(@RequestParam(value = "task") String taskName,
            @RequestParam(value = "owner") String owner, @RequestParam(value = "stacktrace") String stackTrace,
            @RequestParam("key") String key, HttpServletRequest request) {
        super.defaultKeyAuth(key);

        String ip = request.getRemoteAddr();
        SystemError error = this.systemErrorManager.createSystemError(ErrorFrom.QUALITY_ENGINE, stackTrace, taskName
                + "from " + ip, owner);
        try {
            SystemError pError = this.systemErrorManager.save(error);
            return pError == null ? Constants.FAIL : Constants.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Constants.FAIL;
        }
    }

}
