package com.glority.qualityserver.metricengine;

/**
 * MetricItem stands for metric node in metricEngine.xml.
 * 
 * @author liheping
 * 
 */
public class MetricItem extends BasicItem implements Cloneable {
    private String metricName;
    private String metricType;

    public MetricItem(BasicItem item, String metricType, String metricName) {
        super(item);
        this.metricName = metricName;
        this.metricType = metricType;
    }

    public MetricItem clone() {
        return new MetricItem(this, this.metricType, this.metricName);
    }

    public String getMetricName() {
        return metricName;
    }

    public String getMetricType() {
        return metricType;
    }
}
