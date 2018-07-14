package com.itheima.test;

import com.itheima.Utils.MybatisUtil;
import com.itheima.entity.QueryVO;
import com.itheima.entity.UserInfo;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    /*Date时间转换为String*/
    public Date getDateByString(String date){
        Date result=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        result = null;
        try {
            result = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    //多条件查询----全部实现条件查询
    @Test
    public void t1(){
        QueryVO vo = new QueryVO();
        vo.setSex("男");
        //vo.setLikename("王%");
        vo.setStrattime(getDateByString("1990-02-02"));
        vo.setEndtime(new Date());

        Map<String, Integer> map = new HashMap<String, Integer>();
        int pageIndex=2;
        int pageSize=2;
        map.put("start",(pageIndex-1)*pageSize);
        map.put("end",pageSize);

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserInfo> list = mapper.findUsersByParams(vo);
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
        }
        /*if(list!=null){
            List<UserInfo> list1 = mapper.findUserPage(map);
            for (UserInfo userInfo : list1) {
                System.out.println(userInfo.toString());
            }
        }*/
        sqlSession.close();
    }
}
