package com.SpringAOP;

import com.jdkAOP.TargitInterface;
import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface{
    public void save() {
        System.out.println("这是一个连接点");
//        int a=1/0;
    }
}
