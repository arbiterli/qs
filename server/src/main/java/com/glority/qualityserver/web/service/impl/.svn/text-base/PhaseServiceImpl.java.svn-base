package com.glority.qualityserver.web.service.impl;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.exception.NoDataException;
import com.glority.qualityserver.integration.QualityReportServer;
import com.glority.qualityserver.metricengine.DisplayType;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngine;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.PhaseStatus;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.model.StatusMapKeys;
import com.glority.qualityserver.web.service.PhaseService;
import com.glority.qualityserver.web.service.ScoreEmailSettingService;

/**
 * Phase service implementation.
 * 
 * @author liheping
 * 
 */
@Service("phaseService")
@Transactional(readOnly = true)
public class PhaseServiceImpl extends DBBaseService implements PhaseService {
    private static final Logger LOGGER = Logger.getLogger(PhaseServiceImpl.class);
    public static final int INDEX_SUBMETRIC = 8;
    public static final int INDEX_FINAL_SCORE = 6;
    private static final int INDEX_SCORE_NAME = 0;
    private static final int INDEX_SCORE = 5;

    // FIXME: this class is not thread safe
    private static NumberFormat dnf = new DecimalFormat("0.00");
    private static NumberFormat inf = new DecimalFormat("0");

    @Autowired
    private MetricEngineDBService dbService;

    @Autowired
    private ScoreEmailSettingService scoreEmailSettingService;

    @Transactional
    public Map<String, Long> updateActiveBuild(long productId, long buildId, ProductStage stage) {
        Build build = super.buildManager.get(buildId);
        Phase phase = super.phaseManager.getPhase(productId, stage);
        if (build == null || phase == null) {
            throw new NoDataException();
        }

        super.phaseManager.updatePhaseActiveBuild(phase, buildId);

        return this.translateBuild(build);
    }


    private PhaseStatus getPhaseStatus(Build build, ProductStage phase, boolean fullInfo) {
        LOGGER.debug("get phase status for phase : " + phase);
        PhaseStatus phaseStatus = new PhaseStatus();
        if (build != null && ProductStage.INVALID != phase) {
            phaseStatus.setActiveBuild(build);
            MetricEngineProfile profile = new MetricEngineProfile();
            profile.setBuildId(build.getId());
            profile.setProductId(build.getProduct().getId());
            MetricEngine engine = new MetricEngine(profile, this.dbService);
            phaseStatus.setScore(engine.getPhaseScore(phase));
            phaseStatus.setPhase(super.phaseManager.getPhase(build.getProduct().getId(), phase));
            List<Build> buildList = super.buildManager.getAllBuildsInVersion(build.getProduct().getId(), build
                    .getVersion().getId(), phase);
            phaseStatus.setBuildList(buildList);
        }
        return phaseStatus;
    }
    public PhaseStatus getPhaseStatus(long buildId, ProductStage phase, boolean fullInfo) {
        Build build = buildManager.get(buildId);
        return getPhaseStatus(build, phase, fullInfo);
    }

    private List<Map<String, Long>> getBuildListInVersion(Version version, ProductStage phase) {
        List<Map<String, Long>> result = new ArrayList<Map<String, Long>>();
        if (version != null) {
            List<Build> buildList = super.buildManager.getAllBuildsInVersion(version.getProductId(), version.getId(),
                    phase);
            if (buildList != null && !buildList.isEmpty()) {
                for (Build buildInList : buildList) {
                    result.add(this.translateBuild(buildInList));
                }
            }
        }
        return result;
    }

    private Map<String, Long> translateBuild(Build build) {
        Map<String, Long> result = new HashMap<String, Long>();
        if (build != null) {
            result.put(StatusMapKeys.BUILD_ID, build.getId());
            result.put(StatusMapKeys.JENKINS_BUILD_ID, build.getJenkinsBuildId());
        }
        return result;
    }

    @Override
    public List<Map<String, Long>> getBuildListInVersion(long versionId, ProductStage phase) {
        Version version = super.versionManager.get(versionId);
        return this.getBuildListInVersion(version, phase);
    }


    public List<Server> getServersForStage(long productId, ProductStage stage) {
        Phase phase = super.phaseManager.getPhase(productId, stage);

        return super.serverManager.getAllServersInPhase(phase.getId());
    }

    public Server getServerDetail(long serverId, String type, long buildId) {
        Server server = super.serverManager.get(serverId);
        if (server == null) {
            return null;
        }

        if (SERVER_DETAIL_FOR_UPDATE.equals(type)) {
            server.setDeployScript(server.getDeployScript());
        } else if (SERVER_DETAIL_FOR_VIEW.equals(type)) {
            server.setDeployScript(super.parseDeployScript(server, buildId));
        }

        return server;
    }

