package com.itheima.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration//告诉spring被标记为@Configuration注解的类是spring核心配置
@PropertySource("beans.properties")//装载properties文件
public class jdbcspringconfig {



    @Value("${jdbc.driver}")//获取properties文件的参数值 value值获取格式@value=("${value}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    /*创建对象--->方法--->bean*/
    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(driver);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);
        return source;
    }


    @Bean(name = "queryRunner")//配置在方法上用于把方法返回的对象做成bean name属性设置ID
    public QueryRunner getQueryRunner(){//      此处需要通过方法获取数据源
        QueryRunner queryRunner = new QueryRunner(getDataSource());
        return queryRunner;
    }
}
