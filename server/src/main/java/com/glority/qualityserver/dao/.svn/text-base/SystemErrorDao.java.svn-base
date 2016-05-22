package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.SystemError;

/**
 * SystemErrorDao interface.
 * 
 * @author Li.heping
 * 
 */
public interface SystemErrorDao extends GenericDao<SystemError, Long> {
    /**
     * get specified Status errors;
     * 
     * @param status
     *            , ErrorStatus.toString().
     * @return
     */
    List<SystemError> getSystemErrors(String status);
    /**
     * get system error from db.
     * @param pageIndex
     * @param limit
     * @return list of system error
     */
    List<SystemError> getLimittedSystemErrors(int pageIndex, int limit);
    /**
     * get row count.
     * @return the count of row.
     */
    long getRowCount();
}
