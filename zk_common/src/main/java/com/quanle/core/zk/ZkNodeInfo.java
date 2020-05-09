package com.quanle.core.zk;

import org.apache.zookeeper.data.Stat;

/**
 * @author quanle
 * @date 2020/5/9 8:01 AM
 */
public class ZkNodeInfo {

    private String nodeData;
    private Stat stat;

    public String getNodeData() {
        return nodeData;
    }

    public ZkNodeInfo setNodeData(String nodeData) {
        this.nodeData = nodeData;
        return this;
    }

    public Stat getStat() {
        return stat;
    }

    public ZkNodeInfo setStat(Stat stat) {
        this.stat = stat;
        return this;
    }
}
