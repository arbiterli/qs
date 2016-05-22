package com.glority.qualityserver.web.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.web.controller.BasicController;
import com.glority.qualityserver.web.filter.GetProduct;
import com.glority.qualityserver.web.filter.GetProduct.ProductParamName;
import com.glority.qualityserver.web.service.PhaseService;

/**
 * Server web service.
 * 
 * @author li.heping
 * 
 */
@RemoteProxy(name = "serverService")
public class ServerControlledService extends AbstractACLDwrService {
    private static final Logger LOGGER = Logger.getLogger(ServerControlledService.class);

    @Autowired
    private PhaseService phaseService;

    @Override
    public String getFeatureName() {
        return "SERVER_CONTROLLED";
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.SERVER_ID)
    public Map<String, String> deleteServer(long serverId) {
        Map<String, String> result = new HashMap<String, String>();

        if (serverId > 0) {
            try {
                this.phaseService.deleteServer(serverId);
                result.put(BasicController.STATUS, Constants.SUCCESS);
                result.put(BasicController.SERVER_ID, Long.toString(serverId));
            } catch (Exception e) {
                result.put(BasicController.STATUS, Constants.FAIL);
                LOGGER.warn(e.getMessage(), e);
            }
        } else {
            result.put(BasicController.STATUS, Constants.ERROR);
        }

        return result;
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PHASE_ID)
    public Map<String, String> updateServer(long phaseId, Server server) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            Server dbServer = this.phaseService.updateServer(server);
            result.put(BasicController.STATUS, Constants.SUCCESS);
            result.put(BasicController.SERVER_ID, dbServer.getId().toString());
        } catch (Exception e) {
            result.put(BasicController.STATUS, Constants.SUCCESS);
            LOGGER.warn(e.getMessage(), e);
        }

        return result;
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PHASE_ID)
    public Map<String, String> createServer(long phaseId, Server server) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            Server dbServer = this.phaseService.createServer(server);
            if (dbServer != null) {
                result.put(BasicController.STATUS, Constants.SUCCESS);
                result.put(BasicController.SERVER_ID, dbServer.getId().toString());
            } else {
                result.put(BasicController.STATUS, Constants.FAIL);
            }
        } catch (Exception e) {
            result.put(BasicController.STATUS, Constants.FAIL);
            LOGGER.warn(e.getMessage(), e);
        }

        return result;
    }
}
