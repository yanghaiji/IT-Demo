package com.javayh.netty.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyTomcatWebsocketApp implements CommandLineRunner {

    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyTomcatWebsocketApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        new Thread(nettyServer).start();
    }
}
