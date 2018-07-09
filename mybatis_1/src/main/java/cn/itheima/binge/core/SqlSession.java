package cn.itheima.binge.core;
//核心接口----类似于service层与dao层的交互，利用接口交互
public interface SqlSession {


    //动态获取某个实现类的方法
    public <T> T getDAOImpl(Class clz)throws Exception;
}
