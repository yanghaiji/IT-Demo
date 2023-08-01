package com.javayh.websocket.simp.messaging.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author haji
 */
public class LoggerQueue {
    /**
     * 队列大小
     */
    public static final int QUEUE_MAX_SIZE = 10000;
    private static LoggerQueue alarmMessageQueue = new LoggerQueue();
    /**
     * 阻塞队列
     */
    private BlockingQueue blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LoggerQueue() {
    }

    public static LoggerQueue getInstance() {
        return alarmMessageQueue;
    }

    /**
     * 消息入队
     **/
    public boolean push(LoggerMessage log) {
        //队列满了就抛出异常，不阻塞
        return this.blockingQueue.add(log);
    }

    /**
     * 消息出队
     */
    public LoggerMessage poll() {
        LoggerMessage result = null;
        try {
            result = (LoggerMessage) this.blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}

