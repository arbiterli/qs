package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.TestGroupDao;
import com.glority.qualityserver.manager.TestGroupManager;
import com.glority.qualityserver.model.TestGroup;

/**
 * TestGroup manager implementation.
 * 
 * @author liheping
 * 
 */
@Service("testGroupManager")
public class TestGroupManagerImpl extends GenericManagerImpl<TestGroup, Long> implements TestGroupManager {
    @Autowired
    private TestGroupDao testGroupDao;

    @Override
    protected GenericDao<TestGroup, Long> getDao() {

        return this.testGroupDao;
    }

    public TestGroup getLatestTestGroup(long buildId) {
        return this.testGroupDao.getLatestTestGroup(buildId);
    }
}
