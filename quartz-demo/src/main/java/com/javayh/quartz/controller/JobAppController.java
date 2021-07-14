package com.javayh.quartz.controller;

import com.javayh.quartz.entity.TaskDefine;
import com.javayh.quartz.execute.SayHelloJobLogic;
import com.javayh.quartz.service.QuartzJobService;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class JobAppController {


    @Resource
    private QuartzJobService quartzJobService;


    //假如 这个定时任务的 名字叫做HelloWorld, 组名GroupOne
    private final JobKey jobKey = JobKey.jobKey("HelloWorld", "GroupOne");


    /**
     * 启动 hello world
     */
    @GetMapping("/startHelloWorldJob")
    public String startHelloWorldJob() throws SchedulerException {

        //创建一个定时任务
        TaskDefine task = TaskDefine.builder()
                .jobKey(jobKey)
                .cronExpression("0/2 * * * * ? ")
                //具体的逻辑
                .jobClass(SayHelloJobLogic.class)
                .description("这是一个测试的 任务")
                .build();

        quartzJobService.scheduleJob(task);
        return "start HelloWorld Job success";
    }

    /**
     * 暂停 hello world
     */
    @GetMapping("/pauseHelloWorldJob")
    public String pauseHelloWorldJob() throws SchedulerException {
        quartzJobService.pauseJob(jobKey);
        return "pause HelloWorld Job success";
    }


    /**
     * 恢复 hello world
     */
    @GetMapping("/resumeHelloWorldJob")
    public String resumeHelloWorldJob() throws SchedulerException {
        quartzJobService.resumeJob(jobKey);
        return "resume HelloWorld Job success";
    }

    /**
     * 删除 hello world
     */
    @GetMapping("/deleteHelloWorldJob")
    public String deleteHelloWorldJob() throws SchedulerException {
        quartzJobService.deleteJob(jobKey);
        return "delete HelloWorld Job success";
    }

    /**
     * 修改 hello world 的cron表达式
     */
    @GetMapping("/modifyHelloWorldJobCron")
    public String modifyHelloWorldJobCron() {
        //这是即将要修改cron的定时任务
        TaskDefine modifyCronTask = TaskDefine.builder()
                .jobKey(jobKey)
                .cronExpression("0/5 * * * * ? ")
                .jobClass(SayHelloJobLogic.class)
                .description("这是一个测试的 任务")
                .build();
        if (quartzJobService.modifyJobCron(modifyCronTask)){
            return "modify HelloWorld Job Cron success";
        }
        else{
            return "modify HelloWorld Job Cron fail";
        }
    }


}
