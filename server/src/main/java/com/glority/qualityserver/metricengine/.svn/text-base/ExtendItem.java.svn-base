package com.glority.qualityserver.metricengine;

/**
 * ExtendItem class stands for one display score item.
 * 
 * @author liheping
 * 
 */
public class ExtendItem {
    private BasicItem basicItem;

    private double power;
    private double score;
    private String data;
    private double rateScore;
    private double rate;
    private String exists;
    private DisplayType display;

    public ExtendItem clone() {
        ExtendItem item = new ExtendItem();
        item.basicItem = this.basicItem.clone();
        item.power = this.power;
        item.score = this.score;
        item.data = this.data;
        item.rateScore = this.rateScore;
        item.rate = this.rate;
        item.display = this.display;
        item.exists = this.exists;
        return item;
    }

    public double getRateScore() {
        return rateScore;
    }

    public void setRateScore(double rateScore) {
        this.rateScore = rateScore;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public BasicItem getBasicItem() {
        return basicItem;
    }

    public void setBasicItem(BasicItem basicItem) {
        this.basicItem = basicItem;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    public String getExists() {
        return exists;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }
}
