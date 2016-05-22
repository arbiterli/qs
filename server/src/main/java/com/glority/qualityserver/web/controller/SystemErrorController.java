/**
 * 
 */
package com.glority.qualityserver.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glority.qualityserver.model.SystemError;
import com.glority.qualityserver.web.model.Page;

/**
 * this is the system error controller.
 * 
 * @author CLB
 * 
 */
@Controller
@RequestMapping("/systemerror")
public class SystemErrorController extends BasicController {
    private static final int LIMIT = 50;
    private static final String PAGE_INDEX = "pageIndex";
    private static final String ERROR_ID = "errorId";
    private static final int PAGES = 15;
    private static final String URL = "/systemerror?pageIndex=";

    @RequestMapping("/error")
    public String getSystemErrors(@RequestParam(value = PAGE_INDEX, defaultValue = "-1") int pageIndex,
            HttpServletRequest request, HttpServletResponse response) {
        int getIndex = 1;
        if (pageIndex > 0) {
            getIndex = pageIndex;
        }
        super.setPageTitleAndNavigationLinks(request, PAGE_SYSTEM_ERROR);
        Page<SystemError> page = super.systemErrorService.getErrorPage(getIndex, LIMIT, PAGES);
        request.setAttribute("page", page);
        if (page != null) {
            request.setAttribute("pageLinks", page.getPageLinks(URL, PAGES));
            request.setAttribute("prePageLink", page.hasPrePage() ? URL + page.getPrePage() : null);
            request.setAttribute("nextPageLink", page.hasNextPage() ? URL + page.getNextPage() : null);
        }
        return "systemerrors";
    }

    @RequestMapping("/detail")
    public String getSystemErrorInfo(@RequestParam(value = ERROR_ID, defaultValue = "-1") int errorId,
            HttpServletRequest request, HttpServletResponse response) {
        if (errorId < 0) {
            return ERROR;
        }
        super.setPageTitleAndNavigationLinks(request, PAGE_SYSTEM_ERROR_DETAIL);
        SystemError systemError = super.systemErrorService.get(errorId);
        request.setAttribute("error", systemError);
        return "systemerrorinfo";
    }
}
