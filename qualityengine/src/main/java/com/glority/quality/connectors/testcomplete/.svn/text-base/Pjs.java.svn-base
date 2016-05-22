package com.glority.quality.connectors.testcomplete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * pjs file operation.
 * 
 * @author zm.
 * 
 */
public class Pjs {
    private static final Logger LOGGER = Logger.getLogger(Pjs.class);
    /**
     * the pjs document.
     */
    private Document pjsDocument;

    /**
     * the testcase folder path.
     */
    private String tcFolder;

    /**
     * the case counter.
     */
    private int counter;

    /**
     * the uuid.
     */
    private String uuid;

    /**
     * hard code start index.
     */
    private static final int START_INDEX = 0;

    /**
     * the item type code.
     */
    private static final String ITEM_TYPE = "{362A8EE5-675E-43A9-869D-06ECE80B0CB4}";

    /**
     * the folder to hold created pjs.
     */
    private static final String PJS_FOLDER = "DynamicalSuites";

    /**
     * the folder contains all the cases.
     */
    private static final String ATCS_FOLDER = "ATCs";

    /**
     * the report generator mds file.
     */
    private static final String REPORT_GENERATOR_MDS = "reportgenerator\\reportgenerator.mds";

    /**
     * the pjs file extension.
     */
    private static final String PJS_EXTENSION = ".pjs";

