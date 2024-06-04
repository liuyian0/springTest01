package com.liu;

import com.liu.config.SpringConfig;
import com.liu.pojo.Account;
import com.liu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Spring整合junit
@RunWith(SpringJUnit4ClassRunner.class)//SpringJUnit4ClassRunner代替junit原生执行器
@ContextConfiguration(classes = SpringConfig.class)//加载注解配置类
public class SpringJunitTest {
    @Autowired
    AccountService accountService;
    @Test
    public void testFindAccountById(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }
}
