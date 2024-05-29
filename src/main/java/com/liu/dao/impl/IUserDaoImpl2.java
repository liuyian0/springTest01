package com.liu.dao.impl;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository("iUserDao2")
public class IUserDaoImpl2 implements IUserDao {
    @Autowired
    @Qualifier("druidDataSource")//指定bean的名字
    private DataSource dataSource;
    @Override
    public void addUser(User user) {
        System.out.println("IUserDao.addUser");
        try {
            System.out.println("数据库的连接状态："+dataSource.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
