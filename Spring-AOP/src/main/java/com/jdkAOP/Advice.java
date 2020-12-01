package com.jdkAOP;

public class Advice {
    public void before(){
        System.out.println("this is before advice");
    }
    public void after(){
        System.out.println("this is after advice");
    }
}
