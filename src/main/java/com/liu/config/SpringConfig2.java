package com.liu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration//当前类是Spring配置类
@ComponentScan("com.liu")//指定扫描的包
@PropertySource(value = "data.properties")//加载外部资源文件
@Import(MyDataSource.class)//导入MyDataSource类，添加第三方Bean资源（也可以直接在SpringConfig配置类中添加第三方Bean资源SpringConfig3）
public class SpringConfig2 {
}

