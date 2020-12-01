package com.spring.Impl;

import com.spring.UserDao;

public class UserDaoImpl implements UserDao {
//    private UserDao userDao;
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void destroy(){
        System.out.println("this is destroy....");
    }
    public  void init(){
        System.out.println("this is init.....");
    }
    public void test() {
        System.out.println("saving running.....");
    }
}
