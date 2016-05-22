package com.glority.qualityserver.web.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glority.quality.connectors.ssh.SSHExec;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.dao.ProductDao;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.web.service.SvnSyncService;
import com.glority.qualityserver.web.service.impl.SvnSyncServiceImpl;

/**
 * to hold all request to hotdeploy.
 * 
 * @author zm
 * 
 */
@Controller
@RequestMapping("/svnsync")
public class HotDeployController extends BasicController {

    private static final Logger LOGGER = Logger.getLogger(HotDeployController.class);

    private static final String SYNC_TO_PRODUCTION = "Sync To Production";

    private static final String TITLE = "title";

    private static final String OP_DIRECT = "direct";

    private static final String TO = "to";

    private static final String UPDATE_REVISION = "updateRevision";

    private static final String PROP_FILE_PATH = "hotdeploy.properties";

    private static final String PRODUCT_URL = "productionSiteUrl";

    private static final String OPERATION_SERVER = "operationServer";

    private static final String TARGET_URL = "targetUrl";

    private static final String DIFF = "diff";

    private static final String FIRST_PAGE = "1";

    private static final String SPACE = "&nbsp;";

    private static final String BR_TAG = "</br>";

    private static final String SSH_USER = "root";

    private static final String SSH_PASSWORD = "123456";

    private static final String PREVIEW_SITE_URL = "previewSiteUrl";

    private static final String SCRIPTS_PATH = "scriptsPath";

    private static final String SYNC_TO_PRODUCT_DIFF_SH = "synctoproductionchangelist.sh";

    private static final String SYNC_TO_PRODUCT_SH = "synctoproduction.sh";

    private static final String HOT_APPLY_SH = "hotapply.sh";

    private static final String REFRESH = "refresh";

    private static final String NIL = "nil";

    private String productUrl;

    private String operationServer;

    private String previewUrl;

    private String scriptsPath;

    /**
     * to hold all log of product.
     */
    private Map<String, SvnSyncService> svnCache;

    /**
     * productId, revision map.
     */
    private Map<String, String> revisionMap;

    @Autowired
    private ProductDao productDao;

