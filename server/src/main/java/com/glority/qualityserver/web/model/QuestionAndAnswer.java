package com.glority.qualityserver.web.model;

/**
 * Hold Question and Answer for metrics.
 *
 */
public class QuestionAndAnswer {

    private String question;

    private String answer;

    /**
     * Get the question.
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set the question.
     * @param question question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Get the answer.
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set the Answer.
     * @param answer the answer.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
