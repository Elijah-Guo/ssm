package com.itheima.test;

import com.itheima.entity.Grade;
import com.itheima.entity.QueryVO2;
import com.itheima.mapper.gradeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class test3 {

    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory factory;

    static {
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream config = null;
        try {
            config = Resources.getResourceAsStream("SqlMapConfig.xml");
            factory = sqlSessionFactoryBuilder.build(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*查询*/
    public void t1() {

        SqlSession sqlSession = factory.openSession();
        try {
            gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
            List<Grade> list = mapper.findAllGrades();
            for (Grade grade : list) {
                System.out.println(grade.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /*增加*/
    @Test
    public void t2() {
        //SqlSession sqlSession = factory.openSession(true);//设置为自动提交 十条一下的数据自动提交
        SqlSession sqlSession = factory.openSession(false);
        Grade grade = new Grade();
        grade.setGname("斌哥");
        grade.setGdesc("董事长");
        gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
        try {
            int i = mapper.insertGrade(grade);
            sqlSession.commit();
            if (i > 0) {
                System.out.println("添加成功,id:" + grade.getGid());
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();//记住关闭
        }
    }

    /*修改*/
    @Test
    public void t3(){
        SqlSession sqlSession = factory.openSession(true);
        gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
        //找到id为3的对象
        Grade grade = mapper.findGradesByID(3);
        if (grade!=null){
            //更新
            grade.setGname("诸葛亮");
            grade.setGdesc("宇宙无敌");
            int i = mapper.updateGrade(grade);
            String s = i > 0 ? "更新成功" : "更新失败";
            System.out.println(s);
        }
        sqlSession.close();
    }


    public void t4(){
        SqlSession sqlSession = factory.openSession(true);
        gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
        Grade grade = mapper.findGradesByID(12);
        if (grade!=null){
            int i = mapper.deleteGrade(grade);
            String s = i > 0 ? "删除成功" : "删除失败";
            System.out.println(s);
        }
        sqlSession.close();
    }

    /*模糊查找*/

    public void t5(){
        SqlSession sqlSession = factory.openSession();
        gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
        List<Grade> list = mapper.findGradesByLikeName("%老%");
        for (Grade grade : list) {
            System.out.println(grade.toString());
        }
        sqlSession.close();
    }

    /*分页*/
    @Test
    public void t6(){
        SqlSession sqlSession = factory.openSession();
        gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
        int totalcount = mapper.findGradeBypageCount();
        System.out.println("总条数:"+totalcount);
        /*总页数*/
        int pageIndex=1;
        int pageSize=3;
        int totalPage=totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1;
        System.out.println("总页数:"+totalPage);

        /*分页*/
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("start",(pageIndex-1)*pageSize);
        map.put("end",pageSize);
        List<Grade> list = mapper.findGradesByPage(map);
        for (Grade grade : list) {
            /*分页后每页展示的数据*/
            System.out.println(grade.toString());
        }
        sqlSession.close();
    }

    /*多条件查询*/
    @Test
    public void t7(){
        QueryVO2 queryVO2 = new QueryVO2();
        queryVO2.setGname("%小%");
        queryVO2.setStartgid(1);
        queryVO2.setEndgid(6);
        SqlSession sqlSession = factory.openSession();
        gradeMapper mapper = sqlSession.getMapper(gradeMapper.class);
        List<Grade> list = mapper.findUsersByParams(queryVO2);
        for (Grade grade : list) {
            System.out.println(grade.toString());
        }
        sqlSession.close();
    }
}
