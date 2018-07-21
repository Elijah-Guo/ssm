package com.itheima.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

}
