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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

import com.glority.quality.StringUtil;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Product model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "products", catalog = "qualitysystem")
@XmlRootElement
@DataTransferObject
public class Product extends BaseObject implements Serializable {

    private static final long serialVersionUID = -5215468698880826315L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @RemoteProperty
    private Long id;

    @Column(name = "name", length = 50)
    @RemoteProperty
    private String name;

    @Column(name = "product_group", length = 50)
    @RemoteProperty
    private String group;

    @Column(name = "display_name", length = 50)
    @RemoteProperty
    private String displayName;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Column(name = "common_repository_svn")
    private String commonRepositorySVN;

    @Column(name = "has_server")
    private Boolean hasServer;

    @Column(name = "discarded")
    private Boolean discarded;

    @Column(name = "trunk_svn")
    @RemoteProperty
    private String trunkSvnUrl;

    @Transient
    private String ftpReportScope;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "products")
    private Set<Configuration> configurationses = new HashSet<Configuration>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Build> buildses = new HashSet<Build>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<IssueRecord> issues = new HashSet<IssueRecord>(0);

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotdeploy_config_id", nullable = true)
    private HotDeployConfig hotDeployConfig;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "issue_track_id", nullable = true)
    private IssueTrack issueTrack;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testrail_id", nullable = true)
    private TestRail testRail;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("name", name)
                .append("group", group).append("displayName", displayName).append("createdAt", createdAt)
                .append("commonRepositorySVN", commonRepositorySVN).append("hasServer", hasServer)
                .append("discarded", discarded).append("trunkSvnUrl", trunkSvnUrl)
                .append("hotDeployConfig", hotDeployConfig).append("issueTrack", issueTrack)
                .append("testRail", testRail).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product castOther = (Product) other;
        return new EqualsBuilder().append(id, castOther.id).append(name, castOther.name).append(group, castOther.group)
                .append(displayName, castOther.displayName).append(createdAt, castOther.createdAt)
                .append(commonRepositorySVN, castOther.commonRepositorySVN).append(hasServer, castOther.hasServer)
                .append(discarded, castOther.discarded).append(trunkSvnUrl, castOther.trunkSvnUrl)
                .append(hotDeployConfig, castOther.hotDeployConfig).append(issueTrack, castOther.issueTrack)
                .append(testRail, castOther.testRail).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(group).append(displayName).append(createdAt)
                .append(commonRepositorySVN).append(hasServer).append(discarded).append(trunkSvnUrl)
                .append(hotDeployConfig).append(issueTrack).append(testRail).toHashCode();
    }

    /**
     * Return true is the product is valid for the quality systems A valid
     * product should at least have group and name.
     * 
     * @return
     */
    public boolean isValid() {
        if (StringUtil.isEmpty(this.getGroup())) {
            return false;
        }

        if (StringUtil.isEmpty(this.getName())) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Configuration> getConfigurationses() {
        return configurationses;
    }

    public void setConfigurationses(Set<Configuration> configurationses) {
        this.configurationses = configurationses;
    }

    public Set<Build> getBuildses() {
        return buildses;
    }

    public void setBuildses(Set<Build> buildses) {
        this.buildses = buildses;
    }

    public String getCommonRepositorySVN() {
        return commonRepositorySVN;
    }

    public void setCommonRepositorySVN(String commonRepositorySVN) {
        this.commonRepositorySVN = commonRepositorySVN;
    }

    public Set<IssueRecord> getIssues() {
        return issues;
    }

    public void setIssues(Set<IssueRecord> issues) {
        this.issues = issues;
    }

    public Boolean getHasServer() {
        return hasServer;
    }

    public void setHasServer(Boolean hasServer) {
        this.hasServer = hasServer;
    }

    public Boolean getDiscarded() {
        return discarded;
    }

    public void setDiscarded(Boolean discarded) {
        this.discarded = discarded;
    }

    public String getTrunkSvnUrl() {
        return trunkSvnUrl;
    }

    public void setTrunkSvnUrl(String trunkSvn) {
        this.trunkSvnUrl = trunkSvn;
    }

    public HotDeployConfig getHotDeployConfig() {
        return hotDeployConfig;
    }

    public void setHotDeployConfig(HotDeployConfig hotDeployConfig) {
        this.hotDeployConfig = hotDeployConfig;
    }

    public IssueTrack getIssueTrack() {
        return issueTrack;
    }

    public void setIssueTrack(IssueTrack issueTrack) {
        this.issueTrack = issueTrack;
    }

    public TestRail getTestRail() {
        return testRail;
    }

    public void setTestRail(TestRail testRail) {
        this.testRail = testRail;
    }

    public String getFtpReportScope() {
        return ftpReportScope;
    }

    public void setFtpReportScope(String ftpReportScope) {
        this.ftpReportScope = ftpReportScope;
    }

}
