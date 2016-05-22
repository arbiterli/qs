package com.glority.qualityserver.web.model;

/**
 * this class contains all keys used in build info map.
 * 
 * @author liheping
 * 
 */
public final class BuildInfoMapKeys {
    private BuildInfoMapKeys() {
    }

    // detail
    // private long id;
    // private String name;
    // private String stage;
    // private String version;
    // private String buildTime;
    // private String linesOfCode;
    // private String linesOfComments;
    // private String testEnvironments;
    // private String tests;
    // private String failedTest;
    // private String certification;
    /**
     * build id in quality system db.
     */
    public static final String ID = "id";
    /**
     * jenkins build name.
     */
    public static final String JENKINS_BUILD_NAME = "jenkinsBuildName";
    /**
     * jenkins build id.
     */
    public static final String JENKINS_BUILD_ID = "jenkinsBuildId";
    /**
     * build's version.
     */
    public static final String VERSION = "version";
    /**
     * build's build time. it is the build created time in quality system db.
     */
    public static final String BUILD_TIME = "buildTime";
    /**
     * lines of code in build.
     */
    public static final String LINES_OF_CODE = "linesOfCode";
    /**
     * lines of comment in build.
     */
    public static final String LINES_OF_COMMENT = "linesOfComment";
    /**
     * test number for build.
     */
    public static final String TEST_NUMBER = "testNumber";
    /**
     * test environments for build.
     */
    public static final String TEST_ENVIRONMENTS = "testEnvironments";
    /**
     * failed test case number.
     */
    public static final String FAILED_TEST_NUMBER = "failedTestNumber";
    /**
     * certification for build.
     */
    public static final String CERTIFICATION = "certification";
    /**
     * svn url
     */
    public static final String SVN_URL = "svnUrl";
    /**
     * svn version
     */
    public static final String SVN_VERSION = "svnVersion";
    // info
    // private long buildNumber;
    // private String time;
    // private String verion;
    // private String environments;
    // private String tests;
    // private String failedTest;
    // private String certification;

}
