package com.itheima.test;

import com.itheima.Utils.MybatisUtil;
import com.itheima.entity.UserInfo;
import com.itheima.entity.Account;
import com.itheima.mapper.UserMapper;
import com.itheima.mapper.AccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test5 {


    //一对一查询:一个账户查询一个用户

    public void t1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.findAllAccountByID(3);
        System.out.println(account.toString());
        System.out.println(account.getUserInfo());
        sqlSession.close();
    }

    //一对多查询:一个用户查询多个账户

    @Test
    public void t2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserInfo user = mapper.findUsersByID1(1);
        System.out.println(user.toString());
        List<Account> list = user.getAccounts();
        for (Account account : list) {
            System.out.println(account.toString());
        }
        sqlSession.close();
    }
}
