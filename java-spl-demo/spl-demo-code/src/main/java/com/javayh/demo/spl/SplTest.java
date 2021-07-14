package com.javayh.demo.spl;

import com.javayh.app.spl.AppRun;

import java.util.ServiceLoader;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-07
 */
public class SplTest {
    public static final String APP = "app:jboss://";

    public static void main(String[] args) {
        ServiceLoader<AppRun> load = ServiceLoader.load(AppRun.class);
        for (AppRun spl:load){
            if(spl.isSupport(APP)){
                Run run = new Run(spl);
                run.run();
            }
        }
    }
}
