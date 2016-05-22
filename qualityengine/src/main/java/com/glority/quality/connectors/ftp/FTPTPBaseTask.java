package com.glority.quality.connectors.ftp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.ftp.FTPConnector;

/**
 * The base task of all the ftp operation target to taskreport server.
 * 
 * @author zm
 * 
 */

public abstract class FTPTPBaseTask extends FTPBaseTask {

    protected String pathDefFile;
    protected String folderType = "all";
    protected String businessUnit;
    protected String productName;
    protected String svnRevision;
    protected String jenkinsBuild;
    protected Properties pathProp;
    protected static final String HOME_PATH = "/qsdata";
    protected static final String BUILD = "build";

    public FTPTPBaseTask() {
        super();
    }

    public void setPathDefFile(String pathDefFile) {
        this.pathDefFile = pathDefFile;
    }

    public void setFolderType(String folderType) {
        this.folderType = folderType;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }

    public void setJenkinsBuild(String jenkinsBuild) {
        this.jenkinsBuild = jenkinsBuild;
    }

    /**
     * to init the parameters.
     */
    protected void initParameters() {
        if (this.pathDefFile == null) {
            throw new BuildException("Need path properties file.");
        }

        InputStream ins = null;
        try {
            this.pathProp = new Properties();
            ins = new BufferedInputStream(new FileInputStream(pathDefFile));
            pathProp.load(ins);
        } catch (IOException e) {
            throw new BuildException(e.getMessage(), e);
        } finally {
            try {
                ins.close();
            } catch (IOException ex) {
                log.error(ex.getMessage());
            }
        }

        if (this.qualityReport != null) {
            this.businessUnit = this.qualityReport.getProductInfo().getBusinessUnit();
            this.productName = this.qualityReport.getProductInfo().getProductName();
            this.svnRevision = this.qualityReport.getProductInfo().getSvnRevision();
            this.jenkinsBuild = this.qualityReport.getBuildTestInfo().getBuild().getJenkinsbuild();
        }

        this.vaildateParams();
    }

    private void vaildateParams() {
        if (StringUtils.isEmpty(this.localPath)) {
            throw new BuildException("Need Local path");
        }
        if (StringUtils.isEmpty(this.businessUnit)) {
            throw new BuildException("Need Business Unit");
        }

        if (StringUtils.isEmpty(this.productName)) {
            throw new BuildException("Need Product Name");
        }

        if (StringUtils.isEmpty(this.jenkinsBuild)) {
            throw new BuildException("Need jenkins Build");
        }
    }

    /**
     * to create remote path.
     * 
     * @return the path.
     * @throws IOException
     *             create remote path may failed.
     */
    protected String getRemoteFolderPath(String pathPrefix) {
        initParameters();
        String revisionAndBuild = getRevisionAndBuild(pathPrefix);
        String pathPostfix = revisionAndBuild + FTPConnector.FTP_FILE_SEPERATOR + pathProp.getProperty(this.folderType);
        String remoteFolderPath = pathPrefix + FTPConnector.FTP_FILE_SEPERATOR + pathPostfix;
        return remoteFolderPath;
    }

    /**
     * to get revisionAndBuild String.
     * 
     * @param pathPrefix
     *            the path before revisionAndBuild.
     * @return the revisionAndBuild like 24158_611
     * @throws IOException
     *             ftp operation may cause IOException.
     * @throws ConnectorException
     */
    private String getRevisionAndBuild(String pathPrefix) {

        if (this.svnRevision != null) {
            return this.svnRevision + "_" + this.jenkinsBuild;
        }

        List<String> fileNameList = Collections.emptyList();
        try {
            fileNameList = super.connector.getSpecifiedFolderContentNames(pathPrefix);
        } catch (ConnectorException e) {
            throw new BuildException(e.getMessage(), e);
        }

        if (isJenkinsBuildValid()) {
            for (String fileName : fileNameList) {
                String build = fileName.substring(fileName.indexOf('_') + 1);
                if (this.jenkinsBuild.equals(build)) {
                    return fileName;
                }
            }
        } else {
            int baseBuild = 0;
            String revisionAndBuild = null;
            for (String fileName : fileNameList) {
                int newBuild = 0;
                try {
                    String build = fileName.substring(fileName.indexOf('_') + 1);
                    newBuild = Integer.parseInt(build);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                if (newBuild > baseBuild) {
                    baseBuild = newBuild;
                    revisionAndBuild = fileName;
                }
            }
            if (revisionAndBuild != null) {
                return revisionAndBuild;
            }
        }

        throw new BuildException("failed to get revision and build!");
    }

    private boolean isJenkinsBuildValid() {
        try {
            Long.parseLong(this.jenkinsBuild);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * to prepare remote environment.
     */
    protected void prepareRemoteEnv() {
        String pathPrefix = HOME_PATH + FTPConnector.FTP_FILE_SEPERATOR + businessUnit
                + FTPConnector.FTP_FILE_SEPERATOR + BUILD + FTPConnector.FTP_FILE_SEPERATOR + productName;
        remotePath = getRemoteFolderPath(pathPrefix);
    }
}
