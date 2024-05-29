package com.liu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//纯注解开发
@Configuration //当前类是Spring配置类
@ComponentScan("com.liu")//指定扫描的包
@PropertySource(value = "data.properties")//加载外部资源文件
public class SpringConfig {
}
