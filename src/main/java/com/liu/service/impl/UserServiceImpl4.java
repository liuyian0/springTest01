package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.pojo.User;
import com.liu.service.UserService;

import java.util.Date;

public class UserServiceImpl4 implements UserService {
    private int num;
    private String name;
    private UserDao userDao;
    private Date birthday;

    //类中必须包含有参构造方法
    public UserServiceImpl4(int num, String name, UserDao userDao, Date birthday) {
        this.num = num;
        this.name = name;
        this.userDao = userDao;
        this.birthday = birthday;
    }

    public UserServiceImpl4() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveUser(User user) {
        System.out.println("num:"+num);
        System.out.println("name:"+name);
        System.out.println("birthday:"+birthday);
        userDao.save();
    }

    @Override
    public void save() {
        System.out.println("userService.save");
    }
}
