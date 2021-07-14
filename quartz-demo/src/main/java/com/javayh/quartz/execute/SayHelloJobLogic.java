package com.javayh.quartz.execute;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * Job 是 定时任务的具体执行逻辑
 * JobDetail 是 定时任务的定义
 * @author haiyang
 */
@Slf4j
@DisallowConcurrentExecution
public class SayHelloJobLogic implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        //写你自己的逻辑
        log.info("SayHelloJob.execute , hello world  ! ");
        //获取传入的参数
        log.info("jobDataMap {}",jobDataMap.getString("hello"));

    }
}
