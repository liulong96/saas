package com.power.saas.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Long on 2018/7/23.
 */
public class helloScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //打印当前执行时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("当前时间：" + sf.format(date));
        //创建一个JObDetail实例，讲该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(helloJob.class)
                .withIdentity("myJob", "group1").usingJobData("message", "hello myJob1").build();
        // CronTrigger实现每秒钟执行一次
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myCronTrigger", "trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();

       /* //获取当前时间3秒后
        date.setTime(date.getTime()+3000);
        //获取当前时间6秒后 结束
        Date endDate=new Date();
        endDate.setTime(endDate.getTime()+6000);
        //创建一个Trigger 实例 定义该job立即执行，并且每隔两秒执行，知道永远
        Trigger trigger= TriggerBuilder.newTrigger().withIdentity("myTrigger","group1")
                .usingJobData("message","hello myTrigger1")
                .startAt(date)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();*/
        //距离当前时间4秒后执行，每隔两秒，重复
       /* date.setTime(date.getTime()+4000);
        SimpleTrigger trigger= (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();*/
        //创建Scheduler实例 ，通过factory创建
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);//绑定
        Date d = scheduler.scheduleJob(jobDetail, trigger);//绑定
        System.out.print(sf.format(d));
        //执行两秒后挂起
//        Thread.sleep(2000L);
//        scheduler.standby();
//        scheduler.shutdown();
        

    }
}
