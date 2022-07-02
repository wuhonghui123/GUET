package cn.edu.guet.controller;

import cn.edu.guet.bean.Role;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private IRoleService roleServiceImpl;
    @RequestMapping("/roleList")
    public List<Role> roleList(){
        System.out.println("获取角色列表");
        return roleServiceImpl.getRoleList();
    }

    @RequestMapping("/rolePermissionList")
    public List<Role> rolePermissionList(){
        return roleServiceImpl.getRolePermissionList();
    }

    @RequestMapping("/updaterole")
    public boolean updaterole(String roleid,String rolename,String roleinfor){
        System.out.println("更新角色信息");
        return roleServiceImpl.upaterole(roleid,rolename,roleinfor);
    }

    @RequestMapping("/addrole")
    public boolean addrole(String rolename,String roleinfor){
        System.out.println("添加角色");
        return roleServiceImpl.addrole(rolename,roleinfor);
    }

    @RequestMapping("/deleterole")
    public boolean deleterole(String roleid){
        System.out.println("删除角色");
        return roleServiceImpl.deleteRoleById(roleid);
    }
}
