package com.javayh.event.enterprise;


import com.javayh.event.enterprise.common.DemoEvent;

/**
 * <p>
 * 企业级开发封装
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
public class DemoEventSend extends DemoEvent {


    private Long id;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEventSend(Long source) {
        super(source);
        this.id = source;
    }

    public Long getId(){
        return this.id;
    }

}
