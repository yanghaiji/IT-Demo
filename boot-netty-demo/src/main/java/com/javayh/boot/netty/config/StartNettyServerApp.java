package com.javayh.boot.netty.config;

import com.javayh.boot.netty.channel.WebSocketChannelInit;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.boot.netty.comfig → StartNettyServerApp
 * @since 2022-05-15
 */
@Slf4j
@Configuration
public class StartNettyServerApp implements CommandLineRunner, DisposableBean {
    /**
     * netty 配置文件
     */
    private final NettyConfig config;
    /**
     * 通道初始化对象
     */
    private final WebSocketChannelInit webSocketChannelInit;
    /**
     * boos线程组
     */
    private EventLoopGroup boos;

    /**
     * work线程组
     */
    private EventLoopGroup work;

    public StartNettyServerApp(NettyConfig config, WebSocketChannelInit webSocketChannelInit) {
        this.config = config;
        this.webSocketChannelInit = webSocketChannelInit;
    }


    /**
     * 自定义启动方法
     * @param port
     */
    public void start(int port) throws InterruptedException {
        // 设置boos线程组
        boos = new NioEventLoopGroup(1);
        // 设置work线程组
        work = new NioEventLoopGroup();
        // 创建启动助手
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boos,work)
                .channel(NioServerSocketChannel.class)
                //.handler(new LoggingHandler())
                .childHandler(webSocketChannelInit);
        // 绑定ip和端口启动服务端
        ChannelFuture sync = null;
        try {
            // 绑定netty的启动端口
            sync = serverBootstrap.bind(port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            close();
        }
        log.info("netty服务器启动成功 ,端口: {}",port);
        assert sync != null;
        sync.channel().closeFuture().sync();
    }

    /**
     * 容器销毁前关闭线程组
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        close();
    }

    /**
     * 关闭方法
     */
    public void close() {
        if (boos!=null) {
            boos.shutdownGracefully();
        }
        if (work!=null) {
            work.shutdownGracefully();
        }
    }


    @Override
    public void run(String... args) throws Exception {
        start(config.getPort());
    }

}
