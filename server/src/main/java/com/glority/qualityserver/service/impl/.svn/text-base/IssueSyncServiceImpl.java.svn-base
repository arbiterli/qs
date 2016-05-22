package com.glority.qualityserver.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.quality.Constants.IssueStatus;
import com.glority.quality.Constants.TestRunType;
import com.glority.quality.connectors.assembla.AssemblaIssueByVersionTask;
import com.glority.quality.connectors.issuedb.AbstractIssueByVersionTask;
import com.glority.quality.connectors.testrail.TCOfTestRunTask;
import com.glority.quality.connectors.testrail.TCOfVersionTask;
import com.glority.quality.model.Issue;
import com.glority.quality.model.TestCase;
import com.glority.qualityserver.manager.IssueManager;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.model.IssueRecord;
import com.glority.qualityserver.model.IssueTrack;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.TestRail;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.service.IssueSyncService;

/**
 * Issue synchronize service implementation.
 * 
 * @author liheping
 * 
 */
@Service("issueSyncService")
public class IssueSyncServiceImpl implements IssueSyncService {
    private static final Logger LOGGER = Logger.getLogger(IssueSyncServiceImpl.class);

    @Autowired
    private IssueManager issueManager;
    @Autowired
    private ProductManager productManager;

    public void synchronizeIssue(Product product, Version version) {
        List<IssueRecord> updatedIssueList = this.getUpdatedOrNewIssueRecords(product, version);

        LOGGER.debug("product - " + product.getName() + " version -" + version.getVersion()
                + " update Issues - " + updatedIssueList);
        this.issueManager.saveOrUpdateAll(updatedIssueList);
    }

    @SuppressWarnings("rawtypes")
    private List<IssueRecord> getUpdatedOrNewIssueRecords(Product product, Version version) {
        List<Issue> issueList = this.getIssuesFromIssueDB(product, version);

        Map<Long, IssueRecord> recordMap = this.getIssueRecordMapMapedByTrackId(version);

        Map<String, TestCase> testCaseDefineMap = this.getMapForTestCaseDefined(product, version);

        Map<String, TestCase> testCaseDevMap = this.getMapForTestRun(product, version, TestRunType.DEVELOPMENT);

        Map<String, TestCase> testCaseNightlyMap = this.getMapForTestRun(product, version, TestRunType.STABLE_NIGHTLY);

        List<IssueRecord> result = new ArrayList<IssueRecord>();
        if (issueList != null && !issueList.isEmpty()) {
            for (Issue issue : issueList) {
                Long issueId = this.getIssueId(issue);
                if (issueId != null) {
                    IssueRecord record = null;
                    if (!recordMap.containsKey(issueId)) {
                        record = this.issueManager.createNewIssueRecord(product, version, issueId);

                    } else {
                        record = recordMap.get(issueId);
                        recordMap.remove(issueId);
                    }
                    // update issue info
                    boolean issueDBItemUpated = this.issueManager.updateIssueRecord(record, issue);
                    // update test case defined info
                    boolean testCaseInfoUpated = this.issueManager.updateIssueRecord(record, testCaseDefineMap);
                    // update test case passed info
                    boolean testCaseStatusUpdated = this.issueManager.updateIssueRecord(record,
                            testCaseDevMap, testCaseNightlyMap);
                    if (issueDBItemUpated || testCaseInfoUpated || testCaseStatusUpdated) {
                        result.add(record);
                    }

                } else {
                    LOGGER.error("invalid issue : " + issue);
                }
            }
            // update removed
            for (Entry entry : recordMap.entrySet()) {
                // removed issues
                IssueRecord record = (IssueRecord) entry.getValue();
                record.setStatus(IssueStatus.TRADEOFF.toString());
                record.setCloseDate(new Timestamp(new Date().getTime()));

                result.add(record);
            }
        }

        return result;
    }

