package com.glority.qualityserver.manager;

import com.glority.qualityserver.web.model.MetricsDescription;

/**
 * Used for manager the Metrics description.
 */
public interface MetricsDescriptionManager {
    /**
     * Get the MetricsDescription with metric name. The metrics name could be
     * MI, CPD, PMD.
     * 
     * @param metricsName
     *            the metrics name
     * @param productId
     *            optional parameter, if not 0 , mean the metric is a product
     *            metric based
     * @return MetricsDescription
     */
    MetricsDescription getMetricsDesciption(String metricsName, long productId);

}
