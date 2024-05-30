package com.liu.dao;

import com.liu.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao{
    @Insert("insert into account(name,money)values (#{name},#{money})")
    void saveAccount(Account account);

    @Update("update account set name=#{name},money=#{money} where id=@{id}")
    void updateAccount(Account account);

    @Delete("delete from account where id=#{id}")
    void deleteAccountById(Integer id);

    @Select({"Select * from account where id=#{id}"})
    Account findById(Integer id);

    @Select("select * from account")
    List<Account> findAll();
}
