package com.glority.qualityserver.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.TestCaseDao;
import com.glority.qualityserver.manager.TestCaseManager;
import com.glority.qualityserver.model.TestCase;
import com.glority.qualityserver.model.TestSuite;

/**
 * TestCase manager implementation.
 * 
 * @author liheping
 * 
 */
@Service("testCaseManager")
public class TestCaseManagerImpl extends GenericManagerImpl<TestCase, Long> implements TestCaseManager {

    @Autowired
    private TestCaseDao testCaseDao;

    @Override
    protected GenericDao<TestCase, Long> getDao() {
        return this.testCaseDao;
    }

    public List<TestCase> getAllFailedTestCaseInTestSuites(List<TestSuite> testSuiteList) {
        List<TestCase> resultList = new ArrayList<TestCase>();

        if (testSuiteList != null) {
            for (TestSuite suite : testSuiteList) {
                List<TestCase> failedList = this.testCaseDao.getFailedTestCaseInTestSuite(suite.getId());
                resultList.addAll(failedList);
            }
        }

        return resultList;
    }

}
