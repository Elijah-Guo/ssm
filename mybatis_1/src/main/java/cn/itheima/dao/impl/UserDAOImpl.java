package cn.itheima.dao.impl;

import cn.itheima.dao.UserDAO;
import cn.itheima.entity.UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


//老套的jdbc连接数据库过程---------------------------------low
public class UserDAOImpl implements UserDAO {
    //操作数据库
    //定义四大属性
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=UTF-8";
    private String username="root";
    private String password="root";
    public List<UserInfo> findAllUsers() throws Exception {
        //创建方法的返回值
        List<UserInfo> list = new ArrayList<UserInfo>();
        //业务操作
        //加载驱动
        Class.forName(driver);//注册驱动
        Connection conn = DriverManager.getConnection(url, username, password);//获取连接
        //编写sql语句
        String sql="select * from user";
        //执行
        PreparedStatement ps = conn.prepareStatement(sql);
        //处理结果集
        ResultSet set = ps.executeQuery();
        //转数据,将数据库查询到的结果集封装到一个对象中去
        //首先需要一个对象,装入集合中,它写在处理结果集的外面(可以节省栈空间，只需要创建一个引用，便可以指向多个对象)
        UserInfo user=null;
        while (set.next()){
            user = new UserInfo();
            //将数据装入对象
            user.setId(set.getInt("id"));
            user.setUsername(set.getString("username"));
            user.setBirthday(set.getDate("birthday"));
            user.setSex(set.getString("sex"));
            user.setAddress(set.getString("address"));
            list.add(user);
        }
        //关闭资源
        set.close();
        ps.close();
        conn.close();
        return list;
    }
}
