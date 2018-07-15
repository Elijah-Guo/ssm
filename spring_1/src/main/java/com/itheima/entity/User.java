package com.itheima.entity;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private String[] sarrys;
    private List<String> slists;
    private Set<String> ssets;
    private Map<String,String> smaps;
    private Properties properties;
}
