package cn.edu.guet.mapper;

import cn.edu.guet.bean.Permission;

import java.util.List;

public interface PermissionMapper {
    List<Permission> permissionList();
    String getPermissionid(String pidname);
    int addpermission(Permission permission);
    int updatepermission(Permission permission);
    int deletepermission(String permissionname);
}
