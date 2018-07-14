package com.itheima.mapper;

import com.itheima.entity.Account;

public interface AccountMapper {


    /**
     * 1对1查询,1个账号只有一个用户,将用户表的内容包装到账号表,根据账户表的id查询到这个账号下
     * 包装的与其对应的用户表的内容
     * 账号表是主表,用户表是从表
     * @param id
     * @return
     * @throws RuntimeException
     */
    public Account findAllAccountByID(Integer id)throws RuntimeException;
}
