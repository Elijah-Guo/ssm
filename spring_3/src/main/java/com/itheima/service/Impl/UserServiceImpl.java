package com.itheima.service.Impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    public void findUsers() {
        System.out.println("查询所有用户");
    }
}
