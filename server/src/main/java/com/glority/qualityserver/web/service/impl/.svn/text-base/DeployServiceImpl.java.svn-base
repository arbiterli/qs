package com.glority.qualityserver.web.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.quality.connectors.ssh.SSHExec;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.DeployProtocol;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.deploylog.DeployLog;
import com.glority.qualityserver.deploylog.DeployLogManager;
import com.glority.qualityserver.deploylog.impl.DeployLogManagerImpl;
import com.glority.qualityserver.deploylog.impl.SSHExecLog;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.thread.deploy.DeployRunner;
import com.glority.qualityserver.thread.deploy.DeployThread;
import com.glority.qualityserver.thread.deploy.SSHExecDeployRunner;
import com.glority.qualityserver.util.VersionUtils;
import com.glority.qualityserver.web.model.DeployMapKeys;
import com.glority.qualityserver.web.service.DeployService;

/**
 * Deploy service implementation.
 * 
 * @author liheping
 * 
 */
@Service("deployService")
@Transactional(readOnly = true)
public class DeployServiceImpl extends DBBaseService implements DeployService {
    private static final Logger LOGGER = Logger
            .getLogger(DeployServiceImpl.class);

    private static final DeployLogManager LOGMANAGER = new DeployLogManagerImpl();

    private DateFormat df = new SimpleDateFormat(
            Constants.DATE_TIME_FORMAT_YMD_HMS);

    public List<Map<String, Object>> getLatestPreviewDeployUpdateHistory(
            long productId, ProductStage stage, int maxNumber) {
        Phase phase = super.phaseManager.getPhase(productId, stage);

        if (phase == null) {
            return new ArrayList<Map<String, Object>>();
        }

        Server previewServer = this.getSpecifiedServer(phase.getId(),
                Constants.SERVER_TYPE_PREVIEW);

        List<Deploy> deployList = super.deployManager.getPreviewDeploys(phase
                .getId());

        return getLatestDeployHistory(deployList, previewServer, maxNumber);
    }

    public List<Map<String, Object>> getLatestProductionDeployUpdateHistory(
            long productId, ProductStage stage, int maxNumber) {
        Phase phase = super.phaseManager.getPhase(productId, stage);

        if (phase == null) {
            return new ArrayList<Map<String, Object>>();
        }

        Server previewServer = this.getSpecifiedServer(phase.getId(),
                Constants.SERVER_TYPE_OFFICIAL);

        List<Deploy> deployList = super.deployManager
                .getProductionDeploys(phase.getId());

        return getLatestDeployHistory(deployList, previewServer, maxNumber);
    }

