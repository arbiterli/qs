package com.glority.qualityserver.service;

import com.glority.qualityserver.model.Server;

/**
 * Interface for QualitySystem Error Service.
 * 
 * @author liheping
 * 
 */
public interface QualitySystemErrorService {
    void doProcessAlerts(Server server, String detail);
}
