package cn.itheima.test;

import cn.itheima.binge.core.SqlSession;
import cn.itheima.binge.factory.SqlSessionFactory;
import cn.itheima.binge.factory.SqlsessionFactoryBulider;
import cn.itheima.dao.NoImplUserDAO;
import cn.itheima.dao.impl.UserDAOImpl;
import cn.itheima.entity.UserInfo;
import org.junit.Test;

import java.util.List;

public class test1 {

    @Test
    public void t1(){
        //new 一个接口的实现类
        UserDAOImpl dao = new UserDAOImpl();
        try {
            List<UserInfo> list = dao.findAllUsers();
            for (UserInfo userInfo : list) {
                System.out.println(userInfo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2(){
        //用构建者模式来创建工厂,并设置xml配置方式
        SqlsessionFactoryBulider sqlsessionFactoryBulider = new SqlsessionFactoryBulider();
        SqlSessionFactory buider = sqlsessionFactoryBulider.buider();
        //工厂模式创建实体类
        SqlSession sqlSession = buider.openSession();
        try {
        //代理模式创建实体类的对象(根据对应的接口,创建对应的接口实现类对象)
            NoImplUserDAO userDAO = sqlSession.getDAOImpl(NoImplUserDAO.class);
            //利用实体类的对象调用方法,执行方法,返回一个list
            List<UserInfo> list = userDAO.findAllUsers();
            for (UserInfo user : list) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
