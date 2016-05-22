package com.glority.qualityserver.web.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.service.ScoreEmailSettingService;

/**
 * the implement of ScoreEmailSettingService.
 * 
 * @author CLB
 * 
 */
@Service("ScoreEmailSettingService")
public class ScoreEmailSettingServiceImpl extends DBBaseService implements ScoreEmailSettingService {
    private static final Logger LOGGER = Logger.getLogger(ScoreEmailSettingServiceImpl.class);
    public boolean setScoreEmail(long productId, String scoreName, String email) {
        LOGGER.info("do setScoreEmail...");
        return super.scoreEmailManager.save(productId, scoreName, email);
    }
    @Override
    public boolean hasSetEmail(long productId, String scoreName) {
        return super.scoreEmailManager.hasSetEmail(productId, scoreName);
    }
    @Override
    public Object getEmail(long productId, String scoreName) {
        LOGGER.info("get eamil");
        return super.scoreEmailManager.getEmail(productId, scoreName);
    }
}
