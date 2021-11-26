package com.javayh.kettle;

import cn.hutool.core.io.FileUtil;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-24
 */
public class KettleJobTest {

    /**
     * 这是一个job ，调用了上一个示例的转换，如果输出成功，则创建一个txt文件，并写一段话
     * @param args
     * @throws KettleException
     */
    public static void main(String[] args) throws KettleException {
        File file = FileUtil.file("kettle/job_demo_01.kjb");
        String path = file.getPath();
        System.out.println(path);
        KettleEnvironment.init();
        // 任务元对象  fileName为作业的绝对路径
        JobMeta jm = new JobMeta("kettle/job_demo_01.kjb", null);
        // 任务
        Job job = new Job(null, jm);
        // 传参
        /*job.setVariable("beginTime", beginTime);
        job.setVariable("endTime", endTime);*/
        // 开始任务
        job.start();
        // 等待任务结束
        job.waitUntilFinished();
    }
}
