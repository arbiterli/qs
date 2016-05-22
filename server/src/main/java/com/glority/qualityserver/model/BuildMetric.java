package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;
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
 * BuildMetric Model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "build_metric", catalog = "qualitysystem")
@XmlRootElement
public class BuildMetric extends BaseObject implements Serializable {

    private static final long serialVersionUID = 5545432865584791499L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_id", nullable = false)
    private Build builds;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "oldvalue", length = 50)
    private String oldValue;

    @Column(name = "newvalue", length = 50)
    private String newValue;

    @Column(name = "result", length = 50)
    private String result;

    @Column(name = "failurecount")
    private Long failureCount;

    @Column(name = "time", length = 8)
    private Date time;

    @Column(name = "test_id")
    private Long testId;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Column(name = "product_id", length = 11)
    private long produtId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "metrics")
    private Set<Failure> failureses = new HashSet<Failure>(0);

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("builds", builds)
                .append("type", type).append("name", name).append("oldValue", oldValue).append("newValue", newValue)
                .append("result", result).append("failureCount", failureCount).append("time", time)
                .append("testId", testId).append("createdAt", createdAt).append("produtId", produtId).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuildMetric)) {
            return false;
        }
        BuildMetric castOther = (BuildMetric) other;
        return new EqualsBuilder().append(id, castOther.id).append(builds, castOther.builds)
                .append(type, castOther.type).append(name, castOther.name).append(oldValue, castOther.oldValue)
                .append(newValue, castOther.newValue).append(result, castOther.result)
                .append(failureCount, castOther.failureCount).append(time, castOther.time)
                .append(testId, castOther.testId).append(createdAt, castOther.createdAt)
                .append(produtId, castOther.produtId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(builds).append(type).append(name).append(oldValue)
                .append(newValue).append(result).append(failureCount).append(time).append(testId).append(createdAt)
                .append(produtId).toHashCode();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(Long failureCount) {
        this.failureCount = failureCount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public long getProdutId() {
        return produtId;
    }

    public void setProdutId(long produtId) {
        this.produtId = produtId;
    }

    public Set<Failure> getFailureses() {
        return failureses;
    }

    public void setFailureses(Set<Failure> failureses) {
        this.failureses = failureses;
    }
}
