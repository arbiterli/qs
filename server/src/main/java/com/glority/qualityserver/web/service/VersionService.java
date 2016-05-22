/**
 * 
 */
package com.glority.qualityserver.web.service;

import java.util.List;

import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.web.model.VersionExt;

/**
 * version service.
 * 
 * @author User
 * 
 */
public interface VersionService {
    /**
     * get version by product id.
     * 
     * @return list of version
     */
    List<VersionExt> getVersionByProductId(long productId);

    /**
     * modify version.
     */
    Version modifyVersion(Version version);
}
