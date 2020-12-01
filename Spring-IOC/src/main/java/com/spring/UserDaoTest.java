package com.spring;

import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoTest {
    @Test
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao);
//        System.out.println(userDao1);
    }
}
