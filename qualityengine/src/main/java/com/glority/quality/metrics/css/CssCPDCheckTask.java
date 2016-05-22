package com.glority.quality.metrics.css;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.CPDCheckBaseTask;
/**
 * check css CPD.
 * @author Glority
 *
 */
public class CssCPDCheckTask extends CPDCheckBaseTask {

    @Override
    public String getMeticName() {
        return MetricName.CSS_CPD.toString();
    }

}
