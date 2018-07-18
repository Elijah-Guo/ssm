package com.itheima.utils;


import org.aspectj.lang.JoinPoint;

public class sysLog {


    public void methodBefore(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }
    public void methodReturning(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }
    public void methodafterThrowing(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }

    public void methodafter(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("正在执行"+name+"类");
        System.out.println("正在执行"+joinPoint.getSignature()+"方法");
        System.out.println("方法参数为"+joinPoint.getArgs());
    }

}
