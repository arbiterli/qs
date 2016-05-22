/**
 * 
 */
package com.glority.qualityserver.web.service.impl;

import org.springframework.stereotype.Service;

import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.model.Page;
import com.glority.qualityserver.web.service.SystemErrorService;

/**
 * the implement of SystemErrorService.
 * @author CLB
 *
 */
@Service("systemErrorService")
public class SystemErrorServiceImpl extends DBBaseService implements SystemErrorService {
    @Override
    public Page<SystemError> getErrorPage(int pageIndex, int limit, int pages) {
        return super.systemErrorManager.getErrorPage(pageIndex, limit, pages);
    }

    @Override
    public SystemError get(long errorId) {
       return super.systemErrorManager.get(errorId);
    }

}
