package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Quality Engine Failure class.
 */
@Entity
@Table(name = "quality_engine_failures", catalog = "qualitysystem")
@XmlRootElement
public class QualityEngineFailure extends BaseObject implements Serializable {

    private static final long serialVersionUID = 6299909486343150795L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "task", length = 100)
    private String taskClassName;

    @Column(name = "owner", length = 100)
    private String owner;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "failurestacktrace")
    private String stackTrace;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id)
                .append("taskClassName", taskClassName).append("owner", owner).append("createdAt", createdAt)
                .append("stackTrace", stackTrace).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QualityEngineFailure)) {
            return false;
        }
        QualityEngineFailure castOther = (QualityEngineFailure) other;
        return new EqualsBuilder().append(id, castOther.id).append(taskClassName, castOther.taskClassName)
                .append(owner, castOther.owner).append(createdAt, castOther.createdAt)
                .append(stackTrace, castOther.stackTrace).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(taskClassName).append(owner).append(createdAt)
                .append(stackTrace).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskClassName() {
        return taskClassName;
    }

    public void setTaskClassName(String taskClassName) {
        this.taskClassName = taskClassName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

}
