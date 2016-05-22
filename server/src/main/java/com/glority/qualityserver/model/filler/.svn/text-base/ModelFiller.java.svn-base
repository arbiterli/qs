package com.glority.qualityserver.model.filler;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * ModelFiller. fill model some property.
 * 
 * @author li.heping
 * 
 */
public final class ModelFiller {
    public static final String PROPERTY_NAME = "propertyName";
    public static final String PROPERTY_VALUE = "propertyValue";

    private static final Logger LOGGER = Logger.getLogger(ModelFiller.class);

    @SuppressWarnings("rawtypes")
    public static void fillModelWithProperties(Object targetObj, List<Object> propertyList) {
        if (propertyList == null || targetObj == null) {
            return;
        }

        Class targetClass = targetObj.getClass();
        for (Object property : propertyList) {
            if (property != null) {
                try {
                    Class propertyClass = property.getClass();
                    Field nameField = propertyClass.getDeclaredField(PROPERTY_NAME);
                    nameField.setAccessible(true);
                    String propertyName = (String) nameField.get(property);

                    Field valueField = propertyClass.getDeclaredField(PROPERTY_VALUE);
                    valueField.setAccessible(true);
                    String propertyValue = (String) valueField.get(property);

                    Field targetPropertyField = targetClass.getDeclaredField(propertyName);
                    targetPropertyField.setAccessible(true);
                    targetPropertyField.set(targetObj, propertyValue);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    private ModelFiller() {

    }
}
