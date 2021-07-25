package com.javayh.event.enterprise;

import com.javayh.event.enterprise.common.DemoEventListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 企业级开发封装
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
@Component
public class DemoSendListener implements DemoEventListener<DemoEventSend> {


    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(DemoEventSend event) {
        System.out.println(event.getId());
    }

}
