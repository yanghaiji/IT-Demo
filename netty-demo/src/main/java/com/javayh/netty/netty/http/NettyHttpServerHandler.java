package com.javayh.netty.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-06
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpRequest) {
            System.out.println("客户端地址：" + context.channel().remoteAddress());
            //回复信息给浏览器
            ByteBuf byteBuf = Unpooled.copiedBuffer("Hello Netty Http", CharsetUtil.UTF_8);
            //构建一个http响应
            DefaultFullHttpResponse response =
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
            //返回
            context.writeAndFlush(response);
        }
    }
}
