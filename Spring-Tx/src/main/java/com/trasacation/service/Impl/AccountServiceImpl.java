package com.trasacation.service.Impl;

import com.trasacation.dao.AccountDao;
import com.trasacation.dao.impl.AccountDaoImpl;
import com.trasacation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDaoImpl accountDao;

    @Transactional
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
//        测试事务是否控制
//        int a=1/0;
        accountDao.in(inMan,money);
    }
}
