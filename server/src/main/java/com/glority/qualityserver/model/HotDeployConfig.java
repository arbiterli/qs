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
 * hotdeployconfig object.
 * @author Zhao JP
 *
 */
@Entity
@Table(name = "hotdeploy_config", catalog = "qualitysystem")
@XmlRootElement
public class HotDeployConfig extends BaseObject implements Serializable {

    private static final long serialVersionUID = -6225122655771686154L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "svn_user")
    private String svnUser;

    @Column(name = "svn_password")
    private String svnPassword;

    @Column(name = "hotdeploy_svn")
    private String hotDeploySvn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSvnUser() {
        return svnUser;
    }

    public void setSvnUser(String svnUser) {
        this.svnUser = svnUser;
    }

    public String getSvnPassword() {
        return svnPassword;
    }

    public void setSvnPassword(String svnPassword) {
        this.svnPassword = svnPassword;
    }

    public String getHotDeploySvn() {
        return hotDeploySvn;
    }

    public void setHotDeploySvn(String hotDeploySvn) {
        this.hotDeploySvn = hotDeploySvn;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HotDeployConfig)) {
            return false;
        }
        HotDeployConfig castOther = (HotDeployConfig) other;
        return new EqualsBuilder().append(id, castOther.id).append(svnUser, castOther.svnUser)
                .append(svnPassword, castOther.svnPassword)
                .append(hotDeploySvn, castOther.hotDeploySvn).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(svnUser).append(svnPassword)
        .append(hotDeploySvn).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id)
        .append("svnUser", svnUser).append("svnPassword", svnPassword)
        .append("hotDeploySvn", hotDeploySvn).toString();
    }

}
