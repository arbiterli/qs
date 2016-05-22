package com.glority.quality.connectors.testrail;

import java.util.List;

import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.BaseTask;
import com.glority.quality.model.TestCase;

/**
 * the testrail base class.
 * @author zm
 * 
 */
public abstract class TestrailBase extends BaseTask {

    /**
     * the testrail server.
     */
    protected String testrailServer;
    /**
     * the testrail key.
     */
    protected String testrailKey;
    /**
     * the adapter.
     */
    protected TestrailAdapter adapter;
    /**
     * a list of returned test cases.
     */
    protected List<TestCase> resultTC;

    public String getTestrailServer() {
        return testrailServer;
    }

    public void setTestrailServer(final String server) {
        this.testrailServer = server;
    }

    public String getTestrailKey() {
        return testrailKey;
    }

    public void setTestrailKey(final String key) {
        this.testrailKey = key;
    }

    /**
     * to config adapter.
     */
    protected void configAdapter() {
        adapter = new TestrailAdapterImpl();
        adapter.config(testrailServer, testrailKey);
    }

    /**
     * Set the testrailAdapter.
     * @param adapter the adapter to set.
     */
    public void setTestrailAdapter(TestrailAdapter adapter) {
        if (testrailServer == null || testrailKey == null) {
            throw new IllegalStateException("The testrailServer and testrailKey should be set.");
        }
        this.adapter = adapter;
        this.adapter.config(testrailServer, testrailKey);
    }

    /**
     * to get the test cases.
     * @return a list of test cases.
     * @throws BuildException
     */
    public List<TestCase> getTestCases() {
        if (resultTC == null) {
            throw new BuildException("Haven't execute process function.");
        }
        return resultTC;
    }

    @Override
    public abstract void process() throws ConnectorException;

}
