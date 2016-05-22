package com.glority.quality.connectors.ftp;

import com.glority.common.connectors.ConnectorException;

/**
 * To upload files to task report FTP server.
 * 
 * @author zm.
 * 
 */
public class FTPTPUploadTask extends FTPTPBaseTask {

    @Override
    protected void doWithConnector() throws ConnectorException {
        super.prepareRemoteEnv();
        super.connector.upload(super.localPath, super.remotePath);
    }

}
