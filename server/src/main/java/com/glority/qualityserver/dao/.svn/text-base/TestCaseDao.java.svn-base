package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.TestCase;

/**
 * Test case DAO interface.
 * 
 * @author liheping
 * 
 */
public interface TestCaseDao extends GenericDao<TestCase, Long> {
    /**
     * get failed TestCases in Test suite.
     * 
     * @param testSuiteId
     *            the test suite id
     * @return List<TestCase>, if not exists, it is an empty list
     */
    List<TestCase> getFailedTestCaseInTestSuite(long testSuiteId);
}
