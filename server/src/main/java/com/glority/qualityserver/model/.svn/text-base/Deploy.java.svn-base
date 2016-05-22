package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Deploy model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "deploy", catalog = "qualitysystem")
@XmlRootElement
public class Deploy {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "version")
    private String version;

    @Column(name = "build_id")
    private Long buildId;

    @Column(name = "phase_id")
    private Long phaseId;

    @Column(name = "svn_revision")
    private Long svnRevision;

    @Column(name = "preview_deploy_time")
    private Timestamp previewDeployTime;

    @Column(name = "prod_deploy_time")
    private Timestamp productionDeployTime;

    @Column(name = "deploy_user")
    private String deployUser;

    @Column(name = "type")
    private String type;

    @Column(name = "result")
    private String result;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "log")
    private String log;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("version", version)
                .append("buildId", buildId).append("phaseId", phaseId).append("previewDeployTime", previewDeployTime)
                .append("productionDeployTime", productionDeployTime).append("deployUser", deployUser)
                .append("type", type).append("result", result).append("createTime", createTime).append("log", log)
                .append("svnRevision", svnRevision).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Deploy)) {
            return false;
        }
        Deploy castOther = (Deploy) other;
        return new EqualsBuilder().append(id, castOther.id).append(version, castOther.version)
                .append(buildId, castOther.buildId).append(phaseId, castOther.phaseId)
                .append(previewDeployTime, castOther.previewDeployTime)
                .append(productionDeployTime, castOther.productionDeployTime).append(deployUser, castOther.deployUser)
                .append(type, castOther.type).append(result, castOther.result).append(createTime, castOther.createTime)
                .append(log, castOther.log).append(log, castOther.svnRevision).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(version).append(buildId).append(phaseId)
                .append(previewDeployTime).append(productionDeployTime).append(deployUser).append(type).append(result)
                .append(createTime).append(log).append(svnRevision).toHashCode();
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

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = phaseId;
    }

    public Timestamp getPreviewDeployTime() {
        return previewDeployTime;
    }

    public void setPreviewDeployTime(Timestamp previewDeployTime) {
        this.previewDeployTime = previewDeployTime;
    }

    public Timestamp getProductionDeployTime() {
        return productionDeployTime;
    }

    public void setProductionDeployTime(Timestamp productionDeployTime) {
        this.productionDeployTime = productionDeployTime;
    }

    public String getDeployUser() {
        return deployUser;
    }

    public void setDeployUser(String deployUser) {
        this.deployUser = deployUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getSvnRevision() {
        return svnRevision;
    }

    public void setSvnRevision(Long svnRevision) {
        this.svnRevision = svnRevision;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
