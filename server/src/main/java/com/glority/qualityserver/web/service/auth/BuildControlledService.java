package com.glority.qualityserver.web.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.web.controller.BasicController;
import com.glority.qualityserver.web.filter.GetProduct;
import com.glority.qualityserver.web.filter.GetProduct.ProductParamName;
import com.glority.qualityserver.web.service.BuildService;
import com.glority.qualityserver.web.service.PhaseService;

/**
 * This service is used to handle the build related command in the page.
 * 
 * @author li.heping
 * 
 */
@RemoteProxy(name = "buildService")
public class BuildControlledService extends AbstractACLDwrService {

    private static final Logger LOGGER = Logger.getLogger(BuildControlledService.class);
    @Autowired
    private BuildService buildService;
    @Autowired
    private PhaseService phaseService;

    @Override
    public String getFeatureName() {
        return "BUILD_CONTROLLED";
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.BUILD_ID)
    public Map<String, Object> certifyBuild(long buildId, String stageStr) {
        Map<String, Object> result = new HashMap<String, Object>();

        ProductStage stage = ProductStage.getProductStage(stageStr);
        try {
            this.buildService.certifyBuild(buildId, stage);
            result.put(BasicController.STATUS, Constants.SUCCESS);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result.put(BasicController.STATUS, Constants.FAIL);
        }

        return result;
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Map<String, Object> updateActiveBuild(long productId, long buildId, String stageStr) {
        Map<String, Object> result = new HashMap<String, Object>();

        ProductStage stage = ProductStage.getProductStage(stageStr);

        if (productId > 0 && buildId > 0 && stage != ProductStage.INVALID) {
            try {
                Map<String, Long> activeBuild = this.phaseService.updateActiveBuild(productId, buildId, stage);
                result.put(BasicController.STATUS, Constants.SUCCESS);
                result.putAll(activeBuild);
            } catch (Exception e) {
                LOGGER.warn(e.getMessage(), e);
                result.put(BasicController.STATUS, Constants.FAIL);
            }
        } else {
            result.put(BasicController.STATUS, Constants.FAIL);
        }

        return result;
    }
}
