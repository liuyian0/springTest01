package com.liu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountServiceAdvice2 {
    //配置切入点
    @Pointcut("execution(* com.liu.service.impl.AccountServiceImpl4.*(..))")
    public void pt(){
        //切入点配置在无参无返回值的空方法上
    }
    @Around("pt()") //ProcessdingJoinPoint 相当于Method
    public Object aroundMethod(ProceedingJoinPoint pjp){
        Object result = null;//返回结果
        //前置增强
        try {
            System.out.println("开始计时...");
            long beginTime = System.currentTimeMillis();
            //执行原始方法（被增强的原方法）
            result = pjp.proceed();
            //后置增强
            long endTime = System.currentTimeMillis();
            Signature signature = pjp.getSignature();//获取切入点方法
            System.out.println(signature.getName()+"执行时间："+(endTime-beginTime)+"毫秒");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }
        return result;
    }
}
