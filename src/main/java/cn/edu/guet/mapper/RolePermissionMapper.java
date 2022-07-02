package cn.edu.guet.mapper;

import cn.edu.guet.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
    void deleteRolePermission(String roleId);
    void addrolePermission(@Param("roleid") String roleid, @Param("permissionid") String permissionid);
    List<Role> getRolePermissionList();
}
