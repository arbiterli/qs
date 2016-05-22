package com.glority.quality.metrics.css;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.BuildException;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.metrics.MetricsCheckBaseTask;
import com.glority.quality.model.Metric;

/**
 * check Csslint report.
 * 
 * @author LYX
 */
public class CSSCsslintCheckTask extends MetricsCheckBaseTask {
    private int metricCsslintError;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric ce = new Metric();
        String metricName = MetricName.CSS_CSSLINT.toString();
        String thresholdString = getThreshold(metricName);
        ce.setName(metricName);
        ce.setNewValue(metricCsslintError);
        ce.setOldValue(thresholdString);
        ce.setType(MetricType.METRIC_TYPE_LINT);

        if (isInt(thresholdString)) {
            int oldValue = Integer.parseInt(thresholdString);
            ce.setResult(checkMetric(oldValue, metricCsslintError,
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
        metricCsslintError = 0;
        try {
            FileInputStream fstream = new FileInputStream(reportPath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line
            Pattern pattern = Pattern.compile("\\d++: warning");
            while ((strLine = br.readLine()) != null) {
                Matcher m = pattern.matcher(strLine);
                while (m.find()) {
                    metricCsslintError++;
                }
            }
            in.close();
            // Close the input stream

        } catch (Exception e) {
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricCsslintError() {
        return metricCsslintError;
    }

    public void setMetricCsslintError(int metricCsslintError) {
        this.metricCsslintError = metricCsslintError;
    }

}
