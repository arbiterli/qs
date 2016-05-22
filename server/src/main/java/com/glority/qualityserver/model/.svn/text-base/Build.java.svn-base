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

import com.glority.quality.StringUtil;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * Build model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "builds", catalog = "qualitysystem")
@XmlRootElement
@DataTransferObject
public class Build extends BaseObject implements Serializable {

    private static final long serialVersionUID = -6014192257992777752L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @RemoteProperty
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", nullable = false)
    @RemoteProperty
    private Version version;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "jenkins_jobname", length = 50)
    private String jenkinsJobname;

    @Column(name = "jenkins_buildeid")
    @RemoteProperty
    private Long jenkinsBuildId;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "result", length = 20)
    private String result;

    @Column(name = "svn_url", length = 255)
    private String svnUrl;

    @Column(name = "svn_revision", length = 255)
    private String svnRevision;

    @Column(name = "certification", length = 45)
    private String certification;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "builds")
    private Set<BuildMetric> metricses = new HashSet<BuildMetric>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "builds")
    private Set<TestGroup> testgroupses = new HashSet<TestGroup>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "builds")
    private Set<TestSuite> testsuites = new HashSet<TestSuite>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "build")
    private Set<BuildCertifyHistory> buildCertifyHistories = new HashSet<BuildCertifyHistory>(0);

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Build)) {
            return false;
        }
        Build castOther = (Build) other;
        return new EqualsBuilder().append(id, castOther.id).append(version, castOther.version)
                .append(product, castOther.product).append(jenkinsJobname, castOther.jenkinsJobname)
                .append(jenkinsBuildId, castOther.jenkinsBuildId).append(status, castOther.status)
                .append(duration, castOther.duration).append(result, castOther.result).append(svnUrl, castOther.svnUrl)
                .append(svnRevision, castOther.svnRevision).append(certification, castOther.certification)
                .append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(version).append(product).append(jenkinsJobname)
                .append(jenkinsBuildId).append(status).append(duration).append(result).append(svnUrl)
                .append(svnRevision).append(certification).append(createdAt).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("version", version)
                .append("products", product).append("jenkinsJobname", jenkinsJobname)
                .append("jenkinsBuildeid", jenkinsBuildId).append("status", status).append("duration", duration)
                .append("result", result).append("svnUrl", svnUrl).append("svnRevision", svnRevision)
                .append("certification", certification).append("createdAt", createdAt).toString();
    }

    /**
     * Return true is the build meet quality system requirement. A valid build should: 1. has a valid product 2. has
     * jenkinsBuildid and svn revision
     * 
     * @return
     */
    public boolean isValid() {
        if (StringUtil.isEmpty(this.svnRevision)) {
            return false;
        }

        if (this.jenkinsBuildId == null) {
            return false;
        }

        if (product == null) {
            return false;
        }

        if (!product.isValid()) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getJenkinsJobname() {
        return jenkinsJobname;
    }

    public void setJenkinsJobname(String jenkinsJobname) {
        this.jenkinsJobname = jenkinsJobname;
    }

    public Long getJenkinsBuildId() {
        return jenkinsBuildId;
    }

    public void setJenkinsBuildId(Long jenkinsBuildId) {
        this.jenkinsBuildId = jenkinsBuildId;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<BuildMetric> getMetricses() {
        return metricses;
    }

    public void setMetricses(Set<BuildMetric> metricses) {
        this.metricses = metricses;
    }

    public Set<TestGroup> getTestgroupses() {
        return testgroupses;
    }

    public void setTestgroupses(Set<TestGroup> testgroupses) {
        this.testgroupses = testgroupses;
    }

    public Set<TestSuite> getTestsuites() {
        return testsuites;
    }

    public void setTestsuites(Set<TestSuite> testsuites) {
        this.testsuites = testsuites;
    }

    public Set<BuildCertifyHistory> getBuildCertifyHistories() {
        return buildCertifyHistories;
    }

    public void setBuildCertifyHistories(Set<BuildCertifyHistory> buildCertifyHistories) {
        this.buildCertifyHistories = buildCertifyHistories;
    }

}
