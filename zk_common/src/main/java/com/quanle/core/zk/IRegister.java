package com.quanle.core.zk;

import java.util.List;

/**
 * @author quanle
 * @date 2020/5/9 10:38 PM
 */
public interface IRegister {

    public void register(List<ServiceConfig> configList) throws Exception;

    public void unregister();

    public void getRegisterInfo();
}
