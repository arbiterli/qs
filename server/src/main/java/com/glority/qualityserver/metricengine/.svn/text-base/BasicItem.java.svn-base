package com.glority.qualityserver.metricengine;

/**
 * basic item is the base class for the item parsed from metricEngine.xml.
 * 
 * @author liheping
 * 
 */
public class BasicItem implements Cloneable {
    protected String id;
    protected String name;
    protected DisplayType display;
    /**
     * The method to calculate item value.
     */
    protected String method;
    /**
     * The link to the report where we got the metric.
     */
    protected String link;
    /**
     * The link to the page where we hold the related documents about the
     * metric.
     */
    protected String doc;

    /**
     * The language of the metric, like JAVA, CPP. this can be empty.
     */
    protected String lang;

    /**
     * The default owner role.
     */
    protected String role;

    /**
     * the unit for metric.
     */
    protected String unit;

    /**
     * the expected value, or domain.
     */
    protected String expected;

    public BasicItem() {

    }

    public BasicItem(BasicItem item) {
        this.id = item.id;
        this.name = item.name;
        this.display = item.display;
        this.link = item.link;
        this.doc = item.doc;
        this.method = item.method;
        this.role = item.role;
        this.unit = item.unit;
        this.expected = item.expected;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public BasicItem clone() {
        return new BasicItem(this);
    }

}
