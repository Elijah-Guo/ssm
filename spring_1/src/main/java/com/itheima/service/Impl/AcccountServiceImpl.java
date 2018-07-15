package com.itheima.service.Impl;

import com.itheima.dao.AccountDAO;
import com.itheima.entity.Account;
import com.itheima.service.AccountService;

public class AcccountServiceImpl implements AccountService{



    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO){
        this.accountDAO=accountDAO;
    }


    public int insert(Account account) {
        return accountDAO.insert(account);
    }
}
