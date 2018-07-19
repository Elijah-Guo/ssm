package com.itheima.dao.Impl;

import com.itheima.dao.AccountDAO;
import com.itheima.entity.Account;
import com.itheima.entity.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public int insertAccount(Account account) throws Exception {
        String sql="insert into account (a_name,a_money) values (?,?)";
        int i = this.getJdbcTemplate().update(sql, account.getUsername(), account.getMoney());
        return i;
    }

    public int updateAccount(Account account) throws Exception {
        String sql="update account set a_name=?,a_money=? where a_id=?";
        int i = this.getJdbcTemplate().update(sql, account.getUsername(), account.getMoney(), account.getId());
        return i;
    }

    public int deleteAccount(Account account) throws Exception {
        String sql="delete from account where a_id=?";
        int i = this.getJdbcTemplate().update(sql,account.getId());
        return i;
    }

    public Account findAccountByID(Integer id) throws Exception {
        Account account=null;
        String sql="select * from account where a_id=?";//当new AccountMapper()返回一个对象就可以了
        account = this.getJdbcTemplate().queryForObject(sql, new AccountMapper(), id);
        return account;
    }

    public Account findAccountByName(String username) throws Exception {
        Account account=null;
        String sql="select * from account where a_name = ?";
        account = this.getJdbcTemplate().queryForObject(sql, new AccountMapper(), username);
        return account;
    }

    public List<Account> findAccountListByPage(Integer start, Integer end) throws Exception {
        List<Account> list=null;
        String sql="select * from account limit ?,?";//这里返回的是一个list:
        // 每查询一次，便new AccountMapper()一次,最后将他们封装入list集合
        list = this.getJdbcTemplate().query(sql, new AccountMapper(), start, end);
        return list;
    }

    public int findAccountListByPageCount() throws Exception {
        int totalCount=0;
        String sql = "select count(a_id) from account";
        totalCount = this.getJdbcTemplate().queryForObject(sql, int.class);
        return totalCount;
    }
}
