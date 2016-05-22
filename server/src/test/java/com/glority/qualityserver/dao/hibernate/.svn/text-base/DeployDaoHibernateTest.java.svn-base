package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class DeployDaoHibernateTest extends AbstractBaseTest {
    @Autowired
    private DeployDaoHibernate deployDaoHibernate;

    @Test
    public void testGetPreviewHotDeploys() {
        assertEquals(0, deployDaoHibernate.getPreviewHotDeploys(0).size());
        assertEquals(127, deployDaoHibernate.getPreviewHotDeploys(24).size());
    }

    @Test
    public void testGetProductionHotDeploys() {
        assertEquals(0, deployDaoHibernate.getProductionHotDeploys(0).size());
        assertEquals(39, deployDaoHibernate.getProductionHotDeploys(24).size());
    }

    @Test
    public void testGetLatestSuccessBaseDeploy() {
        assertTrue(deployDaoHibernate.getLatestSuccessBaseDeploy(0) == null);
        assertEquals("113", String.valueOf(deployDaoHibernate.getLatestSuccessBaseDeploy(24).getBuildId()));
    }

    @Test
    public void testGetAllDeploys() {
        assertEquals(0, deployDaoHibernate.getAllDeploys(0, 0).size());
        assertEquals(19, deployDaoHibernate.getAllDeploys(24, 32).size());
    }
}
