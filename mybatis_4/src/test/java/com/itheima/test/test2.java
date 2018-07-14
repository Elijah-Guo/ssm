package com.itheima.test;

import com.itheima.Utils.MybatisUtil;
import com.itheima.entity.QueryVO;
import com.itheima.entity.UserInfo;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test2 {


   //多条件------------动态查询----where和if标签的使用
    public void t1(){
        QueryVO queryVO = new QueryVO();
        /*queryVO.setSex("女");
        queryVO.setLikename("陈%");*/   //多个ID查询只能是单独的一条sql语句
        queryVO.setDis(new Integer[]{1,3,5,7,9});
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserInfo> list = mapper.findUsersByParams(queryVO);
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
        }
    }

    @Test
    public void t2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserInfo usersByID = mapper.findUsersByID(1);
        System.out.println(usersByID.toString());
        sqlSession.close();
    }
}
