package com.glority.quality.model;

import com.glority.quality.Constants.IssuePriority;
import com.glority.quality.Constants.IssueStatus;
import com.glority.quality.Constants.IssueType;

/**
 * The quality system model represents a issue in the issue DB.
 * 
 * @author XQS.
 * 
 */
public class Issue {
    private String id;
    private String title;
    private IssueStatus status;
    private IssuePriority priority;
    private IssueType type;
    private String version;
    private String testCases;

    public String getId() {
        return id;
    }

    public String getTestCases() {
        return testCases;
    }

    public void setTestCases(String testCases) {
        this.testCases = testCases;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((testCases == null) ? 0 : testCases.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
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
        if (!(obj instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (priority != other.priority) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (testCases == null) {
            if (other.testCases != null) {
                return false;
            }
        } else if (!testCases.equals(other.testCases)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        if (version == null) {
            if (other.version != null) {
                return false;
            }
        } else if (!version.equals(other.version)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Issue [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", status=");
        builder.append(status);
        builder.append(", priority=");
        builder.append(priority);
        builder.append(", type=");
        builder.append(type);
        builder.append(", version=");
        builder.append(version);
        builder.append(", testCases=");
        builder.append(testCases);
        builder.append("]");
        return builder.toString();
    }

}
