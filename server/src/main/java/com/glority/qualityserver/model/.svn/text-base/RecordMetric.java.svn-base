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
 * RecordMetric model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "record_metric", catalog = "qualitysystem")
@XmlRootElement
public class RecordMetric {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "oldvalue")
    private String oldValue;

    @Column(name = "newvalue")
    private String newValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "build_id")
    private Long buildId;

    @Column(name = "sample_time")
    private Timestamp sampleTime;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "extern_info")
    private String externInfo;

    @Column(name = "server_id")
    private Long serverId;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("type", type)
                .append("name", name).append("oldValue", oldValue).append("newValue", newValue)
                .append("product", product).append("buildId", buildId).append("sampleTime", sampleTime)
                .append("createTime", createTime).append("externInfo", externInfo).append("serverId", serverId)
                .toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordMetric)) {
            return false;
        }
        RecordMetric castOther = (RecordMetric) other;
        return new EqualsBuilder().append(id, castOther.id).append(type, castOther.type).append(name, castOther.name)
                .append(oldValue, castOther.oldValue).append(newValue, castOther.newValue)
                .append(product, castOther.product).append(buildId, castOther.buildId)
                .append(sampleTime, castOther.sampleTime).append(createTime, castOther.createTime)
                .append(externInfo, castOther.externInfo).append(serverId, castOther.serverId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(type).append(name).append(oldValue).append(newValue)
                .append(product).append(buildId).append(sampleTime).append(createTime).append(externInfo)
                .append(serverId).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public Timestamp getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getExternInfo() {
        return externInfo;
    }

    public void setExternInfo(String externInfo) {
        this.externInfo = externInfo;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

}
