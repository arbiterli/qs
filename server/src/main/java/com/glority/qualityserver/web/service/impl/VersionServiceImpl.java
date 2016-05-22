/**
 * 
 */
package com.glority.qualityserver.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.glority.qualityserver.exception.NoDataException;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.model.VersionExt;
import com.glority.qualityserver.web.service.VersionService;

/**
 * version service implementation.
 * 
 * @author User
 * 
 */
@Service("versionService")
public class VersionServiceImpl extends DBBaseService implements VersionService {

    public List<VersionExt> getVersionByProductId(long productId) {
        List<VersionExt> result = new ArrayList<VersionExt>();
        List<Version> versionList = super.versionManager.getVersions(productId);
        if (versionList != null && !versionList.isEmpty()) {
            for (Version version : versionList) {
                result.add(new VersionExt(version));
            }
        }
        return result;
    }

    public Version modifyVersion(Version version) {
        super.versionManager.validate(version);
        Version existVersion = super.versionManager.get(version.getId());
        if (existVersion == null) {
            throw new NoDataException();
        }

        existVersion.setDevStartTime(version.getDevStartTime());
        existVersion.setDevEndTime(version.getDevEndTime());
        existVersion.setTestStartTime(version.getTestStartTime());
        existVersion.setTestEndTime(version.getTestEndTime());
        existVersion.setStageStartTime(version.getStageStartTime());
        existVersion.setStageEndTime(version.getStageEndTime());
        existVersion.setProductionStartTime(version.getProductionStartTime());
        existVersion.setProductionEndTime(version.getProductionEndTime());

        existVersion.setSvnUrl(version.getSvnUrl());
        existVersion.setSvnRevision(version.getSvnRevision());
        existVersion.setVersion(version.getVersion());
        return super.versionManager.save(version);
    }
}
