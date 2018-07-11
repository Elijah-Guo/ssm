package com.itheima.mapper;

import com.itheima.entity.UserType;

import java.util.List;

public interface UserTypeMapper {


    /**
     * 查询全部的用户类型
     * @return
     * @throws RuntimeException
     */
    public List<UserType> findAllUserTypes()throws RuntimeException;



}
