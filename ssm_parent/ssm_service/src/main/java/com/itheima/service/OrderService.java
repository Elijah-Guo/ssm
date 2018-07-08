package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void save(Order order);

    PageInfo<Order> findByPageHelper(Integer pageNum, Integer pageSize);

    void delete(Long[] ids);

    Order findOrderByID(Long id);
}
