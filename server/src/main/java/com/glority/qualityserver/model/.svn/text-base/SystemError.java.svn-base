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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * system error model.
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "system_error", catalog = "qualitysystem")
@XmlRootElement
public class SystemError implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "error_from")
    private String from;

    @Column(name = "info")
    private String info;

    @Column(name = "extern_info")
    private String externInfo;

    @Column(name = "owner")
    private String owner;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "SystemError [id=" + id + ", from=" + from + ", info=" + info + ", externInfo=" + externInfo
                + ", owner=" + owner + ", status=" + status + ", createTime=" + createTime + ", updateTime="
                + updateTime + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getExternInfo() {
        return externInfo;
    }

    public void setExternInfo(String externInfo) {
        this.externInfo = externInfo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestGroup)) {
            return false;
        }
        SystemError castOther = (SystemError) other;
        return new EqualsBuilder().append(id, castOther.id).append(from, castOther.from)
                .append(info, castOther.info).append(status, castOther.status).append(createTime, castOther.createTime)
                .append(updateTime, castOther.updateTime).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(from).append(info).append(status).append(createTime)
                .append(updateTime).toHashCode();
    }
}
