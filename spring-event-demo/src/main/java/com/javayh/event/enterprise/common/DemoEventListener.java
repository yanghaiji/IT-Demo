package com.javayh.event.enterprise.common;

import org.springframework.context.ApplicationListener;

/**
 * <p>
 * 企业级开发封装
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
public interface DemoEventListener<E extends DemoEvent> extends ApplicationListener<E> {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    @Override
    void onApplicationEvent(E event);
}
