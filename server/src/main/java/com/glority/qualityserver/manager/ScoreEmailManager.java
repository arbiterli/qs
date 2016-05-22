/**
 * 
 */
package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.ScoreEmail;

/**
 * ScoreOwnerEmailManager interface.
 * @author CLB
 * 
 */
public interface ScoreEmailManager extends GenericManager<ScoreEmail, Long> {
    boolean save(long productId, String scoreName, String email);
    List<String> getScoreEmailBy(Product product, String scoreName);
    boolean hasSetEmail(long productId, String scoreName);
    Object getEmail(long productId, String scoreName);
}
