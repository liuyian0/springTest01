package com.liu.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面类
@Component//当前bean需要加载到ioc容器中
@Aspect//切面类（切入点+通知）
public class AccountServiceAdvice {
    //配置切入点  切入点表达式=com.liu.service.impl.AccountServiceImpl4类中所有方法
    @Pointcut("execution(* com.liu.service.impl.AccountServiceImpl4.*(..))")
    public void pt(){
        //切入点配置在无参无返回值的空方法上
    }
    long beginTime;//开始时间
    long endTime;//终止时间
    //配置通知
    @Before("pt()")//前置通知，在目标方法执行前运行
    public void beginTime(){
        System.out.println("开始计时...");
        beginTime = System.currentTimeMillis();
    }
    @AfterReturning("pt()")//后置通知，在目标方法执行后运行
    public void endTime(){
        endTime = System.currentTimeMillis();
        System.out.println("执行时间="+(endTime-beginTime)+"毫秒");
    }
}
