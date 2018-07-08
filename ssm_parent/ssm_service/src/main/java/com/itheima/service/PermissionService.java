package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    List<Permission> findByPid(int pid);

    void save(Permission permission);

    List<Permission> findAllNotParent();
}
