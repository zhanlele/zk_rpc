package com.quanle.core.zk;

/**
 * @author quanle
 * @date 2020/5/8 10:20 PM
 */
public class ZkInfo {
    private String ip;
    private Integer port;
    /**
     * 响应时间
     */
    private Long expireTime;
    /**
     * 上一次响应时间撮
     */
    private Long lastTime;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }
}
