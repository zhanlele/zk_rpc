package com.quanle.server1;

import com.quanle.core.util.NettyConstant;
import com.quanle.server1.service.impl.UserServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author quanle
 * @date 2020/5/8 9:19 PM
 */
@SpringBootApplication
public class RpcServerBootstrap {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RpcServerBootstrap.class, args);
        UserServiceImpl.startServer(NettyConstant.connecting_ip, NettyConstant.netty_connecting_port1);
    }
}
