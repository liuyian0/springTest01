package com.liu.service;
//接口
public interface AccountService2 {
    //转账业务
    public abstract void transfer(int outId,int inId,double money);
}
