package com.itheima.mapper;

import com.itheima.entity.Account;
import com.itheima.entity.UserInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {
    //一对一查询  查一个账户 显示与其对应的一个用户信息

    @Select("select * from account where id=#{id}")
    @Results({
            @Result(id = true,column = "ID",property = "id"),
            @Result(column = "MONEY",property = "money"),
            @Result(column = "UID",property = "userInfo",javaType = UserInfo.class,
            one = @One(select ="com.itheima.mapper.UserMapper.findUserByID1",fetchType = FetchType.LAZY)
            )

    })
    public Account findAccountByID(Integer id)throws RuntimeException;



    //根据传过来的uid 查询他下面的所有账户,返回值为账户集合
    @Select("select * from account where uid=#{userid}")
    public List<Account> findAccountByIDforUser(Integer userid)throws RuntimeException;

}
