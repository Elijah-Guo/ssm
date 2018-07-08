package com.itheima.controller;


import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
@Secured({"ROLE_ADMIN"})
public class PermissionController {


    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/save")
    public String save(Permission permission){

        permissionService.save(permission);

        return "redirect:/permission/findAll";
    }

    /**
     * 根据pid查询父菜单们----父菜单的回显
     * 不需要传入pid，直接查所有的pid为一级菜单(pid为0的),写死了
     * @return
     */
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(@RequestParam(value ="pid" ,
            defaultValue = "0") Integer pid){

        ModelAndView mv = new ModelAndView();

        List<Permission> permissions=permissionService.findByPid(pid);
        mv.addObject("permissions",permissions);

        mv.setViewName("permission-add");

        return mv;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<Permission> permissionList=permissionService.findAll();

        mv.addObject("permissionList",permissionList);

        mv.setViewName("permission-list");

        return mv;
    }
}
