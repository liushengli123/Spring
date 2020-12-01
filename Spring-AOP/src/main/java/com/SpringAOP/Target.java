package com.SpringAOP;

import com.jdkAOP.TargitInterface;
import org.springframework.stereotype.Component;

public class Target implements TargetInterface{
    public void save() {
        System.out.println("这是一个连接点");
    }
}
