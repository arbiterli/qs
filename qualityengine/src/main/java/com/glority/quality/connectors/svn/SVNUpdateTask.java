package com.glority.quality.connectors.svn;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

/**
 * to do svn update operation.
 * 
 * @author zm.
 * 
 */
public class SVNUpdateTask extends SVNBaseTask {

    private String localPath;
    private String revision;

    public String getLocalPath() {
        return localPath;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    @Override
    public void process() {
        svnConnect();
        checkParameters();
        SVNRevision updateRevision;
        try {
            updateRevision = SVNRevision.create(Long.parseLong(this.revision));
        } catch (NumberFormatException e) {
            updateRevision = SVNRevision.HEAD;
        }
        File updateFile = new File(localPath);
        SVNUpdateClient updateClient = clientManager.getUpdateClient();
        updateClient.setIgnoreExternals(false);
        try {
            long versionNum = updateClient.doUpdate(updateFile, updateRevision,
                    SVNDepth.INFINITY, false, false);
            getProject().log(
                    "working copy has been updated to revision: " + versionNum);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }
    }

    @Override
    protected void checkParameters() {
        if (this.localPath == null) {
            throw new BuildException("Local path cann't be null.");
        }

        if (!new File(this.localPath).exists()) {
            throw new BuildException("File or folder not exist.");
        }
    }

}
