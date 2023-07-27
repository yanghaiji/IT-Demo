package com.javayh.netty.socket.peer;

import cn.hutool.json.JSONUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-07-26
 */
public class PeerWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final String USER = "user";
    private final AttributeKey<String> key = AttributeKey.valueOf(USER);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
        // 添加到channelGroup 通道组
        ChannelHandlerPool.channelGroup.remove(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 首次连接是FullHttpRequest，处理参数
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String uri = request.uri();

            ConcurrentMap<String, String> paramMap = getUrlParams(uri);
            System.out.println("接收到的参数是：" + JSONUtil.toJsonStr(paramMap));

            online(paramMap.get("user"), ctx.channel());
            // 如果url包含参数，需要处理
            if (uri.contains("?")) {
                String newUri = uri.substring(0, uri.indexOf("?"));
                request.setUri(newUri);
            }
        } else if (msg instanceof TextWebSocketFrame) {
            // 正常的TEXT消息类型
            TextWebSocketFrame frame = (TextWebSocketFrame) msg;
            System.out.println("read0: " + frame.text());
        }
        super.channelRead(ctx, msg);
    }

    private static ConcurrentMap<String, String> getUrlParams(String url) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        url = url.replace("?", ";");
        if (!url.contains(";")) {
            return map;
        }
        if (url.split(";").length > 0) {
            String[] arr = url.split(";")[1].split("&");
            for (String s : arr) {
                String key = s.split("=")[0];
                String value = s.split("=")[1];
                map.put(key, value);
            }
            return map;

        } else {
            return map;
        }
    }

    /**
     * 上线一个用户
     *
     * @param channel
     * @param userId
     */
    private void online(String userId, Channel channel) {
        // 保存channel通道的附带信息，以用户的uid为标识
        channel.attr(key).set(userId);
        ChannelHandlerPool.channelGroup.add(channel);
    }
}
