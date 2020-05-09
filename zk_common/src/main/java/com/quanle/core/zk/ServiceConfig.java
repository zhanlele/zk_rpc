package com.quanle.core.zk;

/**
 * @author quanle
 * @date 2020/5/9 11:34 PM
 */
public class ServiceConfig {
    private Class<?> clazz;

    public Object instance;

    public ServiceConfig(Class<?> clazz, Object instance) {
        this.clazz = clazz;
        this.instance = instance;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }
}
