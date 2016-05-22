package com.glority.qualityserver;

/**
 * String constants class.
 */
public final class Constants {
    /**
     * default constructor.
     */
    private Constants() {
    }

    public static final String QUALITY_SERVER_PROPERTY_FILE = "qualityserver.properties";

    public static final String NO_DATA = "N/A";

    public static final String RUNNING = "running";
    public static final String FAIL = "fail";
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String TIME_OUT = "timeout";

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_FORMAT_MDY_HMS = "MM-dd-yyy HH:mm:ss";

    public static final String WARNING = "warning";
    public static final String NOTRUN = "notrun";

    public static final String USER = "user";

    public static final String RESULT = "result";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String DEPLOY_TYPE_HOT = "hot";
    public static final String DEPLOY_TYPE_BASE = "base";

    public static final String SERVER_TYPE_PREVIEW = "preview";
    public static final String SERVER_TYPE_OFFICIAL = "official";

    public static final String SERVER_URL = "serverUrl";
    /**
     * to hold product svn log.
     */
    public static final String SVN_LOG_FOLDER = "product_svn_log";

    public static final int PAGE_SIZE = 50;
    public static final int DEFAULT_PAGE = 1;

    public static final int PASSING_SCORE = 60;
    public static final int EXCELLENT_SCORE = 85;
}
