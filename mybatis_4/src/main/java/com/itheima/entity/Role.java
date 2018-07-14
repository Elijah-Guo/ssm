package com.itheima.entity;

import java.util.List;

public class Role {
    //根据role的id查询符合条件的用户信息,将用户信息封装到role表中
    private Integer r_id;
    private String r_name;
    private String r_desc;

    private List<UserInfo> userinfo;

    public List<UserInfo> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(List<UserInfo> userinfo) {
        this.userinfo = userinfo;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_desc() {
        return r_desc;
    }

    public void setR_desc(String r_desc) {
        this.r_desc = r_desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_desc='" + r_desc + '\'' +
                '}';
    }
}
