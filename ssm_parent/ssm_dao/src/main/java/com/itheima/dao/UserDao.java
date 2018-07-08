package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many=@Many(select = "com.itheima.dao.RoleDao.findAllRoleByUid",fetchType = FetchType.LAZY)
            )
    })
    SysUser findUserByUserName(String username);

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Insert("insert into sys_user (username,email,password,phoneNum,status) values (#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);


    @Select("select * from sys_user where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many=@Many(select = "com.itheima.dao.RoleDao.findAllRoleByUid",fetchType = FetchType.LAZY)
            )
    })
    SysUser findById(Long id);

    @Delete("delete from sys_user_role where userId=#{userId}")
    void deleteUserRoleRelation(Long userId);

    @Insert("insert into sys_user_role(userId,roleId) values (#{param1},#{param2})")
    void saveUserRoleRelation(Long userId, Long id);
}
