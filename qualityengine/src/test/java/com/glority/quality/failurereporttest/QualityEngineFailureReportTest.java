package com.glority.quality.failurereporttest;

import org.apache.tools.ant.Project;
import org.junit.Test;

/**
 * Junit test for testing quality engine failure system.
 *
 * <p>
 * In order to run the test, it should setup the jetty server. Make sure
 * "http://localhost:8080/reportQualityEngineFailure" can be accessed.
 * </p>
 * 
 * <p>
 * After running the test case, please open the database to see if the failure is reported to server manually.
 * </p>
 * 
 * @author Chen.hong
 * 
 */
public class QualityEngineFailureReportTest {

    @Test
    public void test() {
        MockTask task = new MockTask();
        task.setOwner("test");
        task.setDescription("for testing");

        task.setProject(new Project());

        try {
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
