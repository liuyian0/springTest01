package com.liu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao2 {
    //转出
    @Update("update account set money = money - #{money} where id = #{outId}")
    public abstract int outMoney(@Param("outId") int outId,
                                 @Param("money") double money);
    //转入
    @Update("update account set money = money+ #{money} where id = #{inId};")
    public abstract int inMoney(@Param("inId") int inId,
                                @Param("money") double money);
    //记录日志
    @Insert("insert into db_log values(null,#{message})")
    public abstract int insertLog(String message);
}
