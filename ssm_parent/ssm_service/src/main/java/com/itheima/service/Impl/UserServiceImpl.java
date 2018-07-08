package com.itheima.service.Impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements userService {

    @Autowired
    private UserDao userDao;

    //注入security的加密类
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //需要一个UserDetails,但是他是接口,只能创建他的实现类对象User
        //User()，需要3个参数 1:用户名  2:用户密码  3:需要一个权限的集合,因为不只一个权限

        //根据用户名，去数据库查询用户的密码
        SysUser sysUser=userDao.findUserByUserName(username);



        //用户名的非空判断，不判断有可能会空指针异常
        if(sysUser!=null){

            //创建一个权限集合
            //往集合中添加权限的时候需要先new SimpleGrantedAuthority
            List<GrantedAuthority> authorityList=new ArrayList<>();
            List<Role> roleList = sysUser.getRoleList();
            for (Role role : roleList) {
                authorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }

            User user = new User(username,sysUser.getPassword(),authorityList);

            return user;
        }

        return null;
    }

    @Override
    public List<SysUser> finfAll() {
        return userDao.findAll();
    }

    /**
     * 添加方法
     * @param sysUser
     */
    @Override
    public void save(SysUser sysUser) {

        //调用加密方法encode对用户密码加密
        String encode = passwordEncoder.encode(sysUser.getPassword());
        //将加密后的密码放回
        sysUser.setPassword(encode);

        userDao.save(sysUser);
    }

    @Override
    public SysUser findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(Long userId, Long[] ids) {
        //添加角色之前，先删除之前的当前用户拥有的角色信息(因为如果之前的用户已经有角色信息，
        // 再添加，属于重复添加)

        //根据id删除当前用户拥有的角色信息
        userDao.deleteUserRoleRelation(userId);
        //添加当前用户的角色信息
        if (ids!=null&&ids.length>0){
            for (Long id : ids) {
                userDao.saveUserRoleRelation(userId,id);
            }
        }
    }
}
