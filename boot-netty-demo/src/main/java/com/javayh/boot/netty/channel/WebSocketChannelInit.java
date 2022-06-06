package com.javayh.boot.netty.channel;

import com.javayh.boot.netty.config.NettyConfig;
import com.javayh.boot.netty.handler.WebSocketNettyHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.boot.netty.config → WebSocketChannelInit
 * @since 2022-05-15
 */
@Slf4j
@Component
public class WebSocketChannelInit extends ChannelInitializer {
    /**
     * 自定义
     */
    private final WebSocketNettyHandler nettyHandler;
    /**
     * netty 配置文件
     */
    private final NettyConfig nettyConfig;

    public WebSocketChannelInit(NettyConfig config, WebSocketNettyHandler nettyHandler) {
        this.nettyConfig = config;
        this.nettyHandler = nettyHandler;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                .addLast(new WebSocketNettyHandler())
                // 支持http
                .addLast(new HttpServerCodec())
                // 对大数据流的支持
                .addLast(new ChunkedWriteHandler())
                //post请求分三部分. request line / request header / message body
                // HttpObjectAggregator将多个信息转化成单一的request或者response对象
                .addLast(new HttpObjectAggregator(8000))
                // 将http协议升级为ws协议. websocket的支持
                .addLast(new WebSocketServerProtocolHandler(nettyConfig.getPath()))
                // 自定义处理handler
                .addLast(nettyHandler);
    }
}
