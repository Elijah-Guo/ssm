package com.itheima.domain;

import java.util.ArrayList;
import java.util.List;

public class Role {

    private Long id;
    private String roleName;
    private String roleDesc;

    //该角色拥有哪些权限
    private List<Permission> permissionList = new ArrayList<>();

    //该角色被哪些用户使用
    private List<SysUser> userList = new ArrayList<>();

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
