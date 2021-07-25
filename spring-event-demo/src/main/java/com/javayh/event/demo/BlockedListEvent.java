package com.javayh.event.demo;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
public class BlockedListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlockedListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}