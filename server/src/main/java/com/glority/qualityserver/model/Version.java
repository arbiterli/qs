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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * Version model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "version", catalog = "qualitysystem")
@XmlRootElement
@DataTransferObject
public class Version extends BaseObject implements Serializable {

    private static final long serialVersionUID = -1144622659722494117L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "version", nullable = false, length = 20)
    @RemoteProperty
    private String version;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "dev_start_time", length = 19)
    private Timestamp devStartTime;

    @Column(name = "dev_end_time", length = 19)
    private Timestamp devEndTime;

    @Column(name = "test_start_time", length = 19)
    private Timestamp testStartTime;

    @Column(name = "test_end_time", length = 19)

    private Timestamp testEndTime;

    @Column(name = "stage_start_time", length = 19)
    private Timestamp stageStartTime;

    @Column(name = "stage_end_time", length = 19)

    private Timestamp stageEndTime;

    @Column(name = "production_start_time", length = 19)

    private Timestamp productionStartTime;

    @Column(name = "production_end_time", length = 19)

    private Timestamp productionEndTime;
    @Column(name = "svn_url", length = 250)

    private String svnUrl;

    @Column(name = "svn_revision", length = 250)
    private String svnRevision;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "version")
    private Set<Build> buildses = new HashSet<Build>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "version")
    private Set<Configuration> configurationses = new HashSet<Configuration>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "version")
    private Set<IssueRecord> issues = new HashSet<IssueRecord>(0);

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("version", version)
                .append("productId", productId).append("devStartTime", devStartTime).append("devEndTime", devEndTime)
                .append("testStartTime", testStartTime).append("testEndTime", testEndTime)
                .append("stageStartTime", stageStartTime).append("stageEndTime", stageEndTime)
                .append("productionStartTime", productionStartTime).append("productionEndTime", productionEndTime)
                .append("svnUrl", svnUrl).append("svnRevision", svnRevision).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Version)) {
            return false;
        }
        Version castOther = (Version) other;
        return new EqualsBuilder().append(id, castOther.id).append(version, castOther.version)
                .append(productId, castOther.productId).append(devStartTime, castOther.devStartTime)
                .append(devEndTime, castOther.devEndTime).append(testStartTime, castOther.testStartTime)
                .append(testEndTime, castOther.testEndTime).append(stageStartTime, castOther.stageStartTime)
                .append(stageEndTime, castOther.stageEndTime)
                .append(productionStartTime, castOther.productionStartTime)
                .append(productionEndTime, castOther.productionEndTime).append(svnUrl, castOther.svnUrl)
                .append(svnRevision, castOther.svnRevision).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(version).append(productId).append(devStartTime)
                .append(devEndTime).append(testStartTime).append(testEndTime).append(stageStartTime)
                .append(stageEndTime).append(productionStartTime).append(productionEndTime).append(svnUrl)
                .append(svnRevision).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Timestamp getDevStartTime() {
        return devStartTime;
    }

    public void setDevStartTime(Timestamp devStartTime) {
        this.devStartTime = devStartTime;
    }

    public Timestamp getDevEndTime() {
        return devEndTime;
    }

    public void setDevEndTime(Timestamp devEndTime) {
        this.devEndTime = devEndTime;
    }

    public Timestamp getTestStartTime() {
        return testStartTime;
    }

    public void setTestStartTime(Timestamp testStartTime) {
        this.testStartTime = testStartTime;
    }

    public Timestamp getTestEndTime() {
        return testEndTime;
    }

    public void setTestEndTime(Timestamp testEndTime) {
        this.testEndTime = testEndTime;
    }

    public Timestamp getStageStartTime() {
        return stageStartTime;
    }

    public void setStageStartTime(Timestamp stageStartTime) {
        this.stageStartTime = stageStartTime;
    }

    public Timestamp getStageEndTime() {
        return stageEndTime;
    }

    public void setStageEndTime(Timestamp stageEndTime) {
        this.stageEndTime = stageEndTime;
    }

    public Timestamp getProductionStartTime() {
        return productionStartTime;
    }

    public void setProductionStartTime(Timestamp productionStartTime) {
        this.productionStartTime = productionStartTime;
    }

    public Timestamp getProductionEndTime() {
        return productionEndTime;
    }

    public void setProductionEndTime(Timestamp productionEndTime) {
        this.productionEndTime = productionEndTime;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getSvnRevision() {
        return svnRevision;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }

    public Set<Build> getBuildses() {
        return buildses;
    }

    public void setBuildses(Set<Build> buildses) {
        this.buildses = buildses;
    }

    public Set<Configuration> getConfigurationses() {
        return configurationses;
    }

    public void setConfigurationses(Set<Configuration> configurationses) {
        this.configurationses = configurationses;
    }

    public Set<IssueRecord> getIssues() {
        return issues;
    }

    public void setIssues(Set<IssueRecord> issues) {
        this.issues = issues;
    }

}
