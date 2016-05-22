package com.glority.qualityserver.metricengine;

import java.util.List;


/**
 * DataItem stands for data tag in metricEngine.xml.
 * 
 * @author liheping
 * 
 */
public class DataItem extends BasicItem implements Cloneable {
    public static final String DATA_TYPE_CONSTANT = "constant";
    public static final String DATA_TYPE_DATE = "date";

    private String type;
    private double getScore;
    private String value;
    private List<ExtendItem> itemList;

    public DataItem(BasicItem item, String type, String value, double getScore, List<ExtendItem> itemList) {
        super(item);
        this.type = type;
        this.getScore = getScore;
        this.value = value;
        this.itemList = itemList;
    }

    public double getGetScore() {
        return getScore;
    }

    public String getValue() {
        return value;
    }

    public List<ExtendItem> getItemList() {
        return itemList;
    }

    public DataItem clone() {
        return new DataItem(super.clone(), this.type, this.value, this.getGetScore(), this.itemList);

    }

}
