package com.glority.qualityserver.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.QualityEngineFailureDao;
import com.glority.qualityserver.manager.QualityEngineFailureManager;
import com.glority.qualityserver.model.QualityEngineFailure;
/**
 * Quality Engine Failure Manager Impl class.
 */
@Service("qualityenginefailureManager")
public class QualityEngineFailureManagerImpl extends GenericManagerImpl<QualityEngineFailure, Long> implements
        QualityEngineFailureManager {

    @Autowired
    private QualityEngineFailureDao qualityEngineFailureDao;

    @Override
    protected GenericDao<QualityEngineFailure, Long> getDao() {
        return qualityEngineFailureDao;
    }

    @Override
    public List<QualityEngineFailure> getQualityEngineFailureWithTask(String task) {
        return qualityEngineFailureDao.getQualityEngineFailureWithTask(task);
    }

}