    private List<Map<String, Object>> getLatestDeployHistory(
            List<Deploy> deployList, Server server, int maxNumber) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        if (deployList != null && server != null) {
            Deploy activeDeploy = this.getActiveDeploy(deployList, server);

            int count = 0;
            for (Deploy deploy : deployList) {
                if (count == maxNumber) {
                    break;
                } else {
                    count++;
                }
                Map<String, Object> item = this.translateDeployToDeployUpdate(
                        deploy, deploy.equals(activeDeploy));

                resultList.add(item);
            }
        }
        return resultList;
    }

    public Deploy getLatestHotdeployRecord(long productId) {
        Phase phase = super.phaseManager.getPhase(productId, ProductStage.PROD);
        if (phase == null) {
            return null;
        }
        return super.deployManager.getLatestSuccessHotDeploy(phase.getId());
    }

    public Map<String, Object> getBaseDeployRecord(long productId,
            ProductStage stage) {
        Phase phase = super.phaseManager.getPhase(productId, stage);
        if (phase == null) {
            return null;
        }

        Deploy baseDeploy = super.deployManager
                .getLatestSuccessBaseDeploy(phase.getId());

        if (baseDeploy == null) {
            return null;
        }

        return translateDeployToDeployUpdate(baseDeploy, false);
    }

    private Map<String, Object> translateDeployToDeployUpdate(Deploy deploy,
            boolean isActiveDeploy) {
        Map<String, Object> item = new HashMap<String, Object>();

        if (deploy.getPreviewDeployTime() != null) {
            item.put(DeployMapKeys.CREATE_TIME,
                    df.format(deploy.getPreviewDeployTime()));
        }
        if (deploy.getProductionDeployTime() != null) {
            item.put(DeployMapKeys.DEPLOY_TIME,
                    df.format(deploy.getProductionDeployTime()));
        }
        item.put(DeployMapKeys.VERSION, deploy.getVersion());

        item.put(DeployMapKeys.DEPLOYED_BY, deploy.getDeployUser());
        item.put(DeployMapKeys.ACTIVE, Boolean.valueOf(isActiveDeploy));
        item.put(DeployMapKeys.SVN_REVISION, deploy.getSvnRevision());
        return item;
    }

    @Transactional
    public void hotDeploy(String productName, String user, String revision)
            throws Exception {
        Product product = super.productManager.getProduct(productName);
        if (product == null) {
            throw new NotFoundException("product with name " + productName
                    + " not exists");
        }

        Phase phase = super.phaseManager.getPhase(product.getId(),
                ProductStage.PROD);
        if (phase == null) {
            throw new NotFoundException("phase for product " + productName
                    + " not exists");
        }

        Server server = this.getSpecifiedServer(phase.getId(),
                Constants.SERVER_TYPE_PREVIEW);
        if (server == null) {
            throw new NotFoundException("preview server for product "
                    + productName + " not exists");
        }

        Deploy deploy = setDeploy(phase.getId(), server.getBuildId(), user,
                Constants.DEPLOY_TYPE_HOT, revision);

        server.setActiveVersion(deploy.getVersion());

        super.serverManager.save(server);
        super.deployManager.previewDeploy(deploy, Constants.DEPLOY_TYPE_HOT);
    }

    @Transactional
    public List<String> baseDeploy(long serverId, long buildId, String user) throws Exception {

        Server server = super.serverManager.get(serverId);
        if (server == null) {
            throw new NotFoundException("server do not exist");
        }

        List<Server> serverList = super.serverManager
                .getAllServersInPhase(server.getPhaseId());

        String revision = super.buildManager.get(buildId).getSvnRevision();

        Deploy deploy = this.setDeploy(server.getPhaseId(),
                buildId, user, Constants.DEPLOY_TYPE_BASE,
                revision);

        return this.baseDeploy(server, serverList, deploy, buildId);

    }

    private List<String> baseDeploy(Server server, List<Server> serverList,
            Deploy deploy, long buildId) throws Exception {
        List<String> resultList = new ArrayList<String>();
        synchronized (this) {
            if (this.deployManager.isPhaseServerDeploying(server.getPhaseId())) {
                resultList.add("build already be deploying...");
            } else {
                DeployProtocol protocol = DeployProtocol
                        .getDeployProtocol(server.getDeployProtocol());
                if (!isBaseDeployEnabled()) {
                    String message = "BaseDeployJob is disabled";
                    LOGGER.info(message);
                    resultList.add(message);
                    return resultList;
                }
                if (DeployProtocol.SSH == protocol) {
                    Deploy pDeploy = super.deployManager.deploy(deploy,
                            Constants.DEPLOY_TYPE_BASE);
                    resultList.add("start deploy...");
                    String logKey = this.sshDeploy(server, serverList, pDeploy, buildId);
                    resultList.add(logKey);
                } else {
                    resultList.add("protocol is not supported");

                }
            }

            return resultList;
        }
    }

    /**
     * check whether the feature is enabled.
     * @return if enabled, return true
     */
    private boolean isBaseDeployEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.BASE_DEPLOY);
    }

    private String sshDeploy(Server server, List<Server> serverList,
            Deploy deploy, long buildId) throws Exception {
        SSHExec se = new SSHExec();

        se.setHost(server.getHost());
        se.setUsername(server.getUsername());
        se.setPassword(server.getPassword());
        se.setCommand(super.parseDeployScript(server, buildId));
        se.setTrust(true);
        se.setProject(new Project());

        DeployLog sshLog = new SSHExecLog(se, server.getId());
        String logKey = LOGMANAGER.addDeployLog(sshLog);
        deploy.setLog(logKey);

        DeployRunner runner = new SSHExecDeployRunner(se);
        runner.setDeploy(deploy);
        runner.setServerList(serverList);
        runner.setDeployManager(super.deployManager);
        runner.setServerManager(super.serverManager);
        DeployThread deployThread = new DeployThread(runner);
        deployThread.start();

        return logKey;
    }

    private Deploy setDeploy(long phaseId, long buildId, String user,
            String type, String revisionStr) throws Exception {
        Deploy deploy = new Deploy();

        deploy.setBuildId(buildId);

        deploy.setDeployUser(user);

        deploy.setPhaseId(phaseId);

        deploy.setType(type);
        long revision = 0;
        try {
            revision = Long.parseLong(revisionStr);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
        deploy.setSvnRevision(revision);

        Timestamp now = new Timestamp(new Date().getTime());
        deploy.setCreateTime(now);
        deploy.setPreviewDeployTime(now);

        String deployVersion = null;
        if (Constants.DEPLOY_TYPE_HOT.equalsIgnoreCase(type)) {
            deployVersion = generateNextDeployVersion(buildId, phaseId);
            deploy.setVersion(deployVersion);
            deploy.setResult(Constants.SUCCESS);
        } else if (Constants.DEPLOY_TYPE_BASE.equalsIgnoreCase(type)) {
            deployVersion = generateBaseDeployVersion(buildId);
            deploy.setVersion(deployVersion);
            deploy.setResult(Constants.RUNNING);
            deploy.setProductionDeployTime(now);
        }

        return deploy;
    }

    private String generateNextDeployVersion(long buildId, long phaseId) {
        String latestVersion = super.deployManager.getLatestDeployVersion(
                phaseId, buildId);
        return VersionUtils.getNextDeployVersion(latestVersion);
    }

    private String generateBaseDeployVersion(long buildId) {
        Build build = super.buildManager.get(buildId);

        return VersionUtils.getBaseDeployVersion(build);
    }

    public Map<Object, Object> getActiveDeploy(String productName,
            String serverType) {
        Map<Object, Object> result = new HashMap<Object, Object>();
        if (productName == null) {
            result.put("info", "product not exist");
            return result;
        }

        Product product = super.productManager.getProduct(productName);

        if (product == null) {
            result.put("info", "product not exist");
            return new HashMap<Object, Object>();
        }

        Phase phase = super.phaseManager.getPhase(product.getId(),
                ProductStage.PROD);

        Deploy activeDeploy = this.getActvieDeploy(phase, serverType);

        return translateDeployToMap(activeDeploy, serverType);
    }

    private Map<Object, Object> translateDeployToMap(Deploy activeDeploy,
            String serverType) {
        Map<Object, Object> activeMap = new HashMap<Object, Object>();

        if (activeDeploy != null) {
            activeMap.put("info", "success");
            // activeMap.put("deployId", activeDeploy.getId());
            activeMap.put("phaseId", activeDeploy.getPhaseId());
            activeMap.put("buildId", activeDeploy.getBuildId());
            activeMap.put("currentVersion", activeDeploy.getVersion());
            activeMap.put("user", activeDeploy.getDeployUser());

            if (Constants.SERVER_TYPE_PREVIEW.equalsIgnoreCase(serverType)) {
                if (activeDeploy.getPreviewDeployTime() != null) {
                    String deployTime = df.format(activeDeploy
                            .getPreviewDeployTime());
                    activeMap.put("deployTime", deployTime);
                }
            } else if (Constants.SERVER_TYPE_OFFICIAL
                    .equalsIgnoreCase(serverType)) {
                if (activeDeploy.getProductionDeployTime() != null) {
                    String deployTime = df.format(activeDeploy
                            .getProductionDeployTime());
                    activeMap.put("deployTime", deployTime);
                }
            }

        } else {
            activeMap.put("info", "not find active deploy");
        }
        return activeMap;
    }

    public void updatePreviewServerVersion(String productName) {
        long phaseId = this.getProductPhaseId(productName);

        if (phaseId > 0) {
            List<Deploy> deployList = super.deployManager
                    .getPreviewDeploys(phaseId);

            Server server = this.getSpecifiedServer(phaseId,
                    Constants.SERVER_TYPE_PREVIEW);

            // update the server active version to be the latest success
            // version;
            for (Deploy deploy : deployList) {
                if (Constants.SUCCESS.equalsIgnoreCase(deploy.getResult())) {
                    super.deployManager.previewDeploy(deploy, deploy.getType());

                    server.setActiveVersion(deploy.getVersion());
                    super.serverManager.save(server);
                    break;
                }
            }

        }
    }

    // now this method is not used
    public void rollbackPreviewServerVersion(String productName) {
        long phaseId = this.getProductPhaseId(productName);

        if (phaseId > 0) {
            List<Deploy> deployList = super.deployManager
                    .getPreviewDeploys(phaseId);

            Server server = this.getSpecifiedServer(phaseId,
                    Constants.SERVER_TYPE_PREVIEW);

            boolean versionIsLatterThanActiveVersion = false;
            for (Deploy deploy : deployList) {
                if (!versionIsLatterThanActiveVersion) { // skip all the version
                                                         // after the active
                                                         // version
                    if (server.getActiveVersion().equalsIgnoreCase(
                            deploy.getVersion())) {
                        versionIsLatterThanActiveVersion = true;
                    }
                } else {
                    if (Constants.SUCCESS.equalsIgnoreCase(deploy.getResult())) {
                        server.setActiveVersion(deploy.getVersion());
                        break;
                    }
                }
            }

            super.serverManager.save(server);
        }

    }

    @Transactional
    public void syncFromProductionServerVersion(String productName) {
        long phaseId = this.getProductPhaseId(productName);
        if (phaseId > 0) {
            Server previewServer = this.getSpecifiedServer(phaseId,
                    Constants.SERVER_TYPE_PREVIEW);
            Server productionServer = this.getSpecifiedServer(phaseId,
                    Constants.SERVER_TYPE_OFFICIAL);

            previewServer.setActiveVersion(productionServer.getActiveVersion());

            super.serverManager.save(previewServer);

            // deploy to preview
            List<Deploy> deployList = super.deployManager
                    .getProductionDeploys(phaseId);
            Deploy activeDeploy = this.getActiveDeploy(deployList,
                    previewServer);
            super.deployManager.previewDeploy(activeDeploy,
                    activeDeploy.getType());
        }
    }

    @Transactional
    public void syncToProductionServerVersion(String productName) {
        long phaseId = this.getProductPhaseId(productName);
        if (phaseId > 0) {
            Server previewServer = this.getSpecifiedServer(phaseId,
                    Constants.SERVER_TYPE_PREVIEW);
            Server productionServer = this.getSpecifiedServer(phaseId,
                    Constants.SERVER_TYPE_OFFICIAL);

            productionServer.setActiveVersion(previewServer.getActiveVersion());

            super.serverManager.save(productionServer);

            // deploy to production
            List<Deploy> deployList = super.deployManager
                    .getPreviewDeploys(phaseId);
            Deploy activeDeploy = this.getActiveDeploy(deployList,
                    productionServer);
            super.deployManager.productionDeploy(activeDeploy,
                    activeDeploy.getType());
        }
    }

    public String getVersionForPreviewUpdate(String productName) {

        long phaseId = getProductPhaseId(productName);
        Server server = this.getSpecifiedServer(phaseId,
                Constants.SERVER_TYPE_PREVIEW);

        return this.generateNextDeployVersion(server.getBuildId(), phaseId);

    }

    public String getVersionForRollback(String productName) {
        long phaseId = getProductPhaseId(productName);
        List<Deploy> deployList = super.deployManager
                .getPreviewDeploys(phaseId);

        Server server = this.getSpecifiedServer(phaseId,
                Constants.SERVER_TYPE_PREVIEW);

        boolean versionIsLatterThanActiveVersion = false;
        for (Deploy deploy : deployList) {
            if (!versionIsLatterThanActiveVersion) { // skip all the version
                                                     // after the active
                                                     // version
                if (server.getActiveVersion().equalsIgnoreCase(
                        deploy.getVersion())) {
                    versionIsLatterThanActiveVersion = true;
                }
            } else {
                if (Constants.SUCCESS.equalsIgnoreCase(deploy.getResult())) {
                    return deploy.getVersion();
                }
            }
        }

        return null;
    }

    public String getVersionForSyncFromProduction(String productName) {
        long phaseId = getProductPhaseId(productName);
        Server productionServer = this.getSpecifiedServer(phaseId,
                Constants.SERVER_TYPE_OFFICIAL);

        return productionServer.getActiveVersion();
    }

    public String getVersionnForSyncToProduction(String productName) {
        long phaseId = getProductPhaseId(productName);
        Server previewServer = this.getSpecifiedServer(phaseId,
                Constants.SERVER_TYPE_PREVIEW);
        return previewServer.getActiveVersion();
    }

    private long getProductPhaseId(String productName) {
        if (productName == null) {
            return -1;
        }

        Product product = super.productManager.getProduct(productName);

        if (product == null) {
            return -1;
        }

        Phase phase = super.phaseManager.getPhase(product.getId(),
                ProductStage.PROD);

        if (phase == null) {
            return -1;
        }
        return phase.getId();
    }

    public Map<Object, Object> getBaseDeployLog(String logKey) {
        return LOGMANAGER.getLogInfo(logKey);
    }

    private Deploy getActvieDeploy(Phase phase, String serverType) {
        if (phase == null || serverType == null) {
            return null;
        }

        Server server = this.getSpecifiedServer(phase.getId(), serverType);

        if (server == null) {
            return null;
        }

        List<Deploy> deployList = null;
        if (serverType.equalsIgnoreCase(Constants.SERVER_TYPE_PREVIEW)) {
            deployList = super.deployManager.getPreviewDeploys(phase.getId());
        } else if (serverType.equalsIgnoreCase(Constants.SERVER_TYPE_OFFICIAL)) {
            deployList = super.deployManager
                    .getProductionDeploys(phase.getId());
        }

        return this.getActiveDeploy(deployList, server);
    }

    private Deploy getActiveDeploy(List<Deploy> deployList, Server server) {
        if (deployList == null || deployList.isEmpty() || server == null
                || server.getActiveVersion() == null) {
            return null;
        }

        for (Deploy deploy : deployList) {
            if (server.getActiveVersion().equalsIgnoreCase(deploy.getVersion())) {
                return deploy;
            }
        }

        return null;
    }

    public List<Deploy> getPhaseDeploys(long productId, ProductStage stage) {
        Phase phase = super.phaseManager.getPhase(productId, stage);
        LOGGER.debug("phase - " + phase);
        if (phase == null) {
            return new ArrayList<Deploy>();
        }

        return super.deployManager.getPhaseDeploys(phase.getId());
    }

    // TODO if the logic for server is changed, this method may wrong.
    /**
     * get the specified server. now, the logic is based on that, one phase has
     * only two kinds of server: official and preview. only one server is exist
     * in preview, and may not only one server in official type. but only one
     * has deploy script in official kind. all the servers in official kind, are
     * deploy when the deploy action is taken on the one which has deploy
     * script. this method is only used in the environment about deploy.
     */
    public Server getSpecifiedServer(long phaseId, String serverType) {
        List<Server> serverList = super.serverManager.getSpecifiedServer(
                phaseId, serverType);

        if (Constants.SERVER_TYPE_PREVIEW.equals(serverType)) {
            return (serverList == null || serverList.isEmpty()) ? null
                    : serverList.get(0);
        } else if (Constants.SERVER_TYPE_OFFICIAL.equals(serverType)) {
            // find the server who can deploy. means the one has the deploy
            // script.
            for (Server server : serverList) {
                if (StringUtils.isNotEmpty(server.getDeployScript())) {
                    return server;
                }
            }
        }

        return null;
    }

}
