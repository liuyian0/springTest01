package com.liu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

//切面类：事务管理
@Component
@Aspect
public class TransactionAdvice {//事务通知类
    @Autowired
    private DataSource dataSource;
    //切入点
    @Pointcut("execution(* com.liu.service.impl.AccountService2Impl2.transfer(..))")
    public void pt(){
    }
    //环绕通知
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        //1.创建事务管理器
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        //1.2 为事务管理器设置与数据层相同的数据源
        dstm.setDataSource(dataSource);
        //2.创建事务定义对象：隔离级别/传播属性/超时时间等
        DefaultTransactionDefinition td = new DefaultTransactionDefinition();
        /**
           设置事务隔离级别
           0). spring默认隔离级别是跟数据库软件一致 (ISOLATION_DEFAULT)
           1). mysql默认是REPEATABLE_READ
           2). oracle默认是READ_COMMITTED
        */
        td.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        /**
         * 设置是否为只读事务
         * 1). false,表示读写均可(默认设置,适合增删改操作)
         * 2). true,表示只读(适合查,效率高)
         * */
         td.setReadOnly(false);
         /**
         * 设置超时时间
         * 1). 默认值是-1, 表示永不超时
         * 2). 单位是秒
         */
        td.setTimeout(10);
        /**
         * 设置事务传播行为 （这个比较复杂,后续详解）
         * 1. 一般增删改：REQUIRED (默认值)
         * 2. 一般查询  SUPPORTS
         */
        td.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //3.创建事务状态对象
        TransactionStatus ts = dstm.getTransaction(td);
        try {
            //执行原始方式
            result = pjp.proceed();
            //成功：事务提交
            dstm.commit(ts);
        } catch (Throwable e) {
            //e.printStackTrace();
            System.out.println("转账业务异常");
            //失败：事务回滚
            dstm.rollback(ts);
        }
        //返回值
        return result;
    }
}




