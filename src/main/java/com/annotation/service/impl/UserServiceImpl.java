package com.annotation.service.impl;

import com.annotation.dao.UserDao;
import com.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
//    按照类型从容器中寻找对应的bean
    @Autowired
//    @Qualifier("userDao") 按照id标识符从容器中寻找对应的bean
    private UserDao userDao;
//   @Resource（"userDao"）相当于autowired+qualifier的结合

//    使用注解时不需要写set方法
//    public void setUserDao(UserDao userDao){
//        this.userDao=userDao;
//    }
    public void save() {
        userDao.save();
    }
}
