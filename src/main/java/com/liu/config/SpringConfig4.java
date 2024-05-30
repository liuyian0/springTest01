package com.liu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*
@Configuration
@ComponentScan("com.liu")
@Import(MyBatisConfig.class)
public class SpringConfig4 {
}
*/

//优化Spring整合Mybatis
@Configuration
@ComponentScan("com.liu")
@PropertySource("classpath:db.properties")
@Import(MyBatisConfig.class)
public class SpringConfig4{
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean
    public DataSource getDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}