package com.liu;

import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IUserServiceTest {
    //业务对象
    private IUserService iUserService;
    @Before
    public void initIUserService(){
        //1.加载配置文件初始化容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.从容器中获取对象
        iUserService = (IUserService) ctx.getBean("iUserService");
    }
    @Test
    public void testIUserService(){
        iUserService.saveUser(new User("zhaosi","123456"));
    }
}
