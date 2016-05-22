package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.model.Test;
import com.glority.qualityserver.model.TestSuite;

/**
 * TestSuite manager interface.
 * 
 * @author liheping
 * 
 */
public interface TestSuiteManager extends GenericManager<TestSuite, Long> {
    /**
     * get all test suites based on the tests.
     * 
     * @param testList
     * @return
     */
    List<TestSuite> getTestSuite(List<Test> testList);

    // List<TestSuite> getAllTestSuiteInBuild(long buildId);
}
