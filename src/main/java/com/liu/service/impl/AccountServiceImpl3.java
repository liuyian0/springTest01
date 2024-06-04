package com.liu.service.impl;

import com.liu.pojo.Account;
import com.liu.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService3")
public class AccountServiceImpl3 implements AccountService {
    @Override
    public void saveAccount(Account account) {
        System.out.println("AccountService.saveAccount");
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("AccountService.updateAccount");
    }

    @Override
    public void deleteAccount(Integer id) {
        System.out.println("AccountService.deleteAccount");
    }

    @Override
    public Account findById(Integer id) {
        System.out.println("AccountService.findById");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        System.out.println("AccountService.findAll");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
