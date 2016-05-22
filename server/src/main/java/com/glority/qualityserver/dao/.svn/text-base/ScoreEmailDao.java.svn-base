package com.glority.qualityserver.dao;

import com.glority.qualityserver.model.ScoreEmail;
/**
 * the interface of score owner email dao.
 * @author Administrator
 *
 */
public interface ScoreEmailDao extends GenericDao<ScoreEmail, Long> {

    boolean save(long productId, String scoreName, String email);

    ScoreEmail getScoreEmailBy(long productId, String scoreName);

    boolean hasSetEmail(long productId, String scoreName);

    Object getEmail(long productId, String scoreName);
}
