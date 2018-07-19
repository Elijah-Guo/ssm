package com.itheima.service;

import com.itheima.entity.Account;

import java.util.List;

public interface AccountService {


    /**
     * 转账
     * @param from
     * @param to
     * @param money
     */
    public void transfer(String from, String to, Double money);

    /**
     * 添加
     * @param account
     * @return
     * @throws Exception
     */
    public int insertAccount(Account account);


    /**
     * 更新
     * @param account
     * @return
     * @throws Exception
     */
    public int updateAccount(Account account);

    /**
     * 删除
     * @param account
     * @return
     * @throws Exception
     */
    public int deleteAccount(Account account);

    /**
     * 按ID查询
     * @param id
     * @return
     * @throws Exception
     */
    public Account findAccountByID(Integer id);

    /**
     * 按姓名查询
     * @param username
     * @return
     * @throws Exception
     */
    public Account findAccountByName(String username);


    /**
     * 分页查询
     * @param PageNumber
     * @param PageSize
     * @return
     * @throws Exception
     */
    public List<Account> findAccountListByPage(Integer PageNumber, Integer PageSize);

    /**
     * 总条数
     * @return
     * @throws Exception
     */
    public int findAccountListByPageCount();


}
