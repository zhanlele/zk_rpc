package com.quanle.core.zk;

import com.quanle.core.util.ZkConstant;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author quanle
 * @date 2020/5/8 9:39 PM
 */
public class ZkClient {

    public ZkClient() {
    }

    private static CuratorFramework client;

    public static CuratorFramework createSession() {
        if (client == null) {
            RetryPolicy exponentialBackoffRetry = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.builder()
                    .connectString(ZkConstant.connecting_url)
                    .sessionTimeoutMs(50000)
                    .connectionTimeoutMs(30000)
                    .retryPolicy(exponentialBackoffRetry)
                    // 独立的命名空间 /base
                    .namespace("zdyRpc")
                    .build();

            client.start();
            //强制关闭，清除节点
            Runtime.getRuntime().addShutdownHook(new Thread(() -> client.close()));
            System.out.println("会话创建了");
        } else {
            System.out.println("会话已经存在");
        }
        return client;
    }

    public static ZkNodeInfo createNode(String path, String nodeData) throws Exception {
        if (client == null) {
            createSession();
        }
        // 创建节点
        String s = client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT).forPath(path, nodeData.getBytes());

        System.out.println("节点递归创建成功，该节点路径" + s);
        return getNode(path);
    }

    public void deleteNode(String path, ZkInfo zkInfo) throws Exception {
        // 删除节点
        client.delete().deletingChildrenIfNeeded().withVersion(-1).forPath(path);

        System.out.println("删除成功，删除的节点" + path);
    }

    public static ZkNodeInfo updateNode(String path, String newNodeData) throws Exception {
        if (client == null) {
            createSession();
        }
        //修改数据
        client.setData().forPath(path, newNodeData.getBytes());
        return getNode(path);
    }

    public static ZkNodeInfo getNode(String path) throws Exception {

        // 状态信息
        Stat stat = new Stat();
        byte[] bytes = client.getData().storingStatIn(stat).forPath(path);

        return new ZkNodeInfo().setNodeData(new String(bytes)).setStat(stat);
    }

}