    @PostConstruct
    public void initCache() {
        svnCache = new HashMap<String, SvnSyncService>();
        revisionMap = new HashMap<String, String>();
        Properties prop = new Properties();
        try {
            prop.load(FeatureGate.class.getClassLoader().getResourceAsStream(PROP_FILE_PATH));
            this.productUrl = prop.get(PRODUCT_URL).toString();
            this.operationServer = prop.get(OPERATION_SERVER).toString();
            this.scriptsPath = prop.get(SCRIPTS_PATH).toString();
            this.previewUrl = prop.get(PREVIEW_SITE_URL).toString();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @RequestMapping("/svnpanel")
    public String getSvnPanel(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter(PRODUCT_ID);
        super.setPageTitleAndNavigationLinks(request, PAGE_SVN_SYNC);
        Deploy historyRecord = super.deployService.getLatestHotdeployRecord(Long.parseLong(productId));
        String deployRevision;
        if (null != historyRecord && null != historyRecord.getSvnRevision()) {
            deployRevision = historyRecord.getSvnRevision().toString();
        } else {
            deployRevision = NIL;
        }
        request.setAttribute(PRODUCT_ID, productId);
        request.setAttribute(DEPLOY_REVISION, deployRevision);
        request.setAttribute(TARGET_URL, previewUrl);
        return "svnsync";
    }

    @RequestMapping("/svnlog")
    public synchronized void getSvnLog(HttpServletRequest request, HttpServletResponse response) {
        JSONObject res = new JSONObject();
        String sEcho = request.getParameter("sEcho");
        String productId = request.getParameter(PRODUCT_ID);
        String deployRevision = request.getParameter(DEPLOY_REVISION);
        String type = request.getParameter("type");
        SvnSyncService svnSyncService;
        if (sEcho.equals(FIRST_PAGE)) {
            Product product = this.productDao.getProductById(Long.parseLong(productId));
            svnSyncService = new SvnSyncServiceImpl();
            if (REFRESH.equals(type)) {
                svnSyncService.refreshCache(product, deployRevision);
            } else {
                svnSyncService.initCache(product, deployRevision);
            }
            svnCache.put(productId, svnSyncService);
        } else {
            svnSyncService = svnCache.get(productId);
        }
        try {
            res.put("iTotalRecords", svnSyncService.getCacheSize());
            res.put("iTotalDisplayRecords", svnSyncService.getCacheSize());
            res.put("aaData", svnSyncService.getProductSvnLog(getUsefulParamMap(request)));
            response.setContentType("application/Json");
            response.getWriter().print(res.toString());
        } catch (JSONException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @RequestMapping("/svndiff")
    public synchronized void getSvnDiff(HttpServletRequest request, HttpServletResponse response) {
        List<String> diffs = new ArrayList<String>();
        String revisionOne = request.getParameter("revOne");
        String revisionTwo = request.getParameter("revTwo");
        String productId = request.getParameter(PRODUCT_ID);
        SvnSyncService svnSyncService = svnCache.get(productId);
        diffs = svnSyncService.getSvnDiff(productId, revisionOne, revisionTwo);
        StringBuilder sbDiff = new StringBuilder();
        for (String diff : diffs) {
            sbDiff.append("<div>" + diff + "</div>");
        }
        try {
            response.setContentType("text/plain");
            response.getWriter().print(sbDiff.toString());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    /**
     * rm -r -f /opt/hotdeploy/source/hot/sites.
     * 
     * @param request
     *            the request
     * @param response
     *            the response
     */
    @RequestMapping("/svnupdate")
    public synchronized void doSvnUpdate(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter(PRODUCT_ID);
        String updateRevision = request.getParameter(UPDATE_REVISION);
        Product product = this.productDao.getProductById(Long.parseLong(productId));
        String nextVersion = super.deployService.getVersionnForSyncToProduction(product.getName());
        String currentVersion = super.deployService.getActiveDeploy(product.getName(), Constants.SERVER_TYPE_PREVIEW)
                .get("currentVersion").toString();
        response.setContentType("text/plain");
        try {
            execSSH("/bin/sh " + this.scriptsPath + HOT_APPLY_SH + " " + currentVersion + " " + nextVersion);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            try {
                response.getWriter().print(false);
            } catch (IOException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
        User user = (User) request.getAttribute("user");
        try {
            super.deployService.hotDeploy(product.getName(), user.getName(),
                    updateRevision);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        revisionMap.put(productId, updateRevision);
        try {
            response.getWriter().print(true);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return;
    }

    @RequestMapping("/synctopro")
    public String syncToProduction(HttpServletRequest request, HttpServletResponse response) {
        String diff;
        try {
            diff = execSSH("/bin/sh " + this.scriptsPath + SYNC_TO_PRODUCT_DIFF_SH);
        } catch (Exception e) {
            diff = e.getMessage();
            LOGGER.info(e.getMessage());
        }
        request.setAttribute(TARGET_URL, this.productUrl);
        String productId = request.getParameter(PRODUCT_ID);
        Product product = productDao.getProductById(Long.parseLong(productId));
        String productName = product.getName();
        String nextVersion = super.deployService.getVersionnForSyncToProduction(productName);
        request.setAttribute("nextVersion", nextVersion);
        Map<Object, Object> infoMap = super.deployService.getActiveDeploy(productName, Constants.SERVER_TYPE_OFFICIAL);
        request.setAttribute("infoMap", infoMap);
        request.setAttribute(TITLE, SYNC_TO_PRODUCTION);
        request.setAttribute(OP_DIRECT, TO);
        request.setAttribute(PRODUCT_ID, product.getId());
        request.setAttribute(DIFF, diff);
        super.setPageTitleAndNavigationLinks(request, PAGE_SYNC_TO_OR_FROM_PRODUCTION);
        return "syncproandprev";
    }

    @RequestMapping("/dosynctopro")
    public void doSyncToProduct(HttpServletRequest request, HttpServletResponse response) {
        String result;
        response.setContentType("text/plain");
        try {
            result = execSSH("/bin/sh " + this.scriptsPath + SYNC_TO_PRODUCT_SH);
        } catch (Exception e) {
            try {
                response.getWriter().print("sync failed");
            } catch (IOException ex) {
                LOGGER.info(ex.getMessage());
            }
            return;
        }
        String productId = request.getParameter(PRODUCT_ID);
        Product product = productDao.getProductById(Long.parseLong(productId));
        Deploy historyRecord = super.deployService.getLatestHotdeployRecord(Long.parseLong(productId));
        if (null != historyRecord) {
            super.deployService.syncToProductionServerVersion(product.getName());
        }
        try {
            response.getWriter().print(result);
            response.getWriter().print("");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return;
    }


    @RequestMapping("/lastrefreshtime")
    public void getLastRefreshTime(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter(PRODUCT_ID);
        SvnSyncService svnSyncService = svnCache.get(productId);
        if (svnSyncService != null) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                response.setContentType("text/plain");
                response.getWriter().print(format.format(svnSyncService.getLastRefreshTime()));
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return;
    }

    private Map<String, String> getUsefulParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("iDisplayStart", request.getParameter("iDisplayStart"));
        paramMap.put("iDisplayLength", request.getParameter("iDisplayLength"));
        return paramMap;

    }

    private synchronized String execSSH(String cmd) throws Exception {
        SSHExec exec = new SSHExec();
        exec.setHost(this.operationServer);
        exec.setUsername(SSH_USER);
        exec.setPassword(SSH_PASSWORD);
        exec.setCommand(cmd);
        exec.setTrust(true);
        exec.setProject(new Project());
        exec.process();
        if (exec.getExitCode() > 0) {
            throw new Exception("run ssh failed at" + cmd);
        }
        ByteArrayOutputStream resultStream = (ByteArrayOutputStream) exec.getOutStream();
        BufferedReader resultReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
                resultStream.toByteArray())));
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = resultReader.readLine()) != null) {
                line.replace(" ", SPACE);
                sb.append(line + BR_TAG);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return sb.toString();
    }
}
