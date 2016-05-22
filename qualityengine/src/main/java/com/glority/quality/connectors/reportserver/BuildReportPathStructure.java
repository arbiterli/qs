package com.glority.quality.connectors.reportserver;

import java.io.File;

/**
 * This class defined the folder structure in the build report server the build report server has http and ftp hosted.
 * both of them pointed to the same base folder like http://quality.glority.com:81/qsdata/Glority/build/ESignature/
 * 24419_24/buildreports/
 * 
 * @author XQS
 * 
 */
public class BuildReportPathStructure {
    public static final String BASE_FOLDER = "qsdata";
    public static final String BUILD_FOLDER = "build";
    public static final String INSTALLER_FOLDER = "installer";
    public static final String DEBUG_INSTALLER_FOLDER = "debug_installer";
    public static final String REPORT_FOLDER = "buildreports";
    public static final String QUALITY_REPORT_FOLDER = "qualityreports";
    public static final String QUALITY_XML = "quality.xml";

    public static final String PROTOCOL_FTP = "ftp";
    public static final String PROTOCOL_HTTP = "http";
    public static final String PROTOCOL_LOCAL = "local";

    protected String businessUnit;
    protected String productName;
    protected String svnRevision;
    protected String jenkinsBuildId;
    protected String protocol;

    protected String baseURL;

    /**
     * Get the seperator of the path base on the protocol and OS.
     * 
     * @return
     */
    private String getSeperator() {
        if (PROTOCOL_HTTP.equals(protocol) || PROTOCOL_FTP.equals(protocol)) {
            return "/";
        } else {
            return File.separator;
        }
    }

    public String fixedPath(String path) {
        if (path == null) {
            return null;
        }
        return path.replace("/", getSeperator()).replace("\\", getSeperator());
    }

    /**
     * Get the path of a build like http://quality.glority.com:81/qsdata/Glority/build/ESignature/24419_24/.
     * 
     * @param includeHostUrl
     *            include the base path if it's true
     * @return
     */
    public String getBuildPath(boolean includeHostUrl) {
        String hostUrl = "";
        if (includeHostUrl) {
            hostUrl = this.baseURL + getSeperator();
        }
        return hostUrl + BASE_FOLDER + getSeperator() + this.businessUnit + getSeperator() + BUILD_FOLDER
                + getSeperator() + this.productName + getSeperator() + this.svnRevision + "_" + this.jenkinsBuildId;
    }

    /**
     * Get the path of quality.xml.
     * 
     * @param includeHostUrl
     * @return
     */
    public String getQualityXmlPath(boolean includeHostUrl) {
        return getBuildPath(includeHostUrl) + getSeperator() + QUALITY_XML;
    }

    /**
     * Get installer folder where we store the installers.
     * 
     * @param includeHostUrl
     * @return
     */
    public String getInstallerPath(boolean includeHostUrl) {
        return getBuildPath(includeHostUrl) + getSeperator() + INSTALLER_FOLDER;
    }

    /**
     * Get the debug installer folder where we store the debug installer which means compiled with debug flags enabled.
     * 
     * @param includeHostUrl
     * @return
     */
    public String getDebugInstallerPath(boolean includeHostUrl) {
        return getBuildPath(includeHostUrl) + getSeperator() + DEBUG_INSTALLER_FOLDER;
    }

    /**
     * Get the build report path where we store the build reports of the build.
     * 
     * @param includeHostUrl
     * @return
     */
    public String getBuildReportPath(boolean includeHostUrl) {
        return getBuildPath(includeHostUrl) + getSeperator() + REPORT_FOLDER;
    }

    /**
     * Get the path where we keep quality reports that generated by quality engine it's a subfolder of build report.
     * 
     * @param includeHostUrl
     * @return
     */
    public String getQualityReportPath(boolean includeHostUrl) {
        return getBuildReportPath(includeHostUrl) + getSeperator() + QUALITY_REPORT_FOLDER;
    }

    /**
     * Get a path of a quality report base on the metric This will be under a subfolder of the quality reports path.
     * 
     * @param includeHostUrl
     * @param metricPath
     * @return
     */
    public String getQualityReportPath(boolean includeHostUrl, String metricPath) {
        if (metricPath == null) {
            return null;
        }
        return getQualityReportPath(includeHostUrl) + getSeperator() + fixedPath(metricPath);
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSvnRevision() {
        return svnRevision;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }

    public String getJenkinsBuildId() {
        return jenkinsBuildId;
    }

    public void setJenkinsBuildId(String jenkinsBuildId) {
        this.jenkinsBuildId = jenkinsBuildId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}