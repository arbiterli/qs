package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.SystemErrorDao;
import com.glority.qualityserver.error.ErrorFrom;
import com.glority.qualityserver.error.ErrorStatus;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.web.model.Page;

/**
 * SystemErrorManagerImpl.
 * 
 * @author Li.heping
 * 
 */
@Service
public class SystemErrorManagerImpl extends GenericManagerImpl<SystemError, Long> implements SystemErrorManager {
    private static final Logger LOGGER = Logger.getLogger(SystemErrorManagerImpl.class);
    private static final int END_POS = 12;
    @Autowired
    private SystemErrorDao systemErrorDao;

    @Override
    protected GenericDao<SystemError, Long> getDao() {
        return this.systemErrorDao;
    }

    @Override
    public SystemError createSystemError(ErrorFrom from, String info, String externInfo, String owner) {
        SystemError error = new SystemError();
        error.setFrom(from == null ? null : from.toString());
        error.setInfo(info);
        error.setExternInfo(externInfo);
        error.setOwner(owner);
        error.setStatus(ErrorStatus.NEW.toString());
        error.setCreateTime(new Timestamp(new Date().getTime()));
        error.setUpdateTime(new Timestamp(new Date().getTime()));
        return error;
    }

    @Override
    public List<SystemError> getSystemErrors(ErrorStatus status) {
        if (status == null) {
            LOGGER.error("no status specified. empty list returned");
            return new ArrayList<SystemError>();
        }
        return this.systemErrorDao.getSystemErrors(status.toString());
    }

    @Override
    public Page<SystemError> getErrorPage(int pageIndex, int limit, int pages) {
        if (!isPageIndexOk(pageIndex, limit)) {
            return null;
        }
        List<SystemError> systemErrors = this.systemErrorDao.getLimittedSystemErrors(pageIndex, limit);
        for (int i = 0; i < systemErrors.size(); i++) {
            String info = systemErrors.get(i).getInfo();
            if (info != null && info.length() > END_POS) {
                    info = info.substring(0, END_POS);
                    info += "...";
                    systemErrors.get(i).setInfo(info);
            }
        }
        Page<SystemError> page = new Page<SystemError>();
        page.setRecords(systemErrors);
        page.setCurrentPage(pageIndex);
        page.setRowsPerPage(limit);
        page.setTotalPages(getTotalPages(limit));
        return page;
    }

    private boolean isPageIndexOk(int pageIndex, int limit) {
        long totalPages = getTotalPages(limit);
        return pageIndex >= 1 && pageIndex <= totalPages;
    }

    private long getTotalPages(int limit) {
        long rowCount = this.systemErrorDao.getRowCount();
        long totalPages = rowCount / limit + (rowCount % limit != 0 ? 1 : 0);
        return totalPages;
    }
}
