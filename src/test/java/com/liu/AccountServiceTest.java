package com.liu;

import com.liu.config.SpringConfig4;
import com.liu.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AccountServiceTest {
    AccountService accountService2;
    @Before
    public void initUserService(){
        //1.加载配置类初始化容器
        ApplicationContext aca = new AnnotationConfigApplicationContext(SpringConfig4.class);
        //2.从容器中获取对象
        accountService2 = (AccountService) aca.getBean("accountService2");
    }
    @Test
    public void testAccountService(){
        System.out.println(accountService2.findAll());
        System.out.println(accountService2.findById(2));
    }
}
