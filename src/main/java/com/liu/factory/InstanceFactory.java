package com.liu.factory;

import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl2;

//实例工厂（方法是非静态）
public class InstanceFactory {
    //非静态方法（通过实例对象来调用方法）
    public UserService getBean(){
        //实例化对象
        UserService userService = new UserServiceImpl2(1000);
        return userService;
    }
}
