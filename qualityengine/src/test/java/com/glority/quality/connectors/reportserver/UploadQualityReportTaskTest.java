package com.glority.quality.connectors.reportserver;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.junit.After;
import org.junit.Before;

import com.glority.common.connectors.ConnectorException;

/**
 * Add JunitTest for UploadQualityReportTask.
 * @author Chen.hong
 *
 */
public class UploadQualityReportTaskTest {

    private File testFile;

    private String filePath;

    @Before
    public void setUp() throws Exception {
        filePath = createTestFile();
    }

    //@Test
    public void testProcess() throws UnsupportedEncodingException, ConnectorException {
        UploadQualityReportTask task = new UploadQualityReportTask();
        task.setQualityXmlPath(filePath);

        Project project = new Project();
        MockBuildListener listener = new MockBuildListener();
        project.addBuildListener(listener);

        task.setProject(project);
        task.process();

        assertTrue(listener.isMessageLogged);
    }

    @After
    public void tearDown() {
        testFile.delete();
    }

    private String createTestFile() throws IOException {
        testFile = new File("test.xml");
        if (!testFile.exists()) {
            testFile.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<qaulityreport><productinfo><businessunit>Glority</businessunit>"
                + "<productname>QualityEngine</productname><productversion>1.0</productversion>"
                + "<svnurl>http://svn.glority.com/projects/QualitySystem/trunk/qualityengine</svnurl>"
                + "<svnrevision>999</svnrevision></productinfo><buildtestinfo>"
                + "<certification/><timestamp/></buildtestinfo></qaulityreport>");
        writer.flush();
        writer.close();
        return testFile.getPath();
    }

    /**
     * Mock a BuildListener for testing.
     */
    private class MockBuildListener implements BuildListener {

        protected boolean isMessageLogged = false;

        @Override
        public void buildFinished(BuildEvent event) {
            System.out.println("runing into buildFinished:" + event.getMessage());
        }

        @Override
        public void buildStarted(BuildEvent event) {
            System.out.println("runing into buildStarted:" + event.getMessage());
        }

        @Override
        public void targetFinished(BuildEvent event) {
            System.out.println("runing into targetFinished:" + event.getMessage());
        }

        @Override
        public void targetStarted(BuildEvent event) {
            System.out.println("runing into targetStarted:" + event.getMessage());
        }

        @Override
        public void taskFinished(BuildEvent event) {
            System.out.println("runing into taskFinished:" + event.getMessage());
        }

        @Override
        public void taskStarted(BuildEvent event) {
            System.out.println("runing into taskStarted:" + event.getMessage());
        }

        @Override
        public void messageLogged(BuildEvent event) {
            isMessageLogged = true;
            System.out.println("runing into messageLogged:" + event.getMessage());
        }
    }
}
