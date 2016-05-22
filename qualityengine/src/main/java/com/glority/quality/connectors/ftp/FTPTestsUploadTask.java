package com.glority.quality.connectors.ftp;

import com.glority.common.connectors.ConnectorException;

/**
 * FTPTestsUploadTask.
 * 
 * @author zm.
 * 
 */
public class FTPTestsUploadTask extends FTPTestsBaseTask {

    @Override
    protected void doWithConnector() throws ConnectorException {
        super.prepareRemoteEnv();
        super.connector.upload(super.localPath, super.remotePath);
    }

}
