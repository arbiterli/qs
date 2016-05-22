package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.IssueRecord;

/**
 * Issue DAO interface.
 * 
 * @author liheping
 * 
 */
public interface IssueDao extends GenericDao<IssueRecord, Long> {
    /**
     * get all issue records in product version.
     * 
     * @param productId
     *            specified product id
     * @param versionId
     *            the version id
     * @return List<IssueRecord>, if not exists, it is an empty list
     */
    List<IssueRecord> getIssueRecords(long productId, long versionId);

}
