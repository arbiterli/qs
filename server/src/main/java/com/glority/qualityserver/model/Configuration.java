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
 * Configuration model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "configurations", catalog = "qualitysystem")
@XmlRootElement
public class Configuration extends BaseObject implements Serializable {

    private static final long serialVersionUID = -4390618989841743011L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", nullable = false)
    private Version version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product products;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "vditemplateid")
    private Long vditemplateid;

    @Column(name = "arch", length = 200)
    private String arch;

    @Column(name = "os", length = 200)
    private String os;

    @Column(name = "language", length = 200)
    private String language;

    @Column(name = "softwares", length = 1024)
    private String softwares;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("version", version)
                .append("products", products).append("name", name).append("vditemplateid", vditemplateid)
                .append("arch", arch).append("os", os).append("language", language).append("softwares", softwares)
                .append("createdAt", createdAt).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration castOther = (Configuration) other;
        return new EqualsBuilder().append(id, castOther.id).append(version, castOther.version)
                .append(products, castOther.products).append(name, castOther.name)
                .append(vditemplateid, castOther.vditemplateid).append(arch, castOther.arch).append(os, castOther.os)
                .append(language, castOther.language).append(softwares, castOther.softwares)
                .append(createdAt, castOther.createdAt).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(version).append(products).append(name).append(vditemplateid)
                .append(arch).append(os).append(language).append(softwares).append(createdAt).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVditemplateid() {
        return vditemplateid;
    }

    public void setVditemplateid(Long vditemplateid) {
        this.vditemplateid = vditemplateid;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSoftwares() {
        return softwares;
    }

    public void setSoftwares(String softwares) {
        this.softwares = softwares;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
