package com.celnet.dc.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

@Service
public class QuartzEventService  {

	public static final String QUARTZ_GROUP_01 = "group01";
	public static final String QUARTZ_JOB_01 = "job01";
	public static final String QUARTZ_TRIGGER_01 = "trigger01";
	public static final String QUARTZ_RATE_01 = "0/1 * * * * ?";

	public static final String QUARTZ_GROUP_02 = "group02";
	public static final String QUARTZ_JOB_02 = "job02";
	public static final String QUARTZ_TRIGGER_02 = "trigger02";
	public static final String QUARTZ_RATE_02 = "0/1 * * * * ?";
	
	public static final String QUARTZ_GROUP_03 = "group02";
	public static final String QUARTZ_JOB_03 = "job02";
	public static final String QUARTZ_TRIGGER_03 = "trigger02";
	public static final String QUARTZ_RATE_03 = "0/30 * * * * ?";
	

    public void addQuartz01(Scheduler scheduler) throws SchedulerException {

        JobDetail job = JobBuilder.newJob(ScheduleTaskDo.class).withIdentity(QUARTZ_JOB_01, QUARTZ_GROUP_01).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(QUARTZ_RATE_01);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(QUARTZ_TRIGGER_01, QUARTZ_GROUP_01).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(job, trigger);
    }
    
    public void addQuartz02(Scheduler scheduler) throws SchedulerException {

      JobDetail job = JobBuilder.newJob(ScheduleTaskSay.class).withIdentity(QUARTZ_JOB_02, QUARTZ_GROUP_02).build();
      CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(QUARTZ_RATE_02);
      Trigger trigger = TriggerBuilder.newTrigger().withIdentity(QUARTZ_TRIGGER_02, QUARTZ_GROUP_02).withSchedule(scheduleBuilder).build();
      scheduler.scheduleJob(job, trigger);
  }
    public void addQuartz03(Scheduler scheduler) throws SchedulerException {

        JobDetail job = JobBuilder.newJob(ScheduleTaskSay.class).withIdentity(QUARTZ_JOB_03, QUARTZ_GROUP_03).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(QUARTZ_RATE_03);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(QUARTZ_TRIGGER_03, QUARTZ_GROUP_03).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(job, trigger);
    }
}
