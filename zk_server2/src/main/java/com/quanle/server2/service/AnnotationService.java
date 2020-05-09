package com.quanle.server2.service;

import com.quanle.core.util.ClassUtils;
import com.quanle.core.zk.ServiceConfig;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quanle
 * @date 2020/5/9 11:37 PM
 */
public class AnnotationService {

    public static List<ServiceConfig> getServiceByAnnotation() throws Exception {
        List<Class<?>> clazzs = ClassUtils.getClassByAnnotation(Service.class, "com.quanle");
        if (!clazzs.isEmpty()) {
            List<ServiceConfig> serviceConfigList = new ArrayList<>(clazzs.size());
            for (Class<?> clazz : clazzs) {
                Object obj = clazz.getDeclaredConstructor().newInstance();
                ServiceConfig serviceConfig = new ServiceConfig(clazz.getInterfaces()[0], obj);
                serviceConfigList.add(serviceConfig);
            }
            return serviceConfigList;
        }
        return null;
    }
}
