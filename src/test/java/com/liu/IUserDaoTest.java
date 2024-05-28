package com.liu;

import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IUserDaoTest {
    //业务对象
    private IUserDao iUserDao;

    @Before
    public void initUserService() {
        //1.加载配置文件初始化容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.从容器中获取对象
        iUserDao = (IUserDao) ctx.getBean("iUserDao");
    }
    @Test
    public void testIUserDao(){
        iUserDao.addUser(new User("wangwu","123456"));
    }

}
