package com.liu.service.impl;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("iUserService3")
public class IUserServiceImpl3 implements IUserService {
    @Value("100")
    private int num;//基本类型
    @Value("liuliu")
    private String name;//String类型
    @Value("20")
    private Integer age;//包装类
    @Autowired
    private IUserDao iUserDao;
    @Override
    public void saveUser(User user) {
        System.out.println("IUserService.saveUser");
        System.out.println(num);
        System.out.println(name);
        System.out.println(age);
        iUserDao.addUser(user);
    }
}
