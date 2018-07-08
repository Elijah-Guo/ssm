package com.itheima.dao;

import com.itheima.domain.Order;
import lombok.Lombok;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderDao {

    /*订单和产品是一对一的关系，直接在注解上映射，利用productId可以一对一查询出对应的产品表的所有信息
    * 这里还能调用方法findProductById的全包名，完成查询之后的映射关系
    * 说明不仅可以调用sql语句映射，还能调用已经完成的方法完成映射
    * fetchType代表是否要延迟加载,Lazy代表延迟加载,EAGER代表不延迟
    * */
    @Select("select * from orders")
    @Results({
            @Result(
                    property = "product",
                    column = "productId",
                    one=@One(select = "com.itheima.dao.ProductDao.findProductById",fetchType = FetchType.EAGER)
            )
    })
    List<Order> findAll();

    @Insert("insert into orders (orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) values (#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    void save(Order order);


    @Delete("delete from orders where id=#{id}")
    void delete(Long id);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    Order findOrderByID(Long id);
}
