package com.glority.qualityserver.service;

import java.io.Serializable;
import java.util.Map;

/**
 * MailService interface.
 * @author Administrator
 */
public interface MailService {
    /**
     * Send simple email.
     * @param from the email from
     * @param emailAddress the email address
     * @param subject subject of the mail
     * @param content content of the mail
     */
    void sendPlainEmail(String from, String emailAddress, String subject, String content);

    /**
     * Send simple email.
     * @param emailAddress the email address
     * @param subject subject of the mail
     * @param content content of the mail
     */
    void sendPlainEmail(String emailAddress, String subject, String content);

    /**
     * send email to the given address.
     * @param emailAddress the email address of administrator
     * @param subject the subject title
     * @param templateName template name of email pattern
     * @param model the message of email
     */
    void sendPlainEmail(String emailAddress, String subject, String templateName,
            Map<String, Serializable> model);

    /**
     * send HTML email to the given address.
     * @param emailAddress the email address of administrator
     * @param subject the subject title
     * @param templateName template name of email pattern
     * @param model the message of email
     */
    void sendHTMLEmail(String emailAddress, String subject, String templateName,
            Map<String, Serializable> model);

}
