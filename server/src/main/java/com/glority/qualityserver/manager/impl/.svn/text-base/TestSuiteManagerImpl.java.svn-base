package com.glority.qualityserver.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.TestSuiteDao;
import com.glority.qualityserver.manager.TestSuiteManager;
import com.glority.qualityserver.model.Test;
import com.glority.qualityserver.model.TestSuite;

/**
 * TestSuiteManager implementation.
 * 
 * @author liheping
 * 
 */
@Service("testSuiteManager")
public class TestSuiteManagerImpl extends GenericManagerImpl<TestSuite, Long> implements TestSuiteManager {

    @Autowired
    private TestSuiteDao testSuiteDao;

    @Override
    protected GenericDao<TestSuite, Long> getDao() {
        return this.testSuiteDao;
    }

    public List<TestSuite> getTestSuite(List<Test> testList) {
        List<TestSuite> testSuiteList = new ArrayList<TestSuite>();

        if (testList == null) {
            return testSuiteList;
        }

        for (Test test : testList) {
            List<TestSuite> suiteList = this.testSuiteDao.getTestSuitesInTest(test.getId());

            testSuiteList.addAll(suiteList);
        }

        return testSuiteList;
    }

}
