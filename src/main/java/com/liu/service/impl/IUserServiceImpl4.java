package com.liu.service.impl;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("iUserService4")
public class IUserServiceImpl4 implements IUserService {
    @Value("${num}")
    private int num;
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;

    @Autowired
    private IUserDao iUserDao;
    @Override
    public void saveUser(User user) {
        System.out.println("IUserService.saveUser");
        System.out.println("num = " + num);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        iUserDao.addUser(user);
    }
}
