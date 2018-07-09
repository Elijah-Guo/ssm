package cn.itheima.binge.factory;

import cn.itheima.binge.ann.Select;
import cn.itheima.binge.core.impl.SqlSessionImpl;
import cn.itheima.binge.util.bingeUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAOImplProxyFactory implements InvocationHandler{

    //此方法的三个参数:proxy--代理对象,method---要执行的方法，这里为findAllUsers,args这个方法的参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ResultSet=null;
        //代理对象的方法增强----数据库操作
        //获取这个方法，获取这个方法上的注解，并获取其值---就是已经写好的sql语句
        if (method.isAnnotationPresent(Select.class))//是否有Select这个注解
        {
            //得到这个注解
            Select annotation = method.getAnnotation(Select.class);
            //得到这个注解的值---也就获得sql语句
            String sql = annotation.value();
            //开始获取数据库连接---连接已经有了，直接拿
            Connection conn = SqlSessionImpl.conn;
            //执行
            PreparedStatement ps = conn.prepareStatement(sql);
            //处理结果集
            ResultSet resultSet = ps.executeQuery();
            //接口的返回值需要是List<UserInfo>类型----转数据类型
            //获取到UserInfo转List

            //获取到了method这个方法的全限定名,通过截取，获取他的全限定名，就得到这个类，就能为所欲为
            //java.util.Lsit<cn.itheima.entity.UserInfo>
            String returnType = method.getGenericReturnType().toString();
            //判断是否java.util.Lsit开头
            if (returnType.startsWith(List.class.getName())){
                //截取，替换
                returnType=returnType.replace(List.class.getName(),"");
                //    <cn.itheima.entity.UserInfo>
                //替换尖括号
                returnType=returnType.replace(">","");
                returnType=returnType.replace("<","");
                //cn.itheima.entity.UserInfo
            }
            ResultSet= bingeUtil.getListByResultSet(resultSet,returnType);

        }
        return ResultSet;
    }
}
