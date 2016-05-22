package com.glority.quality.metrics.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.tools.ant.BuildException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.metrics.MetricsCheckBaseTask;
import com.glority.quality.model.Metric;

/**
 * JavaCheckStyleCheckTask.
 * 
 * @author
 */
public class JavaCheckStyleCheckTask extends MetricsCheckBaseTask {
    public static final String CHECKSTYEL_ERROR = "error";
    private int metricCheckstyleError;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric ce = new Metric();
        String metricName = MetricName.JAVA_CHECKSTYLE.toString();
        String thresholdString = getThreshold(metricName);
        ce.setName(metricName);
        ce.setNewValue(metricCheckstyleError);
        ce.setOldValue(thresholdString);
        ce.setType(MetricType.METRIC_TYPE_LINT);

        if (isInt(thresholdString)) {
            // The fewer duplications means success, and more means fail
            float oldValue = Integer.parseInt(thresholdString);
            ce.setResult(checkMetric(oldValue, metricCheckstyleError,
                    MetricCompareMode.SMALLER_BETTER));
        } else if (thresholdString != null) {
            // Report invalid threshold if it's not a number
            ce.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        } else {
            ce.setResult(MetricResult.METRIC_NULL);
        }
        metrics.add(ce);

        return metrics;
    }

    @Override
    public void parseReport() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(this.getReportPath()));
            doc.getDocumentElement().normalize();
            NodeList errorNodes = doc.getElementsByTagName(CHECKSTYEL_ERROR);
            metricCheckstyleError = errorNodes.getLength();

        } catch (Exception e) {
            getProject().log("Failed to parser checkstyle report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricCheckstyleError() {
        return metricCheckstyleError;
    }

    public void setMetricCheckstyleError(int metricCheckstyleError) {
        this.metricCheckstyleError = metricCheckstyleError;
    }

}
