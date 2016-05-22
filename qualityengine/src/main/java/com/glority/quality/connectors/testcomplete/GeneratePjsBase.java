package com.glority.quality.connectors.testcomplete;

import java.util.List;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.BaseTask;
import com.glority.quality.model.TestCase;

/**
 * base class of generate pjs.
 * 
 * @author zm.
 * 
 */
public abstract class GeneratePjsBase extends BaseTask {

    /**
     * The path of the testcomplete pjs template file.
     */
    protected String pjsTemplate;

    /**
     * The path to the test case repo in localmachine.
     */
    protected String testCasePath;

    /**
     * the testrail key.
     */
    protected String testrailKey;

    /**
     * the testrail server.
     */
    protected String testrailServer;

    /**
     * the pjs generator.
     */
    protected PjsGenerator generator;

    /**
     * the test case number limit for a pjs.
     */
    protected static final int TESTCASE_NUM_LIMIT = 10;

    public String getTestCasePath() {
        return testCasePath;
    }

    public void setTestCasePath(String testCasePath) {
        this.testCasePath = testCasePath;
    }

    public String getPjsTemplate() {
        return pjsTemplate;
    }

    public void setPjsTemplate(String pjsTemplate) {
        this.pjsTemplate = pjsTemplate;
    }

    public String getTestrailKey() {
        return testrailKey;
    }

    public void setTestrailKey(String testrailKey) {
        this.testrailKey = testrailKey;
    }

    public String getTestrailServer() {
        return testrailServer;
    }

    public void setTestrailServer(String testrailServer) {
        this.testrailServer = testrailServer;
    }

    @Override
    public void process() throws ConnectorException {
        generator = new PjsGenerator();
        generator.setPjsTemplate(pjsTemplate);
        generator.setTestCasePath(testCasePath);
        generator.generatePjs(getTCFromTestrail(), TESTCASE_NUM_LIMIT);
    }

    /**
     * to get a list of test cases.
     * @return a list of test cases.
     */
    protected abstract List<TestCase> getTCFromTestrail() throws ConnectorException;
}
