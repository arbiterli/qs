package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

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
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * Server model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "server", catalog = "qualitysystem")
@XmlRootElement
@DataTransferObject
public class Server {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @RemoteProperty
    private Long id;

    @Column(name = "phase_id")
    @RemoteProperty
    private Long phaseId;

    @Column(name = "host")
    @RemoteProperty
    private String host;

    @Column(name = "username")
    @RemoteProperty
    private String username;

    @Column(name = "password")
    @RemoteProperty
    private String password;

    @Column(name = "name")
    @RemoteProperty
    private String name;

    @Column(name = "build_id")
    @RemoteProperty
    private Long buildId;

    @Column(name = "type")
    @RemoteProperty
    private String type;

    @Column(name = "site_url")
    @RemoteProperty
    private String siteUrl;

    @Column(name = "edit_url")
    @RemoteProperty
    private String editUrl;

    @Column(name = "deploy_script")
    @RemoteProperty
    private String deployScript;

    @Column(name = "check_script")
    @RemoteProperty
    private String checkScript;

    @Column(name = "deploy_protocol")
    @RemoteProperty
    private String deployProtocol;

    @Column(name = "active_version")
    private String activeVersion;

    @Column(name = "check_is_active")
    @RemoteProperty
    private Boolean checkIsActive;

    @Column(name = "nagios_host")
    private String nagiosHost;

    @Column(name = "nagios_is_active")
    private Boolean nagiosIsActive;

    @Column(name = "nagios_url")
    private String nagiosUrl;

    @Column(name = "nagios_username")
    private String nagiosUserName;

    @Column(name = "nagios_password")
    private String nagiosPassword;

    @Column(name = "discarded")
    private Boolean isDiscarded;

    @Column(name = "cloudwatch_is_active")
    private Boolean cloudwatchIsActive;

    @Column(name = "cloudwatch_instance_id")
    private String cloudwatchInstanceId;

    @Column(name = "cloudwatch_access_key")
    private String cloudwatchAccessKey;

