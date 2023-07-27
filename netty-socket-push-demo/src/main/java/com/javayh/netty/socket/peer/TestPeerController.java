package com.javayh.netty.socket.peer;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haiji
 */
@RestController
public class TestPeerController {

    @PostMapping("/send")
    public String send2User(@RequestParam(value = "user") String user, @RequestParam(value = "data") String data) {
        List<Channel> channelList = ChannelHandlerPool.getChannelByName(user);
        if (channelList.size() <= 0) {
            return "用户" + user + "不在线！";
        }
        channelList.forEach(channel -> channel.writeAndFlush(new TextWebSocketFrame(data)));
        return "success";
    }

}
