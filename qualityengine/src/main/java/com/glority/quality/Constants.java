package com.glority.quality;

import java.util.ArrayList;
import java.util.List;

/**
 * This class maintains all constants used in quality engine.
 * 
 * @author XQS
 * 
 */
// TODO: It's better to move every enums to single classes
public class Constants {

    /**
     * The error handles which represent how the failure should be handled.
     * 
     * @author XQS
     */
    public enum FailureHandle {
        IGNORE, // Ignore the error, and continue
        RETRY, // Retry the operations
        QUIT; // Quit the task
    }

    /**
     * Metric Compare mode which represents which metric is better.
     * 
     * @author XQS
     * 
     */
    public enum MetricCompareMode {
        LARGER_BETTER, // success if new value is larger
        SMALLER_BETTER; // success if new value is smaller
    }

    /**
     * Language enum.
     * 
     * @author XQS
     * 
     */
    public enum Language {
        JAVA("JAVA"), CPP("CPP"), CS("CS"), JS("JS");

        private String value;

        private Language(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    /**
     * Metric name, this will be the unique id of the metric. When you want to
     * add a metric, you need add the name in this enum.
     * 
     * @author XQS
     * 
     */
    public enum MetricName {
        CPP_CPD("CPP_CPD"),
        JAVA_CPD("JAVA_CPD"),
        CS_CPD("CS_CPD"),
        JS_CPD("JS_CPD"),
        JSP_CPD("JSP_CPD"),
        CSS_CPD("CSS_CPD"),
        JAVA_PMD("JAVA_PMD"),
        JAVA_CHECKSTYLE("JAVA_CHECKSTYLE"),
        JS_PMD("JS_PMD"),
        JSP_PMD("JSP_PMD"),
        MI("MI"),
        CMI("MI_WITH_COMMENT"),
        LOC("LINES_OF_CODE"),
        LOM("LINES_OF_COMMENT"),
        JAVA_EMMA_COVERAGE_LINE("JAVA_EMMA_COVERAGE_LINE"),
        JAVA_EMMA_COVERAGE_BLOCK("JAVA_EMMA_COVERAGE_BLOCK"),
        JAVA_EMMA_COVERAGE_METHOD("JAVA_EMMA_COVERAGE_METHOD"),
        JAVA_EMMA_COVERAGE_CLASS("JAVA_EMMA_COVERAGE_CLASS"),
        TEST_TOTAL_COUNT("TEST_TOTAL_COUNT"),
        TEST_PASSED_COUNT("TEST_PASSED_COUNT"),
        TEST_FAILED_COUNT("TEST_FAILED_COUNT"),
        TEST_SUCCESS_RATE("TEST_SUCCESS_RATE"),
        PRODUCT_TEST_TOTAL_COUNT("PRODUCT_TEST_TOTAL_COUNT"),
        PRODUCT_AUTOMATED_TEST_COUNT("PRODUCT_AUTOMATED_TEST_COUNT"),
        CPP_CPPLINT("CPP_CPPLINT"),
        CPP_CPPCHECK("CPP_CPPCHECK"),
        CPP_PCLINT_ERROR("CPP_PCLINT_ERROR"),
        CPP_PCLINT_WARNING("CPP_PCLINT_WARNING"),
        CPP_PCLINT_INFO("CPP_PCLINT_INFO"),
        CPP_BULLSEYE_COVERAGE_FUNCTION("CPP_BULLSEYE_COVERAGE_FUNCTION"),
        CPP_BULLSEYE_COVERAGE_CONDITION("CPP_BULLSEYE_COVERAGE_CONDITION"),
        CPP_BULLSEYE_COVERAGE_DECISION("CPP_BULLSEYE_COVERAGE_DECISION"),
        CS_FXCOP("CS_FXCOP"),
        CS_STYLECOP("CS_STYLECOP"),
        JS_JSLINT("JS_JSLINT"),
        AVERAGE_SLA("AVERAGE_SLA"),
        INVALID_CHANGE("INVALID_CHANGE"),
        CLOUD_WATCH_ALERTS("CLOUD_WATCH_ALERTS"),
        ALL_OPEN_ISSUE("ALL_OPEN_ISSUE"),
        ISSUE_FIX_RATE("ISSUE_FIX_RATE"),
        NEW_ISSUE("NEW_ISSUE"),
        CSS_CSSLINT("CSS_CSSLINT"),
        INVALID("INVALID");

        private String value;

        private MetricName(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        // since we overwrite toString(), this method is used to instead of
        // valueOf() method
        public static MetricName getValueOf(String value) {
            MetricName[] names = MetricName.values();
            for (MetricName name : names) {
                if (name.value.equalsIgnoreCase(value)) {
                    return name;
                }
            }

            return INVALID;
        }
    }

    /**
     * The type of metric, which groups the metrics to several sets.
     * 
     * @author XQS
     * 
     */
    public enum MetricType {
        METRIC_TYPE_DUPLICATION("DUPLICATION"), // Duplications of codes, mainly
                                                // for cpd
        METRIC_TYPE_MI("MI"), // Maintainibility Index
        METRIC_TYPE_TEST_SUMMARY("TEST_SUMMARY"), // Tests general number
        METRIC_TYPE_TESTCASE("TESTCASE"), // Test case
        METRIC_TYPE_COVERAGE("COVERAGE"), // Coverage
        METRIC_TYPE_LINT("LINT"), // Code style lint, include lint and check
                                  // styles
        METRIC_TYPE_DEFECTS("DEFECTS"), // Bugs and Defects reported by rule
                                        // engine like findbugs
        METRIC_TYPE_CODEBASEINFO("CODEBASEINFO"), // Code base info, like line
                                                  // of code, lines of
                                                  // comments
        METRIC_TYPE_RUN_QUALITY("RUN_QUALITY"), // Running quality metric.
        METRIC_TYPE_ISSUE_FIX_ABILITY("ISSUE_FIX_ABILITY"), // issue fix ability.

        METRIC_TYPE_INVALID("INVALID");
        private String value;

        private MetricType(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        // since we overwrite toString(), this method is used to instead of
        // valueOf() method
        public static MetricType getValueOf(String value) {
            MetricType[] types = MetricType.values();
            for (MetricType type : types) {
                if (type.value.equalsIgnoreCase(value)) {
                    return type;
                }
            }
            // this exception is to match the static method valueOf().
            return METRIC_TYPE_INVALID;
        }
    }

    /**
     * The result of the metrics.
     * 
     * @author XQS
     */
    public enum MetricResult {
        METRIC_SUCCESS("success"), // Success
        METRIC_FAIL("fail"), // Fail
        METRIC_NOCHANGE("nochange"), // No change
        METRIC_NOCHECK("nocheck"), // Do not need to check, like lines of code,
                                   // no failure and success
        METRIC_INVALIDTHRESHOLD("invalidthreshold"), // The threshold value is
                                                     // incorrect
        METRIC_NOTRUN("notrun"), // The test case is not run
        METRIC_WARNING("warning"), // Warning
        METRIC_ERROR("error"), // Error in some report
        METRIC_INVALID("invalid"), // Invalid
        METRIC_NULL("null");

        private String value;

        private MetricResult(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static MetricResult getValueOf(String value) {
            MetricResult[] results = MetricResult.values();

            for (MetricResult result : results) {
                if (result.value.equalsIgnoreCase(value)) {
                    return result;
                }
            }

            return METRIC_INVALID;
        }
    }

    /**
     * 
     * Test frameworks.
     * 
     * @author XQS
     * 
     */
    public enum TestFramework {
        TEST_FRAMEWORK_TESTCOMPLETE("TESTCOMPLETE"), // testcomplete
        TEST_FRAMEWORK_JUNIT("JUNIT"), // junit
        TEST_FRAMEWORK_CPPUNIT("CPPUNIT"), // cppunit
        TEST_FRAMEWORK_VSTS("VSTS"), // VS test system
        TEST_FRAMEWORK_GTEST("GTEST"), // gtest
        TEST_FRAMEWORK_NUNIT("NUNIT"); // nunit

        private String value;

        private TestFramework(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    /**
     * The list of issue db.
     * 
     * @author XQS
     * 
     */
    public enum IssueDB {
        JIRA("JIRA"), ASSEMBLA("ASSEMBLA"), FOGBUGZ("FOGBUGZ");

        private String value;

        private IssueDB(String dbName) {
            this.value = dbName;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * The list of issue status. Note: this only includes the standard status
     * quality system required. So when we get issues from issue DB. we need
     * translate the status properly.
     * 
     * @author XQS
     * 
     */
    public enum IssueStatus {
        NOTIMPELEMNTED("NOTIMPELEMNTED"), // Not implemented
        IMPLEMENTED("IMPLEMENTED"), // Implemented, but not passed QA validation
        FIXED("FIXED"), // The issue is fixed(Closed).
        TRADEOFF("TRADEOFF"), // The issue is trade off.
        CANCELLED("CANCELLED"); // Ths issue is cancelled.

        private String value;

        private IssueStatus(String status) {
            this.value = status;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * The priority list of the issues. Note: these are defined priority for
     * quality system. the connectors need translate the priority properly.
     * 
     * @author XQS
     * 
     */
    public enum IssuePriority {
        HIGH("HIGH"), // Important
        NORMAL("NORMAL"), // Normal
        LOW("LOW"); // Low priority

        private String value;

        private IssuePriority(String priority) {
            this.value = priority;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * The list of issue type options.
     * 
     * @author XQS
     * 
     */
    public enum IssueType {
        BUG("BUG"), // bug
        FEATURE("FEATURE"), // new feature
        OTHER("OTHER"); // Other issue types

        private String value;

        private IssueType(String type) {
            this.value = type;
        }

        public String toString() {
            return this.value;
        }
    }

    /**
     * test run types.
     * 
     * @author XQS
     * 
     */
    public enum TestRunType {
        NORMAL("normal"), // normal
        STABLE_NIGHTLY("stable_nightly"), // stable nightly
        UNSTABLE_NIGHTLY("unstable_nightly"), // unstable nightly
        DEVELOPMENT("development"); // development

        private String value;

        private TestRunType(String type) {
            this.value = type;
        }

        public String toString() {
            return this.value;
        }

        public static TestRunType getValueOf(String type) {
            for (TestRunType runType : TestRunType.values()) {
                if (runType.toString().equals(type)) {
                    return runType;
                }
            }
            return null;
        }
    }

    /**
     * List of test run result values in testrail.
     * 
     * @author zm
     * 
     */
    public enum TCResult {
        /**
         * passed.
         */
        PASSED("passed"),
        /**
         * blocked.
         */
        BLOCKED("blocked"),
        /**
         * retest.
         */
        RETEST("retest"),
        /**
         * failed.
         */
        FAILED("failed"),
        /**
         * untested.
         */
        UNTESTED("untested");

        /**
         * the passed flag.
         */
        private static final int PASSED_FLAG = 1;

        /**
         * the blocked flag.
         */
        private static final int BLOCKED_FLAG = 2;

        /**
         * the retest flag.
         */
        private static final int RETEST_FLAG = 3;

        /**
         * the failed flag.
         */
        private static final int FAILED_FLAG = 4;

        /**
         * the untested flag.
         */
        private static final int UNTESTED_FLAG = 5;
        /**
         * the value.
         */
        private String value;

        /**
         * the constructor.
         * 
         * @param result
         *            the result.
         */
        private TCResult(final String result) {
            this.value = result;
        }

        /**
         * the string value.
         * 
         * @return the result.
         */
        public String toString() {
            return this.value;
        }

        /**
         * to get testcase result.
         * 
         * @param result
         *            the result.
         * @return a TCResult.
         */
        public static TCResult getTCResult(final int result) {
            switch (result) {
            case PASSED_FLAG:
                return PASSED;
            case BLOCKED_FLAG:
                return BLOCKED;
            case RETEST_FLAG:
                return RETEST;
            case FAILED_FLAG:
                return FAILED;
            case UNTESTED_FLAG:
                return UNTESTED;
            default:
                return null;
            }
        }
    }

    /**
     * the test case status.
     * 
     * @author zm.
     * 
     */
    public enum TCStatus {
        /**
         * drafted.
         */
        DRAFTED("drafted"),
        /**
         * defined.
         */
        DEFINED("defined"),
        /**
         * automated-planed.
         */
        AUTOMATED_PLANED("automated-planed"),
        /**
         * implemented.
         */
        IMPLEMENTED("implemented"),
        /**
         * stable.
         */
        STABLE("stable"),
        /**
         * outdated.
         */
        OUTDATED("outdated");

        /**
         * the drafted flag.
         */
        private static final int DRAFTED_FLAG = 1;

        /**
         * the defined flag.
         */
        private static final int DEFINED_FLAG = 2;

        /**
         * the automated-planed flag.
         */
        private static final int AUTOMATED_PLANED_FLAG = 3;

        /**
         * the implemented flag.
         */
        private static final int IMPLEMENTED_FLAG = 4;

        /**
         * the stable flag.
         */
        private static final int STABLE_FLAG = 5;

        /**
         * the outdated flag.
         */
        private static final int OUTDATED_FLAG = 6;

        /**
         * the value.
         */
        private String value;

        /**
         * the constructor.
         * 
         * @param result
         *            the result.
         */
        private TCStatus(final String status) {
            this.value = status;
        }

        /**
         * the string value.
         * 
         * @return the result.
         */
        public String toString() {
            return this.value;
        }

        /**
         * to get testcase result.
         * 
         * @param result
         *            the result.
         * @return a TCResult.
         */
        public static TCStatus getTCStatus(final int result) {
            switch (result) {
            case DRAFTED_FLAG:
                return DRAFTED;
            case DEFINED_FLAG:
                return DEFINED;
            case AUTOMATED_PLANED_FLAG:
                return AUTOMATED_PLANED;
            case IMPLEMENTED_FLAG:
                return IMPLEMENTED;
            case STABLE_FLAG:
                return STABLE;
            case OUTDATED_FLAG:
                return OUTDATED;
            default:
                return null;
            }
        }
    }

    /**
     * support ticket status.
     * 
     * @author Li.heping
     *
     */
    public enum SupportTicketStatus {
        NEW, WORKING, INVALID, FIXED;

        public boolean isCloseStatus() {
            if (this.compareTo(INVALID) < 0) {
                return false;
            }
            return true;
        }

        public static SupportTicketStatus getValueOf(String str) {
            for (SupportTicketStatus status : SupportTicketStatus.values()) {
                if (status.toString().equalsIgnoreCase(str)) {
                    return status;
                }
            }
            return null;
        }

        /**
         * get status which is in close.
         * 
         * @return
         */
        public static List<SupportTicketStatus> getClosedStatus() {
            List<SupportTicketStatus> statusList = new ArrayList<SupportTicketStatus>();
            statusList.add(INVALID);
            statusList.add(FIXED);
            return statusList;
        }

        /**
         * get status which is in open.
         * 
         * @return
         */
        public static List<SupportTicketStatus> getOpenStatus() {
            List<SupportTicketStatus> statusList = new ArrayList<SupportTicketStatus>();
            statusList.add(NEW);
            statusList.add(WORKING);
            return statusList;
        }

        /**
         * get status which indicate legal.
         * 
         * @return
         */
        public static List<SupportTicketStatus> getLegalStatus() {
            List<SupportTicketStatus> statusList = new ArrayList<SupportTicketStatus>();
            statusList.add(NEW);
            statusList.add(WORKING);
            statusList.add(FIXED);
            return statusList;
        }
    }
}
