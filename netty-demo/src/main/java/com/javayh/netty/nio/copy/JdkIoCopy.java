package com.javayh.netty.nio.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
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
public class JdkIoCopy {
    public static void main(String[] args) throws IOException {
        File file = new File("source-netty-code/src/main/resources/file.txt");
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        byte[] bytes = new byte[Math.toIntExact(file.length())];
        accessFile.read(bytes);
        Socket socket = new ServerSocket(8080).accept();
        socket.getOutputStream().write(bytes);
    }
}
