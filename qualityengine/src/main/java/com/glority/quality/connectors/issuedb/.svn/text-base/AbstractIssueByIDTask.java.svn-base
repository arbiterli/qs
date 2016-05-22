package com.glority.quality.connectors.issuedb;

import com.glority.quality.model.Issue;

/**
 * The task to get an issue object from issue db with specified issue ID.
 * 
 * @author XQS
 * 
 */
public abstract class AbstractIssueByIDTask extends AbstractIssueBaseTask {
    /**
     * Iusse ID of the issue we want to get.
     */
    protected String issueID;

    /**
     * Get the issue with the specified issue ID from the issue db.
     * 
     * @return
     */
    public abstract Issue getIssue();

    public String getIssueID() {
        return issueID;
    }

    public void setIssueID(String issueID) {
        this.issueID = issueID;
    }
}
