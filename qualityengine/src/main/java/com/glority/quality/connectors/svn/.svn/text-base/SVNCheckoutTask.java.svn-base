package com.glority.quality.connectors.svn;

import java.io.File;
import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNRevision;

/**
 * to do svn check operation.
 * 
 * @author zm
 * 
 */
public class SVNCheckoutTask extends SVNBaseTask {

    private String localPath;
    private String revision;

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    @Override
    public void process() {
        checkParameters();
        svnConnect();
        File localFile = new File(localPath);
        SVNUpdateClient updateClient = clientManager.getUpdateClient();
        updateClient.setIgnoreExternals(false);
        SVNRevision coRevision;
        try {
            coRevision = SVNRevision.create(Long.parseLong(this.revision));
        } catch (NumberFormatException e) {
            coRevision = SVNRevision.HEAD;
        }
        try {
            long workingVersion = updateClient
                    .doCheckout(repositoryURL, localFile, coRevision,
                            coRevision, SVNDepth.INFINITY, false);
            getProject().log(
                    "Reversion: " + workingVersion
                            + " has been checked out to " + localPath);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }
    }

    @Override
    protected void checkParameters() {
        if (this.qualityReport != null) {
            this.revision = this.qualityReport.getProductInfo()
                    .getSvnRevision();
        }
        if (localPath == null) {
            throw new BuildException("Local path cann't be null.");
        }
    }

}
