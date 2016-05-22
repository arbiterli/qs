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
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Test Model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "tests", catalog = "qualitysystem")
@XmlRootElement
public class Test extends BaseObject implements Serializable {

    private static final long serialVersionUID = 5998077886986084691L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testgroup_id", nullable = false)
    private TestGroup testgroup;

    @Column(name = "build_id", nullable = false)
    private Long buildId;

    @Column(name = "jenkins_jobname", length = 50)
    private String jenkinsJobname;

    @Column(name = "jenkins_buildid")
    private Long jenkinsBuildid;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "configuration_id")
    private Long configurationId;

    @Column(name = "result", length = 20)
    private String result;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("testgroup", testgroup)
                .append("buildId", buildId).append("jenkinsJobname", jenkinsJobname)
                .append("jenkinsBuildid", jenkinsBuildid).append("status", status).append("duration", duration)
                .append("configurationId", configurationId).append("result", result).append("createdAt", createdAt)
                .toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Test)) {
            return false;
        }
        Test castOther = (Test) other;
        return new EqualsBuilder().append(id, castOther.id).append(testgroup, castOther.testgroup)
                .append(buildId, castOther.buildId).append(jenkinsJobname, castOther.jenkinsJobname)
                .append(jenkinsBuildid, castOther.jenkinsBuildid).append(status, castOther.status)
                .append(duration, castOther.duration).append(configurationId, castOther.configurationId)
                .append(result, castOther.result).append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(testgroup).append(buildId).append(jenkinsJobname)
                .append(jenkinsBuildid).append(status).append(duration).append(configurationId).append(result)
                .append(createdAt).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestGroup getTestgroup() {
        return testgroup;
    }

    public void setTestgroup(TestGroup testgroup) {
        this.testgroup = testgroup;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public String getJenkinsJobname() {
        return jenkinsJobname;
    }

    public void setJenkinsJobname(String jenkinsJobname) {
        this.jenkinsJobname = jenkinsJobname;
    }

    public Long getJenkinsBuildid() {
        return jenkinsBuildid;
    }

    public void setJenkinsBuildid(Long jenkinsBuildid) {
        this.jenkinsBuildid = jenkinsBuildid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Long configurationId) {
        this.configurationId = configurationId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
