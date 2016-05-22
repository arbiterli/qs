package com.glority.quality.connectors.svn;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.wc.SVNStatus;
import org.tmatesoft.svn.core.wc.SVNStatusType;

/**
 * to do svn commit operation.
 * 
 * @author zm.
 * 
 */
public class SVNCommitTask extends SVNBaseTask {

    private String commitMessage;
    private String localPath;
    private static final String SVN_FILE = ".svn";

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    @Override
    public void process() {
        checkParameters();
        svnConnect();
        File commitFile = new File(localPath);
        addUnversionedFiles(commitFile);
        try {
            SVNCommitInfo info = clientManager.getCommitClient().doCommit(
                    new File[] { commitFile }, true, commitMessage, null, null,
                    false, false, SVNDepth.fromRecurse(true));
            getProject().log(
                    "commit successfully. " + "Date: " + info.getDate()
                            + "Revision: " + info.getNewRevision());
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }
    }

    @Override
    protected void checkParameters() {
        if (commitMessage == null) {
            throw new BuildException("Commit message cann't be null.");
        }

        if (localPath == null) {
            throw new BuildException("Local path cann't be null.");
        }
    }

    private void addUnversionedFiles(File file) {
        if (file.getName().equals(SVN_FILE) || file == null) {
            return;
        }
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null) {
                return;
            }
            for (int i = 0; i < childFiles.length; i++) {
                addUnversionedFiles(childFiles[i]);
            }
        } else {
            try {
                SVNStatus status = clientManager.getStatusClient().doStatus(
                        file, true);
                if (status == null
                        || status.getContentsStatus() == SVNStatusType.STATUS_UNVERSIONED) {
                    clientManager.getWCClient().doAdd(file, false, false,
                            false, SVNDepth.INFINITY, false, false);
                    getProject().log("add: " + file.getName());
                } else if (status.getContentsStatus() == SVNStatusType.STATUS_MODIFIED) {
                    getProject().log("modified: " + file.getName());
                }
            } catch (SVNException e) {
                throw new BuildException(e.getMessage());
            }
        }
    }

}
