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
 * check PClint report.
 * 
 * @author LYX
 */
public class CppPClintCheckTask extends MetricsCheckBaseTask {
    private int metricPClintError;
    private int metricPClintWarning;
    private int metricPClintInfo;

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric error = new Metric();
        String metricName = MetricName.CPP_PCLINT_ERROR.toString();
        String thresholdString = getThreshold(metricName);
        error.setName(metricName);
        error.setNewValue(metricPClintError);
        error.setOldValue(thresholdString);
        error.setType(MetricType.METRIC_TYPE_DEFECTS);

        if (isInt(thresholdString)) {
            int oldValue = Integer.parseInt(thresholdString);
            error.setResult(checkMetric(oldValue, metricPClintError,
                    MetricCompareMode.SMALLER_BETTER));
        } else if (thresholdString != null) {
            // Report invalid threshold if it's not a number
            error.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        } else {
            error.setResult(MetricResult.METRIC_NULL);
        }
        metrics.add(error);

        Metric warning = new Metric();
        warning.setName(MetricName.CPP_PCLINT_WARNING.toString());
        warning.setNewValue(metricPClintWarning);
        warning.setType(MetricType.METRIC_TYPE_DEFECTS);
        warning.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(warning);

        Metric info = new Metric();
        info.setName(MetricName.CPP_PCLINT_INFO.toString());
        info.setNewValue(metricPClintInfo);
        info.setType(MetricType.METRIC_TYPE_DEFECTS);
        info.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(info);

        return metrics;
    }

    @Override
    public void parseReport() {
        try {
            metricPClintError = 0;
            metricPClintWarning = 0;
            metricPClintInfo = 0;
            FileInputStream fin = new FileInputStream(this.getReportPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    fin));
            String line = reader.readLine();
            Pattern patternError = Pattern.compile("Error \\d++:");
            Pattern patternWarning = Pattern.compile("Warning \\d++:");
            Pattern patternInfo = Pattern.compile("Info \\d++:");
            while ((line = reader.readLine()) != null) {
                Matcher matchError = patternError.matcher(line);
                Matcher matchWarning = patternWarning.matcher(line);
                Matcher matchInfo = patternInfo.matcher(line);
                if (matchError.find()) {
                    metricPClintError++;
                } else if (matchWarning.find()) {
                    metricPClintWarning++;
                } else if (matchInfo.find()) {
                    metricPClintInfo++;
                }
            }
        } catch (Exception e) {
            getProject().log("Failed to parser PClint report");
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public int getMetricPClintError() {
        return metricPClintError;
    }

    public void setMetricPClintError(int metricPClintError) {
        this.metricPClintError = metricPClintError;
    }

    public int getMetricPClintWarning() {
        return metricPClintWarning;
    }

    public void setMetricPClintWarning(int metricPClintWarning) {
        this.metricPClintWarning = metricPClintWarning;
    }

    public int getMetricPClintInfo() {
        return metricPClintInfo;
    }

    public void setMetricPClintInfo(int metricPClintInfo) {
        this.metricPClintInfo = metricPClintInfo;
    }
}
