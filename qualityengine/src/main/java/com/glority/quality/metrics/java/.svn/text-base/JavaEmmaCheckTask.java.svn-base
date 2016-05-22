package com.glority.quality.metrics.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.metrics.MetricsCheckBaseTask;
import com.glority.quality.model.Metric;

/**
 * JavaEmmaCheckTask.
 * 
 * @author liheping
 */
public class JavaEmmaCheckTask extends MetricsCheckBaseTask {
    public static final String EMMA_CLASS = "class";
    public static final String EMMA_METHOD = "method";
    public static final String EMMA_BLOCK = "block";
    public static final String EMMA_LINE = "line";

    private float metricClass;
    private float metricMethod;
    private float metricLine;
    private float metricBlock;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric line = new Metric();
        String metricName = MetricName.JAVA_EMMA_COVERAGE_LINE.toString();
        String thresholdString = getThreshold(metricName);
        line.setName(metricName);
        line.setNewValue(metricLine);
        line.setOldValue(thresholdString);
        line.setType(MetricType.METRIC_TYPE_COVERAGE);

        if (isFloat(thresholdString)) {
            // The fewer duplications means success, and more means fail
            float oldValue = Float.parseFloat(thresholdString);
            line.setResult(checkMetric(oldValue, metricLine,
                    MetricCompareMode.LARGER_BETTER));
        } else if (thresholdString != null) {
            // Report invalid threshold if it's not a number
            line.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        } else {
            line.setResult(MetricResult.METRIC_NULL);
        }
        metrics.add(line);

        Metric block = new Metric();
        block.setName(MetricName.JAVA_EMMA_COVERAGE_BLOCK.toString());
        block.setNewValue(metricBlock);
        block.setType(MetricType.METRIC_TYPE_COVERAGE);
        block.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(block);

        Metric method = new Metric();
        method.setName(MetricName.JAVA_EMMA_COVERAGE_METHOD.toString());
        method.setNewValue(metricMethod);
        method.setType(MetricType.METRIC_TYPE_COVERAGE);
        method.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(method);

        Metric clasz = new Metric();
        clasz.setName(MetricName.JAVA_EMMA_COVERAGE_CLASS.toString());
        clasz.setNewValue(metricClass);
        clasz.setType(MetricType.METRIC_TYPE_COVERAGE);
        clasz.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(clasz);

        return metrics;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void parseReport() {
        try {
            Document doc = (new SAXBuilder()).build(new File(getReportPath()));
            Element reportRoot = doc.getRootElement();
            Element dataElement = reportRoot.getChild("data");
            Element allElement = dataElement.getChild("all");
            List<Element> coverageMetrics = allElement.getChildren("coverage");

            for (int i = 0; i < coverageMetrics.size(); i++) {
                Element coverageElement = (Element) coverageMetrics.get(i);
                String type = coverageElement.getAttributeValue("type");
                String coverageType = type.substring(0, type.indexOf(", %"));
                String value = coverageElement.getAttributeValue("value");
                String percentValue = value.substring(0, value.indexOf("%"));
                float floatValue = Float.parseFloat(percentValue);
                if (EMMA_CLASS.equals(coverageType)) {
                    this.metricClass = floatValue;
                } else if (EMMA_METHOD.equals(coverageType)) {
                    this.metricMethod = floatValue;
                } else if (EMMA_BLOCK.equals(coverageType)) {
                    this.metricBlock = floatValue;
                } else {
                    this.metricLine = floatValue;
                }
            }

        } catch (Exception e) {
            getProject().log("Failed to parser emma report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public float getMetricClass() {
        return metricClass;
    }

    public void setMetricClass(float metricClass) {
        this.metricClass = metricClass;
    }

    public float getMetricMethod() {
        return metricMethod;
    }

    public void setMetricMethod(float metricMethod) {
        this.metricMethod = metricMethod;
    }

    public float getMetricLine() {
        return metricLine;
    }

    public void setMetricLine(float metricLine) {
        this.metricLine = metricLine;
    }

    public float getMetricBlock() {
        return metricBlock;
    }

    public void setMetricBlock(float metricBlock) {
        this.metricBlock = metricBlock;
    }
}
