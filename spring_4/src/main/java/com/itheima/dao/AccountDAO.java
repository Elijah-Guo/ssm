package com.itheima.dao;

import com.itheima.entity.Account;

import java.util.List;

public interface AccountDAO {
    /**
     * 添加
     * @param account
     * @return
     * @throws Exception
     */
    public int insertAccount(Account account)throws Exception;


    /**
     * 更新
     * @param account
     * @return
     * @throws Exception
     */
    public int updateAccount(Account account)throws Exception;

    /**
     * 删除
     * @param account
     * @return
     * @throws Exception
     */
    public int deleteAccount(Account account)throws Exception;

    /**
     * 按ID查询
     * @param id
     * @return
     * @throws Exception
     */
    public Account findAccountByID(Integer id)throws Exception;

    /**
     * 按姓名查询
     * @param username
     * @return
     * @throws Exception
     */
    public Account findAccountByName(String username)throws Exception;


    /**
     * 分页查询
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public List<Account> findAccountListByPage(Integer start, Integer end)throws Exception;

    /**
     * 总条数
     * @return
     * @throws Exception
     */
    public int findAccountListByPageCount()throws Exception;


}
