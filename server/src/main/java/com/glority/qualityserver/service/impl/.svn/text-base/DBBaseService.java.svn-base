package com.glority.qualityserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.manager.AlertManager;
import com.glority.qualityserver.manager.BuildCertifyHistoryManager;
import com.glority.qualityserver.manager.BuildManager;
import com.glority.qualityserver.manager.BuildMetricManager;
import com.glority.qualityserver.manager.ConfigurationManager;
import com.glority.qualityserver.manager.DeployManager;
import com.glority.qualityserver.manager.FailureManager;
import com.glority.qualityserver.manager.IssueManager;
import com.glority.qualityserver.manager.PhaseManager;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.manager.QualityEngineFailureManager;
import com.glority.qualityserver.manager.RecordMetricManager;
import com.glority.qualityserver.manager.ScoreEmailManager;
import com.glority.qualityserver.manager.ScoreOwnerMappingManager;
import com.glority.qualityserver.manager.ServerManager;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.manager.SystemRoleManager;
import com.glority.qualityserver.manager.SystemUserManager;
import com.glority.qualityserver.manager.TestCaseManager;
import com.glority.qualityserver.manager.TestGroupManager;
import com.glority.qualityserver.manager.TestManager;
import com.glority.qualityserver.manager.TestSuiteManager;
import com.glority.qualityserver.manager.VersionManager;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Server;

/**
 * DB base service.
 * 
 * @author liheping
 * 
 */
public class DBBaseService {
    @Autowired
    protected ProductManager productManager;
    @Autowired
    protected BuildManager buildManager;
    @Autowired
    protected ConfigurationManager configurationManager;
    @Autowired
    protected TestManager testManager;
    @Autowired
    protected TestGroupManager testGroupManager;
    @Autowired
    protected BuildMetricManager metricManager;
    @Autowired
    protected TestCaseManager testCaseManager;
    @Autowired
    protected TestSuiteManager testSuiteManger;
    @Autowired
    protected VersionManager versionManager;
    @Autowired
    protected FailureManager failureManager;
    @Autowired
    protected PhaseManager phaseManager;
    @Autowired
    protected ServerManager serverManager;
    @Autowired
    protected DeployManager deployManager;
    @Autowired
    protected SystemUserManager userManager;
    @Autowired
    protected SystemRoleManager roleManager;
    @Autowired
    protected RecordMetricManager recordMetricManager;
    @Autowired
    protected BuildCertifyHistoryManager buildCertifyHistoryManager;
    @Autowired
    protected IssueManager issueManager;
    @Autowired
    protected QualityEngineFailureManager qualityEngineFailureManager;
    @Autowired
    protected ScoreOwnerMappingManager scoreOwnerMappingManager;
    @Autowired
    protected AlertManager alertManager;
    @Autowired
    protected ScoreEmailManager scoreEmailManager;
    @Autowired
    protected SystemErrorManager systemErrorManager;

    protected String parseDeployScript(Server server, long buildId) {
        final String supportedWiredString = "$BUILDNUMBER";

        String script = server.getDeployScript();
        if (script != null && buildId != 0) {
            Build build = this.buildManager.get(buildId);
            String jenkensBuild = null;
            if (build.getJenkinsBuildId() != null) {
                jenkensBuild = build.getJenkinsBuildId().toString();
            }

            return script.replace(supportedWiredString, jenkensBuild);
        }
        return script;
    }

}
