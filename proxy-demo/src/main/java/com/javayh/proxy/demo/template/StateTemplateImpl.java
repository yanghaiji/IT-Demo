package com.javayh.proxy.demo.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-06-21
 */
@Slf4j
public class StateTemplateImpl implements StateTemplate {

    @Override
    public void doGet() {
        log.info("StateTemplateImpl Get");
    }

    @Override
    public void doPost() {
        log.info("StateTemplateImpl Post");
    }
}
