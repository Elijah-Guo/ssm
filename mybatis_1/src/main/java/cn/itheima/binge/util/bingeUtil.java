package cn.itheima.binge.util;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

        //转数据,转为list集合
public class bingeUtil {
    public static <T> List<T> getListByResultSet(ResultSet set,String className){
        ArrayList<T> list = new ArrayList<T>();
        //思路---根据数据库列名，根据类获取Set方法，根据列名找到对应的Set方法，一个个set添加到对象，装入list集合返回
        try {
        //1：获取数据库列名-----元数据
            ResultSetMetaData md = set.getMetaData();
        //2:创建一个cnames集合装所有的列名
            ArrayList<String> cnames = new ArrayList<String>();
        //3:获取元数据中，列名的个数(为循环做准备)
            int count = md.getColumnCount();
        //4:将列名循环添加至---cnames列名集合中
          // 数据库的循环都是从1开始
            for (int i = 1; i <=count; i++) {
                //           获取第i列的列名(注意方法不要写错)
                cnames.add(md.getColumnName(i));
            }
        //5:通过类名调用set方法，首先获取类(加载)
            Class clz = Class.forName(className);
            //获取set方法不可能-->获取所有的方法(包括get,set,构造)
            Method[] methods = clz.getMethods();
        //6:遍历ResultSet---
            //T代表支持接收任何对象的类型
            T object=null;//object代表任何对象
            while (set.next()){
                object=(T)clz.newInstance();   //利用反射获得
                //两层循环
                //循环列名
                for (String cname : cnames) {
                    //循环类中的所有方法
                    for (Method method : methods) {
                        //判断,忽略大小写,如果列名的名字等同于方法中的set+列名字,说明找到了对应列名的set方法

                        if (method.getName().equalsIgnoreCase("set"+cname)){//注意这里的方法
                            //找到了，执行方法
                            //Object invoke(Object obj, Object... args)
                            method.invoke(object,set.getObject(cname));
                            //到这一步，就说明完成了，将结果集中的数据，利用set方法循环添加到了一个对象中
                        }
                    }
                }
                //至此，已经完成了一个对象set方法的设置内容，现在要添加到集合中去
                list.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
