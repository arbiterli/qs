package com.glority.quality.connectors.svn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.wc.ISVNDiffStatusHandler;
import org.tmatesoft.svn.core.wc.SVNDiffClient;
import org.tmatesoft.svn.core.wc.SVNDiffStatus;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNStatusType;

/**
 * to svn diff operation.
 * 
 * @author zm.
 * 
 */
public class SVNDiffTask extends SVNBaseTask {

    private String revisionOld;
    private String revisionNew;
    private List<String> diffs;

    private static final String ADD_TAG = "added : ";
    private static final String DELETE_TAG = "deleted : ";
    private static final String MODIFIED_TAG = "modified : ";

    public void setRevisionOld(String revisionOld) {
        this.revisionOld = revisionOld;
    }

    public void setRevisionNew(String revisionNew) {
        this.revisionNew = revisionNew;
    }

    @Override
    protected void checkParameters() {
        if (null == revisionOld) {
            throw new BuildException("revision old cann't be null.");
        }

        if (null == revisionNew) {
            throw new BuildException("revision new cann't be null.");
        }
    }

    @Override
    public void process() {
        svnConnect();
        diffs = new ArrayList<String>();
        SVNDiffClient diffClient = clientManager.getDiffClient();
        final List<String> addedList = new LinkedList<String>();
        final List<String> deletedList = new LinkedList<String>();
        final List<String> modifiedList = new LinkedList<String>();

        try {
            diffClient.doDiffStatus(repositoryURL,
                    SVNRevision.create(Long.parseLong(revisionOld)),
                    repositoryURL,
                    SVNRevision.create(Long.parseLong(revisionNew)),
                    SVNDepth.INFINITY, true, new ISVNDiffStatusHandler() {
                        public void handleDiffStatus(SVNDiffStatus diffStatus) {
                            if (diffStatus.getKind() == SVNNodeKind.FILE) {
                                SVNStatusType status = diffStatus
                                        .getModificationType();
                                String path = diffStatus.getPath();
                                if (status == SVNStatusType.STATUS_ADDED) {
                                    addedList.add(ADD_TAG + path);
                                }

                                if (status == SVNStatusType.STATUS_DELETED) {
                                    deletedList.add(DELETE_TAG + path);
                                }

                                if (status == SVNStatusType.STATUS_MODIFIED) {
                                    modifiedList.add(MODIFIED_TAG + path);
                                }
                            }
                        }
                    });
            mergeDiffs(modifiedList, addedList, deletedList);
        } catch (SVNException e) {
            throw new BuildException(e.getMessage());
        }
    }

    /**
     * to get diffs.
     * @return a list of diffs.
     */
    public List<String> getDiffs() {
        return this.diffs;
    }

    /**
     * to merge all diffs.
     * @param mList modified.
     * @param aList added.
     * @param dList deleted.
     */
    private void mergeDiffs(List<String> mList, List<String> aList,
            List<String> dList) {
        for (String diff : mList) {
            diffs.add(diff);
            getProject().log(diff);
        }

        for (String diff : aList) {
            diffs.add(diff);
            getProject().log(diff);
        }

        for (String diff : dList) {
            diffs.add(diff);
            getProject().log(diff);
        }
    }
}
