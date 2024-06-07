package com.liu.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//接口
public interface AccountService2 {
    //声明式事务第三步：配置需要事务支持的切入点
    @Transactional(
            isolation = Isolation.DEFAULT,
            readOnly = false,
            timeout = 10,
            propagation = Propagation.REQUIRED
    )
    //转账业务
    public abstract void transfer(int outId,int inId,double money);

}
