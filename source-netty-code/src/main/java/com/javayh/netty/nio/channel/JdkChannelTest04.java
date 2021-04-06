package com.javayh.netty.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class JdkChannelTest04 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("source-netty-code/src/main/resources/01.png");
        FileOutputStream fileOutputStream = new FileOutputStream("source-netty-code/src/main/resources/02.png");
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();
        try(fileInputStream;fileOutputStream){
            destCh.transferFrom(sourceCh,0,sourceCh.size());
        }
    }
}
