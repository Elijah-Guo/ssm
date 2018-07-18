package com.itheima.dao;

import com.itheima.entity.Account;

import java.util.List;

public interface AccountDAO {
    // 6大方法
    public void insertAccount(Account account)throws Exception;

    public void updateAccount(Account account)throws Exception;

    public void deleteAccount(Account account)throws Exception;

    public Account findAccountByID(Integer id)throws Exception;

    public List<Account> findAccountByPage(Integer start, Integer end)throws Exception;

    public int findAccountByPageCount()throws Exception;
}
