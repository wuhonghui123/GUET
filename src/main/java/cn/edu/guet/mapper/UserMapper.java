package cn.edu.guet.mapper;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User login(@Param("username") String username, @Param("password") String password);
    List<Permission> getMenuByUserId(String userId);
    List<User> getUserList();
    int adduser(User user);
    int deleteuser(@Param("userid") String userid);
    int updateuser(User user);
}
