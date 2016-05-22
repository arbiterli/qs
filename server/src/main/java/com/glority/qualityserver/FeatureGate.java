package com.glority.qualityserver;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.glority.quality.StringUtil;

/**
 * Feature Gate class.
 * 
 * based on the configurations in qualityserver.properties to control the feature's enable status.
 * 
 * @author liheping
 * 
 */
public final class FeatureGate {
    private static final Logger LOGGER = Logger.getLogger(FeatureGate.class);

    private Map<FeatureGateName, Boolean> gateMap;

    private static FeatureGate gate = new FeatureGate();

    /**
     * the method to get FeatureGate instance.
     * 
     * @return FeatureGate instance.
     */
    public static FeatureGate getInstance() {
        return gate;
    }

    /**
     * constructor.
     */
    private FeatureGate() {
        this.gateMap = new HashMap<FeatureGateName, Boolean>();

        try {
            ServerSettings settings = ServerSettings.getInstance();

            FeatureGateName[] names = FeatureGateName.values();
            for (FeatureGateName name : names) {
                String value = (String) settings.getSetting(name.toString());
                LOGGER.debug(name + " value : " + value);
                boolean enabled = false;
                if (!StringUtil.isEmpty(value)) {
                    try {
                        enabled = Boolean.parseBoolean(value);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
                LOGGER.debug(name + " enabled : " + enabled);
                this.gateMap.put(name, Boolean.valueOf(enabled));
            }

        } catch (Exception e) {
            LOGGER.error(" init feature gate failed!");
        }
    }

    /**
     * check whether the specified feature gate is enabled.
     * 
     * @param gate
     *            the specified gate name
     * @return whether the specified gate is enabled
     */
    public boolean isFeatureEnabled(FeatureGateName gate) {

        Boolean gateState = this.gateMap.get(gate);

        if (gateState != null) {
            return gateState.booleanValue();
        }

        return false;
    }
}
