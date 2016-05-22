package com.glority.qualityserver.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.glority.qualityserver.AbstractBaseControllerTest;

/**
 * Test class for {@link #BuildController)}.
 * modify by xu.weifeng
 * @author liheping
 */
public class BuildControllerTest extends AbstractBaseControllerTest {

    @Autowired
    private BuildController controller;

    private MockHttpServletRequest request = new MockHttpServletRequest();
    //private MockHttpServletResponse response = new MockHttpServletResponse();
    private MockMvc mockMvc = null;

    private static final String DEFAULT_BUILD_ID = "3";
    private static final String DEFAULT_PRODUCT_ID = "1";
    //private static final String INVALID_ID = "-1";

    /**
     * run before every test case, to initialize the test environment.
     */
    @Before
    public void setUp() {
        request.setParameter(BasicController.BUILD_ID, DEFAULT_BUILD_ID);
        request.setParameter(BasicController.PRODUCT_ID, DEFAULT_PRODUCT_ID);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = standaloneSetup(controller).setViewResolvers(viewResolver).build();
    }

    /**
     * run after every test case, to clean up the test environment.
     */
    @After
    public void tearDown() {
        this.mockMvc = null;
    }

    /**
     * test if the BuildController can handle the request rightly by the url template: /build/buildreportlist
     * @throws Exception exception
     */
    @Test
    public void testGetBuildReportListPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreportlist"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreportlist").param("productId", "10000"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreportlist").param("productId", "1"))
        .andExpect(status().isOk())
        .andExpect(request().attribute("productId", new Long(1)))
        .andExpect(request().attribute("productName", "Quality System"))
        .andExpect(forwardedUrl("/WEB-INF/jsp/buildreportlist.jsp"));
    }

    /**
     * test if the BuildController can handle the request rightly by the url template: /build/buildreport
     * @throws Exception exception
     */
    @Test
    public void testGetBuildReportPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreport"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreport").param("productId", "-1"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreport").param("buildId", "-1"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreport").param("productId", "10000").param("buildId", "3"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

        mockMvc.perform(MockMvcRequestBuilders.get("/build/buildreport").param("productId", "1").param("buildId", "3"))
        .andExpect(status().isOk())
        .andExpect(request().attribute("productId", new Long(1)))
        .andExpect(request().attribute("productName", "Quality System"))
        .andExpect(forwardedUrl("/WEB-INF/jsp/buildreport.jsp"));
    }

//    /**
//     * test if the BuildController can handle the request rightly by the url template: /build/testbuildinfo
//     * @throws Exception exception
//     */
//    @Test
//    public void testGetTestBuildInfoPage() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/build/testbuildinfo"))
//        .andExpect(status().isOk())
//        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/build/testbuildinfo").param("productId", "-1"))
//        .andExpect(status().isOk())
//        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/build/testbuildinfo").param("buildId", "-1"))
//        .andExpect(status().isOk())
//        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/build/testbuildinfo").param("productId", "10000").param("buildId", "3"))
//        .andExpect(status().isOk())
//        .andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/build/testbuildinfo").param("productId", "1").param("buildId", "3"))
//        .andExpect(status().isOk())
//        .andExpect(request().attribute("productId", new Long(1)))
//        .andExpect(request().attribute("productName", "Quality System"))
//        .andExpect(forwardedUrl("/WEB-INF/jsp/testbuildinfo.jsp"));
//    }

}
