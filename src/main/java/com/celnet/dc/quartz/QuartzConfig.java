package com.celnet.dc.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private SpringJobFactory springJobFactory;
	
	@Autowired
	private QuartzEventService myScheduler;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		try {
//			//myScheduler.addQuartz01(scheduler());//添加第1个定时任务
//			myScheduler.addQuartz03(scheduler());//添加第2个定时任务
//		} catch (SchedulerException e) {
//			e.printStackTrace();
//		}
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setJobFactory(springJobFactory);
		return schedulerFactoryBean;
	}

	@Bean
	public Scheduler scheduler() {
		return schedulerFactoryBean().getScheduler();
	}
}
