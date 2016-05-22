package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class TestGroupDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private TestGroupDaoHibernate testGroup;

    @Test
    public void testGetFailedTestCaseInTestSuite() {
        assertTrue(testGroup.getLatestTestGroup(0) == null);
        assertEquals("8", String.valueOf(testGroup.getLatestTestGroup(15).getId()));
    }
}
