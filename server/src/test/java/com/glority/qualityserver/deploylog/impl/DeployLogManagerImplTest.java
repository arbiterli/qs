package com.glority.qualityserver.deploylog.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.qualityserver.deploylog.DeployLog;
import com.glority.qualityserver.deploylog.impl.DeployLogManagerImpl.ClearTask;

/**
 * Junit test for DeployLogManagerImpl class.
 * 
 * @author Chenhong
 * 
 */
public class DeployLogManagerImplTest {

    private static final int TEN = 10;
    private DeployLogManagerImpl impl;

    private File file;

    /**
     * setup.
     * 
     * @throws Exception
     *             to junit
     */
    @Before
    public void setUp() throws Exception {
        impl = new DeployLogManagerImpl();
        mockFileData();
    }

    /**
     * Tear down, delete test file.
     * 
     * @throws Exception
     *             to junit
     */
    @After
    public void tearDown() throws Exception {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    /**
     * test get log info method with directory not test log name.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testGetLogInfo() {
        Map<Object, Object> ret = impl.getLogInfo("test_log_directory");
        List<String> result = (List<String>) ret.get(DeployLogManagerImpl.DEPLOY_LOG);
        assertTrue(result.isEmpty());
    }

    /**
     * Use Reflection to get the deployLogpath.
     * 
     * @return the deploy log path
     * @throws Exception
     *             to junit
     */
    private String getDeployLogPath() throws Exception {
        Field field = impl.getClass().getDeclaredField("deployLogPath");
        field.setAccessible(true);
        return (String) field.get(impl);
    }

    /**
     * Prepare a file for testing.
     * 
     * @throws Exception
     *             to junit
     */
    private void mockFileData() throws Exception {
        String deployLogPath = getDeployLogPath();
        if (deployLogPath != null && deployLogPath.startsWith("d:")) {
            deployLogPath = "c://";
            Field field = impl.getClass().getDeclaredField("deployLogPath");
            field.setAccessible(true);
            field.set(impl, deployLogPath);
        }
        file = new File(deployLogPath + File.separator + "test_log.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.append("test_log");
        writer.close();
    }

    /**
     * Test getLogInfo.
     * 
     * @throws Exceptin
     *             to junit
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetLogInfo2() throws Exception {
        Map<Object, Object> ret = impl.getLogInfo("test_log.log");
        List<String> result = (List<String>) ret.get(DeployLogManagerImpl.DEPLOY_LOG);
        assertEquals(1, result.size());
        assertEquals("test_log", result.get(0));
    }

    /**
     * Test add DeployLog.
     * 
     * @throws Exception
     *             to junit
     */
    @Test
    public void testAddDeployLog() throws Exception {
        DummyDeployLog log = new DummyDeployLog();
        impl.addDeployLog(log);

        File outputFile = log.getFile();

        assertNotNull(outputFile);
        assertTrue(outputFile.exists());

    }

    /**
     * Test method dispose.
     * 
     * @throws Exception
     *             to junit
     */
    @Test
    public void testDisposeDeployLog() throws Exception {
        DummyDeployLog log = new DummyDeployLog();
        impl.addDeployLog(log);
        File outputFile = log.getFile();

        assertNotNull(outputFile);
        assertTrue(outputFile.exists());

        String deployLogPath = getDeployLogPath();
        String key = outputFile.getName();
        impl.disposeDeployLog(key);

        File file = new File(deployLogPath + File.separator + key);
        assertFalse(file.exists());
    }

    /**
     * Test the task.
     */
    @Test
    public void testTask() {
        Hashtable<String, DeployLog> table = new Hashtable<String, DeployLog>();
        for (int i = 0; i < TEN; i++) {
            table.put("test_" + i, new DummyDeployLog());
        }
        ClearTask clearTask = new ClearTask(table);
        clearTask.run();

        assertTrue(table.isEmpty());
    }
}
