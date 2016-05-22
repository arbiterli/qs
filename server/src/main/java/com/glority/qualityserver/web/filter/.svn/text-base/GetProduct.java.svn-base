package com.glority.qualityserver.web.filter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for get Product.
 * 
 * @author liheping
 * 
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface GetProduct {
    ProductParamName paramName();

    int index() default 0;

    /**
     * the param name for get product.
     * 
     * @author liheping
     * 
     */
    public enum ProductParamName {
        PRODUCT_ID, SERVER_ID, VERSION_ID, PHASE_ID, BUILD_ID, FAILURE_ID;
    }
}
