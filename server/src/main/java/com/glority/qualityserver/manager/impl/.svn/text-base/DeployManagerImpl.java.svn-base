package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.DeployDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.DeployManager;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.util.VersionUtils;

/**
 * The logic for deploy server type is identified by deploy time. (preview
 * deploy time and production deploy time is separated)
 * 
 * @author liheping
 * 
 */
@Service("deployHistoryManager")
public class DeployManagerImpl extends GenericManagerImpl<Deploy, Long> implements DeployManager {

    @Autowired
    private DeployDao deployDao;

    @Override
    protected GenericDao<Deploy, Long> getDao() {
        return this.deployDao;
    }

    public List<Deploy> getPreviewDeploys(long phaseId) {

        return this.deployDao.getPreviewHotDeploys(phaseId);
    }

    public List<Deploy> getProductionDeploys(long phaseId) {

        return this.deployDao.getProductionHotDeploys(phaseId);
    }

    public String getLatestDeployVersion(long phaseId, long buildId) {

        List<Deploy> deployList = this.deployDao.getAllDeploys(phaseId, buildId);

        if (deployList == null || deployList.isEmpty()) {
            return null;
        }

        String result = null;
        int resultIndex = -1;
        for (Deploy deploy : deployList) {
            if (deploy.getVersion() != null) {
                String version = deploy.getVersion();

                int index = VersionUtils.getDeployVersionIndex(version);

                if (index > resultIndex) {
                    resultIndex = index;
                    result = version;
                }
            }
        }

        return result;
    }

    public Deploy getLatestSuccessBaseDeploy(long phaseId) {

        return this.deployDao.getLatestSuccessBaseDeploy(phaseId);
    }

    public Deploy getLatestSuccessHotDeploy(long phaseId) {

        return this.deployDao.getLatestSuccessHotDeploy(phaseId);
    }

    public Deploy previewDeploy(Deploy deploy, String deployType) {
        Timestamp now = new Timestamp(new Date().getTime());

        deploy.setPreviewDeployTime(now);
        deploy.setType(deployType);

        return super.save(deploy);
    }

    public Deploy productionDeploy(Deploy deploy, String deployType) {
        Timestamp now = new Timestamp(new Date().getTime());

        deploy.setProductionDeployTime(now);
        deploy.setType(deployType);

        return super.save(deploy);
    }

    public Deploy deploy(Deploy deploy, String deployType) {
        deploy.setType(deployType);

        return super.save(deploy);
    }

    public boolean isPhaseServerDeploying(long phaseId) {

        return this.deployDao.isPhaseServerDeploying(phaseId);
    }

    public List<Deploy> getDeployWithSpecifiedResult(String result) {

        return this.deployDao.getDeployWithSpecifiedResult(result);
    }

    public List<Deploy> getPhaseDeploys(long phaseId) {

        return this.deployDao.getAllDeploys(phaseId);
    }

}
