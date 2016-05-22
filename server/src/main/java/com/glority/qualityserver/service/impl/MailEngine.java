package com.glority.qualityserver.service.impl;

import java.io.Serializable;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.StringUtils;

import com.glority.qualityserver.service.MailService;

/**
 * Class for sending e-mail messages based on Velocity templates
 * or with attachments.
 */
public class MailEngine implements MailService {
    public static final String COMMA = ",";
    /**
     * tag of log.
     */
    private final Log log = LogFactory.getLog(MailEngine.class);
    /**
     * mailSender of MailEngine.
     */
    private JavaMailSender mailSender;
    /**
     * velocityEngine of MailEngine, use the default loader.
     */
    private VelocityEngine velocityEngine;

    /**
     * defaultFrom of MailEngine.
     */
    private String defaultFrom;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setFrom(String from) {
        this.defaultFrom = from;
    }

    /**
     * Send a simple message with pre-populated values.
     * @param msg the message to send
     */
    private void sendMessage(SimpleMailMessage msg) {
        try {
            if (!StringUtils.hasText(msg.getFrom())) {
                msg.setFrom(this.defaultFrom);
            }
            mailSender.send(msg);
        } catch (MailException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    /**
     * Send a simple message based on a Velocity template.
     * @param msg the message to populate
     * @param templateName the Velocity template to use (relative to classpath)
     * @param model a map containing key/value pairs
     */
    private void sendMessage(SimpleMailMessage msg, String templateName, Map<String, Serializable> model) {
        String result = null;

        try {
            result =
                VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                                                            "templates/" + templateName, "utf-8", model);
        } catch (VelocityException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }

        msg.setText(result);
        sendMessage(msg);
    }

    /**
     * send HTML message.
     * @param msg the message to send
     * @param templateName the template to use
     * @param model a map containing key/value pairs
     */
    private void sendHTMLMessageByHtml(SimpleMailMessage msg, String templateName, Map<String, Serializable> model) {
        try {
            String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                    "templates/" + templateName, "utf-8", model);
            sendHtmlMessage(msg, content);
        } catch (VelocityException e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Convenience method for sending messages with attachments.
     * @param recipients array of e-mail addresses
     * @param sender e-mail address of sender
     * @param resource attachment from classpath
     * @param bodyText text in e-mail
     * @param subject subject of e-mail
     * @param attachmentName name for attachment
     * @throws MessagingException thrown when can't communicate with SMTP server
     */
    public void sendMessage(String[] recipients, String sender,
                            ClassPathResource resource, String bodyText,
                            String subject, String attachmentName)
    throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        // use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(recipients);

        // use the default sending if no sender specified
        if (sender == null) {
            helper.setFrom(defaultFrom);
        } else {
           helper.setFrom(sender);
        }

        helper.setText(bodyText);
        helper.setSubject(subject);

        helper.addAttachment(attachmentName, resource);

        mailSender.send(message);
    }

    /**
     * send html email according the content.
     * @param msg the message to send
     * @param content the content
     */
    private void sendHtmlMessage(SimpleMailMessage msg, String content) {
        MimeMessage mimeMsg = null;
        try {
            mimeMsg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "utf-8");
            helper.setTo(msg.getTo());
            if (msg.getSubject() != null) {
                helper.setSubject(msg.getSubject());
            }

            helper.setFrom(defaultFrom);
            helper.setText(content, true);
            mailSender.send(mimeMsg);
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }
    }


    /**
     * Send a plain message.
     * @param subject subject of the mail
     * @param receivers receivers of the mail, split by comma.
     * @param text content of the mail
     * @return A SimpleMailMessage instance
     */
    private SimpleMailMessage createSimpleMessage(String subject, String receivers, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        String [] receiverArray = receivers.split(COMMA);
        message.setTo(receiverArray);
        message.setText(text);
        return message;
    }

    @Override
    public void sendPlainEmail(String emailAddress,
            String subject, String templateName, Map<String, Serializable> model) {
        SimpleMailMessage message = createSimpleMessage(subject, emailAddress, null);
        sendMessage(message, templateName, model);
    }

    @Override
    public void sendHTMLEmail(String emailAddress, String subject,
            String templateName, Map<String, Serializable> model) {
        SimpleMailMessage message = createSimpleMessage(subject, emailAddress, null);
        sendHTMLMessageByHtml(message, templateName, model);
    }

    @Override
    public void sendPlainEmail(String emailAddress, String subject,
            String content) {
        SimpleMailMessage message = createSimpleMessage(subject, emailAddress, content);
        sendMessage(message);
    }

    @Override
    public void sendPlainEmail(String from, String emailAddress, String subject, String content) {
        SimpleMailMessage message = createSimpleMessage(subject, emailAddress, content);
        message.setFrom(from);
        sendMessage(message);
    }
}

