package com.javayh.websocket.simp.messaging.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haiji
 */
@Slf4j
@Lazy
@Configuration
@EnableWebSocketMessageBroker
public class MyWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final SimpMessagingTemplate messagingTemplate;

    public MyWebSocketConfig(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * 配置WebSocket消息代理端点，即stomp服务端;spring boot自带的webSocket模块提供stomp的服务端
     *
     * @param registry 注册
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    /**
     * 配置消息代理
     *
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 推送日志到/topic/pullLogger
     */
    @PostConstruct
    public void pushLogger() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        LoggerMessage log = LoggerQueue.getInstance().poll();
                        if (log != null) {
                            if (messagingTemplate != null) {
                                //服务端发送
                                messagingTemplate.convertAndSend("/topic/pullLogger", log);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        executorService.submit(runnable);
    }
}
