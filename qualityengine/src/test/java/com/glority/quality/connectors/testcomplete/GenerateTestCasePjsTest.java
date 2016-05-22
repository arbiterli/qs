package com.glority.quality.connectors.testcomplete;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.connectors.testrail.GetSingleTCTask;


public class GenerateTestCasePjsTest extends GeneratePjsBaseTestCase {
    
    @Before
    public void init() throws IOException {
        super.init();

        generator = new GenerateTestCasePjs();
        testrailTask = new GetSingleTCTask();
        testrailTask.setTestrailKey(TESTRAIL_KEY);
        testrailTask.setTestrailServer(TESTRAIL_SERVER);
        ((GetSingleTCTask)testrailTask).setCaseId("91");
        generator.setPjsTemplate(PJS_TEMPLATE);
        generator.setTestCasePath(ATC_PATH);
        ((GenerateTestCasePjs)generator).setCaseId("91");
        generator.setTestrailKey(TESTRAIL_KEY);
        generator.setTestrailServer(TESTRAIL_SERVER);
    }
    
    @Test
    @Override
    public void testGeneratePjs() throws ConnectorException {
        generator.process();
        testrailTask.process();
        int caseNum = testrailTask.getTestCases().size();
        int caseNumFromPjs = getCaseNumFromPjsFiles();
        assertEquals(caseNum, caseNumFromPjs);
    }
}
