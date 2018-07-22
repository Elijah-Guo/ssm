package com.itheima.web;

import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/AccountViewAction")
public class AccountViewAction {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/AccountView")
    public ModelAndView findAllAccounts()throws Exception{

        System.out.println("执行目标方法");
        ModelAndView mv = new ModelAndView();

        List<Account> accounts = accountService.findAllAccounts();

        System.out.println(accounts.toString());

        mv.addObject("accounts",accounts);

        mv.setViewName("forward:/index.jsp");

        return mv;
    }
}
