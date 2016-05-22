package com.glority.quality.metrics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.model.Metric;

/**
 * TestCheckBaseTask.
 * 
 * @author
 */
public abstract class TestCheckBaseTask extends MetricsCheckBaseTask {
    /** The number of tests. */
    protected int totalCount = 0;

    /** The number of failures. */
    protected int failCount = 0;

    /** Error Count. */
    protected int errorCount = 0;

    /** The number passes. */
    protected int passCount = 0;

    /** The success rate. */
    protected float successRate = 0;

    /** The list of the test cases represented in metric list. */

    protected List<Metric> tests;

    protected MetricResult testResult;

    public TestCheckBaseTask() {
        tests = new ArrayList<Metric>();
        testResult = MetricResult.METRIC_INVALIDTHRESHOLD;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public int getPassCount() {
        return passCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public float getSuccessRate() {
        return successRate;
    }

    public List<Metric> getTests() {
        return tests;
    }

    public abstract String getTestFrameworkName();

    /**
     * For the test metrics, we need add the test cases to test section.
     * 
     * @Override
     */
    public void updateQualityXML() {
        if (qualityReport == null) {
            return;
        }
        try {
            // qr.addMetrics(getMetrics());
            qualityReport.updateTestResult(getTestFrameworkName(), this.tests);
            // Considering there maybe some test cases in the quality report.
            // We should recalculate the test summary metrics base on the new
            // merged test list
            qualityReport.updateTestSummary(getTestFrameworkName(), testResult);
            qualityReport.writeToFile(qualityXmlPath);
        } catch (Exception e) {
            getProject().log("Error: Failed to update metrics to quality xml");
            throw new BuildException(e);
        }
    }

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric total = new Metric();
        total.setName(getTestFrameworkName() + "_"
                + MetricName.TEST_TOTAL_COUNT);
        total.setNewValue(this.totalCount);
        total.setType(MetricType.METRIC_TYPE_TEST_SUMMARY);
        total.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(total);

        Metric passed = new Metric();
        passed.setName(getTestFrameworkName() + "_"
                + MetricName.TEST_PASSED_COUNT);
        passed.setNewValue(this.passCount);
        passed.setType(MetricType.METRIC_TYPE_TEST_SUMMARY);
        passed.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(passed);

        Metric sr = new Metric();
        sr.setName(getTestFrameworkName() + "_" + MetricName.TEST_SUCCESS_RATE);
        sr.setNewValue(this.successRate);
        sr.setType(MetricType.METRIC_TYPE_TEST_SUMMARY);
        sr.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(sr);

        Metric fail = new Metric();
        String metricName = getTestFrameworkName() + "_"
                + MetricName.TEST_FAILED_COUNT;
        fail.setName(metricName);
        fail.setNewValue(this.failCount);
        fail.setType(MetricType.METRIC_TYPE_TEST_SUMMARY);
        String threshold = getThreshold(metricName);
        fail.setOldValue(threshold);
        if (isInt(threshold)) {
            int oldValue = Integer.parseInt(threshold);
            fail.setResult(checkMetric(oldValue, failCount,
                    MetricCompareMode.SMALLER_BETTER));
        } else if (threshold != null) {
            fail.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        } else {
            fail.setResult(MetricResult.METRIC_NULL);
        }
        metrics.add(fail);
        testResult = fail.getResult();
        // Add all test case metrics
        // metrics.addAll(tests);

        return metrics;
    }

    public void addTestCaseMetric(String name, MetricResult result,
            String oldValue, String newValue, String duration) {
        Metric m = new Metric();
        m.setName(name);
        m.setNewValue(newValue);
        m.setOldValue(oldValue);
        m.setResult(result);
        m.setTime(duration);
        m.setType(MetricType.METRIC_TYPE_TESTCASE);

        tests.add(m);
    }

    // TODO:
    // 1. Maybe, we need also parse the failures and errors
    // 2. Currently we treat error as failure
    @Override
    public void parseReport() {
        File f = new File(reportPath);
        if (f.isFile()) {
            parseReportFile(f);
        } else {
            // If the path is a folder, process all xml reports under the folder
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.getPath().endsWith(".xml")) {
                    parseReportFile(file);
                }
            }
        }
    }

    protected abstract void parseReportFile(File file);
}
