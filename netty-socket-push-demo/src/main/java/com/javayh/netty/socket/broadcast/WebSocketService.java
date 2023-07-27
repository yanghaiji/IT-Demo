package com.javayh.netty.socket.broadcast;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author haiji
 */
@Slf4j
@Service
public class WebSocketService {

    private final Set<ChannelHandlerContext> clients = new HashSet<>();

    public void addClient(ChannelHandlerContext client) {
        clients.add(client);
    }

    public void removeClient(ChannelHandlerContext client) {
        clients.remove(client);
    }

    public void handleMessage(String message) {
        // 在这里处理收到的消息，例如解析消息内容，更新数据库等
        log.info("当前的消息为:{}", message);
        // 通知所有客户端
        notifyClients(message);
    }


    public void sendDataUpdateNotification(String message) {
        notifyClients(message);
    }

    private void notifyClients(String message) {
        TextWebSocketFrame frame = new TextWebSocketFrame(message + UUID.randomUUID().toString());
        for (ChannelHandlerContext client : clients) {
            client.channel().writeAndFlush(frame);
        }
    }
}
