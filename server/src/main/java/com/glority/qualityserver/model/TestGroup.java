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
 * TestGroup Model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "testgroups", catalog = "qualitysystem")
@XmlRootElement
public class TestGroup extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1899316338752811636L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_id", nullable = false)
    private Build builds;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "testgroup")
    private Set<Test> testses = new HashSet<Test>(0);

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("builds", builds)
                .append("name", name).append("status", status).append("productId", productId)
                .append("duration", duration).append("createdAt", createdAt).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestGroup)) {
            return false;
        }
        TestGroup castOther = (TestGroup) other;
        return new EqualsBuilder().append(id, castOther.id).append(builds, castOther.builds)
                .append(name, castOther.name).append(status, castOther.status).append(productId, castOther.productId)
                .append(duration, castOther.duration).append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(builds).append(name).append(status).append(productId)
                .append(duration).append(createdAt).toHashCode();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Test> getTestses() {
        return testses;
    }

    public void setTestses(Set<Test> testses) {
        this.testses = testses;
    }
}
