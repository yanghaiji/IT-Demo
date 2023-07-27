package com.javayh.netty.socket.peer;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author haiji
 */
public class ChannelHandlerPool {

    public ChannelHandlerPool() {
    }

    public static Set<Channel> channelGroup = Collections.synchronizedSet(new HashSet<>());

    /**
     * 根据用户id查找channel
     *
     * @param name 有户名
     * @return 需要推送的channel
     */
    public static List<Channel> getChannelByName(String name) {
        AttributeKey<String> key = AttributeKey.valueOf("user");
        return ChannelHandlerPool.channelGroup.stream().filter(channel -> channel.attr(key).get().equals(name))
                .collect(Collectors.toList());
    }

}
