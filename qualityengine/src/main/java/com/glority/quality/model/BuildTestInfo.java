package com.glority.quality.model;
/**
 * BuildTestInfoModel.
 * @author liheping
 *
 */
public class BuildTestInfo {
    private String certification;
    private String timestamp;
    private Build build;
    private TestGroup testgroup;

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public TestGroup getTestgroup() {
        return testgroup;
    }

    public void setTestgroup(TestGroup testgroup) {
        this.testgroup = testgroup;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BuildTestInfo [certification=");
        builder.append(certification);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append(", build=");
        builder.append(build);
        builder.append(", testgroup=");
        builder.append(testgroup);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((build == null) ? 0 : build.hashCode());
        result = prime * result + ((certification == null) ? 0 : certification.hashCode());
        result = prime * result + ((testgroup == null) ? 0 : testgroup.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BuildTestInfo)) {
            return false;
        }
        BuildTestInfo other = (BuildTestInfo) obj;
        if (build == null) {
            if (other.build != null) {
                return false;
            }
        } else if (!build.equals(other.build)) {
            return false;
        }
        if (certification == null) {
            if (other.certification != null) {
                return false;
            }
        } else if (!certification.equals(other.certification)) {
            return false;
        }
        if (testgroup == null) {
            if (other.testgroup != null) {
                return false;
            }
        } else if (!testgroup.equals(other.testgroup)) {
            return false;
        }
        if (timestamp == null) {
            if (other.timestamp != null) {
                return false;
            }
        } else if (!timestamp.equals(other.timestamp)) {
            return false;
        }
        return true;
    }

}
