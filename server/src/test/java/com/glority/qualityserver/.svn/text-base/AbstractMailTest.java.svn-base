package com.glority.qualityserver;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import com.glority.qualityserver.service.impl.MailEngine;

/**
 * This class is used for tests require testing email.
 * @author xxd
 *
 */
public abstract class AbstractMailTest extends AbstractBaseTest {
    @Autowired
    protected MailEngine mailEngine;
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    protected Wiser wiser;

    @Before
    public void setUp() {
        // set the port to a random value so there's no conflicts between tests
        int port = 2525 + (int) (Math.random() * 100);
        mailSender.setPort(port);        
        mailSender.setHost("localhost");
        mailEngine.setMailSender(mailSender);
        
        // mock smtp server
        wiser = new Wiser();
        wiser.setPort(port);
        wiser.start();
    }

    @After
    public void tearDown() {
        mailEngine.setMailSender(null);
        wiser.stop();
    }
    
    protected void validateMessageSize(long expectMessageCount) {
        assertEquals(expectMessageCount, (long) wiser.getMessages().size());
    }
    
    protected void validateMessage(int index, String expectSubject, String expectContent) 
        throws MessagingException, IOException {
        assertTrue(wiser.getMessages().size() >= index + 1);
        WiserMessage wm = wiser.getMessages().get(0);
        assertEquals(expectSubject, wm.getMimeMessage().getSubject());
        String content = (String)wm.getMimeMessage().getContent();
        //for deal with different OS.
        String processContent = content.replace("\r", "");
        assertEquals(expectContent, processContent);
    }
}
