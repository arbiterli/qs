package com.glority.qualityserver.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import com.glority.qualityserver.AbstractBaseControllerTest;

/**
 * Controller test
 * 
 */
public class MetricsDescriptionControllerTest extends AbstractBaseControllerTest {
    /**
     * Test if get description controller can work or not.
     * 
     * @throws Exception
     *             to junit
     */
    @Test
    public void testGetDescription() throws Exception {
        get("/metricsdescription/getMetricsDescription").andExpect(status().isOk());
    }
}
