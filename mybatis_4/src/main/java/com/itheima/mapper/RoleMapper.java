package com.itheima.mapper;

import com.itheima.entity.Role;

public interface RoleMapper {

    /**
     * 通过role id查询用户信息------多对多查询
     * @param id
     * @return
     * @throws RuntimeException
     */
    public Role findAllByRoleID(Integer id)throws RuntimeException;
}
