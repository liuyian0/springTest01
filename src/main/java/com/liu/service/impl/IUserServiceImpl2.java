package com.liu.service.impl;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("iUserService2")
public class IUserServiceImpl2 implements IUserService {
    /*使用@Autowired向业务类中注入dao对象
    @Autowired
    private IUserDao iUserDao;*/
    //使用@Autowired+@Qualifier向业务类中注入dao对象
    @Autowired
    @Qualifier("iUserDao")
    private IUserDao iUserDao;
    @Override
    public void saveUser(User user) {
        System.out.println("IUserService.saveUser");
        //调用IUserDao的方法
        iUserDao.addUser(user);
    }
}
