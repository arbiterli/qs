package com.glority.common.connectors.jenkins;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.http.HttpConnector;

/**
 * JenkinsConnector. this connector is only for Jenkins ver. 1.471.
 * 
 * @author Li.heping
 * 
 */
public class JenkinsConnector {
    public static final String API_XML_SUFFIX = "/api/xml";

    private static final String URL_SEPARATOR = "/";
    private static final String JOB_TAG = "/job";
    private static final String EXECUTOR_TAG = "/computer";
    private static final String CONSOLE_TAG = "/consoleText";
    private static final String BUILD_SUFFIX = "/buildWithParameters";

    private static final Long WAIT_TIME_FOR_ADD_BUILD = 1000L;
    private static final int MAX_RETRY_TIME = 20;

    private String baseUrl;

    public JenkinsConnector(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * get all jenkins build executors, the source is like this
     * http://jenkins.glority.com:8080/computer/api/xml.
     * 
     * @return List<JenkinsBuildExecutor>
     * @throws ConnectorException
     */
    public List<JenkinsBuildExecutor> getJenkinsBuildExecutors() throws ConnectorException {
        String url = new StringBuilder(this.baseUrl).append(EXECUTOR_TAG).append(API_XML_SUFFIX).toString();
        return JenkinsXmlParser.parseJenkinsBuildExecutors(url);
    }

    /**
     * get all jenkins jobs, the source is like this
     * http://jenkins.glority.com:8080/api/xml.
     * 
     * @return
     * @throws ConnectorException
     */
    public List<JenkinsJob> getJenkinsJobs() throws ConnectorException {
        String url = new StringBuilder(this.baseUrl).append(API_XML_SUFFIX).toString();
        return JenkinsXmlParser.parseJenkinsJobs(url);
    }

    /**
     * get specified jenkinsJob.
     * 
     * @param jenkinsJobName
     * @return
     * @throws ConnectorException
     */
    public JenkinsJob getJenkinsJob(String jenkinsJobName) throws ConnectorException {
        String url = new StringBuilder(this.baseUrl).append(JOB_TAG).append(URL_SEPARATOR + jenkinsJobName)
                .append(API_XML_SUFFIX).toString();
        return JenkinsXmlParser.parseJenkinsJob(url);
    }

    /**
     * get specified jenkins build info.
     * 
     * @param jenkinsJobName
     * @param jenkinsBuildId
     * @return
     * @throws ConnectorException
     */
    public JenkinsBuild getJenkinsBuild(String jenkinsJobName, String jenkinsBuildId) throws ConnectorException {
        String url = new StringBuilder(this.baseUrl).append(JOB_TAG).append(URL_SEPARATOR + jenkinsJobName)
                .append(URL_SEPARATOR + jenkinsBuildId).append(API_XML_SUFFIX).toString();
        return JenkinsXmlParser.parseJenkinsBuild(url);
    }

    /**
     * get specified jenkins build console output.
     * 
     * @param jenkinsJobName
     * @param jenkinsBuildId
     * @return
     * @throws ConnectorException
     */
    public String getJenkinsBuildConsoleOutput(String jenkinsJobName, String jenkinsBuildId) throws ConnectorException {
        String url = new StringBuilder(this.baseUrl).append(JOB_TAG).append(URL_SEPARATOR + jenkinsJobName)
                .append(URL_SEPARATOR + jenkinsBuildId).append(CONSOLE_TAG).toString();
        return new HttpConnector().doGet(url);
    }

    /**
     * create a build in jenkins job with specified params. if success return
     * the buildId. otherwise return -1;
     * 
     * @param jenkinsJobName
     * @param postData
     * @throws ConnectorException
     */
    public int addJenkinsBuild(String jenkinsJobName, String postData) throws ConnectorException {
        JenkinsJob job = this.getJenkinsJob(jenkinsJobName);
        new HttpConnector().doPost(job.getUrl() + BUILD_SUFFIX, parsePostData(postData));

        // we can not get the post result, so use the following code to check
        // the add operation whether success.
        int retryTimes = 0;
        do {
            this.waitForMoment();
            JenkinsJob latestJob = this.getJenkinsJob(jenkinsJobName);

            if (job.getBuilds().size() + 1 <= latestJob.getBuilds().size()) {
                List<JenkinsBuild> newBuildList = latestJob.getBuilds();
                newBuildList.removeAll(job.getBuilds());
                return newBuildList.get(0).getNumber();
            }
        } while (retryTimes < MAX_RETRY_TIME);

        return -1;
    }

    private void waitForMoment() {
        try {
            Thread.sleep(WAIT_TIME_FOR_ADD_BUILD);
        } catch (InterruptedException e) {
            throw new BuildException(e);
        }
    }

    /**
     * to parse post data.
     * 
     * @param dataStr
     *            name1:value1;name2:value2;
     * @return the post data name value pair list
     */
    private Map<String, String> parsePostData(String dataStr) {
        Map<String, String> result = new HashMap<String, String>();
        if (dataStr != null) {
            String[] dataPairStr = dataStr.split(";");
            for (String dataPair : dataPairStr) {
                String[] data = dataPair.split("=");
                int dataSize = data.length;
                result.put(data[0], dataSize < 2 ? "" : data[1]);
            }
        }
        return result;
    }

    public static void main(String[] args) throws ConnectorException {
        JenkinsConnector connecter = new JenkinsConnector("http://jenkins.glority.com:8080");
        connecter.addJenkinsBuild("Glority_QualitySystem_Build", null);
    }
}
