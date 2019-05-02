package com.hzit.spring.dao.Impl;

import com.hzit.spring.dao.Usb;
import org.springframework.stereotype.Component;

@Component
public class Mouse implements Usb {
    @Override
    public void conn() {
        System.out.println("鼠标连接上了");
    }
}
