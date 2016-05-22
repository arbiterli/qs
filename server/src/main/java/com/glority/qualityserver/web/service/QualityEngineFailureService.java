package com.glority.qualityserver.web.service;

import java.util.List;

import com.glority.qualityserver.model.QualityEngineFailure;
/**
 * Quality Engine Failure Service interface.
 */
public interface QualityEngineFailureService {

    void reportFailure(QualityEngineFailure entity);

    List<QualityEngineFailure> getAllQualityEngineFailues();

    List<QualityEngineFailure> getQualityEngineFailures(String task);
}
