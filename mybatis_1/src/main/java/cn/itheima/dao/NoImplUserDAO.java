package cn.itheima.dao;

import cn.itheima.binge.ann.Select;
import cn.itheima.entity.UserInfo;

import java.util.List;

    //查询多个表，避免一个表查询，一个Impl
    //只需要一个接口，什么都不需要，就能够完成查询数据库的操作---框架
public interface NoImplUserDAO {

    @Select(value="select * from user")
    public List<UserInfo> findAllUsers()throws Exception;

}
