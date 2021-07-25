package com.javayh.event.enterprise.common;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 * 企业级开发封装
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
public class DemoEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source) {
        super(source);
    }

    public void publishEvent(){
        DemoEventPublisher.publishEvent(this);
    }
}