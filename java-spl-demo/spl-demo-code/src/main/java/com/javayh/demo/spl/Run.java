package com.javayh.demo.spl;

import com.javayh.app.spl.AppRun;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-07
 */
public class Run {

    private final AppRun appRun;

    public Run(AppRun appRun) {
        this.appRun = appRun;
    }

    public void run(){
        appRun.start();
        appRun.stop();
        appRun.destroy();
    }
}
