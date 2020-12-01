package com.annotation.dao.impl;

import com.annotation.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("running....");
    }
}
