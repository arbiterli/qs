package com.glority.quality.metrics.cs;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.CPDCheckBaseTask;
/**
 * check cs CPD.
 * @author Glority
 *
 */
public class CsCPDCheckTask extends CPDCheckBaseTask {

    @Override
    public String getMeticName() {
        return MetricName.CS_CPD.toString();
    }

}
