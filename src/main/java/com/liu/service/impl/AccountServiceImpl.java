package com.liu.service.impl;

import com.liu.dao.AccountDao;
import com.liu.pojo.Account;
import com.liu.service.AccountService;
import com.liu.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount(Account account) {
        //1.获取mybatis的会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.使用会话对象调用方法获取接口代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //3.使用接口对象调用方法
        accountDao.saveAccount(account);
        //4.释放资源
        session.close();
    }
    @Override
    public void updateAccount(Account account) {
        //1.获取mybatis的会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.使用会话对象调用方法获取接口对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //3.使用接口对象调用方法
        accountDao.updateAccount(account);
        //4.释放资源
        session.close();
    }
    @Override
    public void deleteAccount(Integer id) {
        //1.获取mybatis的会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.使用会话对象调用方法获取接口代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //3.使用接口代理对象调用方法
        accountDao.deleteAccountById(id);
        //4.释放资源
        session.close();
    }
    @Override
    public Account findById(Integer id) {
        //1.获取mybatis的会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.使用会话对象调用方法获取接口代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //3.使用接口代理对象调用方法
        Account account = accountDao.findById(id);
        //4.关闭资源
        session.close();
        return account;
    }

    @Override
    public List<Account> findAll() {
        //1.获取mybatis的会话对象
        SqlSession session = SqlSessionUtil.getSession();
        //2.使用会话对象调用方法获取接口代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //3.使用接口代理对象调用方法
        List<Account> list = accountDao.findAll();
        return list;
    }
}
