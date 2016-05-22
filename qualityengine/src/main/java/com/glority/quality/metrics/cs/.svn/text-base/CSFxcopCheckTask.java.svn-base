package com.glority.quality.metrics.cs;

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
 * check fxcop report.
 * 
 * @author LYX
 */
public class CSFxcopCheckTask extends MetricsCheckBaseTask {
    public static final String FXCOP_ERROR = "Issue";
    private int metricFxcopError;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric ce = new Metric();
        String metricName = MetricName.CS_FXCOP.toString();
        String thresholdString = getThreshold(metricName);
        ce.setName(metricName);
        ce.setNewValue(metricFxcopError);
        ce.setOldValue(thresholdString);
        ce.setType(MetricType.METRIC_TYPE_DEFECTS);

        if (isInt(thresholdString)) {
            int oldValue = Integer.parseInt(thresholdString);
            ce.setResult(checkMetric(oldValue, metricFxcopError,
                    MetricCompareMode.SMALLER_BETTER));
        } else if (thresholdString != null) {
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
            NodeList errorNodes = doc.getElementsByTagName(FXCOP_ERROR);
            metricFxcopError = errorNodes.getLength();

        } catch (Exception e) {
            getProject().log("Failed to parser fxcop report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricFxcopError() {
        return metricFxcopError;
    }

    public void setMetricFxcopError(int metricFxcopError) {
        this.metricFxcopError = metricFxcopError;
    }

}
