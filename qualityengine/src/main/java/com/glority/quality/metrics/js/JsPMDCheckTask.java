package com.glority.quality.metrics.js;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.PMDCheckBaseTask;
/**
 * check js PMD.
 * @author Glority
 *
 */
public class JsPMDCheckTask extends PMDCheckBaseTask {

    @Override
    public String getMeticName() {
        return MetricName.JS_PMD.toString();
    }

}
