//package com.javayh.netty.netty.heartbeat;
//
//import com.javayh.netty.netty.http.NettyHttpServerHandler;
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
///**
// * <p>
// *
// * </p>
// *
// * @author Dylan
// * @version 1.0.0
// * @since 2021-04-10
// */
//public class MyHeartbeatClient {
//    public static void main(String[] args) throws InterruptedException {
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        //创建环境信息
//        try {
//            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(bossGroup)
//                    .channel(NioSocketChannel.class)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ChannelPipeline pipeline = ch.pipeline();
//                            pipeline.addLast(new NettyHttpServerHandler());
//                        }
//                    });
//            bootstrap.connect("localhost", 8888).sync();
//        } finally {
//            bossGroup.shutdownGracefully();
//        }
//    }
//}
