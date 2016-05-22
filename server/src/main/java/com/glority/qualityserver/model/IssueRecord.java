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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Issue record.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "issue", catalog = "qualitysystem")
@XmlRootElement
public class IssueRecord {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "track_id")
    private Long trackId;

    @Column(name = "title")
    private String title;

    @Column(name = "priority")
    private String priority;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "implement_date")
    private Timestamp implementDate;

    @Column(name = "close_date")
    private Timestamp closeDate;

    @Column(name = "test_defined")
    private Boolean testDefined;

    @Column(name = "test_automated")
    private Boolean testAutomated;

    @Column(name = "passed_dev_test")
    private Boolean passedDevTest;

    @Column(name = "passed_nightly_test")
    private Boolean passedNightlyTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id", nullable = false)
    private Version version;

    @Column(name = "testcases")
    private String testCases;

    @Column(name = "test_defined_time")
    private Timestamp testDefinedTime;

    @Column(name = "test_automated_time")
    private Timestamp testAutomatedTime;

    @Column(name = "passed_dev_test_time")
    private Timestamp passedDevTestTime;

    @Column(name = "passed_nightly_test_time")
    private Timestamp passedNightlyTestTime;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("trackId", trackId)
                .append("title", title).append("priority", priority).append("type", type).append("status", status)
                .append("createTime", createTime).append("implementDate", implementDate).append("closeDate", closeDate)
                .append("testDefined", testDefined).append("testAutomated", testAutomated)
                .append("passedDevTest", passedDevTest).append("passedNightlyTest", passedNightlyTest)
                .append("product", product).append("version", version).append("testCases", testCases)
                .append("testDefinedTime", testDefinedTime).append("testAutomatedTime", testAutomatedTime)
                .append("passedDevTestTime", passedDevTestTime).append("passedNightlyTestTime", passedNightlyTestTime)
                .toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IssueRecord)) {
            return false;
        }
        IssueRecord castOther = (IssueRecord) other;
        return new EqualsBuilder().append(id, castOther.id).append(trackId, castOther.trackId)
                .append(title, castOther.title).append(priority, castOther.priority).append(type, castOther.type)
                .append(status, castOther.status).append(createTime, castOther.createTime)
                .append(implementDate, castOther.implementDate).append(closeDate, castOther.closeDate)
                .append(testDefined, castOther.testDefined).append(testAutomated, castOther.testAutomated)
                .append(passedDevTest, castOther.passedDevTest).append(passedNightlyTest, castOther.passedNightlyTest)
                .append(product, castOther.product).append(version, castOther.version)
                .append(testCases, castOther.testCases).append(testDefinedTime, castOther.testDefinedTime)
                .append(testAutomatedTime, castOther.testAutomatedTime)
                .append(passedDevTestTime, castOther.passedDevTestTime)
                .append(passedNightlyTestTime, castOther.passedNightlyTestTime).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(trackId).append(title).append(priority).append(type)
                .append(status).append(createTime).append(implementDate).append(closeDate).append(testDefined)
                .append(testAutomated).append(passedDevTest).append(passedNightlyTest).append(product).append(version)
                .append(testCases).append(testDefinedTime).append(testAutomatedTime).append(passedDevTestTime)
                .append(passedNightlyTestTime).toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Timestamp getImplementDate() {
        return implementDate;
    }

    public void setImplementDate(Timestamp implementDate) {
        this.implementDate = implementDate;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    public Boolean getTestDefined() {
        return testDefined;
    }

    public void setTestDefined(Boolean testDefined) {
        this.testDefined = testDefined;
    }

    public Boolean getTestAutomated() {
        return testAutomated;
    }

    public void setTestAutomated(Boolean testAutomated) {
        this.testAutomated = testAutomated;
    }

    public Boolean getPassedDevTest() {
        return passedDevTest;
    }

    public void setPassedDevTest(Boolean passedDevTest) {
        this.passedDevTest = passedDevTest;
    }

    public Boolean getPassedNightlyTest() {
        return passedNightlyTest;
    }

    public void setPassedNightlyTest(Boolean passedNightlyTest) {
        this.passedNightlyTest = passedNightlyTest;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getTestCases() {
        return testCases;
    }

    public void setTestCases(String testCases) {
        this.testCases = testCases;
    }

    public Timestamp getTestDefinedTime() {
        return testDefinedTime;
    }

    public void setTestDefinedTime(Timestamp testDefinedTime) {
        this.testDefinedTime = testDefinedTime;
    }

    public Timestamp getTestAutomatedTime() {
        return testAutomatedTime;
    }

    public void setTestAutomatedTime(Timestamp testAutomatedTime) {
        this.testAutomatedTime = testAutomatedTime;
    }

    public Timestamp getPassedDevTestTime() {
        return passedDevTestTime;
    }

    public void setPassedDevTestTime(Timestamp passedDevTestTime) {
        this.passedDevTestTime = passedDevTestTime;
    }

    public Timestamp getPassedNightlyTestTime() {
        return passedNightlyTestTime;
    }

    public void setPassedNightlyTestTime(Timestamp passedNightlyTestTime) {
        this.passedNightlyTestTime = passedNightlyTestTime;
    }

}
