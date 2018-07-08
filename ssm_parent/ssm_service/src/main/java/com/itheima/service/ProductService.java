package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findProductById(Long id);

    void updateProduct(Product product);

    void delete(Long[] dis);

    PageBean<Product> findByPage(Integer pageNum, Integer pageSize);

    PageInfo<Product> findByPageHelper(Integer pageNum,Integer pageSize);
}
