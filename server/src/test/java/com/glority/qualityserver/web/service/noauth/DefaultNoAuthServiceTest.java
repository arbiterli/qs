package com.glority.qualityserver.web.service.noauth;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;

import com.glority.qualityserver.AbstractBaseControllerTest;

public class DefaultNoAuthServiceTest extends AbstractBaseControllerTest {
    @Test
    public void testNoauth() throws Exception {
         get("/service/noauth/test").andExpect(status().isOk()).andExpect(content().string("test"));
    }
}
