package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {


    @Select("select * from product")
    List<Product> findAll();

    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id=#{id}")
    Product findProductById(Long id);

    @Update("update product set productNum = #{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void updateProduct(Product product);

    @Delete("delete from product where id=#{id}")
    void delete(Long id);

    @Select("select count(id) from product")
    Long findByPageCount();

    /*当输入参数只有一个且没有使用@Param注解时，MyBatis会直接传递这个参数；当输入参数多于一个，
    或者使用了@Param注解时，MyBatis会将参数封装在Map中传递，这时的Map的key分为以下几种可能：

    1:---------Map中会有param1, param2这样的key，其顺序对应输入参数的顺序。无论是否有@Param注解。
    2:---------对于@Param注解的参数，Map中会保存注解中给定的名字作为key
    3:----------对于没有用@Param注解的参数，Map中会用1、2、3 ..这样的数字作为key，按顺序保存输入参数。*/
    @Select("select * from product limit #{param1},#{param2}")
    List<Product> findByPage(Integer start, Integer pageSize);
}
