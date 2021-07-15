package com.javayh.netty.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-30
 */
public class NioServer {
    public static void main(String[] args) throws IOException {

        //创建一个server
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 创建一个selector
        Selector selector = Selector.open();
        // 绑定端口
        socketChannel.socket().bind(new InetSocketAddress(6666));
        //设置成非阻塞的
        socketChannel.configureBlocking(false);
        //将socket channel 注册到selector上
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //这里等待1s 如果没有事件则返回
            if(selector.select(1000) == 0){
                System.out.println("服务端等待客户端链接....");
                continue;
            }
            //如果返货的>0获取相关的selectionKey的集合
            // 大于0 表示已经获取了相关的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()){
                //获取 key
                SelectionKey key = keyIterator.next();
                //根据 key做相应的处理
                if(key.isAcceptable()){
                    //有客户端来链接
                    //位该客户端生成一个channel
                    SocketChannel accept = socketChannel.accept();
                    accept.configureBlocking(false);
                    //进行注册
                    accept.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //发生读取时间
                if(key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取该channel关联的buffer
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    channel.read(byteBuffer);
                    System.out.println("客户端发送的数据："+new String(byteBuffer.array()));
                }

                keyIterator.remove();
            }
        }

    }
}
