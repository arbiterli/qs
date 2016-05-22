package com.glority.qualityserver.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.error.ErrorStatus;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.util.DaoUtils;
import com.glority.qualityserver.web.model.NavigationLink;
import com.glority.qualityserver.web.service.BuildService;
import com.glority.qualityserver.web.service.DeployService;
import com.glority.qualityserver.web.service.PhaseService;
import com.glority.qualityserver.web.service.ProductService;
import com.glority.qualityserver.web.service.RoleService;
import com.glority.qualityserver.web.service.SystemErrorService;
import com.glority.qualityserver.web.service.SystemUserService;
import com.glority.qualityserver.web.service.VersionService;

/**
 * this controller contains all the functions to parse parameter from http
 * request.
 * 
 * @author liheping
 * 
 */
public abstract class BasicController {
    /**
     * url for all the pages.
     */
    public static final String URL_PRODUCT_LIST = "/productlist";
    public static final String URL_PRODUCT = "/product";
    public static final String URL_PHASE = "/phase";
    public static final String URL_BUILD_REPORT_LIST = "/buildlist";
    public static final String URL_BUILD_REPORT = "/buildreport";
    public static final String URL_DEPLOY_HISTORY = "/deployhistory";

    /**
     * all the pages.
     */
    public static final String PAGE_SYSTEM_ERROR_DETAIL = "errordetail";
    public static final String PAGE_SYSTEM_ERROR = "systemerror";
    public static final String PAGE_PRODUCT_LIST = "productlist";
    public static final String PAGE_PRODUCT = "product";
    public static final String PAGE_PHASE = "phase";
    public static final String PAGE_BUILD_REPORT_LIST = "buildReportList";
    public static final String PAGE_BUILD_REPORT = "buildReport";
    public static final String PAGE_BUILD_DETAIL = "buildDetail";
    public static final String PAGE_HOT_DEPLOY = "hotDeploy";
    public static final String PAGE_SVN_SYNC = "svnSync";
    public static final String PAGE_SYNC_TO_OR_FROM_PRODUCTION = "syncToOrFromProduction";

    public static final String PHASE_ID = "phaseId";
    public static final String SERVER_ID = "serverId";
    public static final String PRODUCT_ID = "productId";
    public static final String BUILD_ID = "buildId";
    public static final String USER_ID = "userId";
    public static final String FAILURE_ID = "failureId";
    public static final String VERSION_ID = "versionId";

    public static final String DEPLOY_REVISION = "deployRevision";

    public static final String PAGE = "page";

    public static final String PRODUCT_NAME = "productName";
    public static final String DATE = "date";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";

    public static final String OPERATION = "operation";
    public static final String STATUS = "status";

    public static final String LOG_KEY = "logKey";

    public static final String STAGE = "stage";

    public static final String PAGE_MESSAGE = "pageMessage";
    public static final String ERROR = "error";
    public static final String ACCESS_DENIED = "denied";
    public static final String LOGOUT = "logout";

    public static final String USERNAME = "username";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static final String USER_ROLE = "role";

    public static final String TITLE = "title";
    public static final String PAGE_NAVIGATION_LINKS = "navigationLinks";

    private static final String DEPLOY_HISTORY_SUFFIX = "&stage=production";

    @Autowired
    protected ProductService productService;
    @Autowired
    protected PhaseService phaseService;
    @Autowired
    protected BuildService buildService;
    @Autowired
    protected DeployService deployService;
    @Autowired
    protected SystemUserService userService;
    @Autowired
    protected AccessControlService aclService;
    @Autowired
    protected VersionService versionService;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected SystemErrorService systemErrorService;

    protected long getProductId(HttpServletRequest request) {
        String productIdString = request.getParameter(PRODUCT_ID);

        return DaoUtils.parseStringToId(productIdString);
    }

    protected long getBuildId(HttpServletRequest request) {
        String buildIdString = request.getParameter(BUILD_ID);

        return DaoUtils.parseStringToId(buildIdString);
    }

