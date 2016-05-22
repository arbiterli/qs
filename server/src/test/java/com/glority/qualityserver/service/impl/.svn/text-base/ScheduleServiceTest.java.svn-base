package com.glority.qualityserver.service.impl;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.quality.connectors.supportdb.StdEmailContent;
import com.glority.qualityserver.AbstractMailTest;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.dao.ServerDao;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.SchedulerService;

/**
 * Test SchedulerService
 * 
 * @author xxd
 */
public class ScheduleServiceTest extends AbstractMailTest {
    @Autowired
    private SchedulerService scheduleService;

    @Autowired
    private ServerDao serverDao;

    @Autowired
    private ProductManager productManager;

    @Test
    public void testSendServerChangeEmailToOperations() throws Exception {
        Server testServer = serverDao.get(1L);
        Product testProduct = productManager.getProduct(testServer);
        assertEquals("JavaZipSendServer", testProduct.getName());

        StdEmailContent content = new StdEmailContent();
        content.setInfo("server changes detected");
        content.setProductName(testProduct.getName());
        content.setServerName(testServer.getName());
        content.setTitle("Server Invalid Changes");
        content.setType("Alert");

        Boolean oldValue = this.modifyFeatureGate(FeatureGateName.SUPPORT_DB_EMAIL_SEND, Boolean.TRUE);
        scheduleService.saveChange(content.getInfo(), testServer);
        this.modifyFeatureGate(FeatureGateName.SUPPORT_DB_EMAIL_SEND, oldValue);

        assertEquals(content.getEmailContent(), content.getEmailContent());

        validateMessageSize(1);
        validateMessage(0, content.getFomartTitle(), content.getEmailContent());
    }

    private Boolean modifyFeatureGate(FeatureGateName name, Boolean value) throws Exception {
        FeatureGate gate = FeatureGate.getInstance();
        Class gateClass = gate.getClass();
        Field mapField = gateClass.getDeclaredField("gateMap");
        mapField.setAccessible(true);
        Map<FeatureGateName, Boolean> gateMap = (Map<FeatureGateName, Boolean>) mapField.get(gate);
        return gateMap.put(name, value);
    }

}