    private Map<String, TestCase> getMapForTestRun(Product product, Version version, TestRunType type) {
        List<TestCase> testCaseList = new ArrayList<TestCase>();
        LOGGER.debug("get map for test run ... type - " + type);
        if (this.productManager.isTestRailConfiged(product)) {
            LOGGER.debug("test rail is configed, get date from configed server ...");

            TestRail testRail = product.getTestRail();
            TCOfTestRunTask runTask = new TCOfTestRunTask();
            runTask.setProductId(testRail.getTestrailProductId().toString());
            runTask.setVersion(version.getVersion());
            runTask.setTestrailServer(testRail.getTestrailServer());
            runTask.setTestrailKey(testRail.getTestrailPassword());
            runTask.setType(type);
            runTask.setProject(new Project());
            runTask.execute();

            testCaseList = runTask.getTestCases();

            LOGGER.debug("get date from configed server finished");
        }

        return this.getTestCaseMap(testCaseList);
    }

    private Map<String, TestCase> getMapForTestCaseDefined(Product product, Version version) {
        List<TestCase> testCaseList = new ArrayList<TestCase>();

        LOGGER.debug("get map for test case define ... ");
        if (this.productManager.isTestRailConfiged(product)) {
            LOGGER.debug("test rail is configed, get date from configed server ...");

            TestRail testRail = product.getTestRail();
            TCOfVersionTask tcOfVersionTask = new TCOfVersionTask(testRail.getTestrailPassword(),
                    testRail.getTestrailServer(), version.getVersion());
            tcOfVersionTask.setProductId(testRail.getTestrailProductId().toString());
            tcOfVersionTask.setProductVersion(version.getVersion());
            tcOfVersionTask.setTestrailServer(testRail.getTestrailServer());
            tcOfVersionTask.setTestrailKey(testRail.getTestrailPassword());
            tcOfVersionTask.setProject(new Project());
            tcOfVersionTask.execute();

            testCaseList = tcOfVersionTask.getTestCases();

            LOGGER.debug("get date from configed server finished");
        }
        Map<String, TestCase> testCasesMap = this.getTestCaseMap(testCaseList);

        return testCasesMap;
    }

    /**
     * create a map which key is the testcase id, value is the test case.
     * 
     * @param testCaseList
     * @return
     */
    private Map<String, TestCase> getTestCaseMap(List<TestCase> testCaseList) {
        Map<String, TestCase> testCaseMap = new HashMap<String, TestCase>();

        if (testCaseList != null) {
            for (TestCase testCase : testCaseList) {
                testCaseMap.put(testCase.getId(), testCase);
            }
        }

        return testCaseMap;
    }

    private Map<Long, IssueRecord> getIssueRecordMapMapedByTrackId(Version version) {
        Map<Long, IssueRecord> recordMap = new HashMap<Long, IssueRecord>();

        Set<IssueRecord> issueRecords = version.getIssues();
        if (issueRecords != null && !issueRecords.isEmpty()) {
            for (IssueRecord record : issueRecords) {
                recordMap.put(record.getTrackId(), record);
            }
        }

        return recordMap;
    }

    private List<Issue> getIssuesFromIssueDB(Product product, Version version) {

        AbstractIssueByVersionTask task = new AssemblaIssueByVersionTask();
        IssueTrack issueTrack = product.getIssueTrack();

        task.setBaseURL(issueTrack.getIssueTrackBaseUrl());
        task.setProductName(issueTrack.getIssueTrackProductName());
        task.setUserName(issueTrack.getIssueTrackUsername());
        task.setPassword(issueTrack.getIssueTrackPassword());
        task.setVersion(version.getVersion());
        Project project = new Project();
        task.setProject(project);
        task.execute();

        return task.getAllIssues();

    }

    private Long getIssueId(Issue issue) {
        try {
            return Long.parseLong(issue.getId());
        } catch (Exception e) {
            return null;
        }
    }

}
