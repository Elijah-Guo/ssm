package com.itheima.mapper;

import com.itheima.entity.QueryVO;
import com.itheima.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 数据层接口需要添加 更新 删除 按id查询 模糊查询 分页查询功能
 */
public interface UserMapper {


    /**
     * 条件查询类 为了姐如果传入的参数都是多个情况
     * @param queryVO
     * @return
     * @throws RuntimeException
     */
    public List<UserInfo> findUsersByParams(QueryVO queryVO)throws RuntimeException;


    /**
     * 分页集合
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws RuntimeException
     * map.put("start",(pageIndex-1)*pageSize)
     * map.put("end",pageSize)
     */
    public List<UserInfo> findUsersByPage(Map<String,Integer> map)throws RuntimeException;

    /**
     * 总条数用于计算总页数
     * @return
     * @throws RuntimeException
     */
    public int findUsersByPageCount()throws RuntimeException;


    /**
     * 模糊查询
     * @param name
     * @return
     * @throws RuntimeException
     */
    public List<UserInfo> findUsersByLikeName(String name)throws RuntimeException;



    /**
     * 添加
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    public int insertUser(UserInfo userInfo)throws RuntimeException;

    /**
     * 更新
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    public int updateUser(UserInfo userInfo)throws RuntimeException;

    /**
     * 删除
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    public int deleteUser(UserInfo userInfo)throws RuntimeException;


    /**
     * 按ID查询
     * @param id
     * @return
     * @throws RuntimeException
     */
    public UserInfo findUserByID(Integer id)throws RuntimeException;



}