    protected ProductStage getProductStage(HttpServletRequest request) {
        String stageString = request.getParameter(STAGE);

        return ProductStage.getProductStage(stageString);
    }

    protected UserRole getUserRole(HttpServletRequest request) {
        String roleString = request.getParameter(USER_ROLE);

        return UserRole.getUserRole(roleString);
    }

    protected boolean setRequestProductInfo(HttpServletRequest request) {
        Product product = null;

        long productId = this.getProductId(request);
        if (productId > 0) {
            product = this.productService.getProductById(productId);
            if (product == null) {
                return false;
            }
        }
        long buildId = this.getBuildId(request);
        if (buildId > 0) {
            product = this.productService.getProductByBuild(buildId);
            if (product == null) {
                return false;
            }
        }

        if (product == null) {
            return false;
        }

        request.setAttribute(PRODUCT_ID, product.getId());
        request.setAttribute(PRODUCT_NAME, product.getDisplayName());
        return true;
    }

    private String formProductListPageLink() {
        return URL_PRODUCT_LIST;
    }

    private String formProductPageLink(long productId) {
        return URL_PRODUCT + "?" + PRODUCT_ID + "=" + productId;
    }

    private String formDeployHistoryLink(long productId) {
        return URL_DEPLOY_HISTORY + "?" + PRODUCT_ID + "=" + productId + DEPLOY_HISTORY_SUFFIX;
    }

    private String formBuildReportListPage(long productId) {
        return URL_BUILD_REPORT_LIST + "?" + PRODUCT_ID + "=" + productId;
    }

