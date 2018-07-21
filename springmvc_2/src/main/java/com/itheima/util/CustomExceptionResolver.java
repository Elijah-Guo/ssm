package com.itheima.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {

        e.printStackTrace();


        CustomException customException=null;

        if (e instanceof CustomException){
            //发生的异常属于自定义异常
            customException=(CustomException) e;
        }else {
            customException = new CustomException("系统发生其他异常");
        }
        //将错误信息输出
        ModelAndView mv = new ModelAndView();

        mv.addObject("message",e.getMessage());
        mv.setViewName("error");

        return mv;
    }
}
