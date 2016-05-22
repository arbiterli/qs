package com.glority.qualityserver.web.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.model.QualityEngineFailure;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.service.QualityEngineFailureService;
/**
 * Quality Engine Failure Service Impl class.
 */
@Service("quailtyenginefailureService")
public class QualityEngineFailureServiceImpl extends DBBaseService implements QualityEngineFailureService {
    private static Log log = LogFactory.getLog(QualityEngineFailureServiceImpl.class.getName());

    /**
     * Save the QualityEngineFailure into database.
     */
    @Override
    public void reportFailure(QualityEngineFailure entity) {
        if (log.isDebugEnabled()) {
            log.debug("report the QualityEngineFailure with detail: " + entity);
        }
        super.qualityEngineFailureManager.save(entity);
    }

    @Override
    public List<QualityEngineFailure> getAllQualityEngineFailues() {
        if (log.isDebugEnabled()) {
            log.debug("enter the method: QualityEngineFailureServiceImpl#getAllQualityEngineFailues");
        }
        return super.qualityEngineFailureManager.getAll();
    }

    @Override
    public List<QualityEngineFailure> getQualityEngineFailures(String task) {
        if (log.isDebugEnabled()) {
            log.debug("enter QualityEngineFailureServiceImpl#getAllQualityEngineFailues with task=" + task);
        }
        return super.qualityEngineFailureManager.getQualityEngineFailureWithTask(task);
    }
}
