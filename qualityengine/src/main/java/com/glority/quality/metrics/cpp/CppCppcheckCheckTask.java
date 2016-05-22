package com.glority.quality.metrics.cpp;

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
 * check cppcheck report.
 * 
 * @author LYX
 */
public class CppCppcheckCheckTask extends MetricsCheckBaseTask {
    public static final String CPPCHECK_ERROR = "error";
    private int metricCppcheckError;

    @Override
    public final List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric ce = new Metric();
        String metricName = MetricName.CPP_CPPCHECK.toString();
        String thresholdString = getThreshold(metricName);
        ce.setName(metricName);
        ce.setNewValue(metricCppcheckError);
        ce.setOldValue(thresholdString);
        ce.setType(MetricType.METRIC_TYPE_DEFECTS);

        if (isInt(thresholdString)) {
            int oldValue = Integer.parseInt(thresholdString);
            ce.setResult(checkMetric(oldValue, metricCppcheckError,
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
    public final void parseReport() {
        try {
            File file = new File(this.getReportPath());
            if(file.length() == 0){
                metricCppcheckError = 0;
                return;
            }
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList errorNodes = doc.getElementsByTagName(CPPCHECK_ERROR);
            metricCppcheckError = errorNodes.getLength();

        } catch (Exception e) {
            getProject().log("Failed to parser cppcheck report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricCppcheckError() {
        return metricCppcheckError;
    }

    public void setMetricCppcheckError(int metricCppcheckError) {
        this.metricCppcheckError = metricCppcheckError;
    }

}
