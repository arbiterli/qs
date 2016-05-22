package com.glority.quality.connectors.ftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.ftp.FTPConnector;
import com.glority.common.connectors.ftp.FTPLogger;
import com.glority.quality.BaseTask;

/**
 * 
 * The base task of all the FTP operation.
 * 
 * @author zm
 * 
 */
public abstract class FTPBaseTask extends BaseTask {
    private int port = FTPConnector.DEFAULT_PORT;

    protected Log log = LogFactory.getLog(this.getClass());
    private String server;
    private String username;
    private String password;;

    protected String localPath;
    protected String remotePath;

    protected FTPConnector connector;

    public void setServer(String server) {
        this.server = server;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    @Override
    public void process() {
        this.connector = new FTPConnector(this.server, this.port, this.username, this.password);
        FTPLogger connectorlog = new FTPLog(this, log);
        this.connector.setLog(connectorlog);

        try {
            this.doWithConnector();
        } catch (ConnectorException e) {
            throw new BuildException(e.getMessage(), e);
        }

    }

    protected abstract void doWithConnector() throws ConnectorException;

}
