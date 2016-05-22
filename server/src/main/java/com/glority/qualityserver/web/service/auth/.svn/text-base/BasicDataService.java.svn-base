package com.glority.qualityserver.web.service.auth;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.ProductStatus;
import com.glority.qualityserver.util.DateUtils;
import com.glority.qualityserver.web.filter.GetProduct;
import com.glority.qualityserver.web.filter.GetProduct.ProductParamName;
import com.glority.qualityserver.web.service.BuildService;
import com.glority.qualityserver.web.service.PhaseService;
import com.glority.qualityserver.web.service.ProductService;

/**
 * This class contain all the basic data API for web construct.
 * 
 * @author li.heping
 * 
 */
@RemoteProxy(name = "basicDataService")
public class BasicDataService extends AbstractACLDwrService {
    @Autowired
    private ProductService productService;
    @Autowired
    private BuildService buildService;
    @Autowired
    private PhaseService phaseService;

    @Override
    public String getFeatureName() {
        return "BASIC_DATA";
    }

    // Product related part.
    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public ProductStatus getProductDetails(long productId, String dateStr) {
        Timestamp time = DateUtils.getTimestamp(dateStr, Constants.DATE_FORMAT_STRING);

        if (productId < 0 || time == null) {
            return null;
        }

       ProductStatus productStatus = this.productService.getProductStatus(productId, time);
       return productStatus;
    }

    // Build related part.
    @RemoteMethod
    @GetProduct(paramName = ProductParamName.BUILD_ID)
    public Object[] getTestCases(long buildId, String type) {
        if (Constants.SUCCESS.equalsIgnoreCase(type)) {
            return this.buildService.getSuccessTestCase(buildId).toArray();
        } else if (Constants.FAIL.equalsIgnoreCase(type)) {
            return this.buildService.getFailedTestCase(buildId).toArray();
        }
        return new ArrayList<List<Object>>().toArray();
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Object[] getBuildsInfo(long productId, String startDateStr, String endDataStr, int currentPage) {
        Timestamp startTime = DateUtils.getTimestamp(startDateStr, Constants.DATE_FORMAT_STRING);
        Timestamp endTime = DateUtils.getTimestamp(endDataStr, Constants.DATE_FORMAT_STRING);

        if (productId < 0 || currentPage <= 0) {
            return null;
        }

        List<HashMap<String, Object>> buildInfoList = this.buildService.getHistoryBuildInfo(productId, startTime,
                endTime, Constants.PAGE_SIZE, currentPage);
        int buildInfoCount = this.buildService.getBuildsCount(productId, startTime, endTime);

        HashMap<String, Object> count = new HashMap<String, Object>();
        count.put("buildInfoPageCount", (int) Math.ceil(buildInfoCount / Double.valueOf(Constants.PAGE_SIZE)));
        buildInfoList.add(count);

        return buildInfoList.toArray();
    }

    // Score related part.
    @RemoteMethod
    @GetProduct(paramName = ProductParamName.VERSION_ID)
    public Object[] getBuildsInVersion(long versionId, String stageStr) {
        ProductStage phase = ProductStage.getProductStage(stageStr);
        if (versionId < 0 || ProductStage.INVALID == phase) {
            return null;
        }

        return this.phaseService.getBuildListInVersion(versionId, phase).toArray();
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.BUILD_ID)
    public Object[] getDetailedScore(long buildId, String phaseStr) {
        ProductStage phase = ProductStage.getProductStage(phaseStr);
        if (buildId < 0) {
            return null;
        }

        return this.phaseService.getMetricScore(buildId, phase).toArray();
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Object[] getProductHistoryScores(long productId) {

        if (productId < 0) {
            return null;
        }

        return this.productService.getProductHistoryScore(productId).toArray();
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Object getMetricScore(long productId, int submetricIndex, long buildId, String stageString) {
        if (submetricIndex == -1) {
            return null;
        }
        ProductStage stage = ProductStage.getProductStage(stageString);
        List<List<List<Object>>> score = phaseService.getMetricScore(buildId, stage);
        List<List<List<Object>>> result = phaseService.addScoreEmailSettingFlag(productId, score);
        result = phaseService.addSubmetricIndex(result);
        if (!result.isEmpty()) {
            return result.get(submetricIndex);
        }
        return null;
    }
}
