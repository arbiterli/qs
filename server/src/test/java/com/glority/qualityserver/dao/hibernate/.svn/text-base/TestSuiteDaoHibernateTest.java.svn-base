package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class TestSuiteDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private TestSuiteDaoHibernate testSuite;

    @Test
    public void testGetTestSuitesInTest() {
        assertEquals(0, testSuite.getTestSuitesInTest(0L).size());
        assertEquals(2, testSuite.getTestSuitesInTest(3L).size());
    }

}
