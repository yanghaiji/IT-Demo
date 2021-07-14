package com.javayh.netty.nio.copy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
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
public class NioServer {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(8001));
        ByteBuffer allocate = ByteBuffer.allocate(1024);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            int read =0;
            while (read !=-1){
                read = socketChannel.read(allocate);
            }
            allocate.rewind();
        }
    }
}
