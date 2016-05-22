package com.glority.qualityserver.web.model;

/**
 * Map keys for deploy.
 * 
 * @author liheping
 * 
 */
public final class DeployMapKeys {
    private DeployMapKeys() {

    }
    // private String version;
    // private String createTime;
    // private String deployTime;
    // private String user;
    // private String buildId;
    // private String phaseId;
    // private boolean active;

    public static final String VERSION = "version";
    public static final String CREATE_TIME = "createTime";
    public static final String DEPLOY_TIME = "deployTime";
    public static final String DEPLOYED_BY = "user";
    public static final String BUILD_ID = "buildId";
    public static final String PHASE_ID = "phaseId";
    public static final String ACTIVE = "active";
    public static final String SVN_REVISION = "svnRevision";
}
