package com.quanle.client;

import com.quanle.client.consumer.RpcConsumer;
import com.quanle.core.service.IUserService;

/**
 * @author quanle
 * @date 2020/5/8 9:12 PM
 */
public class RpcClientBootstrap {

    public static void main(String[] args) throws InterruptedException {
        RpcConsumer rpcConsumer = new RpcConsumer();
        IUserService proxy = (IUserService) rpcConsumer.createProxy(IUserService.class);
        while (true) {
            System.out.println("============>>>>>");
            Thread.sleep(2000);
            proxy.sayHello("are you ok?");
            System.out.println("已响应");
        }
    }
}
