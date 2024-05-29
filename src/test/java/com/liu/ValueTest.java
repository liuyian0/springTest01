package com.liu;

import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValueTest {
    private IUserService iUserService3;
    @Before
    public void initUserService(){
        //1.加载配置文件初始化容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.从容器中获取对象
        iUserService3 = (IUserService) ctx.getBean("iUserService3");
    }
    @Test
    public void testValue(){
        iUserService3.saveUser(new User("zhangsan","1234"));
    }
}
