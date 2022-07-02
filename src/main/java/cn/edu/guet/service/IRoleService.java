package cn.edu.guet.service;

import cn.edu.guet.bean.Role;

import java.util.List;

public interface IRoleService {
    boolean deleteRoleById(String roleId);
    List<Role> getRoleList();
    boolean addrole(String rolename,String roleinfor);
    List<Role> getRolePermissionList();
    boolean upaterole(String roleid,String rolename,String roleinfor);
}
