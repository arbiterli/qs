package com.glority.qualityserver.manager.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.error.ErrorFrom;
import com.glority.qualityserver.manager.SystemErrorManager;
import com.glority.qualityserver.model.SystemError;

public class SystemErrorImplTest extends AbstractBaseTest {
    @Autowired
    private SystemErrorManager systemErrorManager;

    @Test
    public void testCreate() {
        SystemError error = this.systemErrorManager.createSystemError(ErrorFrom.QUALITY_SERVER, "info", "externInfo",
                "owner");
        assertTrue(error != null);
    }
}
