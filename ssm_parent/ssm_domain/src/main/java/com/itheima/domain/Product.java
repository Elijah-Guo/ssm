package com.itheima.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itheima.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable{

    private Long id;
    private String productNum;
    private String productName;
    private String cityName;
    private Date departureTime;
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;



    public String getDepartureTime() {
        if (departureTime==null){
            return null;
        }
        return DateUtils.DatetoString(departureTime,"yyyy-MM-dd HH:mm");
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
}
