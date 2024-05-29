package com.liu;

import com.liu.config.SpringConfig;
import com.liu.dao.IUserDao;
import com.liu.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyDataSourceTest {
    private IUserDao iUserDao2;

    @Before
    public void initUserService() {
        //1.加载配置类初始化容器
        ApplicationContext aca = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2.从容器中获取对象
        iUserDao2 = (IUserDao) aca.getBean("iUserDao2");
    }

    @Test
    public void testMyDataSource() {
        User user = new User("zj", "1234");
        iUserDao2.addUser(user);
        //IUserDao.addUser
        //数据库的连接状态：false
    }
}
