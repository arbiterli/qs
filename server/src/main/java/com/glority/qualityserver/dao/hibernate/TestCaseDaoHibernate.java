package com.glority.qualityserver.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.TestCaseDao;
import com.glority.qualityserver.model.TestCase;

/**
 * Hibernate implementation for TestCase DAO.
 * 
 * @author liheping
 * 
 */
@Repository("testCaseDao")
public class TestCaseDaoHibernate extends GenericDaoHibernate<TestCase, Long> implements TestCaseDao {
    /**
     * Default constructor.
     */
    public TestCaseDaoHibernate() {
        super(TestCase.class);
    }

    /**
     * get failed TestCases in Test suite.
     * 
     * @param testSuiteId
     *            the test suite id
     * @return List<TestCase>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<TestCase> getFailedTestCaseInTestSuite(long testSuiteId) {
        List<TestCase> failedList = super.getHibernateTemplate().find(
                "from TestCase where testsuite_id = ? and result = 'fail'", Long.valueOf(testSuiteId));

        if (failedList == null) {
            return new ArrayList<TestCase>();
        }

        return failedList;
    }
}
