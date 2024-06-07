package com.liu.config;

/*@Configuration
@ComponentScan("com.liu")
@Import(MyBatisConfig.class)
public class SpringConfig4 {
}*/

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//优化Spring整合Mybatis
@Configurable
@ComponentScan("com.liu")
@PropertySource("classpath:db.properties")
@Import(MyBatisConfig.class)
//声明式事务第一步：开启事务管理支持
@EnableTransactionManagement
public class SpringConfig5 {
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
    //声明式事务第二步：配置事务管理器
    @Bean
    public DataSourceTransactionManager getTxManager(DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }
}