package com.itheima.test;

import com.itheima.entity.Grade;
import com.itheima.entity.UserInfo;
import com.itheima.entity.UserType;
import com.itheima.mapper.GradeMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.mapper.UserTypeMapper;
import com.itheima.mapper.impl.UserMapperImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2Test2 {


    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;

    static {
        try {
            InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
            // InputStream config = M2Test.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
            builder = new SqlSessionFactoryBuilder();
            factory = builder.build(config);
        } catch (Exception e) {
            System.out.println("找不到配置文件");
            e.printStackTrace();
        }

    }

    public Date getDateByString(String date){
        Date result = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            result = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }



    @Test
    public void test4(){
        // 班级查询总条数测试
        SqlSession session = factory.openSession(true);
        GradeMapper mapper = session.getMapper(GradeMapper.class);
        int totalCount = mapper.findGradeListByPageCount();
        System.out.println(totalCount);
        session.close(); // 很重要哦!!!!!!!
        // connection get time out 404
    }


    public void test3(){
        // 班级添加测试
        SqlSession session = factory.openSession(true);
        Grade g = new Grade();
        g.setGname("黑马318");
        g.setGdesc("JavaEE");
        GradeMapper mapper = session.getMapper(GradeMapper.class);
        int count = mapper.insertGrade(g);
        if(count > 0){
            System.out.println("添加成功,ID为" + g.getGid());
        }else{
            System.out.println("添加失败");
        }
    }


    public void test2(){
        SqlSession sqlSession = factory.openSession();
        UserTypeMapper mapper = sqlSession.getMapper(UserTypeMapper.class);
        List<UserType> list = mapper.findAllUserTypes();
        for (UserType userType : list) {
            System.out.println(userType.toString());
        }
    }


    public void test1(){

        // 测试分页
        UserMapper userMapper = new UserMapperImpl(factory);
        // 1. 获取总条数
        int totalCount = userMapper.findUsersByPageCount();
        if(totalCount > 0){
            System.out.println("总条数"+totalCount);
            int pageIndex = 2; // 第一页 页码
            int pageSize = 3; // 每页展示3条 页容量
            // 总页数
            int totalPage = totalCount%pageSize==0?totalCount/pageSize:
                    totalCount/pageSize + 1;

            System.out.println("总页数" + totalPage);
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("start",(pageIndex-1)*pageSize);
            map.put("end",pageSize);
            /*
            * 1 2 3 1*3
            * 4 5 6 2*3 (2-1)*3+1
            * 7 8 9 3*3
            * 8888
            * */
            List<UserInfo> list = userMapper.findUsersByPage(map);
            for (UserInfo userInfo : list) {
                System.out.println(userInfo.toString());
            }




        }else{
            System.out.println("没有查询到数据");
        }

    }





}
