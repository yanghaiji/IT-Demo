package com.javayh.udp.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class UdpServer {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .handler(new UdpPacketHandler());

            Channel ch = b.bind(8888).sync().channel();
            ch.closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}

class UdpPacketHandler extends ChannelInitializer<DatagramChannel> {
    @Override
    protected void initChannel(DatagramChannel ch) {
        ch.pipeline()
                .addLast(new UdpPacketDecoder())
                .addLast(new UdpPacketProcessHandler());
    }
}

class UdpPacketDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket packet, List<Object> out) {
        ByteBuf content = packet.content();

        if (content.readableBytes() < 10) {
            return; // 不足10字节无法解析
        }

        // 解析帧头
        short frameHeader = content.readShort();
        // 解析总帧数
        short totalFrames = content.readShort();
        // 解析当前帧号
        short currentFrameNumber = content.readShort();
        // 解析数据域长度
        short dataLength = content.readShort();

        if (content.readableBytes() < dataLength + 2) {
            return; // 不足数据域长度+帧尾长度无法解析
        }

        // 解析数据域
        byte[] data = new byte[dataLength];
        content.readBytes(data);

        // 解析帧尾
        short frameFooter = content.readShort();

        UdpPacket udpPacket = new UdpPacket(frameHeader, totalFrames, currentFrameNumber, dataLength, data, frameFooter);
        out.add(udpPacket);
    }
}

class UdpPacketProcessHandler extends SimpleChannelInboundHandler<UdpPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UdpPacket packet) {
        // 处理接收到的数据包
        System.out.println("Received UDP Packet: " + new String(packet.getData(), CharsetUtil.UTF_8));
        System.out.println(packet);
        ctx.writeAndFlush(packet);
    }

}
