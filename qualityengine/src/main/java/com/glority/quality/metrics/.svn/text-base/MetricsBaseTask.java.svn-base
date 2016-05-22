package com.glority.quality.metrics;

import java.util.List;

import org.apache.tools.ant.BuildException;

import com.glority.quality.BaseTask;
import com.glority.quality.model.Metric;

/**
 * Base task of all metrics.
 * @author cz
 *
 */
public abstract class MetricsBaseTask extends BaseTask {

    /**
     * To update quality.xml.
     */
    protected void updateQualityXML(List<Metric> metrics) {
        if (qualityReport == null) {
            return;
        }
        try {
            qualityReport.addMetrics(metrics);
            qualityReport.writeToFile(qualityXmlPath);
        } catch (Exception e) {
            getProject().log("Error: Failed to update metrics to quality xml");
            throw new BuildException(e);
        }
    }
}
