package com.javayh.hadoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → PACKAGE_NAME → com.javayh.hadoop.HadoopApp
 * @since 2022-06-07
 */
@SpringBootApplication
public class HadoopApp {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\java_tools\\hadoop\\hadoop-3.0.0");
        SpringApplication.run(HadoopApp.class,args);
    }
}
