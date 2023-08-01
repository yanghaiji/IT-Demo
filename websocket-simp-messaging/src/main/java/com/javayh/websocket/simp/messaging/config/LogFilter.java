package com.javayh.websocket.simp.messaging.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author haiji
 */
@Service
public class LogFilter extends Filter<ILoggingEvent> {

    /**
     * 获取logback的日志，塞入日志队列中
     *
     * @param event
     * @return
     */
    @Override
    public FilterReply decide(ILoggingEvent event) {
        StringBuilder exception = new StringBuilder();
        IThrowableProxy throwableProxy = event.getThrowableProxy();

        if (throwableProxy != null) {
            exception = new StringBuilder("<span class='excehtext'>" + throwableProxy.getClassName() + " " + throwableProxy.getMessage() + "</span></br>");
            for (int i = 0; i < throwableProxy.getStackTraceElementProxyArray().length; i++) {
                exception.append("<span class='excetext'>").append(throwableProxy.getStackTraceElementProxyArray()[i].toString()).append("</span></br>");
            }
        }
        LoggerMessage loggerMessage = new LoggerMessage(
                event.getMessage()
                , DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())),
                event.getThreadName(),
                event.getLoggerName(),
                event.getLevel().levelStr,
                exception.toString(),
                ""
        );
        LoggerQueue.getInstance().push(loggerMessage);
        return FilterReply.ACCEPT;
    }
}
