package com.javayh.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * Bio 模型学习
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-25
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        //创建一个 socket链接
        ServerSocket serverSocket = new ServerSocket(6060);
        System.out.println("服务器启动成功");
        while (true){
            // 监听这个链接
            final Socket socket = serverSocket.accept();
            System.out.println("客户端链接成功");
            //创建一个线程池
            ExecutorService executorService = Executors.newCachedThreadPool();

            executorService.execute(()->{
                handler(socket);
            });

        }
    }

    static void handler(Socket socket){

        try (socket) {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println("接受到的消息为:" + new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
