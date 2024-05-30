package com.liu.config;

import com.liu.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

//Mybatis配置类
public class MyBatisConfig {
    //传统方法：SqlSessionFactoryBuilder -> SqlSessionFactory -> SqlSession -> AccountDao

    //将SqlSessionFactory放入ioc容器中
    @Bean("factory")
    public SqlSessionFactory getFactory() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        return factory;
    }
    //将SqlSession放到ioc容器中
    @Bean //在方法上使用@Bean注解时，方法参数列表中声明的对象会自动从ioc容器中获取
    public SqlSession getSqlSession(SqlSessionFactory factory){
        SqlSession sqlSession = factory.openSession(true);
        return sqlSession;
    }
    //将accountDao放到ioc容器中
    @Bean("accountDao")//自动从ioc容器中获取SqlSession类型的bean对象
    public AccountDao getDao(SqlSession sqlSession){
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        return accountDao;
    }
}
