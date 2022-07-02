package cn.edu.guet.mapper;

import cn.edu.guet.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteRoleById(String roleId);
    String getroleid(String rolename);
    List<Role> getRoleList();
    int addrole(@Param("rolename") String rolename,@Param("roleid") String roleid);
    int updaterole(@Param("rolename") String rolename,@Param("roleid") String roleid);
}
