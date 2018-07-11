package com.itheima.mapper.impl;

import com.itheima.entity.QueryVO;
import com.itheima.entity.UserInfo;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

public class UserMapperImpl implements UserMapper {


    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public UserMapperImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<UserInfo> findUsersByParams(QueryVO queryVO) throws RuntimeException {
        // 创建方法的返回值
        List<UserInfo> list = null;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        list = session.selectList("findUsersByParams",queryVO);
        // 关闭
        session.close();
        // 返回
        return list;
    }

    public List<UserInfo> findUsersByPage(Map<String, Integer> map) throws RuntimeException {
        // 创建方法的返回值
        List<UserInfo> list = null;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        list = session.selectList("findUsersByPage",map);
        // 关闭
        session.close();
        // 返回
        return list;
    }

    public int findUsersByPageCount() throws RuntimeException {
        // 创建方法的返回值
        int count = 0;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        // 获取数据
        count = session.selectOne("findUsersByPageCount");
        // 关闭
        session.close();
        // 返回
        return count;
    }

    public List<UserInfo> findUsersByLikeName(String name) throws RuntimeException {
        // 创建方法的返回值
        List<UserInfo> list = null;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        list = session.selectList("findUsersByLikeName",name);
        // 关闭
        session.close();
        // 返回
        return list;
    }

    public int insertUser(UserInfo userInfo) throws RuntimeException {
        // 创建方法的返回值
        int count = 0;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        // 执行
        count = session.insert("insertUser",userInfo);
        // 关闭
        session.close();
        return count;
    }

    public int updateUser(UserInfo userInfo) throws RuntimeException {
        // 创建方法的返回值
        int count = 0;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        // 执行
        count = session.insert("updateUser",userInfo);
        // 关闭
        session.close();
        return count;
    }

    public int deleteUser(UserInfo userInfo) throws RuntimeException {
        // 创建方法的返回值
        int count = 0;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        // 执行
        count = session.insert("deleteUser",userInfo);
        // 关闭
        session.close();
        return count;
    }

    public UserInfo findUserByID(Integer id) throws RuntimeException {
        // 创建方法的返回值
        UserInfo userInfo = null;
        // 创建SQL对象
        SqlSession session = sqlSessionFactory.openSession();
        // 执行
        userInfo = session.selectOne("findUserByID",id);
        // 关闭
        session.close();
        // 返回
        return userInfo;
    }
}
