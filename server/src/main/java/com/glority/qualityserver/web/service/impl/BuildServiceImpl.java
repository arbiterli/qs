package com.glority.qualityserver.web.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.metricengine.MetricEngine;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.Test;
import com.glority.qualityserver.model.TestCase;
import com.glority.qualityserver.model.TestGroup;
import com.glority.qualityserver.model.TestSuite;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.model.BuildInfoMapKeys;
import com.glority.qualityserver.web.service.BuildService;

/**
 * build service implementation.
 * 
 * @author liheping
 * 
 */
@Service("buildService")
public class BuildServiceImpl extends DBBaseService implements BuildService {
    private static final Logger LOGGER = Logger.getLogger(BuildServiceImpl.class);
    @Autowired
    private MetricEngineDBService dbService;

    @Autowired
    private AccessControlService aclService;

    public List<List<Object>> getFailedTestCase(long buildId) {
        TestGroup testGroup = super.testGroupManager.getLatestTestGroup(buildId);

        if (testGroup == null || testGroup.getTestses() == null) {
            return new ArrayList<List<Object>>();
        }

        List<Test> testList = this.pickLatestTestRecords(testGroup.getTestses());

        List<TestSuite> testSuiteList = super.testSuiteManger.getTestSuite(testList);

        List<TestCase> failedTestCaseList = this.getFailedTestCases(testSuiteList);
        LOGGER.debug("failedTestCaseList.size - " + failedTestCaseList.size());
        return this.translateTestCases(failedTestCaseList);
    }

    private List<List<Object>> translateTestCases(List<TestCase> testCaseList) {
        List<List<Object>> result = new ArrayList<List<Object>>();

        if (testCaseList == null || testCaseList.isEmpty()) {
            return result;
        }

        for (TestCase testCase : testCaseList) {
            result.add(translateTestCase(testCase));
        }

        return result;
    }

    private List<Object> translateTestCase(TestCase testCase) {
        List<Object> result = new ArrayList<Object>();

        if (testCase == null) {
            return null;
        }

        result.add(Long.valueOf(testCase.getId()));
        result.add(testCase.getName());
        result.add(testCase.getTime());
        result.add(testCase.getResult());

        return result;
    }

    private List<Test> pickLatestTestRecords(Set<Test> testSet) {
        List<Test> testList = new ArrayList<Test>();
        testList.addAll(testSet);
        return testList;
    }

    private List<TestCase> getFailedTestCases(List<TestSuite> testSuiteList) {
        List<TestCase> testCaseList = new ArrayList<TestCase>();

        if (testSuiteList == null || testSuiteList.isEmpty()) {
            return testCaseList;
        }

        for (TestSuite testSuite : testSuiteList) {

            List<TestCase> failList = this.getSpecifiedResultTestCase(testSuite.getTestcases(), Constants.FAIL);
            testCaseList.addAll(failList);
        }

        return testCaseList;
    }

    private List<TestCase> getSpecifiedResultTestCase(Set<TestCase> testSet, String specifiedResult) {
        List<TestCase> caseList = new ArrayList<TestCase>();

        if (testSet != null) {
            //TODO:compiler warning,need refactoring code.
            for (Iterator<TestCase> iter = testSet.iterator(); iter.hasNext();) {
                TestCase testCase = (TestCase) iter.next();
                if (specifiedResult.equalsIgnoreCase(testCase.getResult())) {
                    caseList.add(testCase);
                }
            }
        }

        return caseList;
    }

    /**
     * get the history build info for product, between start date and end date.
     * 
     * @param productId
     *            , startDate, endDate
     * @return List<BuildInfo>
     */
    @Transactional
    public List<HashMap<String, Object>> getHistoryBuildInfo(long productId, Timestamp startDate,
            Timestamp endDate, int pageSize, int currentPage) {
        LOGGER.debug("getHistoryBuildInfo : productId - " + productId + " startDate - " + startDate
                + " endDate - " + endDate);
        MetricEngineProfile profile = new MetricEngineProfile();
        profile.setProductId(productId);
        MetricEngine engine = new MetricEngine(profile, this.dbService);

        List<Build> buildList = super.buildManager.getBuildsInPeriod(productId, startDate,
                endDate, pageSize, currentPage);
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        for (Build build : buildList) {
            result.add(this.translateBuildInfo(build, engine));
        }

        return result;
    }

    public int getBuildsCount(long productId, Timestamp startTime, Timestamp endTime) {
        return super.buildManager.getBuildsCount(productId, startTime, endTime);
    }

    private HashMap<String, Object> translateBuildInfo(final Build build, MetricEngine engine) {
        HashMap<String, Object> buildInfo = new HashMap<String, Object>();

        buildInfo.put("id", build.getId());
        buildInfo.put("jenkins_jobname", build.getJenkinsJobname());
        buildInfo.put("jenkins_buildeid", build.getJenkinsBuildId());

        DateFormat df = new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS);
        String time = build.getCreatedAt() != null ? df.format(build.getCreatedAt()) : Constants.NO_DATA;
        buildInfo.put("created_at", time);
        buildInfo.put("version", build.getVersion().getVersion());