    /**
     * to init template.
     * 
     * @param templatePath
     *            pjs file path.
     * @param tcFolder
     *            testcase folder.
     */
    public void init(String templatePath, String tcFolder) {
        this.tcFolder = tcFolder;
        this.counter = START_INDEX;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            pjsDocument = builder.parse(new File(templatePath));
            clearTemplateNodeContent();
        } catch (ParserConfigurationException e) {
            throw new BuildException(e.getMessage());
        } catch (IOException e) {
            throw new BuildException(e.getMessage());
        } catch (SAXException e) {
            throw new BuildException(e.getMessage());
        }
    }

    /**
     * to generate report generator. need to be refacted.
     */
    public void insertReportGenerator() {
        NodeList nodes = pjsDocument.getElementsByTagName("Node");
        Node childListNode = getChildListNode(nodes, false);
        String itemName = String.format("item%1$,010d", ++counter);
        Node itemNode = createNode(itemName);
        Node itemDataNode = createNode("item data");
        String mdsFilePath = "..\\.." + File.separator + ATCS_FOLDER
                + File.separator + REPORT_GENERATOR_MDS;
        itemDataNode.appendChild(createPrp("relpath", "S", mdsFilePath));
        itemNode.appendChild(itemDataNode);
        itemNode.appendChild(createPrp("index", "I", String.valueOf(counter)));
        uuid = "{" + UUID.randomUUID().toString() + "}";
        itemNode.appendChild(createPrp("key", "S", uuid));
        itemNode.appendChild(createPrp("pluginname", "S", ""));
        itemNode.appendChild(createPrp("type", "S", ITEM_TYPE));
        itemNode.appendChild(createPrp("typename", "S", "Project"));
        childListNode.appendChild(itemNode);
        nodes = pjsDocument.getElementsByTagName("Node");
        Node filesNode = getFilesNode(nodes);
        if (null == filesNode) {
            return;
        }
        filesNode.appendChild(createNode("..\\.." + File.separator
                + ATCS_FOLDER + File.separator + REPORT_GENERATOR_MDS));
        nodes = pjsDocument.getElementsByTagName("Node");
        childListNode = getChildListNode(nodes, true);
        itemName = String.format("item%1$,010d", counter);
        itemNode = createNode(itemName);
        itemNode.appendChild(createPrp("description", "S", ""));
        itemNode.appendChild(createPrp("enabled", "B", "-1"));
        itemNode.appendChild(createPrp("index", "I", String.valueOf(counter)));
        itemNode.appendChild(createPrp("key", "S", uuid));
        itemNode.appendChild(createPrp("stoponerror", "B", "0"));
        itemNode.appendChild(createPrp("timeout", "I", "0"));
        childListNode.appendChild(itemNode);

    }

    /**
     * to insert a test case into the template.
     * 
     * @param caseId
     *            the case id.
     */
    public void insertTestCase(String caseId) {
        if (caseExist(caseId)) {
            uuid = "{" + UUID.randomUUID().toString() + "}";
            insertToChildList(caseId);
            insertToFiles(caseId);
            insertToTestDataList(caseId);
            counter++;
        } else {
            LOGGER.debug("Warning: case " + caseId + " not exist.");
            return;
        }
    }

    /**
     * to check if case exists.
     * 
     * @param caseId
     *            the case id.
     * @return if exists.
     */
    private boolean caseExist(String caseId) {
        String mdsFilePath = this.tcFolder + ATCS_FOLDER + File.separator
                + caseId + File.separator + caseId + ".mds";
        if (new File(mdsFilePath).exists()) {
            return true;
        }
        return false;
    }

    /**
     * to clear template node content.
     */
    private void clearTemplateNodeContent() {
        NodeList nodes = pjsDocument.getElementsByTagName("Node");
        Node childListNode = getChildListNode(nodes, false);
        Node childListNodeInTestData = getChildListNode(nodes, true);
        Node filesNode = getFilesNode(nodes);
        clearNodeChildren(childListNodeInTestData);
        clearNodeChildren(childListNode);
        clearNodeChildren(filesNode);
    }

    /**
     * to insert the case info into child list node.
     * 
     * @param caseId
     *            the case id.
     */
    private void insertToChildList(String caseId) {
        NodeList nodes = pjsDocument.getElementsByTagName("Node");
        Node childListNode = getChildListNode(nodes, false);
        String itemName = String.format("item%1$,010d", counter);
        Node itemNode = createNode(itemName);
        Node itemDataNode = createNode("item data");
        String mdsFilePath = "..\\.." + File.separator + ATCS_FOLDER
                + File.separator + caseId + File.separator + caseId + ".mds";
        itemDataNode.appendChild(createPrp("relpath", "S", mdsFilePath));
        itemNode.appendChild(itemDataNode);
        itemNode.appendChild(createPrp("index", "I", String.valueOf(counter)));
        itemNode.appendChild(createPrp("key", "S", uuid));
        itemNode.appendChild(createPrp("pluginname", "S", ""));
        itemNode.appendChild(createPrp("type", "S", ITEM_TYPE));
        itemNode.appendChild(createPrp("typename", "S", "Project"));
        childListNode.appendChild(itemNode);
    }

    /**
     * to insert the case mds file path into files node.
     * 
     * @param caseId
     *            the case id.
     */
    private void insertToFiles(String caseId) {
        NodeList nodes = pjsDocument.getElementsByTagName("Node");
        Node filesNode = getFilesNode(nodes);
        if (null == filesNode) {
            return;
        }
        filesNode.appendChild(createNode(".." + File.separator + ATCS_FOLDER
                + File.separator + caseId + File.separator + caseId + ".mds"));
    }

    /**
     * to get files node.
     * 
     * @param nodes
     *            get the node with the tag name of files.
     * @return the files node.
     */
    private Node getFilesNode(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node tmpNode = nodes.item(i);
            String nodeName = getNodeAttribute(tmpNode, "name");
            if ("files".equals(nodeName)) {
                return tmpNode;
            }
        }
        return null;
    }

    /**
     * to insert the case info into test data child list node.
     * 
     * @param caseId
     *            the case id
     */
    private void insertToTestDataList(String caseId) {
        NodeList nodes = pjsDocument.getElementsByTagName("Node");
        Node childListNode = getChildListNode(nodes, true);
        String itemName = String.format("item%1$,010d", counter);
        Node itemNode = createNode(itemName);
        itemNode.appendChild(createPrp("description", "S", ""));
        itemNode.appendChild(createPrp("enabled", "B", "-1"));
        itemNode.appendChild(createPrp("index", "I", String.valueOf(counter)));
        itemNode.appendChild(createPrp("key", "S", uuid));
        itemNode.appendChild(createPrp("stoponerror", "B", "0"));
        itemNode.appendChild(createPrp("timeout", "I", "0"));
        childListNode.appendChild(itemNode);
    }

    /**
     * to create node.
     * @param name  the node name.
     * @return an element with tag of Node.
     */
    private Node createNode(String name) {
        Element node = pjsDocument.createElement("Node");
        node.setAttribute("name", name);
        return node;
    }

    /**
     * to create prp node.
     * @param name
     *            the name.
     * @param type
     *            the type.
     * @param value
     *            the value.
     * @return the prp node.
     */
    private Node createPrp(String name, String type, String value) {
        Element prp = pjsDocument.createElement("Prp");
        prp.setAttribute("name", name);
        prp.setAttribute("type", type);
        prp.setAttribute("value", value);
        return prp;
    }

    /**
     * to get the child list node.
     * 
     * @param nodes
     *            a nodelist.
     * @param isInTestData
     *            if the child list node in test data.
     * @return the child list node.
     */
    private Node getChildListNode(NodeList nodes, boolean isInTestData) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node tmpNode = nodes.item(i);
            if ("child list".equals(getNodeAttribute(tmpNode, "name"))) {
                String parentNodeName = getNodeAttribute(
                        tmpNode.getParentNode(), "name");
                if (isInTestData) {
                    if ("test data".equals(parentNodeName)) {
                        return tmpNode;
                    }
                } else {
                    if ("root".equals(parentNodeName)) {
                        return tmpNode;
                    }
                }
            }
        }
        return null;
    }

    /**
     * to get node attribute.
     * @param node
     *            the node.
     * @param attrib
     *            the attribute name.
     * @return the attribute value.
     */
    private String getNodeAttribute(Node node, String attrib) {
        NamedNodeMap attriMap = node.getAttributes();
        for (int i = 0; i < attriMap.getLength(); i++) {
            Attr attr = (Attr) attriMap.item(i);
            if (attr.getName().equals(attrib)) {
                return attr.getValue();
            }
        }
        return "";
    }

    /**
     * clear childnodes of a node.
     * 
     * @param node
     *            parent node
     */
    private void clearNodeChildren(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            node.removeChild(childNodes.item(i));
        }
    }

    /**
     * to output pjs file.
     * 
     * @param pjsFileName
     *            the pjs file name.
     */
    public void outputPjsFile(int pjsFileIndex) {
        try {
            String pjsFileName = String.valueOf(pjsFileIndex);
            File outputFolder = new File(this.tcFolder + File.separator +  PJS_FOLDER + File.separator
                    + pjsFileName);
            if (!outputFolder.exists()) {
                if (!outputFolder.mkdir()) {
                    LOGGER.debug("Create folder " + this.tcFolder
                            + PJS_FOLDER + "/" + pjsFileName + " failed.");
                }
            }
            File outputFile = new File(this.tcFolder + File.separator +  PJS_FOLDER + "/"
                    + pjsFileName + "/" + pjsFileName + PJS_EXTENSION);
            if (!outputFile.exists()) {
                try {
                    outputFile.createNewFile();
                } catch (IOException e) {
                    throw new BuildException(e.getMessage());
                }
            }
            OutputStream outputStream = new FileOutputStream(outputFile);
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource((Node) pjsDocument);
            StreamResult result = new StreamResult(outputStream);
            transformer.transform(source, result);
            return;
        } catch (FileNotFoundException e) {
            throw new BuildException(e.getMessage());
        } catch (TransformerConfigurationException e) {
            throw new BuildException(e.getMessage());
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
