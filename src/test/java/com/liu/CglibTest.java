package com.liu;

import com.liu.pojo.Account;
import com.liu.service.AccountServicecglib;
import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class CglibTest {
    @Test
    public void testCglib(){
        //1.创建被代理类的对象
        AccountServicecglib accountServicecglib = new AccountServicecglib();
        //2.创建代理类对象
        Callback callback = new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object result = null;//方法执行完后的返回值
                long beginTime = System.currentTimeMillis();//开时时间

                result = method.invoke(accountServicecglib, args);//执行方法

                long endTime = System.currentTimeMillis();//结束时间
                System.out.println("执行时间：" + (endTime - beginTime) + "毫秒");

                return result;
            }
        };
        Class type = accountServicecglib.getClass();
        AccountServicecglib proxy = (AccountServicecglib) Enhancer.create(type, callback);
        //3.使用代理类对象调用方法
        List<Account> accountList = proxy.findAll();
        Account account = proxy.findById(1);
    }
}
