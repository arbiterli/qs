package com.glority.qualityserver.manager;

import java.util.List;
import java.util.Map;

import com.glority.quality.Constants.IssueStatus;
import com.glority.quality.model.Issue;
import com.glority.quality.model.TestCase;
import com.glority.qualityserver.model.IssueRecord;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Version;

/**
 * Issue manager interface.
 * 
 * @author liheping
 * 
 */
public interface IssueManager extends GenericManager<IssueRecord, Long> {

    /**
     * create new IssueRecord with some property setted, without save to DB.
     * 
     * @return
     */
    IssueRecord createNewIssueRecord(Product product, Version version, Long issueTrackId);

    /**
     * update issue test passed info, without save to DB.
     * 
     * @param record
     * @param map
     * @param map2
     * @return
     */
    boolean updateIssueRecord(IssueRecord record, Map<String, TestCase> devTestCaseMap,
            Map<String, TestCase> nightlyTestCaseMap);

    /**
     * update issue test case defined and test case automated field, without
     * save to DB.
     * 
     * @param record
     * @param testcasesMap
     * @return
     */
    boolean updateIssueRecord(IssueRecord record, Map<String, TestCase> testcasesMap);

    /**
     * update issue base info, without save to DB.
     * 
     * @param record
     * @param issue
     * @return
     */
    boolean updateIssueRecord(IssueRecord record, Issue issue);

    /**
     * count the issue numbers in status.
     * 
     * @param productId
     * @param versionId
     * @param status
     * @return
     */
    int countIssues(List<IssueRecord> issueList, IssueStatus status);

    /**
     * get all issues in version for product.
     * 
     * @param productId
     * @param versionId
     * @return
     */
    List<IssueRecord> getIssueRecords(long productId, long versionId);
}
