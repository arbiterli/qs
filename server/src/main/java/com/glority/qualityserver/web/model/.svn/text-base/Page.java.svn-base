/**
 * 
 */
package com.glority.qualityserver.web.model;

import java.util.ArrayList;
import java.util.List;

/**page for pagination
 * 
 * @author CLB
 *
 * @param <T> info for displaying.
 */
public class Page<T> {
    private List<T> records;
    private long currentPage;
    private long rowsPerPage;
    private long totalPages;

    public List<T> getRecords() {
        return records;
    }
    public void setRecords(List<T> records) {
        this.records = records;
    }
    public long getCurrentPage() {
        return currentPage;
    }
    public long getRowsPerPage() {
        return rowsPerPage;
    }
    public void setRowsPerPage(long rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }
    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }
    public long getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
    /**
     * has previous page.
     * @return if has pre page return true else return false.
     */
    public boolean hasPrePage() {
        return (currentPage > 1) && (currentPage <= totalPages);
    }
    /**
     * has next page.
     * @return if has next page return true else return false
     */
    public boolean hasNextPage() {
        return (currentPage >= 1) && (currentPage < totalPages);
    }
    /**
     * get previous page
     * @return page index .
     */
    public long getPrePage() {
        return currentPage - 1 < 1 ? 1 : currentPage;
    }
    /**
     * get next page.
     * @return page index.
     */
    public long getNextPage() {
        return currentPage + 1 > totalPages ? totalPages : currentPage + 1;
    }

    /**
     * get page links for current page.
     * @param url
     * @param pagesForDisplay
     * @return links
     */
    public List<PageLink> getPageLinks(String url, int pagesForDisplay) {
        List<PageLink> links = new ArrayList<PageLink>();
        long endPage = currentPage + pagesForDisplay / 2;
        if (endPage > totalPages) {
            endPage = totalPages;
        }
        long startPage = endPage - pagesForDisplay + 1;
        if (startPage < 1) {
            startPage = 1;
        }
        if (endPage - startPage + 1 < pagesForDisplay) {
            endPage += pagesForDisplay - (endPage - startPage + 1);
            if (endPage > totalPages) {
                endPage = totalPages;
            }
        }
        for (long i = startPage; i <= endPage; i++) {
            PageLink pageLink = new PageLink();
            pageLink.setPage(i);
            pageLink.setUrl(url + i);
            links.add(pageLink);
        }
        return links;
    }
}
