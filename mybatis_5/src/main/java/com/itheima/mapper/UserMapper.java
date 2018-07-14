package com.itheima.mapper;

import com.itheima.entity.UserInfo;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    //增删改,按ID查,分页,模糊

    /**
     * 添加方法
     * @return
     * @throws RuntimeException
     */
    @Insert("insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    @SelectKey(statement = "select last_insert_id()",keyColumn = "ID",keyProperty = "id",before = false,resultType = int.class)
    public int insertUser(UserInfo userInfo)throws RuntimeException;

    /**
     * 更新方法
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    public int updateUser(UserInfo userInfo)throws RuntimeException;

    /**
     * 删除方法
     * @param userInfo
     * @return
     * @throws RuntimeException
     */
    @Delete("delete from user where id=#{id}")
    public int deleteUser(UserInfo userInfo)throws RuntimeException;

    /**
     * 通过ID查询
     * @return
     * @throws RuntimeException
     */
    @Select("select * from user where id=#{id}")
    public UserInfo findUserByID(Integer id)throws RuntimeException;

    /**
     * 模糊查找---动态查询方法,如果查不到查询全部
     * @return
     * @throws RuntimeException
     */
    @Select("<script>" +
            "select * from user" +
            "<where>" +
            "<if test=\"null != username\">" +
            "and username like #{username}" +
            "</if>" +
            "</where></script>")
    public List<UserInfo> findUsersByLikename(@Param("username") String username)throws RuntimeException;

    /**
     * 分页查找
     * @param a
     * @param b
     * @return
     * @throws RuntimeException
     */
    @Select("select * from user limit #{start},#{end}")
    public List<UserInfo> findUserByPage(@Param("start") Integer a,@Param("end") Integer b)throws RuntimeException;

    /**
     * 查询总条数
     * @return
     * @throws RuntimeException
     */
    @Select("select count(id) from user")
    public int findUserByPageCount()throws RuntimeException;

    @Select("select * from user where id=#{id}")
    public UserInfo findUserByID1(Integer id)throws RuntimeException;


    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true,column = "ID",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "address",property = "address"),
            @Result(column = "ID",property = "accounts",javaType = List.class,
                    many = @Many(select = "com.itheima.mapper.AccountMapper.findAccountByIDforUser",fetchType = FetchType.LAZY)
            )
    })
    public UserInfo findUserByIDChaXunAccount(Integer id)throws RuntimeException;
}
