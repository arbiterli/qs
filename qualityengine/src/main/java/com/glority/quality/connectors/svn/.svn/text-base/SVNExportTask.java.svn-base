package com.glority.quality.connectors.svn;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * to do svn export operation.
 * 
 * @author zm
 * 
 */
public class SVNExportTask extends SVNBaseTask {

    private String destPath;
    private String revision;

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    @Override
    public void process() {
        checkParameters();
        svnConnect();
        SVNRepository repository = null;
        try {
            repository = SVNRepositoryFactory.create(SVNURL
                    .parseURIEncoded(svnURI));
            ISVNAuthenticationManager authManager = SVNWCUtil
                    .createDefaultAuthenticationManager(username, password);
            repository.setAuthenticationManager(authManager);
            SVNUpdateClient updateClient = clientManager.getUpdateClient();
            updateClient.setIgnoreExternals(false);
            SVNRevision realRevision;
            try {
                realRevision = SVNRevision.create(Long
                        .parseLong(revision));
            } catch (NumberFormatException e) {
                realRevision = SVNRevision.HEAD;
            }
            updateClient.doExport(SVNURL.parseURIEncoded(svnURI), new File(
                        destPath), realRevision, realRevision, null, true,
                        SVNDepth.INFINITY);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }

    }

    @Override
    protected void checkParameters() {
        if (destPath == null) {
            throw new BuildException("Destination path cann't be null.");
        }

        if (revision == null) {
            getProject().log(
                    "Warning: no revision set, it will use head revision.");
        }
    }

}
