package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.User;
import cn.edu.guet.mapper.RoleMapper;
import cn.edu.guet.mapper.UserMapper;
import cn.edu.guet.mapper.UserRoleMapper;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;
    private RoleMapper roleMapper;
    private UserRoleMapper userRoleMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public void setRoleMapper(RoleMapper roleMapper){this.roleMapper = roleMapper;}
    @Autowired
    public void setUserRoleMapper(UserRoleMapper userRoleMapper){this.userRoleMapper = userRoleMapper;}

    @Override
    public User login(String username, String password) {
        System.out.println(userMapper);
        User user = userMapper.login(username, password);
        // UserMapper到底是什么？UserMapper是一个动态代理对象，而且是JDK的动态代理
        // 动态代理：JDK动态代理、CGLIB动态代理
        // MyBatis根据UserMapper接口，帮我们创建的一个对象，该对象和UserDaoImpl
        if (user != null) { //说明用户名是对的
            String encPass = user.getPassword();
            String salt = user.getSalt();
            PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
            boolean result = encoderMd5.matches(encPass, password);
            // result如果是真，说明密码也正确
            if (result) {
                // 密码验证完成后，清空password和salt，不要返回到浏览器
                user.setPassword("");
                user.setSalt("");
                return user;
            }
        }
        return null;
    }

    @Override
    public List<Permission> getMenuByUserId(String userId) {
        return userMapper.getMenuByUserId(userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public boolean adduser(User user,String password) {
        String salt = PasswordEncoder.encryptToMD5(user.getUsername());//获取盐
        PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
        String pwd_md5 = encoderMd5.encode(password);//获取加密后的密码
        Date date = new Date();//获取当前系统时间
        Timestamp create_time = new Timestamp(date.getTime());
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setPassword(pwd_md5);
        user.setSalt(salt);
        user.setCreatetime(String.valueOf(create_time));
        String roleid = roleMapper.getroleid(user.getRolename());
        int a = userMapper.adduser(user);
        userRoleMapper.adduserrole(user.getId(),roleid);
        return a!=0;
    }

    @Override
    public boolean deleteuser(String userid) {
        userRoleMapper.deleteUserRole1(userid);
        int a = userMapper.deleteuser(userid);
        return a!=0;
    }

    @Override
    public boolean updateuser(User user) {
        String roleid = roleMapper.getroleid(user.getRolename());
        userRoleMapper.updateuserrole(user.getId(),roleid);
        int a = userMapper.updateuser(user);
        return a!=0;
    }
}