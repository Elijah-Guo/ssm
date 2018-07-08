package com.itheima.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class SysUser {


    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;

    //该用户包含了哪些角色
    //roleList如果直接调用这个属性去数据库封装内容，数据库为null的时候会报错
    //new ArrayList<>()数据库返回null时，不会报错，提高稳定性
    private List<Role> roleList=new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
