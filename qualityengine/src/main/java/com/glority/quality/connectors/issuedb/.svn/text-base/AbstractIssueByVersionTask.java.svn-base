package com.glority.quality.connectors.issuedb;

import java.util.List;

import com.glority.quality.model.Issue;

/**
 * Get all the issues in a specified version.
 * @author XQS
 * 
 */
public abstract class AbstractIssueByVersionTask extends AbstractIssueBaseTask {
    /**
     * The version of the product.
     */
    protected String version;

    /**
     * Get all issues in the specified version.
     * 
     * @return the full list of the issues in the specified version. all issues
     *         in the list should have all fields well translated
     */
    public abstract List<Issue> getAllIssues();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
