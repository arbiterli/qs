package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class TestCaseDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private TestCaseDaoHibernate testCase;

    @Test
    public void testGetFailedTestCaseInTestSuite() {
        assertEquals(0, testCase.getFailedTestCaseInTestSuite(0).size());
        assertEquals(1, testCase.getFailedTestCaseInTestSuite(4).size());
    }
}
