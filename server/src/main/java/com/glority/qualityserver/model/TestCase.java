package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;

/**
 * TestCase model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "testcase", catalog = "qualitysystem")
@XmlRootElement
public class TestCase extends BaseObject implements Serializable {

    private static final long serialVersionUID = -3425462167244893850L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testsuite_id", nullable = false)
    private TestSuite testsuite;

    @Column(name = "svn_revision", length = 20)
    private String svnRevision;

    @Column(name = "svn_url", length = 20)
    private String svnUrl;

    @Column(name = "result", length = 20)
    private String result;

    @Column(name = "time")
    private float time;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + ((svnRevision == null) ? 0 : svnRevision.hashCode());
        result = prime * result + ((svnUrl == null) ? 0 : svnUrl.hashCode());
        result = prime * result + ((testsuite == null) ? 0 : testsuite.hashCode());
        result = prime * result + Float.floatToIntBits(time);
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
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
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
        if (testsuite == null) {
            if (other.testsuite != null) {
                return false;
            }
        } else if (!testsuite.equals(other.testsuite)) {
            return false;
        }
        if (Float.floatToIntBits(time) != Float.floatToIntBits(other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestCase [id=");
        builder.append(id);
        builder.append(", testsuite=");
        builder.append(testsuite);
        builder.append(", svnRevision=");
        builder.append(svnRevision);
        builder.append(", svnUrl=");
        builder.append(svnUrl);
        builder.append(", result=");
        builder.append(result);
        builder.append(", time=");
        builder.append(time);
        builder.append(", name=");
        builder.append(name);
        builder.append(", createdAt=");
        builder.append(createdAt);
        builder.append("]");
        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestSuite getTestsuite() {
        return testsuite;
    }

    public void setTestsuite(TestSuite testsuite) {
        this.testsuite = testsuite;
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

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
