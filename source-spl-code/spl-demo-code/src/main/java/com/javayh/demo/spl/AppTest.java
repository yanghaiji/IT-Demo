package com.javayh.demo.spl;

import com.javayh.app.spl.AppRun;
import com.javayh.tomcat.spl.TomcatRun;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-07
 */
public class AppTest {
    public static void main(String[] args) {
        AppRun tomcat = new TomcatRun();
        Run run = new Run(tomcat);
        run.run();
    }
}
