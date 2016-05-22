package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Phase model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "phase", catalog = "qualitysystem")
@XmlRootElement
public class Phase {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "deploy_build")
    private Long deployBuild;

    @Column(name = "deploy_time")
    private Timestamp deployTime;

    @Column(name = "default_build")
    private Long defaultBuild;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "phase")
    private Set<BuildCertifyHistory> buildCertifyHistories = new HashSet<BuildCertifyHistory>(0);

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("productId", productId)
                .append("type", type).append("deployBuild", deployBuild).append("deployTime", deployTime)
                .append("defaultBuild", defaultBuild).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Phase)) {
            return false;
        }
        Phase castOther = (Phase) other;
        return new EqualsBuilder().append(id, castOther.id).append(productId, castOther.productId)
                .append(type, castOther.type).append(deployBuild, castOther.deployBuild)
                .append(deployTime, castOther.deployTime).append(defaultBuild, castOther.defaultBuild).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(productId).append(type).append(deployBuild).append(deployTime)
                .append(defaultBuild).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDeployBuild() {
        return deployBuild;
    }

    public void setDeployBuild(Long deployBuild) {
        this.deployBuild = deployBuild;
    }

    public Timestamp getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Timestamp deployTime) {
        this.deployTime = deployTime;
    }

    public Long getDefaultBuild() {
        return defaultBuild;
    }

    public void setDefaultBuild(Long defaultBuild) {
        this.defaultBuild = defaultBuild;
    }

    public Set<BuildCertifyHistory> getBuildCertifyHistories() {
        return buildCertifyHistories;
    }

    public void setBuildCertifyHistories(Set<BuildCertifyHistory> buildCertifyHistories) {
        this.buildCertifyHistories = buildCertifyHistories;
    }
}
