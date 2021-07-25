package com.javayh.event.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
@Component
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(event.getSource());
        System.out.println(event.getAddress());
        System.out.println(event.getContent());
    }


}