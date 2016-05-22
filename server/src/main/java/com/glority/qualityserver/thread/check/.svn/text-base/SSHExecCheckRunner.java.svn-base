package com.glority.qualityserver.thread.check;

import java.io.ByteArrayOutputStream;

import org.apache.tools.ant.Project;

import com.glority.quality.connectors.ssh.SSHExec;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.SchedulerService;

/**
 * SSH Exec Server change check runner.
 * 
 * @author liheping
 * 
 */
public class SSHExecCheckRunner extends CheckRunner {

    public SSHExecCheckRunner(SchedulerService schedulerService, Server server) {
        super.schedulerService = schedulerService;
        super.server = server;
    }

    @Override
    protected String check() {
        SSHExec se = new SSHExec();
        se.setHost(super.server.getHost());
        se.setUsername(super.server.getUsername());
        se.setPassword(super.server.getPassword());
        se.setCommand(super.server.getCheckScript());
        se.setTrust(true);
        se.setProject(new Project());

        se.execute();

        // wait for finish
        boolean flag = true;
        while (se.getExitCode() == -1) {
            flag = !flag;
        }

        ByteArrayOutputStream execLogOut = (ByteArrayOutputStream) se.getOutStream();

        return execLogOut.toString();

    }

}
