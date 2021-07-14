package com.javayh.netty.nio.channel;

import java.io.File;
import java.io.FileInputStream;
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
public class JdkChannelTest02 {
    public static void main(String[] args) throws IOException {
        File file = new File("source-netty-code/src/main/resources/file.txt");
        //创建输入流
        FileInputStream inputStream = new FileInputStream(file);
        //获取channel
        FileChannel channel = inputStream.getChannel();
        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(Math.toIntExact(file.length()));
        // 将通道的数据读取到buffer
        int read = channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        inputStream.close();

    }
}
