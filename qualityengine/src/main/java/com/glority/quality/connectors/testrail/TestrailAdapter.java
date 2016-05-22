package com.glority.quality.connectors.testrail;

import java.util.List;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.Constants.TestRunType;
import com.glority.quality.model.TestCase;

/**
 * the interface of testrail operation.
 * 
 * @author zm
 * 
 */

public interface TestrailAdapter {
    /**
     * to config the adapter.
     * 
     * @param testrailServer
     *            the testrail server.
     * @param testrailKey
     *            the testrail key.
     */
    void config(String testrailServer, String testrailKey);

    /**
     * to get the testcases of product.
     * 
     * @param productId
     *            product id.
     * @return a list of test cases.
     */
    List<TestCase> getTestCasesOfProduct(String productId) throws ConnectorException;

    /**
     * to get the testcases of a product in certain version.
     * 
     * @param productId
     *            the id of product.
     * @param productVersion
     *            the version of a product.
     * @return a list of test cases.
     */
    List<TestCase> getTestCasesOfVersion(String productId, String productVersion) throws ConnectorException;

    /**
     * to get the nightbuild testcases of a product in certain version.
     * 
     * @param productId
     *            the id of a product.
     * @param productVersion
     *            the version of a product.
     * @return a list of test cases.
     */
    List<TestCase> getNightlyBuildTests(String productId, String productVersion) throws ConnectorException;

    /**
     * to update the result of a test.
     * 
     * @param testId
     *            the id of a test.
     * @param testResult
     *            the result of a test.
     * @param message
     *            the message of a result.
     */
    void updateTestResult(String testId, String testResult, String message) throws ConnectorException;

    /**
     * to get a list of test cases of a test run.
     * 
     * @param testRunId
     *            the id of test run.
     * @return a list of test cases.
     */
    List<TestCase> getTestRunResult(String testRunId) throws ConnectorException;

    /**
     * to get a list of test cases of a test run.
     * 
     * @param testRunId
     *            the id of test run.
     * @return a list of test cases.
     */
    List<TestCase> getTestRunResult(String productId, String version,
            TestRunType type) throws ConnectorException;

    /**
     * to get a single testcase.
     * 
     * @param caseId
     *            the caseId.
     * @return a testcase.
     */
    List<TestCase> getSingleTestCase(String caseId) throws ConnectorException;
}
