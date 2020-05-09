package com.quanle.server2;

import com.quanle.core.util.NettyConstant;
import com.quanle.core.zk.ServiceConfig;
import com.quanle.core.zk.ZkRegister;
import com.quanle.server2.service.AnnotationService;
import com.quanle.server2.service.impl.UserServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author quanle
 * @date 2020/5/8 9:28 PM
 */
@SpringBootApplication
public class RpcServerBootstrap {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RpcServerBootstrap.class, args);
        //注册zk
        List<ServiceConfig> serviceByAnnotation = AnnotationService.getServiceByAnnotation();
        ZkRegister zkRegister = new ZkRegister();
        zkRegister.register(serviceByAnnotation);
        //启动netty
        UserServiceImpl.startServer(NettyConstant.connecting_ip, NettyConstant.netty_connecting_port2);
    }
}
