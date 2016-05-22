package com.glority.quality.metrics.java;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.CPDCheckBaseTask;

/**
 * JavaCPDCheckTask.
 * 
 * @author
 * 
 */
public class JavaCPDCheckTask extends CPDCheckBaseTask {

    @Override
    public String getMeticName() {
        return MetricName.JAVA_CPD.toString();
    }

}