    @Override
    public Server getServerDetail(long productId, ProductStage stage) {
        Server server = new Server();
        Phase phase = super.phaseManager.getPhase(productId, stage);
        if (phase != null) {
            server.setPhaseId(phase.getId());
        }
        return server;
    }

    @Override
    public Map<String, Long> getDeployedBuild(long serverId) {
        Server server = super.serverManager.get(serverId);
        if (server == null) {
            return new HashMap<String, Long>();
        }

        Build build = super.buildManager.get(server.getBuildId());

        return this.translateBuild(build);
    }

    public Map<String, Long> getActiveBuild(long serverId) {
        Map<String, Long> result = new HashMap<String, Long>();
        Server server = super.serverManager.get(serverId);
        if (server == null) {
            return result;
        }

        Phase phase = super.phaseManager.get(server.getPhaseId());
        if (phase == null) {
            return result;
        }

        Build activeBuild = this.dbService.getBuildForScore(phase.getProductId(),
                ProductStage.getProductStage(phase.getType()));
        return this.translateBuild(activeBuild);
    }

    @Override
    public Map<String, Long> getActiveBuild(long productId, ProductStage stage) {
        Build activeBuild = this.dbService.getBuildForScore(productId, stage);
        return this.translateBuild(activeBuild);
    }

    public Server updateServer(Server server) throws Exception {
        super.serverManager.validate(server);
        Server existServer = super.serverManager.get(server.getId());
        if (existServer == null) {
            throw new NotFoundException("server not exist");
        }

        existServer.setName(server.getName());
        existServer.setType(server.getType());
        existServer.setHost(server.getHost());
        existServer.setUsername(server.getUsername());
        existServer.setSiteUrl(server.getSiteUrl());
        existServer.setEditUrl(server.getEditUrl());
        existServer.setCheckIsActive(server.getCheckIsActive());
        existServer.setCheckScript(server.getCheckScript());
        existServer.setDeployProtocol(server.getDeployProtocol());
        existServer.setDeployScript(server.getDeployScript());
        existServer.setBuildId(server.getBuildId());
        return super.serverManager.save(existServer);
    }

    public Server createServer(Server server) {
        if (server != null) {
            server.setIsDiscarded(false);
            return super.serverManager.save(server);
        }
        return null;
    }

    public void deleteServer(long serverId) {
        super.serverManager.deleteServer(serverId);
    }

    public List<List<List<Object>>> getMetricScore(long buildId, ProductStage phase) {
        List<ExtendItem> itemList = getItemList(buildId, phase);
        if (itemList == null) {
            return null;
        }
        return this.translateExtendItemList(itemList, buildId);
    }

    private List<ExtendItem> getItemList(long buildId, ProductStage phase) {
        Build build = super.buildManager.get(buildId);
        if (build == null) {
            return null;
        }

        MetricEngineProfile profile = new MetricEngineProfile();
        profile.setBuildId(buildId);
        profile.setProductId(build.getProduct().getId());
        MetricEngine engine = new MetricEngine(profile, this.dbService);

        Timestamp rqSampleTime = engine.getSampleTime(new Date(), MetricType.METRIC_TYPE_RUN_QUALITY);
        Timestamp ifaSampleTime = engine.getSampleTime(new Date(), MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY);
        profile.setRqSampleTime(rqSampleTime);
        profile.setIfaSampleTime(ifaSampleTime);

        List<ExtendItem> itemList = engine.getPhaseDetailScore(phase);
        return itemList;
    }

    public Map<String, Object> getMetricNameScorePairs(long buildId, ProductStage phase) {
        List<List<List<Object>>> metricScore = getMetricScore(buildId, phase);
        if (null == metricScore || metricScore.isEmpty()) {
            return null;
        }

        List<List<Object>> metricScoreData = metricScore.get(0);
        if (null == metricScoreData) {
            return null;
        }

        metricScoreData.remove(0);
        Map<String, Object> result = new HashMap<String, Object>();
        for (List<Object> metricMap : metricScoreData) {
            result.put(metricMap.get(INDEX_SCORE_NAME).toString(), metricMap.get(INDEX_SCORE).toString());
        }
        return result;
    }

    /**
     * translate ExtendItem List to detailed score item for UI display.
     * 
     * @param detailScoreList
     * @return
     * TODO: the result is too complex and hard to understand
     */
    private List<List<List<Object>>> translateExtendItemList(List<ExtendItem> detailScoreList, long buildId) {
        List<List<List<Object>>> result = new ArrayList<List<List<Object>>>();
        Queue<ExtendItem> itemQue = new LinkedList<ExtendItem>();

        List<List<Object>> scoreDetailList = addScoreDetailItem(itemQue, detailScoreList, buildId);
        this.addToScoreDetailList(result, scoreDetailList);
        while (!itemQue.isEmpty()) {
            ExtendItem extendItem = itemQue.poll();

            if (extendItem.getBasicItem() instanceof ScoreItem) {
                ScoreItem scoreItem = (ScoreItem) extendItem.getBasicItem();

                List<ExtendItem> detailItemList = scoreItem.getItemList();
                List<List<Object>> childDetailList = this.addScoreDetailItem(itemQue, detailItemList, buildId);
                this.addToScoreDetailList(result, childDetailList);
            }

        }

        return result;
    }

