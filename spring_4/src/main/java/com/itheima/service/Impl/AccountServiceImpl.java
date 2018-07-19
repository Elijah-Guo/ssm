package com.itheima.service.Impl;

import com.itheima.dao.AccountDAO;
import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,isolation = Isolation.DEFAULT,propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //方法上开启事务(xml文件中配置aop事务管理，将此方法内的每个分支事务都归一个总事务管理)
    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(String from, String to, Double money) {
        Account afrom=this.findAccountByName(from);
        Account afto = this.findAccountByName(to);
        afrom.setMoney(afrom.getMoney()-money);
        afto.setMoney(afto.getMoney()+money);
        //持久化保存数据
        updateAccount(afrom);
        int i=1/0;
        //插入一个错误，将导致事务提交失败，但是上一个事务却执行了
        updateAccount(afto);
    }

    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertAccount(Account account) {
        int i=0;
        try {
            i=accountDAO.insertAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int updateAccount(Account account) {
        int i=0;
        try {
            i=accountDAO.updateAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int deleteAccount(Account account) {
        int i=0;
        try {
            i=accountDAO.deleteAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public Account findAccountByID(Integer id) {
        Account account=null;
        try {
            account=accountDAO.findAccountByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account findAccountByName(String username) {
        Account account=null;
        try {
            account=accountDAO.findAccountByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> findAccountListByPage(Integer PageNumber, Integer PageSize) {
        int start=(PageNumber-1)*PageSize;
        int end=PageSize;
        List<Account> list=null;
        if (start>=0&&end>0){
            try {
                list = accountDAO.findAccountListByPage(start, end);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int findAccountListByPageCount() {
        int totalcount=0;
        try {
            totalcount =accountDAO.findAccountListByPageCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalcount;
    }
}
