package com.liu;

import com.liu.config.SpringConfig;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigTest {
    private IUserService iUserService4;
    @Before
    public void initUserService(){
        //1.加载配置文件初始化容器
        ApplicationContext aca = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2.从容器中获取对象
        iUserService4 = (IUserService)aca.getBean("iUserService4");
    }
    @Test
    public void testSpringConfig(){
        User user = new User("zs", "1234");
        iUserService4.saveUser(user);
    }
}
