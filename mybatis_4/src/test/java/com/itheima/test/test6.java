package com.itheima.test;

import com.itheima.Utils.MybatisUtil;
import com.itheima.entity.Role;
import com.itheima.entity.UserInfo;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test6 {


    //role表的rid查询展示user表信息

    public void t1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.findAllByRoleID(1);
        System.out.println(role.toString());
        List<UserInfo> list = role.getUserinfo();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
        }
        sqlSession.close();
    }

    //user表的uid查询展示role表信息
    @Test
    public void t2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserInfo userInfo = mapper.findUsersByID2(1);
        System.out.println(userInfo.toString());
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            System.out.println(role.toString());
        }
        sqlSession.close();
    }
}
