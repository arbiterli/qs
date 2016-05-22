package com.glority.quality.connectors.ftp;

import com.glority.common.connectors.ConnectorException;

/**
 * to do ftp common upload.
 * 
 * @author zm.
 * 
 */
public class FTPCommonUploadTask extends FTPBaseTask {

    @Override
    protected void doWithConnector() throws ConnectorException {
        super.connector.upload(super.localPath, super.remotePath);
    }

}
