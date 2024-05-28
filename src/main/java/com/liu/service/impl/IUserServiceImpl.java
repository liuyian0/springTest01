package com.liu.service.impl;

import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("iUserService")
//业务层注解使用@Service
@Service("iUserService")
public class IUserServiceImpl implements IUserService {
    @Override
    public void saveUser(User user) {
        System.out.println("IUserService.saveUser()");
    }
}
