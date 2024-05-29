package com.liu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration//当前类是Spring配置类
@ComponentScan("com.liu")//指定扫描的包
@PropertySource(value = "data.properties")
public class SpringConfig3 {
    @Bean("druidDataSource")//bean的id名
    public DataSource createDruidDataSource(){
        //1.创建第三方资源对象
        DruidDataSource druidDataSource = new DruidDataSource();
        //2.设置参数
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db1");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");
        //返回对象
        return druidDataSource;
    }
}
