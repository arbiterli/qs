package com.glority.qualityserver.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.ServerErrorCollector;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.QualitySystemErrorService;

/**
 * QualitySystemErrorServiceImpl.
 * 
 * @author liheping
 * 
 */
@Service
public class QualitySystemErrorServiceImpl implements QualitySystemErrorService {
    private static final Logger LOGGER = Logger.getLogger(QualitySystemErrorServiceImpl.class);


    @Override
    public void doProcessAlerts(Server server, String detail) {
        LOGGER.error("server - " + server.getId() + " " + detail);
        ServerErrorCollector.getInstance().collectError(detail, "server : " + server.getName());
    }

}
