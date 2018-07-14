package com.itheima.entity;

public class Account {

    private Integer id;
    private Double money;

    //重点来了---把实体类当做一个属性包装,这个属性不需要重写toString方法
    private UserInfo userInfo;

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
