package com.itheima.mapper;

import com.itheima.entity.Account;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@MapperScan
public interface AccountMapper {

    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM ACCOUNT")
    @Results({
            @Result(id = true,property = "id",column = "a_id"),
            @Result(property = "username",column = "a_name"),
            @Result(property = "money",column = "a_money")
    })
    public List<Account> findAllAccounts() throws Exception;

    /**
     * 添加
     * @param account
     * @return
     * @throws Exception
     */

    @Insert("INSERT INTO ACCOUNT (A_NAME,A_MONEY) VALUES (#{username},#{money})")
    @SelectKey(statement = "select last_insert_id()",keyProperty = "id", keyColumn = "A_ID",before = false,resultType = int.class)
    public int insertAccount(Account account)throws Exception;
}
