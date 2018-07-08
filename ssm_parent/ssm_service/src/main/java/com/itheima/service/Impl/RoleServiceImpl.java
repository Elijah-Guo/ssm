package com.itheima.service.Impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {

        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void addPermissionToRole(Long roleId, Long[] ids) {
        //对中间表操作，对中间表操作，对中间表操作
        //删除原来角色的权限关系(避免只有角色已有关系，再次添加为重复添加)
        roleDao.deleteRolePermissionRelation(roleId);
        //添加角色新的权限关系
        if (ids!=null&&ids.length>0){
            for (Long permissionId : ids) {
                roleDao.saveRolePermissionRelation(roleId,permissionId);
            }
        }
    }
}
