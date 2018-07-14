package com.itheima.test;

import com.itheima.Utils.MybatisUtil;
import com.itheima.entity.QueryVO;
import com.itheima.entity.UserInfo;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test4 {



    //修改数据------------set和if标签的使用
    @Test
    public void t1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(13);
        userInfo.setUsername("郭日天");
        userInfo.setSex("女");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(config);
            SqlSession sqlSession = factory.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.updateUser(userInfo);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
