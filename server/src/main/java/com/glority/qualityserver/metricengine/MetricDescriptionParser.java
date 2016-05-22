package com.glority.qualityserver.metricengine;

import java.io.InputStream;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.glority.qualityserver.web.model.MetricsDescription;
import com.glority.qualityserver.web.model.QuestionAndAnswer;

/**
 * Used for parse the xml configuration files for MetricsDescription.
 * 
 * Note that the QuestionAndAnswers are options.
 * @author Chenhong
 */
public class MetricDescriptionParser {
    private static final String METRIC = "metric";
    private static final String METRIC_NAME = "name";
    private static final String OVERVIEW = "overview";
    private static final String REFERENCE_LINKS = "ReferenceLinks";
    private static final String URL = "URL";
    private static final String QUESTION_AND_ANSWERS = "QuestionAndAnswers";
    private static final String QUESTION_AND_ANSWER = "QuestionAndAnswer";
    private static final String POSSIBLE_FAILURES = "PossibleFailures";
    private static final String POSSIBLE_FAIILURE = "PossibleFailure";
    private static final String QUESTION = "Question";
    private static final String ANSWER = "Answer";

    private static final Logger LOGGER = Logger.getLogger(MetricDescriptionParser.class);

    /**
     * Parse the InputStream for retrieve MetricsDescription instances.
     * 
     * @param inputStream
     *            the input stream
     * @return MetricsDescription map
     */
    @SuppressWarnings("unchecked")
    public Map<String, MetricsDescription> parse(InputStream inputStream) {
        Map<String, MetricsDescription> metricDescriptions = new HashMap<String, MetricsDescription>();

        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(inputStream);
            Element root = doc.getRootElement();

            List<Element> metricsList = root.elements(METRIC);

            for (Element element : metricsList) {
                MetricsDescription metricsDescription = parseMetricDescription(element);
                metricDescriptions.put(metricsDescription.getMetricName(), metricsDescription);
            }
        } catch (DocumentException e) {
            LOGGER.error("Failed to parse the InputStream caused by " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("Failed to parse the InputStream caused by " + e.getMessage(), e);
        }

        return metricDescriptions;
    }

    /**
     * Parse the MetricsDescription element.
     * 
     * @param element
     *            the metrics description element, must not be null
     * @return MetricsDescription parsed
     */
    private MetricsDescription parseMetricDescription(Element element) {
        if (element == null || !METRIC.equals(element.getName())) {
            return null;
        }

        String metricName = null;
        Attribute typeAttr = element.attribute(METRIC_NAME);
        if (typeAttr != null) {
            metricName = typeAttr.getText();
        }

        MetricsDescription metricDescription = new MetricsDescription();
        metricDescription.setMetricName(metricName);

        String overview = parseOverviewElement(element.element(OVERVIEW));
        metricDescription.setOverview(overview);

        Element referenceLinksElement = element.element(REFERENCE_LINKS);
        if (referenceLinksElement != null) {
            metricDescription.setReferenceLinks(parseReferenceLinks(referenceLinksElement));
        }

        Element questionAndAnswersElement = element.element(QUESTION_AND_ANSWERS);
        if (questionAndAnswersElement != null) {
            metricDescription.setQuestionAndAnswerList(parseQuestionAndAnswers(questionAndAnswersElement));
        }

        Element possibleFailuresElement = element.element(POSSIBLE_FAILURES);
        if (possibleFailuresElement != null) {
            metricDescription.setPossibleFailures(parsePossibleFailures(possibleFailuresElement));
        }

        return metricDescription;
    }

    /**
     * Parse question and answers.
     * 
     * @param element
     *            the question and answer elements, must not be null
     * @return a list of QuestionAndAnswers
     */
    @SuppressWarnings("unchecked")
    private List<QuestionAndAnswer> parseQuestionAndAnswers(Element element) {
        List<QuestionAndAnswer> questionAndAnswers = new ArrayList<QuestionAndAnswer>();
        List<Element> questionAndAnswerList = element.elements(QUESTION_AND_ANSWER);
        for (Element questionAndAnswerElement : questionAndAnswerList) {
            if (questionAndAnswerElement != null) {
                questionAndAnswers.add(parseQuestionAndAnswer(questionAndAnswerElement));
            }
        }
        return questionAndAnswers;
    }

    /**
     * Parse one question and answer content from given element.
     * 
     * @param element
     *            the question and answer element, must be not null
     * @return QuestionAndAnswer
     */
    private QuestionAndAnswer parseQuestionAndAnswer(Element element) {
        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();

        Element questionElement = element.element(QUESTION);
        questionAndAnswer.setQuestion(questionElement.getTextTrim());

        Element answerElement = element.element(ANSWER);
        questionAndAnswer.setAnswer(answerElement.getTextTrim());

        return questionAndAnswer;
    }

    /**
     * Parse the reference links.
     * 
     * @param element
     *            the reference links element must be not null
     * @return a list of reference links
     */
    @SuppressWarnings("unchecked")
    private List<String> parseReferenceLinks(Element element) {
        List<String> referenceLinks = new ArrayList<String>();

        List<Element> urlElementList = element.elements(URL);
        for (Element urlElement : urlElementList) {
            referenceLinks.add(urlElement.getTextTrim());
        }
        return referenceLinks;
    }

    /**
     * Parse the Overview element. The OverView element would include html tags such as <li>
     * 
     * @param element
     *            overview element, must be not null
     * @return the overview
     */
    private String parseOverviewElement(Element element) {
        String overviewContent = element.asXML();
        overviewContent = overviewContent.replace("<overview>", "");
        overviewContent = overviewContent.replace("</overview>", "");

        return overviewContent;
    }

    /**
     * Parse the configured possible failure reason for metric.
     * 
     * @param element
     *            the possible failure element.
     * @return list of possible failures
     */
    @SuppressWarnings("unchecked")
    private List<String> parsePossibleFailures(Element element) {
        List<String> possibleFailures = new ArrayList<String>();
        List<Element> possibleFailureList = element.elements(POSSIBLE_FAIILURE);
        for (Element possibleFailureElement : possibleFailureList) {
            if (possibleFailureElement != null) {
                possibleFailures.add(possibleFailureElement.getTextTrim());
            }
        }

        return possibleFailures;
    }

}
