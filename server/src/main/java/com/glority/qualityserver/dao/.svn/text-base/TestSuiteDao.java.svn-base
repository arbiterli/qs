package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.TestSuite;

/**
 * TestSuite DAO interface.
 * 
 * @author liheping
 * 
 */
public interface TestSuiteDao extends GenericDao<TestSuite, Long> {
    /**
     * get all test suites in test.
     * 
     * @param testId
     *            the test id
     * @return List<TestSuite>, if not exists, it is an empty list
     */
    List<TestSuite> getTestSuitesInTest(long testId);
}
