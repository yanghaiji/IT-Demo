package com.javayh.udp.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 帧头：2个字节
 * 总帧数：2个字节
 * 当前帧号：2个字节
 * 数据域长度：2个字节
 * 数据域：可变长度
 * 帧尾：2个字节
 *
 * @author haiji
 */
public class UdpPacket {
    /**
     * 编码帧头
     */
    private final short frameHeader;
    /**
     * 编码总帧数
     */
    private final short totalFrames;
    /**
     * 编码当前帧号
     */
    private final short currentFrameNumber;
    /**
     * 编码数据域长度
     */
    private final short dataLength;
    /**
     * 编码数据域
     */
    private final byte[] data;
    /**
     * 编码帧尾
     */
    private final short frameFooter;

    public UdpPacket(short frameHeader, short totalFrames, short currentFrameNumber, short dataLength, byte[] data, short frameFooter) {
        this.frameHeader = frameHeader;
        this.totalFrames = totalFrames;
        this.currentFrameNumber = currentFrameNumber;
        this.dataLength = dataLength;
        this.data = data;
        this.frameFooter = frameFooter;
    }

    public short getFrameHeader() {
        return frameHeader;
    }

    public short getTotalFrames() {
        return totalFrames;
    }

    public short getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public short getDataLength() {
        return dataLength;
    }

    public byte[] getData() {
        return data;
    }

    public short getFrameFooter() {
        return frameFooter;
    }

    public ByteBuf encode() {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeShort(frameHeader);
        buffer.writeShort(totalFrames);
        buffer.writeShort(currentFrameNumber);
        buffer.writeShort(dataLength);
        buffer.writeBytes(data);
        buffer.writeShort(frameFooter);
        return buffer;
    }
}
