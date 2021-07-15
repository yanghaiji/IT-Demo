package com.javayh.netty.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-10
 */
public class MyWsHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyWsHandler handlerRemoved 被调用 " + ctx.channel().id().asLongText());
    }

    // 客户端链接就会触发
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //这是唯一的值
        System.out.println("MyWsHandler handlerAdded 被调用 " + ctx.channel().id().asLongText());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext context, TextWebSocketFrame frame) throws Exception {
        System.out.println("服务端收到消息"+ frame.text());

        context.channel().writeAndFlush(new TextWebSocketFrame("服务器的时间"+ LocalDateTime.now() + frame.text()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生"+ cause.getMessage());
        ctx.channel().close();
    }
}
