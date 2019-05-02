package com.hzit.spring.dao.Impl;

import com.hzit.spring.dao.Usb;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UImpl implements Usb {
    @Value("${name}")
    private String name;
    @Value("${size}")
    private long size;

    public UImpl(){}
    public UImpl(String name, long size) {

        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public void conn() {
        System.out.println("U盘连接上了");
        System.out.println("U盘品牌："+name);
        System.out.println("U盘容量："+size);
    }
}
