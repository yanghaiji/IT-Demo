package com.javayh.netty.nio.copy.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-31
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8001));

        FileChannel channel = new FileInputStream("source-netty-code/src/main/resources/01.png").getChannel();
        long time = System.currentTimeMillis();
        long transferTo = channel.transferTo(0, channel.size(), socketChannel);
        System.out.println("发送的总字节数：" +transferTo);
        System.out.println("耗时：" + (System.currentTimeMillis() - time));
        channel.close();
    }
}
