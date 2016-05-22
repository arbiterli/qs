package com.glority.qualityserver.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import com.glority.qualityserver.AbstractBaseControllerTest;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.exception.PermissionDeniedException;
import com.glority.qualityserver.web.service.key.KeyAuthService;

public class DefaultKeyAuthServiceTest extends AbstractBaseControllerTest {
    @Test
    public void testNoKey() throws Exception {
        get("/service/key/test").andExpect(status().isBadRequest());
    }

    @Test
    public void testValidKey() throws Exception {
        get("/service/key/test?key=" + ServerSettings.getInstance().getSetting(KeyAuthService.SERVER_DEFAULT_AUTH_KEY))
                .andExpect(status().isOk()).andExpect(content().string("test"));
    }

    @Test(expected = PermissionDeniedException.class)
    public void testInValidKey() throws Throwable {
        try {
            get("/service/key/test?key=InvalidKey").andExpect(status().isNotFound());
        } catch (Exception e) {
            // The exception will be wrapped by
            // org.springframework.web.util.NestedServletException
            // Unwrap to the original exception.
            throw e.getCause();
        }
    }
}
