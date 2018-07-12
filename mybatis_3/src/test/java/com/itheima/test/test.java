package com.itheima.test;

import com.itheima.entity.UserInfo;
import com.itheima.mapper.UserMapper;
import com.itheima.mapper.impl.UserMapperImpl;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory factory;

    static {
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream config = null;
        try {
            config = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = sqlSessionFactoryBuilder.build(config);
    }

    //date格式转换
    public Date getDateByString(String date){
        Date parse=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }


    public void t1() {
            SqlSession sqlSession = factory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserInfo> list = mapper.findUsersByLikeName("%王%");

            for (UserInfo info : list) {
                System.out.println(info.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    //传统方式测试分页
    @Test
    public void t2(){
        UserMapperImpl mapper = new UserMapperImpl(factory);
        //查询总条数
        int totalcount = mapper.findUsersByPageCount();
        System.out.println("总条数:"+totalcount);
        int pageIndex=1;
        int pageSize=3;
        int totalpage=0;
        //查询总页数
        if (totalcount%pageSize==0){
            totalpage=totalcount/pageSize;
        }else {
            totalpage=totalcount/pageSize+1;
        }
        System.out.println("总页数:"+totalpage);
        //分页查询
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start",(pageIndex-1)*pageSize);
        map.put("end",pageSize);
        List<UserInfo> list = mapper.findUsersByPage(map);
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
        }
    }
}
