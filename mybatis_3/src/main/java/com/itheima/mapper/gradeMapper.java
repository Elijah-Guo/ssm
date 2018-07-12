package com.itheima.mapper;

import com.itheima.entity.Grade;
import com.itheima.entity.QueryVO2;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface gradeMapper {

    @Insert("insert into grade (gname,gdesc) values(#{gname},#{gdesc})")
    @SelectKey(keyProperty = "gid",keyColumn = "gid",before = false,statement ="select last_insert_id()",resultType = int.class)
    public int insertGrade(Grade grade)throws RuntimeException;

    @Update("update grade set gname=#{gname},gdesc=#{gdesc} where gid=#{gid}")
    public int updateGrade(Grade grade)throws RuntimeException;

    @Delete("delete from grade where gid=#{gid}")
    public int deleteGrade(Grade grade)throws RuntimeException;

    @Select("select * from grade")
    public List<Grade> findAllGrades()throws RuntimeException;

    @Select("select * from grade where gid=#{gid}")
    public Grade findGradesByID(Integer integer) throws RuntimeException;

    @Select("select * from grade limit #{start},#{end}")
    public List<Grade> findGradesByPage(Map<String,Integer> map)throws RuntimeException;

    /**
     * 查询总条数,一般根据主键查询,速度最快了
     * @return
     * @throws RuntimeException
     */
    @Select("select count(gid) from grade")
    public int findGradeBypageCount()throws RuntimeException;

    @Select("select * from grade where gname like #{gname}")
    public List<Grade> findGradesByLikeName(String name)throws RuntimeException;

    /**
     * 多条件查找,不是动态查询(只需要满足条件之一就可以查到)，必须要满足全部条件才能查到
     * @param queryVO2
     * @return
     * @throws RuntimeException
     */
    @Select("select * from grade where gname like #{gname} and gid between #{startgid} and #{endgid}")
    public List<Grade> findUsersByParams(QueryVO2 queryVO2)throws RuntimeException;
}
