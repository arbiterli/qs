package com.glority.quality.connector.supportdb;

import com.glority.quality.connectors.supportdb.GlorityOperationsDBClient;

public class TGlorityOperationsDBClient extends GlorityOperationsDBClient {
    private String xmlString;

    @Override
    protected void initClient() {
        super.xmlContent = this.xmlString;
    }

    public void setXmlString(String xmlString) {
        this.xmlString = xmlString;
    }
}
