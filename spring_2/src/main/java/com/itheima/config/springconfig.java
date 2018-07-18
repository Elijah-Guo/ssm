package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration//告诉spring被标记为@Configuration注解的类是spring核心配置
@ComponentScan("com.itheima")//包扫描：扫描此包下的所有注解
@Import(jdbcspringconfig.class)//导入一个外置的核心配置类
public class springconfig {

}
