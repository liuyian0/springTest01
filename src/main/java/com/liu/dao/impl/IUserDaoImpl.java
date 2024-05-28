package com.liu.dao.impl;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import org.springframework.stereotype.Repository;
//dao层持久层，用@Repository
@Repository("iUserDao")
public class IUserDaoImpl implements IUserDao {
    @Override
    public void addUser(User user) {
        System.out.println("IUserDao.addUser");
    }
}
