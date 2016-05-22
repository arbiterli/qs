package com.glority.common.connectors.nagios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.LogFactory;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.http.HttpConnector;

/**
 * NagiosConnector. this connector is only for connect to nagios.
 * 
 * @author Administrator
 * 
 */
public class NagiosConnector {
    private static final String OK_RATE_RELATIVE_PATH = "/cgi-bin/avail.cgi?show_log_entries";
    private static final String STATUS_RELATIVE_PATH = "/cgi-bin/status.cgi?";
    private static final String NOTIFICATION_RELATIVE_PATH = "/cgi-bin/notifications.cgi?type=0&archive=";

    private static final String STATUS_ATTEMPT = "^<TD CLASS=\'status.*</TD>$";
    private static final String ENTER = "\n";
    private static final String SERVICE_INDEXOF = "<A HREF=\'extinfo.cgi\\?type=2&host=";

    private static final int STATUS_STEP = 6;
    private static final int STATUS_CURRENT_STATUS = 1;
    private static final int STATUS_CURRENT_SERVICE = 0;
    private static final int STATUS_CURRENT_ATTEMPT = 4;

    private static final int NOTIFICATION_HOST = 1;
    private static final int NOTIFICATION_SERVICE = 2;
    private static final int NOTIFICATION_TYPE = 3;
    private static final int NOTIFICATION_TIME = 4;
    private static final int NOTIFICATION_CONTACT = 5;
    private static final int NOTIFICAIION_INFO = 7;

    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String username;
    private String password;
    private String baseUrl;
    private String host;

    public NagiosConnector(String baseUrl, String host, String username, String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.host = host;
    }

    /**
     * get service notifications for specified day. if day =0, return today's
     * notifications. if day =1, return yesterday's...
     * 
     * @param
     * @return
     * @throws ParserException
     * @throws ConnectorException
     */
    public List<ServiceNotification> getServiceNotifications(int day) throws ConnectorException {
        String relative = NOTIFICATION_RELATIVE_PATH + day + "&host=" + host;
        String html = getPageHtml(relative);

        List<ServiceNotification> result;
        try {
            result = parseServiceNotification(html);
            return result;
        } catch (ParserException e) {
            throw new ConnectorException(e.getMessage(), e);
        }
    }

    private List<ServiceNotification> parseServiceNotification(String html) throws ParserException {
        List<ServiceNotification> notifications = new ArrayList<ServiceNotification>();

        Parser parser = new Parser(html);
        NodeFilter filter = new HasAttributeFilter("class", "notifications");
        NodeList nodes = parser.extractAllNodesThatMatch(filter);
        Node root = nodes.elementAt(1);
        NodeList nodeList = root.getChildren();
        // here start with 2, to skip the body notifications class and table
        // notifications class.
        for (int i = 2; i < nodeList.size(); i++) {
            Node child = nodeList.elementAt(i);
            if (child.getChildren() != null && child.getChildren().size() > 0) {
                ServiceNotification notification = parseServiceNotification(child);
                if (notification != null) {
                    notifications.add(notification);
                }
            }
        }

        return notifications;
    }

    private ServiceNotification parseServiceNotification(Node node) {
        ServiceNotification notification = new ServiceNotification();
        NodeList nodeList = node.getChildren();
        for (int i = 0, j = 1; i < nodeList.size(); i++) {
            Node element = nodeList.elementAt(i);
            String text = element.toPlainTextString();
            if (text != null && !text.isEmpty() && text.length() > 1) {
                switch (j) {
                case NOTIFICATION_HOST:
                    notification.setHost(text);
                    break;
                case NOTIFICATION_SERVICE:
                    notification.setService(text);
                    break;
                case NOTIFICATION_TYPE:
                    notification.setType(text);
                    break;
                case NOTIFICATION_TIME:
                    Date date = null;
                    System.out.println(text);
                    try {
                        date = DF.parse(text);
                        notification.setTime(date);
                    } catch (Exception e) {
                        LogFactory.getLog(NagiosConnector.class).error(e.getMessage(), e);
                        return null;
                    }
                    break;
                case NOTIFICATION_CONTACT:
                    notification.setContact(text);
                    break;
                case NOTIFICAIION_INFO:
                    notification.setInfo(text);
                    break;
                default:
                    break;
                }
                j++;
            }
        }
        return notification;
    }

