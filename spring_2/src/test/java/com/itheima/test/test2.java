package com.itheima.test;

import com.itheima.config.springconfig;
import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {springconfig.class})
public class test2 {

    @Autowired
    private AccountService accountService;


    @Test
    public void t1(){
        Account accountByID = accountService.findAccountByID(7);
        System.out.println(accountByID.toString());
    }
}
