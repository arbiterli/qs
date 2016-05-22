package com.glority.quality.connectors.svn;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

/**
 * to do svn switch operation.
 * @author zm.
 *
 */
public class SVNSwitchTask extends SVNBaseTask {

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
    protected void checkParameters() {
        if (null == localPath) {
            throw new BuildException("localPath cann't be null.");
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void process() {
        svnConnect();
        checkParameters();
        SVNRevision switchRevision;
        try {
            switchRevision = SVNRevision.create(Long.parseLong(this.revision));
        } catch (NumberFormatException e) {
            switchRevision = SVNRevision.HEAD;
        }
        File updateFile = new File(localPath);
        SVNUpdateClient updateClient = clientManager.getUpdateClient();
        updateClient.setIgnoreExternals(false);
        try {
            long versionNum = updateClient.doSwitch(updateFile, repositoryURL,
                    switchRevision, true);
            getProject()
                    .log("working copy has been switched to revision: "
                            + versionNum);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }

    }

}
