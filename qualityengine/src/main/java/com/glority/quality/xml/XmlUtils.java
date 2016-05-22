/**
 * 
 */
package com.glority.quality.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.tools.ant.BuildException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**this class is to parser xml dom.
 * @author CLB
 *
 */
public final class XmlUtils {
    private XmlUtils() {
    }
    /**.
     * make the XML domtree and get the root of XML domtree.
     * 
     * @param xmlContent
     *            the source to parse.
     * 
     * @return the root of domTree.
     */
    public static Element makeDomTree(String xmlContent) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory
                    .newDocumentBuilder();
            Document domTree = documentBuilder.parse(new ByteArrayInputStream(
                    xmlContent.getBytes()));
            Element root = domTree.getDocumentElement();
            return root;
        } catch (IOException e) {
            throw new BuildException(e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new BuildException(e.getMessage());
        } catch (SAXException e) {
            throw new BuildException(e.getMessage());
        }
    }
    /**
     * the value to get.
     * 
     * @param element
     *            the element.
     * @param tagName
     *            the tagName.
     * @return the value of element.
     */
    public static String getXmlNodeValueByNameTag(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getFirstChild().getNodeValue();
    }

}
