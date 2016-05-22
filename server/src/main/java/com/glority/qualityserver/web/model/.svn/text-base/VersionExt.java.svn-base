package com.glority.qualityserver.web.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.model.Version;

/**
 * This class is for model version. may for Timestamp format.
 * 
 * @author Administrator
 * 
 */
@DataTransferObject
public class VersionExt {
    private static final Logger LOGGER = Logger.getLogger(VersionExt.class);

    private static final long serialVersionUID = 6562395215490768934L;

    private static final SimpleDateFormat DF = new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS);
    @RemoteProperty
    private Long id;

    @RemoteProperty
    private Long productId;

    @RemoteProperty
    private String version;

    @RemoteProperty
    private String svnUrl;

    @RemoteProperty
    private String svnRevision;

    @RemoteProperty
    private String devStartTimeStr;

    @RemoteProperty
    private String devEndTimeStr;

    @RemoteProperty
    private String testStartTimeStr;

    @RemoteProperty
    private String testEndTimeStr;

    @RemoteProperty
    private String stageStartTimeStr;

    @RemoteProperty
    private String stageEndTimeStr;

    @RemoteProperty
    private String productionStartTimeStr;

    @RemoteProperty
    private String productionEndTimeStr;

    public VersionExt() {

    }

    public VersionExt(Version version) {
        this.id = version.getId();
        this.version = version.getVersion();
        this.svnUrl = version.getSvnUrl();
        this.svnRevision = version.getSvnRevision();
        this.productId = version.getProductId();
        this.devStartTimeStr = this.getTimeString(version.getStageStartTime());
        this.devEndTimeStr = this.getTimeString(version.getDevEndTime());
        this.testStartTimeStr = this.getTimeString(version.getTestStartTime());
        this.testEndTimeStr = this.getTimeString(version.getTestEndTime());
        this.stageStartTimeStr = this.getTimeString(version.getStageStartTime());
        this.stageEndTimeStr = this.getTimeString(version.getStageEndTime());
        this.productionStartTimeStr = this.getTimeString(version.getProductionStartTime());
        this.productionEndTimeStr = this.getTimeString(version.getProductionEndTime());
    }

    public Version getWrappedVersion() {
        Version result = new Version();
        result.setId(this.getId());
        result.setVersion(this.getVersion());
        result.setSvnUrl(this.getSvnUrl());
        result.setSvnRevision(this.getSvnRevision());
        result.setProductId(this.getProductId());
        result.setDevStartTime(this.getTimestamp(this.devStartTimeStr));
        result.setDevEndTime(this.getTimestamp(this.devEndTimeStr));
        result.setTestStartTime(this.getTimestamp(this.testStartTimeStr));
        result.setTestEndTime(this.getTimestamp(this.testEndTimeStr));
        result.setStageStartTime(this.getTimestamp(this.stageStartTimeStr));
        result.setStageEndTime(this.getTimestamp(this.stageEndTimeStr));
        result.setProductionStartTime(this.getTimestamp(this.productionStartTimeStr));
        result.setProductionEndTime(this.getTimestamp(this.productionEndTimeStr));
        return result;
    }

    private String getTimeString(Timestamp time) {
        if (time != null) {
            try {
                return DF.format(time);
            } catch (Exception e) {
                LOGGER.warn(e.getMessage(), e);
            }
        }
        return null;
    }

    private Timestamp getTimestamp(String timeStr) {
        if (timeStr != null) {
            try {
                Date time = DF.parse(timeStr);
                return new Timestamp(time.getTime());
            } catch (Exception e) {
                LOGGER.warn(e.getMessage(), e);
            }
        }
        return null;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getSvnRevision() {
        return svnRevision;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }

    public String getDevStartTimeStr() {
        return devStartTimeStr;
    }

    public void setDevStartTimeStr(String devStartTimeStr) {
        this.devStartTimeStr = devStartTimeStr;
    }

    public String getDevEndTimeStr() {
        return devEndTimeStr;
    }

    public void setDevEndTimeStr(String devEndTimeStr) {
        this.devEndTimeStr = devEndTimeStr;
    }

    public String getTestStartTimeStr() {
        return testStartTimeStr;
    }

    public void setTestStartTimeStr(String testStartTimeStr) {
        this.testStartTimeStr = testStartTimeStr;
    }

    public String getTestEndTimeStr() {
        return testEndTimeStr;
    }

    public void setTestEndTimeStr(String testEndTimeStr) {
        this.testEndTimeStr = testEndTimeStr;
    }

    public String getStageStartTimeStr() {
        return stageStartTimeStr;
    }

    public void setStageStartTimeStr(String stageStartTimeStr) {
        this.stageStartTimeStr = stageStartTimeStr;
    }

    public String getStageEndTimeStr() {
        return stageEndTimeStr;
    }

    public void setStageEndTimeStr(String stageEndTimeStr) {
        this.stageEndTimeStr = stageEndTimeStr;
    }

    public String getProductionStartTimeStr() {
        return productionStartTimeStr;
    }

    public void setProductionStartTimeStr(String productionStartTimeStr) {
        this.productionStartTimeStr = productionStartTimeStr;
    }

    public String getProductionEndTimeStr() {
        return productionEndTimeStr;
    }

    public void setProductionEndTimeStr(String productionEndTimeStr) {
        this.productionEndTimeStr = productionEndTimeStr;
    }

}
