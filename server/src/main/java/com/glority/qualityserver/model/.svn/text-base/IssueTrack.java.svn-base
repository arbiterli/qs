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
 * issue_tracker object.
 * @author Zhao JP.
 *
 */
@Entity
@Table(name = "issue_track", catalog = "qualitysystem")
@XmlRootElement
public class IssueTrack extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1473310761139067173L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "issue_track_base_url")
    private String issueTrackBaseUrl;

    @Column(name = "issue_track_product_name")
    private String issueTrackProductName;

    @Column(name = "issue_track_username")
    private String issueTrackUsername;

    @Column(name = "issue_track_password")
    private String issueTrackPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueTrackBaseUrl() {
        return issueTrackBaseUrl;
    }

    public void setIssueTrackBaseUrl(String issueTrackBaseUrl) {
        this.issueTrackBaseUrl = issueTrackBaseUrl;
    }

    public String getIssueTrackProductName() {
        return issueTrackProductName;
    }

    public void setIssueTrackProductName(String issueTrackProductName) {
        this.issueTrackProductName = issueTrackProductName;
    }

    public String getIssueTrackUsername() {
        return issueTrackUsername;
    }

    public void setIssueTrackUsername(String issueTrackUsername) {
        this.issueTrackUsername = issueTrackUsername;
    }

    public String getIssueTrackPassword() {
        return issueTrackPassword;
    }

    public void setIssueTrackPassword(String issueTrackPassword) {
        this.issueTrackPassword = issueTrackPassword;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IssueTrack)) {
            return false;
        }
        IssueTrack castOther = (IssueTrack) other;
        return new EqualsBuilder().append(id, castOther.id).append(issueTrackBaseUrl, castOther.issueTrackBaseUrl)
                .append(issueTrackProductName, castOther.issueTrackProductName)
                .append(issueTrackUsername, castOther.issueTrackUsername)
                .append(issueTrackPassword, castOther.issueTrackPassword).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(issueTrackBaseUrl).append(issueTrackProductName)
        .append(issueTrackUsername).append(issueTrackPassword).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id)
        .append("issueTrackBaseUrl", issueTrackBaseUrl).append("issueTrackProductName", issueTrackProductName)
        .append("issueTrackUsername", issueTrackUsername).append("issueTrackPassword", issueTrackPassword).toString();
    }

}
