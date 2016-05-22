package com.glority.quality.sca.mi.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.apache.log4j.Logger;

import com.glority.quality.sca.antlr.LanguageParserFactory.LanguageEnum;
import com.glority.quality.sca.mi.metrics.ProjectMetrics;

/**
 * XML format report of the MI. This report only contains the project level mi values.
 * 
 * @author XQS
 * 
 */
public class XMLReport {
    private static final Logger LOGGER = Logger.getLogger(XMLReport.class);
    private ProjectMetrics pmi;
    private LanguageEnum lang;
    private String reportPath;

    /** Default xml report file name. */
    public static final String MI_XML_REPORT_FILE_NAME = "mi.xml";

    public XMLReport(ProjectMetrics pmi, LanguageEnum lang, String reportPath) {
        this.pmi = pmi;
        this.lang = lang;
        this.reportPath = reportPath;
    }

    /**
     * Generate xml style project MI. The xml will be like following.
     * 
     */
    public void writeReport() {
        String reportFile = this.reportPath + File.separator + MI_XML_REPORT_FILE_NAME;
        OutputStream os = null;
        XMLStreamWriter xmlWriter = null;
        try {
            os = new FileOutputStream(reportFile);
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            xmlWriter = factory.createXMLStreamWriter(os);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug("Failed to create xml report writer");
        }

        try {
            xmlWriter.writeStartDocument();
            xmlWriter.writeStartElement("projectmi");
            xmlWriter.writeStartElement("totalloc");
            xmlWriter.writeCharacters("" + pmi.getLoc());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("totallom");
            xmlWriter.writeCharacters("" + pmi.getLom());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("avgloc");
            xmlWriter.writeCharacters("" + pmi.getAvgLoc());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("avglom");
            xmlWriter.writeCharacters("" + pmi.getAvgLom());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("avghalsteadvolume");
            xmlWriter.writeCharacters("" + pmi.getAvgHalsteadVolume());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("avgcyclomaticcomplexity");
            xmlWriter.writeCharacters("" + pmi.getAvgCcVolume());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("mi");
            xmlWriter.writeCharacters("" + pmi.getMi());
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("miwithcomment");
            xmlWriter.writeCharacters("" + pmi.getCmi());
            xmlWriter.writeEndElement();
            xmlWriter.writeEndElement();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug("Failed to write xml report");
        } finally {
            try {
                if (xmlWriter != null) {
                    xmlWriter.flush();
                    xmlWriter.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.debug("Failed close output stream ");
            }
        }
    }
}
