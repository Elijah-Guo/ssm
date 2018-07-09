package cn.itheima.binge.factory;


import java.io.InputStream;

//利用到了构建者模式
public class SqlsessionFactoryBulider {

    //对配置文件的读取方式扩展，支持多种方式（默认方式，自定义命名方式,不同位置不同命的xml）


    //默认方式
    public SqlSessionFactory buider(){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        InputStream config = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory.setConfig(config);
        return sqlSessionFactory;
    }
    
    //读取自定义命名的xml
    public SqlSessionFactory buider(String filename){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        InputStream config = this.getClass().getClassLoader().getResourceAsStream(filename);
        sqlSessionFactory.setConfig(config);
        return sqlSessionFactory;
    }
    
    //读取不同位置不同名的xml
    public SqlSessionFactory buider(InputStream config){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        sqlSessionFactory.setConfig(config);
        return sqlSessionFactory;
    }
    

}
