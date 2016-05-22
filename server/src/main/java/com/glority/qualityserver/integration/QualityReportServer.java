package com.glority.qualityserver.integration;

import org.apache.log4j.Logger;

import com.glority.quality.connectors.reportserver.BuildReportPathStructure;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.model.Build;

/**
 * Qualitye Report Sever.
 * 
 * @author liheping
 * 
 */
public final class QualityReportServer {
    private static final Logger LOGGER = Logger.getLogger(QualityReportServer.class);
    private static final String BASE_URL_PROPERTY_KEY = "reportserver_url";

    private static QualityReportServer instance = new QualityReportServer();

    /**
     * default constructor.
     */
    private QualityReportServer() {

    }

    /**
     * method to get QualitReportServer instance.
     * 
     * @return
     */
    public static QualityReportServer getInstance() {
        return instance;
    }

    /**
     * Get the quality report path of the specified build and metrics item.
     * 
     * @param build
     * @param item
     * @return
     */
    public String getQualityReportPath(Build build, ExtendItem item) {
        if (build == null || !build.isValid()) {
            if (build == null) {
                LOGGER.error("Build is null");
            } else {
                LOGGER.error("Build is not valid: " + build.getId());
            }
            return null;
        }
        BuildReportPathStructure brps = new BuildReportPathStructure();
        brps.setBusinessUnit(build.getProduct().getGroup());
        brps.setProductName(build.getProduct().getName());
        brps.setSvnRevision(build.getSvnRevision());
        brps.setProtocol(BuildReportPathStructure.PROTOCOL_HTTP);
        brps.setJenkinsBuildId(Long.toString(build.getJenkinsBuildId()));
        brps.setBaseURL(ServerSettings.getInstance().getSetting(BASE_URL_PROPERTY_KEY));
        return brps.getQualityReportPath(true, item.getBasicItem().getLink());
    }
}
