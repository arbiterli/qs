package com.glority.quality.connectors.testcomplete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.connectors.testrail.TestrailBase;

public abstract class GeneratePjsBaseTestCase {
    protected GeneratePjsBase generator;
    protected TestrailBase testrailTask;
    protected static final String PJS_TEMPLATE = "test.pjs";
    protected static final String ATC_PATH = "test";
    protected static final String TESTRAIL_SERVER = "http://testrail.glority.com";
    protected static final String TESTRAIL_KEY = "glority123";
    protected static final String PJS_FOLDER = "DynamicalSuites";
    private static final String CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
            + "<!DOCTYPE Nodes [" + "" + "<!ENTITY % NameValue \"CDATA\">" + "<!ENTITY % PropType \"(I|S|D|L|H|B)\">"
            + "<!ENTITY % VersionValue \"CDATA\">" + "" + "<!ELEMENT Prp (#PCDATA)>" + "<!ELEMENT Node (Node|Prp)*>"
            + "<!ELEMENT Nodes (Node)+>" + "" + "<!ATTLIST Nodes version CDATA \"1\">" + ""
            + "<!ATTLIST Node name CDATA #REQUIRED>" + "" + "<!ATTLIST Prp name CDATA #REQUIRED>"
            + "<!ATTLIST Prp type CDATA #REQUIRED>" + "<!ATTLIST Prp value CDATA #REQUIRED>" + "]>"
            + "<Nodes version=\"1\">" + " <Node name=\"root\">" + "     <Node name=\"analysis\">"
            + "         <Prp name=\"key\" type=\"S\" value=\"{1C7AD24E-60BA-4AA6-9244-B9C1096E51DD}\"/>"
            + "     </Node>" + "     <Node name=\"child list\">" + "         <Node name=\"item0000000000\">"
            + "             <Node name=\"item data\">"
            + "                 <Prp name=\"relpath\" type=\"S\" value=\"46595.mds\"/>" + "             </Node>"
            + "             <Prp name=\"index\" type=\"I\" value=\"0\"/>"
            + "             <Prp name=\"key\" type=\"S\" value=\"{ACB3C50E-A329-462F-8B0E-CDE49D31E3C5}\"/>"
            + "             <Prp name=\"pluginname\" type=\"S\" value=\"\"/>"
            + "             <Prp name=\"type\" type=\"S\" value=\"{362A8EE5-675E-43A9-869D-06ECE80B0CB4}\"/>"
            + "             <Prp name=\"typename\" type=\"S\" value=\"Project\"/>" + "         </Node>"
            + "     </Node>" + "     <Node name=\"files\">" + "         <Node name=\"46595.mds\"/>" + "     </Node>"
            + "     <Node name=\"folders\">" + "         <Node name=\"folders\"/>" + "     </Node>"
            + "     <Node name=\"scc\"/>" + "     <Node name=\"settings\">"
            + "         <Node name=\"{5a85e200-b5d2-4f74-972a-0221f2956a19}\">"
            + "             <Prp name=\"type\" type=\"I\" value=\"5\"/>"
            + "             <Prp name=\"value\" type=\"S\" value=\"Log\"/>" + "         </Node>"
            + "         <Prp name=\"key\" type=\"S\" value=\"{C08CE05D-E0F4-48D8-A0D7-51DB16E22881}\"/>"
            + "         <Prp name=\"settingsversion\" type=\"S\" value=\"9.0\"/>" + "     </Node>"
            + "     <Node name=\"test data\">" + "         <Node name=\"child list\">"
            + "             <Node name=\"item0000000000\">"
            + "                 <Prp name=\"description\" type=\"S\" value=\"\"/>"
            + "                 <Prp name=\"enabled\" type=\"B\" value=\"-1\"/>"
            + "                 <Prp name=\"index\" type=\"I\" value=\"0\"/>"
            + "                 <Prp name=\"key\" type=\"S\" value=\"{ACB3C50E-A329-462F-8B0E-CDE49D31E3C5}\"/>"
            + "                 <Prp name=\"stoponerror\" type=\"B\" value=\"-1\"/>"
            + "                 <Prp name=\"timeout\" type=\"I\" value=\"0\"/>" + "             </Node>"
            + "         </Node>"
            + "         <Prp name=\"key\" type=\"S\" value=\"{FD0C96AD-ED7C-46F6-986C-A0373ED2AB6D}\"/>"
            + "     </Node>" + "     <Node name=\"variables\">"
            + "         <Prp name=\"key\" type=\"S\" value=\"{253376DF-5645-44EB-94B1-C5692307CCB8}\"/>"
            + "     </Node>" + "     <Prp name=\"key\" type=\"S\" value=\"{CCB6BD55-1813-48F3-851C-993C06419892}\"/>"
            + "     <Prp name=\"signature\" type=\"S\" value=\"{24B6FA0B-0143-461A-9758-AEB9E9A9428B}\"/>"
            + "     <Prp name=\"version\" type=\"S\" value=\"9.0\"/>" + " </Node>" + "</Nodes>";

    protected File pjsFolder;

    /**
     * to init test.
     */
    @Before
    protected void init() throws IOException {
        File file = new File(ATC_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        pjsFolder = new File(ATC_PATH + File.separator + PJS_FOLDER);
        if (!pjsFolder.exists()) {
            pjsFolder.mkdir();
        }

        createTemplate();
    }

    private void createTemplate() throws IOException {
        File file = new File(PJS_TEMPLATE);
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.append(CONTENT);
        writer.flush();
        writer.close();
    }

    @After
    public void tearDown() {
        pjsFolder.delete();

        File file = new File(PJS_TEMPLATE);
        file.delete();
    }

    /**
     * to test generate pjs.
     */
    protected abstract void testGeneratePjs() throws ConnectorException;

    /**
     * get all case number from pjs files.
     * 
     * @return case number.
     */
    protected int getCaseNumFromPjsFiles() {
        File dir = new File(ATC_PATH + File.separator + PJS_FOLDER);
        File file[] = dir.listFiles();
        int caseCounter = 0;
        for (int i = 0; i < file.length; i++) {
            File tmpFile = file[i];
            if (tmpFile.isFile() && tmpFile.getAbsolutePath().endsWith(".pjs")) {
                caseCounter += getCaseNumFromPjs(tmpFile);
            }
        }
        return caseCounter;
    }

    /**
     * 
     * @param pjsFile
     *            the pjs file
     * @return case number.
     */
    protected int getCaseNumFromPjs(File pjsFile) {
        int caseCounter = 0;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document pjsDocument = builder.parse(pjsFile);
            NodeList nodes = pjsDocument.getElementsByTagName("Node");
            Node childListNode = getChildListNode(nodes, false);
            NodeList testcaseNodes = childListNode.getChildNodes();
            for (int i = 0; i < testcaseNodes.getLength(); i++) {
                Node tmpNode = testcaseNodes.item(i);
                if (tmpNode.getNodeName().equals("Node")) {
                    caseCounter++;
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return --caseCounter;
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
                String parentNodeName = getNodeAttribute(tmpNode.getParentNode(), "name");
                if (isInTestData && "test data".equals(parentNodeName)) {
                    return tmpNode;
                }
                if ("root".equals(parentNodeName)) {
                    return tmpNode;
                }
            }
        }
        return null;
    }

    /**
     * 
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
}
