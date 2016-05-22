package com.glority.quality.metrics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.tools.ant.BuildException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.glority.quality.Constants.MetricCompareMode;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.model.Metric;

/**
 * The report will like: <violation beginline="64" endline="66" begincolumn="12"
 * endcolumn="5" rule="EmptyMethodInAbstractClassShouldBeAbstract"
 * ruleset="Design" package="com.glority.quality" class="BaseTask"
 * externalInfoUrl=
 * "http://pmd.sourceforge.net/rules/java/design.html#EmptyMethodInAbstractClassShouldBeAbstract"
 * priority="1"> An empty method in an abstract class should be abstract instead
 * </violation> <violation beginline="64" endline="66" begincolumn="60"
 * endcolumn="5" rule="UncommentedEmptyMethod" ruleset="Design"
 * package="com.glority.quality" class="BaseTask" method="handleFailure"
 * externalInfoUrl
 * ="http://pmd.sourceforge.net/rules/java/design.html#UncommentedEmptyMethod"
 * priority="3"> Document empty method. </violation>
 * 
 * @author XQS
 */
public abstract class PMDCheckBaseTask extends MetricsCheckBaseTask {

    public static final String PMD_VIOLATION_TAG = "violation";
    public static final String PMD_VIOLATION_PRIORITY_ATTR = "priority";
    /**
     * PMD priority 1 -> severity error, priority high. PMD priority 2->
     * severity error, priority normal. PMD priority 3 -> severity warning,
     * priority high. PMD priority 4 -> severity warning, priority normal. PMD
     * priority 5 -> severity information, priority normal.
     */
    public static final int PMD_ERROR_PRIORITY = 2;
    public static final int PMD_WRARNING_PRIORITY = 4;
    public static final String PMD_ERROR_POSTFIX = "_ERROR";
    public static final String PMD_WARNING_POSTFIX = "_WARNING";

    protected int metricTotalPMDViolations = 0;
    protected int metricPMDErrors = 0;
    protected int metricPMDWarnings = 0;

    public int getMetricTotalPMDViolations() {
        return metricTotalPMDViolations;
    }

    public int getMetricPMDErrors() {
        return metricPMDErrors;
    }

    public int getMetricPMDWarnings() {
        return metricPMDWarnings;
    }

    /**
     * Warning: The sub class must re-write this method And each metric should
     * have unique metric name And please define the metrics name in
     * com.glority.quality.Constants.MetricName.
     */
    public abstract String getMeticName();

    @Override
    public List<Metric> getMetrics() {
        List<Metric> metrics = new ArrayList<Metric>();
        Metric m = new Metric();
        String thresholdString = getThreshold(getMeticName());
        m.setName(getMeticName());
        m.setNewValue(metricTotalPMDViolations);
        m.setOldValue(thresholdString);
        m.setType(MetricType.METRIC_TYPE_DEFECTS);

        if (isInt(thresholdString)) {
            // The fewer duplications means success, and more means fail
            int oldValue = Integer.parseInt(thresholdString);
            m.setResult(checkMetric(oldValue, metricTotalPMDViolations,
                    MetricCompareMode.SMALLER_BETTER));
        } else if (thresholdString != null) {
            // Report invalid threshold if it's not a number
            m.setResult(MetricResult.METRIC_INVALIDTHRESHOLD);
        } else {
            m.setResult(MetricResult.METRIC_NULL);
        }
        metrics.add(m);

        Metric me = new Metric();
        me.setName(getMeticName() + PMD_ERROR_POSTFIX);
        me.setNewValue(metricPMDErrors);
        me.setType(MetricType.METRIC_TYPE_DEFECTS);
        me.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(me);

        Metric mw = new Metric();
        mw.setName(getMeticName() + PMD_WARNING_POSTFIX);
        mw.setNewValue(metricPMDWarnings);
        mw.setType(MetricType.METRIC_TYPE_DEFECTS);
        mw.setResult(MetricResult.METRIC_NOCHECK);
        metrics.add(mw);

        return metrics;
    }

    @Override
    public void parseReport() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(reportPath));
            doc.getDocumentElement().normalize();

            NodeList listOfViolations = doc
                    .getElementsByTagName(PMD_VIOLATION_TAG);
            metricTotalPMDViolations = listOfViolations.getLength();

            for (int i = 0; i < listOfViolations.getLength(); i++) {
                int priority = Integer.parseInt(listOfViolations.item(i)
                        .getAttributes()
                        .getNamedItem(PMD_VIOLATION_PRIORITY_ATTR)
                        .getNodeValue());

                if (priority <= PMD_ERROR_PRIORITY) {
                    metricPMDErrors++;
                } else if (priority <= PMD_WRARNING_PRIORITY) {
                    metricPMDWarnings++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException(e.getMessage(), e);
        }
    }
}
