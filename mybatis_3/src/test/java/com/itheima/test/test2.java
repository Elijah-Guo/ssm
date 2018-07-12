package com.itheima.test;

import com.itheima.entity.UserType;
import com.itheima.mapper.UserTypeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test2 {

    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory factory;


    static {
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {                                                  //读取mybatis配置文件
            InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = sqlSessionFactoryBuilder.build(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*String转Date类型*/
    public Date getDateByString(String date){
        Date result=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void t1() {
        SqlSession sqlSession = factory.openSession();
        UserTypeMapper mapper = sqlSession.getMapper(UserTypeMapper.class);
        List<UserType> list = mapper.findAllUserTypes();
        for (UserType userType : list) {
            System.out.println(userType.toString());
        }
        sqlSession.close();
    }
}
