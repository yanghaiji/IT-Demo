package com.javayh.netty.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-29
 */
public class JdkChannelTest01 {
    public static void main(String[] args) throws IOException {
        String str = "hello nio";
        //创建一个输出流
        FileOutputStream stream = new FileOutputStream("source-netty-code/src/main/resources/file.txt");
        //获取一个文件channel
        FileChannel channel = stream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将数据写入buffer
        byteBuffer.put(str.getBytes());
        //谢欢buffer的模式
        byteBuffer.flip();
        //写入channel
        channel.write(byteBuffer);
        stream.close();
    }
}
