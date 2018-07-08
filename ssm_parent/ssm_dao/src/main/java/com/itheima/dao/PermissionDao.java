package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from sys_permission")
    List<Permission> findAll();

    @Select("select * from sys_permission where pid=#{pid}")
    List<Permission> findByPid(int pid);

    @Insert("insert into sys_permission (permissionName,url,pid) values (#{permissionName}, #{url}, #{pid})")
    void save(Permission permission);

    @Select("select p.* from sys_permission p,sys_role_permission rp where p.id=rp.permissionId and rp.roleId=#{rid}")
    List<Permission> findPermissionsByRid(Long rid);

    @Select("select * from sys_permission where pid!=0")
    List<Permission> findAllNotParent();
}
