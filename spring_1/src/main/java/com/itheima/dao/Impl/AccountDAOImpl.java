package com.itheima.dao.Impl;

import com.itheima.dao.AccountDAO;
import com.itheima.entity.Account;

public class AccountDAOImpl implements AccountDAO {
    public int insert(Account account) throws RuntimeException {
        System.out.println("插入了一条数据");
        return 1;
    }
}
