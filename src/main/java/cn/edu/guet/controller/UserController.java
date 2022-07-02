package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IRoleService;
import cn.edu.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userServiceImpl;
    @Autowired
    private IRoleService roleServiceImpl;

    @RequestMapping("/userList")
    public List<User> userList() {
        System.out.println("获取所有的用户");
        return userServiceImpl.getUserList();
    }

    @RequestMapping("/Adduser")
    public boolean adduser(String username, String password, String nickname, String rolename, String email, String mobile) {
        User user = new User();
        user.setUsername(username);
        user.setNickName(nickname);
        user.setRolename(rolename);
        user.setEmail(email);
        user.setMobile(mobile);
        System.out.println("添加用户成功:");
        return userServiceImpl.adduser(user, password);
    }

    @RequestMapping("/deleteuser")
    public boolean deleteuser(String userid) {
        System.out.println("删除用户的角色成功" + userid);
        System.out.println("删除用户成功" + userid);
        return userServiceImpl.deleteuser(userid);
    }

    @RequestMapping("/updateuser")
    public boolean updateuser(String userid, String username, String nickname, String rolename, String email, String mobile) {
        User user = new User();
        user.setId(userid);
        user.setUsername(username);
        user.setNickName(nickname);
        user.setRolename(rolename);
        user.setEmail(email);
        user.setMobile(mobile);
        System.out.println("修改用户成功" + username);
        return userServiceImpl.updateuser(user);
    }
}
