package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TestSuite model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "testsuite", catalog = "qualitysystem")
@XmlRootElement
public class TestSuite extends BaseObject implements Serializable {

    private static final long serialVersionUID = 7681900382375815353L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "build_id", nullable = false)
    private Build builds;

    @Column(name = "configuration_id")
    private Long configurationId;

    @Column(name = "test_id")
    private Long testId;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "testsuite")
    private Set<TestCase> testcases = new HashSet<TestCase>(0);

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("builds", builds)
                .append("configurationId", configurationId).append("testId", testId).append("type", type)
                .append("createdAt", createdAt).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestSuite)) {
            return false;
        }
        TestSuite castOther = (TestSuite) other;
        return new EqualsBuilder().append(id, castOther.id).append(builds, castOther.builds)
                .append(configurationId, castOther.configurationId).append(testId, castOther.testId)
                .append(type, castOther.type).append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(builds).append(configurationId).append(testId).append(type)
                .append(createdAt).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Build getBuilds() {
        return builds;
    }

    public void setBuilds(Build builds) {
        this.builds = builds;
    }

    public Long getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Long configurationId) {
        this.configurationId = configurationId;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TestCase> getTestcases() {
        return testcases;
    }

    public void setTestcases(Set<TestCase> testcases) {
        this.testcases = testcases;
    }
}
