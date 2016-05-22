package com.glority.quality.connectors.assembla;

import java.util.ArrayList;
import java.util.List;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.assembla.AssemblaConnector;
import com.glority.common.connectors.assembla.AssemblaIssue;
import com.glority.quality.connectors.issuedb.AbstractIssueByVersionTask;
import com.glority.quality.model.Issue;

/**
 * 
 * AssemblaIssueByVersionTask allows you to get a list of issue from assembla.
 * system by a specified version.
 * 
 * @author CLB.
 * 
 */
public class AssemblaIssueByVersionTask extends AbstractIssueByVersionTask {

    private List<Issue> issueList;

    @Override
    public List<Issue> getAllIssues() {
        return issueList;
    }

    @Override
    public void process() throws ConnectorException {
        AssemblaConnector conn = new AssemblaConnector(userName, password, productName);
        List<AssemblaIssue> issues = conn.getIssuesByMilestone(version);
        issueList = convertIssue(issues);

        writeIssueListToLog(this.issueList);
    }

    private List<Issue> convertIssue(List<AssemblaIssue> assemblaIssues) {
        List<Issue> issues = new ArrayList<Issue>(assemblaIssues.size());
        for (AssemblaIssue assemblaIssue : assemblaIssues) {
            Issue issue = new Issue();
            issue.setId(Integer.toString(assemblaIssue.getId()));
            issue.setTitle(assemblaIssue.getSummary());
            issue.setVersion(version);
            // TODO: mapping the fillowing fields
//            issue.setPriority(priority);
//            issue.setStatus(status);
//            issue.setType(type);
            issues.add(issue);
        }
        return issues;
    }

    /**
     * 
     * write the specified issueList got from the assembla system to log.
     * 
     * @param issueList
     *            .
     * 
     */
    private void writeIssueListToLog(List<Issue> issueList) {
        if (verbose) {
            for (Issue issue : issueList) {
                getProject().log(
                        "ID: " + issue.getId() + " Status: "
                                + issue.getStatus() + " Priority: "
                                + issue.getPriority() + " Version: "
                                + issue.getVersion() + " Type: "
                                + issue.getType() + " Title: "
                                + issue.getTitle() + " TestCases:"
                                + issue.getTestCases());
            }
        } else {
            getProject().log("Get " + issueList.size() + " issues");
        }
    }
}
