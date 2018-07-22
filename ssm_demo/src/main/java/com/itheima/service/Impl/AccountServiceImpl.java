package com.itheima.service.Impl;

import com.itheima.entity.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAllAccounts() throws Exception {
        return accountMapper.findAllAccounts();
    }

    @Override
    public int insertAccount(Account account) throws Exception {
        return accountMapper.insertAccount(account);
    }
}
