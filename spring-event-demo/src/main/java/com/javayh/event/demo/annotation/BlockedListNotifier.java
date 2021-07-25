package com.javayh.event.demo.annotation;

import com.javayh.event.demo.BlockedListEvent;
import org.springframework.context.event.EventListener;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
//@Component
public class BlockedListNotifier {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener
    public void processBlockedListEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(event.getSource());
        System.out.println(event.getAddress());
        System.out.println(event.getContent());
    }
}