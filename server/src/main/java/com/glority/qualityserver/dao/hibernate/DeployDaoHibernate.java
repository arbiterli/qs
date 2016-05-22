package com.glority.qualityserver.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.dao.DeployDao;
import com.glority.qualityserver.model.Deploy;

/**
 * Hibernate implementation for Deploy DAO.
 * 
 * @author liheping
 * 
 */
@Repository("deployHistoryDao")
public class DeployDaoHibernate extends GenericDaoHibernate<Deploy, Long> implements DeployDao {
    /**
     * default constructor.
     */
    public DeployDaoHibernate() {
        super(Deploy.class);
    }

    /**
     * get all the hot deploys for preview.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Deploy>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<Deploy> getPreviewHotDeploys(long phaseId) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where phase_id = ?  and result = ? "
                + "and preview_deploy_time <> ? order by preview_deploy_time desc",
                new Object[] { Long.valueOf(phaseId), Constants.SUCCESS, "null" });

        if (deployList == null) {
            return new ArrayList<Deploy>();
        }
        return deployList;
    }

    /**
     * get all the hot deploys for production.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Deploy>, if not exist, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<Deploy> getProductionHotDeploys(long phaseId) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where phase_id = ?  and result = ? and "
                + "prod_deploy_time <> ? order by prod_deploy_time desc",
                new Object[] { Long.valueOf(phaseId),

                Constants.SUCCESS, "null" });

        if (deployList == null) {
            return new ArrayList<Deploy>();
        }
        return deployList;
    }

    /**
     * get the latest success base deploy for phase.
     * 
     * @param phaseId
     *            the phase id.
     * @return Deploy, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public Deploy getLatestSuccessBaseDeploy(long phaseId) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where phase_id = ? and result = ? and type = ? order by create_time desc",
                new Object[] { Long.valueOf(phaseId), Constants.SUCCESS, Constants.DEPLOY_TYPE_BASE });

        if (deployList == null || deployList.isEmpty()) {
            return null;
        }

        return deployList.get(0);
    }

    /**
     * get the latest success hot deploy for phase.
     * 
     * @param phaseId
     *            the phase id.
     * @return Deploy, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public Deploy getLatestSuccessHotDeploy(long phaseId) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where phase_id = ? and result = ? and type = ? order by create_time desc",
                new Object[] { Long.valueOf(phaseId), Constants.SUCCESS, Constants.DEPLOY_TYPE_HOT });

        if (deployList == null || deployList.isEmpty()) {
            return null;
        }

        return deployList.get(0);
    }

    /**
     * get all the deploys in phase, order by create time.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Deploy>, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public List<Deploy> getAllDeploys(long phaseId) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where phase_id = ?  order by create_time desc",
                new Object[] { Long.valueOf(phaseId), });
        if (deployList == null) {
            return new ArrayList<Deploy>();
        }
        return deployList;
    }

    /**
     * get all deploys for phase with build.
     * 
     * @param phaseId
     *            the phase id
     * @param buildId
     *            the build id
     * @return List<Deploy>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<Deploy> getAllDeploys(long phaseId, long buildId) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where phase_id = ? and build_id = ? order by version desc",
                new Object[] { Long.valueOf(phaseId), Long.valueOf(buildId) });
        if (deployList == null) {
            return new ArrayList<Deploy>();
        }
        return deployList;
    }

    /**
     * get all the deploys that has the specified result.
     * 
     * @param result
     *            the specified result
     * @return List<Deploy>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<Deploy> getDeployWithSpecifiedResult(String result) {
        List<Deploy> deployList = super.getHibernateTemplate().find(
                "from Deploy where result = ? order by version", result);
        if (deployList == null) {
            return new ArrayList<Deploy>();
        }
        return deployList;
    }

    /**
     * check the specified phase server whether deploying.
     * 
     * @param phaseId
     *            the specified phase
     * @return whether the phase server is deploying
     */
    public boolean isPhaseServerDeploying(long phaseId) {
        List<Deploy> runningDeployList = this.getDeployWithSpecifiedResult(Constants.RUNNING);

        if (runningDeployList != null && !runningDeployList.isEmpty()) {
            for (Deploy runningdeploy : runningDeployList) {
                if (phaseId == runningdeploy.getPhaseId()) {
                    return true;
                }
            }
        }

        return false;
    }

}
