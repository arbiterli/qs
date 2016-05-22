package com.glority.quality.connectors.supportdb;

/**
 * this class do with the std email template for server, whith send to operation
 * db.
 * 
 * @author Li.heping
 * 
 */
public class StdEmailContent {
    public static final String PRODUCT_NAME = "Product Name";
    public static final String SERVER_NAME = "Server Name";
    public static final String INFO = "Info";
    public static final String TYPE = "Type";

    public static final String DIVISION = ": ";
    public static final String LINE_FEED = "\n";

    public static final String BRACKET_L = "[";
    public static final String BRACKET_R = "]";

    private String title;
    private String productName;
    private String serverName;
    private String info;
    private String type;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmailContent() {
        return getEmailContent(this);
    }

    public static String getEmailContent(StdEmailContent content) {
        StringBuffer sb = new StringBuffer();
        sb.append(PRODUCT_NAME).append(DIVISION).append(content.productName).append(LINE_FEED);
        sb.append(SERVER_NAME).append(DIVISION).append(content.serverName).append(LINE_FEED);
        sb.append(INFO).append(DIVISION).append(content.info).append(LINE_FEED);
        sb.append(TYPE).append(DIVISION).append(content.type);
        return sb.toString();
    }

    public String getFomartTitle() {
        return getTitle(this);
    }

    public static String getTitle(StdEmailContent content) {
        StringBuffer sb = new StringBuffer();
        sb.append(BRACKET_L).append(content.type).append(BRACKET_R).append(" ");
        sb.append(BRACKET_L).append(content.productName).append(BRACKET_R).append(" ");
        sb.append(BRACKET_L).append(content.serverName).append(BRACKET_R).append(" ");
        sb.append(content.title);
        return sb.toString();
    }

    public static StdEmailContent parseStdEmailContent(String title, String text) {
        StdEmailContent content = new StdEmailContent();

        if (title != null) {
            if (validateStdEmailTitle(title)) {
                content.title = title.substring(title.lastIndexOf(BRACKET_R) + 1).trim();
            } else {
                return null;
            }
        }

        if (text != null) {
            if (validateStdEmailText(text)) {
                String[] textProps = text.split(LINE_FEED);
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

    private static void setProp(StdEmailContent content, String[] propValuePair) {
        if (propValuePair.length != 2) {
            return;
        }

        if (propValuePair[0].equals(PRODUCT_NAME)) {
            content.productName = propValuePair[1].trim();
        } else if (propValuePair[0].equals(SERVER_NAME)) {
            content.serverName = propValuePair[1].trim();
        } else if (propValuePair[0].equals(INFO)) {
            content.info = propValuePair[1].trim();
        } else if (propValuePair[0].equals(TYPE)) {
            content.type = propValuePair[1].trim();
        }
    }

    public static boolean validateStdEmailText(String text) {
        if (text == null) {
            return false;
        }

        if (!text.contains(PRODUCT_NAME + DIVISION)) {
            return false;
        }

        if (!text.contains(SERVER_NAME + DIVISION)) {
            return false;
        }

        if (!text.contains(INFO + DIVISION)) {
            return false;
        }

        if (!text.contains(TYPE + DIVISION)) {
            return false;
        }

        return true;
    }

    public static boolean validateStdEmailTitle(String title) {
        if (title != null) {
            int lIndex = title.indexOf(BRACKET_L);
            int rIndex = title.indexOf(BRACKET_R);
            if (lIndex == 0 && rIndex > 0) {
                return true;
            }
        }

        return false;
    }
}
