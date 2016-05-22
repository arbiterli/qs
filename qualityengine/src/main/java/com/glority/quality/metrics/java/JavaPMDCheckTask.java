package com.glority.quality.metrics.java;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.PMDCheckBaseTask;

/**
 * JavaPMDCheckTask.
 * 
 * @author
 * 
 */
public class JavaPMDCheckTask extends PMDCheckBaseTask {

    @Override
    public String getMeticName() {
        return MetricName.JAVA_PMD.toString();
    }

}