    public List<ServiceStatus> getServiceStatuses() throws ConnectorException {
        String relative = STATUS_RELATIVE_PATH + "&host=" + host;
        String html = getPageHtml(relative);
        try {
            return parseServiceStatuses(html);
        } catch (ParserException e) {
            throw new ConnectorException(e.getMessage(), e);
        }
    }

    /**
     * get statuses from html String.
     * 
     * @param html
     * @return list of Status
     * @throws ParserException
     */
    private List<ServiceStatus> parseServiceStatuses(String html) throws ParserException {
        String reg = "(" + STATUS_ATTEMPT + ")|(" + SERVICE_INDEXOF + ")";
        String subhtml = regexMath(html, reg);
        Parser parser = new Parser(subhtml);
        List<String> ret = new ArrayList<String>();
        for (NodeIterator i = parser.elements(); i.hasMoreNodes();) {
            Node node = i.nextNode();
            if (node.toPlainTextString().length() > 1) {
                ret.add(node.toPlainTextString());
            }
        }

        List<ServiceStatus> statuses = new ArrayList<ServiceStatus>();
        for (int i = 0; i + STATUS_CURRENT_ATTEMPT < ret.size(); i += STATUS_STEP) {
            ServiceStatus status = new ServiceStatus();
            status.setService(ret.get(i + STATUS_CURRENT_SERVICE));
            status.setStatus(ServiceStatus.Status.getValueOf(ret.get(i + STATUS_CURRENT_STATUS)));
            status.setAttempt(ret.get(i + STATUS_CURRENT_ATTEMPT));
            statuses.add(status);
        }
        return statuses;
    }

    private String regexMath(String html, String reg) {
        String[] tempString = html.split(ENTER);
        String retHtml = "";
        for (int i = 0; i < tempString.length; i++) {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(tempString[i]);
            if (matcher.find()) {
                tempString[i] = tempString[i].replace("</TR>", "");
                retHtml += tempString[i] + ENTER;
            }
        }
        return retHtml;
    }

    /**
     * get service Ok rate from nagios page. if no data, return null.
     * 
     * @return ok rate, unit is percent. eg 99.00% return 99.00.
     * @throws ParserException
     * @throws ConnectorException
     */
    public double getServiceOkRate() throws ConnectorException {
        String relative = OK_RATE_RELATIVE_PATH + "&host=" + host;
        String html = getPageHtml(relative);
        try {
            String rateStr = parseServiceOkRate(html);
            return Double.valueOf(rateStr);
        } catch (Exception e) {
            throw new ConnectorException(e.getMessage(), e);
        }
    }

    /**
     * parse service ok rate from html string.
     * 
     * @param html
     * @return okrate
     * @throws ParserException
     */

    private String parseServiceOkRate(String html) throws ParserException {
        Parser parser = new Parser(html);
        NodeFilter filter = new HasAttributeFilter("class", "serviceOK");
        NodeList nodes = parser.extractAllNodesThatMatch(filter);
        if (nodes.size() > 0) {
            String ret = nodes.elementAt(nodes.size() - 1).toPlainTextString();
            return ret.split("%")[0];
        }
        return null;
    }

    /**
     * this method is protected for test.
     * 
     * @param relativePath
     * @return
     * @throws ConnectorException
     */
    protected String getPageHtml(String relativePath) throws ConnectorException {
        String url = this.baseUrl + relativePath;
        HttpConnector connector = new HttpConnector(this.username, this.password);
        return connector.doGet(url);
    }

}
