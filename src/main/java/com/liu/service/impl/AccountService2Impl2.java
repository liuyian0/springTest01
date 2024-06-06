package com.liu.service.impl;

import com.liu.dao.AccountDao2;
import com.liu.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
/**
 *使用spring提供的api进行事务管理，对转账业务代码进行修改
 *
 *此代码存在问题
 * 1.事务管理代码和业务代码耦合在一起
 * 2.后续还需编写事务代码
 */
@Service
public class AccountService2Impl2 implements AccountService2 {
    @Autowired
    private AccountDao2 accountDao2;
    @Autowired
    private DataSource dataSource;
    @Override
    public void transfer(int outId, int inId, double money) {
        //1.创建事务管理器
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        //1.2 为事务管理器设置与数据相同的数据源
        dstm.setDataSource(dataSource);
        //2.创建事务定义对象：隔离级别/传播特性/超时时间等
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
         */
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
        //3.创建事务状态对象，用于控制事务执行
        TransactionStatus ts = dstm.getTransaction(td);
        try {
            //转出
            accountDao2.outMoney(outId, money);
            //转入
            accountDao2.inMoney(inId, money);
            //成功：事务提交
            dstm.commit(ts);
        } catch (TransactionException e) {
            //e.printStackTrace();
            //失败：回滚
            dstm.rollback(ts);
        }
    }
}
