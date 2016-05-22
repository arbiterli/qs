package com.glority.qualityserver.web.model;
/**
 * this is the page link
 * @author CLB
 *
 */
public class PageLink {
    private long page;
    private String url;
    public long getPage() {
        return page;
    }
    public void setPage(long page) {
        this.page = page;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "PageLink [page=" + page + ", url=" + url + "]";
    }
}