    @Column(name = "cloudwatch_secret_key")
    private String cloudwatchSecretKey;

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Server)) {
            return false;
        }
        Server castOther = (Server) other;
        return new EqualsBuilder().append(id, castOther.id).append(phaseId, castOther.phaseId)
                .append(host, castOther.host).append(username, castOther.username).append(password, castOther.password)
                .append(name, castOther.name).append(buildId, castOther.buildId).append(type, castOther.type)
                .append(siteUrl, castOther.siteUrl).append(editUrl, castOther.editUrl)
                .append(deployScript, castOther.deployScript).append(checkScript, castOther.checkScript)
                .append(deployProtocol, castOther.deployProtocol).append(activeVersion, castOther.activeVersion)
                .append(checkIsActive, castOther.checkIsActive).append(nagiosHost, castOther.nagiosHost)
                .append(nagiosIsActive, castOther.nagiosIsActive).append(nagiosUrl, castOther.nagiosUrl)
                .append(nagiosUserName, castOther.nagiosUserName).append(nagiosPassword, castOther.nagiosPassword)
                .append(isDiscarded, castOther.isDiscarded).append(cloudwatchIsActive, castOther.cloudwatchIsActive)
                .append(cloudwatchInstanceId, castOther.cloudwatchInstanceId)
                .append(cloudwatchAccessKey, castOther.cloudwatchAccessKey)
                .append(cloudwatchSecretKey, castOther.cloudwatchSecretKey).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(phaseId).append(host).append(username).append(password)
                .append(name).append(buildId).append(type).append(siteUrl).append(editUrl).append(deployScript)
                .append(checkScript).append(deployProtocol).append(activeVersion).append(checkIsActive)
                .append(nagiosHost).append(nagiosIsActive).append(nagiosUrl).append(nagiosUserName)
                .append(nagiosPassword).append(isDiscarded).append(cloudwatchIsActive).append(cloudwatchInstanceId)
                .append(cloudwatchAccessKey).append(cloudwatchSecretKey).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("phaseId", phaseId)
                .append("host", host).append("username", username).append("password", password).append("name", name)
                .append("buildId", buildId).append("type", type).append("siteUrl", siteUrl).append("editUrl", editUrl)
                .append("deployScript", deployScript).append("checkScript", checkScript)
                .append("deployProtocol", deployProtocol).append("activeVersion", activeVersion)
                .append("checkIsActive", checkIsActive).append("nagiosHost", nagiosHost)
                .append("nagiosIsActive", nagiosIsActive).append("nagiosUrl", nagiosUrl)
                .append("nagiosUserName", nagiosUserName).append("nagiosPassword", nagiosPassword)
                .append("isDiscarded", isDiscarded).append("cloudwatchIsActive", cloudwatchIsActive)
                .append("cloudwatchInstanceId", cloudwatchInstanceId)
                .append("cloudwatchAccessKey", cloudwatchAccessKey).append("cloudwatchSecretKey", cloudwatchSecretKey)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = phaseId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public String getDeployScript() {
        return deployScript;
    }

    public void setDeployScript(String deployScript) {
        this.deployScript = deployScript;
    }

    public String getCheckScript() {
        return checkScript;
    }

    public void setCheckScript(String checkScript) {
        this.checkScript = checkScript;
    }

    public String getDeployProtocol() {
        return deployProtocol;
    }

    public void setDeployProtocol(String deployProtocol) {
        this.deployProtocol = deployProtocol;
    }

    public String getActiveVersion() {
        return activeVersion;
    }

    public void setActiveVersion(String activeVersion) {
        this.activeVersion = activeVersion;
    }

    public Boolean getCheckIsActive() {
        return checkIsActive;
    }

    public void setCheckIsActive(Boolean checkIsActive) {
        this.checkIsActive = checkIsActive;
    }

    public String getNagiosHost() {
        return nagiosHost;
    }

    public void setNagiosHost(String nagiosHost) {
        this.nagiosHost = nagiosHost;
    }

    public Boolean getNagiosIsActive() {
        return nagiosIsActive;
    }

    public void setNagiosIsActive(Boolean nagiosIsActive) {
        this.nagiosIsActive = nagiosIsActive;
    }

    public String getNagiosUrl() {
        return nagiosUrl;
    }

    public void setNagiosUrl(String nagiosUrl) {
        this.nagiosUrl = nagiosUrl;
    }

    public String getNagiosUserName() {
        return nagiosUserName;
    }

    public void setNagiosUserName(String nagiosUserName) {
        this.nagiosUserName = nagiosUserName;
    }

    public String getNagiosPassword() {
        return nagiosPassword;
    }

    public void setNagiosPassword(String nagiosPassword) {
        this.nagiosPassword = nagiosPassword;
    }

    public Boolean getIsDiscarded() {
        return isDiscarded;
    }

    public void setIsDiscarded(Boolean isDiscarded) {
        this.isDiscarded = isDiscarded;
    }

    public Boolean getCloudwatchIsActive() {
        return cloudwatchIsActive;
    }

    public void setCloudwatchIsActive(Boolean cloudwatchIsActive) {
        this.cloudwatchIsActive = cloudwatchIsActive;
    }

    public String getCloudwatchInstanceId() {
        return cloudwatchInstanceId;
    }

    public void setCloudwatchInstanceId(String cloudwatchInstanceId) {
        this.cloudwatchInstanceId = cloudwatchInstanceId;
    }

    public String getCloudwatchAccessKey() {
        return cloudwatchAccessKey;
    }

    public void setCloudwatchAccessKey(String cloudwatchAccessKey) {
        this.cloudwatchAccessKey = cloudwatchAccessKey;
    }

    public String getCloudwatchSecretKey() {
        return cloudwatchSecretKey;
    }

    public void setCloudwatchSecretKey(String cloudwatchSecretKey) {
        this.cloudwatchSecretKey = cloudwatchSecretKey;
    }

}
