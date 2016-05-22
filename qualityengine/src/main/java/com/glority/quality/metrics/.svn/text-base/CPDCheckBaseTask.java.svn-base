package com.glority.quality.metrics;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.BuildException;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.model.Metric;

/**
 * The base class to check PMD CPD report. The cpd report for all language have
 * the same format. So we shared the parser for all language.
 * 
 * @author XQS
 * 
 */
public abstract class CPDCheckBaseTask extends MetricsCheckBaseTask {
    protected int metricTotalDuplicaton;

    /**
     * Warning: The sub class must re-write this method And each metric should
     * have unique metric name And please define the metrics name in
     * com.glority.quality.Constants.MetricName.
     */
    public abstract String getMeticName();

    public void parseReport() {
        metricTotalDuplicaton = 0;
        File f = new File(reportPath);
        if (f.isFile()) {
            parseReportFile(f);
        } else {
            // If the path is a folder, process all xml reports under the folder
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.getPath().endsWith("cpd.txt")) {
                    parseReportFile(file);
                }
            }
        }
    }
    /**
     * CPD can generate report and kinds of format. including txt and xml. We
     * use txt format here.
     * 
     * TODO: 1. should we also implement xml version parser? 2. The detailed
     * failure is not parsered.
     */
    public void parseReportFile(File file) {
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(file);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line
            Pattern pattern = Pattern
                    .compile("Found a \\d++ line \\(\\d++ tokens\\) duplication in the following files");
            while ((strLine = br.readLine()) != null) {
                Matcher m = pattern.matcher(strLine);
                while (m.find()) {
                    metricTotalDuplicaton++;
                }
            }

            in.close();
            // Close the input stream

        } catch (Exception e) {
            throw new BuildException(e.getMessage(), e);
        }
    }

    /**
     * Add the number of duplication as a metric The fewer duplications is
     * better.
     */
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric m = new Metric();
        String thresholdString = getThreshold(getMeticName());
        m.setName(getMeticName());
        m.setNewValue(metricTotalDuplicaton);
        m.setOldValue(thresholdString);
        m.setType(MetricType.METRIC_TYPE_DUPLICATION);

        if (isInt(thresholdString)) {
            // The fewer duplications means success, and more means fail
            int oldValue = Integer.parseInt(thresholdString);
            m.setResult(checkMetric(oldValue, metricTotalDuplicaton,
                    MetricCompareMode.SMALLER_BETTER));
        } else {
            // Report invalid threshold if it's not a number
            m.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        }
        metrics.add(m);
        return metrics;
    }
}
