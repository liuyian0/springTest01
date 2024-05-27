package com.liu;

import com.liu.pojo.User;
import com.liu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterTest {
    @Test
    public void testPropertySetter(){
        //1.加载指定的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.获取Spring容器中的资源
        UserService userService3 = (UserService) ctx.getBean("userService3");
        //3.调用方法
        userService3.saveUser(new User());
        //num:100
        //name:zhangsan
        //birthday:Mon May 27 17:06:58 CST 2024
        //userDao.save
    }
}
