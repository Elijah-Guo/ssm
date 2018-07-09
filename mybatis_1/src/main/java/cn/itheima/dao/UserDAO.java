package cn.itheima.dao;

import cn.itheima.entity.UserInfo;

import java.util.List;

public interface UserDAO {

    public List<UserInfo> findAllUsers()throws Exception;
}