        String testTotalCount = engine.getMetric(MetricEngine.TEST_TOTAL_COUNT, build.getId());
        buildInfo.put("testTotalCount", Constants.NO_DATA.equals(testTotalCount) ? testTotalCount
                : (int) Double.parseDouble(testTotalCount));

        String testFailureCount = engine.getMetric(MetricEngine.TEST_FAILURE_COUNT, build.getId());
        buildInfo.put("testFailureCount", Constants.NO_DATA.equals(testFailureCount) ? testFailureCount
               : (int) Double.parseDouble(testFailureCount));
        buildInfo.put("svn_url", null == build.getSvnUrl() ? Constants.NO_DATA : build.getSvnUrl());
        buildInfo.put("svn_revision", null == build.getSvnRevision() ? Constants.NO_DATA : build.getSvnRevision());
        buildInfo.put("certification", null == build.getCertification() ? Constants.NO_DATA : build.getCertification());

        return buildInfo;
    }

    public Map<String, Object> getBuildDetail(long buildId) {
        Build build = super.buildManager.get(buildId);

        if (build == null) {
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>();

        result.put(BuildInfoMapKeys.ID, build.getId());

        SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS);
        String buildTime = build.getCreatedAt() == null ? Constants.NO_DATA : df.format(build.getCreatedAt());
        result.put(BuildInfoMapKeys.BUILD_TIME, buildTime);
        result.put(BuildInfoMapKeys.VERSION, build.getVersion().getVersion());
        result.put(BuildInfoMapKeys.CERTIFICATION, build.getCertification());
        result.put(BuildInfoMapKeys.JENKINS_BUILD_NAME, build.getJenkinsJobname());
        result.put(BuildInfoMapKeys.JENKINS_BUILD_ID, build.getJenkinsBuildId());
        result.put(BuildInfoMapKeys.SVN_URL, build.getSvnUrl());
        result.put(BuildInfoMapKeys.SVN_VERSION, build.getSvnRevision());

        MetricEngineProfile profile = new MetricEngineProfile();
        profile.setBuildId(buildId);
        MetricEngine engine = new MetricEngine(profile, this.dbService);

        result.put(BuildInfoMapKeys.FAILED_TEST_NUMBER, engine.getMetric(MetricEngine.TEST_FAILURE_COUNT, buildId));
        result.put(BuildInfoMapKeys.TEST_NUMBER, engine.getMetric(MetricEngine.TEST_TOTAL_COUNT, buildId));
        result.put(BuildInfoMapKeys.LINES_OF_COMMENT, engine.getMetric(MetricEngine.LINES_OF_COMMENT, buildId));
        result.put(BuildInfoMapKeys.LINES_OF_CODE, engine.getMetric(MetricEngine.LINES_OF_CODE, buildId));

        return result;
    }

    public List<BuildMetric> getMetrics(long buildId) {
        return super.metricManager.getMetricsForScoreCalculate(buildId);
    }

    public List<List<Object>> getSuccessTestCase(long buildId) {
        TestGroup testGroup = super.testGroupManager.getLatestTestGroup(buildId);

        if (testGroup == null || testGroup.getTestses() == null) {
            return new ArrayList<List<Object>>();
        }

        List<Test> testList = this.pickLatestTestRecords(testGroup.getTestses());

        List<TestSuite> testSuiteList = super.testSuiteManger.getTestSuite(testList);

        List<TestCase> successTestCaseList = this.getSuccessTestCases(testSuiteList);
        LOGGER.debug("successTestCaseList.size - " + successTestCaseList.size());
        return this.translateTestCases(successTestCaseList);
    }

    private List<TestCase> getSuccessTestCases(List<TestSuite> testSuiteList) {
        List<TestCase> testCaseList = new ArrayList<TestCase>();

        if (testSuiteList == null || testSuiteList.isEmpty()) {
            return testCaseList;
        }

        for (TestSuite testSuite : testSuiteList) {

            List<TestCase> successList = this.getSpecifiedResultTestCase(testSuite.getTestcases(), Constants.SUCCESS);
            testCaseList.addAll(successList);
        }

        return testCaseList;
    }

    @Transactional
    public void certifyBuild(long buildId, ProductStage stage) {
        User user = this.aclService.getCurrentUser();
        if (user != null) {
            Build build = super.buildManager.get(buildId);
            if (build != null) {
                ProductStage nextStage = super.buildManager.certifyBuild(build, stage);
                if (nextStage != null) {
                    Phase phase = super.phaseManager.getPhase(build.getProduct().getId(), nextStage);
                    super.buildCertifyHistoryManager.save(build, phase, user.getLogin());
                }
            }
        }
    }
}
