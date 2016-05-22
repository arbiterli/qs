package com.glority.common.connectors.jenkins;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.jenkins.JenkinsJob.JobColor;

/**
 * JenkinsXmlParser. this class is a util class for parse jenkins xml api info.
 * only for Jenkins ver. 1.471.
 * 
 * @author li.heping
 * 
 */
public final class JenkinsXmlParser {
    public static final String COMPUTER_TAG = "computer";
    public static final String OFFLINE_TAG = "offline";
    public static final String DISPLAY_NAME_TAG = "displayName";

    protected static final String NUMBER_TAG = "number";
    protected static final String ESTIMATE_TAG = "estimatedDuration";
    protected static final String RESULT_TAG = "result";
    protected static final String BUILD_TAG = "build";

    private static final String NAME_TAG = "name";
    private static final String TYPE_TAG = "type";
    private static final String CHOICE_TAG = "choice";
    private static final String URL_TAG = "url";
    private static final String COLOR_TAG = "color";
    private static final String DEFAULT_PARA_VAL_TAG = "defaultParameterValue";
    private static final String PARAMETER_DEF_TAG = "parameterDefinition";

    private static final String JOB_TAG = "job";

    private JenkinsXmlParser() {

    }

    /**
     * to init document.
     * 
     * @throws ConnectorException
     */
    private static Document init(String xmlUrl) throws ConnectorException {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setNamespaceAware(true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            return builder.parse(xmlUrl);
        } catch (Exception e) {
            throw new ConnectorException(e.getMessage(), e);
        }
    }

    /**
     * parse jenkins build detail.the build detail page is like
     * http://jenkins.glority
     * .com:8080/job/Glority_QualitySystem_Build/294/api/xml. this parser only
     * for Jenkins ver. 1.471.
     * 
     * @param url
     * @return
     * @throws ConnectorException
     */
    public static JenkinsBuild parseJenkinsBuild(String url) throws ConnectorException {
        Document doc = init(url);
        JenkinsBuild build = new JenkinsBuild();
        doc.getDocumentElement().normalize();
        Node rootNode = doc.getChildNodes().item(0);
        NodeList infoNodes = rootNode.getChildNodes();
        for (int i = 0; i < infoNodes.getLength(); i++) {
            Node tempNode = infoNodes.item(i);
            setJenkinsBuildProperty(tempNode, build);
        }
        return build;
    }

    private static void setJenkinsBuildProperty(Node tempNode, JenkinsBuild build) {
        if (tempNode.getNodeName().equals(NUMBER_TAG)) {
            build.setNumber(Integer.parseInt(tempNode.getFirstChild().getNodeValue().trim()));
        }

        if (tempNode.getNodeName().equals(URL_TAG)) {
            build.setUrl(tempNode.getFirstChild().getNodeValue());
        }

        if (tempNode.getNodeName().equals(ESTIMATE_TAG)) {
            build.setEstimated(Long.parseLong(tempNode.getFirstChild().getNodeValue()));
        }

        if (tempNode.getNodeName().equals(RESULT_TAG)) {
            build.setResult(JenkinsBuild.BuildResult.valueOf(tempNode.getFirstChild().getNodeValue().trim()));
        }
    }

