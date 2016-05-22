package com.glority.qualityserver.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.manager.PhaseManager;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.PhaseStatus;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.web.service.BuildService;
import com.glority.qualityserver.web.service.DeployService;
import com.glority.qualityserver.web.service.PhaseService;
import com.glority.qualityserver.manager.ProductManager;

/**
 * PhaseController holds all request about phase page.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("/phase")
public class PhaseController extends BasicController {

    public static final int INDEX_SUBMETRIC = 6;
    public static final int INDEX_FINAL_SCORE = 4;
    public static final int INDEX_RATE_SCORE = 6;
    public static final int RUNNING_SCORE = 3;
    public static final int FIX_SCORE = 4;
    private static final int POWER = 4;
    private static final int SCORE = 5;

    @Autowired
    private DeployService deployService;
    @Autowired
    private PhaseManager phaseManager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private BuildService buildService;

    /**
     * this method to get stage detail for stagedetail.
     * 
     * @param request
     * @param response
     * @return productphase.jsp
     */
    @RequestMapping("/productphase")
    public String getProductPhaseDetail(@RequestParam(value = BUILD_ID, defaultValue = "-1") long buildId,
            @RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = STAGE, required = false) String stageString, HttpServletRequest request,
            HttpServletResponse response) {
        ProductStage stage = ProductStage.getProductStage(stageString);

        if (!super.setRequestProductInfo(request) || stage == null || stage == ProductStage.INVALID) {
            return "error";
        }
        request.setAttribute("stageString", stageString);
        request.setAttribute("buildId", buildId);
        super.setPageTitleAndNavigationLinks(request, PAGE_PHASE);
        PhaseStatus phaseStatus = this.phaseService.getPhaseStatus(buildId, stage, false);

        request.setAttribute("phaseStatus", phaseStatus);
        request.setAttribute("stage", stage);
        boolean hasServer = productManager.hasProductionServer(productId);
        request.setAttribute("hasServer", hasServer);
        if (hasServer) {
            List<Server> serverList = this.phaseService.getServersForStage(productId, stage);
            List<Map<String, Object>> servers = addDeployAtToServers(serverList, productId);
            request.setAttribute("servers", servers);
        }

        List<List<List<Object>>> score = super.phaseService.getMetricScore(buildId, stage);
        List<List<List<Object>>> result = super.phaseService.addScoreEmailSettingFlag(productId, score);
        result = super.phaseService.addSubmetricIndex(result);
        if (!result.isEmpty()) {
            request.setAttribute("scores", result.get(0));
            request.setAttribute("finalscore", getFinalScore(result.get(0)));
        } else {
            request.setAttribute("scores", null);
        }
        long nextStageServerId = -1;
        if (stage != ProductStage.PROD) {
            ProductStage nextStage = stage.getNextProductStage();
            Phase phase = phaseManager.getPhase(productId, nextStage);
            Server nextStageOfficalServer = deployService.getSpecifiedServer(phase.getId(),
                    Constants.SERVER_TYPE_OFFICIAL);
            if (nextStageOfficalServer != null) {
                nextStageServerId = nextStageOfficalServer.getId();
            }
        }
        request.setAttribute("nextStageServerId", nextStageServerId);
        return "phase";

    }

    @RequestMapping("/serverbuildpage")
    //TODO move to deploy controller
    public String getServerBuildPage(@RequestParam(value = SERVER_ID, defaultValue = "-1") long serverId,
            @RequestParam(value = BUILD_ID, defaultValue = "-1") long buildId,
            @RequestParam(value = STAGE) String stage,
            HttpServletRequest request, HttpServletResponse response) {
        if (serverId < 0) {
            return "error";
        }

        Server server = this.phaseService.getServerDetail(serverId, PhaseService.SERVER_DETAIL_FOR_VIEW, buildId);
        request.setAttribute("server", server);

        Map<String, Long> buildInServer = this.phaseService.getDeployedBuild(serverId);
        request.setAttribute("buildInServer", buildInServer);

        Map<String, Object> buildDetail = buildService.getBuildDetail(buildId);
        request.setAttribute("buildDetail", buildDetail);
        request.setAttribute("operation", "deploy");
        request.setAttribute("stage", stage);
        return "server";
    }

    @RequestMapping("/createserverpage")
    public String getCreateServerPage(@RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = STAGE, required = false) String stageString, HttpServletRequest request,
            HttpServletResponse response) {
        ProductStage stage = ProductStage.getProductStage(stageString);
        try {
            Map<String, Long> activeBuild = this.phaseService.getActiveBuild(productId, stage);
            request.setAttribute("activeBuild", activeBuild);

            Server server = this.phaseService.getServerDetail(productId, stage);
            request.setAttribute("server", server);
            request.setAttribute("operation", "create");
            return "server";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/updateserverpage")
    public String getUpdateServerBuildPage(@RequestParam(value = SERVER_ID, defaultValue = "-1") long serverId,
            HttpServletRequest request, HttpServletResponse response) {
        Server server = this.phaseService.getServerDetail(serverId, PhaseService.SERVER_DETAIL_FOR_UPDATE, 0);
        request.setAttribute("server", server);

        Map<String, Long> buildInServer = this.phaseService.getDeployedBuild(serverId);
        request.setAttribute("buildInServer", buildInServer);

        Map<String, Long> activeBuild = this.phaseService.getActiveBuild(serverId);
        request.setAttribute("activeBuild", activeBuild);

        request.setAttribute("operation", "update");
        return "server";
    }

    @RequestMapping("/servermanage")
    public String getServerManagePage(@RequestParam(value = SERVER_ID, defaultValue = "-1") long serverId,
            HttpServletRequest request, HttpServletResponse response) {
        Server server = this.phaseService.getServerDetail(serverId, PhaseService.SERVER_DETAIL_FOR_UPDATE, 0);
        request.setAttribute("server", server);

        Map<String, Long> buildInServer = this.phaseService.getDeployedBuild(serverId);
        request.setAttribute("buildInServer", buildInServer);

        Map<String, Long> activeBuild = this.phaseService.getActiveBuild(serverId);
        request.setAttribute("activeBuild", activeBuild);

        return "servermanage";
    }

    private List<Map<String, Object>> addDeployAtToServers(List<Server> serverList, long productId) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Server server : serverList) {
            Map<String, Object> tmp = new HashMap<String, Object>();
            tmp.put("server", server);
            Product product = super.productService.getProductById(productId);
            tmp.put("deploy", super.deployService.getActiveDeploy(product.getName(), server.getType()));
            result.add(tmp);
        }
        return result;
    }

    private int getFinalScore(List<List<Object>> scores) {
        double finalScore = 0;
        for (int i = 1; i < scores.size(); i++) {
            finalScore += Double.parseDouble((String) scores.get(i).get(POWER))
                    * Double.parseDouble((String) scores.get(i).get(SCORE));
        }
        return (int) finalScore;
    }

}
