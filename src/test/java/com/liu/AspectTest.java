package com.liu;

import com.liu.config.SpringConfig0;
import com.liu.pojo.Account;
import com.liu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//测试类
@RunWith(SpringJUnit4ClassRunner.class)//Spring整合junit
@ContextConfiguration(classes = SpringConfig0.class)//加载注解配置类
public class AspectTest {
    @Autowired
    AccountService accountService4;
    @Test
    public void testAspect(){
        List<Account> accountList = accountService4.findAll();
        Account account = accountService4.findById(1);
    }
}
