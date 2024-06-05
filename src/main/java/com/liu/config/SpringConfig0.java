package com.liu.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//配置类
@Configurable
@ComponentScan("com.liu")
@EnableAspectJAutoProxy//开启aop注解支持
public class SpringConfig0 {
}
