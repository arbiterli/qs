package com.glority.quality.connectors.testcomplete;

import java.util.List;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.connectors.testrail.GetSingleTCTask;
import com.glority.quality.model.TestCase;

/**
 * to generate single test case pjs.
 * 
 * @author zm.
 * 
 */
public class GenerateTestCasePjs extends GeneratePjsBase {

    /**
     * the test case id.
     */
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Override
    protected List<TestCase> getTCFromTestrail() throws ConnectorException {
        GetSingleTCTask singleCaseTask = new GetSingleTCTask();
        singleCaseTask.setCaseId(caseId);
        singleCaseTask.setTestrailKey(testrailKey);
        singleCaseTask.setTestrailServer(testrailServer);
        singleCaseTask.process();
        List<TestCase> testcases = singleCaseTask.getTestCases();
        return testcases;
    }

}
