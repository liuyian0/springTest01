package com.liu;

import com.liu.pojo.User;
import com.liu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringOuterPropertiesTest {
    @Test
    public void testSpringOuterProperties(){
        //1.加载指定配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.获取Spring容器中的资源
        UserService userService5 = (UserService) ctx.getBean("userService5");
        //3.调用方法
        userService5.saveUser(new User());
        //num:10
        //name:zhangsan
        //birthday:Tue May 28 15:31:47 CST 2024
        //userDao.save
        //其中num和name都是data.properties中的数据，配置文件中要用${}
    }
}
