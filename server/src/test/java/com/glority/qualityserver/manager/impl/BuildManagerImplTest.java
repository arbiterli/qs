package com.glority.qualityserver.manager.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;

public class BuildManagerImplTest extends AbstractBaseTest {

    @Autowired
    private BuildManagerImpl build;

    @Test
    public void testGetBuild() {
        assertEquals("1", String.valueOf(build.getBuild(1, "QaulityNightly", 22).getProduct().getId()));
    }

    @Test
    public void testGetBuildInVersion() {
        assertEquals("133", String.valueOf(build.getBuildInVersion(3, 3, ProductStage.INVALID).getId()));
        assertEquals("133", String.valueOf(build.getBuildInVersion(3, 3, ProductStage.DEV).getId()));
    }

    @Test
    public void testGetAllBuildsInVersion() {
        assertEquals(55, build.getAllBuildsInVersion(3, 3, ProductStage.INVALID).size());
    }

    @Test
    public void testGetBuildsInPeriod() {
        Timestamp earlierTime = Timestamp.valueOf("2012-09-01 00:00:00");
        Timestamp laterTime = Timestamp.valueOf("2012-11-01 00:00:00");
        assertEquals(33, build.getBuildsInPeriod(3, earlierTime, laterTime, Constants.PAGE_SIZE, 1).size());
        assertEquals(33, build.getBuildsInPeriod(3, null, laterTime, Constants.PAGE_SIZE, 1).size());
        assertEquals(50, build.getBuildsInPeriod(3, earlierTime, null, Constants.PAGE_SIZE, 1).size());
        assertEquals(50, build.getBuildsInPeriod(3, null, null, Constants.PAGE_SIZE, 1).size());
    }
}
