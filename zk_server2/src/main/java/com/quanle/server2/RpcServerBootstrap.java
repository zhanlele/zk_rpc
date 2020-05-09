package com.quanle.server2;

import com.quanle.core.util.NettyConstant;
import com.quanle.core.zk.ZkClient;
import com.quanle.server2.service.impl.UserServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author quanle
 * @date 2020/5/8 9:28 PM
 */
@SpringBootApplication
public class RpcServerBootstrap {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RpcServerBootstrap.class, args);
        //注册zk
        ZkClient zkClient = new ZkClient();
        zkClient.createSession();
        zkClient.createNode();
        //启动netty
        UserServiceImpl.startServer(NettyConstant.connecting_ip, NettyConstant.netty_connecting_port2);
    }
}
