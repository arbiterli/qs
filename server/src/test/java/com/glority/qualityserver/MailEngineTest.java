package com.glority.qualityserver;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.mail.internet.InternetAddress;

import org.junit.Test;
import org.subethamail.wiser.WiserMessage;

public class MailEngineTest extends AbstractMailTest {
    @Test
    public void testSend() throws Exception {
        Date dte = new Date();
        String emailSubject = "grepster testSend: " + dte;
        String emailBody = "Body of the grepster testSend message sent at: " + dte;
        
        this.mailEngine.sendPlainEmail("foo@bar.com", emailSubject, emailBody);
        
        validateMessageSize(1);
        validateMessage(0, emailSubject, emailBody);
        WiserMessage wm = wiser.getMessages().get(0);
        assertEquals("noreply@qualitysystem.com", ((InternetAddress) wm.getMimeMessage().getFrom()[0]).getAddress());
    }
}
