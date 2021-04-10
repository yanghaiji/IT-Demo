package com.javayh.netty.netty.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-06
 */
public class NettyHttpServerInitializer  extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //得到管道
        ChannelPipeline pipeline = channel.pipeline();
        //加入http
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        //增加自定义的handler
        pipeline.addLast("MyNettyHttpServerHandler",new NettyHttpServerHandler());

    }
}
