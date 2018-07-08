package com.itheima.service.Impl;

import com.itheima.dao.PermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {

        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findByPid(int pid) {
        return permissionDao.findByPid(pid);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findAllNotParent() {
        return permissionDao.findAllNotParent();
    }
}
