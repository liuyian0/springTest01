package com.liu.service;

import com.liu.dao.AccountDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceClass {
    @Autowired
    private AccountDao2 accountDao2;
    //转出转入
    @Transactional(
            propagation = Propagation.REQUIRED
    )
    public void inAndOut(int outId,int inId,double money){
        //转出
        accountDao2.outMoney(outId,money);
        //转入
        accountDao2.inMoney(inId, money);
    }
    //日志记录
    @Transactional(
            propagation = Propagation.REQUIRES_NEW//开启新事务
    )
    public void saveLog(){
        accountDao2.insertLog("转账日志");
    }
}
