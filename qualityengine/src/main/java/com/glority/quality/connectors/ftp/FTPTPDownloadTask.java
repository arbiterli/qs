package com.glority.quality.connectors.ftp;

import com.glority.common.connectors.ConnectorException;

/**
 * To download files from task report FTP Server.
 * 
 * @author zm
 * 
 */
public class FTPTPDownloadTask extends FTPTPBaseTask {

    @Override
    protected void doWithConnector() throws ConnectorException {
        super.prepareRemoteEnv();
        super.connector.download(super.remotePath, super.localPath);
    }

}
