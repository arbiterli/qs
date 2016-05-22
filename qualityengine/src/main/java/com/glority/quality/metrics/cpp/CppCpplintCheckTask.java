package com.glority.quality.metrics.cpp;

import java.io.BufferedReader;
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
 * check CppLint report.
 * 
 * @author LYX
 */
public class CppCpplintCheckTask extends MetricsCheckBaseTask {
    private int metricCpplintError;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric ce = new Metric();
        String metricName = MetricName.CPP_CPPLINT.toString();
        String thresholdString = getThreshold(metricName);
        ce.setName(metricName);
        ce.setNewValue(metricCpplintError);
        ce.setOldValue(thresholdString);
        ce.setType(MetricType.METRIC_TYPE_LINT);

        if (isInt(thresholdString)) {
            int oldValue = Integer.parseInt(thresholdString);
            ce.setResult(checkMetric(oldValue, metricCpplintError,
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
            metricCpplintError = 0;
            FileInputStream fin = new FileInputStream(this.getReportPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    fin));
            String line = reader.readLine();
            Pattern pattern = Pattern
                    .compile("Total No. Of Error Count is : \\d++");
            while ((line = reader.readLine()) != null) {
                Matcher match = pattern.matcher(line);
                if (match.find()) {
                    break;
                }
            }
            String digitString = line.replaceAll(
                    "Total No. Of Error Count is : ", "");
            metricCpplintError = Integer.parseInt(digitString.trim());
        } catch (Exception e) {
            getProject().log("Failed to parser cpplint report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricCpplintError() {
        return metricCpplintError;
    }

    public void setMetricCpplintError(int metricCpplintError) {
        this.metricCpplintError = metricCpplintError;
    }

}
