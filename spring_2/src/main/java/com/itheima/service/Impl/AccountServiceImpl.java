package com.itheima.service.Impl;

import com.itheima.dao.AccountDAO;
import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired //通过接口类型
    @Qualifier("accountDAO") //通过beanID找
    private AccountDAO accountDAO;

    public void insertAccount(Account account) {
        try {
            accountDAO.insertAccount(account);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败");
        }
    }

    public void updateAccount(Account account) {
        try {
            accountDAO.updateAccount(account);
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }
    }

    public void deleteAccount(Account account) {
        try {
            accountDAO.deleteAccount(account);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    public Account findAccountByID(Integer id) {
        Account account=null;
        try {
            account = accountDAO.findAccountByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> findAccountByPage(Integer PageIndex, Integer PageSize) {
        List<Account> list=null;
        int start=0;
        int end=0;
        start=(PageIndex-1)*PageSize;
        end=PageSize;
        try {
            list = accountDAO.findAccountByPage(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int findAccountByPageCount() {
        int totalcount=0;
        try {
        totalcount = accountDAO.findAccountByPageCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalcount;
    }
}
