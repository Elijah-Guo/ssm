package com.itheima.test;

import com.itheima.entity.Account;
import com.itheima.entity.UserInfo;
import com.itheima.mapper.AccountMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class test {

    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory factory;
    private static UserMapper mapper;
    private static AccountMapper  accountMapper;

    static {
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            InputStream config = Resources.getResourceAsStream("SqlMapConfig.xml");
            factory = sqlSessionFactoryBuilder.build(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Date getDateByString(String date){
        Date dd=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dd = null;
        try {
            dd = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dd;
    }

    @Before
    public void init(){
        //before ：所有的测试方法之前都先执行这个方法"
        //两点不好:1 sqlSession全部是为自动提交 2:无法关闭sqlSession
        SqlSession sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
        accountMapper=sqlSession.getMapper(AccountMapper.class);
    }

    //添加测试

    public void t1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("郭奋斗");
        userInfo.setSex("男");
        userInfo.setBirthday(getDateByString("2018-08-08"));
        userInfo.setAddress("北京昌平区");
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insertUser(userInfo);
        if (i>0){
            System.out.println("添加成功,ID："+userInfo.getId());
        }else {
            System.out.println("添加失败");
        }
        sqlSession.close();
    }

    //修改测试

    public void t2(){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserInfo user = mapper.findUserByID(16);
        if (user!=null){
            user.setUsername("大佬");
            user.setBirthday(new Date());
            user.setSex("女");
            int i = mapper.updateUser(user);
            String s = i > 0 ? "更新成功" : "更新失败";
            System.out.println(s);
        }else {
            System.out.println("没有找到");
        }
        sqlSession.close();
    }

    //删除测试

    public void t3(){
        UserInfo userByID = mapper.findUserByID(14);
        if (userByID!=null){
            int i = mapper.deleteUser(userByID);
            String s = i > 0 ? "删除成功" : "删除失败";
            System.out.println(s );
        }
    }
    //模糊查找

    public void t4(){
        List<UserInfo> list = mapper.findUsersByLikename("王%");
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }

    //分页查找

    public void t5(){
        int totalcount = mapper.findUserByPageCount();
        int pageIndex=1;
        int pageSize=6;
        int start=(pageIndex-1)*pageSize;
        int end=pageSize;
        int totalpage=0;
        if (totalcount>0){
            if(totalcount%pageSize==0){
                totalpage=totalcount/pageSize;
            }else {
                totalpage=totalcount/pageSize+1;
            }
            System.out.println("总条数:"+totalcount);
            System.out.println("总页数:"+totalpage);
            System.out.println("当前页:"+pageIndex);
            System.out.println("页容量:"+pageSize);
            List<UserInfo> list = mapper.findUserByPage(start, end);
            for (UserInfo userInfo : list) {
                System.out.println(userInfo);
            }
        }else {
            System.out.println("没有查到任何数据");
        }
    }

    //注解一对一查询

    public void t6(){
        Account account = accountMapper.findAccountByID(4);
        System.out.println(account);
        UserInfo userInfo = account.getUserInfo();
        System.out.println(userInfo);
    }


    //注解一对多查询
    @Test
    public void  t7(){
        UserInfo user = mapper.findUserByIDChaXunAccount(1);
        System.out.println(user);
        List<Account> list = user.getAccounts();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
