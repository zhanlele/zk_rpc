package com.quanle.core.zk;

import com.google.common.collect.Lists;
import com.quanle.core.util.NettyConstant;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

import java.net.InetAddress;
import java.util.List;

/**
 * @author quanle
 * @date 2020/5/9 10:45 PM
 */
public class ZkRegister implements IRegister {

    @Override
    public void register(List<ServiceConfig> configs) throws Exception {
        //连接zk
        CuratorFramework client = ZkClient.createSession();
        //获取path
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        String path = ip + NettyConstant.netty_connecting_port2;
        //获取zk节点数据
        ZkNodeInfo nodeInfo = ZkClient.getNode(path);
        String nodeData = nodeInfo.getNodeData();
        Stat stat = nodeInfo.getStat();
        List<String> datas = Lists.newArrayList();
        //如果节点为空，则说明还没有注册，否则要将内容修改并重新注册
        if(StringUtils.isEmpty(nodeData)){
        }else {

        }
    }

    @Override
    public void unregister() {

    }

    @Override
    public void getRegisterInfo() {

    }
}
