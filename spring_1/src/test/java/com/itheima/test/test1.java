package com.itheima.test;

import com.itheima.dao.AccountDAO;
import com.itheima.dao.Impl.AccountDAOImpl;
import com.itheima.entity.Account;
import com.itheima.entity.User;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

    private static ClassPathXmlApplicationContext context;
    private static AccountDAO accountDAO1;
    private static AccountService accountService;

    static {
        context = new ClassPathXmlApplicationContext("beans.xml");
        accountDAO1 = context.getBean("accountDAO", AccountDAO.class);
        accountService = context.getBean("accountService", AccountService.class);
    }




    //类与属性的依赖注入问题
    @Test
    public void t4(){
        User user1 = context.getBean("user1", User.class);
        System.out.println(user1);
    }

    //依赖注入
    //类与类之间的依赖注入问题

    @Test
    public void t3(){
        //直接调用dao层的方法，传入参数--可以直接打印
        System.out.println(accountDAO1.insert(new Account()));
        //直接调用service层的方法传入参数,不可以直接打印输出，应该还需要传入一个参数（dao层的对象）
        //而这个参数如果不在beans.xml中让srping整合的话----报空指针异常
        System.out.println(accountService.insert(new Account()));
    }


    //配置单例模式 sorce:singleton     多例模式sorce:prototype
    //基本都是单例模式，spring默认单例模式,只有sqlsession是多例模式

    public void t2(){
        AccountDAO accountDAO1 = context.getBean("accountDAO", AccountDAO.class);
        AccountDAO accountDAO2 = context.getBean("accountDAO", AccountDAO.class);
        AccountDAO accountDAO3 = context.getBean("accountDAO", AccountDAO.class);
        System.out.println(accountDAO1);
        System.out.println(accountDAO2);
        System.out.println(accountDAO3);
    }

    //spring获取实现类对象的方法----解耦合(是一种软耦合)
    public void test1(){
                                         //             beans配置文件的id ，接口的类型
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        System.out.println(accountDAO);
        System.out.println(accountService);
    }
}
