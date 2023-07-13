package com.javayh.netty.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private WebSocketService webSocketService;

    @GetMapping(value = "/push")
    public void push(String id) {
        webSocketService.sendDataUpdateNotification(id);
    }

}
