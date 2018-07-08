package com.itheima.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/showUsername")
    @ResponseBody
    public String findUsername(HttpServletRequest request){

        //两种方法获取
        //1:当前线程
        //SecurityContext context = SecurityContextHolder.getContext();
        //2:session
        SecurityContext context = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        //获取认证对象
        Authentication authentication = context.getAuthentication();
        //获取主角对象
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        String password = principal.getPassword();
        System.out.println(username);
        System.out.println(password);

        return username;
    }
}
