package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
@Secured({"ROLE_ADMIN"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 真正的权限添加--持久化到数据库
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(Long roleId,Long[] ids){

        roleService.addPermissionToRole(roleId,ids);

        return "redirect:/role/findAll";
    }

    /**
     * 添加权限到角色表(前台页面回显操作)
     * @return
     */
    @RequestMapping("/addPermissionToRoleUI")
    public ModelAndView addPermissionToRoleUI(Long id){
        ModelAndView mv = new ModelAndView();
        //获取所有的权限信息(查找不包含一级菜单的方法)----添加权限页面信息展示
        List<Permission> permissionList = permissionService.findAllNotParent();
        //获取当前角色的所有权限信息-----添加权限页面勾选框勾选
        Role role=roleService.findById(id);
        List<Permission> rolePermissionList = role.getPermissionList();
        StringBuffer stringBuffer = new StringBuffer();
        for (Permission permission : rolePermissionList) {
            stringBuffer.append(permission.getId());
            stringBuffer.append(",");
        }
        //获取当前角色的id'
        Long roleId = role.getId();
        //以上操作都是为了给前台页面准备数据,将数据传给前台
        mv.addObject("permissionList",permissionList);
        mv.addObject("rolePermissionListStr",stringBuffer.toString());
        mv.addObject("roleId",roleId);

        mv.setViewName("role-permission-add");
        return mv;
    }


    @RequestMapping("/save")
    public String save(Role role){

        roleService.save(role);

        return "redirect:/role/findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<Role> roleList=roleService.findAll();

        mv.addObject("roleList",roleList);

        mv.setViewName("role-list");
        return mv;
    }

}
