package com.itheima.controller;


import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.RoleService;
import com.itheima.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/user")
@Secured({"ROLE_ADMIN"})
public class UserController {

    @Autowired
    private userService userService;

    @Autowired
    private RoleService roleService;


    /**
     * 真正的添加角色方法
     * @param userId
     * @return
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Long userId,Long[] ids){

        userService.addRoleToUser(userId,ids);

        return "redirect:/user/findAll";
    }

    /**
     * 为用户添加角色回显并选择框选中
     * @return
     */
    @RequestMapping("/addRoleToUserUI")
    public ModelAndView addRoleToUserUI(Long id){
        ModelAndView mv = new ModelAndView();
        //获取数据库要展示的所有角色
        List<Role> roleList = roleService.findAll();
        //获取当前用户的所有角色，为了便于前台页面的勾选框勾选操作
        SysUser user = userService.findById(id);
        List<Role> userRoleList = user.getRoleList();
        StringBuffer userRoleListStr = new StringBuffer();
        for (Role role : userRoleList) {
            userRoleListStr.append(role.getId());
            userRoleListStr.append(",");
            //拼接之后  1,2,3,
        }
        //获取用户id，传入前台页面，便于真正的添加方法执行时的操作
        Long userId = user.getId();
        //将所有信息传输至前台页面
        mv.addObject("roleList",roleList);
        mv.addObject("userRoleListStr",userRoleListStr.toString());
        mv.addObject("userId",userId);

        mv.setViewName("user-role-add");

        return mv;
    }


    //详情页面
    // 传入uid，查询所拥有的角色，角色所拥有的权限
    @RequestMapping("/findById")
    public ModelAndView findById(Long id){
        ModelAndView mv = new ModelAndView();

        SysUser user=userService.findById(id);

        mv.addObject("user",user);

        mv.setViewName("user-show");
        return mv;
    }



    @RequestMapping("/save")
    public String save(SysUser sysUser){

        userService.save(sysUser);

        return "redirect:/user/findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();

        List<SysUser> userList=userService.finfAll();

        mv.addObject("userList",userList);

        mv.setViewName("user-list");

        return mv;
    }
}
