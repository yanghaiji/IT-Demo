package com.javayh.netty.socket;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haiji
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final WebSocketService webSocketService;

    @Autowired
    public MyWebSocketHandler(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        log.debug("{}开始发送消息", ctx);
        String message = msg.text();
        webSocketService.handleMessage(message);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.debug("服务上线");
        webSocketService.addClient(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.debug("服务下线");
        webSocketService.removeClient(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
