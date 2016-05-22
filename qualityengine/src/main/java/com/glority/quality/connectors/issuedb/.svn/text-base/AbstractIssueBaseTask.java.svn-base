package com.glority.quality.connectors.issuedb;

import com.glority.quality.BaseTask;
import com.glority.quality.Constants.IssueDB;

/**
 * This is the base task for issue db connectors. like Assembla, Jira, etc It
 * will collect info from issue db that needed for quality system.
 * 
 * @author XQS
 * 
 */
public abstract class AbstractIssueBaseTask extends BaseTask {
    /**
     * The name of the product.
     */
    protected String productName;
    /**
     * The type of the issue DB.
     */
    protected IssueDB issueDB;

    /**
     * The user name of the issue DB.
     */
    protected String userName;

    /**
     * The password of the issue DB.
     */
    protected String password;

    /**
     * The base url address of the issue DB.
     */
    protected String baseURL;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public IssueDB getIssueDB() {
        return issueDB;
    }

    public void setIssueDB(IssueDB issueDB) {
        this.issueDB = issueDB;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

}
