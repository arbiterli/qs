package com.glority.qualityserver.metricengine;

import java.util.HashMap;
import java.util.Map;

/**
 * ItemContainer to contain all the item that parsed form metricEngine.xml.
 * 
 * @author liheping
 * 
 */
public class ItemContainer {
    protected Map<String, BasicItem> itemMap = new HashMap<String, BasicItem>();

    protected MetricEngineCache metricCache;
    protected MetricEngineProfile profile;

    public void setMetricCache(MetricEngineCache metricCache) {
        this.metricCache = metricCache;
    }

    public void add(BasicItem item) {
        if (item == null) {
            return;
        }
        // item.registToContainer(this);

        if (item.getId() != null) {
            BasicItem existItem = this.itemMap.get(item.getId());
            if (existItem == null) {
                this.itemMap.put(item.getId(), item);
            }
        }
    }

    public BasicItem getItem(String key) {
        return this.itemMap.get(key);
    }

}
