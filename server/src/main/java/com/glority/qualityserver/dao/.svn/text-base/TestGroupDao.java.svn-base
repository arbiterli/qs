package com.glority.qualityserver.dao;

import com.glority.qualityserver.model.TestGroup;

/**
 * TestGroup dao interface.
 */
public interface TestGroupDao extends GenericDao<TestGroup, Long> {
    /**
     * get the latest test group in the build.
     * 
     * @param buildId
     *            the build id
     * @return TestGroup, if not exists, return null
     */
    TestGroup getLatestTestGroup(long buildId);
}
