package com.liu.service;

import com.liu.pojo.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService0")
public class AccountServicecglib {
    public Account findById(Integer id){
        System.out.println("AccountServicecglib.findById");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Account> findAll(){
        System.out.println("AccountServicecglib.findAll");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
