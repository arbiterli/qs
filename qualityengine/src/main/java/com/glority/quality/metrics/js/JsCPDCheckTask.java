package com.glority.quality.metrics.js;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.CPDCheckBaseTask;
/**
 * check js CPD.
 * @author Glority
 *
 */
public class JsCPDCheckTask extends CPDCheckBaseTask {

    @Override
    public String getMeticName() {
        return MetricName.JS_CPD.toString();
    }
}
