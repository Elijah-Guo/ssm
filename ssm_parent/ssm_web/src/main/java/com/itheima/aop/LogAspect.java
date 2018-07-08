package com.itheima.aop;

import com.itheima.domain.SysLog;
import com.itheima.domain.SysUser;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    @After("execution(* com.itheima.controller.*.*(..))")
    public void after(JoinPoint joinPoint){
        SysLog sysLog = new SysLog();
//        private String visitTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String visitTime = sdf.format(new Date());
        sysLog.setVisitTime(visitTime);
//        private String username;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        sysLog.setUsername(username);
//        private String ip;
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);
//        private String method;
        //通过连接点获得
        //获得类名
        Class<?> aClass = joinPoint.getTarget().getClass();
        String className = aClass.getName();
        //获得方法名
        String methodName = joinPoint.getSignature().getName();
        String method=className+"."+methodName;
        sysLog.setMethod(method);

        //调用业务层
        sysLogService.save(sysLog);

    }
}
