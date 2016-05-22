package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.quality.Constants.IssueStatus;
import com.glority.quality.Constants.TCResult;
import com.glority.quality.Constants.TCStatus;
import com.glority.quality.StringUtil;
import com.glority.quality.model.Issue;
import com.glority.quality.model.TestCase;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.IssueDao;
import com.glority.qualityserver.manager.IssueManager;
import com.glority.qualityserver.model.IssueRecord;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Version;

/**
 * issue manager implementation.
 * 
 * @author Administrator
 * 
 */
@Service("issueManager")
public class IssueManagerImpl extends GenericManagerImpl<IssueRecord, Long> implements IssueManager {

    @Autowired
    private IssueDao issueDao;

    @Override
    protected GenericDao<IssueRecord, Long> getDao() {
        return this.issueDao;
    }

    public IssueRecord createNewIssueRecord(Product product, Version version, Long issueTrackId) {

        IssueRecord record = new IssueRecord();
        record.setVersion(version);
        record.setProduct(product);
        record.setTrackId(issueTrackId);
        record.setCreateTime(new Timestamp(new Date().getTime()));
        return record;

    }

    public boolean updateIssueRecord(IssueRecord record, Map<String, TestCase> devTestCaseMap,
            Map<String, TestCase> nightlyTestCaseMap) {
        List<String> testCaseIdList = StringUtil.splitByComma(record.getTestCases());

        boolean updatedFlag = false;
        // update dev passed test
        if (record.getPassedDevTest() == null) {
            record.setPassedDevTest(false);
            updatedFlag = true;
        }

        if (!record.getPassedDevTest() && this.isTestCasesPassed(testCaseIdList, devTestCaseMap)) {
            record.setPassedDevTest(true);
            record.setPassedDevTestTime(new Timestamp(new Date().getTime()));
            updatedFlag = true;
        } else if (record.getPassedDevTest() && !this.isTestCasesPassed(testCaseIdList, devTestCaseMap)) {
            record.setPassedDevTest(false);
            updatedFlag = true;
        }

        // update nightly passed test
        if (record.getPassedNightlyTest() == null) {
            record.setPassedNightlyTest(false);
            updatedFlag = true;
        }

        if (!record.getPassedNightlyTest() && this.isTestCasesPassed(testCaseIdList, nightlyTestCaseMap)) {
            record.setPassedNightlyTest(true);
            record.setPassedNightlyTestTime(new Timestamp(new Date().getTime()));
            updatedFlag = true;
        } else if (record.getPassedNightlyTest() && !this.isTestCasesPassed(testCaseIdList, nightlyTestCaseMap)) {
            record.setPassedNightlyTest(false);
            updatedFlag = true;
        }

        return updatedFlag;
    }

    private boolean isTestCasesPassed(List<String> testCaseIdList, Map<String, TestCase> testCaseMap) {
        if (testCaseIdList == null || testCaseIdList.isEmpty()) {
            return false;
        }

        for (String testCaseId : testCaseIdList) {
            TestCase testCase = testCaseMap.get(testCaseId);
            if (testCase == null || !TCResult.PASSED.toString().equalsIgnoreCase(testCase.getResult())) {
                return false;
            }
        }

        return true;
    }

    public boolean updateIssueRecord(IssueRecord record, Map<String, TestCase> testcasesMap) {
        boolean updatedFlag = false;

        if (record != null && testcasesMap != null) {
            List<String> testcaseList = StringUtil.splitByComma(record.getTestCases());

            if (testcaseList == null || testcaseList.isEmpty()) {
                if (record.getTestDefined() == null || record.getTestDefined()) {
                    record.setTestDefined(false);
                    updatedFlag = true;
                }
            } else {
                // set test defined
                if (record.getTestDefined() == null) {
                    record.setTestDefined(false);
                    updatedFlag = true;
                }
                if (!record.getTestDefined() && isTestDefined(testcaseList, testcasesMap)) {
                    record.setTestDefined(true);
                    record.setTestDefinedTime(new Timestamp(new Date().getTime()));
                    updatedFlag = true;
                } else if (record.getTestDefined() && !isTestDefined(testcaseList, testcasesMap)) {
                    record.setTestDefined(false);
                    updatedFlag = true;
                }

                // set test automated
                if (record.getTestDefined()) {
                    if (record.getTestAutomated() == null) {
                        record.setTestAutomated(false);
                        updatedFlag = true;
                    }

                    if (!record.getTestAutomated() && this.isTestAutomated(testcaseList, testcasesMap)) {
                        record.setTestAutomated(true);
                        record.setTestAutomatedTime(new Timestamp(new Date().getTime()));
                        updatedFlag = true;
                    } else if (record.getTestAutomated() && !this.isTestAutomated(testcaseList, testcasesMap)) {
                        record.setTestAutomated(false);
                        updatedFlag = true;
                    }
                }
            }

        }

        return updatedFlag;
    }

    private boolean isTestAutomated(List<String> testcaseList, Map<String, TestCase> testcasesMap) {
        if (testcaseList == null) {
            return false;
        }

        for (String testcaseId : testcaseList) {
            TestCase testCase = testcasesMap.get(testcaseId);
            if (testCase == null || testCase.getStatus() == null
                    || testCase.getStatus().compareTo(TCStatus.AUTOMATED_PLANED) < 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isTestDefined(List<String> testcaseList, Map<String, TestCase> testcasesMap) {
        if (testcaseList == null) {
            return false;
        }

        for (String testcaseId : testcaseList) {
            TestCase testCase = testcasesMap.get(testcaseId);
            if (testCase == null || TCStatus.DRAFTED == testCase.getStatus()) {
                return false;
            }
        }

        return true;
    }

    public boolean updateIssueRecord(IssueRecord record, Issue issue) {
        boolean updatedFlag = false;

        if (record != null && issue != null) {
            if (issue.getTitle() != null && !issue.getTitle().equalsIgnoreCase(record.getTitle())) {
                record.setTitle(issue.getTitle());
                updatedFlag = true;
            }

            if (issue.getPriority() != null && !issue.getPriority().toString().equalsIgnoreCase(record.getPriority())) {
                record.setPriority(issue.getPriority().toString());
                updatedFlag = true;
            }

            if (issue.getType() != null && !issue.getType().toString().equalsIgnoreCase(record.getType())) {
                record.setType(issue.getType().toString());
                updatedFlag = true;
            }

            if (issue.getStatus() != null && !issue.getStatus().toString().equalsIgnoreCase(record.getStatus())) {
                record.setStatus(issue.getStatus().toString());
                switch (issue.getStatus()) {
                case IMPLEMENTED:
                    record.setImplementDate(new Timestamp(new Date().getTime()));
                    break;
                case CANCELLED:
                case FIXED:
                    record.setCloseDate(new Timestamp(new Date().getTime()));
                    break;
                default:
                    break;
                }

                updatedFlag = true;
            }

            if (issue.getTestCases() != null && !issue.getTestCases().equalsIgnoreCase(record.getTestCases())) {
                record.setTestCases(record.getTestCases());
                updatedFlag = true;
            }
        }

        return updatedFlag;
    }

    public int countIssues(List<IssueRecord> issueList, IssueStatus status) {
        int count = 0;
        if (issueList != null && !issueList.isEmpty() && status != null) {
            for (IssueRecord issueRecord : issueList) {
                if (status.toString().equalsIgnoreCase(issueRecord.getStatus())) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<IssueRecord> getIssueRecords(long productId, long versionId) {

        return this.issueDao.getIssueRecords(productId, versionId);
    }

}
