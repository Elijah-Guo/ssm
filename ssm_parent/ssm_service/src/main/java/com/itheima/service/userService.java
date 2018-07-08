package com.itheima.service;

import com.itheima.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface userService extends UserDetailsService{

    List<SysUser> finfAll();

    void save(SysUser sysUser);

    SysUser findById(Long id);

    void addRoleToUser(Long userId, Long[] ids);
}
