package cn.itheima.binge.core.impl;

import cn.itheima.binge.core.SqlSession;
import cn.itheima.binge.factory.DAOImplProxyFactory;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlSessionImpl implements SqlSession {
    //将连接数据库的任务也交给这个实现类

    //这里不把数据写死，万一以后不用同一家的数据库呢，账号密码不一样呢？---提高扩展性
    //这里有个问题，不写死的话，写到哪里？----写到xml配置文件中
    private String driver;
    private String url;
    private String username;
    private String password;

    //这里只提供set方法，因为用不到get方法，尽量用不到的方法不要写


    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //设置为静态方法，便于调用
    public static Connection conn;

    //目的:第一创建某个接口的对象,第二实现接口中的方法
    public <T> T getDAOImpl(Class clz) throws Exception {
        //数据库的连接获取工作，写在这里是当接口的实现类执行getDAOImpl这个方法的时候，才会去建立连接
        //而这个时候去建立连接的好处:之后代理对象对其实现类方法增强的时候，不再需要再次创建连接
        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);


        //利用代理模式：即实现创建接口对象，又实现接口中的方法
        //方法中有三个参数1:被代理对象的类 2：被代理对象实现的接口(数组，可实现多接口)3:能够获取实现类中的方法，并增强方法
        //前两个参数都是能够获得类对象，第三个参数则能 对实现类中的方法进行增强(增加一些功能,比如数据库查询)
        return (T)Proxy.newProxyInstance(clz.getClassLoader(),new Class[]{clz},new DAOImplProxyFactory());
        //       Proxy---代理类  newProxyInstance---代理类的对象
    }
}
