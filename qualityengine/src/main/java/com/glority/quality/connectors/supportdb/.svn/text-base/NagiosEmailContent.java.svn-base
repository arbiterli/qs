package com.glority.quality.connectors.supportdb;

/**
 * this class do with the exist nagios email which send to operation db.
 * 
 * @author Li.heping
 * 
 */
public class NagiosEmailContent {
    /**
     * **** Nagios *****
     * 
     * Notification Type: RECOVERY
     * 
     * Service: Portal Server Host: quality.glority.com Address:
     * quality.glority.com State: OK info: ###
     * 
     * Date/Time: Thu Dec 6 13:09:11 CST 2012
     */

    public static final String LINE_FEED = "\n";
    public static final String NAGIOS_EMAIL_TEXT_FLAG = "**** Nagios *****";
    public static final String NAGIOS_EMAIL_TITLE_FLAG = "**";
    public static final String DIVISION = ": ";

    public static final String TYPE = "Notification Type";
    public static final String SERVICE = "Service";
    public static final String HOST = "Host";
    public static final String ADDRESS = "Address";
    public static final String STATE = "State";
    public static final String INFO = "info";

    private String title;
    private String type;
    private String service;
    private String host;
    private String address;
    private String status;
    private String info;

    /**
     * if not valid content, return null;
     * 
     * @param title
     * @param text
     * @return
     */
    public static NagiosEmailContent parseNagiosEmailContent(String title, String text) {
        NagiosEmailContent content = new NagiosEmailContent();

        if (title != null) {
            if (validateNagiosEmailTitle(title)) {
                content.title = title;
            } else {
                return null;
            }
        }

        if (text != null) {
            if (validateNaigosEmailText(text)) {
                String pText = text.replace(NAGIOS_EMAIL_TEXT_FLAG, "").trim();
                String[] textProps = pText.split(LINE_FEED);
                for (String prop : textProps) {
                    String[] propValuePair = prop.trim().split(DIVISION);
                    setProp(content, propValuePair);
                }
            } else {
                return null;
            }
        }
        return content;
    }

    private static void setProp(NagiosEmailContent content, String[] propValuePair) {
        if (propValuePair.length != 2) {
            return;
        }

        if (propValuePair[0].equals(TYPE)) {
            content.type = propValuePair[1];
        } else if (propValuePair[0].equals(SERVICE)) {
            content.service = propValuePair[1];
        } else if (propValuePair[0].equals(HOST)) {
            content.host = propValuePair[1];
        } else if (propValuePair[0].equals(ADDRESS)) {
            content.address = propValuePair[1];
        } else if (propValuePair[0].equals(STATE)) {
            content.status = propValuePair[1];
        } else if (propValuePair[0].equals(INFO)) {
            content.info = propValuePair[1];
        }
    }

    public static boolean validateNaigosEmailText(String text) {
        if (text == null) {
            return false;
        } else if (!text.contains(NAGIOS_EMAIL_TEXT_FLAG)) {
            return false;
        }
        return true;
    }

    public static boolean validateNagiosEmailTitle(String title) {
        if (title == null) {
            return false;
        } else if (!title.contains(NAGIOS_EMAIL_TITLE_FLAG)) {
            return false;
        }

        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
