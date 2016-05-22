package com.glority.qualityserver.web.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glority.qualityserver.manager.MetricsDescriptionManager;
import com.glority.qualityserver.web.model.MetricsDescription;

/**
 * Controller for lookup the metric description.
 * 
 * @author Chenhong
 * 
 */
@Controller
@RequestMapping("/metricsdescription")
public class MetricsDescriptionController {

    @Autowired
    private MetricsDescriptionManager manager;

    /**
     * Get the MetricsDescription.
     * 
     * @param metricsName
     *            the metrics name such as CHECKSTYLE, MI
     * @param request
     *            the HttpRequest
     * @param response
     *            the HttpResponse
     * @return MetricsDescription
     */
    @RequestMapping("/getMetricsDescription")
    public String getMetricsDescription(@RequestParam(value = "metrics_name", required = false) String metricsName,
            @RequestParam(value = "productId", required = false, defaultValue = "-1") long productId,
            HttpServletRequest request, HttpServletResponse response) {

        if (metricsName == null) {
            return "error";
        }

        request.setAttribute("metricname", metricsName);
        request.setAttribute("productId", productId);

        return "metricdescription";
    }

    /**
     * Get the MetricsDescription.
     * 
     * @param metricsName
     *            the metrics name such as CHECKSTYLE, MI
     * @param request
     *            the HttpRequest
     * @param response
     *            the HttpResponse
     * @return MetricsDescription
     */
    @RequestMapping("/getMetricsDescriptionDetail")
    @ResponseBody
    public MetricsDescription getMetricsDescriptionDetail(
            @RequestParam(value = "metrics_name", required = false) String metricsName,
            @RequestParam(value = "productId", required = false, defaultValue = "-1") long productId,
            HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("metricname", metricsName);
        request.setAttribute("productId", productId);

        return manager.getMetricsDesciption(metricsName, productId);
    }
}
