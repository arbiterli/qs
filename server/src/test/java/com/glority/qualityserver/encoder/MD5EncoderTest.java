package com.glority.qualityserver.encoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class MD5EncoderTest extends AbstractBaseTest {

    @Autowired
    private MD5Encoder md5;

    @Test
    public void testIsPasswordValid() {
        assertTrue(md5.isPasswordValid("5F4DCC3B5AA765D61D8327DEB882CF99", "password", new String()));
    }
}
