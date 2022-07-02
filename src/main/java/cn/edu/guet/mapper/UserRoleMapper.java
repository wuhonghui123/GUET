package cn.edu.guet.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int deleteUserRole(String roleId);
    void deleteUserRole1(@Param("userid") String userId);
    void adduserrole(@Param("id") String userid, @Param("roleid") String roleid);
    void updateuserrole(@Param("id") String userid, @Param("roleid") String roleid);
}
