package com.quanle.server2.service.impl;

import com.quanle.core.code.RpcDecoder;
import com.quanle.core.rpc.RpcRequest;
import com.quanle.core.serial.impl.JSONSerializer;
import com.quanle.core.service.IUserService;
import com.quanle.server2.handler.UserServerHandler;

import org.springframework.stereotype.Service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author quanle
 * @date 2020/5/8 9:29 PM
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public String sayHello(String word) {
        System.out.println("调用成功--参数 " + word);
        return "调用成功--参数 " + word;
    }

    public static void startServer(String hostName, int port) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new RpcDecoder(RpcRequest.class, new JSONSerializer()));
                        pipeline.addLast(new UserServerHandler());
                    }
                });
        serverBootstrap.bind(hostName, port).sync();
        System.out.println("netty服务启动，端口为：" + port);
    }
}
