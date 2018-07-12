package com.itheima.mapper;

import com.itheima.entity.QueryVO;
import com.itheima.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 多条件查询(条件必须全部实现，不是动态查询)
     * @param queryVO
     * @return
     * @throws RuntimeException
     */
    public List<UserInfo> findUsersByParams(QueryVO queryVO)throws RuntimeException;

    /**
     * 总条数
     * @return
     * @throws RuntimeException
     */
    public int findUsersByPageCount()throws RuntimeException;

    /**
     * 分页集合-----------------------------------重点(小规模数据传输)
     * @param map
     * @return
     * @throws RuntimeException
     * map.put(start,(pageIndex-1)*pageSize)
     * map.put(end,pageSize)
     */
    public List<UserInfo> findUsersByPage(Map<String,Integer> map)throws RuntimeException;

    /**
     * 模糊查找
     * @param name
     * @return
     * @throws RuntimeException
     */
    public List<UserInfo> findUsersByLikeName(String name)throws RuntimeException;

    /**
     * 增加方法
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    public int insertUser(UserInfo userInfo) throws RuntimeException;

    /**
     * 更新方法
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    public int updateUser(UserInfo userInfo) throws RuntimeException;

    /**
     * 删除方法
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    public int deleteUser(UserInfo userInfo) throws RuntimeException;

    /**
     * 条件查询
     * @param id
     * @return
     * @throws RuntimeException
     */
    public UserInfo findUserByID(Integer id) throws RuntimeException;
}
