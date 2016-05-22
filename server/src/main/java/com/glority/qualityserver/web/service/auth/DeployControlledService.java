package com.glority.qualityserver.web.service.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.web.filter.GetProduct;
import com.glority.qualityserver.web.filter.GetProduct.ProductParamName;
import com.glority.qualityserver.web.service.DeployService;

/**
 * This service is used to handle the deploy command in the page.
 * 
 * @author xxd
 * 
 */
@RemoteProxy(name = "deployService")
public class DeployControlledService extends AbstractACLDwrService {
    private static final Logger LOGGER = Logger.getLogger(DeployControlledService.class);

    @Autowired
    private DeployService deployService;
    @Autowired
    private AccessControlService aclService;

    @Override
    public String getFeatureName() {
        return "DEPLOY_CONTROLLED";
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.SERVER_ID)
    public Map<Object, Object> baseDeploy(long serverId, long buildId) {
        Map<Object, Object> result = new HashMap<Object, Object>();
        // TODO add more detailed permission control.
        try {
            User user = this.aclService.getCurrentUser();
            List<String> deployInfoList = this.deployService.baseDeploy(serverId, buildId, user.getEmail());

            if (deployInfoList.size() == 1) {
                result.put("result", Constants.FAIL);
                result.put("deployInfo", deployInfoList.get(0));
                return result;
            } else if (deployInfoList.size() == 2) {
                result.put("result", Constants.SUCCESS);
                result.put("deployInfo", deployInfoList.get(0));
                result.put("key", deployInfoList.get(1));
                result.put("serverId", serverId);
                return result;
            } else {
                result.put("result", Constants.ERROR);
                return result;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        result.put("result", Constants.ERROR);
        return result;
    }

}
