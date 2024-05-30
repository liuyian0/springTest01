package com.liu;

import com.liu.config.SpringConfig;
import com.liu.dao.IUserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitDestoryTest {
    @Test
    public void testInitDestory(){
        //1.加载配置类初始化容器
        ApplicationContext aca = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2.从容器中获取对象
        IUserDao iUserDao301 = (IUserDao) aca.getBean("iUserDao3");
        IUserDao iUserDao302 = (IUserDao) aca.getBean("iUserDao3");

        System.out.println("iUserDao301 = " + iUserDao301);
        System.out.println("iUserDao302 = " + iUserDao302);
        //IUserDaoImpl3构造方法
        //IUserDaoImpl3.init
        //IUserDaoImpl3构造方法
        //IUserDaoImpl3.init
        //iUserDao301 = com.liu.dao.impl.IUserDaoImpl3@7cc0cdad
        //iUserDao302 = com.liu.dao.impl.IUserDaoImpl3@7c7b252e
    }
}
