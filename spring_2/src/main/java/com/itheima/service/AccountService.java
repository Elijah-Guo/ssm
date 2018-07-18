package com.itheima.service;

import com.itheima.entity.Account;

import java.util.List;

public interface AccountService {
    // 6大方法
    public void insertAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccount(Account account);

    public Account findAccountByID(Integer id);

    public List<Account> findAccountByPage(Integer PageIndex, Integer PageSize);

    public int findAccountByPageCount();
}
