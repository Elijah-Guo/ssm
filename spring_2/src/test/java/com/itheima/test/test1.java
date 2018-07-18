package com.itheima.test;

import com.itheima.config.springconfig;
import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class test1 {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(springconfig.class);
    AccountService accountService = context.getBean("accountService", AccountService.class);

    @Test
    public void t5(){
        Account accountByID = accountService.findAccountByID(18);
        if (accountByID!=null){
            accountService.deleteAccount(accountByID);
        }
    }
    public void t4(){
        Account accountByID = accountService.findAccountByID(18);
        if (accountByID!=null){
            accountByID.setUsername("斌哥无敌");
            accountByID.setMoney(99996666D);
            accountService.updateAccount(accountByID);
        }
    }
    public void t3(){
        Account account = new Account();
        account.setUsername("齐天大圣");
        account.setMoney(999999D);
        accountService.insertAccount(account);
    }
    public void t2(){
        int totalcount = accountService.findAccountByPageCount();
        if (totalcount!=0){
            int PageIndex=1;
            int PageSize=6;
            int totalpage=0;
            totalpage=totalcount%PageSize==0?totalcount/PageSize:totalcount/PageSize+1;
            System.out.println("当前页:"+PageIndex+"页容量:"+PageSize+"总条数:"+totalcount+"总页数:"+totalpage);
            List<Account> list = accountService.findAccountByPage(PageIndex, PageSize);
            for (Account account : list) {
                System.out.println(PageIndex+"页数据:"+account);
            }
        }
    }

    @Test
    public void t1(){
        Account accountByID = accountService.findAccountByID(6);
        System.out.println(accountByID);
    }
}
