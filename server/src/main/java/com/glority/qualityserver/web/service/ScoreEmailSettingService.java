/**
 * 
 */
package com.glority.qualityserver.web.service;

/**
 * this interface is to bind email for score.
 * 
 * @author CLB
 * 
 */
public interface ScoreEmailSettingService {
    /**
     * this method is to set email owner.
     * 
     * @param productId
     *            product id
     * @param stage
     *            DEV TEST STAGE PROD
     * @param scoreName
     *            score name
     * @param Email
     *            the score owner email
     * @return success or failed
     */
    boolean setScoreEmail(long productId, String scoreName, String email);

    boolean hasSetEmail(long productId, String scoreName);

    Object getEmail(long productId, String scoreName);
}
