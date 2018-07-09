package cn.itheima.binge.factory;

import cn.itheima.binge.core.SqlSession;
import cn.itheima.binge.core.impl.SqlSessionImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.List;

    //利用到了工厂模式:
public class SqlSessionFactory {

    //第一件事---帮助sqlsession创建实现类---能够避免多次创建对象
    //第二件事---帮助我们读取xml数据完成最后的封装


    //利用字节输入流读取配置文件
    private InputStream config;

        public void setConfig(InputStream config) {
            this.config = config;
        }

        //定义一个方法实现上述功能
    public SqlSession openSession(){
        //1:工厂模式创建SqlSessionImpl的实现类对象
        SqlSessionImpl sqlSession = new SqlSessionImpl();
        //同时调用readXMLConfig方法，调用读取xml文件的方法
        sqlSession = readXMLConfig(sqlSession);
        return sqlSession;
    }

    //定义为私有
   private SqlSessionImpl readXMLConfig(SqlSessionImpl sqlSession){
       //2:读取xml中的数据---数据库连接的四个重要指标还未赋值，通过读取xml配置文件赋值
       //利用dom4j解析纯xml
       try {
           //读取配置文件
           Document document = new SAXReader().read(config);
           //读取根目录
           Element root = document.getRootElement();
           //因为标签层级太多，利用selectNodes方法直接读取指定的标签
           //得到所有的property标签的内容，返回一个集合
           List<Element> list = root.selectNodes("//property");
           //遍历集合
           for (Element element : list) {
               //获取每个元素的name,value
               String name = element.attributeValue("name");
               String value = element.attributeValue("value");
               //判断name是哪个的?
               switch (name){
                   case "driver":
                       sqlSession.setDriver(value);
                   case "url":
                       sqlSession.setUrl(value);
                   case "username":
                       sqlSession.setUsername(value);
                   case "password":
                       sqlSession.setPassword(value);
                       break;
               }
           }
       } catch (DocumentException e) {
           e.printStackTrace();
       }
       return sqlSession;
   }
}
