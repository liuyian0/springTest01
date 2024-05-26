package com.liu.service.impl;

import com.liu.pojo.User;
import com.liu.service.UserService;

public class UserServiceImpl2 implements UserService {
    private Integer number;

    public UserServiceImpl2() {
    }

    public UserServiceImpl2(Integer number) {
        this.number = number;
    }

    @Override
    public void saveUser(User user) {
        System.out.println("用户对象："+user);
        System.out.println("保存对象..");
    }

    @Override
    public void save() {
        System.out.println("save...");
    }
}
