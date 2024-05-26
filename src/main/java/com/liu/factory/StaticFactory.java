package com.liu.factory;

import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl2;

//静态工厂类
public class StaticFactory {
    //静态方法：创建UserService类型的对象
    public static UserService getBean(){
        //实例化对象
        UserService userService = new UserServiceImpl2();
        return userService;
    }
}
