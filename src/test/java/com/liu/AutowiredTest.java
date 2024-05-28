package com.liu;

import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredTest {
    private IUserService iUserService2;
    @Before
    public void initUserService(){
        //1.加载配置文件初始化容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.从容器中获取对象
         iUserService2 = (IUserService) ctx.getBean("iUserService2");
    }
    @Test
    public void testIUserServiceTest(){
        User user = new User("zhangsan", "12345");
        iUserService2.saveUser(user);
        //IUserService.saveUser
        //IUserDao.addUser
    }
}
