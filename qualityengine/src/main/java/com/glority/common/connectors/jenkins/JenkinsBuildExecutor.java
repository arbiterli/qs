package com.glority.common.connectors.jenkins;

/**
 * BuildExecutor. this model is used to store the data which parsed from the xml
 * which is got from jenkins build exuctor api. right now, only the offline
 * attribute is used. so,just this attribute and computer display name is here.
 * 
 * @author li.heping
 * 
 */
public class JenkinsBuildExecutor {
    /**
     * the executor display name.
     */
    private String displayName;
    /**
     * the status of the executor for offline.
     */
    private boolean offline;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    @Override
    public String toString() {
        return "BuildExecutor [displayName=" + displayName + ", offline=" + offline + "]";
    }

}
