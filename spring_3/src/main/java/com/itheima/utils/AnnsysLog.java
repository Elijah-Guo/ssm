package com.itheima.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("AnnsysLog")
@Aspect
public class AnnsysLog {

    @Pointcut("execution(* com.itheima.service..*.*(..))")
    public void pointCut(){

    }


    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }
    @AfterReturning(value = "pointCut()")
    public void methodReturning(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }
    @AfterThrowing(value = "pointCut()")
    public void methodafterThrowing(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }

    @After(value = "pointCut()")
    public void methodafter(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }

}
