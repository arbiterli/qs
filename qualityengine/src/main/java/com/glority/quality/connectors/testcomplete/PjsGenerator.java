package com.glority.quality.connectors.testcomplete;

import java.util.List;
import com.glority.quality.model.TestCase;

/**
 * a util class to generate.
 * 
 * @author XQS
 * 
 */
public class PjsGenerator {

    /**
     * The path of the testcomplete pjs template file.
     */
    private String pjsTemplate;

    /**
     * The path to the test case repo in localmachine.
     */
    private String testCasePath;

    /**
     * Generate the pjs. This assume all the test cases are ready in the
     * specified path.
     */
    public void generatePjs(List<TestCase> testcases, int testcaseNumLimit) {
        Pjs template = new Pjs();
        template.init(this.pjsTemplate, this.testCasePath);
        int caseCounter = 0;
        int pjsCounter = 1;
        for (int i = 0; i < testcases.size(); i++) {
            TestCase tmpCase = testcases.get(i);
            if (tmpCase.getStatus() == null
                    || tmpCase.getStatus().ordinal() < 2) {
                // System.out.println("case " + tmpCase.getId()
                // + " has not been automated.");
                continue;
            }
            caseCounter++;
            template.insertTestCase(tmpCase.getId());
            if (caseCounter > testcaseNumLimit - 1) {
                template.insertReportGenerator();
                template.outputPjsFile(pjsCounter);
                caseCounter = 0;
                pjsCounter++;
                template = new Pjs();
                template.init(this.pjsTemplate, this.testCasePath);
            }
        }
        if (caseCounter > 0) {
            template.insertReportGenerator();
            template.outputPjsFile(pjsCounter);
        }
    }

    public void setPjsTemplate(String pjsTemplate) {
        this.pjsTemplate = pjsTemplate;
    }

    public void setTestCasePath(String testCasePath) {
        this.testCasePath = testCasePath;
    }

}
