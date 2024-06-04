package com.liu;

import com.liu.pojo.Account;
import com.liu.service.AccountService;
import com.liu.service.impl.AccountServiceImpl3;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class JDKProxyTest {
    @Test
    public void testProxy(){
        //创建对象
        AccountServiceImpl3 accountService3 = new AccountServiceImpl3();
        //类加载器
        ClassLoader classLoader = JDKProxyTest.class.getClassLoader();
        //父接口
        Class[] interfaces = AccountServiceImpl3.class.getInterfaces();
        //处理器
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;//方法执行完后的返回值
                long beginTime = System.currentTimeMillis();//开始时间
                result = method.invoke(accountService3, args);//执行方法
                long endTime = System.currentTimeMillis();//结束时间
                System.out.println("执行时间=" + (endTime - beginTime) + "毫秒");
                return result;
            }
        };
        //使用jdk的Proxy获取代理对象
        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(classLoader, interfaces,handler);
        //使用代理对象调用方法
        List<Account> accountList = accountServiceProxy.findAll();
        //AccountService.findAll
        //执行时间=3008毫秒
    }
}