    private List<List<Object>> addScoreDetailItem(Queue<ExtendItem> itemQue, List<ExtendItem> detailItemList,
            long buildId) {
        List<List<Object>> scoreDetailList = new ArrayList<List<Object>>();

        if (detailItemList != null && !detailItemList.isEmpty()) {
            scoreDetailList.add(getScoreDetailTitle());

            for (ExtendItem item : detailItemList) {
                ExtendItem addItem = null;
                if (DisplayType.NONE != item.getDisplay()) {
                    if (item.getPower() != 0) {
                        addItem = item;
                    } else {
                        if (DisplayType.DISPLAY == item.getDisplay()) {
                            addItem = item;
                        }
                    }
                }
                LOGGER.debug("item name :" + item.getBasicItem().getName() + " item type : "
                        + item.getBasicItem().getDisplay());
                boolean add = false;
                if (addItem != null) {
                    if (DisplayType.DISPLAY == item.getBasicItem().getDisplay()) {
                        itemQue.add(item);
                        add = true;
                    } else if (DisplayType.AUTO == item.getBasicItem().getDisplay()) {
                        if (item.getPower() != 0 || item.getRate() != 0) {
                            LOGGER.debug("add Item");
                            itemQue.add(item);
                            add = true;
                        }
                    }
                    List<Object> detail = getScoreItemDetail(addItem, add, buildId);
                    scoreDetailList.add(detail);
                }
            }

        }

        return scoreDetailList;
    }
    /**
     * to add scoreDetailList to result.
     * 
     * this method remove the score which only contains one item
     * 
     * @param result
     * @param scoreDetailList
     */
    private void addToScoreDetailList(List<List<List<Object>>> result, List<List<Object>> scoreDetailList) {
            result.add(scoreDetailList);
    }

    private List<Object> getScoreItemDetail(ExtendItem item, boolean add, long buildId) {
        List<Object> result = new ArrayList<Object>();
        if (item != null) {
            result.add(item.getBasicItem().getName() == null ? "" : item.getBasicItem().getName());
            result.add(item.getData() == null ? "" : item.getData());
            result.add(item.getBasicItem().getUnit() == null ? "" : item.getBasicItem().getUnit());
            result.add(item.getBasicItem().getExpected() == null ? "" : item.getBasicItem().getExpected());
            result.add(dnf.format(item.getRate()) == null ? "" : dnf.format(item.getRate()));
            result.add(inf.format(item.getScore()) == null ? "" : inf.format(item.getScore()));
            result.add(inf.format(item.getRateScore()));
            result.add(QualityReportServer.getInstance().getQualityReportPath(getBuild(buildId), item));
            result.add(add);
        }
        return result;
    }

    private Build getBuild(long buildId) {
        return dbService.getBuild(buildId);
    }

    private List<Object> getScoreDetailTitle() {
        List<Object> result = new ArrayList<Object>();

        result.add("Name");
        result.add("Data");
        result.add("Unit");
        result.add("Expected");
        result.add("Percent rate");
        result.add("Score");
        result.add("Powered Score");
        result.add("Report");
        result.add("ContainChild");
        return result;
    }

    @Override
    public List<List<List<Object>>> addScoreEmailSettingFlag(long productId, List<List<List<Object>>> scores) {
        List<List<List<Object>>> result = scores != null ? scores : new ArrayList<List<List<Object>>>();
        if (!result.isEmpty()) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                int subSize = result.get(i).size();
                for (int j = 0; j < subSize; j++) {
                    if (scoreEmailSettingService.hasSetEmail(productId, (String) result.get(i).get(j).get(0))) {
                        result.get(i).get(j).add(true);
                    } else {
                        result.get(i).get(j).add(false);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<List<List<Object>>> addSubmetricIndex(List<List<List<Object>>> scores) {
        List<List<List<Object>>> result = scores != null ? scores : new ArrayList<List<List<Object>>>();
        int submetricIndex = 1;
        if (!result.isEmpty()) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                int subSize = result.get(i).size();
                for (int j = 1; j < subSize; j++) {
                    if ((Boolean) result.get(i).get(j).get(INDEX_SUBMETRIC)) {
                        result.get(i).get(j).add(submetricIndex++);
                    } else {
                        result.get(i).get(j).add(-1);
                    }
                }
            }
        }
        return result;
    }
}
