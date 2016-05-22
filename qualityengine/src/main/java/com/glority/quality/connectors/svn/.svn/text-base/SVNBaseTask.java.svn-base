package com.glority.quality.connectors.svn;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.glority.quality.BaseTask;

/**
 * The base task of all svn operation.
 * 
 * @author zm
 * 
 */
public abstract class SVNBaseTask extends BaseTask {
    protected String svnURI;
    protected String username;
    protected String password;
    protected SVNURL repositoryURL;
    protected SVNClientManager clientManager;
    private static final String SVN_PREFIX = "svn";
    private static final String DAV_PREFIX = "http";

    public String getSvnURI() {
        return svnURI;
    }

    public void setSvnURI(String svnURI) {
        this.svnURI = svnURI;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected void svnConnect() {
        validateParameters();
        if (svnURI.startsWith(SVN_PREFIX)) {
            SVNRepositoryFactoryImpl.setup();
        }

        if (svnURI.startsWith(DAV_PREFIX)) {
            DAVRepositoryFactory.setup();
        }

        try {
            repositoryURL = SVNURL.parseURIEncoded(svnURI);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }

        ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
        ISVNAuthenticationManager authManager = new BasicAuthenticationManager(username, password);
        clientManager = SVNClientManager.newInstance(
                (DefaultSVNOptions) options, authManager);
    }

    protected void validateParameters() {
        if (this.qualityReport != null) {
            this.svnURI = this.qualityReport.getProductInfo().getSvnUrl();
        }

        if (this.svnURI == null) {
            throw new BuildException("svnURI cann't be null.");
        }

        if (this.username == null) {
            throw new BuildException("username cann't be null.");
        }

        if (this.password == null) {
            throw new BuildException("password cann't be null.");
        }
    }

    protected abstract void checkParameters();
}
