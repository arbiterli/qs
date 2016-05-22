package com.glority.quality.model;

import com.glority.quality.Constants.TCStatus;
/**
 * Test Case model.
 * @author liheping
 *
 */
public class TestCase {
    private String id;
    private String name;
    private String time;
    private String svnRevision;
    private String svnUrl;
    private String result;
    private String dependency;
    private TCStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TCStatus getStatus() {
        return status;
    }

    public void setStatus(TCStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSvnRevision() {
        return svnRevision;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestCase [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", time=");
        builder.append(time);
        builder.append(", svnRevision=");
        builder.append(svnRevision);
        builder.append(", svnUrl=");
        builder.append(svnUrl);
        builder.append(", result=");
        builder.append(result);
        builder.append(", dependency=");
        builder.append(dependency);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dependency == null) ? 0 : dependency.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((svnRevision == null) ? 0 : svnRevision.hashCode());
        result = prime * result + ((svnUrl == null) ? 0 : svnUrl.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        if (!(obj instanceof TestCase)) {
            return false;
        }
        TestCase other = (TestCase) obj;
        if (dependency == null) {
            if (other.dependency != null) {
                return false;
            }
        } else if (!dependency.equals(other.dependency)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (result == null) {
            if (other.result != null) {
                return false;
            }
        } else if (!result.equals(other.result)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (svnRevision == null) {
            if (other.svnRevision != null) {
                return false;
            }
        } else if (!svnRevision.equals(other.svnRevision)) {
            return false;
        }
        if (svnUrl == null) {
            if (other.svnUrl != null) {
                return false;
            }
        } else if (!svnUrl.equals(other.svnUrl)) {
            return false;
        }
        if (time == null) {
            if (other.time != null) {
                return false;
            }
        } else if (!time.equals(other.time)) {
            return false;
        }
        return true;
    }
}
