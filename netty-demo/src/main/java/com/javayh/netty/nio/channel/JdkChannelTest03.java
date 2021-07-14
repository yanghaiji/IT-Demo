package com.javayh.netty.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * 拷贝文件
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-29
 */
public class JdkChannelTest03 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("source-netty-code/src/main/resources/file.txt");
        FileChannel channelInt = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("source-netty-code/src/main/resources/file02.txt");
        FileChannel channelOut = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try(inputStream;outputStream){
            while (true){
                //重置一个标志位 这里不重置将一直循环读取下去
                byteBuffer.clear();
                int read = channelInt.read(byteBuffer);
                if(read == -1){
                    break;
                }
                byteBuffer.flip();
                channelOut.write(byteBuffer);
            }
        }
    }
}
