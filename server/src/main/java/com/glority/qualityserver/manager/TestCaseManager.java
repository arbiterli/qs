package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.model.TestCase;
import com.glority.qualityserver.model.TestSuite;

/**
 * TestCase manager interface.
 * 
 * @author liheping
 * 
 */
public interface TestCaseManager extends GenericManager<TestCase, Long> {
    /**
     * get all failed test case in the test suites.
     * 
     * @param testSuiteList
     * @return
     */
    List<TestCase> getAllFailedTestCaseInTestSuites(List<TestSuite> testSuiteList);
}
