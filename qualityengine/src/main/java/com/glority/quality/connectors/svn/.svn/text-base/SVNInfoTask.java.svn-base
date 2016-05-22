package com.glority.quality.connectors.svn;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;

/**
 * to do like svn info.
 * 
 * @author zm
 * 
 */
public class SVNInfoTask extends SVNBaseTask {

    /**
     * the local path.
     */
    private String localPath;

    private String url;

    private String curRevision;

    private File wcPath;

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    @Override
    protected void checkParameters() {
        if (null == localPath) {
            throw new BuildException("localPath cann't be null.");
        }
        wcPath = new File(localPath);
        if (!wcPath.exists()) {
            throw new BuildException("local path file doesn't exist.");
        }
    }

    @Override
    public void process() {
        checkParameters();
        svnConnect();
        try {
            SVNInfo info = clientManager.getWCClient().doInfo(wcPath,
                    SVNRevision.WORKING);
            url = info.getURL().toString();
            curRevision = info.getCommittedRevision().toString();
            getProject().log(
                    "URL : " + url + "\n" + "revision : " + curRevision);
            checkAndModifyQualityXML();
            qualityReport.writeToFile(qualityXmlPath);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        } catch (Exception e) {
            throw new BuildException(e.getMessage());
        }
    }

    /**
     * to check and modify quality xml.
     */
    private void checkAndModifyQualityXML() {
        String qualitySvnUrl = qualityReport.getProductInfo().getSvnUrl();
        String qualitySvnRevision = qualityReport.getProductInfo()
                .getSvnRevision();
        if (!url.endsWith(qualitySvnUrl)) {
            getProject().log(
                    "Warnning: svnurl in quality.xml is not the real one.");
            this.qualityReport.getProductInfo().setSvnUrl(url);
            getProject()
                    .log("Change svn url from " + qualitySvnUrl + " to " + url
                            + ".");
        }

        if (!curRevision.equals(qualitySvnRevision)) {
            qualityReport.getProductInfo().setSvnRevision(curRevision);
            getProject().log(
                    "Change svn revision from " + qualitySvnRevision + " to "
                            + curRevision + ".");
        }
    }

}
