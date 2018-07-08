package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

//Alt+enter快速实现该类
public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(Long id);

    void addPermissionToRole(Long roleId, Long[] ids);
}
