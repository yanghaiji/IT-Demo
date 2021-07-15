package com.javayh.netty.nio.copy.io;

import java.io.*;
import java.net.Socket;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-31
 */
public class IoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8000);
        String fileName = "source-netty-code/src/main/resources/01.png";
        InputStream inputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        long readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(bytes))>=0){
            total += readCount;
            dataOutputStream.write(bytes);
        }
        System.out.println(" total="+total);
        System.out.println(System.currentTimeMillis() -startTime);
        inputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
