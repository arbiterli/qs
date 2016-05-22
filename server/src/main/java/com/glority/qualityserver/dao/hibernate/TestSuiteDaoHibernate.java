package com.glority.qualityserver.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.TestSuiteDao;
import com.glority.qualityserver.model.TestSuite;

/**
 * Hibernate implementation for TestSuite DAO.
 * 
 * @author liheping
 * 
 */
@Repository("testSuiteDao")
public class TestSuiteDaoHibernate extends GenericDaoHibernate<TestSuite, Long> implements TestSuiteDao {

    /**
     * Default constructor.
     */
    public TestSuiteDaoHibernate() {
        super(TestSuite.class);
    }

    /**
     * get all test suites in test.
     * 
     * @param testId
     *            the test id
     * @return List<TestSuite>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<TestSuite> getTestSuitesInTest(long testId) {
        List<TestSuite> testSuiteList = super.getHibernateTemplate().find("from TestSuite where test_id = ?",
                Long.valueOf(testId));

        if (testSuiteList == null || testSuiteList.isEmpty()) {
            return new ArrayList<TestSuite>();
        }

        return testSuiteList;
    }

}
