package com.glority.qualityserver.service;

/**
 * ScoreCheckService. specified for Score Check Job.
 * 
 * @author li.heping
 * 
 */
public interface ScoreCheckService {
    /**
     * check Score, and send email.
     */
    void checkScore();
}
