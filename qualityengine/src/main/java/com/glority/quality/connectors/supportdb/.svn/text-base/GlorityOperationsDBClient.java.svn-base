/**
 * 
 */
package com.glority.quality.connectors.supportdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.http.HttpConnector;
import com.glority.quality.Constants.SupportTicketStatus;
import com.glority.quality.constants.SupportTicketType;
import com.glority.quality.constants.Ticket;
import com.glority.quality.model.SupportTicket;
import com.glority.quality.xml.XmlUtils;

/**
 * . GlorityOperationsDBClient.
 * 
 * @author CLB
 * 
 */
public class GlorityOperationsDBClient implements SupportDBClient {
    private static final Logger LOGGER = Logger.getLogger(GlorityOperationsDBClient.class);
    private String baseUrl;
    private String userName;
    private String password;
    public static final String RELATIVE_PATH = "/spaces/glority-operations/tickets/report/0.xml";
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    protected String xmlContent;

    public GlorityOperationsDBClient() {
    }

    /**
     * construct.
     * 
     * @param baseUrl
     *            the baseUrl to set.
     * @param userName
     *            the userName to set.
     * @param password
     *            the password to set.
     */
    public GlorityOperationsDBClient(String baseUrl, String userName, String password) {
        this.baseUrl = baseUrl;
        this.userName = userName;
        this.password = password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * init the xmlcontent for support ticket parse. this method is marked
     * protected for test purpose.
     * @throws ConnectorException
     */
    protected void initClient() throws ConnectorException {
        String url = baseUrl + RELATIVE_PATH;
        this.xmlContent = new HttpConnector(userName, password).doGet(url);
    }

    /**
     * get date by format.
     * 
     * @param dateString
     *            the dateString.
     * @param format
     *            the format.
     * @return date time.
     */
    private Date getDateByFormat(String dateString, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return null;
    }

    /**
     * get support ticket from xmldom. only parse nagios and server created
     * ticket.
     * 
     * @param element
     *            the element.
     * @return supportTicket.
     */
    private SupportTicket getSupportTicket(Element element) {
        String title = XmlUtils.getXmlNodeValueByNameTag(element, Ticket.SUMMARY.toString());
        String content = XmlUtils.getXmlNodeValueByNameTag(element, Ticket.DESCRIPTION.toString());
        String statusStr = XmlUtils.getXmlNodeValueByNameTag(element, Ticket.STATUS_NAME.toString());
        String createOnStr = XmlUtils.getXmlNodeValueByNameTag(element, Ticket.CREATE_ON.toString());

        SupportTicketStatus status = SupportTicketStatus.getValueOf(statusStr);
        Date createOn = this.getDateByFormat(createOnStr, DATE_FORMAT);

        SupportTicket supportTicket = new SupportTicket();
        supportTicket.setCreateOn(createOn);
        supportTicket.setStatus(status);
        supportTicket.setContent(content);

        StdEmailContent stdContent = StdEmailContent.parseStdEmailContent(title, content);
        if (stdContent != null) {
            supportTicket.setTitle(stdContent.getTitle());
            supportTicket.setProduct(stdContent.getProductName());
            supportTicket.setSystem(stdContent.getServerName());
            supportTicket.setType(SupportTicketType.QUALITY_SERVER);
            return supportTicket;
        }

        NagiosEmailContent nagiosContent = NagiosEmailContent.parseNagiosEmailContent(title, content);
        if (nagiosContent != null) {
            supportTicket.setTitle(nagiosContent.getTitle());
            supportTicket.setProduct(nagiosContent.getHost());
            supportTicket.setSystem(nagiosContent.getService());
            supportTicket.setType(SupportTicketType.NAGIOS);
            return supportTicket;
        }

        return null;
    }

    @Override
    public List<SupportTicket> get() {
        List<SupportTicket> supportTicketList = new ArrayList<SupportTicket>();
        try {
            // parse ticket from xml content.
            Element root = XmlUtils.makeDomTree(this.xmlContent);
            NodeList nodeList = root.getElementsByTagName(Ticket.TICKET.toString());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                supportTicketList.add(getSupportTicket(element));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            LOGGER.error("return empty List");
            supportTicketList.clear();
        }

        return supportTicketList;
    }
}
