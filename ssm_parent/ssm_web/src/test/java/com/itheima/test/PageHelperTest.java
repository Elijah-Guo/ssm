package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PageHelperTest {

    /*分页插件使用步骤：
      1：导入jar包
      2: 添加配置文件
      3: 分页助手的api使用
         a:设置分页参数
         b:调用查询方法(查全部)
         c:获得分页相关数据*/

    @Autowired
    private ProductService productService;

    @Test
    public void testPageHelper(){
        //设置分页参数
        PageHelper.startPage(2,5);

        //调用查询方法
        List<Product> list = productService.findAll();
        for (Product product : list) {
            System.out.println(product.getId());
        }
        //获得分页相关数据
        PageInfo<Product> productPageInfo = new PageInfo<>(list);
        System.out.println("总条数"+productPageInfo.getTotal());
        System.out.println("总页数"+productPageInfo.getPages());
        System.out.println("当前页"+productPageInfo.getPageNum());
        System.out.println("当前页显示条数"+productPageInfo.getPageSize());
        System.out.println("是否是首页:"+productPageInfo.isIsFirstPage());
        System.out.println("是否是尾页:"+productPageInfo.isIsLastPage());
        System.out.println("上一页是:"+productPageInfo.getPrePage());

    }
}
