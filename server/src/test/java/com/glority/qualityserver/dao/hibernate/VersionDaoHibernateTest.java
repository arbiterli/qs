package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.ProductStage;

public class VersionDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private VersionDaoHibernate version;

    private Timestamp time = Timestamp.valueOf("2012-10-01 00:00:00");
    private Timestamp endTime = Timestamp.valueOf("2012-12-31 00:00:00");

    @Test
    public void testExistsByVersionAndProductId() {
        assertTrue(version.exists("1.0", 1));
        assertFalse(version.exists("1.0", 0));
    }

    @Test
    public void testGetVersion() {
        assertEquals("1", String.valueOf(version.getVersion("1.0", 1).getId()));
        assertTrue(version.getVersion("1.0", 0) == null);
    }

    @Test
    public void testGetVersionForDevStage() {
        // Fixed Notes: the expected version here should be 1.1
        assertEquals("1.1", String.valueOf(version.getVersions(1, ProductStage.DEV, time).get(0).getVersion()));
        assertTrue(version.getVersions(0, ProductStage.DEV, time).isEmpty());
    }

    @Test
    public void testGetVersionForStageStage() {
        assertEquals("1.1", String.valueOf(version.getVersions(1, ProductStage.STAGE, time).get(0).getVersion()));

        assertTrue(version.getVersions(0, ProductStage.STAGE, time).isEmpty());
    }

    @Test
    public void testGetVersionForTestStage() {
        assertEquals("1.1", String.valueOf(version.getVersions(1, ProductStage.TEST, time).get(0).getVersion()));
        assertTrue(version.getVersions(0, ProductStage.TEST, time).isEmpty());
    }

    @Test
    public void testGetVersionForBeforeDate() {
        assertEquals(2, version.getVersionsBeforeDate(1, ProductStage.DEV, endTime).size());
        assertEquals(0, version.getVersionsBeforeDate(0, ProductStage.DEV, endTime).size());
    }

    @Test
    public void testGetTestVersionsBeforeDate() {
        assertEquals(2, version.getVersionsBeforeDate(1, ProductStage.TEST, endTime).size());
        assertEquals(0, version.getVersionsBeforeDate(0, ProductStage.TEST, endTime).size());
    }

    @Test
    public void testGetStageVersionsBeforeDate() {
        assertEquals(2, version.getVersionsBeforeDate(1, ProductStage.STAGE, endTime).size());
        assertEquals(0, version.getVersionsBeforeDate(0, ProductStage.STAGE, endTime).size());
    }

    @Test
    public void testGetProdVersionsBeforeDate() {
        assertEquals(2, version.getVersionsBeforeDate(1, ProductStage.PROD, endTime).size());
        assertEquals(0, version.getVersionsBeforeDate(0, ProductStage.PROD, endTime).size());
    }

}
