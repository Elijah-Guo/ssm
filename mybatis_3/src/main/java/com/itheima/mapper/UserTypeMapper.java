package com.itheima.mapper;

import com.itheima.entity.UserType;

import java.util.List;

public interface UserTypeMapper {


    public List<UserType> findAllUserTypes()throws RuntimeException;
}
