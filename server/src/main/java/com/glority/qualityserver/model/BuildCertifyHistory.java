package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * BuildCertifyHistory model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "build_certify_history", catalog = "qualitysystem")
@XmlRootElement
public class BuildCertifyHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_id", nullable = false)
    private Build build;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phase_id", nullable = false)
    private Phase phase;

    @Column(name = "certified_at")
    private Timestamp certifiedAt;

    @Column(name = "certified_by")
    private String certifiedBy;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("build", build)
                .append("phase", phase).append("certifiedAt", certifiedAt).append("certifiedBy", certifiedBy)
                .toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuildCertifyHistory)) {
            return false;
        }
        BuildCertifyHistory castOther = (BuildCertifyHistory) other;
        return new EqualsBuilder().append(id, castOther.id).append(build, castOther.build)
                .append(phase, castOther.phase).append(certifiedAt, castOther.certifiedAt)
                .append(certifiedBy, castOther.certifiedBy).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(build).append(phase).append(certifiedAt).append(certifiedBy)
                .toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Timestamp getCertifiedAt() {
        return certifiedAt;
    }

    public void setCertifiedAt(Timestamp certifiedAt) {
        this.certifiedAt = certifiedAt;
    }

    public String getCertifiedBy() {
        return certifiedBy;
    }

    public void setCertifiedBy(String certifiedBy) {
        this.certifiedBy = certifiedBy;
    }

}
