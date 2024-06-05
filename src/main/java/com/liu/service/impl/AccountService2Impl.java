package com.liu.service.impl;

import com.liu.dao.AccountDao2;
import com.liu.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService02")
public class AccountService2Impl implements AccountService2 {
    @Autowired
    private AccountDao2 accountDao2;
    @Override
    public void transfer(int outId, int inId, double money) {
        try {
            //转出
            accountDao2.outMoney(outId, money);
            //转入
            accountDao2.inMoney(inId, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
