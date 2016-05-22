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
 * Failure model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "failures", catalog = "qualitysystem")
@XmlRootElement
public class Failure extends BaseObject implements Serializable {

    private static final long serialVersionUID = 5423227377329604066L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metric_id", nullable = false)
    private BuildMetric metrics;

    @Column(name = "detail", length = 200)
    private String detail;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("metrics", metrics)
                .append("detail", detail).append("createdAt", createdAt).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Failure)) {
            return false;
        }
        Failure castOther = (Failure) other;
        return new EqualsBuilder().append(id, castOther.id).append(metrics, castOther.metrics)
                .append(detail, castOther.detail).append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(metrics).append(detail).append(createdAt).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildMetric getMetrics() {
        return metrics;
    }

    public void setMetrics(BuildMetric metrics) {
        this.metrics = metrics;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
