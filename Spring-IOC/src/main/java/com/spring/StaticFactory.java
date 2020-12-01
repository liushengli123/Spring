package com.spring;

import com.spring.Impl.UserDaoImpl;

public class StaticFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
