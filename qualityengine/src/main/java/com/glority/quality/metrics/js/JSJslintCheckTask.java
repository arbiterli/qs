package com.glority.quality.metrics.js;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.metrics.MetricsCheckBaseTask;
import com.glority.quality.model.Metric;

/**
 * check JSlint report.
 * 
 * @author LYX
 */
public class JSJslintCheckTask extends MetricsCheckBaseTask {
    public static final String JSLINT_ERROR = "issue";
    private int metricJslintError;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric ce = new Metric();
        String metricName = MetricName.JS_JSLINT.toString();
        String thresholdString = getThreshold(metricName);
        ce.setName(metricName);
        ce.setNewValue(metricJslintError);
        ce.setOldValue(thresholdString);
        ce.setType(MetricType.METRIC_TYPE_LINT);

        if (isInt(thresholdString)) {
            int oldValue = Integer.parseInt(thresholdString);
            ce.setResult(checkMetric(oldValue, metricJslintError,
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
            /*
             * DocumentBuilderFactory docBuilderFactory =
             * DocumentBuilderFactory.newInstance(); DocumentBuilder docBuilder
             * = docBuilderFactory.newDocumentBuilder(); Document doc =
             * docBuilder.parse(new File(this.getReportPath()));
             * doc.getDocumentElement().normalize(); NodeList errorNodes =
             * doc.getElementsByTagName(JSLINT_ERROR); metricJslintError =
             * errorNodes.getLength();
             */

            BufferedReader in = new BufferedReader(new FileReader(new File(
                    this.getReportPath())));
            String s;
            while ((s = in.readLine()) != null) {
                if (s.contains("<issue line")) {
                    metricJslintError++;
                }
            }
            in.close();
        } catch (Exception e) {
            getProject().log("Failed to parser jslint report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricJslintError() {
        return metricJslintError;
    }

    public void setMetricJslintError(int metricJslintError) {
        this.metricJslintError = metricJslintError;
    }

}
