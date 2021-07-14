package com.javayh.netty.netty.websocket;

import com.javayh.netty.netty.heartbeat.MyHeartbeatHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-10
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建环境信息
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            ChannelFuture channelFuture = bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))//加入日志处理
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //基于http协议 使用http的编解码器
                            pipeline.addLast(new HttpServerCodec());
                            //以块的方式写
                            pipeline.addLast(new ChunkedWriteHandler());
                            /*
                            * http数据的传输过程中是分段的，HttpObjectAggregator 可以将多个段聚合起来
                            * */
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            /*
                            * websocket 是以桢的方式传递
                            * WebSocketServerProtocolHandler 将http协议升级为ws协议 保持长连接
                            * */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));
                            pipeline.addLast(new MyWsHandler());
                        }
                    })
                    .bind(8888).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
