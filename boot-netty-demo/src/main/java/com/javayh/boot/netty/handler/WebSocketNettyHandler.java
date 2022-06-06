package com.javayh.boot.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.boot.netty.handler → WebSocketNettyHandler
 * @since 2022-05-15
 */
@Component
@Slf4j
public class WebSocketNettyHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    /**
     * 存储当前连接上的通道
     */
    List<ChannelHandlerContext> LIST = new CopyOnWriteArrayList<>();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame text) throws Exception {

        log.info("client send msg :{}", text.text());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("client 断开链接...");
        LIST.remove(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("当前在线人数: {}",LIST.size());
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("client 建立链接...");
        LIST.add(ctx);
    }
}
