package com.javayh.netty.nio.copy.io;

import java.io.DataInputStream;
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
public class IoServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            byte[] bytes = new byte[1024];
            while (true){
                int read = dataInputStream.read(bytes, 0, bytes.length);
                if(-1 == read){
                    break;
                }
            }
        }
    }
}