    public static List<JenkinsBuildExecutor> parseJenkinsBuildExecutors(String url) throws ConnectorException {
        Document doc = init(url);
        List<JenkinsBuildExecutor> executorList = new ArrayList<JenkinsBuildExecutor>();
        if (doc != null) {
            NodeList nodeList = doc.getElementsByTagName(COMPUTER_TAG);
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    JenkinsBuildExecutor executor = parseBuildExecutor(node);
                    executorList.add(executor);
                }
            }
        }
        return executorList;
    }

    /**
     * parse the node to a BuildExecutor model.
     * 
     * @param computerNode
     * @return
     */
    private static JenkinsBuildExecutor parseBuildExecutor(Node computerNode) {
        JenkinsBuildExecutor executor = new JenkinsBuildExecutor();

        NodeList atrrNodeList = computerNode.getChildNodes();
        if (atrrNodeList != null) {
            for (int i = 0; i < atrrNodeList.getLength(); i++) {
                Node attrNode = atrrNodeList.item(i);
                parseAndSetBuildExecutorAttr(attrNode, executor);
            }
        }

        return executor;
    }

    /**
     * set set the executor attribute, based on the value which parsed form
     * attrNode.
     * 
     * @param attrNode
     * @param executor
     */
    private static void parseAndSetBuildExecutorAttr(Node attrNode, JenkinsBuildExecutor executor) {
        if (attrNode != null) {
            if (DISPLAY_NAME_TAG.equals(attrNode.getNodeName())) {
                executor.setDisplayName(attrNode.getTextContent());
            } else if (OFFLINE_TAG.equals(attrNode.getNodeName())) {
                executor.setOffline(Boolean.valueOf(attrNode.getTextContent()));
            }
        }
    }

    /**
     * parse jenkins job. the page is like
     * http://jenkins.glority.com:8080/job/Glority_QualitySystem_Build/api/xml
     * this parser only for Jenkins ver. 1.471.
     * 
     * @param url
     * @return
     * @throws ConnectorException
     */
    public static JenkinsJob parseJenkinsJob(String url) throws ConnectorException {
        Document doc = init(url);
        JenkinsJob job = new JenkinsJob();
        parseBaseInfo(job, doc);
        parseParameters(job, doc);
        parseBuilds(job, doc);
        return job;
    }

    private static void parseBaseInfo(JenkinsJob job, Document doc) {
        NodeList nameList = doc.getElementsByTagName(NAME_TAG);
        job.setName(nameList.item(0).getTextContent());
        NodeList urlList = doc.getElementsByTagName(URL_TAG);
        job.setUrl(urlList.item(0).getTextContent());
        NodeList colorList = doc.getElementsByTagName(COLOR_TAG);
        job.setColor(JobColor.valueOf(colorList.item(0).getTextContent()));
    }

    private static void parseParameters(JenkinsJob job, Document doc) {
        List<Parameter> params = new ArrayList<Parameter>();

        NodeList nodeList = doc.getElementsByTagName(PARAMETER_DEF_TAG);
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Parameter param = parseParam(node);
                params.add(param);
            }
        }

        job.setParameters(params);
    }

    private static Parameter parseParam(Node node) {
        List<String> choices = new ArrayList<String>();
        NodeList childNodes = node.getChildNodes();
        Parameter para = new Parameter();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node tempNode = childNodes.item(i);
            if (tempNode.getLocalName().equals(DEFAULT_PARA_VAL_TAG)) {
                Node valueNode = tempNode.getFirstChild();
                if (null != valueNode) {
                    String defaultValue = valueNode.getFirstChild().getNodeValue();
                    para.setDefaultValue(defaultValue);
                }
            }

            if (tempNode.getLocalName().equals(NAME_TAG)) {
                String name = tempNode.getFirstChild().getNodeValue();
                para.setName(name);
            }

            if (tempNode.getLocalName().equals(TYPE_TAG)) {
                String type = tempNode.getFirstChild().getNodeValue();
                para.setType(type);
            }

            if (tempNode.getLocalName().equals(CHOICE_TAG)) {
                String choice = tempNode.getFirstChild().getNodeValue();
                choices.add(choice);
            }
        }
        para.setChoices(choices);
        return para;
    }

    private static void parseBuilds(JenkinsJob job, Document doc) {
        List<JenkinsBuild> buildList = new ArrayList<JenkinsBuild>();

        NodeList nodeList = doc.getElementsByTagName(BUILD_TAG);
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                JenkinsBuild build = parseBuild(node);
                buildList.add(build);
            }
        }

        job.setBuilds(buildList);
    }

    private static JenkinsBuild parseBuild(Node node) {
        JenkinsBuild build = new JenkinsBuild();

        NodeList attrNodeList = node.getChildNodes();
        for (int i = 0; i < attrNodeList.getLength(); i++) {
            setJenkinsBuildProperty(attrNodeList.item(i), build);
        }

        return build;
    }

    /**
     * parse and get all jobs. this parser only for Jenkins ver. 1.471.
     * 
     * @param url
     * @return
     * @throws ConnectorException
     */
    public static List<JenkinsJob> parseJenkinsJobs(String url) throws ConnectorException {
        Document doc = init(url);
        List<JenkinsJob> jobList = new ArrayList<JenkinsJob>();
        doc.getDocumentElement().normalize();
        Node hudsonNode = doc.getChildNodes().item(0);
        NodeList childNodes = hudsonNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node tempNode = childNodes.item(i);
            if (tempNode.getNodeName().equals(JOB_TAG)) {
                jobList.add(parseJob(tempNode));
            }
        }
        return jobList;
    }

    /**
     * to convert a job node to a job object.
     * 
     * @param node
     *            job node
     * @return a job node
     * @throws ConnectorException
     */
    private static JenkinsJob parseJob(Node node) throws ConnectorException {
        String url = null;

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeName().equals(URL_TAG)) {
                url = childNode.getTextContent();
            }
        }

        return parseJenkinsJob(url + JenkinsConnector.API_XML_SUFFIX);
    }
}
