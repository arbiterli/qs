package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.error.ErrorFrom;
import com.glority.qualityserver.error.ErrorStatus;
import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.web.model.Page;

/**
 * SystemErrorManager.
 * 
 * @author li.heping
 * 
 */
public interface SystemErrorManager extends GenericManager<SystemError, Long> {
    /**
     * create a system error, based on the input info.
     * 
     * @param from
     * @param info
     * @param externInfo
     * @param owner
     * @return
     */
    SystemError createSystemError(ErrorFrom from, String info, String externInfo, String owner);

    /**
     * get all systemErrors with the specified status.
     * 
     * @param status
     * @return
     */
    List<SystemError> getSystemErrors(ErrorStatus status);
    /**
     * this method is to get error page.
     * @param pageIndex
     * @return error page.
     */
    Page<SystemError> getErrorPage(int pageIndex, int limit, int pages);
}
