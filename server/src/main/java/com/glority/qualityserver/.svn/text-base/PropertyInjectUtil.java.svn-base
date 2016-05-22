package com.glority.qualityserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.glority.qualityserver.manager.SystemErrorManager;

/**
 * inject spring context bean to classes.
 * 
 * @author li.heping
 * 
 */
@Component
public class PropertyInjectUtil implements ApplicationListener {

    @Autowired
    private SystemErrorManager systemErrorManager;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // ContextRefreshedEvent, bean load finshed or context refreshed
        // triggered.
        if (event instanceof ContextRefreshedEvent) {
            ServerErrorCollector.getInstance().setSystemErrorManager(systemErrorManager);
        }
    }

}
