package com.hzit.spring.services;

import com.hzit.spring.dao.Usb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    @Autowired
    private Usb UImpl;

    public Computer(){

    }

    public Computer(Usb usb) {
        this.UImpl = usb;
    }

    public Usb getUImpl() {
        return UImpl;
    }

    public void setUImpl(Usb UImpl) {
        this.UImpl = UImpl;
    }

    public void ranTime(){
        UImpl.conn();
    }
}
