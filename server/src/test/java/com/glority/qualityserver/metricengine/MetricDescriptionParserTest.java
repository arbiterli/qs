package com.glority.qualityserver.metricengine;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

import org.junit.Test;

import com.glority.qualityserver.web.model.MetricsDescription;

/**
 * Junit test for testing parsing MetricsDescriptionParser.
 * 
 * @author Chen.hong
 * 
 */
public class MetricDescriptionParserTest {

    private MetricDescriptionParser parser = new MetricDescriptionParser();

    /**
     * Test parser.
     */
    @Test
    public void testParseParseOneMetric() {
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.append("<metricdescriptions>\n");
        writer.append("  <metric name=\"JAVA_CHECKSTYLE\">\n");
        writer.append("     <overview>checkstyle overview</overview>\n");
        writer.append("     <QuestionAndAnswers>\n");
        writer.append("         <QuestionAndAnswer>\n");
        writer.append("            <Question>Question for testing</Question>\n");
        writer.append("            <Answer>Answer For testing</Answer>\n");
        writer.append("         </QuestionAndAnswer>\n");
        writer.append("     </QuestionAndAnswers>\n");
        writer.append("     <ReferenceLinks>\n");
        writer.append("         <URL>http://en.wikipedia.org/wiki/Checkstyle</URL>\n");
        writer.append("     </ReferenceLinks>");
        writer.append("     <PossibleFailures>\n");
        writer.append("        <PossibleFailure>Test failure1</PossibleFailure>\n");
        writer.append("     </PossibleFailures>\n");
        writer.append("  </metric>\n");
        writer.append("</metricdescriptions>\n");
        InputStream stream = new ByteArrayInputStream(writer.toString().getBytes());

        Map<String, MetricsDescription> ret = parser.parse(stream);

        assertEquals(1, ret.size());
        MetricsDescription description = ret.get("JAVA_CHECKSTYLE");
        assertEquals(1, description.getReferenceLinks().size());
        assertEquals("http://en.wikipedia.org/wiki/Checkstyle", description.getReferenceLinks().get(0));

        assertEquals(1, description.getqAndAList().size());
        assertEquals("Question for testing", description.getqAndAList().get(0).getQuestion());
        assertEquals("Answer For testing", description.getqAndAList().get(0).getAnswer());

        assertEquals("checkstyle overview", description.getOverview());

        assertEquals(1, description.getPossibleFailures().size());
        assertEquals("Test failure1", description.getPossibleFailures().get(0));
    }

    /**
     * Test parser.
     */
    @Test
    public void testParseParseOneMetricWithoutReferenceLinksAndQuestionAndAnswers() {
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.append("<metricdescriptions>\n");
        writer.append("  <metric name=\"JAVA_CHECKSTYLE\">\n");
        writer.append("     <overview>checkstyle overview</overview>\n");
        writer.append("  </metric>\n");
        writer.append("</metricdescriptions>\n");
        InputStream stream = new ByteArrayInputStream(writer.toString().getBytes());

        Map<String, MetricsDescription> ret = parser.parse(stream);

        assertEquals(1, ret.size());
        MetricsDescription description = ret.get("JAVA_CHECKSTYLE");
        assertEquals(0, description.getReferenceLinks().size());

        assertEquals(0, description.getqAndAList().size());
        assertEquals(0, description.getPossibleFailures().size());

        assertEquals("checkstyle overview", description.getOverview());
    }

    /**
     * Test parser.
     */
    @Test
    public void testParseParseMoreMetric() {
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        writer.append("<metricdescriptions>\n");
        writer.append("  <metric name=\"JAVA_CHECKSTYLE\">\n");
        writer.append("     <overview>checkstyle overview</overview>\n");
        writer.append("     <QuestionAndAnswers>\n");
        writer.append("         <QuestionAndAnswer>\n");
        writer.append("            <Question>Question for testing</Question>\n");
        writer.append("            <Answer>Answer For testing</Answer>\n");
        writer.append("         </QuestionAndAnswer>\n");
        writer.append("     </QuestionAndAnswers>\n");
        writer.append("     <ReferenceLinks>\n");
        writer.append("         <URL>http://en.wikipedia.org/wiki/Checkstyle</URL>\n");
        writer.append("     </ReferenceLinks>");
        writer.append("     <PossibleFailures>\n");
        writer.append("        <PossibleFailure>Test failure1</PossibleFailure>\n");
        writer.append("     </PossibleFailures>\n");
        writer.append("  </metric>\n");
        writer.append("  <metric name=\"JAVA_MI\">\n");
        writer.append("     <overview>javaMI overview</overview>\n");
        writer.append("     <ReferenceLinks>\n");
        writer.append("         <URL>MI_Link</URL>\n");
        writer.append("     </ReferenceLinks>");
        writer.append("  </metric>\n");
        writer.append("</metricdescriptions>\n");
        InputStream stream = new ByteArrayInputStream(writer.toString().getBytes());

        Map<String, MetricsDescription> ret = parser.parse(stream);

        assertEquals(2, ret.size());
        MetricsDescription description = ret.get("JAVA_CHECKSTYLE");
        assertEquals(1, description.getReferenceLinks().size());
        assertEquals("http://en.wikipedia.org/wiki/Checkstyle", description.getReferenceLinks().get(0));

        assertEquals(1, description.getqAndAList().size());
        assertEquals("Question for testing", description.getqAndAList().get(0).getQuestion());
        assertEquals("Answer For testing", description.getqAndAList().get(0).getAnswer());

        assertEquals("checkstyle overview", description.getOverview());

        assertEquals(1, description.getPossibleFailures().size());
        assertEquals("Test failure1", description.getPossibleFailures().get(0));

        description = ret.get("JAVA_MI");
        assertEquals(1, description.getReferenceLinks().size());

        assertEquals(0, description.getqAndAList().size());
        assertEquals(0, description.getPossibleFailures().size());
        assertEquals("javaMI overview", description.getOverview());
    }
}
