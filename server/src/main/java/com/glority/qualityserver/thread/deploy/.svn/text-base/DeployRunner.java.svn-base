package com.glority.qualityserver.thread.deploy;

import java.util.List;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.manager.DeployManager;
import com.glority.qualityserver.manager.ServerManager;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Server;

/**
 * Deploy Runner. this class manager deploy run.
 * 
 * @author liheping
 * 
 */
public abstract class DeployRunner {
    private DeployManager deployManager;
    private ServerManager serverManager;

    private Deploy deploy;
    private List<Server> serverList;

    public void deployRun() {
        try {
            this.deploy();
            if (this.isDeploySuccessful()) {
                deploy.setResult(Constants.SUCCESS);
                this.deployManager.deploy(deploy, Constants.DEPLOY_TYPE_BASE);

                for (Server server : serverList) {
                    server.setBuildId(deploy.getBuildId());
                    server.setActiveVersion(deploy.getVersion());

                    this.serverManager.save(server);
                }
            } else {
                deploy.setResult(Constants.FAIL);
                this.deployManager.save(deploy);
            }
        } catch (Exception e) {
            e.printStackTrace();

            deploy.setResult(Constants.FAIL);
            this.deployManager.deploy(deploy, Constants.DEPLOY_TYPE_BASE);
        }
    }

    /**
     * deploy method should wait the deploy completed.
     */
    protected abstract void deploy();

    /**
     * the deploy is successful.
     * 
     * @return
     */
    protected abstract boolean isDeploySuccessful();

    public DeployManager getDeployManager() {
        return deployManager;
    }

    public void setDeployManager(DeployManager deployManager) {
        this.deployManager = deployManager;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }

    public void setServerManager(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    public Deploy getDeploy() {
        return deploy;
    }

    public void setDeploy(Deploy deploy) {
        this.deploy = deploy;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

}
