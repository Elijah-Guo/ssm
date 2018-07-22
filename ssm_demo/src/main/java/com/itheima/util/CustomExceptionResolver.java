package com.itheima.util;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         @Nullable Object o,
                                         Exception e) {
        e.printStackTrace();
        // 定义一个自己的异常
        CustomException customException = null;
        if(e instanceof CustomException){
            customException = (CustomException)e;
        }else{
            customException = new CustomException("系统发生其他异常!");
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("message",e.getMessage());
        mv.setViewName("forward:/error.jsp");
        return mv;
    }
}
