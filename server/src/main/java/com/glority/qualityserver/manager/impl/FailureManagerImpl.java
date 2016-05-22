package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.FailureDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.FailureManager;
import com.glority.qualityserver.model.Failure;

/**
 * Implementation for Failure manager.
 * 
 * @author liheping
 * 
 */
@Service("failureManager")
public class FailureManagerImpl extends GenericManagerImpl<Failure, Long> implements FailureManager {
    @Autowired
    private FailureDao failureDao;

    @Override
    protected GenericDao<Failure, Long> getDao() {
        // TODO Auto-generated method stub
        return this.failureDao;
    }

}
