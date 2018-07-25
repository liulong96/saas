package com.power.saas.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Long on 2018/7/23.
 */
public class helloJob implements Job {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        //打印当前执行时间
        Date data=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("当前时间："+sf.format(data));
        //编写具体的业务逻辑
        //System.out.print("Hello Word");
        Trigger trigger=context.getTrigger();
        System.out.print("startTime is "+sf.format(trigger.getStartTime()));



        JobKey jobKey=context.getJobDetail().getKey();
        System.out.print("jobKey:"+jobKey.getName()+" and "+jobKey.getGroup());
        TriggerKey triggerKey=context.getTrigger().getKey();
        System.out.print(" triggerKey:"+triggerKey.getName()+" and "+triggerKey.getGroup());
//        JobDataMap jobDataMap=context.getJobDetail().getJobDataMap();
//        JobDataMap  triggerDataMap=context.getTrigger().getJobDataMap();
//        String jobMsg=jobDataMap.getString("message");
//        String triggerMsg=triggerDataMap.getString("message");
//        System.out.print(" job:"+jobMsg+"  trigger:"+triggerMsg);

        //获取所有key key值相等取trigger
//        JobDataMap dataMap=context.getMergedJobDataMap();
//        String triggerMsg=dataMap.getString("message");
//        System.out.print(" trigger:"+triggerMsg);

        //成员变量和存值key一样
        System.out.print(" trigger:"+message);

    }
}
