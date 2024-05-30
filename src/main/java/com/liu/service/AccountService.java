package com.liu.service;

import com.liu.pojo.Account;

import java.util.List;

public interface AccountService {
    /**
     * 添加用户
     * @param account
     */
    public void saveAccount(Account account);

    /**
     * 修改用户
     * @param account
     */
    public void updateAccount(Account account);

    /**
     * 删除用户
     * @param id
     */
    public void deleteAccount(Integer id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    public List<Account> findAll();
}
