package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.dao.BuildDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.BuildManager;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildCertifyHistory;
import com.glority.qualityserver.model.Product;

/**
 * Implementation for Build manager.
 * 
 * @author liheping
 * 
 */
@Service("buildManager")
public class BuildManagerImpl extends GenericManagerImpl<Build, Long> implements BuildManager {

    @Autowired
    private BuildDao buildDao;

    @Override
    protected GenericDao<Build, Long> getDao() {
        return this.buildDao;
    }

    public Build getBuild(long productId, String job, long buidId) {
        return this.buildDao.getBuild(productId, job, buidId);
    }

    public Build getBuildInVersion(long productId, long versionId, ProductStage stage) {
        Timestamp now = new Timestamp(new java.util.Date().getTime());
        return getBuildInVersion(productId, versionId, stage, now);
    }

    public Build getBuildInVersion(long productId, long versionId, ProductStage stage, Timestamp date) {
        if (date == null) {
            return null;
        }
        List<Build> buildList = this.getAllBuildsInVersion(productId, versionId, stage);

        if (buildList != null && !buildList.isEmpty()) {
            for (Build build : buildList) {
                if (date.before(build.getCreatedAt())) {
                    continue;
                }

                if (ProductStage.DEV == stage) {
                    if (this.isATrunkBuild(build)) {
                        return build;
                    }
                } else {
                    if (this.isBuildCertifyBeforeDate(build.getBuildCertifyHistories(), productId, stage, date)) {
                        return build;
                    }
                }

            }
        }

        return null;
    }

    private boolean isBuildCertifyBeforeDate(Set<BuildCertifyHistory> histories, long productId, ProductStage stage,
            Timestamp date) {
        if (histories != null && !histories.isEmpty()) {
            for (BuildCertifyHistory history : histories) {
                Build build = history.getBuild();
                if (build.getProduct().getId() == productId
                        && stage.toString().equalsIgnoreCase(build.getCertification())
                        && !history.getCertifiedAt().after(date)) {
                    return true;
                }
            }
        } else {
            // no certify history record, this may cause problem
            return true;
        }

        return false;
    }

    private boolean isATrunkBuild(Build build) {
        Product product = build.getProduct();
        if (!StringUtils.isNotEmpty(product.getTrunkSvnUrl())) { //trunk svn not configed.
            return true;
        }
        if (product.getTrunkSvnUrl().trim().equals(build.getSvnUrl())) {
            return true;
        }

        return false;
    }

    public List<Build> getAllBuildsInVersion(long productId, long versionId, ProductStage stage) {
        List<Build> result = new ArrayList<Build>();

        List<Build> buildList = this.buildDao.getAllBuildsForProductInVersion(productId, versionId);

        if (buildList != null && !buildList.isEmpty()) {
            for (Build build : buildList) {
                ProductStage certification = ProductStage.getProductStage(build.getCertification());
                if (ProductStage.DEV == stage) {
                    result.add(build);
                } else {
                    if (certification.isEqualOrBiggerThan(stage)) {
                        result.add(build);
                    }
                }
            }
        }

        return result;
    }

    public List<Build> getBuildsInPeriod(long productId, Timestamp startTime,
            Timestamp endTime, int pageSize, int currentPage) {
        return this.buildDao.getBuilds(productId, startTime, endTime, pageSize, currentPage);
    }

    public int getBuildsCount(long productId, Timestamp startTime, Timestamp endTime) {
        return this.buildDao.getBuildsCount(productId, startTime, endTime);
    }

    public ProductStage certifyBuild(Build build, ProductStage stage) {
        if (build != null) {
            ProductStage nextStage = stage.getNextProductStage();

            if (build != null) {
                ProductStage certification = ProductStage.getProductStage(build.getCertification());

                if (nextStage.isEqualOrBiggerThan(certification)) {
                    build.setCertification(nextStage.toString());
                    super.save(build);
                    return nextStage;
                }
            }
        }
        return null;
    }

    public Build getProductLatestBuild(long productId, ProductStage productStage) {
        return buildDao.getProductLatestBuild(productId, productStage, new Timestamp(new Date().getTime()));
    }

}
