package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
         productDao.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productDao.findProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            productDao.delete(id);
        }

    }

    @Override
    public PageBean<Product> findByPage(Integer pageNum, Integer pageSize) {
        //pageBean封装数据
        PageBean<Product> pb = new PageBean<>();
        //封装当前页pageNum
        pb.setPageNum(pageNum);
        //封装页容量
        pb.setPageSize(pageSize);
        //封装总条数
        Long totalCount=productDao.findByPageCount();
        pb.setTotalCount(totalCount);
        //封装总页数(向上取整，强转类型)
        int totalPage= (int) Math.ceil(1.0*totalCount/pageSize);
        pb.setTotalPage(totalPage);
        //封装当前页展示的数据
        Integer start=(pageNum-1)*pageSize;
        List<Product> productList = productDao.findByPage(start, pageSize);
        pb.setPageList(productList);

        return pb;
    }

    /**
     * 分页助手分页
     * @return
     */
    @Override
    public PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize) {

        //设置分页参数
        PageHelper.startPage(pageNum,pageSize);

        //调用查询方法（全部查询）
        List<Product> all = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(all);

        //返回分页需要的所有数据
        return pageInfo;
    }


}
