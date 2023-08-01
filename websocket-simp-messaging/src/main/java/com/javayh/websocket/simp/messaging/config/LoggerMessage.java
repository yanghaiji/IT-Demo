package com.javayh.websocket.simp.messaging.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haiji
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoggerMessage {
    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
    private String exception;
    private Object cause;
}
