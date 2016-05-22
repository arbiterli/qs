package com.glority.quality.connectors.testcomplete;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.connectors.testrail.TCOfTestRunTask;

/**
 * to test GenerateTestRunPjs.
 * @author zm
 *
 */
public class GenerateTestRunPjsTest extends GeneratePjsBaseTestCase {

    @Before
    public void init() throws IOException {
        super.init();
        generator = new GenerateTestRunPjs();
        testrailTask = new TCOfTestRunTask();
        testrailTask.setTestrailKey(TESTRAIL_KEY);
        testrailTask.setTestrailServer(TESTRAIL_SERVER);
        ((TCOfTestRunTask)testrailTask).setTestrunId("11");
        generator.setPjsTemplate(PJS_TEMPLATE);
        generator.setTestCasePath(ATC_PATH);
        ((GenerateTestRunPjs)generator).setProductId("2");
        ((GenerateTestRunPjs)generator).setVersion("4.5");
        ((GenerateTestRunPjs)generator).setType("development");
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
        System.out.println(caseNum);
        System.out.println(caseNumFromPjs);
    }
}
