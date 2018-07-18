package com.itheima.dao.Impl;

import com.itheima.dao.AccountDAO;
import com.itheima.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

//@Component代表注解去配置Bean标签，下面有三个衍生物，只是为了区别三层架构各层
@Repository("accountDAO")//不写为 类名小写
@Scope("singleton")//范围：单例模式
public class AccountDAOImpl implements AccountDAO {

    //@Autowired  按类型注入  spring提供
    //@Repository  按ID注入  jdk提供

    @Autowired //自动去装载get/set方法，自动装配
    @Qualifier("queryRunner")
    private QueryRunner queryRunner;

    public void insertAccount(Account account) throws Exception {
        String sql="insert into account (username,money) values (?,?)";
        queryRunner.update(sql,account.getUsername(),account.getMoney());
    }

    public void updateAccount(Account account) throws Exception {
        String sql="update account set username=? ,money=? where id=?";
        queryRunner.update(sql,account.getUsername(),account.getMoney(),account.getId());
    }

    public void deleteAccount(Account account) throws Exception {
        String sql="delete from account where id=?";
        queryRunner.update(sql,account.getId());
    }

    public Account findAccountByID(Integer id) throws Exception {
        Account account=null;
        String sql="select * from account where id=?";
        account = queryRunner.query(sql, new BeanHandler<Account>(Account.class),id);
        return account;
    }

    public List<Account> findAccountByPage(Integer start, Integer end) throws Exception {
        List<Account> list=null;
        String sql="select * from account limit ?,?";
        list = queryRunner.query(sql, new BeanListHandler<Account>(Account.class), start, end);
        return list;
    }

    public int findAccountByPageCount() throws Exception {
        int totalcount=0;
        String sql="select count(id) from account";
        Number num =(Number)queryRunner.query(sql, new ScalarHandler(1));
        totalcount= num.intValue();
        return totalcount;
    }
}
