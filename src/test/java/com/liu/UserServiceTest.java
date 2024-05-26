package com.liu;

import com.liu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void testStaticFactory(){
        //获取指定的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //获取Spring容器中的资源
        UserService userService1 = (UserService) ctx.getBean("userService1");
        //调用方法
        userService1.save();
    }
    @Test
    public void testInstanceFactory(){
        //获取指定的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //获取Spring容器中的资源
        UserService userService1 = (UserService) ctx.getBean("userService2");
        //调用方法
        userService1.save();
    }
}
