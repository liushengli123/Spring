package com.annotation.controller;

import com.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.DataSourceTest;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app=new AnnotationConfigApplicationContext(DataSourceTest.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
