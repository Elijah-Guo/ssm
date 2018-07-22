package com.itheima.entity;

import java.io.Serializable;

/**
 * 实现序列化：服务于 数据层框架(mybatis...)的二级缓存,使每个sqlsession都能共享到数据
 */
public class Account implements Serializable {

    private Integer id;
    private String username;
    private Double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
