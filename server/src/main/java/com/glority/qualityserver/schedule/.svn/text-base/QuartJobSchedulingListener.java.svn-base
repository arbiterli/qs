package com.glority.qualityserver.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.JobDetailBean;

import com.glority.qualityserver.exception.NotInheritClassException;

/**
 * QuartJobSchedulingListener. this class config quartz job on spring context
 * load or refresh.
 * 
 * @author liheping
 * 
 */
public class QuartJobSchedulingListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = Logger.getLogger(QuartJobSchedulingListener.class);
    @Autowired
    private Scheduler scheduler;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            ApplicationContext applicationContext = event.getApplicationContext();
            List<CronTriggerBean> cronTriggerBeans = this.loadCronTriggerBeans(applicationContext);
            this.scheduleJobs(cronTriggerBeans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CronTriggerBean> loadCronTriggerBeans(ApplicationContext applicationContext) {
        Map<String, Object> quartzJobBeans = applicationContext.getBeansWithAnnotation(QuartzJob.class);

        Set<String> beanNames = quartzJobBeans.keySet();

        List<CronTriggerBean> cronTriggerBeans = new ArrayList<CronTriggerBean>();
        // MethodInvokingJobDetailFactoryBean bean = new
        // MethodInvokingJobDetailFactoryBean();
        // b
        for (String beanName : beanNames) {
            CronTriggerBean cronTriggerBean = null;
            Object object = quartzJobBeans.get(beanName);
            // System.out.println(object);
            try {
                cronTriggerBean = this.buildCronTriggerBean(object);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }

            if (cronTriggerBean != null) {
                cronTriggerBeans.add(cronTriggerBean);
            }
        }
        return cronTriggerBeans;
    }

    public CronTriggerBean buildCronTriggerBean(Object job) throws Exception {
        CronTriggerBean cronTriggerBean = null;
        QuartzJob quartzJobAnnotation = AnnotationUtils.findAnnotation(job.getClass(), QuartzJob.class);

        if (Job.class.isAssignableFrom(job.getClass())) {
            // System.out.println("It is a Quartz Job");
            cronTriggerBean = new CronTriggerBean();
            cronTriggerBean.setCronExpression(quartzJobAnnotation.cronExp());
            cronTriggerBean.setName(quartzJobAnnotation.name() + "_trigger");
            // cronTriggerBean.setGroup(quartzJobAnnotation.group());
            JobDetailBean jobDetail = new JobDetailBean();
            jobDetail.setName(quartzJobAnnotation.name());
            // jobDetail.setGroup(quartzJobAnnotation.group());
            jobDetail.setJobClass(job.getClass());
            cronTriggerBean.setJobDetail(jobDetail);
        } else {
            throw new NotInheritClassException(job.getClass() + " doesn't implemented " + Job.class);
        }
        return cronTriggerBean;
    }

    protected void scheduleJobs(List<CronTriggerBean> cronTriggerBeans) {
        for (CronTriggerBean cronTriggerBean : cronTriggerBeans) {
            JobDetail jobDetail = cronTriggerBean.getJobDetail();
            try {
                LOGGER.debug("JOB : name - " + jobDetail.getName() + ", group - " + jobDetail.getGroup());
                // if (null == scheduler.getJobDetail(jobDetail.getName(),
                // jobDetail.getGroup())) {
                LOGGER.debug("ADD JOB : name - " + jobDetail.getName() + ", group - " + jobDetail.getGroup());
                scheduler.scheduleJob(jobDetail, cronTriggerBean);
                // }
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }
}
