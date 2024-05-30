package com.liu.dao.impl;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("iUserDao3")
//@Scope("singleton")
@Scope("prototype")
public class IUserDaoImpl3 implements IUserDao {
    public IUserDaoImpl3(){
        System.out.println("IUserDaoImpl3构造方法");
    }
    @PostConstruct
    public void init(){
        System.out.println("IUserDaoImpl3.init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("IUserDaoImpl.destory");
    }
    @Override
    public void addUser(User user) {
        System.out.println("IUserDao.addUser");
    }
}
