package com.javayh.event.web;

import com.javayh.event.demo.EmailService;
import com.javayh.event.enterprise.DemoEventSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-18
 */
@RestController
public class EventDemoController {

    @Autowired
    EmailService emailService;

    @GetMapping(value = "event")
    public void event(String type){
        emailService.setBlockedList(Arrays.asList("127.0.0.1","localhost"));
        emailService.sendEmail("127.0.0.1","Event Demo");
    }

    @GetMapping(value = "event2")
    public void even2(Long type){
        new DemoEventSend(type).publishEvent();
    }
}
