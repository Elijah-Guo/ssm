package com.itheima.web;

import com.itheima.entity.Account;
import com.itheima.service.AccountService;
import com.itheima.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/AccountOperateAction")
public class AccountOperateAction {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/AccountOperate")
    public ModelAndView insertAccount(Account account) throws Exception {
        int i = accountService.insertAccount(account);
        System.out.println(i);
        String msg="很遗憾,添加失败";
        if(i>0) {
            msg = "恭喜，添加成功";
        }
            ModelAndView mv = new ModelAndView();
            mv.addObject("msg",msg);
            mv.setViewName("forward:/note.jsp");

        return mv;
    }
}
