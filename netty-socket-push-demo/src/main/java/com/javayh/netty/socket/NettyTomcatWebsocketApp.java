package com.javayh.netty.socket;

import com.javayh.netty.socket.broadcast.NettyServer;
import com.javayh.netty.socket.peer.ClientsCheck;
import com.javayh.netty.socket.peer.PeerNettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyTomcatWebsocketApp /*implements CommandLineRunner*/ {

    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(NettyTomcatWebsocketApp.class, args);
        // 客户端检查
        new Thread(new ClientsCheck()).start();
        new PeerNettyServer(9999).start();
    }


//    @Override
//    public void run(String... args) throws Exception {
//        new Thread(nettyServer).start();
////        new Thread(new PeerNettyServer(9999)).start();
//    }
}
