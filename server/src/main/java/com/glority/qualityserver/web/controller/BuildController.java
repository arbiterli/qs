package com.glority.qualityserver.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.model.BuildMetric;

/**
 * BuildController. this class holds all request about build page.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("/build")
public class BuildController extends BasicController {

    /**
     * this method to get build report page.
     * 
     * @param request
     * @param response
     * @return buildreport.jsp
     */

    @RequestMapping("buildreportlist")
    public String getBuildReportListPage(@RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            HttpServletRequest request, HttpServletResponse response) {
        if (productId < 0) {
            return "error";
        }

        if (!setRequestProductInfo(request)) {
            return "error";
        }

        super.setPageTitleAndNavigationLinks(request, PAGE_BUILD_REPORT_LIST);
        List<HashMap<String, Object>> buildInfoList = super.buildService.getHistoryBuildInfo(productId, null, null,
                Constants.PAGE_SIZE, Constants.DEFAULT_PAGE);
        int buildInfoCount = super.buildService.getBuildsCount(productId, null, null);

        request.setAttribute("buildInfoList", buildInfoList);
        request.setAttribute("buildInfoPageCount",
                (int) Math.ceil(buildInfoCount / Double.valueOf(Constants.PAGE_SIZE)));
        return "buildreportlist";
    }

    @RequestMapping("buildreport")
    public String getBuildReportPage(@RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = BUILD_ID, defaultValue = "-1") long buildId,
            HttpServletRequest request, HttpServletResponse response) {
        if (productId < 0 || buildId < 0) {
            return "error";
        }

        if (!setRequestProductInfo(request)) {
            return "error";
        }

        super.setPageTitleAndNavigationLinks(request, PAGE_BUILD_REPORT);

        Map<String, Object> buildDetail = super.buildService.getBuildDetail(buildId);
        request.setAttribute("buildDetail", buildDetail);

        // metric
        List<BuildMetric> metric = super.buildService.getMetrics(buildId);
        request.setAttribute("metrics", metric);

        return "buildreport";
    }
}
