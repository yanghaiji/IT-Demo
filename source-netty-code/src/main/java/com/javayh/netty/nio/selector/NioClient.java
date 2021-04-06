package com.javayh.netty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-30
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",6666);
        //链接服务器
        if(!socketChannel.connect(socketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("等待连接......");
            }
        }
        //链接成功发送数据
        String str = "hello Nio";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
        //发送数据
        socketChannel.write(wrap);
        System.in.read();
    }
}
