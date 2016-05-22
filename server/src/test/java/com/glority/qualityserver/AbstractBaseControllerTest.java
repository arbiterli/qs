package com.glority.qualityserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
public abstract class AbstractBaseControllerTest extends AbstractBaseTest {
    @Autowired
    private WebApplicationContext wac;

    protected MockMvc build() {
        return MockMvcBuilders.webAppContextSetup(wac).build();
    }

    protected ResultActions get(String string) throws Exception {
        return build().perform(MockMvcRequestBuilders.get(string));
    }
}
