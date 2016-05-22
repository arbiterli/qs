package com.glority.qualityserver;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.glority.qualityserver.error.ErrorFrom;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.model.SystemError;

/**
 * collect server errors. this class need SystemErrorManager, so, when the
 * methods in this class invoked, you must be sure that the spring context has
 * loaded. thus this class can not be used to collect the spring init error.
 * 
 * @author Li.heping
 * 
 */
public final class ServerErrorCollector {
    private SystemErrorManager systemErrorManager;

    private ServerErrorCollector() {

    }

    protected void setSystemErrorManager(SystemErrorManager systemErrorManager) {
        this.systemErrorManager = systemErrorManager;
    }

    /**
     * ServerErrorCollectorHolder, to deal with multithread and lazy load.
     * 
     * @author Li.heping
     * 
     */
    private static class ServerErrorCollectorHolder {
        private static final ServerErrorCollector COLLECTOR = new ServerErrorCollector();
    }

    public static ServerErrorCollector getInstance() {
        return ServerErrorCollectorHolder.COLLECTOR;
    }

    /**
     * collect server error. be sure that spring context is loaded, otherwise no
     * data will save to db. when this whole application is running, this can
     * class works will. the default ErrorFrom is QUALITY_SERVER.
     * 
     * @param info
     * @param externInfo
     */
    public void collectError(String info, String externInfo) {
        if (this.systemErrorManager != null) {
            SystemError error = this.systemErrorManager.createSystemError(ErrorFrom.QUALITY_SERVER, info, externInfo,
                    null);
            this.systemErrorManager.save(error);
        }
    }

    /**
     * collect server error. be sure that spring context is loaded, otherwise no
     * data will save to db. when this whole application is running, this can
     * class works will. the default ErrorFrom is QUALITY_SERVER.
     * 
     * @param e
     * @param externInfo
     */
    public void collectorError(Throwable e, String externInfo) {
        StringWriter strWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(strWriter);
        e.printStackTrace(printWriter);
        this.collectError(strWriter.toString(), externInfo);
    }

    /**
     * collect server error. be sure that spring context is loaded, otherwise no
     * data will save to db.when this whole application is running, this can
     * class works will. if from is null, from will be set to QUALITY_SERVER.
     * 
     * @param from
     * @param info
     * @param externInfo
     */
    public void collectError(ErrorFrom from, String info, String externInfo) {
        if (this.systemErrorManager != null) {
            ErrorFrom fFrom = from == null ? ErrorFrom.QUALITY_SERVER : from;
            SystemError error = this.systemErrorManager.createSystemError(fFrom, info, externInfo, null);
            this.systemErrorManager.save(error);
        }
    }
}
