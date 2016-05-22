package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Alert model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "alert", catalog = "qualitysystem")
@XmlRootElement
public class Alert {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "server_id")
    private Long serverId;

    @Column(name = "type")
    private String type;

    @Column(name = "info")
    private String info;

    @Column(name = "start_time", length = 19)
    private Timestamp startTime;

    @Column(name = "end_Time", length = 19)
    private Timestamp endTime;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Alert)) {
            return false;
        }
        Alert castOther = (Alert) other;
        return new EqualsBuilder().append(id, castOther.id).append(productId, castOther.productId)
                .append(serverId, castOther.serverId).append(type, castOther.type).append(info, castOther.info)
                .append(startTime, castOther.startTime).append(endTime, castOther.endTime)
                .append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(productId).append(serverId).append(type).append(info)
                .append(startTime).append(endTime).append(createdAt).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("productId", productId).append("serverId", serverId)
                .append("type", type).append("info", info).append("startTime", startTime).append("endTime", endTime)
                .append("createdAt", createdAt).toString();
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

}
