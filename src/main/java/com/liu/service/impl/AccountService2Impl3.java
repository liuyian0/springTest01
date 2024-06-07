package com.liu.service.impl;

import com.liu.service.AccountService2;
import com.liu.service.AccountServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService2Impl3 implements AccountService2 {
    @Autowired
    private AccountServiceClass accountService02;
    @Override
    @Transactional
    public void transfer(int outId, int inId, double money) {
        try {
            accountService02.inAndOut(outId, inId, money);
        } finally {
            //记录日志
            accountService02.saveLog();
        }
    }
}
