package com.glority.qualityserver.encoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.glority.qualityserver.AbstractBaseTest;

public class MD5Test extends AbstractBaseTest {

    @Test
    public void testVerifyPasswordForMultiTimes() {
        assertTrue(MD5.verifyPassword("password", "AAA0CC98C7DC4AB6FD12433F097107D9", 3));
    }

    @Test
    public void testVerifyPassword() {
        assertTrue(MD5.verifyPassword("password", "5F4DCC3B5AA765D61D8327DEB882CF99"));
    }

}
