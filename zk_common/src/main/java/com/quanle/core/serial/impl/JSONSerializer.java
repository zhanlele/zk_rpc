package com.quanle.core.serial.impl;

import com.alibaba.fastjson.JSON;
import com.quanle.core.serial.Serializer;

import java.io.IOException;

/**
 * @author quanle
 * @date 2020/5/8 9:10 PM
 */
public class JSONSerializer implements Serializer {

    /**
     * java对象转换为二进制
     *
     * @param object
     * @return
     */
    @Override
    public byte[] serialize(Object object) throws IOException {
        return JSON.toJSONBytes(object);
    }

    /**
     * 二进制转换成java对象
     *
     * @param clazz
     * @param bytes
     * @return
     */
    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException {
        return JSON.parseObject(bytes, clazz);
    }
}
