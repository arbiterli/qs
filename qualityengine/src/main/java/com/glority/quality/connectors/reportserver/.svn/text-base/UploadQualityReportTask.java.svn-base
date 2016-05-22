package com.glority.quality.connectors.reportserver;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.http.HttpConnector;
import com.glority.quality.BaseTask;

/**
 * The task to upload quality.xml to quality portal.
 * 
 * @author XQS
 * 
 */
public class UploadQualityReportTask extends BaseTask {

    private String qualityXmlUploadURL;

    @Override
    public void process() throws UnsupportedEncodingException, ConnectorException {
        HttpConnector connector = new HttpConnector();

        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("xml", new FileBody(new File(qualityXmlPath)));
        reqEntity.addPart("comment", new StringBody("Quality XML"));

        connector.doMultipartPost(qualityXmlUploadURL, reqEntity);
    }

    public void setQualityXmlUploadURL(String qualityXmlUploadURL) {
        this.qualityXmlUploadURL = qualityXmlUploadURL;
    }
}
