package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;

/**
 * TestRail model.
 * 
 * @author Zhao JP
 * 
 */
@Entity
@Table(name = "testrail", catalog = "qualitysystem")
@XmlRootElement
public class TestRail extends BaseObject implements Serializable {

    private static final long serialVersionUID = -7435806614147198379L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "testrail_server")
    private String testrailServer;

    @Column(name = "testrail_product_id")
    private Long testrailProductId;

    @Column(name = "testrail_password")
    private String testrailPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestrailServer() {
        return testrailServer;
    }

    public void setTestrailServer(String testrailServer) {
        this.testrailServer = testrailServer;
    }

    public Long getTestrailProductId() {
        return testrailProductId;
    }

    public void setTestrailProductId(Long testrailProductId) {
        this.testrailProductId = testrailProductId;
    }

    public String getTestrailPassword() {
        return testrailPassword;
    }

    public void setTestrailPassword(String testrailPassword) {
        this.testrailPassword = testrailPassword;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestRail)) {
            return false;
        }
        TestRail castOther = (TestRail) other;
        return new EqualsBuilder().append(id, castOther.id).append(testrailServer, castOther.testrailServer)
                .append(testrailProductId, castOther.testrailProductId)
                .append(testrailPassword, castOther.testrailPassword).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(testrailServer).append(testrailProductId)
        .append(testrailPassword).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id)
        .append("testrailServer", testrailServer).append("testrailProductId", testrailProductId)
        .append("testrailPassword", testrailPassword).toString();
    }

}
