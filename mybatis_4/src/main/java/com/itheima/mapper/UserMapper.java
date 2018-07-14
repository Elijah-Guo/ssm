package com.itheima.mapper;

import com.itheima.entity.QueryVO;
import com.itheima.entity.Role;
import com.itheima.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 多条件查询
     * @return
     * @throws RuntimeException
     */
    public List<UserInfo> findUsersByParams(QueryVO queryVO)throws RuntimeException;


    public int updateUser(UserInfo userInfo)throws RuntimeException;

    /**
     * 单条件查询
     * @return
     */
    public UserInfo findUsersByID(Integer id)throws RuntimeException;


    /**
     * 一对多查询:一个用户查询多个账号
     * @param id
     * @return
     * @throws RuntimeException
     */
    public UserInfo findUsersByID1(Integer id)throws RuntimeException;


    /**
     * 多表查询--->
     * 通过一个用户id,查询出用户的所有信息和与之关联的所有role表的信息
     * @param id
     * @return
     * @throws RuntimeException
     */
    public UserInfo findUsersByID2(Integer id)throws RuntimeException;


    /**
     * 分页查询
     * @param map
     * @return
     * @throws RuntimeException
     */
    public UserInfo findUserPage(Map<String,Integer> map)throws RuntimeException;

}
