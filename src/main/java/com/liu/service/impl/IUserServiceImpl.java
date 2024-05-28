package com.liu.service.impl;

import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.stereotype.Component;

@Component("iUserService")
public class IUserServiceImpl implements IUserService {
    @Override
    public void saveUser(User user) {
        System.out.println("IUserService.saveUser()");
    }
}