    protected void setPageTitleAndNavigationLinks(HttpServletRequest request, String page) {
        if (page == null || request == null) {
            return;
        }

        List<NavigationLink> links = new ArrayList<NavigationLink>();

        if (PAGE_PRODUCT_LIST.equalsIgnoreCase(page)) {
            NavigationLink productListLink = new NavigationLink();
            productListLink.setTitle("Dashboard");
            productListLink.setLastOne(true);
            links.add(productListLink);
        } else if (PAGE_PRODUCT.equalsIgnoreCase(page)) {
            long productId = this.getProductId(request);

            if (productId < 0) {
                return;
            }

            NavigationLink productListLink = new NavigationLink();
            productListLink.setTitle("Dashboard");
            productListLink.setLink(this.formProductListPageLink());
            links.add(productListLink);

            NavigationLink productLink = new NavigationLink();
            productLink.setTitle(this.productService.getProductNameForDisplay(productId));
            productLink.setLastOne(true);
            links.add(productLink);
        } else if (PAGE_PHASE.equalsIgnoreCase(page)) {
            long buildId = this.getBuildId(request);
            ProductStage stage = this.getProductStage(request);
            if (buildId < 0 || stage == ProductStage.INVALID) {
                return;
            }
            Product product = this.productService.getProductByBuild(buildId);

            NavigationLink productListLink = new NavigationLink();
            productListLink.setTitle("Dashboard");
            productListLink.setLink(this.formProductListPageLink());
            links.add(productListLink);

            NavigationLink productLink = new NavigationLink();
            productLink.setTitle(this.productService.getProductNameForDisplay(product.getId()));
            productLink.setLink(this.formProductPageLink(product.getId()));
            links.add(productLink);

            NavigationLink phaseLink = new NavigationLink();
            phaseLink.setTitle(stage.toString() + " Phase");
            phaseLink.setLastOne(true);
            links.add(phaseLink);
        } else if (PAGE_BUILD_REPORT_LIST.equalsIgnoreCase(page)) {
            long productId = this.getProductId(request);
            if (productId < 0) {
                return;
            }
            NavigationLink productListLink = new NavigationLink();
            productListLink.setTitle("Dashboard");
            productListLink.setLink(this.formProductListPageLink());
            links.add(productListLink);

            NavigationLink productLink = new NavigationLink();
            productLink.setTitle(this.productService.getProductNameForDisplay(productId));
            productLink.setLink(this.formProductPageLink(productId));
            links.add(productLink);

            NavigationLink buildReprotListLink = new NavigationLink();
            buildReprotListLink.setTitle("Build Report List");
            buildReprotListLink.setLastOne(true);
            links.add(buildReprotListLink);
        } else if (PAGE_BUILD_REPORT.equalsIgnoreCase(page)) {
            long productId = this.getProductId(request);
            if (productId < 0) {
                return;
            }
            NavigationLink productListLink = new NavigationLink();
            productListLink.setTitle("Dashboard");
            productListLink.setLink(this.formProductListPageLink());
            links.add(productListLink);

            NavigationLink productLink = new NavigationLink();
            productLink.setTitle(this.productService.getProductNameForDisplay(productId));
            productLink.setLink(this.formProductPageLink(productId));
            links.add(productLink);

            NavigationLink buildReportListLink = new NavigationLink();
            buildReportListLink.setTitle("Build Report List");
            buildReportListLink.setLink(this.formBuildReportListPage(productId));
            links.add(buildReportListLink);

            NavigationLink buildReportLink = new NavigationLink();
            buildReportLink.setTitle("Build Report");
            buildReportLink.setLastOne(true);
            links.add(buildReportLink);
        } else if (PAGE_BUILD_DETAIL.equalsIgnoreCase(page)) {
            long productId = this.getProductId(request);
            if (productId < 0) {
                return;
            }
            NavigationLink productListLink = new NavigationLink();
            productListLink.setTitle("Dashboard");
            productListLink.setLink(this.formProductListPageLink());
            links.add(productListLink);

            NavigationLink productLink = new NavigationLink();
            productLink.setTitle(this.productService.getProductNameForDisplay(productId));
            productLink.setLink(this.formProductPageLink(productId));
            links.add(productLink);

            NavigationLink buildDetailLink = new NavigationLink();
            buildDetailLink.setTitle("Build Detail");
            buildDetailLink.setLastOne(true);
            links.add(buildDetailLink);
        } else if (PAGE_HOT_DEPLOY.equalsIgnoreCase(page)) {
            NavigationLink hotDeployLink = new NavigationLink();
            hotDeployLink.setTitle("Hot Deploy");
            hotDeployLink.setLastOne(true);
            links.add(hotDeployLink);
        } else if (PAGE_SVN_SYNC.equalsIgnoreCase(page)) {
            long productId = this.getProductId(request);
            NavigationLink hotDeployLink = new NavigationLink();
            hotDeployLink.setTitle("Hot Deploy");
            hotDeployLink.setLink(this.formDeployHistoryLink(productId));
            links.add(hotDeployLink);
            NavigationLink svnSyncLink = new NavigationLink();
            svnSyncLink.setTitle("SVN Sync");
            svnSyncLink.setLastOne(true);
            links.add(svnSyncLink);
        } else if (PAGE_SYNC_TO_OR_FROM_PRODUCTION.equals(page)) {
            long productId = this.getProductId(request);
            NavigationLink hotDeployLink = new NavigationLink();
            hotDeployLink.setTitle("Hot Deploy");
            hotDeployLink.setLink(this.formDeployHistoryLink(productId));
            links.add(hotDeployLink);
            NavigationLink svnSyncLink = new NavigationLink();
            svnSyncLink.setTitle(request.getAttribute("title").toString());
            svnSyncLink.setLastOne(true);
            links.add(svnSyncLink);
        }
        if (!links.isEmpty()) {
            NavigationLink lastLink = links.get(links.size() - 1);
            request.setAttribute(TITLE, lastLink.getTitle());
            request.setAttribute(PAGE_NAVIGATION_LINKS, links);
        }
    }

    public ErrorStatus getErrorStatus(HttpServletRequest request) {
        String statusString = request.getParameter(STATUS);
        ErrorStatus status = ErrorStatus.getValueOf(statusString);
        return status;
    }

}
