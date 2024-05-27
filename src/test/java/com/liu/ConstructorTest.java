package com.liu;

import com.liu.pojo.User;
import com.liu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorTest {
    @Test
    public void testPropertyConstruct(){
        //1.获取指定的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.获取Spring容器中的资源
        UserService userService4 = (UserService) ctx.getBean("userService4");
        //3.调用方法
        userService4.saveUser(new User());
        //num:100
        //name:zhangsan
        //birthday:Mon May 27 18:27:30 CST 2024
        //userDao.save
    }
}
