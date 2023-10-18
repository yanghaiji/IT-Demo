package com.javayh.udp.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class UdpClient {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .handler(new UdpPacketEncoder())
                    .handler(new UdpClientHandler());

            Channel ch = b.bind(0).sync().channel();

            ch.closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}

class UdpClientHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        short frameHeader = 1;
        short frameFooter = 0;

        String message = "Hello, UDP!";
        byte[] data = message.getBytes(CharsetUtil.UTF_8);
        short dataLength = (short) data.length;

        UdpPacket packet = new UdpPacket(frameHeader, (short) 0, (short) 0, dataLength, data, frameFooter);
        DatagramPacket datagramPacket = new DatagramPacket(packet.encode(), new InetSocketAddress("127.0.0.1", 8888));

        ctx.writeAndFlush(datagramPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        // 处理接收到的数据逻辑
        System.out.println("Received UDP Packet: " + new String(((UdpPacket) msg).getData(), CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        short frameHeader = 1;
        short frameFooter = 0;

        String message = "Hello, UDP!";
        byte[] data = message.getBytes(CharsetUtil.UTF_8);
        short dataLength = (short) data.length;

        UdpPacket packet = new UdpPacket(frameHeader, (short) 0, (short) 0, dataLength, data, frameFooter);
        ctx.writeAndFlush(packet);
    }
}


class UdpPacketEncoder extends MessageToByteEncoder<UdpPacket> {
    @Override
    protected void encode(ChannelHandlerContext ctx, UdpPacket packet, ByteBuf out) throws Exception {
        out.writeShort(packet.getFrameHeader());
        out.writeShort(packet.getTotalFrames());
        out.writeShort(packet.getCurrentFrameNumber());
        out.writeShort(packet.getDataLength());
        out.writeBytes(packet.getData());
        out.writeShort(packet.getFrameFooter());
    }
}
