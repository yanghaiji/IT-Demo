package com.javayh.jimu.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-08-09
 */
@SpringBootApplication(scanBasePackages = {"org.jeecg.modules.jmreport", "com.javayh.jimu.report"})
public class JiMuReportApp {
    public static void main(String[] args) {
        SpringApplication.run(JiMuReportApp.class, args);
    }
}
