package com.glority.quality.metrics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.tools.ant.BuildException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.model.Metric;

/**
 * MICheckBaseTask. TODO: MICheckBaseTask has four subclasses, which only
 * specify a lang it is not needed. the lang could be specified on the build.xml
 * 
 * @author
 */
public abstract class MICheckBaseTask extends MetricsCheckBaseTask {
    public static final String MI_XML_REPORT_FILENAME = "mi.xml";
    public static final String MI_LOC = "totalloc";
    public static final String MI_LOM = "totallom";
    public static final String MI_MI = "mi";
    public static final String MI_CMI = "miwithcomment";

    private float metricMI;
    private float metricCMI;
    private float metricLoc;
    private float metricLom;

    /**
     * Warning: The sub class must re-write this method And each metric should
     * have unique metric name And please define the metrics name in
     * com.glority.quality.Constants.MetricName.
     */
    public abstract String getLanguageName();

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric cmi = new Metric();
        String metricName = getLanguageName() + "_" + MetricName.CMI;
        String thresholdString = getThreshold(metricName);
        cmi.setName(metricName);
        cmi.setNewValue(metricCMI);
        cmi.setOldValue(thresholdString);
        cmi.setType(MetricType.METRIC_TYPE_MI);

        if (isFloat(thresholdString)) {
            // The fewer duplications means success, and more means fail
            float oldValue = Float.parseFloat(thresholdString);
            cmi.setResult(checkMetric(oldValue, metricCMI,
                    MetricCompareMode.LARGER_BETTER));
        } else if (thresholdString != null) {
            // Report invalid threshold if it's not a number
            cmi.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        } else {
            cmi.setResult(MetricResult.METRIC_NULL);
        }
        metrics.add(cmi);

        Metric mi = new Metric();
        mi.setName(getLanguageName() + "_" + MetricName.MI);
        mi.setNewValue(metricMI);
        mi.setResult(MetricResult.METRIC_NOCHECK);
        mi.setType(MetricType.METRIC_TYPE_MI);
        metrics.add(mi);

        Metric loc = new Metric();
        loc.setName(getLanguageName() + "_" + MetricName.LOC);
        loc.setNewValue(metricLoc);
        loc.setResult(MetricResult.METRIC_NOCHECK);
        loc.setType(MetricType.METRIC_TYPE_CODEBASEINFO);
        metrics.add(loc);

        Metric lom = new Metric();
        lom.setName(getLanguageName() + "_" + MetricName.LOM);
        lom.setNewValue(metricLom);
        lom.setResult(MetricResult.METRIC_NOCHECK);
        lom.setType(MetricType.METRIC_TYPE_CODEBASEINFO);
        metrics.add(lom);

        return metrics;
    }

    @Override
    public void parseReport() {
        try {
            String reportFile = this.getReportPath() + File.separator
                    + MI_XML_REPORT_FILENAME;
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(reportFile));
            doc.getDocumentElement().normalize();

            metricLoc = Float.parseFloat(((Node) doc.getElementsByTagName(
                    MI_LOC).item(0)).getFirstChild().getNodeValue());
            metricLom = Float.parseFloat(((Node) doc.getElementsByTagName(
                    MI_LOM).item(0)).getFirstChild().getNodeValue());
            metricMI = Float.parseFloat(((Node) doc.getElementsByTagName(MI_MI)
                    .item(0)).getFirstChild().getNodeValue());
            metricCMI = Float.parseFloat(((Node) doc.getElementsByTagName(
                    MI_CMI).item(0)).getFirstChild().getNodeValue());

        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }

    public float getMetricMI() {
        return metricMI;
    }

    public float getMetricCMI() {
        return metricCMI;
    }

    public float getMetricLoc() {
        return metricLoc;
    }

    public float getMetricLom() {
        return metricLom;
    }
}
