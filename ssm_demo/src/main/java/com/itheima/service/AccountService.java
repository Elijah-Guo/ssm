package com.itheima.service;

import com.itheima.entity.Account;


import java.util.List;


public interface AccountService {

    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    public List<Account> findAllAccounts() throws Exception;

    /**
     * 添加
     * @param account
     * @return
     * @throws Exception
     */
    public int insertAccount(Account account)throws Exception;
}
