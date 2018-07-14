package com.itheima.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MybatisUtil {

    // 创建对象
    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    static {
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            System.out.println("没有获取到配置文件");
            e.printStackTrace();
        }
    }

    /**
     * 获取
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭
     * @param sqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession){
        sqlSession.close();
    }
}
