package com.glority.common.connectors.nagios;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.htmlparser.util.ParserException;
import org.junit.Test;

public class NagiosConnectorTest extends NagiosConnector {
    public NagiosConnectorTest() {
        super(null, null, null, null);
    }

    private String pageHtml;

    @Override
    protected String getPageHtml(String relativePath) {
        return this.pageHtml;
    }

    public void setPageHtml(String pageHtml) {
        this.pageHtml = pageHtml;
    }

    @Test
    public void testGetNotifications() throws Exception {
        String inputPath = "testtasks" + File.separator + "res" + File.separator + "glority_nagios_notification.txt";
        InputStream inputStream = new FileInputStream(new File(inputPath));
        String html = IOUtils.toString(inputStream);

        NagiosConnectorTest test = new NagiosConnectorTest();
        test.setPageHtml(html);

        assertTrue(test.getServiceNotifications(0).size() == 4);
    }

    @Test
    public void testGetServiceOkRate() throws Exception {
        String inputPath = "testtasks" + File.separator + "res" + File.separator + "glority_nagios_okrate.txt";
        InputStream inputStream = new FileInputStream(new File(inputPath));
        String html = IOUtils.toString(inputStream);

        NagiosConnectorTest test = new NagiosConnectorTest();
        test.setPageHtml(html);

        assertTrue(test.getServiceOkRate() == 33.0d);
    }

    @Test
    public void testGetServiceStatus() throws Exception {
        String inputPath = "testtasks" + File.separator + "res" + File.separator + "glority_nagios_status.txt";
        InputStream inputStream = new FileInputStream(new File(inputPath));
        String html = IOUtils.toString(inputStream);

        NagiosConnectorTest test = new NagiosConnectorTest();
        test.setPageHtml(html);

        assertTrue(test.getServiceStatuses().size() == 2);
    }
}
