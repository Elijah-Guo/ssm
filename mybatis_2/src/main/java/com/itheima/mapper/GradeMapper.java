package com.itheima.mapper;

import com.itheima.entity.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface GradeMapper {

    @Insert("insert into grade (gname,gdesc) values (#{gname},#{gdesc})")
    @SelectKey(keyProperty = "gid",keyColumn = "gid",before = false,statement = "select last_insert_id()",resultType = int.class)
    public int insertGrade(Grade g)throws RuntimeException;

    @Update("update grade set gname=#{gname},gdesc=#{gdesc} where gid=#{gid}")
    public int updateGrade(Grade g)throws RuntimeException;

    @Delete("delete from grade where gid = #{gid}")
    public int deleteGrade(Grade g)throws RuntimeException;

    @Select("select * from grade where gid = #{id}")
    public Grade findGradeByID(Integer id)throws RuntimeException;

    @Select("select * from grade limit #{start},#{end}")
    public List<Grade> findGradeListByPage(Map<String,Integer> map)throws RuntimeException;

    @Select("select count(gid) from grade")
    public int findGradeListByPageCount()throws RuntimeException;


}
