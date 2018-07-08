package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {


    @Select("select * from sys_role")
    List<Role> findAll();

    @Insert("insert into sys_role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select r.* from sys_role r,sys_user_role ur where r.id=ur.roleId and ur.userId=#{uid}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(
                    property = "permissionList",
                    column ="id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionsByRid",fetchType = FetchType.LAZY)
            )
    })
    List<Role> findAllRoleByUid(Long uid);

    @Select("select * from sys_role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(
                    property = "permissionList",
                    column ="id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionsByRid",fetchType = FetchType.EAGER)
            )
    })
    Role findById(Long id);

    @Delete("delete from sys_role_permission where roleId=#{roleId}")
    void deleteRolePermissionRelation(Long roleId);

    @Insert("insert into sys_role_permission (roleId,permissionId) values (#{param1},#{param2})")
    void saveRolePermissionRelation(Long roleId, Long permissionId);
}
