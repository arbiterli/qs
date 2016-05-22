package com.glority.qualityserver.web.model;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the description for one kind of Metric. It includes overview, metric
 * name, metric score calculate formula, owners who take care the metrics,
 * question and answers , reference link, and possible failure reason for the
 * metrics.
 * 
 * <p>
 * The overview, reference links, possible failures are all retrieved from
 * configuration xml files. The metric formula will be retrieved from
 * MetricEngine.ScoreItem.
 * </p>
 * 
 * @author Chenhong
 */
public class MetricsDescription {

    public static final String METRIC_DESCRIPTION_URL = "/metricsdescription/getMetricsDescriptionDetail";

    private String overview;

    private String metricName;

    private MetricScoreFormula metricFormula;
    private List<ScoreOwner> owners;
    private List<QuestionAndAnswer> qAndAList;
    private List<String> referenceLinks;
    private List<String> possibleFailures;

    /**
     * Get the Overview.
     * 
     * @return overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Set the overview.
     * 
     * @param overview
     *            overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Get the metric name.
     * 
     * @return the metric name
     */
    public String getMetricName() {
        return metricName;
    }

    /**
     * Set the metric name.
     * 
     * @param metricName
     *            the metric name to set.
     */
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    /**
     * Get the formula.
     * 
     * @return formula.
     */
    public MetricScoreFormula getMetricFormula() {
        return metricFormula;
    }

    /**
     * Set the formulas.
     * 
     * @param metricFormula
     *            the formula
     */
    public void setMetricFormula(MetricScoreFormula metricFormula) {
        this.metricFormula = metricFormula;
    }

    /**
     * Get owners.
     * 
     * @return owners.
     */
    public List<ScoreOwner> getOwners() {
        if (this.owners == null) {
            return new ArrayList<ScoreOwner>();
        }
        return this.owners;
    }

    /**
     * Set the owners.
     * 
     * @param owners
     *            owners.
     */
    public void setOwners(List<ScoreOwner> scoreOwners) {
        if (scoreOwners == null) {
            throw new IllegalArgumentException("The parameter scoreOwners should not be null.");
        }
        this.owners = new ArrayList<ScoreOwner>(scoreOwners);
    }

    /**
     * Get the question and answers.
     * 
     * @return Q&A
     */
    public List<QuestionAndAnswer> getqAndAList() {
        if (qAndAList == null) {
            return new ArrayList<QuestionAndAnswer>();
        }
        return qAndAList;
    }

    /**
     * Set the question and answers.
     * 
     * @param qAndAList
     *            Q&A
     */
    public void setQuestionAndAnswerList(List<QuestionAndAnswer> qAndAList) {
        if (qAndAList == null) {
            throw new IllegalArgumentException("The parameter for Q&A should not be null.");
        }
        this.qAndAList = new ArrayList<QuestionAndAnswer>(qAndAList);
    }

    /**
     * Get the reference links.
     * 
     * @return the reference links.
     */
    public List<String> getReferenceLinks() {
        if (referenceLinks == null) {
            return new ArrayList<String>();
        }
        return referenceLinks;
    }

    /**
     * Set the reference links.
     * 
     * @param referenceLinks
     *            the reference links.
     */
    public void setReferenceLinks(List<String> referenceLinks) {
        if (referenceLinks == null) {
            throw new IllegalArgumentException("The referenceLinks should not be null.");
        }
        this.referenceLinks = new ArrayList<String>(referenceLinks);
    }

    /**
     * Get possible failure reasons.
     * 
     * @return the possible failure reason
     */
    public List<String> getPossibleFailures() {
        if (possibleFailures == null) {
            return new ArrayList<String>();
        }
        return possibleFailures;
    }

    /**
     * Set the possible failures.
     * 
     * @param possibleFailures
     *            the possible failures
     */
    public void setPossibleFailures(List<String> possibleFailures) {
        if (possibleFailures == null) {
            throw new IllegalArgumentException("The possibleFailures should not be null.");
        }
        this.possibleFailures = possibleFailures;
    }
}
