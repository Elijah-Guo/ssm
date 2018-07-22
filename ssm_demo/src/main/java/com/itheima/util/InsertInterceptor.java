package com.itheima.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertInterceptor implements HandlerInterceptor {

    /**
     * 前置增强 本来要执行的方法之前执行 将参数进行验证
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器3的preHandle执行");
        // boolean --> 是否继续
        String username = request.getParameter("username");
        String money = request.getParameter("money");
        // 判断当前执行的是哪个方法
        String url = request.getRequestURL().toString();
        if(url.indexOf("AccountOperate") > 0){
            // 增删改
            if(StringUtils.isEmpty(username) || StringUtils.isEmpty(money)){
                throw  new CustomException("账户或金额为空,不能添加!");
            }
            //return false; // 执行到完事了
        }
        return true; // 继续往下执行
    }

    /**
     * 后置增强 本来的方法已经执行完了 但是还没有跳转的时候执行 保证你给页面的返回值的正确性
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器3的postHandle执行");
    }

    /**
     * 最终增强 在你目标方法已经跳转的情况下执行 清理资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("拦截器3的afterCompletion");
    }
}
