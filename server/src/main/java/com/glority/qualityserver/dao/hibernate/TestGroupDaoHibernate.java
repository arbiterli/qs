package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.TestGroupDao;
import com.glority.qualityserver.model.TestGroup;

/**
 * Hibernate implement for testgroup dao.
 */
@Repository("testGroupDao")
public class TestGroupDaoHibernate extends GenericDaoHibernate<TestGroup, Long> implements TestGroupDao {

    /**
     * Default constructor.
     */
    public TestGroupDaoHibernate() {
        super(TestGroup.class);
    }

    /**
     * get the latest test group in the build.
     * 
     * @param buildId
     *            the build id
     * @return TestGroup, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public TestGroup getLatestTestGroup(long buildId) {
        List<TestGroup> testGroupList = super.getHibernateTemplate().find(
                "from TestGroup where build_id = ? order by created_at desc", Long.valueOf(buildId));
        if (testGroupList == null || testGroupList.isEmpty()) {
            return null;
        }

        return testGroupList.get(0);
    }

}
