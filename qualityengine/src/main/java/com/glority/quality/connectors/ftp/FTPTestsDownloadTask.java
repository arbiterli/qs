package com.glority.quality.connectors.ftp;

import com.glority.common.connectors.ConnectorException;

/**
 * FTPTestsDownloadTask.
 * 
 * @author zm.
 * 
 */
public class FTPTestsDownloadTask extends FTPTestsBaseTask {

    @Override
    protected void doWithConnector() throws ConnectorException {
        super.prepareRemoteEnv();
        super.connector.download(super.remotePath, super.localPath);
    }

}
