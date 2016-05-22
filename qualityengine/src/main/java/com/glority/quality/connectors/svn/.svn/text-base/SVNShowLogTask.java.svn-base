package com.glority.quality.connectors.svn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;

import com.glority.quality.model.SVNLog;

/**
 * to do svn show log operation.
 * 
 * @author zm
 * 
 */
public class SVNShowLogTask extends SVNBaseTask {

    private List<SVNLog> svnLogs;
    private static final String SVN_PREFIX = "svn";

    public List<SVNLog> getSvnLogs() {
        return svnLogs;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void process() {
        validateParameters();
        SVNRepository repository = null;
        try {
            if (svnURI.startsWith(SVN_PREFIX)) {
                repository = SVNRepositoryFactoryImpl.create(SVNURL
                        .parseURIEncoded(svnURI));
            } else {
                repository = DAVRepositoryFactory.create(SVNURL
                        .parseURIEncoded(svnURI));
            }
            ISVNAuthenticationManager authManager = new BasicAuthenticationManager(username, password);
            repository.setAuthenticationManager(authManager);
            Collection<SVNLogEntry> logEntries = null;
            logEntries = repository.log(new String[] { "" }, null, 0, -1, true,
                    true);
            svnLogs = new ArrayList<SVNLog>();
            for (Iterator<SVNLogEntry> entries = logEntries.iterator(); entries
                    .hasNext();) {
                SVNLogEntry logEntry = (SVNLogEntry) entries.next();
                SVNLog log = new SVNLog();
                log.setAuthor(logEntry.getAuthor());
                log.setMessage(logEntry.getMessage());
                log.setRevision(logEntry.getRevision());
                log.setDate(logEntry.getDate());
                svnLogs.add(log);
            }
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }
    }

    @Override
    protected void checkParameters() {

    }
}
