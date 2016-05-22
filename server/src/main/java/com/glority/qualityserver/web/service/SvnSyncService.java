package com.glority.qualityserver.web.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;

import com.glority.qualityserver.model.Product;

/**
 * svn sync interface.
 * 
 * @author zm.
 * 
 */
public interface SvnSyncService {

    /**
     * to get svn log of a product.
     * 
     * @param svnUrl
     *            the svn url
     * @return the svn logs.
     */
    JSONArray getProductSvnLog(Map<String, String> paramMap);

    /**
     * to init cache.
     * 
     * @param product
     *            the product.
     * @param deployRevision
     *            the deploy revision
     */
    void initCache(Product product, String deployRevision);

    /**
     * to refresh cache.
     * 
     * @param product
     *            the product.
     * @param deployRevision
     *            the deployrevision.
     */
    void refreshCache(Product product, String deployRevision);

    /**
     * to get cache size.
     * 
     * @return the cache size.
     */
    int getCacheSize();

    /**
     * to get svn diff of two revision.
     * 
     * @param productId
     *            the product Id.
     * @param revNew
     *            the old revision.
     * @param revOld
     *            the new revision.
     * @return a list of diff string.
     */
    List<String> getSvnDiff(String productId, String revNew, String revOld);

    /**
     * to get the last refresh time.
     * @return the last refresh time.
     */
    Date getLastRefreshTime();
}
