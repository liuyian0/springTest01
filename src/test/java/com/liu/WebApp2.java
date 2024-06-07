package com.liu;

import com.liu.config.SpringConfig4;
import com.liu.service.AccountService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig4.class)
public class WebApp2 {
    @Autowired
    private AccountService2 accountService02;
    @Test
    public void testWebApp(){
        accountService02.transfer(1,2,500);
    }
}
