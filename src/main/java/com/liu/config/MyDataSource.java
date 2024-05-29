package com.liu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MyDataSource {
    @Bean("druidDataSource")//bean的id名（Spring容器中资源的名字）
    public DataSource createDruidDataSource(){
        //1.创建第三方资源对象
        DruidDataSource druidDataSource = new DruidDataSource();
        //2.设置参数
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db1");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");
        return druidDataSource;
    }
}
