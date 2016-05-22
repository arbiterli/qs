package com.glority.common.connectors.jenkins;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * the build module.
 * 
 * @author zm
 * 
 */
public class JenkinsBuild {
    private int number;
    private String url;
    private BuildResult result;
    /**
     * estimated time for build. unit ms.
     */
    private Long estimated;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BuildResult getResult() {
        return result;
    }

    public void setResult(BuildResult result) {
        this.result = result;
    }

    public Long getEstimated() {
        return estimated;
    }

    public void setEstimated(Long estimated) {
        this.estimated = estimated;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof JenkinsBuild) {
            JenkinsBuild otherBuild = (JenkinsBuild) other;
            return new EqualsBuilder().append(url, otherBuild.url).append(result, otherBuild.result)
                    .append(number, otherBuild.number).append(estimated, otherBuild.estimated).isEquals();
        }
        return false;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(url).append(result).append(number).append(estimated).hashCode();
    }

    /**
     * jenkins build result enum.
     * 
     * @author li.heping
     * 
     */
    public static enum BuildResult {
        ABORTED, FAILURE, UNSTABLE, SUCCESS;
    }
}
