package com.glority.qualityserver.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.deploylog.DeployLogManager;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.web.service.PhaseService;

/**
 * DeployController holds all request about deploy page.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("deploy")
public class DeployController extends BasicController {
    private static final Logger LOGGER = Logger
            .getLogger(DeployController.class);
    private static final int HISTORY_MAX_NUMBER = 3;
    private static final int HISTORY_NUMBER_PER_PAGE = 20;

    @RequestMapping("/deployhistory")
    public String getDeployHistoryPage(
            @RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = STAGE, required = false) String stageString,
            HttpServletRequest request, HttpServletResponse response) {
        ProductStage stage = ProductStage.getProductStage(stageString);
        super.setPageTitleAndNavigationLinks(request, PAGE_HOT_DEPLOY);
        super.setRequestProductInfo(request);

        Map<String, Object> baseItem = super.deployService.getBaseDeployRecord(
                productId, stage);
        request.setAttribute("baseItem", baseItem);

        List<Map<String, Object>> previewDeployList = super.deployService
                .getLatestPreviewDeployUpdateHistory(productId, stage,
                        HISTORY_MAX_NUMBER);

        request.setAttribute("previewDeploys", previewDeployList);

        List<Map<String, Object>> productionDeployList = super.deployService
                .getLatestProductionDeployUpdateHistory(productId, stage,
                        HISTORY_MAX_NUMBER);

        request.setAttribute("productionDeploys", productionDeployList);

        List<Server> serverList = super.phaseService.getServersForStage(
                productId, stage);

        Server previewServer = this.getSpecfiedServer(serverList,
                Constants.SERVER_TYPE_PREVIEW);

        request.setAttribute("previewServer", previewServer);

        Server productServer = this.getSpecfiedServer(serverList,
                Constants.SERVER_TYPE_OFFICIAL);

        request.setAttribute("productServer", productServer);

        return "deployhistory";
    }

    private Server getSpecfiedServer(List<Server> serverList, String type) {
        if (serverList != null) {
            for (int i = 0; i < serverList.size(); i++) {
                Server server = serverList.get(i);
                if (type.equalsIgnoreCase(server.getType())) {
                    return server;
                }
            }
        }
        return null;
    }

    @RequestMapping("/basedeployinfo")
    public String getBaseDeployInfo(
            @RequestParam(value = SERVER_ID, defaultValue = "-1") long serverId,
            @RequestParam(value = LOG_KEY, required = false) String logKey,
            HttpServletRequest request, HttpServletResponse response) {
        if (logKey == null || serverId < 0) {
            return "error";
        }

        Server server = this.phaseService.getServerDetail(serverId,
                PhaseService.SERVER_DETAIL_FOR_VIEW, 0);
        request.setAttribute("server", server);

        Map<String, Long> buildInServer = this.phaseService
                .getDeployedBuild(serverId);
        request.setAttribute("buildInServer", buildInServer);

        Map<Object, Object> deployLogMap = super.deployService
                .getBaseDeployLog(logKey);
        request.setAttribute("finished",
                deployLogMap.get(DeployLogManager.DEPLOY_FINISHED));
        request.setAttribute("deployInfoList",
                deployLogMap.get(DeployLogManager.DEPLOY_LOG));

        return "deployresult";
    }

    @RequestMapping("/phasedeployhistory")
    public String getPhaseDeployHistoryPage(
            @RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = STAGE, required = false) String stageString,
            HttpServletRequest request, HttpServletResponse response) {
        ProductStage stage = ProductStage.getProductStage(stageString);
        LOGGER.debug("productId : " + productId + " stage:" + stage);
        if (productId < 0) {
            return "error";
        }
        List<Deploy> deployList = super.deployService.getPhaseDeploys(
                productId, stage);
        int count = deployList.size() / HISTORY_NUMBER_PER_PAGE;
        if (count * HISTORY_NUMBER_PER_PAGE < deployList.size()
                || deployList.size() == 0) {
            count++;
        }
        LOGGER.debug("deploy list size - " + deployList.size());
        int toIndex = (deployList.size() > HISTORY_NUMBER_PER_PAGE) ? HISTORY_NUMBER_PER_PAGE
                : deployList.size();
        deployList = deployList.subList(0, toIndex);
        request.setAttribute("deploys", deployList);
        request.setAttribute("productId", productId);
        request.setAttribute("count", count);
        request.setAttribute("stage", stageString);
        return "phasedeployhistory";
    }

    /**
     * get the phase deploy history when the page changed.
     * 
     * @param request
     * @param response
     * @return list of deploy
     */
    @RequestMapping("/updatephasedeployhistory")
    @ResponseBody
    public List<Deploy> updatePhaseDeployHistory(
            @RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = STAGE, required = false) String stageString,
            @RequestParam(value = PAGE) int page, HttpServletRequest request,
            HttpServletResponse response) {
        ProductStage stage = ProductStage.getProductStage(stageString);
        LOGGER.debug("productId : " + productId + " stage:" + stage);
        if (productId < 0) {
            return null;
        }
        List<Deploy> deployList = super.deployService.getPhaseDeploys(
                productId, stage);
        int toIndex = page * HISTORY_NUMBER_PER_PAGE;
        if (toIndex > deployList.size()) {
            toIndex = deployList.size();
        }
        return deployList
                .subList((page - 1) * HISTORY_NUMBER_PER_PAGE, toIndex);
    }

    @RequestMapping("/getlogpage")
    public String getLogPage(@RequestParam(value = "logKey") String logKey, HttpServletRequest request) {
        Map<Object, Object> deployLogMap = super.deployService.getBaseDeployLog(logKey);
        request.setAttribute("deployInfoList", deployLogMap.get(DeployLogManager.DEPLOY_LOG));
        return "logPage";
    }
}
