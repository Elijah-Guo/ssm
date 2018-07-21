package com.itheima.web;

import com.itheima.entiyt.Account;
import com.itheima.entiyt.UserInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/UserViewAction")
public class UserViewAction {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("执行了控制器");
        return "show";
    }

    @RequestMapping(value = "/method",method = RequestMethod.POST)
    public String method(){
        System.out.println("执行了post方法");
        return "show";
    }
    @RequestMapping(value = "/method",method = RequestMethod.GET)
    public String method1(){
        System.out.println("执行了get方法");
        return "show";
    }

    @RequestMapping("/getparms")
    public String getparms(String username,Integer age){
        System.out.println(username);
        System.out.println(age);
        return "show";
    }

    @RequestMapping("/getparms1")
    public String getparms1(String id, Account account, Integer money){
        System.out.println(id);
        System.out.println(money);
        System.out.println(account.getUser());
        return "show";
    }

    @RequestMapping("/getparms2")
    public String getparms2(UserInfo user){
        System.out.println(user.getUsername());
        System.out.println(user.getAccounts());
        System.out.println(user.getAccountMap());
        return "show";
    }

    @RequestMapping(value = "/login",params = {"isAdmin=1","status","type=admin"})
    public String login(){
        System.out.println("管理员登陆");
        return "show";
    }
    @RequestMapping(value = "/login",params = {"isAdmin=0","status","type=user"})
    public String login2(){
        System.out.println("普通用户登陆");
        return "show";
    }
    @RequestMapping(value = "/login",params = {"isAdmin=0","status","type=VIP"})
    public String login3(){
        System.out.println("VIP登陆");
        return "show";
    }
    /**
     * 属性不对应
     */
    @RequestMapping("/getparms3")
    public String getparms3(@RequestParam(value = "uuname") String username,
                            @RequestParam(value = "uuage") Integer age){
        System.out.println(username);
        System.out.println(age);
        return "show";
    }
    /**
     * 属性写不写都可以传递
     */
    @RequestMapping("/getparms4")
    public String getparms4(@RequestParam(value = "uuname",required = false) String username,
                            @RequestParam(value = "uuage") Integer age){
        System.out.println(username);
        System.out.println(age);
        return "show";
    }

    @RequestMapping("/getparms5")
    public String getparms5(UserInfo user){
        System.out.println(user.getBirthday());
        return "show";
    }

    @RequestMapping("/getparms6")
    public String getparms6(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        return "show";
    }

    /**
     * 标准方法定义
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getparms7")
    public String excute(HttpServletRequest request, HttpServletResponse response){
        //作用：转发和重定向
        System.out.println("执行转发或者重定向");
        return "show";
    }

    @RequestMapping("/getparms8")
    public String getparms7(@RequestHeader(required = false,value = "Accept-Language") String q1,
                            @CookieValue(required = false,value = "JSESSIONID") String q2){
        System.out.println(q1);
        System.out.println(q2);
        return "show";
    }
}
