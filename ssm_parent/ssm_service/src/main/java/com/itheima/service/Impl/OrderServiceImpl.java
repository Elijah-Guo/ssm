package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    /**
     * 分页助手分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Order> findByPageHelper(Integer pageNum, Integer pageSize) {
        //设定分页参数
        PageHelper.startPage(pageNum,pageSize);

        //调用查询全部方法
        List<Order> all = orderDao.findAll();
        PageInfo<Order> pageInfo = new PageInfo<>(all);
        //获得分页参数返回,返回的是一个PageInfo
        return pageInfo;
    }

    /**
     * 删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {

        for (Long id : ids) {
            orderDao.delete(id);
        }
    }

    @Override
    public Order findOrderByID(Long id) {
        return orderDao.findOrderByID(id);
    }
}
