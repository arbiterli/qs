package com.glority.qualityserver.metricengine;

import java.util.ArrayList;
import java.util.List;

import com.glority.qualityserver.web.model.MetricScoreFormula;

/**
 * ScoreItem stands for score node in metricEngine.xml.
 * 
 * @author liheping
 * 
 */
public class ScoreItem extends BasicItem implements Cloneable {

    private List<ExtendItem> itemList;

    private String data;
    private String dataType;

    private MetricScoreFormula formula;

    public ScoreItem(BasicItem item, String dataType, List<ExtendItem> itemList) {
        super(item);
        this.dataType = dataType;
        this.itemList = itemList;
        MetricFormulaGenerator formulaGenerator = ScoreGeneratorFactory.getFormulaGenerator(method);
        if (formulaGenerator != null) {
            formula = formulaGenerator.generateFormula(getName(), itemList);
        }
    }

    // public List<Object> getValues() {
    // LOGGER.debug("in score getValues : " + method);
    // int value = 0;
    // if (method != null) {
    // try {
    // value = MethodManager.calculateScore(this);
    // } catch (Exception e) {
    // LOGGER.error(e);
    // e.printStackTrace();
    // }
    // LOGGER.debug(value);
    // }
    //
    // List<Object> result = new ArrayList<Object>();
    // result.add(new Integer(value));
    //
    // return result;
    // }

    public List<ExtendItem> getItemList() {
        // try {
        // MethodManager.calculateScore(this);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        return this.itemList;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // private List<BasicItem> getReferedItem(List<String> refList) {
    // List<BasicItem> itemList = new ArrayList<BasicItem>();
    //
    // if (refList != null && !refList.isEmpty()) {
    // for (String ref : refList) {
    // BasicItem item = super.container.getItem(ref);
    // itemList.add(item);
    // }
    // }
    //
    // return itemList;
    // }

    public ScoreItem clone() {
        List<ExtendItem> newExtendItem = new ArrayList<ExtendItem>();
        if (this.itemList != null) {
            for (ExtendItem item : this.itemList) {
                newExtendItem.add(item.clone());
            }
        }
        ScoreItem scoreItem = new ScoreItem(super.clone(), this.dataType, newExtendItem);
        return scoreItem;
    }

    public MetricScoreFormula getFormula() {
        return formula;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
