package com.liu.service.impl;

import com.liu.pojo.User;
import com.liu.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(User user) {
        System.out.println("用户对象："+user);
        System.out.println("保存用户");
    }

    @Override
    public void save() {
        System.out.println("save..");
    }
}
