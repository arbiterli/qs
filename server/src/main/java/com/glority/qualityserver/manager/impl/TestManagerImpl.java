package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.TestDao;
import com.glority.qualityserver.manager.TestManager;
import com.glority.qualityserver.model.Test;

/**
 * test manager implementation.
 * 
 * @author liheping
 * 
 */
@Service("testManager")
public class TestManagerImpl extends GenericManagerImpl<Test, Long> implements TestManager {
    @Autowired
    private TestDao testDao;

    @Override
    protected GenericDao<Test, Long> getDao() {
        return this.testDao;
    }

}
